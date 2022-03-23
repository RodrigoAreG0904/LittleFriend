/**
 * Clase que representa los Duenios.
 * @author Rodrigo Arevalo Gaytan
 * @author Diana Berenice Hernández Alonso
 * @author Julio Cesar Torres Escobedo
 * @author Santiago  Arroyo Lozano
 * @author Karyme Ivette Azpeitia Garcia
 * @version 17/03/2022
 */
public class Duenio {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String curp;
    private String direccion;
    private int telefono;

    /**
     * Constructor por omision
     */
    public Duenio() {
        this.nombre = "Rodrigo";
        this.apellidoP = "Arevalo";
        this.apellidoM = "Gaytan";
        this.curp = "ARGR010203";
        this.direccion = "Ciudad de Mexico";
        this.telefono = 123456789;
    }

    /**
     * Constructor por parametros que genera un Duenio
     * @param nombre -- Nombre del Duenio
     * @param apellidoP -- Apellido Paterno del Duenio
     * @param apellidoM -- Apellido Materno del Duenio
     * @param curp -- CURP del Duenio
     * @param direccion -- direccion del Duenio
     * @param telefono -- Telefono del Duenio
     */

    public Duenio(String nombre, String apellidoP, String apellidoM, String curp,String direccion, int telefono) {
        this.nombre = nombre;
        this.apellidoP= apellidoP;
        this.apellidoM = apellidoM;
        this.curp = curp;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
    * Metodo getNombre que obtiene el nombre del Duenio
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
     * Metodo getApellidoP que obtiene el apellido paterno del Duenio
     * @return apellidoP -- El apellido paterno del Duenio
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * Metodo setApellidoP que define el nuevo apellido paterno del Duenio
     * @param apellidoP -- El nuevo apellido paterno del Duenio
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * Metodo getApellidoM que obtiene el apellido materno del Duenio
     * @return apellidoM -- El apellido materno del Duenio
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * Metodo setApellidoM que define el nuevo apellido materno del Duenio
     * @param apellidoM  -- EL nuevo apellido materno del Duenio
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * Metodo getCurp que obtiene el curp del Duenio
     * @return curp -- El curp del Duenio
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Metodo setCurp que define el nuevo curp del Duenio
     * @param curp -- El nuevo curp del Duenio
     */
    public void setCurp(String curp) {
        this.curp = curp;
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
     * Metodo ToString de Duenio
     * @return Regresa la representación de un Duenio para generar el CSV
     */
    @Override
    public String toString() {
        return this.nombre +", "+this.apellidoP+", "+this.apellidoM+", "+this.curp
                +", "+this.direccion+", "+this.telefono;
    }
    
}
