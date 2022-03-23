/**
 * Clase que representa las Esteticas.
 * @author Rodrigo Arevalo Gaytan
 *	   Diana Berenice Hernández Alonso
 * 	   Julio Cesar Torres Escobedo
 *	   Santiago  Arroyo Lozano
 *	   Karyme Ivette Azpeitia Garcia
 * @version 17/03/2022
 */
public class Estetica {
    private String nombre;
    private String direccion;
    private int telefono;
    private String horario;

    /**
     * Constructor por omision
     */
    public Estetica() {
        this.nombre = "Rodrigo";
        this.direccion = "Ciudad de Mexico";
        this.telefono = 123456789;
        this.horario = "12:00-1:00";
    }

    /**
     * Constructor por parametros que genera una Estetica
     * @param nombre -- Nombre de la Estetica
     * @param direccion -- direccion de la Estetica
     * @param telefono -- Telefono de la Estetica
     * @param horario -- El horario de la Estetica
     */

    public Estetica(String nombre, String direccion, int telefono, String horario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
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
     * Metodo ToString de la Estetica
     * @return Regresa la representación de una Estetica para generar el CSV
     */
    @Override
    public String toString() {
        return this.nombre +", "+this.direccion+", "+this.telefono+", "+this.horario;
    }
}
