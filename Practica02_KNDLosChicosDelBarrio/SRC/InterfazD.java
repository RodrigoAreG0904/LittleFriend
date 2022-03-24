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
  private ArrayList<Duenio> duenios = new ArrayList<>();

    public void interfazDuenios() {
    input = new Scanner(System.in);
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
            Duenio duenio = agregarDuenio();
            duenios.add(duenio);
            archivo.escribeDuenio(duenios);
            System.out.println("Se agrego la Duenio");
          break;  // Break caso 1.1 = agregar duenio

          case 2:
            for(int i=0;i<duenios.size();i++)
              System.out.println(duenios.get(i).toString());
          break;  // Break caso 1.2 = ver duenio

          case 3:
            System.out.println("Inserte el nombre del duenio: ");
            try {
              String nombreD = input.nextLine();
              duenio = buscarDuenio(duenios, nombreD);
              if(duenio == null){
                System.out.println("No hay ningun duenio registrado con este nombre.");
                return;
              }
              System.out.println("Seleccione la opcion que quiera editar:\n" + "1.- Nombre del duenio\n" + "2.- Apellido Paterno\n" + "3.- Apellido Materno\n" 
              + "4.- Fecha\n" + "5.- CURP\n" + "6.- Direccion\n" + "7.- Telefono\n" + "8.- Tarjeta\n" + "9.- Correo\n" + "10.- Salir\n");
              
              opcion = input.nextInt();
              switch(opcion){
                case 1: editarNombre(duenio); break;
                case 2: editarApellidoP(duenio); break;
                case 3: editarApellidoM(duenio); break;
                case 4: editarFecha(duenio); break;
                case 5: editarCURP(duenio); break;
                case 6: editarDireccion(duenio); break;
                case 7: editarTelefono(duenio); break;
                case 8: editarTarjeta(duenio); break;
                case 9: editarCorreo(duenio); break;
                case 10: 
                  System.out.println("Saliendo del menu de edicion.");
                break;

                default:
                  System.out.println("Seleccione una opcion correcta");
                break;
              }
            } catch (InputMismatchException e){
              input.next();
              System.out.println("Nombre del duenio invalido.");
            }
          break;   // Break caso 1.3: editar duenio

          case 4:
            System.out.println("Inserte el nombre del duenio: ");
            try {
              input.nextLine();
              String nombreM = input.nextLine();
              duenio = buscarDuenio(duenios, nombreM);
              if(duenio == null){
                System.out.println("No hay ningun duenio registrado con este nombre.");
                return;
              }
              duenios.remove(duenio);
            }catch (InputMismatchException e){
              input.next();
              System.out.println("Nombre del duenio invalido.");
            } 
          break;  // Break caso 1.4: eliminar duenio

          case 5:
            if(!duenios.isEmpty()){
              System.out.println("Guardando datos de duenios...");
              archivo.escribeDuenio(duenios);
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
          break;  // Break caso 2.2: editar duenio

          case 3:
            System.out.println("Inserte el nombre del duenio: ");
            try {
              String nombreD = input.nextLine();
              duenio = buscarDuenio(duenios, nombreD);
              if(duenio == null){
                System.out.println("No hay ningun duenio registrado con este nombre.");
                return;
              }
              System.out.println("Seleccione la opcion que quiera editar:\n" + "1.- Nombre del duenio\n" + "2.- Apellido Paterno\n" + "3.- Apellido Materno\n" 
              + "4.- Fecha\n" + "5.- CURP\n" + "6.- Direccion\n" + "7.- Telefono\n" + "8.- Tarjeta\n" + "9.- Correo\n" + "10.- Salir\n");
              
              opcion = input.nextInt();
              switch(opcion){
                case 1: editarNombre(duenio); break;
                case 2: editarApellidoP(duenio); break;
                case 3: editarApellidoM(duenio); break;
                case 4: editarFecha(duenio); break;
                case 5: editarCURP(duenio); break;
                case 6: editarDireccion(duenio); break;
                case 7: editarTelefono(duenio); break;
                case 8: editarTarjeta(duenio); break;
                case 9: editarCorreo(duenio); break;
                case 10: 
                  System.out.println("Saliendo del menu de edicion.");
                break;

                default:
                  System.out.println("Seleccione una opcion correcta");
                break;
              }
            } catch (InputMismatchException e){
              input.next();
              System.out.println("Nombre del duenio invalido.");
            }
          break;  // Break caso 2.3: editar duenio

          case 4:
            System.out.println("Inserte el nombre del duenio: ");
            try {
              input.nextLine();
              String nombreM = input.nextLine();
              duenio = buscarDuenio(duenios, nombreM);
              if(duenio == null){
                System.out.println("No hay ningun duenio registrado con este nombre.");
                return;
              }
              duenios.remove(duenio);
            }catch (InputMismatchException e){
              input.next();
              System.out.println("Nombre del duenio invalido.");
            }
          break;  // Break caso 2.4: eliminar duenio

          case 5:
            if(!duenios.isEmpty()){
              System.out.println("Guardando datos de duenios...");
              archivo.escribeDuenio(duenios);
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

  /**
  * Metodo para editar el nombre del duenio
  * @param duenio -- El duenio que modificaremos
  */
  public void editarNombre(Duenio duenio){
    System.out.println("Escriba el nuevo nombre del duenio: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga un nombre\n");
      return;
    }
    duenio.setNombre(nuevo);
    System.out.println("Se ha guardado el nombre.\n");
  }

  /**
  * Metodo para editar el apellido paterno del duenio
  * @param duenio -- El duenio que modificaremos
  */
  public void editarApellidoP(Duenio duenio){
    System.out.println("Escriba el nuevo apellido paterno del duenio: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga un apellido paterno\n");
      return;
    }
    duenio.setApellidoP(nuevo);
    System.out.println("Se ha guardado el apellido paterno.\n");
  }

  /**
  * Metodo para editar el apellido materno del duenio
  * @param duenio -- El duenio que modificaremos
  */
  public void editarApellidoM(Duenio duenio){
    System.out.println("Escriba el nuevo apellido materno del duenio: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga un apellido materno\n");
      return;
    }
    duenio.setApellidoM(nuevo);
    System.out.println("Se ha guardado el apellido materno.\n");
  }

  /**
  * Metodo para editar la fecha del duenio
  * @param duenio -- El duenio que modificaremos
  */
  public void editarFecha(Duenio duenio){
    System.out.println("Escriba la nueva fecha del duenio: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga una fecha\n");
      return;
    }
    duenio.setFecha(nuevo);
    System.out.println("Se ha guardado la fecha.\n");
  }

  /**
  * Metodo para editar el CURP del duenio
  * @param duenio -- El duenio que modificaremos
  */
  public void editarCURP(Duenio duenio){
    System.out.println("Escriba el nuevo CURP del duenio: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga un CURP\n");
      return;
    }
    duenio.setCurp(nuevo);
    System.out.println("Se ha guardado el CURP.\n");
  }

  /**
  * Metodo para editar la direccion del duenio
  * @param duenio -- El duenio que modificaremos
  */
  public void editarDireccion(Duenio duenio){
    System.out.println("Escriba la nueva direccion del duenio: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga una direccion\n");
      return;
    }
    duenio.setDireccion(nuevo);
    System.out.println("Se ha guardado la direccion.\n");
  }

  /**
  * Metodo para editar el telefono del duenio
  * @param duenio -- El duenio que modificaremos
  */
  public void editarTelefono(Duenio duenio){
    System.out.println("Escriba el nuevo telefono del duenio: \n");
    int telefono = input.nextInt();
    if(telefono <= 0){
      System.out.println("Ponga el telefono con 10 digitos\n");
      return;
    }
    duenio.setTelefono(telefono);
    System.out.println("Se ha guardado el telefono.\n");
  }

  /**
  * Metodo para editar la tarjeta del duenio
  * @param duenio -- El duenio que modificaremos
  */
  public void editarTarjeta(Duenio duenio){
    System.out.println("Escriba la nueva tarjeta del duenio: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga una tarjeta\n");
      return;
    }
    duenio.setTarjeta(nuevo);
    System.out.println("Se ha guardado la tarjeta.\n");
  }

  /**
  * Metodo para editar el correo del duenio
  * @param duenio -- El duenio que modificaremos
  */
  public void editarCorreo(Duenio duenio){
    System.out.println("Escriba el correo del duenio: \n");
    String nuevo = input.nextLine();
    if(nuevo.equals("")){
      System.out.println("Ponga un correo\n");
      return;
    }
    duenio.setCorreo(nuevo);
    System.out.println("Se ha guardado el correo.\n");
  }


  /**
  * Metodo para buscar el nombre de duenio
  * @param duenio -- EL duenio a buscar
  * @param lista -- lista de los duenios registrados
  * @return Duenio -- El duenio encontrada
  */
  public Duenio buscarDuenio(ArrayList<Duenio> lista, String duenio){
    Duenio actual = new Duenio();
    ArrayList<Duenio> busqueda = new ArrayList<Duenio>();
    if(duenio.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String nombreActual = actual.getNombre();
        if(nombreActual.equals(duenio))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte el apellido paterno del duenio\n");
      input.nextLine();
      String apellidoP = input.nextLine();
      actual = buscarApellidoP(busqueda, apellidoP);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar el apellido paterno de duenio
  * @param duenio -- EL duenio a buscar
  * @param lista -- lista de los duenios registrados
  * @return Duenio -- El duenio encontrado
  */
  public Duenio buscarApellidoP(ArrayList<Duenio> lista, String duenio){
    Duenio actual = new Duenio();
    ArrayList<Duenio> busqueda = new ArrayList<Duenio>();
    if(duenio.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String apellidoP = actual.getApellidoP();
        if(apellidoP.equals(duenio))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte el apellido materno del duenio\n");
      input.nextLine();
      String apellidoM = input.nextLine();
      actual = buscarApellidoM(busqueda, apellidoM);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar el apellido materno del duenio
  * @param duenio -- EL duenio a buscar
  * @param lista -- lista de los duenios registrados
  * @return Duenio -- El duenio encontrado
  */
  public Duenio buscarApellidoM(ArrayList<Duenio> lista, String duenio){
    Duenio actual = new Duenio();
    ArrayList<Duenio> busqueda = new ArrayList<Duenio>();
    if(duenio.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String apellidoM = actual.getApellidoM();
        if(apellidoM.equals(duenio))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte la fecha del duenio\n");
      input.nextLine();
      String fecha = input.nextLine();
      actual = buscarFecha(busqueda, fecha);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar la fecha del duenio
  * @param duenio -- EL duenio a buscar
  * @param lista -- lista de los duenios registrados
  * @return Duenio -- El duenio encontrado
  */
  public Duenio buscarFecha(ArrayList<Duenio> lista, String duenio){
    Duenio actual = new Duenio();
    ArrayList<Duenio> busqueda = new ArrayList<Duenio>();
    if(duenio.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String fecha = actual.getFecha();
        if(fecha.equals(duenio))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte el CURP del duenio\n");
      input.nextLine();
      String curp = input.nextLine();
      actual = buscarCURP(busqueda, curp);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar la CURP del duenio
  * @param duenio -- EL duenio a buscar
  * @param lista -- lista de los duenios registrados
  * @return Duenio -- El duenio encontrado
  */
  public Duenio buscarCURP(ArrayList<Duenio> lista, String duenio){
    Duenio actual = new Duenio();
    ArrayList<Duenio> busqueda = new ArrayList<Duenio>();
    if(duenio.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String curp = actual.getCurp();
        if(curp.equals(duenio))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte la direccion del duenio\n");
      input.nextLine();
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
  * Metodo para buscar la direccion del duenio
  * @param duenio -- EL duenio a buscar
  * @param lista -- lista de los duenios registrados
  * @return Duenio -- El duenio encontrado
  */
  public Duenio buscarDireccion(ArrayList<Duenio> lista, String duenio){
    Duenio actual = new Duenio();
    ArrayList<Duenio> busqueda = new ArrayList<Duenio>();
    if(duenio.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String direccion = actual.getDireccion();
        if(direccion.equals(duenio))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte el telefono del duenio\n");
      input.nextInt();
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
  * Metodo para buscar el telefono del duenio
  * @param duenio -- EL duenio a buscar
  * @param lista -- lista de los duenios registrados
  * @return Duenio -- El duenio encontrado
  */
  public Duenio buscarTelefono(ArrayList<Duenio> lista, int duenio){
    Duenio actual = new Duenio();
    ArrayList<Duenio> busqueda = new ArrayList<Duenio>();
    if(duenio < 0 || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        int telefono = actual.getTelefono();
        if(telefono == duenio)
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte la tarjeta del duenio\n");
      input.nextLine();
      String tarjeta = input.nextLine();
      actual = buscarTarjeta(busqueda, tarjeta);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar la tarjeta del duenio
  * @param duenio -- EL duenio a buscar
  * @param lista -- lista de los duenios registrados
  * @return Duenio -- El duenio encontrado
  */
  public Duenio buscarTarjeta(ArrayList<Duenio> lista, String duenio){
    Duenio actual = new Duenio();
    ArrayList<Duenio> busqueda = new ArrayList<Duenio>();
    if(duenio.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String tarjeta = actual.getTarjeta();
        if(tarjeta.equals(duenio))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado mas de 1 resultado, por favor inserte el correo del duenio\n");
      input.nextLine();
      String correo = input.nextLine();
      actual = buscarCorreo(busqueda, correo);
      return actual;
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para buscar el correo del duenio
  * @param duenio -- EL duenio a buscar
  * @param lista -- lista de los duenios registrados
  * @return Duenio -- El duenio encontrado
  */
  public Duenio buscarCorreo(ArrayList<Duenio> lista, String duenio){
    Duenio actual = new Duenio();
    ArrayList<Duenio> busqueda = new ArrayList<Duenio>();
    if(duenio.equals("") || lista.isEmpty()){
      return null;
    }else{
      for(int i = 0; i < lista.size(); i++){
        actual = lista.get(i);
        String correo = actual.getCorreo();
        if(correo.equals(duenio))
          busqueda.add(actual);
      }
    }
    if(busqueda.size() > 1){
      System.out.println("Hemos encontrado una copia del duenio. Procedemos a eliminar la(s) copia(s).\n");
      for(int i = 1; i <= busqueda.size(); i++){
        duenios.remove(actual);
      }
      return busqueda.get(0);
    }else if(busqueda.isEmpty()){
      return null;
    }else{
      return busqueda.get(0);
    }
  }

  /**
  * Metodo para agregar un duenio
  * @return Duenio -- El Duenio agregado
  */
  public Duenio agregarDuenio(){
    input = new Scanner(System.in);
    String nombre, apellidoP, apellidoM, fecha, curp, direccion, tarjeta, correo;
    nombre = apellidoP = apellidoM = fecha = curp = direccion = tarjeta = correo = "";
    int telefono;
    telefono = 0;
    boolean continua;
    System.out.println("Ingresa el nombre del duenio\n");
    nombre = input.nextLine();
    //poner error?
    System.out.println("Ingresa el apellido paterno del duenio\n");
    apellidoP = input.nextLine();

    System.out.println("Ingresa el apellido materno del duenio\n");
    apellidoM = input.nextLine();

    System.out.println("Ingresa la fecha del duenio\n");
    fecha = input.nextLine();

    System.out.println("Ingresa el curp del duenio\n");
    curp = input.nextLine();

    System.out.println("Ingresa la direccion del duenio\n");
    direccion = input.nextLine();

    System.out.println("Ingresa el telefono del duenio\n");
    do{
      try {
        continua = false;
        telefono = input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Ingresa un telefono valida");
        input.next();
        continua = true;
      }
    } while (continua);
    

    //nextLine vacio que el programa salta por el nextInt anterior
    input.nextLine();

    System.out.println("Ingresa la tarjeta del duenio\n");
    tarjeta = input.nextLine();
    
    System.out.println("Ingresa el correo del duenio\n");
    correo = input.nextLine();

    Duenio duenio = new Duenio(nombre, apellidoP, apellidoM, fecha, curp, direccion, telefono, tarjeta, correo);
    return duenio;
  }

}