/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EjemploPractica2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Main que sirve de ejemplo para lo que van a entregar en la practica 2
 * @author Ricardo Badillo Macias
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
	ArrayList<Operador> operadores = new ArrayList<>();
        OperadorArchivo archivo = new OperadorArchivo();
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
                        System.out.println("Cargando datos de Operadores...");
                        try{
                        operadores = archivo.leeOperadores();
                        System.out.println("Listo...");
                        }catch(Exception e){
                             System.out.println(e);
                        }
                        do{
                            bandera = true;
                            System.out.println("Ingresa la opción deseada\n" + "1-Agregar Operador\n" + "2-Ver Operadores\n"
                            + "3-Editar Operador\n" + "4-Borrar Operador\n" + "5-Salir\n");
                            try {
                                opcion = input.nextInt();
                            } catch (InputMismatchException e) {
                                input.next();
                                System.out.println("Ingresa un número como opción");
                            }
                            if (opcion > 0 && opcion < 6) {
                                switch (opcion) {
                                    case 1:
                                        Operador operador = new Operador();
                                        operadores.add(operador);
                                        System.out.println("Se agrego el Operador");
				
                                    break;
                                    case 2:
                                        for(int i=0;i<operadores.size();i++){
                                            System.out.println(operadores.get(i).toString());
                                        }
                                    break;
                    
                                    case 3:
                                    break;
                    
                                    case 4:
                                    break;
					
                                    case 5:
                                        if(!operadores.isEmpty()){
                                            System.out.println("Guardando datos de operadores...");
                                            archivo.escribeOpeador(operadores);
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
                            System.out.println("Ingresa la opción deseada\n" + "1-Agregar Operador\n" + "2-Ver Operadores\n"
                            + "3-Editar Operador\n" + "4-Borrar Operador\n" + "5-Salir\n");
                            try {
                                opcion = input.nextInt();
                            } catch (InputMismatchException e) {
                                input.next();
                                System.out.println("Ingresa un número como opción");
                            }
                            if (opcion > 0 && opcion < 6) {
                                switch (opcion) {
                                    case 1:
                                        Operador operador = new Operador();
                                        operadores.add(operador);
                                        System.out.println("Se agrego el Operador");
				
                                    break;
                                    case 2:
                                        for(int i=0;i<operadores.size();i++){
                                            System.out.println(operadores.get(i).toString());
                                        }
                                    break;
                    
                                    case 3:
                                    break;
                    
                                    case 4:
                                    break;
					
                                    case 5:
                                        if(!operadores.isEmpty()){
                                            System.out.println("Guardando datos de operadores...");
                                            archivo.escribeOpeador(operadores);
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
