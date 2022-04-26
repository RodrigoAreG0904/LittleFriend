import java.util.ArrayList;

/**
 * Clase que permite escribir y leer a Operadores sobre un archivo CSV
 * @author Rodrigo Arevalo Gaytan
 * @author Diana Berenice Hernández Alonso
 * @author Julio Cesar Torres Escobedo
 * @author Santiago  Arroyo Lozano
 * @author Karyme Ivette Azpeitia Garcia
 * @version 16/03/2022
 */
public class DuenioArchivo extends LeeryEscribir {
  
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
        String fecha = linea[3];
        String curp = linea[4];
        String direccion = linea[5];
        int telefono = Integer.valueOf(linea[6]);
        String tarjeta = linea[7];
        String correo = linea[8];
        return new Duenio(nombre, apellidoP, apellidoM, fecha, curp, direccion, telefono, tarjeta, correo);
      }
    
}
