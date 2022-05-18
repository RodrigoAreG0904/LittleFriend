package practica09.Modelo;

/**
 * Clase que modela a una Estetica
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class Estetica {
    private int idEstetica;
    private String nombre;
    private int telefono;
    private int horario;
    private String apartado;
    private int consultorios;
    private String estado;
    private String calle;
    private int numero;
    private int codigoPostal;

    /**
     * Constructor por parametros que crea una estetica
     * 
     * @param idEstetica   -- El idEstetica de la estetica
     * @param nombre       -- El nombre de la estetica
     * @param telefono     -- El telefono de la estetica
     * @param horario      -- El horario en que labora la estetica
     * @param apartado     -- El apartado de la estetica
     * @param consultorios -- Los consultorios que tiene la estetica
     * @param estado       -- El estado donde se encuentra la estetica
     * @param calle        -- La calle donde se encuentra la estetica
     * @param numero       -- El numero donde se encuentra la estetica
     * @param codigoPostal -- El codigo postal donde se encuentra la estetica
     */
    public Estetica(int idEstetica, String nombre, int telefono, int horario, String apartado,
            int consultorios, String estado, String calle, int numero, int codigoPostal) {
        this.idEstetica = idEstetica;
        this.nombre = nombre;
        this.telefono = telefono;
        this.horario = horario;
        this.apartado = apartado;
        this.consultorios = consultorios;
        this.estado = estado;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Metodo getIdEstetica que obtiene el IdEstetica
     * 
     * @return -- int el idEstetica de la estetica
     */
    public int getIdEstetica() {
        return idEstetica;
    }

    /**
     * Metodo set que define un nuevo idEstetica
     * 
     * @param idEstetica -- El nuevo idEstetica de la estetica
     */
    public void setIdEstetica(int idEstetica) {
        this.idEstetica = idEstetica;
    }

    /**
     * Metodo get Nombre que obtiene el nombre de la estetica
     * 
     * @return String -- el nombre de la estetica
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo set que define un nuevo nombre a la estetica
     * 
     * @param nombre -- El nuevo nombre de la estetica
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo getTelefono que obtiene el telefono de la estetica
     * 
     * @return -- int el telefono de la estetica
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Metodo set que define un nuevo telefono de la estetica
     * 
     * @param telefono -- El nuevo telefono de la estetica
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo get que obtiene el horario de la estetica
     * 
     * @return int -- el horario de la estetica
     */
    public int getHorario() {
        return horario;
    }

    /**
     * Metodo set que define un nuevo horario de la estetica
     * 
     * @param horario -- el nuevo horario de la estetica
     */
    public void setHorario(int horario) {
        this.horario = horario;
    }

    /**
     * Metodo get que obtiene el apartado de la estetica
     * 
     * @return String -- el apartado de la estetica
     */
    public String getApartado() {
        return apartado;
    }

    /**
     * Metodo set que define el nuevo apartado de la estetica
     * 
     * @param apartado -- el nuevo correo de la estetica
     */
    public void setApartado(String apartado) {
        this.apartado = apartado;
    }

    /**
     * Metodo get que obtiene los consultorios de la estetica
     * 
     * @return String -- los consultorios de la estetica
     */
    public int getConsultorios() {
        return consultorios;
    }

    /**
     * Metodo set que define los nuevos consultorios de la estetica
     * 
     * @param consultorios -- los nuevos consultorios de la estetica
     */
    public void setConsultorios(int consultorios) {
        this.consultorios = consultorios;
    }

    /**
     * Metodo get que obtiene el estado de la estetica
     * 
     * @return String -- el estado de la estetica
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo set que define el nuevo estado de la estetica
     * 
     * @param estado -- el nuevo estado de la estetica
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo get que obtiene la calle de la estetica
     * 
     * @return String -- la calle de la estetica
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Metodo set que define la nueva calle de la estetica
     * 
     * @param calle -- la nueva calle donde esta la estetica
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Metodo get que obtiene el numero de la estetica
     * 
     * @return int -- el numero de la estetica
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Metodo set que define el nuevo numero de la estetica
     * 
     * @param numero -- el nuevo numero de la estetica
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Metodo get que obtiene el codigo postal de la estetica
     * 
     * @return int -- el codigo postal de la estetica
     */
    public int getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Metodo set que define el nuevo codigo postal de la estetica
     * 
     * @param codigoPostal -- el nuevo codigo postal de la estetica
     */
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Metodo toString que imprime un duenio
     * 
     * @return String -- lo que define a un duenio
     */
    @Override
    public String toString() {
        return "Estetica{" + "idEstetica=" + idEstetica + ", nombre=" + nombre + ", telefono=" + telefono + ", horario="
                + horario
                + ", apartado=" + apartado + ", consultorios=" + consultorios + ", estado=" + estado +
                ", calle=" + calle + ", numero=" + numero + ", codigoPostal=" + codigoPostal + "}";
    }

}
