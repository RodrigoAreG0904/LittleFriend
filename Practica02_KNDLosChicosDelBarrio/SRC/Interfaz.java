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
public class Interfaz {

  private boolean bandera;
  private int opcion = 0;
  private Scanner input;

  public void interfazMascota() {
    input = new Scanner(System.in);
    ArrayList<Mascota> mascotas = new ArrayList<>();
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
          break;

          case 2:
            for(int i=0;i<mascotas.size();i++)
              System.out.println(mascotas.get(i).toString());
          break;

          case 3:
          //dejar que edite cada uno de los atributos de la mascota,
          //pero que haya una opcion para dejar el atributo que se le deja para editar como esta, hacer un mini menu para que elija que quiere editar, o si quiere editar todo.
          break;

          case 4:
          // metodo para buscar mascota y que todos los datos correspondan a una única mascota o que busque por diferentes
          // atributos y elija cual eliminar (le puede ir apareciendo las mascotas que corresponden con la busqueda)
          //mascotas.remove(mascota);
          //System.out.println("Se elimino la Mascota");
          break;

          case 5:
            if(!mascotas.isEmpty()) {
              System.out.println("Guardando datos de mascotas...");
              archivo.escribeMascota(mascotas);
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
          break;

          case 2:
            for(int i=0;i<mascotas.size();i++)
              System.out.println(mascotas.get(i).toString());
          break;

          case 3:
          break;

          case 4:
          break;

          case 5:
            if(!mascotas.isEmpty()){
              System.out.println("Guardando datos de mascotas...");
              archivo.escribeMascota(mascotas);
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
          //dejar que edite cada uno de los atributos de la duenio,
          //pero que haya una opcion para dejar el atributo que se le deja para editar como esta, hacer un mini menu para que elija que quiere editar, o si quiere editar todo.
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
