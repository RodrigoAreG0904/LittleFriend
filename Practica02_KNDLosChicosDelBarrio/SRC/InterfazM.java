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
public class InterfazM {

  private boolean bandera;
  private int opcion = 0;
  private Scanner input;
  private ArrayList<Mascota> mascotas = new ArrayList<>();

  public void interfazMascota() {
    input = new Scanner(System.in);
    MascotaArchivo archivo = new MascotaArchivo();
    System.out.println("Ingresa la opcion deseda\n 1-CargarDatos\n 2-CrearNuevo\n 3-Salir");
    try {
      opcion = input.nextInt();
    } catch (InputMismatchException e) {
      input.next();
      System.out.println("Ingresa un número como opcion");
    }
    switch(opcion) {
      case 1:
      System.out.println("Cargando datos de Mascotas...");
      try {
        mascotas = archivo.leeMascotas();
        System.out.println("Listo...");
      } catch(Exception e) {
        System.out.println(e);
      }
      do {
        bandera = true;
        System.out.println("Ingresa la opcion deseada\n" + "1-Agregar Mascota\n" + "2-Ver Mascotas\n"
        + "3-Editar Mascota\n" + "4-Borrar Mascota\n" + "5-Salir\n");
        try {
          opcion = input.nextInt();
        } catch (InputMismatchException e) {
          input.next();
          System.out.println("Ingresa un número como opcion");
        }
        switch (opcion) {
          case 1:
            Mascota mascota = agregarMascota();
            mascotas.add(mascota);
            System.out.println("Se agrego la Mascota");
          break; // Break caso 1.1: agregar mascota

          case 2:
            for(int i=0;i<mascotas.size();i++)
              System.out.println(mascotas.get(i).toString());
          break;  // Break caso 1.2: ver mascota

          case 3:
            System.out.println("Inserte el nombre de su mascota: ");
            try {
              input.nextLine();
              String nombreM = input.nextLine();
              mascota = buscarMascota(mascotas, nombreM);
              if(mascota == null){
                System.out.println("No hay ninguna mascota registrada con este nombre.");
                return;
              }
              System.out.println("Seleccione la opcion que quiera editar:\n" + "1.- Nombre de la mascota\n" + "2.- Edad\n" + "3.- Peso\n" 
              + "4.- Especie\n" + "5.- Raza\n" + "6.- Nombre del duenio\n" + "7.- Salir\n");
              
              opcion = input.nextInt();
              switch(opcion){
                case 1: editarNombre(mascota); break;
                case 2: editarEdad(mascota); break;
                case 3: editarPeso(mascota); break;
                case 4: editarEspecie(mascota); break;
                case 5: editarRaza(mascota); break;
                case 6: editarNombreDuenio(mascota); break;
                case 7: 
                  System.out.println("Saliendo del menu de edicion.");
                break;

                default:
                  System.out.println("Seleccione una opcion correcta");
                break;
              }
            } catch (InputMismatchException e){
              input.next();
              System.out.println("Nombre de mascota invalido.");
            }
          break;   // Break caso 1.3: editar mascota

          case 4:
            System.out.println("Inserte el nombre de su mascota: ");
            try {
              input.nextLine();
              String nombreM = input.nextLine();
              mascota = buscarMascota(mascotas, nombreM);
              if(mascota == null){
                System.out.println("No hay ninguna mascota registrada con este nombre.");
                return;
              }
              mascotas.remove(mascota);
            }catch (InputMismatchException e){
              input.next();
              System.out.println("Nombre de mascota invalido.");
            } 
          break;  // Break caso 1.4: eliminar mascota

          case 5:
            if(!mascotas.isEmpty()) {
              System.out.println("Guardando datos de mascotas...");
              archivo.escribeMascota(mascotas);
              System.out.println("Datos guardados");
            }
            bandera = false;
            System.out.println("Saliendo del sistema...\nHasta pronto.");
          break;  // Break caso 1.5: salir

          default: 
            System.out.println("Por favor introduce una opcion valida");
          break;
        }
      } while(bandera);
      break; //BREAK CASO 1 SWITCH PRINCIPAL !!!!!!

      case 2:
      do {
        bandera = true;
        System.out.println("Ingresa la opcion deseada\n" + "1-Agregar Mascota\n" + "2-Ver Mascotas\n"
        + "3-Editar Mascotas\n" + "4-Borrar Mascota\n" + "5-Salir\n");
        try {
          opcion = input.nextInt();
        } catch (InputMismatchException e) {
          input.next();
          System.out.println("Ingresa un número como opcion");
        }
        switch (opcion) {
          case 1:
            Mascota mascota = agregarMascota();
            mascotas.add(mascota);
            System.out.println("Se agrego la Mascota");
          break; // Break caso 2.1: agregar mascota

          case 2:
            for(int i = 0;i < mascotas.size();i++)
              System.out.println(mascotas.get(i).toString());
          break;  // Break caso 2.2: ver mascotas

          case 3:
            System.out.println("Inserte el nombre de su mascota: ");
            try {
              input.nextLine();
              String nombreM = input.nextLine();
              mascota = buscarMascota(mascotas, nombreM);
              if(mascota == null){
                System.out.println("No hay ninguna mascota registrada con este nombre.");
                return;
              }
              System.out.println("Seleccione la opcion que quiera editar:\n" + "1.- Nombre de la mascota\n" + "2.- Edad\n" + "3.- Peso\n" 
              + "4.- Especie\n" + "5.- Raza\n" + "6.- Nombre del duenio\n" + "7.- Salir\n");
              
              opcion = input.nextInt();
              switch(opcion){
                case 1: editarNombre(mascota); break;
                case 2: editarEdad(mascota); break;
                case 3: editarPeso(mascota); break;
                case 4: editarEspecie(mascota); break;
                case 5: editarRaza(mascota); break;
                case 6: editarNombreDuenio(mascota); break;
                case 7: 
                  System.out.println("Saliendo del menu de edicion.");
                break;

                default:
                  System.out.println("Seleccione una opcion correcta");
                break;
              }
            } catch (InputMismatchException e){
              input.next();
              System.out.println("Nombre de mascota invalido.");
            }
          break;   // Break caso 2.3: editar mascota

          case 4:
            System.out.println("Inserte el nombre de su mascota: ");
            try {
              input.nextLine();
              String nombreM = input.nextLine();
              mascota = buscarMascota(mascotas, nombreM);
              if(mascota == null){
                System.out.println("No hay ninguna mascota registrada con este nombre.");
                return;
              }
              mascotas.remove(mascota);
            }catch (InputMismatchException e){
              input.next();
              System.out.println("Nombre de mascota invalido.");
            } 
          break;  // Break caso 2.4: eliminar mascota

          case 5:
            if(!mascotas.isEmpty()){
              System.out.println("Guardando datos de mascotas...");
              archivo.escribeMascota(mascotas);
              System.out.println("Datos guardados");
            }
            bandera = false;
            System.out.println("Saliendo del sistema...\nHasta pronto.");
          break;  // Break caso 2.5: salir

          default: 
            System.out.println("Por favor introduce una opcion valida");
          break;
        }
      } while(bandera);
      break; //BREAK CASO 2 SWITCH PRINCIPAL !!!!!!

      case 3:
        System.out.println("Adios :D.");
        bandera = false;
      break; //BREAK CASO 3

      default: 
        System.out.println("Por favor introduce una opcion valida");
      break; //BREAK DEFAULT 
    }
  }

