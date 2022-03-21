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
public class DuenioArchivo {
    /**
     * Constructor por omision que crea el archivo Duenio.csv
     */
    public DuenioArchivo(){
        super("Duenio.csv");
      }
  
      /**
       * Metodo que prepara el arreglo de Duenios para que puede ser guardado
       * @param duenio -- El arreglo de duenio
       */
      public void escribeDuenio(ArrayList<Duenio> duenio) {
        String lineaDuenio = "";
        for (Duenio m : duenio) {
          lineaDuenio += m + "\n";
        }
        super.escribeArchivo(lineaDuenio);
      }
  
      /**
       * Metodo que convierte un arreglo de String a un arreglo de Duenios
       * @return duenios -- El arreglo de duenios
       * @throws ArchivoNoExiste -- Se lanza la excepción cuando el archivo no existe
       */
      public ArrayList<Duenio> leeDuenios() throws ArchivoNoExiste {
        String lineas[] = super.leeArchivo();
        ArrayList<Duenio> duenios = new ArrayList<>();
        for (int i = 0; i < lineas.length; i++) {
          if (!lineas[i].equals("null")) {
            duenios.add(parseaDuenio(lineas[i]));
          }
        }
        return duenios;
      }
  
      /**
       * Metodo que recibe una cadena y parsea los datos para crear a un Operador
       * @param cadenaOperador -- La cadena  parsear
       * @return el objeto con los datos de la cadena
       */
      private Duenio parseaDuenio(String cadenaDuenio) {
        String linea[] = cadenaDuenio.trim().split(",");
        String nombre = linea[0];
        String apellidoP = linea[1];
        String apellidoM = linea[2];
        String curp = linea[3];
        String direccion = linea[4];
        int telefono= Integer.valueOf(linea[5]);
        return new Duenio(nombre, apellidoP, apellidoM, curp, direccion, telefono);
      }
    
}
