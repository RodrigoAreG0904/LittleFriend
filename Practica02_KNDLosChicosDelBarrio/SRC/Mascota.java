/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploPractica2;

/**
 * Clase que representa el Operador del Sistema de Transporte Colectivo.
 * @author Ricardo Badillo Macias
 * @version 16/03/2022
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
    public Operador() {
        this.nombre = "Firulais";
        this.edad = 2;
        this.peso = 15;
        this.especie = "perro";
        this.raza = "pitbull";
        this.nombreDeDuenio = "Rodrigo";
    }

    /**
     * Constructor por parametros que genera un Operador
     * @param nombre -- Nombre de la Mascota
     * @param edad -- Edad de la Mascota
     * @param peso -- Peso de la Mascota
     * @param especie -- Especie de la Mascota
     * @param raza -- Raza de la Mascota
     * @param nombreDeDuenio -- Nombre del dueño de la Mascota
     */

    public Operador(String nombre, int edad, int peso, string especie, string raza, string nombreDeDuenio) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.especie = especie;
        this.raza = raza;
        this.nombreDeDuenio = nombreDeDuenio;
    }

    /**
    * Metodo getNombre que obtiene el nombre del Operador
    * @return nombre -- El nombre del Operador
    */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo setNombre que define el nuevo nombre del Operador
     * @param nombre -- El nuevo nombre del Operador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo getApellidoP que obtiene el apellido Paterno del Operador
     * @return apellidoP -- El Apellido Paterno del Operador
     */
    public int getEdad() {
        return edad;
    }
    /**
     * Metodo setAPellidoP que define el nuevo apellido del Operador
     * @param apellidoP -- El nuevo Apellido del Operador
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /**
     * Metodo getAPellidoM que obtiene el apellido Materno del Operador
     * @return apellidoM -- El apellido Materno del Operador
     */
    public int getPeso() {
        return peso;
    }
    /**
     * Metodo setApellidoM que define el nuevo apellido materno del Operador
     * @param apellidoM  -- EL nuevo apellido materno del operador
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }
    /**
     * Metodo getFecha que obtiene la fecha de nacimiento del Operador
     * @return fecha -- La fecha de Nacimiento del Operador
     */
    public String getEspecie() {
        return especie;
    }
    /**
     * Metodo setFecha que define la nueva fecha de nacimiento del Opeardor
     * @param fecha -- La nueva fecha de nacimiento del operador
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    /**
     * Metodo getDIreccion que obtiene la DIreccion del Domicilio del Operador
     * @return direccion -- La dirección del Operador
     */
    public String getRaza() {
        return raza;
    }
    /**
     * Metodo setRaza que define la nueva raza de la Mascota
     * @param raza -- La nueva raza de la mascota
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }
    /**
     * Metodo getNombreDuenio que obtiene el nombre de duenio de la Mascota
     * @return nombreDeDuenio -- El nombre de duenio de la mascota
     */
    public String getNombreDuenio() {
        return nombreDeDuenio;
    }
    /**
     * Metodo setNombreDuenio que define el nuevo nombre de duenio de la Mascota
     * @param nombreDeDuenio -- El nuevo nombre de duenio de la Mascota
     */
    public void setNombreDuenio(String nombreDeDuenio) {
        this.nombreDeDuenio = nombreDeDuenio;
    }
    /**
     * Metodo ToString de Mascota
     * @return Regresa la representación de una mascota para generar el CSV
     */
    @Override
    public String toString() {
        return this.nombre +","+this.edad+","+this.peso+","+this.especie
                +","+this.raza+","+this.nombreDeDuenio;
    }



}
