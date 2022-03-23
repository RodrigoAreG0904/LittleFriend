/**
 * Clase Excepcion que surge cuando un archivo se intenta manipular y no existe
 * @author Rodrigo Arevalo Gaytan
 * @author Diana Berenice Hernández Alonso
 * @author Julio Cesar Torres Escobedo
 * @author Santiago  Arroyo Lozano
 * @author Karyme Ivette Azpeitia Garcia
 * @version 16/03/2022
 */
public class ArchivoNoExiste extends Exception{
    public ArchivoNoExiste(String message){
        super(message);
    }
}
