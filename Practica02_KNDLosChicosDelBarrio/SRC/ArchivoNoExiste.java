/**
 * Clase Excepcion que surge cuando un archivo se intenta manipular y no existe
 * @author Poner a todos
 * @version 16/03/2022
 */
public class ArchivoNoExiste extends Exception{
    public ArchivoNoExiste(String message){
        super(message);
    }
}
