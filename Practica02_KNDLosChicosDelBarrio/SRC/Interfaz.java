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
public class Interfaz {
  
  public void hazInterfaz(String opcion){
    if(opcion.equals("Mascota")){
      ArrayList<Mascota> mascotas = new ArrayList<>();
      MascotaArchivo archivo = new MascotaArchivo();
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
            mascotas = archivo.leeMascotas();
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
                System.out.println("Se agrego la Mascota");
                break;
                
                case 2:
                for(int i=0;i<mascotas.size();i++){
                  System.out.println(mascotas.get(i).toString());
                  }
                break;
                
                case 3:
                //dejar que edite cada uno de los atributos de la mascota, 
                //pero que haya una opción para dejar el atributo que se le deja para editar como esta, hacer un mini menu para que elija que quiere editar, o si quiere editar todo.
                break;
                
                case 4:
                // metodo para buscar mascota y que todos los datos correspondan a una única mascota o que busque por diferentes 
                // atributos y elija cual eliminar (le puede ir apareciendo las mascotas que corresponden con la busqueda)
                mascotas.remove(mascota);
                System.out.println("Se elimino la Mascota");
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
                  break;
                }
              }
            }while(bandera);
            break;
            
            case 2:
            do{
              bandera = true;
              System.out.println("Ingresa la opción deseada\n" + "1-Agregar Mascota\n" + "2-Ver Mascotas\n"
              + "3-Editar Mascotas\n" + "4-Borrar Mascota\n" + "5-Salir\n");
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
                    System.out.println("Se agrego la Mascota");
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
                      archivo.escribeMascota(mascotas);
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
              }

    // Aqui el menu para esteticas
    if(opcion.equals("Estetica")){
            ArrayList<Estetica> esteticas = new ArrayList<>();
            EsteticaArchivo archivo = new EsteticaArchivo();
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
          System.out.println("Cargando datos de Esteticas...");
          try{
            esteticas = archivo.leeEsteticas();
            System.out.println("Listo...");
          }catch(Exception e){
            System.out.println(e);
          }
          do{
            bandera = true;
            System.out.println("Ingresa la opción deseada\n" + "1-Agregar Estetica\n" + "2-Ver Esteticas\n"
            + "3-Editar Estetica\n" + "4-Borrar Estetica\n" + "5-Salir\n");
            try {
              opcion = input.nextInt();
            } catch (InputMismatchException e) {
              input.next();
              System.out.println("Ingresa un número como opción");
            }
            if (opcion > 0 && opcion < 6) {
              switch (opcion) {
                case 1:
                Estetica estetica = new Estetica();
                esteticas.add(estetica);
                System.out.println("Se agrego la Estetica");
                break;
                
                case 2:
                for(int i=0;i<esteticas.size();i++){
                  System.out.println(esteticas.get(i).toString());
                  }
                break;
                
                case 3:
                //dejar que edite cada uno de los atributos de la estetica, 
                //pero que haya una opción para dejar el atributo que se le deja para editar como esta, hacer un mini menu para que elija que quiere editar, o si quiere editar todo.
                break;
                
                case 4:
                // metodo para buscar estetica y que todos los datos correspondan a una única estetica o que busque por diferentes 
                // atributos y elija cual eliminar (le puede ir apareciendo las esteticas que corresponden con la busqueda)
                esteticas.remove(estetica);
                System.out.println("Se elimino la Estetica");
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
                  break;
                }
              }
            }while(bandera);
            break;
            
            case 2:
            do{
              bandera = true;
              System.out.println("Ingresa la opción deseada\n" + "1-Agregar Estetica\n" + "2-Ver Esteticas\n"
              + "3-Editar Esteticas\n" + "4-Borrar Estetica\n" + "5-Salir\n");
              try {
                opcion = input.nextInt();
              } catch (InputMismatchException e) {
                input.next();
                System.out.println("Ingresa un número como opción");
              }
              if (opcion > 0 && opcion < 6) {
                switch (opcion) {
                  case 1:
                  Estetica estetica = new Estetica();
                  esteticas.add(estetica);
                  System.out.println("Se agrego la Estetica");
                  break;
                    
                  case 2:
                  for(int i=0;i<esteticas.size();i++){
                    System.out.println(esteticas.get(i).toString());
                  }
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
    }

    // aqui el menu para duenios
    if(opcion.equals("Duenio")){
      ArrayList<Duenio> duenios = new ArrayList<>();
      DuenioArchivo archivo = new DuenioArchivo();
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
        System.out.println("Cargando datos de Duenios...");
        try{
          duenios = archivo.leeDuenios();
          System.out.println("Listo...");
        }catch(Exception e){
          System.out.println(e);
        }
        do{
          bandera = true;
          System.out.println("Ingresa la opción deseada\n" + "1-Agregar Duenio\n" + "2-Ver Duenios\n"
          + "3-Editar Duenio\n" + "4-Borrar Duenio\n" + "5-Salir\n");
          try {
            opcion = input.nextInt();
          } catch (InputMismatchException e) {
            input.next();
            System.out.println("Ingresa un número como opción");
          }
          if (opcion > 0 && opcion < 6) {
            switch (opcion) {
            case 1:
            Duenio duenio = new Duenio();
            duenios.add(duenio);
            System.out.println("Se agrego la Duenio");
            break;

            case 2:
            for(int i=0;i<duenios.size();i++){
              System.out.println(duenios.get(i).toString());
            }
            break;

            case 3:
            //dejar que edite cada uno de los atributos de la duenio, 
            //pero que haya una opción para dejar el atributo que se le deja para editar como esta, hacer un mini menu para que elija que quiere editar, o si quiere editar todo.
            break;

            case 4:
            //metodo para buscar duenio y que todos los datos correspondan a una única duenio
            duenios.remove(duenio);
            System.out.println("Se elimino la Duenio");
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
            break;
            }
          }
        }while(bandera);
        break;

        case 2:
        do{
          bandera = true;
          System.out.println("Ingresa la opción deseada\n" + "1-Agregar Duenio\n" + "2-Ver Duenios\n"
          + "3-Editar Duenios\n" + "4-Borrar Duenio\n" + "5-Salir\n");
          try {
            opcion = input.nextInt();
          } catch (InputMismatchException e) {
            input.next();
            System.out.println("Ingresa un número como opción");
          }
          if (opcion > 0 && opcion < 6) {
            switch (opcion) {
            case 1:
            Duenio duenio = new Duenio();
            duenios.add(duenio);
            System.out.println("Se agrego la Duenio");
            break;

            case 2:
            for(int i=0;i<duenios.size();i++){
              System.out.println(duenios.get(i).toString());
            }
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
    }
  }
}
