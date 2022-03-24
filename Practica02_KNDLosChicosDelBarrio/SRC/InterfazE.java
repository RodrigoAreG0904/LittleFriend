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
  private ArrayList<Estetica> esteticas = new ArrayList<>();
  
    public void interfazEstetica() {
    input = new Scanner(System.in);
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
          break; // Break caso 1.1: agregar Estetica

          case 2:
            for(int i=0;i<esteticas.size();i++)
              System.out.println(esteticas.get(i).toString());
          break; // Break caso 1.2: ver Estetica

          case 3:
            System.out.println("Inserte el nombre de la Estetica: ");
            try {
              String nombreE = input.nextLine();
              estetica = buscarEstetica(esteticas, nombreE);
              if(estetica == null){
                System.out.println("No hay ninguna Estetica registrada con este nombre.");
                return;
              }
              System.out.println("Seleccione la opcion que quiera editar:\n" + "1.- Nombre de la estetica\n" + "2.- Direccion\n" + "3.- Telefono\n" 
              + "4.- Horario\n" + "5.- Salir\n");
            
              opcion = input.nextInt();
              switch(opcion){
                case 1: editarNombre(estetica); break;
                case 2: editarDireccion(estetica); break;
                case 3: editarTelefono(estetica); break;
                case 4: editarHorario(estetica); break;
                case 5: 
                  System.out.println("Saliendo del menu de edicion.");
                break;

                default:
                  System.out.println("Seleccione una opcion correcta");
                break;
              }
            } catch (InputMismatchException e){
              input.next();
              System.out.println("Nombre de estetica invalido.");
            }
          break; // Break caso 1.3: editar Estetica

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
          break; // Break caso 2.1: agregar Estetica

          case 2:
            for(int i=0;i<esteticas.size();i++)
              System.out.println(esteticas.get(i).toString());
          break; // Break caso 2.2: ver Esteticas

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
          break; // Break caso 2.5: salir

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

  /**
  * Metodo para editar el nombre de la estetica
  * @param estetica -- La estetica que modificaremos
  */
  public void editarNombre(Estetica estetica){
    System.out.println("Escriba el nuevo nombre de su estetica: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga un nombre\n");
      return;
    }
    estetica.setNombre(nuevo);
    System.out.println("Se ha guardado el nombre.\n");
  }

  /**
  * Metodo para editar la direccion de la estetica
  * @param estetica -- La estetica que modificaremos
  */
  public void editarDireccion(Estetica estetica){
    System.out.println("Escriba la nueva direccion de su estetica: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga una direccion\n");
      return;
    }
    estetica.setDireccion(nuevo);
    System.out.println("Se ha guardado la direccion.\n");
  }

  /**
  * Metodo para editar el telefono de la estetica
  * @param estetica -- La estetica que modificaremos
  */
  public void editarTelefono(Estetica estetica){
    System.out.println("Escriba el nuevo telefono de su estetica: \n");
    int nuevo = input.nextInt();
    if(nuevo <= 0 || nuevo > 9999999999){
      System.out.println("Ponga un numero mayor a 0 y menor a 9999999999\n");
      return;
    }
    estetica.setTelefono(nuevo);
    System.out.println("Se ha guardado el telefono.\n");
  }

  /**
  * Metodo para editar el horario de la estetica
  * @param estetica -- La estetica que modificaremos
  */
  public void editarHorario(Estetica estetica){
    System.out.println("Escriba el nuevo horario de su estetica: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga un horario\n");
      return;
    }
    estetica.setHorario(nuevo);
    System.out.println("Se ha guardado el horario.\n");
  }
}