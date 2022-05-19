package practica09.Repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import practica09.Conexion.ConexionBD;
import practica09.Modelo.Duenio;

/**
 * Clase que permite las operaciones CRUD de la tabla duenio de la base de
 * datos
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class DuenioRepositorio {
    private ConexionBD conexion = new ConexionBD();
    // Objeto para ejecutar queries
    private Statement stmt;
    // Objeto para prepara un querie para su ejecucion
    private PreparedStatement ps;

    /**
     * Metodo que se conecta a la base de datos y obtiene todas las entradas
     * de los operadores
     * 
     * @return List<Duenio> Una lista de Duenios
     * @throws SQLException -- Excepcion que sale si no se logra a hacer
     *                      la query de la consulta o la conexion
     */
    public List<Duenio> getDuenios() throws SQLException {
        String query = "SELECT * FROM duenio"; // Escribimos nuestra query
        List<Duenio> duenioLista = new ArrayList<Duenio>();
        try {
            // Nos conectamos a la base de datos
            conexion.conectar();
            // Preparamos la base de datos
            stmt = conexion.prepararDeclaracion();
            // Ejecuto mi query y me regresa un iterador
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Duenio dn = new Duenio(
                        rs.getString("curp"),
                        rs.getInt("idEstetica"),
                        rs.getString("nombreDuenio"),
                        rs.getString("apellidoPaternoDuenio"),
                        rs.getString("apellidoMaternoDuenio"),
                        rs.getString("correoDuenio"),
                        rs.getString("estadoDuenio"),
                        rs.getString("calleDuenio"),
                        rs.getInt("numeroDuenio"),
                        rs.getInt("codigoPostalDuenio"));
                // Agrego el resultado
                duenioLista.add(dn);
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
        return duenioLista;
    }

    /**
     * Metodo que obtiene a un duenio dentro de la base a partir de su curp
     * 
     * @param curp -- El curp del duenio
     * @return Duenio -- El duenio en caso de encontrarse null, en otro caso
     * @throws SQLException --Excepcion que sale si no se logra a hacer
     *                      la query de la consulta o la conexion
     */
    public Duenio getDuenio(String curp) throws SQLException {
        String query = "SELECT * FROM duenio WHERE curp = ?";
        Duenio dn = null;
        try {
            // Conectamos a la Base
            conexion.conectar();
            // Preparamos la Base para la consulta
            ps = conexion.prepararDeclaracionPreparada(query);
            // Modificamos la consulta, para ver que sustituira
            ps.setString(1, curp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dn = new Duenio(
                        rs.getString("curp"),
                        rs.getInt("idEstetica"),
                        rs.getString("nombreDuenio"),
                        rs.getString("apellidoPaternoDuenio"),
                        rs.getString("apellidoMaternoDuenio"),
                        rs.getString("correoDuenio"),
                        rs.getString("estadoDuenio"),
                        rs.getString("calleDuenio"),
                        rs.getInt("numeroDuenio"),
                        rs.getInt("codigoPostalDuenio"));
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
        return dn;
    }

    /**
     * Metodo que inserta un duenio dentro de la base de datos
     * 
     * @param duenio -- El duenio que deseamos insertar en la base de datos
     */
    public void insertarDuenio(Duenio duenio) {
        String query = "INSERT INTO duenio "
                + "(curp, idEstetica, nombreDuenio, apellidoPaternoDuenio, apellidoMaternoDuenio, correoDuenio, estadoDuenio, calleDuenio, numeroDuenio, codigoPostalDuenio)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            conexion.conectar();
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setString(1, duenio.getCurp());
            ps.setInt(2, duenio.getIdEstetica());
            ps.setString(3, duenio.getNombreDuenio());
            ps.setString(4, duenio.getApellidoPaternoDuenio());
            ps.setString(5, duenio.getApellidoMaternoDuenio());
            ps.setString(6, duenio.getCorreoDuenio());
            ps.setString(7, duenio.getEstadoDuenio());
            ps.setString(8, duenio.getCalleDuenio());
            ps.setInt(9, duenio.getNumeroDuenio());
            ps.setInt(10, duenio.getCodigoPostalDuenio());
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
     * Metodo que actualiza un duenio dentro de la base de datos
     * 
     * @param curp   -- El curp del duenio a buscar para actualizar
     * @param duenio -- El duenio al que vamos a intercambiar sus valores
     */
    public void actualizarDuenio(String curp, Duenio duenio) {
        String query = "UPDATE duenio SET curp = ?, idEstetica = ?, "
                + "nombreDuenio = ?, apellidoPaternoDuenio = ?, apellidoMaternoDuenio = ?, "
                + "correoDuenio = ?, estadoDuenio = ?, calleDuenio = ?, numeroDuenio = ?, codigoPostalDuenio = ? WHERE curp = ?";
        try {
            conexion.conectar();
            ;
            ps = conexion.prepararDeclaracionPreparada(query);
            ps.setString(1, duenio.getCurp());
            ps.setInt(2, duenio.getIdEstetica());
            ps.setString(3, duenio.getNombreDuenio());
            ps.setString(4, duenio.getApellidoPaternoDuenio());
            ps.setString(5, duenio.getApellidoMaternoDuenio());
            ps.setString(6, duenio.getCorreoDuenio());
            ps.setString(7, duenio.getEstadoDuenio());
            ps.setString(8, duenio.getCalleDuenio());
            ps.setInt(9, duenio.getNumeroDuenio());
            ps.setInt(10, duenio.getCodigoPostalDuenio());
            ps.setString(11, curp);
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
     * Metodo para borrar un duenio
     * 
     * @param curp -- El curp del duenio a eliminar
     * @return Boolean -- true si se realizo, false en caso contrario
     */
    public Boolean borrarDuenio(String curp) {
        String query = "DELETE FROM duenio WHERE curp = ?";
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
