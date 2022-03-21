import java.util.ArrayList;

/**
 * Clase que permite escribir y leer a Operadores sobre un archivo CSV
 * @author Rodrigo Arevalo Gaytan
 *	   Diana Berenice Hernández Alonso
 * 	   Julio Cesar Torres Escobedo
 *	   Santiago  Arroyo Lozano
 *	   Karyme Ivette Azpeitia Garcia
 * @version 16/03/2022
 */
public class EsteticaArchivo extends LeeryEscribir{
    /**
     * Constructor por omision que crea el archivo Estetica.csv
     */
    public EsteticaArchivo(){
        super("Estetica.csv");
      }
  
      /**
       * Metodo que prepara el arreglo de Esteticas para que puede ser guardado
       * @param estetica -- El arreglo de estetica
       */
      public void escribeEstetica(ArrayList<Estetica> estetica) {
        String lineaEstetica = "";
        for (Estetica m : estetica) {
          lineaEstetica += m + "\n";
        }
        super.escribeArchivo(lineaEstetica);
      }
  
      /**
       * Metodo que convierte un arreglo de String a un arreglo de Esteticas
       * @return esteticas -- El arreglo de esteticas
       * @throws ArchivoNoExiste -- Se lanza la excepción cuando el archivo no existe
       */
      public ArrayList<Estetica> leeEsteticas() throws ArchivoNoExiste {
        String lineas[] = super.leeArchivo();
        ArrayList<Estetica> esteticas = new ArrayList<>();
        for (int i = 0; i < lineas.length; i++) {
          if (!lineas[i].equals("null")) {
            esteticas.add(parseaEstetica(lineas[i]));
          }
        }
        return esteticas;
      }
  
      /**
       * Metodo que recibe una cadena y parsea los datos para crear a un Operador
       * @param cadenaOperador -- La cadena  parsear
       * @return el objeto con los datos de la cadena
       */
      private Estetica parseaEstetica(String cadenaEstetica) {
        String linea[] = cadenaEstetica.trim().split(",");
        String nombre = linea[0];
        String direccion = linea[1];
        int telefono = Integer.valueOf(linea[2]);
        String horario = linea[3];
        return new Estetica(nombre, direccion, telefono, horario);
      }
}
