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
public class InterfazE {

  private boolean bandera;
  private int opcion = 0;
  private Scanner input;
    public void interfazEstetica() {
    input = new Scanner(System.in);
    ArrayList<Estetica> esteticas = new ArrayList<>();
    EsteticaArchivo archivo = new EsteticaArchivo();
    System.out.println("Ingresa la opcion deseda\n 1-CargarDatos\n 2-CrearNuevo\n 3-Salir");
    try {
      opcion = input.nextInt();
    } catch (InputMismatchException e) {
      input.next();
      System.out.println("Ingresa un número como opcion");
    }
    switch(opcion) {
      case 1:
      System.out.println("Cargando datos de Esteticas...");
      try {
        esteticas = archivo.leeEsteticas();
        System.out.println("Listo...");
      } catch(Exception e) {
        System.out.println(e);
      }
      do {
        bandera = true;
        System.out.println("Ingresa la opcion deseada\n" + "1-Agregar Estetica\n" + "2-Ver Esteticas\n"
        + "3-Editar Estetica\n" + "4-Borrar Estetica\n" + "5-Salir\n");
        try {
          opcion = input.nextInt();
        } catch (InputMismatchException e) {
          input.next();
          System.out.println("Ingresa un número como opcion");
        }
        switch (opcion) {
          case 1:
            Estetica estetica = new Estetica();
            esteticas.add(estetica);
            System.out.println("Se agrego la Estetica");
          break;

          case 2:
            for(int i=0;i<esteticas.size();i++)
              System.out.println(esteticas.get(i).toString());
          break;

          case 3:
          //dejar que edite cada uno de los atributos de la estetica,
          //pero que haya una opcion para dejar el atributo que se le deja para editar como esta, hacer un mini menu para que elija que quiere editar, o si quiere editar todo.
          break;

          case 4:
          // metodo para buscar estetica y que todos los datos correspondan a una única estetica o que busque por diferentes
          // atributos y elija cual eliminar (le puede ir apareciendo las esteticas que corresponden con la busqueda)
          //esteticas.remove(estetica);
          //System.out.println("Se elimino la Estetica");
          break;

          case 5:
            if(!esteticas.isEmpty()) {
              System.out.println("Guardando datos de esteticas...");
              archivo.escribeEstetica(esteticas);
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
      break; // BREAK CASO 1 SWITCH PRINCIPAL !!!!! 

      case 2:
      do {
        bandera = true;
        System.out.println("Ingresa la opcion deseada\n" + "1-Agregar Estetica\n" + "2-Ver Esteticas\n"
        + "3-Editar Esteticas\n" + "4-Borrar Estetica\n" + "5-Salir\n");
        try {
          opcion = input.nextInt();
        } catch (InputMismatchException e) {
          input.next();
          System.out.println("Ingresa un número como opcion");
        }
        switch (opcion) {
          case 1:
            Estetica estetica = new Estetica();
            esteticas.add(estetica);
            System.out.println("Se agrego la Estetica");
          break;

          case 2:
            for(int i=0;i<esteticas.size();i++)
              System.out.println(esteticas.get(i).toString());
          break;

          case 3:
          break;

          case 4:
          break;

          case 5:
            if(!esteticas.isEmpty()){
              System.out.println("Guardando datos de esteticas...");
              archivo.escribeEstetica(esteticas);
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
      break; // BREAK CASO 2 SWITCH PRINCIPAL !!!!! 

      case 3:
        System.out.println("Adios :D.");
        bandera = false;
      break; // BREAK CASO 3 SWITCH PRINCIPAL !!!!! 

      default: 
        System.out.println("Por favor introduce una opcion valida");
      break; // BREAK CASO DEFAULT SWITCH PRINCIPAL !!!!! 
    }
  }
}