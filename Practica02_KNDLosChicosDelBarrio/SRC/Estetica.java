import java.util.ArrayList;

/**
 * Clase que representa las Esteticas.
 * @author Rodrigo Arevalo Gaytan
 * @author Diana Berenice Hernández Alonso
 * @author Julio Cesar Torres Escobedo
 * @author Santiago  Arroyo Lozano
 * @author Karyme Ivette Azpeitia Garcia
 * @version 17/03/2022
 */
public class Estetica {
    private String nombre;
    private String direccion;
    private int telefono;
    private String horario;
    private ArrayList<Integer> registroIngresos = new ArrayList<Integer>();
    private int gananciasTotales;

    /**
     * Constructor por omision
     */
    public Estetica() {
        this.nombre = "Rodrigo";
        this.direccion = "Ciudad de Mexico";
        this.telefono = 123456789;
        this.horario = "12:00-1:00";
        registroIngresos.add(5000);
        this.gananciasTotales = 5000;
    }

    /**
     * Constructor por parametros que genera una Estetica
     * @param nombre -- Nombre de la Estetica
     * @param direccion -- direccion de la Estetica
     * @param telefono -- Telefono de la Estetica
     * @param horario -- El horario de la Estetica
     * @param registroIngresos -- Los ingresos de la Estetica
     * @param gananciasTotales -- Los ingresos de la Estetica
     */

    public Estetica(String nombre, String direccion, int telefono, String horario, ArrayList<Integer> registroIngresos, int gananciasTotales) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
        this.registroIngresos = registroIngresos;
        this.gananciasTotales = gananciasTotales;
    }

    /**
    * Metodo getNombre que obtiene el nombre de la Estetica
    * @return nombre -- El nombre de la Estetica
    */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo setNombre que define el nuevo nombre de la Estetica
     * @param nombre -- El nuevo nombre de la Estetica
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo getDireccion que obtiene la direccion de la Estetica
     * @return direccion -- La direccion de la Estetica
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo setDireccion que define la nueva direccion de la Estetica
     * @param direccion -- La nueva direccion de la Estetica
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo getTelefono que obtiene el telefono de la Estetica
     * @return telefono -- El telefono de la Estetica
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Metodo setTelefono que define el nuevo telefono de la Estetica
     * @param telefono -- El nuevo telefono de la Estetica
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo getHorario que obtiene el horario de la Estetica
     * @return horario -- El horario de la Estetica
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Metodo setHorario que define el nuevo horario de la Estetica
     * @param horario -- El nuevo horario de la Estetica
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Metodo getIngresos que obtiene el registro de ingresos de la Estetica
     * @return registroIngresos -- Los ingresos de la Estetica
     */
    public ArrayList<Integer> getIngresos() {
        return registroIngresos;
    }

    /**
     * Metodo setIngresos que define el registro de ingresos de la Estetica
     * @param registroIngresos -- El nuevo ingreso de la Estetica
     */
    public void setIngresos(ArrayList<Integer> registroIngresos) {
        this.registroIngresos = registroIngresos;
    }

    /**
     * Metodo getGanancias que obtiene la suma de los ingresos de la lista registroIngresos de la Estetica
     * @return gananciasTotales -- La ganancia hasta el momento de la Estetica
     */
    public int getGanancias() {
        return gananciasTotales;
    }

    /**
     * Metodo setGanancias que define la ganancia total de la Estetica
     * (las ganancias totales se calcula por medio de la lista registroIngresos)
     */
    public void setGanancias() {
        int total=0;
        for(int i = 0; i < registroIngresos.size(); i++){
            total = total + registroIngresos.get(i);
        }
        this.gananciasTotales = total;
    }

    /**
     * Metodo ToString de la Estetica
     * @return Regresa la representación de una Estetica para generar el CSV
     */
    @Override
    public String toString() {
        return this.nombre +","+this.direccion+","+this.telefono+","+this.horario + "," + toStringRegistroIngresos() + "," + this.gananciasTotales;
    }

    /**
     * Metodo ToStringRegistroIngresos
     * @return Regresa la representación de la lista de ingresos
     */
    public String toStringRegistroIngresos() {
        if(registroIngresos.size() == 0){
            return "no hay ingresos";
        }
        String finalList = "";
        for(int i = 0; i < registroIngresos.size(); i++){
            finalList = finalList + registroIngresos.get(i) + ";";
        }
        return finalList;

    }

}
