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
            Estetica estetica = agregarEstetica();
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
                    System.out.println("Inserte el nombre de la estetica que busca: ");
            try {
              String nombreE = input.nextLine();
              estetica = buscarEstetica(esteticas, nombreE);
              if(estetica == null){
                System.out.println("No hay ninguna estetica registrada con este nombre.");
                return;
              }
              esteticas.remove(estetica);
            }catch (InputMismatchException e){
              input.next();
              System.out.println("Nombre de estetica invalido.");
            }

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
            Estetica estetica = agregarEstetica();
            esteticas.add(estetica);
            System.out.println("Se agrego la Estetica");
          break; // Break caso 2.1: agregar Estetica

          case 2:
            for(int i=0;i<esteticas.size();i++)
              System.out.println(esteticas.get(i).toString());
          break; // Break caso 2.2: ver Esteticas

          case 3:
                    System.out.println("Inserte el nombre de la estetica: ");
          try {
            input.nextLine();
            String nombreE = input.nextLine();
            estetica = buscarEstetica(esteticas, nombreE);
            if(estetica == null){
              System.out.println("No hay ninguna estetica registrada con este nombre.");
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
          break; // Break caso 2.3: editar estetica


          case 4:
                    System.out.println("Inserte el nombre de la estetica: ");
            try {
              input.nextLine();
              String nombreE = input.nextLine();
              estetica = buscarEstetica(esteticas, nombreE);
              if(estetica == null){
                System.out.println("No hay ninguna estetica registrada con este nombre.");
                return;
              }
              esteticas.remove(estetica);
            }catch (InputMismatchException e){
              input.next();
              System.out.println("Nombre de la estetica invalido.");
            }
          break; // Break caso 2.4: eliminar estetica

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
        if(nuevo <= 0 || nuevo > Integer.MAX_VALUE){
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

    /**
  * Metodo para buscar el nombre de una estetica
  * @param estetica -- La estetica a buscar
  * @param lista -- lista de las esteticas registradas
  * @return Estetica -- La estetica encontrada
  */
  public Estetica buscarEstetica(ArrayList<Estetica> lista, String estetica){
    Estetica actual = new Estetica();
    ArrayList<Estetica> busqueda = new ArrayList<Estetica>();
    if(estetica.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String nombreActual = actual.getNombre();
        if(nombreActual.equals(estetica))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte la direccion de su estetica\n");
      String direccion = input.nextLine();
      actual = buscarDireccion(busqueda, direccion);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar la direccion de una estetica
  * @param estetica -- La estetica a buscar
  * @param lista -- lista de las esteticas registradas con el mismo nombre
  * @return Estetica -- La estetica encontrada
  */
  public Estetica buscarDireccion(ArrayList<Estetica> lista, String estetica){
    Estetica actual = new Estetica();
    ArrayList<Estetica> busqueda = new ArrayList<Estetica>();
    if(estetica.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String direccionActual = actual.getDireccion();
        if(direccionActual == estetica)
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte el telefono de su estetica\n");
      int telefono = input.nextInt();
      actual = buscarTelefono(busqueda, telefono);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar el telefono de una estetica
  * @param estetica -- La estetica a buscar
  * @param lista -- lista de las esteticas registradas con el mismo nombre y direccion
  * @return Estetica -- La estetica encontrada
  */
  public Estetica buscarTelefono(ArrayList<Estetica> lista, int estetica){
    Estetica actual = new Estetica();
    ArrayList<Estetica> busqueda = new ArrayList<Estetica>();
    if(estetica < 0 || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        int telefonoActual = actual.getTelefono();
        if(telefonoActual == estetica)
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte el horario de su estetica (nn:nn - nn:nn)\n");
      String horario = input.nextLine();
      actual = buscarHorario(busqueda, horario);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }
  
  /**
  * Metodo para buscar la horario de una estetica
  * @param estetica -- La estetica a buscar
  * @param lista -- lista de las esteticas registradas con el mismo nombre, direccion y telefono
  * @return Estetica -- La estetica encontrada
  */
  public Estetica buscarHorario(ArrayList<Estetica> lista, String estetica){
    Estetica actual = new Estetica();
    ArrayList<Estetica> busqueda = new ArrayList<Estetica>();
    if(estetica.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String horarioActual = actual.getHorario();
        if(horarioActual.equals(estetica))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado una copia de su estetica. Procedemos a eliminar la(s) copia(s).\n");
      for(int i = 1; i <= busqueda.size(); i++){
        esteticas.remove(i);
      }
      return busqueda.get(0);
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para agregar una estetica
  * @return Estetica -- La estetica agregada
  */
  public Estetica agregarEstetica(){
    input = new Scanner(System.in);
    String nombre, horario, raza, duenio, direccion;
    nombre = horario = raza = duenio = direccion = "";
    int telefono, ingreso, gananciasTotales;
    telefono = ingreso = 0;
    boolean continua;
    System.out.println("Ingresa el nombre de tu estetica\n");
    nombre = input.nextLine();
    //poner error?
    System.out.println("Ingresa la direccion de tu estetica\n");
    direccion = input.nextLine();
    do{
      System.out.println("Ingresa el telefono de tu estetica\n");
      try {
        continua = false;
        telefono = input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Ingresa un telefono valido");
        input.next();
        continua = true;
      }
    } while(continua);

    //nextLine vacio que el programa salta por el nextInt anterior
    input.nextLine();

    System.out.println("Ingresa el horario de tu estetica\n");
    horario = input.nextLine();
    do{
      System.out.println("Ingresa el el ingreso mas tardio de tu estetica\n");
      try {
        continua = false;
        ingreso = input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Ingresa una cantidad valida");
        input.next();
        continua = true;
      }
    } while(continua);
    ArrayList<Integer> ingresos = new ArrayList<Integer>();
    ingresos.add(ingreso);
    // numero al azar para poder crear estetica
    gananciasTotales = 5;

    Estetica estetica = new Estetica(nombre, direccion, telefono, horario, ingresos, gananciasTotales);
    estetica.setGanancias();
    return estetica;
  }
}