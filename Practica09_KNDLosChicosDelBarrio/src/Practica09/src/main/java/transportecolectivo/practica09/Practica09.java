package transportecolectivo.practica09;

import java.sql.SQLException;
import transportecolectivo.practica09.Conexion.ConexionBD;

//import transportecolectivo.practica09.ProgramaEjemplo.Insertar;
/**
import transportecolectivo.practica09.Conexion.ConexionBD;
import java.sql.SQLException;
import transportecolectivo.practica09.Modelo.Operador;
import transportecolectivo.practica09.Repositorio.OperadorRepositorio;
*/
/**
 * Clase que ejecuta la aplicacion de java de escritorio
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class Practica09 {

    public static void main(String[] pps) {

        ConexionBD c = new ConexionBD();
        try {
            c.conectar();
            c.cerrar();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }
}
