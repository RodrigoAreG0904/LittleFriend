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
    private String fecha;
    private String curp;
    private String direccion;
    private int telefono;
    private String tarjeta;
    private String correo;

    /**
     * Constructor por omision
     */
    public Duenio() {
        this.nombre = "Rodrigo";
        this.apellidoP = "Arevalo";
        this.apellidoM = "Gaytan";
        this.fecha = "01/02/03";
        this.curp = "ARGR010203";
        this.direccion = "Ciudad de Mexico, Calle, CP";
        this.telefono = 123456789;
        this.tarjeta = "123456789, 0102, Rodrigo Arevalo Gaytan";
        this.correo = "RodAreG@gmail.com";
    }

    /**
     * Constructor por parametros que genera un Duenio
     * @param nombre -- Nombre del Duenio
     * @param apellidoP -- Apellido Paterno del Duenio
     * @param apellidoM -- Apellido Materno del Duenio
     * @param fecha -- La fecha de Nacimiento del Duenio
     * @param curp -- CURP del Duenio
     * @param direccion -- direccion del Duenio
     * @param telefono -- Telefono del Duenio
     * @param tarjeta -- La Tarjeta del Duenio
     * @param correo -- El correo electrónico del Duenio
     */

    public Duenio(String nombre, String apellidoP, String apellidoM, String fecha, String curp,
                    String direccion, int telefono, String tarjeta, String correo) {
        this.nombre = nombre;
        this.apellidoP= apellidoP;
        this.apellidoM = apellidoM;
        this.fecha = fecha;
        this.curp = curp;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tarjeta = tarjeta;
        this.correo = correo;
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
     * Metodo getFecha que obtiene la fecha de nacimiento del Duenio
     * @return fecha -- La fecha de nacimiento del Duenio
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Metodo setFecha que define la nueva fecha de nacimiento del Duenio
     * @param fecha  -- La nueva fecha del Duenio
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
     * Metodo getTarjeta que obtiene la tarjeta del Duenio
     * @return tarjeta -- La tarjeta del Duenio
     */
    public String getTarjeta() {
        return tarjeta;
    }

    /**
     * Metodo setTarjeta que define la nueva tarjeta del Duenio
     * @param tarjeta  -- La nueva tarjeta del Duenio
     */
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * Metodo getCorreo que obtiene el correo electrónico del Duenio
     * @return correo -- El correo electrónico del Duenio
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo setCorreo que define el nuevo correo electrónico del Duenio
     * @param correo  -- EL nuevo correo electrónico del Duenio
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo ToString de Duenio
     * @return Regresa la representación de un Duenio para generar el CSV
     */
    @Override
    public String toString() {
        return this.nombre +", "+this.apellidoP+", "+this.apellidoM+", "+this.fecha+", "+this.curp
                +", "+this.direccion+", "+this.telefono+", "+this.tarjeta+", "+this.correo;
    }
    
}
