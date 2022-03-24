import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Interfaz que sirve para la practica 2
 * @author Rodrigo Arevalo Gaytan
 * @author Diana Berenice Hernández Alonso
 * @author Julio Cesar Torres Escobedo
 * @author Santiago  Arroyo Lozano
 * @author Karyme Ivette Azpeitia Garcia
 * @version 16/03/2022
 */
public class InterfazD {

  private boolean bandera;
  private int opcion = 0;
  private Scanner input;

    public void interfazDuenios() {
    input = new Scanner(System.in);
    ArrayList<Duenio> duenios = new ArrayList<>();
    DuenioArchivo archivo = new DuenioArchivo();
    System.out.println("Ingresa la opcion deseda\n 1-CargarDatos\n 2-CrearNuevo\n 3-Salir");
    try {
      opcion = input.nextInt();
    } catch (InputMismatchException e) {
      input.next();
      System.out.println("Ingresa un número como opcion");
    }
    switch(opcion) {
      case 1:
      System.out.println("Cargando datos de Duenios...");
      try{
        duenios = archivo.leeDuenios();
        System.out.println("Listo...");
      }catch(Exception e){
        System.out.println(e);
      }
      do{
        bandera = true;
        System.out.println("Ingresa la opcion deseada\n" + "1-Agregar Duenio\n" + "2-Ver Duenios\n"
        + "3-Editar Duenio\n" + "4-Borrar Duenio\n" + "5-Salir\n");
        try {
          opcion = input.nextInt();
        } catch (InputMismatchException e) {
          input.next();
          System.out.println("Ingresa un número como opcion");
        }
        switch (opcion) {
          case 1:
            Duenio duenio = new Duenio();
            duenios.add(duenio);
            System.out.println("Se agrego la Duenio");
          break;

          case 2:
            for(int i=0;i<duenios.size();i++)
              System.out.println(duenios.get(i).toString());
          break;

          case 3:
            
          break;

          case 4:
          //metodo para buscar duenio y que todos los datos correspondan a una única duenio
          //duenios.remove(duenio);
          //System.out.println("Se elimino la Duenio");
          break;

          case 5:
            if(!duenios.isEmpty()){
              System.out.println("Guardando datos de duenios...");
              archivo.escribeDuenio(duenios);
              System.out.println("Datos guardados");
            }
            bandera = false;
            System.out.println("Saliendo del sistema...\nHasta pronto.");
          break;

          default: 
            System.out.println("Por favor introduce una opcion valida");
          break;
        }
      } while(bandera);
      break; // BREAK CASO 1 SWITCH PRINCIPAL !!!

      case 2:
      do {
        bandera = true;
        System.out.println("Ingresa la opcion deseada\n" + "1-Agregar Duenio\n" + "2-Ver Duenios\n"
        + "3-Editar Duenios\n" + "4-Borrar Duenio\n" + "5-Salir\n");
        try {
          opcion = input.nextInt();
        } catch (InputMismatchException e) {
          input.next();
          System.out.println("Ingresa un número como opcion");
        }
        switch (opcion) {
          case 1:
            Duenio duenio = new Duenio();
            duenios.add(duenio);
            System.out.println("Se agrego la Duenio");
          break;

          case 2:
            for(int i=0;i<duenios.size();i++)
              System.out.println(duenios.get(i).toString());
          break;

          case 3:
          break;

          case 4:
          break;

          case 5:
            if(!duenios.isEmpty()){
              System.out.println("Guardando datos de duenios...");
              archivo.escribeDuenio(duenios);
              System.out.println("Datos guardados");
            }
            bandera = false;
            System.out.println("Saliendo del sistema...\nHasta pronto.");
          break;

          default: 
            System.out.println("Por favor introduce una opcion valida");
          break;
        }
      } while(bandera);
      break; //BREAK CASO 2 SWITCH PRINCIPAL !!!  

      case 3:
        System.out.println("Adios :D.");
        bandera = false;
      break; //BREAK CASO 3 SWITCH PRINCIPAL !!!  

      default: 
        System.out.println("Por favor introduce una opcion valida");
      break; //BREAK CASO DEGAULT SWITCH PRINCIPAL !!!  
    }
  }
}