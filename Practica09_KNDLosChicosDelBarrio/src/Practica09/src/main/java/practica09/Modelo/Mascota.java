package practica09.Modelo;

/**
 * Clase que representa las Mascotas.
 * 
 * @author Rodrigo Arevalo Gaytan
 * @author Diana Berenice Hernández Alonso
 * @author Julio Cesar Torres Escobedo
 * @author Santiago Arroyo Lozano
 * @version 17/05/2022
 */
public class Mascota {
    private int idMascota;
    private String curp;
    private String nombre;
    private String especie;
    private String raza;
    private String nombreDuenio;
    private int edad;
    private int peso;

    /**
     * Constructor por parametros que genera una Mascota
     * 
     * @param idMascota    -- El identificador de la Mascota
     * @param curp         -- El curp del duenio.
     * @param nombre       -- Nombre de la Mascota
     * @param especie      -- Especie de la Mascota
     * @param raza         -- Raza de la Mascota
     * @param nombreDuenio -- Nombre del dueño de la Mascota
     * @param edad         -- Edad de la Mascota
     * @param peso         -- Peso de la Mascota
     */

    public Mascota(int idMascota, String curp, String nombre, String especie, String raza, String nombreDuenio,
            int edad, int peso) {
        this.idMascota = idMascota;
        this.curp = curp;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.nombreDuenio = nombreDuenio;
        this.edad = edad;
        this.peso = peso;
    }

    /**
     * Metodo getIdMascota que obtiene el identificador de la Mascota
     * 
     * @return idMascota -- El identificador de la Mascota
     */
    public int getIdMascota() {
        return idMascota;
    }

    /**
     * Metodo setIdMascota que define el nuevo identificador de la Mascota
     * 
     * @param idMascota -- El nuevo identificador de la Mascota
     */
    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    /**
     * Metodo getCurp que obtiene el curp del duenio
     * 
     * @return curp -- El curp del duenio
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Metodo setCurp que define el nuevo curp del duenio
     * 
     * @param curp -- El nuevo curp del duenio
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Metodo getNombre que obtiene el nombre de la Mascota
     * 
     * @return nombre -- El nombre de la Mascota
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo setNombre que define el nuevo nombre de la Mascota
     * 
     * @param nombre -- El nuevo nombre de la Mascota
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo getEspecie que obtiene la especie de la Mascota
     * 
     * @return especie -- La especie de la Mascota
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Metodo setEspecie que define la nueva especie de la Mascota
     * 
     * @param especie -- La nueva especie de la Mascota
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * Metodo getRaza que obtiene la raza de la Mascota
     * 
     * @return raza -- La raza de la Mascota
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Metodo setRaza que define la nueva raza de la Mascota
     * 
     * @param raza -- La nueva raza de la Mascota
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Metodo getNombreDuenio que obtiene el nombre del duenio de la Mascota
     * 
     * @return nombreDuenio -- El nombre del duenio de la Mascota
     */
    public String getNombreDuenio() {
        return nombreDuenio;
    }

    /**
     * Metodo setNombreDuenio que define el nuevo nombre del duenio de la Mascota
     * 
     * @param nombreDeDuenio -- El nuevo nombre del duenio de la Mascota
     */
    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    /**
     * Metodo getEdad que obtiene la edad de la Mascota
     * 
     * @return edad -- La edad de la Mascota
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Metodo setEdad que define la nueva edad de la Mascota
     * 
     * @param edad -- La nueva edad de la Mascota
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Metodo getPeso que obtiene el peso de la Mascota
     * 
     * @return peso -- El peso de la Mascota
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Metodo setPeso que define el nuevo peso de la Mascota
     * 
     * @param peso -- EL nuevo peso de la Mascota
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Metodo ToString de Mascota
     * 
     * @return Regresa la representación de una Mascota para generar el CSV
     */
    @Override
    public String toString() {
        return "Mascota{" + "idMascota=" + idMascota + ", curp=" + curp + ", nombre=" + nombre + ", especie=" + especie
                + ", raza=" + raza
                + ", nombreDuenio=" + nombreDuenio + ", edad=" + edad + ", peso=" + peso + "}";
    }

}
