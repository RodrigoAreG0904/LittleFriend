import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Main que sirve para la practica 2
 * @author Rodrigo Arevalo Gaytan
 *	   Diana Berenice Hernández Alonso
 * 	   Julio Cesar Torres Escobedo
 *	   Santiago  Arroyo Lozano
 *	   Karyme Ivette Azpeitia Garcia
 * @version 16/03/2022
 */
public class EjemploPractica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      boolean bandera;
      int opcion = 0;
      Scanner input = new Scanner(System.in);
      ArrayList<Mascota> mascotas = new ArrayList<>();
      MascotaArchivo archivo = new MascotaArchivo();
      do {
        bandera = true;
        System.out.println("Ingresa la opcion deseda\n 1-CargarDatos\n 2-CrearNuevo\n 3-Salir");
        try{
          opcion = input.nextInt();
        } catch (InputMismatchException e) {
          input.next();
          System.out.println("Ingresa un número como opción");
        }
        if(opcion > 0 && opcion < 4){
          switch(opcion){
            case 1:
            System.out.println("Cargando datos de Mascotas...");
            try{
              mascotas = archivo.leeOperadores();
              System.out.println("Listo...");
            }catch(Exception e){
              System.out.println(e);
            }
            do{
              bandera = true;
              System.out.println("Ingresa la opción deseada\n" + "1-Agregar Mascota\n" + "2-Ver Mascotas\n"
              + "3-Editar Mascota\n" + "4-Borrar Mascota\n" + "5-Salir\n");
              try {
                opcion = input.nextInt();
              } catch (InputMismatchException e) {
                input.next();
                System.out.println("Ingresa un número como opción");
              }
              if (opcion > 0 && opcion < 6) {
                switch (opcion) {
                  case 1:
                  Mascota mascota = new Mascota();
                  mascotas.add(mascota);
                  System.out.println("Se agrego el Mascota");
                  break;

                  case 2:
                  for(int i=0;i<mascotas.size();i++){
                    System.out.println(mascotas.get(i).toString());
                  }
                  break;

                  case 3:
                  break;

                  case 4:
                  break;

                  case 5:
                  if(!mascotas.isEmpty()){
                    System.out.println("Guardando datos de mascotas...");
                    archivo.escribeOpeador(mascotas);
                    System.out.println("Datos guardados");
                  }
                  bandera = false;
                  System.out.println("Saliendo del sistema...\nHasta pronto.");
                  break;
                  default:
                  break;
                }
              }
            }while(bandera);
            break;

            case 2:
            do{
              bandera = true;
              System.out.println("Ingresa la opción deseada\n" + "1-Agregar Mascota\n" + "2-Ver Mascotas\n"
              + "3-Editar Mascota\n" + "4-Borrar Mascota\n" + "5-Salir\n");
              try {
                opcion = input.nextInt();
              } catch (InputMismatchException e) {
                input.next();
                System.out.println("Ingresa un número como opción");
              }
              if (opcion > 0 && opcion < 6) {
                switch (opcion) {
                  case 1:
                  Mascota mascota = new Mascota();
                  mascotas.add(mascota);
                  System.out.println("Se agrego el Mascota");
                  break;

                  case 2:
                  for(int i=0;i<mascotas.size();i++){
                    System.out.println(mascotas.get(i).toString());
                  }
                  break;

                  case 3:
                  break;

                  case 4:
                  break;

                  case 5:
                  if(!mascotas.isEmpty()){
                    System.out.println("Guardando datos de mascotas...");
                    archivo.escribeOpeador(mascotas);
                    System.out.println("Datos guardados");
                  }
                  bandera = false;
                  System.out.println("Saliendo del sistema...\nHasta pronto.");
                  break;
                  default:
                  break;
                }
              }
            }while(bandera);
            case 3:
            System.out.println("Adios :D.");
            bandera = false;
            break;
            default:
            break;
          }
        }

      } while (bandera);

    }
  }
