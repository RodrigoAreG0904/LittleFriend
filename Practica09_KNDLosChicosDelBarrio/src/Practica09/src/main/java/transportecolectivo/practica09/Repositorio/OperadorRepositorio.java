package transportecolectivo.practica09.Repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import transportecolectivo.practica09.Conexion.ConexionBD;
import transportecolectivo.practica09.Modelo.Operador;

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
public class OperadorRepositorio {
    private ConexionBD conexion = new ConexionBD();
    // Objeto para ejecutar queries
    private Statement stmt;
    // Objeto para prepara un querie para su ejecucion
    private PreparedStatement ps;

    /**
     * Metodo que se conecta a la base de datos y obtiene todas las entradas
     * de los operadores
     * 
     * @return List<Operador> Una lista de operadores
     * @throws SQLException -- Excepcion que sale si no se logra a hacer
     *                      la query de la consulta o la conexion
     */
    public List<Operador> getOperadores() throws SQLException {
        String query = "SELECT * FROM operador"; // Escribimos nuestra query
        List<Operador> operadorLista = new ArrayList<Operador>();
        try {
            // Nos conectamos a la base de datos
            conexion.conectar();
            // Preparamos la base de datos
            stmt = conexion.prepararDeclaracion();
            // Ejecuto mi query y me regresa un iterador
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // System.out.println(rs.getString("curp"));
                Operador op = new Operador(
                        rs.getString("curp"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getInt("horario"),
                        rs.getString("ciudad"),
                        rs.getString("calle"),
                        rs.getInt("cp"));
                // Agrego el resultado
                operadorLista.add(op);
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
        return operadorLista;
    }

    /**
     * Metodo que obtiene a un operador dentro de la base a partir de su curp
     * 
     * @param curp -- La curp del operador a buscar
     * @return Operador -- El operador en caso de encontrarse null, en otro caso
     * @throws SQLException --Excepcion que sale si no se logra a hacer
     *                      la query de la consulta o la conexion
     */
    public Operador getOperador(String curp) throws SQLException {
        String query = "SELECT * FROM operador WHERE curp = ?";
        Operador op = null;
        try {
            // Conectamos a la Base
            conexion.conectar();
            // Preparamos la Base para la consulta
            ps = conexion.prepararDeclaracionPreparada(query);
            // Modificamos la consulta, para ver que sustituira
            ps.setString(1, curp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                op = new Operador(
                        rs.getString("curp"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getInt("horario"),
                        rs.getString("ciudad"),
                        rs.getString("calle"),
                        rs.getInt("cp"));
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
        return op;
    }

    /**
     * Metodo que inserta un operador dentro de la base de datos
     * 
     * @param operador -- El operador que deseamos insertar en la base de datos
     */
    public void insertarOperador(Operador operador) {
        String query = "INSERT INTO operador "
                + "(curp, nombre, apellidoPaterno, apellidoMaterno, horario, ciudad, calle, cp)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        try {
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setString(1, operador.getCurp());
            ps.setString(2, operador.getNombre());
            ps.setString(3, operador.getApellidoPaterno());
            ps.setString(4, operador.getApellidoMaterno());
            ps.setInt(5, operador.getHorario());
            ps.setString(6, operador.getCiudad());
            ps.setString(7, operador.getCalle());
            ps.setInt(8, operador.getCp());
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
     * Metodo que actualiza un operador dentro de la base de datos
     * 
     * @param curp     -- El curp del operador a buscar para actualizar
     * @param operador -- El operador que vamos a intercambiar sus valores
     */
    public void actualizarOperador(String curp, Operador operador) {
        String query = "UPDATE operador SET curp = ?, nombre = ?, "
                + "apellidoPaterno = ?, apellidoMaterno = ?, "
                + "horario=?, ciudad =?, calle=?, cp= ? WHERE curp = ?";
        try {
            conexion.conectar();
            ;
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setString(1, operador.getCurp());
            ps.setString(2, operador.getNombre());
            ps.setString(3, operador.getApellidoPaterno());
            ps.setString(4, operador.getApellidoMaterno());
            ps.setInt(5, operador.getHorario());
            ps.setString(6, operador.getCiudad());
            ps.setString(7, operador.getCalle());
            ps.setInt(8, operador.getCp());
            ps.setString(9, curp);
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
     * Metodo para borrar un operador
     * 
     * @param curp -- Curp del operador a eliminar
     * @return Boolean -- true si se realizo, false en caso contrario
     */
    public Boolean borrarOperador(String curp) {
        String query = "DELETE FROM operador WHERE curp = ?";
        boolean ok = false;
        try {
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setString(1, curp);
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
