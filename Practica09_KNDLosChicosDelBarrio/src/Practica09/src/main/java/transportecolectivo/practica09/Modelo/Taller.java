
package transportecolectivo.practica09.Modelo;

/**
 * Clase que modela a un Taller
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class Taller {
    private int id_Taller;
    private int numeroMecanicos;
    private String ciudad;
    private String calle;
    private int numero;
    private int cp;

    /**
     * Constructor por parametros de un taller
     * 
     * @param id_Taller       -- EL id del taller
     * @param numeroMecanicos -- El numero de mecanicos que dispone un taller
     * @param ciudad          -- La ciudad donde se ubica el taller
     * @param calle           -- La calle donde se ubica el taller
     * @param numero          -- El numero donde se ubica el taller
     * @param cp              -- EL codigo postal donde se ubica el taller
     */
    public Taller(int id_Taller, int numeroMecanicos, String ciudad, String calle, int numero, int cp) {
        this.id_Taller = id_Taller;
        this.numeroMecanicos = numeroMecanicos;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
    }

    /**
     * Metodo get que obtiene el id del taller
     * 
     * @return int -- el id del taller
     */
    public int getId_Taller() {
        return id_Taller;
    }

    /**
     * Metodo set que define una nueva id del taller
     * 
     * @param id_Taller -- el nuevo id del taller
     */
    public void setId_Taller(int id_Taller) {
        this.id_Taller = id_Taller;
    }

    /**
     * Metodo get que obtiene el numero de mecanicos del taller
     * 
     * @return int -- el numero de mecanicos
     */
    public int getNumeroMecanicos() {
        return numeroMecanicos;
    }

    /**
     * Metodo set que define un nuevo numero de mecanicos del taller
     * 
     * @param numeroMecanicos -- el nuevo numero de mecanicos
     */
    public void setNumeroMecanicos(int numeroMecanicos) {
        this.numeroMecanicos = numeroMecanicos;
    }

    /**
     * Metodo get que obtiene la ciudad del taller
     * 
     * @return String -- la ciudad del taller
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Metodo set que define una nueva ciudad del taller
     * 
     * @param ciudad -- la nueva ciudad del taller
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Metodo get que obtiene la calle del taller
     * 
     * @return String -- la calle del taller
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Metodo set que define la nueva calle del taller
     * 
     * @param calle -- la nueva calle del taller
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Metodo get que obtiene el numero del taller
     * 
     * @return int -- el numero del taller
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Metodo set que define un nuevo numero al taller
     * 
     * @param numero -- nuevo numero del taller
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Metodo get que obtiene el codigo postal del taller
     * 
     * @return int -- El codigo postal del taller
     */
    public int getCp() {
        return cp;
    }

    /**
     * Metodo set que define el nuevo codigo postal del taller
     * 
     * @param cp -- el nuevo codigo postal del taller
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * Metodo toString que imprime un taller
     * 
     * @return String -- la representacion de un taller
     */
    @Override
    public String toString() {
        return "Taller{" + "id_Taller=" + id_Taller + ", numeroMecanicos=" + numeroMecanicos + ", ciudad=" + ciudad
                + ", calle=" + calle + ", numero=" + numero + ", cp=" + cp + '}';
    }

}
