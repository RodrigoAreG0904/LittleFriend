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
public class MascotaArchivo extends LeeryEscribir{
    /**
     * Constructor por omision que crea el archivo Mascota.csv
     */
    public MascotaArchivo(){
      super("Mascota.csv");
    }

    /**
     * Metodo que prepara el arreglo de Mascotas para que puede ser guardado
     * @param mascota -- El arreglo de mascota
     */
    public void escribeMascota(ArrayList<Mascota> mascota) {
      String lineaMascota = "";
      for (Mascota m : mascota) {
        lineaMascota += m + "\n";
      }
      super.escribeArchivo(lineaMascota);
    }

    /**
     * Metodo que convierte un arreglo de String a un arreglo de Mascotas
     * @return mascotas -- El arreglo de mascotas
     * @throws ArchivoNoExiste -- Se lanza la excepción cuando el archivo no existe
     */
    public ArrayList<Mascota> leeMascotas() throws ArchivoNoExiste {
      String lineas[] = super.leeArchivo();
      ArrayList<Mascota> mascotas = new ArrayList<>();
      for (int i = 0; i < lineas.length; i++) {
        if (!lineas[i].equals("null")) {
          mascotas.add(parseaMascota(lineas[i]));
        }
      }
      return mascotas;
    }

    /**
     * Metodo que recibe una cadena y parsea los datos para crear a un Operador
     * @param cadenaOperador -- La cadena  parsear
     * @return el objeto con los datos de la cadena
     */
    private Mascota parseaMascota(String cadenaMascota) {
      String linea[] = cadenaMascota.trim().split(",");
      String nombre = linea[0];
      int edad = Integer.valueOf(linea[1]);
      int peso = Integer.valueOf(linea[2]);
      String especie = linea[3];
      String raza = linea[4];
      String nombreDeDuenio= linea[5];
      return new Mascota(nombre, edad, peso, especie, raza, nombreDeDuenio);
    }
}
