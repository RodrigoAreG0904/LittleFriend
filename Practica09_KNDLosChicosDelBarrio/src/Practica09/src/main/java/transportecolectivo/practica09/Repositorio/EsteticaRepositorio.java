package transportecolectivo.practica09.Repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import transportecolectivo.practica09.Conexion.ConexionBD;
import transportecolectivo.practica09.Modelo.Estetica;

/**
 * Clase que permite las operaciones CRUD de la tabla estetica de la base de
 * datos
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class EsteticaRepositorio {
    private ConexionBD conexion = new ConexionBD();
    // Objeto para ejecutar queries
    private Statement stmt;
    // Objeto para prepara un querie para su ejecucion
    private PreparedStatement ps;

    /**
     * Metodo que se conecta a la base de datos y obtiene todas las entradas
     * de las esteticas
     * 
     * @return List<Estetica> Una lista de esteticas
     * @throws SQLException -- Excepcion que sale si no se logra a hacer
     *                      la query de la consulta o la conexion
     */
    public List<Estetica> getEsteticas() throws SQLException {
        String query = "SELECT * FROM estetica"; // Escribimos nuestra query
        List<Estetica> esteticaLista = new ArrayList<Estetica>();
        try {
            // Nos conectamos a la base de datos
            conexion.conectar();
            // Preparamos la base de datos
            stmt = conexion.prepararDeclaracion();
            // Ejecuto mi query y me regresa un iterador
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Estetica es = new Estetica(
                        rs.getInt("idEstetica"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getInt("horario"),
                        rs.getString("apartado"),
                        rs.getInt("consultorios"),
                        rs.getString("estado"),
                        rs.getString("calle"),
                        rs.getInt("numero"),
                        rs.getInt("codigoPostal"));
                // Agrego el resultado
                esteticaLista.add(es);
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
        return esteticaLista;
    }

    /**
     * Metodo que obtiene a una estetica dentro de la base a partir de su idEstetica
     * 
     * @param idEstetica -- La id de la estetica a buscar
     * @return Estetica -- La estetica en caso de encontrarse null, en otro caso
     * @throws SQLException --Excepcion que sale si no se logra a hacer
     *                      la query de la consulta o la conexion
     */
    public Estetica getEstetica(int idEstetica) throws SQLException {
        String query = "SELECT * FROM estetica WHERE idEstetica = ?";
        Estetica es = null;
        try {
            // Conectamos a la Base
            conexion.conectar();
            // Preparamos la Base para la consulta
            ps = conexion.prepararDeclaracionPreparada(query);
            // Modificamos la consulta, para ver que sustituira
            ps.setInt(1, idEstetica);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                es = new Estetica(
                        rs.getInt("idEstetica"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getInt("horario"),
                        rs.getString("apartado"),
                        rs.getInt("consultorios"),
                        rs.getString("estado"),
                        rs.getString("calle"),
                        rs.getInt("numero"),
                        rs.getInt("codigoPostal"));
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
        return es;
    }

    /**
     * Metodo que inserta una estetica dentro de la base de datos
     * 
     * @param estetica -- La estetica que deseamos insertar en la base de datos
     */
    public void insertarEstetica(Estetica estetica) {
        String query = "INSERT INTO estetica "
                + "(idEstetica, nombre, telefono, horario, apartado, consultorios, estado, calle, numero, codigoPostal)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setInt(1, estetica.getIdEstetica());
            ps.setString(2, estetica.getNombre());
            ps.setInt(3, estetica.getTelefono());
            ps.setInt(4, estetica.getHorario());
            ps.setString(5, estetica.getApartado());
            ps.setInt(6, estetica.getConsultorios());
            ps.setString(7, estetica.getEstado());
            ps.setString(8, estetica.getCalle());
            ps.setInt(9, estetica.getNumero());
            ps.setInt(10, estetica.getCodigoPostal());
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
     * Metodo que actualiza una estetica dentro de la base de datos
     * 
     * @param idEstetica     -- El id de la estetica a buscar para actualizar
     * @param estetica -- La estetica que vamos a intercambiar sus valores
     */
    public void actualizarEstetica(int idEstetica, Estetica estetica) {
        String query = "UPDATE estetica SET idEstetica = ?, nombre = ?, "
                + "telefono = ?, horario = ?, "
                + "apartado=?, consultorios =?, "
                + "estado=?, calle= ?, numero= ?, codigoPostal= ? WHERE idEstetica = ?";
        try {
            conexion.conectar();
            ;
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setInt(1, estetica.getIdEstetica());
            ps.setString(2, estetica.getNombre());
            ps.setInt(3, estetica.getTelefono());
            ps.setInt(4, estetica.getHorario());
            ps.setString(5, estetica.getApartado());
            ps.setInt(6, estetica.getConsultorios());
            ps.setString(7, estetica.getEstado());
            ps.setString(8, estetica.getCalle());
            ps.setInt(9, estetica.getNumero());
            ps.setInt(10, estetica.getCodigoPostal());
            ps.setInt(11, idEstetica);
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
     * Metodo para borrar una estetica
     * 
     * @param idEstetica -- Id de la estetica a eliminar
     * @return Boolean -- true si se realizo, false en caso contrario
     */
    public Boolean borrarEstetica(int idEstetica) {
        String query = "DELETE FROM estetica WHERE idEstetica = ?";
        boolean ok = false;
        try {
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setInt(1, idEstetica);
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