  /**
  * Metodo para editar el nombre de la mascota
  * @param mascota -- La mascota que modificaremos
  */
  public void editarNombre(Mascota mascota){
    System.out.println("Escriba el nuevo nombre de su mascota: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga un nombre\n");
      return;
    }
    mascota.setNombre(nuevo);
    System.out.println("Se ha guardado el nombre.\n");
  }

  /**
  * Metodo para editar la edad de la mascota
  * @param mascota -- La mascota que modificaremos
  */
  public void editarEdad(Mascota mascota){
    System.out.println("Escriba la nueva edad de su mascota: \n");
    int nuevo = input.nextInt();
    if(nuevo <= 0 || nuevo > 100){
      System.out.println("Ponga una edad mayor a 0 y menor a 100\n");
      return;
    }
    mascota.setEdad(nuevo);
    System.out.println("Se ha guardado la edad.\n");
  }

  /**
  * Metodo para editar el peso de la mascota
  * @param mascota -- La mascota que modificaremos
  */
  public void editarPeso(Mascota mascota){
    System.out.println("Escriba el nuevo peso de su mascota: \n");
    int peso = input.nextInt();
    if(peso <= 0){
      System.out.println("Ponga el peso mayor a 0\n");
      return;
    }
    mascota.setPeso(peso);
    System.out.println("Se ha guardado el peso.\n");
  }

  /**
  * Metodo para editar la especie de la mascota
  * @param mascota -- La mascota que modificaremos
  */
  public void editarEspecie(Mascota mascota){
    System.out.println("Escriba la nueva especie de su mascota: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga una especie valida\n");
      return;
    }
    mascota.setEspecie(nuevo);
    System.out.println("Se ha guardado la especie.\n");
  }

  /**
  * Metodo para editar la raza de la mascota
  * @param mascota -- La mascota que modificaremos
  */
  public void editarRaza(Mascota mascota){
    System.out.println("Escriba la nueva raza de su mascota: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga una raza valida\n");
      return;
    }
    mascota.setRaza(nuevo);
    System.out.println("Se ha guardado la raza.\n");
  }

  /**
  * Metodo para editar el nombre del duenio de la mascota
  * @param mascota -- La mascota que modificaremos
  */
  public void editarNombreDuenio(Mascota mascota){
    System.out.println("Escriba el nuevo duenio de la mascota: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga un nombre valido\n");
      return;
    }
    mascota.setNombreDuenio(nuevo);
    System.out.println("Se ha guardado el nuevo duenio.\n");
  }

  /**
  * Metodo para buscar el nombre de una mascota
  * @param mascota -- La mascota a buscar
  * @param lista -- lista de las mascotas registradas
  * @return Mascota -- La mascota encontrada
  */
  public Mascota buscarMascota(ArrayList<Mascota> lista, String mascota){
    Mascota actual = new Mascota();
    ArrayList<Mascota> busqueda = new ArrayList<Mascota>();
    if(mascota.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String nombreActual = actual.getNombre();
        if(nombreActual.equals(mascota))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte la edad de su mascota\n");
      input.nextInt();
      int edad = input.nextInt();
      actual = buscarEdad(busqueda, edad);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar la edad de una mascota
  * @param mascota -- La mascota a buscar
  * @param lista -- lista de las mascotas registradas con el mismo nombre
  * @return Mascota -- La mascota encontrada
  */
  public Mascota buscarEdad(ArrayList<Mascota> lista, int mascota){
    Mascota actual = new Mascota();
    ArrayList<Mascota> busqueda = new ArrayList<Mascota>();
    if(mascota < 0 || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        int edadActual = actual.getEdad();
        if(edadActual == mascota)
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte el peso de su mascota\n");
      input.nextInt();
      int peso = input.nextInt();
      actual = buscarPeso(busqueda, peso);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar el peso de una mascota
  * @param mascota -- La mascota a buscar
  * @param lista -- lista de las mascotas registradas con el mismo nombre y edad
  * @return Mascota -- La mascota encontrada
  */
  public Mascota buscarPeso(ArrayList<Mascota> lista, int mascota){
    Mascota actual = new Mascota();
    ArrayList<Mascota> busqueda = new ArrayList<Mascota>();
    if(mascota < 0 || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        int pesoActual = actual.getPeso();
        if(pesoActual == mascota)
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte la especie de su mascota\n");
      input.nextLine();
      String especie = input.nextLine();
      actual = buscarEspecie(busqueda, especie);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }
  
  /**
  * Metodo para buscar la especie de una mascota
  * @param mascota -- La mascota a buscar
  * @param lista -- lista de las mascotas registradas con el mismo nombre, edad y peso
  * @return Mascota -- La mascota encontrada
  */
  public Mascota buscarEspecie(ArrayList<Mascota> lista, String mascota){
    Mascota actual = new Mascota();
    ArrayList<Mascota> busqueda = new ArrayList<Mascota>();
    if(mascota.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String especieActual = actual.getEspecie();
        if(especieActual.equals(mascota))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte la raza de su mascota\n");
      input.nextLine();
      String raza = input.nextLine();
      actual = buscarRaza(busqueda, raza);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar la raza de una mascota
  * @param mascota -- La mascota a buscar
  * @param lista -- lista de las mascotas registradas con el mismo nombre, edad, peso y especie
  * @return Mascota -- La mascota encontrada
  */
  public Mascota buscarRaza(ArrayList<Mascota> lista, String mascota){
    Mascota actual = new Mascota();
    ArrayList<Mascota> busqueda = new ArrayList<Mascota>();
    if(mascota.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String razaActual = actual.getRaza();
        if(razaActual.equals(mascota))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte el duenio de la mascota\n");
      input.nextLine();
      String duenio = input.nextLine();
      actual = buscarDuenio(busqueda, duenio);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar el duenio de la mascota
  * @param mascota -- La mascota a buscar
  * @param lista -- lista de las mascotas registradas con el mismo nombre, edad, peso, especie y raza
  * @return Mascota -- La mascota encontrada
  */
  public Mascota buscarDuenio(ArrayList<Mascota> lista, String mascota){
    Mascota actual = new Mascota();
    ArrayList<Mascota> busqueda = new ArrayList<Mascota>();
    if(mascota.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String duenioActual = actual.getNombreDuenio();
        if(duenioActual.equals(mascota))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado una copia de su mascota. Procedemos a eliminar la(s) copia(s).\n");
      for(int i = 1; i <= busqueda.size(); i++){
        mascotas.remove(actual);
      }
      return busqueda.get(0);
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para agregar una mascota
  * @return Mascota -- La mascota agregada
  */
  public Mascota agregarMascota(){
    input = new Scanner(System.in);
    String nombre, especie, raza, duenio;
    nombre = especie = raza = duenio = "";
    int edad, peso;
    edad = peso = 0;
    boolean continua;
    System.out.println("Ingresa el nombre de tu mascota\n");
    nombre = input.nextLine();
    //poner error?
    System.out.println("Ingresa la edad de tu mascota\n");
    do{
      try {
        continua = false;
        edad = input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Ingresa una edad valida");
        input.next();
        continua = true;
      }
    } while (continua);
    do{
      System.out.println("Ingresa el peso de tu mascota\n");
      try {
        continua = false;
        peso = input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Ingresa un peso valido");
        input.next();
        continua = true;
      }
    } while(continua);

    //nextLine vacio que el programa salta por el nextInt anterior
    input.nextLine();

    System.out.println("Ingresa la especie de tu mascota\n");
    especie = input.nextLine();
    
    System.out.println("Ingresa la raza de tu mascota\n");
    raza = input.nextLine();

    System.out.println("Ingresa tu nombre (nombre del duenio)\n");
    duenio = input.nextLine();

    Mascota mascota = new Mascota(nombre, edad, peso, especie, raza, duenio);
    return mascota;
  }
}
