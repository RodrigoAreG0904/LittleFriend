/**
 * Clase que representa los Duenios.
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
     * Constructor por parametros que genera un Duenio
     * @param nombre -- Nombre del Duenio
     * @param direccion -- direccion del Duenio
     * @param telefono -- Telefono del Duenio
     * @param horario -- El horario de la Estetica
     */

    public Estetica(String nombre, String direccion, int telefono, String horario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
    }

    /**
    * Metodo getNombre que obtiene el nombre de la Duenio
    * @return nombre -- El nombre del Duenio
    */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo setNombre que define el nuevo nombre del Duenio
     * @param nombre -- El nuevo nombre del Duenio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo getDireccion que obtiene la direccion del Duenio
     * @return direccion -- La direccion del Duenio
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo setDireccion que define la nueva direccion del Duenio
     * @param direccion -- La nueva direccion del Duenio
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo getTelefono que obtiene el telefono del Duenio
     * @return telefono -- El telefono del Duenio
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Metodo setTelefono que define el nuevo telefono del Duenio
     * @param telefono -- El nuevo telefono del Duenio
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo getDireccion que obtiene la direccion del Duenio
     * @return direccion -- La direccion del Duenio
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Metodo setDireccion que define la nueva direccion del Duenio
     * @param direccion -- La nueva direccion del Duenio
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Metodo ToString de Duenio
     * @return Regresa la representación de un Duenio para generar el CSV
     */
    @Override
    public String toString() {
        return this.nombre +","+","+this.direccion+","+this.telefono+","+this.horario;
    }
}
