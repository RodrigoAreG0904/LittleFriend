/**
 * Clase que representa las Mascotas.
 * @author Rodrigo Arevalo Gaytan
 * @author Diana Berenice Hernández Alonso
 * @author Julio Cesar Torres Escobedo
 * @author Santiago  Arroyo Lozano
 * @author Karyme Ivette Azpeitia Garcia
 * @version 17/03/2022
 */
public class Mascota {
    private String nombre;
    private int edad;
    private int peso;
    private String especie;
    private String raza;
    private String nombreDeDuenio;

    /**
     * Constructor por omision
     */
    public Mascota() {
        this.nombre = "Firulais";
        this.edad = 2;
        this.peso = 15;
        this.especie = "perro";
        this.raza = "pitbull";
        this.nombreDeDuenio = "Rodrigo";
    }

    /**
     * Constructor por parametros que genera una Mascota
     * @param nombre -- Nombre de la Mascota
     * @param edad -- Edad de la Mascota
     * @param peso -- Peso de la Mascota
     * @param especie -- Especie de la Mascota
     * @param raza -- Raza de la Mascota
     * @param nombreDeDuenio -- Nombre del dueño de la Mascota
     */

    public Mascota(String nombre, int edad, int peso, String especie, String raza, String nombreDeDuenio) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.especie = especie;
        this.raza = raza;
        this.nombreDeDuenio = nombreDeDuenio;
    }

    /**
    * Metodo getNombre que obtiene el nombre de la Mascota
    * @return nombre -- El nombre de la Mascota
    */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo setNombre que define el nuevo nombre de la Mascota
     * @param nombre -- El nuevo nombre de la Mascota
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo getEdad que obtiene la edad de la Mascota
     * @return edad -- La edad de la Mascota
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Metodo setEdad que define la nueva edad de la Mascota
     * @param edad -- La nueva edad de la Mascota
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Metodo getPeso que obtiene el peso de la Mascota
     * @return peso -- El peso de la Mascota
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Metodo setPeso que define el nuevo peso de la Mascota
     * @param peso  -- EL nuevo peso de la Mascota
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Metodo getEspecie que obtiene la especie de la Mascota
     * @return especie -- La especie de la Mascota
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Metodo setEspecie que define la nueva especie de la Mascota
     * @param especie -- La nueva especie de la Mascota
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * Metodo getRaza que obtiene la raza de la Mascota
     * @return raza -- La raza de la Mascota
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Metodo setRaza que define la nueva raza de la Mascota
     * @param raza -- La nueva raza de la Mascota
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Metodo getNombreDuenio que obtiene el nombre del duenio de la Mascota
     * @return nombreDeDuenio -- El nombre del duenio de la Mascota
     */
    public String getNombreDuenio() {
        return nombreDeDuenio;
    }

    /**
     * Metodo setNombreDuenio que define el nuevo nombre del duenio de la Mascota
     * @param nombreDeDuenio -- El nuevo nombre del duenio de la Mascota
     */
    public void setNombreDuenio(String nombreDeDuenio) {
        this.nombreDeDuenio = nombreDeDuenio;
    }

    /**
     * Metodo ToString de Mascota
     * @return Regresa la representación de una Mascota para generar el CSV
     */
    @Override
    public String toString() {
        return this.nombre +", "+this.edad+", "+this.peso+", "+this.especie
                +", "+this.raza+", "+this.nombreDeDuenio;
    }

}
