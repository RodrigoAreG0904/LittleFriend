package practica09.Modelo;

/**
 * Clase que modela a un Duenio
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class Duenio {
    private String curp;
    private int idEstetica;
    private String nombreDuenio;
    private String apellidoPaternoDuenio;
    private String apellidoMaternoDuenio;
    private String correoDuenio;
    private String estadoDuenio;
    private String calleDuenio;
    private int numeroDuenio;
    private int codigoPostalDuenio;

    /**
     * Constructor por parametros que crea un duenio
     * 
     * @param curp                  -- El CURP del duenio
     * @param nombreDuenio          -- El nombre del duenio
     * @param apellidoPaternoDuenio -- El apellido Paterno del duenio
     * @param apellidoMaternoDuenio -- El apellido Materno del duenio
     * @param correoDuenio          -- El correo electronico del duenio
     * @param estadoDuenio          -- El estado donde vive el duenio
     * @param calleDuenio           -- La calle donde vive el duenio
     * @param numeroDuenio          -- El numero donde vive el duenio
     * @param codigoPostalDuenio    -- El codigo postal donde vive el duenio
     */
    public Duenio(String curp, int idEstetica, String nombreDuenio, String apellidoPaternoDuenio,
            String apellidoMaternoDuenio, String correoDuenio,
            String estadoDuenio, String calleDuenio, int numeroDuenio, int codigoPostalDuenio) {
        this.curp = curp;
        this.idEstetica = idEstetica;
        this.nombreDuenio = nombreDuenio;
        this.apellidoPaternoDuenio = apellidoPaternoDuenio;
        this.apellidoMaternoDuenio = apellidoMaternoDuenio;
        this.correoDuenio = correoDuenio;
        this.estadoDuenio = estadoDuenio;
        this.calleDuenio = calleDuenio;
        this.numeroDuenio = numeroDuenio;
        this.codigoPostalDuenio = codigoPostalDuenio;
    }

    /**
     * Metodo getCurp que obtiene el curp
     * 
     * @return -- String el curp del duenio
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Metodo set que define un nuevo curp del duenio
     * 
     * @param curp -- El nuevo CURP
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Metodo getIdEstetica que obtiene el IdEstetica
     * 
     * @return -- int el idEstetica del duenio
     */
    public int getIdEstetica() {
        return idEstetica;
    }

    /**
     * Metodo set que define un nuevo idEstetica
     * 
     * @param idEstetica -- El nuevo idEstetica
     */
    public void setIdEstetica(int idEstetica) {
        this.idEstetica = idEstetica;
    }

    /**
     * Metodo get Nombre que obtiene el nombre del duenio
     * 
     * @return String -- el nombre del duenio
     */
    public String getNombreDuenio() {
        return nombreDuenio;
    }

    /**
     * Metodo set que define un nuevo nombre al duenio
     * 
     * @param nombreDuenio -- El nuevo nombre del duenio
     */
    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    /**
     * Metodo get que obtiene el apellido paterno del duenio
     * 
     * @return String -- el apellido paterno del duenio
     */
    public String getApellidoPaternoDuenio() {
        return apellidoPaternoDuenio;
    }

    /**
     * Metedo set que define un nuevo apellido paterno al duenio
     * 
     * @param apellidoPaternoDuenio -- El nuevo apellido paterno del duenio
     */
    public void setApellidoPaternoDuenio(String apellidoPaternoDuenio) {
        this.apellidoPaternoDuenio = apellidoPaternoDuenio;
    }

    /**
     * Metodo get que obtiene el apellido materno del duenio
     * 
     * @return String -- el apellido materno del duenio
     */
    public String getApellidoMaternoDuenio() {
        return apellidoMaternoDuenio;
    }

    /**
     * Metodo set que define un nuevo apellido materno del duenio
     * 
     * @param apellidoMaternoDuenio -- el nuevo apellido materno del duenio
     */
    public void setApellidoMaternoDuenio(String apellidoMaternoDuenio) {
        this.apellidoMaternoDuenio = apellidoMaternoDuenio;
    }

    /**
     * Metodo get que obtiene el correo electronico del duenio
     * 
     * @return String -- el correo del duenio
     */
    public String getCorreoDuenio() {
        return correoDuenio;
    }

    /**
     * Metodo set que define un nuevo correo del duenio
     * 
     * @param correoDuenio -- el nuevo correo del duenio
     */
    public void setCorreoDuenio(String correoDuenio) {
        this.correoDuenio = correoDuenio;
    }

    /**
     * Metodo get que obtiene el estado del duenio
     * 
     * @return String -- el estado donde vive el duenio
     */
    public String getEstadoDuenio() {
        return estadoDuenio;
    }

    /**
     * Metodo set que define un nuevo estado al duenio
     * 
     * @param estadoDuenio -- el nuevo estado del duenio
     */
    public void setEstadoDuenio(String estadoDuenio) {
        this.estadoDuenio = estadoDuenio;
    }

    /**
     * Metodo get que obtiene la calle del duenio
     * 
     * @return String -- la calle del duenio
     */
    public String getCalleDuenio() {
        return calleDuenio;
    }

    /**
     * Metodo set que define la nueva calle del duenio
     * 
     * @param calleDuenio -- la nueva calle donde vive el duenio
     */
    public void setCalle(String calleDuenio) {
        this.calleDuenio = calleDuenio;
    }

    /**
     * Metodo get que obtiene el numero del duenio
     * 
     * @return int -- el numero del duenio
     */
    public int getNumeroDuenio() {
        return numeroDuenio;
    }

    /**
     * Metodo set que define el nuevo numero del duenio
     * 
     * @param numeroDuenio -- el nuevo numero del duenio
     */
    public void setNumeroDuenio(int numeroDuenio) {
        this.numeroDuenio = numeroDuenio;
    }

    /**
     * Metodo get que obtiene el codigo postal del duenio
     * 
     * @return int -- el codigo postal del duenio
     */
    public int getCodigoPostalDuenio() {
        return codigoPostalDuenio;
    }

    /**
     * Metodo set que define el nuevo codigo postal del duenio
     * 
     * @param codigoPostalDuenio -- el nuevo codigo postal del duenio
     */
    public void setCodigoPostalDuenio(int codigoPostalDuenio) {
        this.codigoPostalDuenio = codigoPostalDuenio;
    }

    /**
     * Metodo toString que imprime un duenio
     * 
     * @return String -- lo que define a un duenio
     */
    @Override
    public String toString() {
        return "Duenio{" + "curp=" + curp + ", idEstetica=" + idEstetica + ", nombreDuenio=" + nombreDuenio
                + ", apellidoPaternoDuenio=" + apellidoPaternoDuenio
                + ", apellidoMaternoDuenio=" + apellidoMaternoDuenio + ", correoDuenio=" + correoDuenio
                + ", estadoDuenio=" + estadoDuenio +
                ", calleDuenio=" + calleDuenio + ", numeroDuenio=" + numeroDuenio + ", codigoPostalDuenio="
                + codigoPostalDuenio + "}";
    }

}