package transportecolectivo.practica09.Repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import transportecolectivo.practica09.Conexion.ConexionBD;
import transportecolectivo.practica09.Modelo.Mascota;

/**
 * Clase que permite las operaciones CRUD de la tabla operador de la base de
 * datos
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class MascotaRepositorio {
    private ConexionBD conexion = new ConexionBD();
    // Objeto para ejecutar queries
    private Statement stmt;
    // Objeto para prepara un querie para su ejecucion
    private PreparedStatement ps;

    /**
     * Metodo que se conecta a la base de datos y obtiene todas las entradas
     * de los operadores
     * 
     * @return List<Mascota> Una lista de Mascotas
     * @throws SQLException -- Excepcion que sale si no se logra a hacer
     *                      la query de la consulta o la conexion
     */
    public List<Mascota> getMascotas() throws SQLException {
        String query = "SELECT * FROM mascota"; // Escribimos nuestra query
        List<Mascota> mascotaLista = new ArrayList<Mascota>();
        try {
            // Nos conectamos a la base de datos
            conexion.conectar();
            // Preparamos la base de datos
            stmt = conexion.prepararDeclaracion();
            // Ejecuto mi query y me regresa un iterador
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Mascota ma = new Mascota(
                        rs.getInt("idMascota"),
                        rs.getString("curp"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getString("raza"),
                        rs.getString("nombreDuenio"),
                        rs.getInt("edad"),
                        rs.getInt("peso"));
                // Agrego el resultado
                mascotaLista.add(ma);
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            try {
                conexion.cerrar();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return mascotaLista;
    }

    /**
     * Metodo que obtiene a una mascota dentro de la base a partir de su idMascota
     * 
     * @param idMascota -- La id de la mascota a buscar
     * @return Mascota -- La mascota en caso de encontrarse null, en otro caso
     * @throws SQLException --Excepcion que sale si no se logra a hacer
     *                      la query de la consulta o la conexion
     */
    public Mascota getMascota(int idMascota) throws SQLException {
        String query = "SELECT * FROM mascota WHERE idMascota = ?";
        Mascota ma = null;
        try {
            // Conectamos a la Base
            conexion.conectar();
            // Preparamos la Base para la consulta
            ps = conexion.prepararDeclaracionPreparada(query);
            // Modificamos la consulta, para ver que sustituira
            ps.setInt(1, idMascota);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ma = new Mascota(
                        rs.getInt("idMascota"),
                        rs.getString("curp"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getString("raza"),
                        rs.getString("nombreDuenio"),
                        rs.getInt("edad"),
                        rs.getInt("peso"));
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            try {
                conexion.cerrar();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return ma;
    }

    /**
     * Metodo que inserta una mascota dentro de la base de datos
     * 
     * @param mascota -- La mascota que deseamos insertar en la base de datos
     */
    public void insertarMascota(Mascota mascota) {
        String query = "INSERT INTO mascota "
                + "(idMascota, curp, nombre, especie, raza, nombreDuenio, edad, peso)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        try {
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setInt(1, mascota.getIdMascota());
            ps.setString(2, mascota.getCurp());
            ps.setString(3, mascota.getNombre());
            ps.setString(4, mascota.getEspecie());
            ps.setString(5, mascota.getRaza());
            ps.setString(6, mascota.getNombreDuenio());
            ps.setInt(7, mascota.getEdad());
            ps.setInt(8, mascota.getPeso());
            ps.executeUpdate(); // Utilizamos esta instruccion para insertar y actualizar
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            try {
                conexion.cerrar();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
    }

    /**
     * Metodo que actualiza una mascota dentro de la base de datos
     * 
     * @param idMascota     -- El id de la mascota a buscar para actualizar
     * @param mascota -- La mascota que vamos a intercambiar sus valores
     */
    public void actualizarMascota(int idMascota, Mascota mascota) {
        String query = "UPDATE mascota SET idMascota = ?, curp = ?, "
                + "nombre = ?, especie = ?, "
                + "raza=?, nombreDuenio =?, edad=?, peso= ? WHERE idMascota = ?";
        try {
            conexion.conectar();
            ;
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setInt(1, mascota.getIdMascota());
            ps.setString(2, mascota.getCurp());
            ps.setString(3, mascota.getNombre());
            ps.setString(4, mascota.getEspecie());
            ps.setString(5, mascota.getRaza());
            ps.setString(6, mascota.getNombreDuenio());
            ps.setInt(7, mascota.getEdad());
            ps.setInt(8, mascota.getPeso());
            ps.setInt(9, idMascota);
            ps.executeUpdate();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            try {
                conexion.cerrar();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
    }

    /**
     * Metodo para borrar una mascota
     * 
     * @param idMascota -- El id de la mascota a eliminar
     * @return Boolean -- true si se realizo, false en caso contrario
     */
    public Boolean borrarMascota(int idMascota) {
        String query = "DELETE FROM mascota WHERE idMascota = ?";
        boolean ok = false;
        try {
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setInt(1, idMascota);
            ps.executeUpdate();
            ok = true;
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            try {
                conexion.cerrar();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return ok;
    }

}
