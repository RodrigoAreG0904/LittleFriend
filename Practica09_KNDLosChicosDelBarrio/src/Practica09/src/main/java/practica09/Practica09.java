package practica09;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import practica09.Conexion.ConexionBD;
import practica09.Modelo.Duenio;
import practica09.Modelo.Mascota;
import practica09.Modelo.Estetica;
import practica09.Servicio.DuenioServicio;
import practica09.Servicio.EsteticaServicio;
import practica09.Servicio.MascotaServicio;

/**
 * Clase que ejecuta la aplicacion de java de escritorio
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class Practica09 {
    
    private static final String OPCIONES_TABLAS = "1 • Juega con la tabla Duenio.\n"
                                    + "2 • Juega con la tabla Estetica.\n"
                                    + "3 • Juega con la tabla Mascota.\n";
    
    private static final String OPCIONES_CRUD = "1 • Crea una nueva fila.\n"
                                    + "2 • Lee una fila.\n"
                                    + "3 • Actualiza una fila.\n"
                                    + "4 • Borra una fila.\n";

    public static void main(String[] pps) throws Exception {
        ConexionBD c = new ConexionBD();
        try {
            c.conectar();
            c.cerrar();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        System.out.println("BIENVENIDO!\nTe invitamos a probar las operaciones CRUD en nuestra practica!");
        System.out.println(OPCIONES_TABLAS);
        /* Definimos el tipo de usuario */
        switch (lee(1, 3)) {
            case 1:
                duenio();
                break;
            case 2:
                estetica();
                break;
            case 3:
                mascota();
                break;
            default:
                throw new IllegalStateException("Valor inesperado");
        }
    }
    
    public static void duenio() throws Exception {
        DuenioServicio duenioServicio = new DuenioServicio();
        String curp = "";
        int idEstetica = 0;
        String nombreDuenio = "";
        String apellidoPaternoDuenio = "";
        String apellidoMaternoDuenio = "";
        String correoDuenio = "";
        String estadoDuenio = "";
        String calleDuenio = "";
        int numeroDuenio = 0;
        int codigoPostalDuenio = 0;
        System.out.println("Escogiste Duenio! Ahora elige que operacion hacer:");
        System.out.println(OPCIONES_CRUD);
        switch (lee(1, 4)) {
            case 1:
                System.out.println("Por favor introduce el curp a buscar: ");
                curp = new Scanner(System.in).nextLine();
                System.out.println("Por favor introduce el idEstetica del duenio: ");
                idEstetica = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el nombre del duenio: ");
                nombreDuenio = leeCadena();
                System.out.println("Por favor introduce el apellidoPaterno del duenio: ");
                apellidoPaternoDuenio = leeCadena();
                System.out.println("Por favor introduce el apellidoMaterno del duenio: ");
                apellidoMaternoDuenio = leeCadena();
                System.out.println("Por favor introduce el calleDuenio del duenio: ");
                calleDuenio = leeCadena();
                System.out.println("Por favor introduce el numeroDuenio del duenio: ");
                numeroDuenio = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el codigoPostalDuenio del duenio: ");
                codigoPostalDuenio = Integer.parseInt(leeCadena());
                duenioServicio.insertarDuenio(new Duenio(curp, idEstetica, nombreDuenio, apellidoPaternoDuenio,
                        apellidoMaternoDuenio, correoDuenio, estadoDuenio, calleDuenio, numeroDuenio, codigoPostalDuenio));
                break;
            case 2:
                System.out.println("Por favor introduce el curp a buscar: ");
                curp = leeCadena();
                try {
                Duenio dn = duenioServicio.getDuenio(curp);
                System.out.println(dn.getNombreDuenio());
                } catch (NullPointerException npe) {
                    System.out.println("NO SE ENCONTRÓ EN LA BD!!!!!");
                }
                break;
            case 3:
                System.out.println("Por favor introduce el curp a buscar: ");
                curp = new Scanner(System.in).nextLine();
                System.out.println("Por favor introduce el idEstetica del duenio: ");
                idEstetica = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el nombre del duenio: ");
                nombreDuenio = leeCadena();
                System.out.println("Por favor introduce el apellidoPaterno del duenio: ");
                apellidoPaternoDuenio = leeCadena();
                System.out.println("Por favor introduce el apellidoMaterno del duenio: ");
                apellidoMaternoDuenio = leeCadena();
                System.out.println("Por favor introduce el calleDuenio del duenio: ");
                calleDuenio = leeCadena();
                System.out.println("Por favor introduce el numeroDuenio del duenio: ");
                numeroDuenio = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el codigoPostalDuenio del duenio: ");
                codigoPostalDuenio = Integer.parseInt(leeCadena());
                duenioServicio.actualizarDuenio(curp, new Duenio(curp, idEstetica, nombreDuenio, apellidoPaternoDuenio,
                        apellidoMaternoDuenio, correoDuenio, estadoDuenio, calleDuenio, numeroDuenio, codigoPostalDuenio));
                break;
            case 4:
                System.out.println("Por favor introduce el curp a buscar: ");
                curp = leeCadena();
                duenioServicio.borrarDuenio(curp);
                break;
            default:
                throw new IllegalStateException("Valor inesperado");
        }
    }
    
    private static void estetica() throws Exception {
        EsteticaServicio esteticaServicio = new EsteticaServicio();
        int idEstetica = 0;
        String nombre = "";
        long telefono = 0L;
        String horario = "";
        String apartado = "";
        int consultorios = 0;
        String estado = "";
        String calle = "";
        int numero = 0;
        int codigoPostal = 0;
        System.out.println("Escogiste Estetica! Ahora elige que operacion hacer:");
        System.out.println(OPCIONES_CRUD);
        switch (lee(1, 4)) {
            case 1:
                System.out.println("Por favor introduce el idEstetica de la estetica: ");
                idEstetica = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el nombre de la estetica: ");
                nombre = leeCadena();
                System.out.println("Por favor introduce el telefono de la estetica: ");
                telefono = Long.parseLong(leeCadena());
                System.out.println("Por favor introduce el horario de la estetica: ");
                horario =  leeCadena();
                System.out.println("Por favor introduce el apartado de la estetica: ");
                apartado = leeCadena();
                System.out.println("Por favor introduce el numero de consultorios de la estetica: ");
                consultorios =  Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el estado de la estetica: ");
                estado = leeCadena();
                System.out.println("Por favor introduce la calle de la estetica: ");
                calle = leeCadena();
                System.out.println("Por favor introduce el numero de la estetica: ");
                numero = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el codigoPostal de la estetica: ");
                codigoPostal = Integer.parseInt(leeCadena());
                esteticaServicio.insertarEstetica(new Estetica(idEstetica, nombre, telefono,
                        horario, apartado, consultorios, estado, calle, numero, codigoPostal));
                break;
            case 2:
                System.out.println("Por favor introduce el id a buscar: ");
                try {
                idEstetica = Integer.parseInt(leeCadena());
                esteticaServicio.getEstetica(idEstetica);
                } catch (NullPointerException npe) {
                    System.out.println("NO SE ENCONTRÓ EN LA BD!!!!!");
                }
                break;
            case 3:
                System.out.println("Por favor introduce el idEstetica de la estetica: ");
                idEstetica = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el nombre de la estetica: ");
                nombre = leeCadena();
                System.out.println("Por favor introduce el telefono de la estetica: ");
                telefono = Long.parseLong(leeCadena());
                System.out.println("Por favor introduce el horario de la estetica: ");
                horario =  leeCadena();
                System.out.println("Por favor introduce el apartado de la estetica: ");
                apartado = leeCadena();
                System.out.println("Por favor introduce el numero de consultorios de la estetica: ");
                consultorios =  Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el estado de la estetica: ");
                estado = leeCadena();
                System.out.println("Por favor introduce la calle de la estetica: ");
                calle = leeCadena();
                System.out.println("Por favor introduce el numero de la estetica: ");
                numero = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el codigoPostal de la estetica: ");
                codigoPostal = Integer.parseInt(leeCadena());
                esteticaServicio.actualizarEstetica(idEstetica, new Estetica(idEstetica, nombre, telefono,
                        horario, apartado, consultorios, estado, calle, numero, codigoPostal));
                break;
            case 4:
                try {
                idEstetica = Integer.parseInt(leeCadena());
                esteticaServicio.getEstetica(idEstetica);
                } catch (NullPointerException npe) {
                    System.out.println("NO SE ENCONTRÓ EN LA BD!!!!!");
                }
                break;
            default:
                throw new IllegalStateException("Valor inesperado");
        }
    }
    
    private static void mascota() throws Exception {
        MascotaServicio mascotaServicio = new MascotaServicio();
        String curp = "";
        int idMascota = 0;
        String nombre = "";
        String especie = "";
        String raza = "";
        String nombreDuenio = "";
        int edad = 0;
        int peso = 0;
        System.out.println("Escogiste Mascota! Ahora elige que operacion hacer:");
        System.out.println(OPCIONES_CRUD);
        switch (lee(1, 4)) {
            case 1:
                System.out.println("Por favor introduce el idMascota de la Mascota: ");
                idMascota = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el curp de la mascota: ");
                curp = leeCadena();
                System.out.println("Por favor introduce el nombre de la mascota: ");
                nombre = leeCadena();
                System.out.println("Por favor introduce la especie de la mascota: ");
                especie = leeCadena();
                System.out.println("Por favor introduce el raza de la mascota: ");
                raza = leeCadena();
                System.out.println("Por favor introduce el nombre del duenio de la mascota: ");
                nombreDuenio = leeCadena();
                System.out.println("Por favor introduce la edad de la mascota: ");
                edad = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el peso de la mascota: ");
                peso = Integer.parseInt(leeCadena());
                mascotaServicio.insertarMascota(new Mascota(idMascota, curp, nombre, especie,
                raza, nombreDuenio, edad, peso));
                break;
            case 2:
                System.out.println("Por favor introduce el id a buscar: ");
                try {
                idMascota = Integer.parseInt(leeCadena());
                mascotaServicio.getMascota(idMascota);
                } catch (NullPointerException npe) {
                    System.out.println("NO SE ENCONTRÓ EN LA BD!!!!!");
                }
                break;
            case 3:
                System.out.println("Por favor introduce el idMascota de la Mascota: ");
                idMascota = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el curp de la mascota: ");
                curp = leeCadena();
                System.out.println("Por favor introduce el nombre de la mascota: ");
                nombre = leeCadena();
                System.out.println("Por favor introduce la especie de la mascota: ");
                especie = leeCadena();
                System.out.println("Por favor introduce el raza de la mascota: ");
                raza = leeCadena();
                System.out.println("Por favor introduce el nombre del duenio de la mascota: ");
                nombreDuenio = leeCadena();
                System.out.println("Por favor introduce la edad de la mascota: ");
                edad = Integer.parseInt(leeCadena());
                System.out.println("Por favor introduce el peso de la mascota: ");
                peso = Integer.parseInt(leeCadena());
                mascotaServicio.actualizarMascota(idMascota, new Mascota(idMascota, curp, nombre, especie,
                raza, nombreDuenio, edad, peso));
                break;
            case 4:
                try {
                idMascota = Integer.parseInt(leeCadena());
                mascotaServicio.borrarMascota(idMascota);
                } catch (NullPointerException npe) {
                    System.out.println("NO SE ENCONTRÓ EN LA BD!!!!!");
                }
                break;
            default:
                throw new IllegalStateException("Valor inesperado");
        }
    }
    
    /**
     * Método que lee hasta que el usuario proporcione una opción válida
     *
     * @param cota_inferior El mínimo número válido
     * @param cota_superior El máximo número válido
     * @return El número entero leído por el scanner
     */
    private static int lee(int cota_inferior, int cota_superior) {
        int opcion = 0;
        boolean validacion = false;
        do {
            try {
                System.out.println("-----------------------------------------------------");
                System.out.print("Selecciona una opcion  --> ");
                opcion = new Scanner(System.in).nextInt();
                validacion = true;
            } catch (InputMismatchException ime) {
                System.out.println("Opción invalida! Introduzca sólo números!");
                validacion = false;
                continue;
            }
            if (opcion < cota_inferior || opcion > cota_superior) {
                System.out.println("Opción invalida! Introduzca un numero valido");
                validacion = false;
            }
        } while (!validacion);
        return opcion;
    }
    
    
    /**
     * Método que lee hasta que el usuario proporcione una opción válida
     *
     * @param cota_inferior El mínimo número válido
     * @param cota_superior El máximo número válido
     * @return El número entero leído por el scanner
     */
    private static String leeCadena() {
        String opcion = "";
        boolean validacion = false;
        do {
            try {
                opcion = new Scanner(System.in).nextLine();
                validacion = true;
            } catch (InputMismatchException ime) {
                System.out.println("Opción invalida! Introduzca sólo números!");
                validacion = false;
            }
        } while (!validacion);
        return opcion;
    }
}
