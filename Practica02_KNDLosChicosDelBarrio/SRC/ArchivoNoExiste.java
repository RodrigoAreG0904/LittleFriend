/**
 * Clase Excepcion que surge cuando un archivo se intenta manipular y no existe
 * @author Rodrigo Arevalo Gaytan
 *	   Diana Berenice Hernández Alonso
 * 	   Julio Cesar Torres Escobedo
 *	   Santiago  Arroyo Lozano
 *	   Karyme Ivette Azpeitia Garcia
 * @version 16/03/2022
 */
public class ArchivoNoExiste extends Exception{
    public ArchivoNoExiste(String message){
        super(message);
    }
}
