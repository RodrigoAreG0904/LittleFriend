import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Main de la practica 2
 * @author Rodrigo Arevalo Gaytan
 * @author Diana Berenice Hernández Alonso
 * @author Julio Cesar Torres Escobedo
 * @author Santiago  Arroyo Lozano
 * @author Karyme Ivette Azpeitia Garcia
 * @version 16/03/2022
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Interfaz interfaz = new Interfaz();
        int opcion = 0;
        boolean validacion = false;

        System.out.println("-----------------");
        System.out.println("Practica02 - Equipo KND");
        System.out.println("-----------------");
        System.out.println("1. Mascotas");
        System.out.println("2. Estetica");
        System.out.println("3. Duenios");
        System.out.print("Seleccionar una opcion  --> ");
        do {
            opcion = 0;
            validacion = true;
            try{
                opcion = input.nextInt();
            } catch(InputMismatchException ime){
                validacion = false;
                System.out.println("\nOpcion invalida.\nIntroduzca 1, 2 o 3.\n\n");
            }
            if(opcion < 1 || opcion > 3) {
                validacion = false;
                System.out.println("\nOpcion invalida.\nIntroduzca 1, 2 o 3.\n\n");
            }
        } while(!validacion);
        switch (opcion) {
            case 1: interfaz.interfazMascota();break;
            case 2: interfaz.interfazEstetica();break;
            case 3: interfaz.interfazDuenios();break;
        }
    }
}
