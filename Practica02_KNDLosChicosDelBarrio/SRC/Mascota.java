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
    private String nombreDeDueño;
    /**
     * Constructor por omision
     */
    public Operador() {
        this.nombre = "Firulais";
        this.edad = 2;
        this.peso = 15;
        this.especie = "perro";
        this.raza = "pitbull";
        this.nombreDeDueño = "Rodrigo";
    }

    /**
     * Constructor por parametros que genera un Operador
     * @param nombre -- Nombre del Operador
     * @param apellidoP -- Apellido Paterno del Operador
     * @param apellidoM -- Apellido MAterno del Operador
     * @param fecha -- Fecha de Nacimiento del Operador
     * @param direccion -- DIrección del domimicilio del Operador
     * @param genero -- Genero del Operador puede ser M o F
     * @param gradoMaximo -- Grado Máximo de EStudios del Operador
     * @param telefono -- Telefono del Operador
     * @param horario -- Horario que labora el Operador
     * @param dias  -- Dias que labora el Operador
     */

    public Operador(String nombre, int edad, int peso, string especie, string raza, string nombreDeDueño) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.especie = especie;
        this.raza = raza;
        this.nombreDeDueño = nombreDeDueño;
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
    public String getEdad() {
        return edad;
    }
    /**
     * Metodo setAPellidoP que define el nuevo apellido del Operador
     * @param apellidoP -- El nuevo Apellido del Operador
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }


////////////////////////////////Falta cambiar desde aquí y todos los comentarios


    /**
     * Metodo getAPellidoM que obtiene el apellido Materno del Operador
     * @return apellidoM -- El apellido Materno del Operador
     */
    public String getApellidoM() {
        return apellidoM;
    }
    /**
     * Metodo setApellidoM que define el nuevo apellido materno del Operador
     * @param apellidoM  -- EL nuevo apellido materno del operador
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    /**
     * Metodo getFecha que obtiene la fecha de nacimiento del Operador
     * @return fecha -- La fecha de Nacimiento del Operador
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Metodo setFecha que define la nueva fecha de nacimiento del Opeardor
     * @param fecha -- La nueva fecha de nacimiento del operador
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
     * Metodo getDIreccion que obtiene la DIreccion del Domicilio del Operador
     * @return direccion -- La dirección del Operador
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Metodo setDireccion que define la nueva direccion del Domicilio del Operador
     * @param direccion -- La nueva dirección del operador
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Metodo getGenero que obtiene el genero del Operador
     * @return genero -- el genero del operador
     */
    public char getGenero() {
        return genero;
    }
    /**
     * Metodo setGenero que define el nuevo genero del Operador
     * @param genero -- El nuevo GEnero del Operador
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }
    /**
     * Metodo getGradoMaximo que obtiene el grado Maximo de estudios del operador
     * @return gradoMAximo -- El grado maximo que tiene el operador.
     */
    public String getGradoMaximo() {
        return gradoMaximo;
    }
    /**
     * Metodo setGradoMaximo que define el nuevo gradoMaximo del operador
     * @param gradoMaximo -- EL nuevo grado del operador.
     */
    public void setGradoMaximo(String gradoMaximo) {
        this.gradoMaximo = gradoMaximo;
    }
    /**
     * Metodo getTelefono que obtiene el telefono del operador
     * @return telefono -- EL telefono del operador
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Metodo setTelefono que define el nuevo telefono del Operador
     * @param telefono -- El nuevo telefono del operador
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * Metodo getHorario que obtiene el horario laboral del Operador
     * @return horario -- El horario laboral del trabajador
     */
    public String getHorario() {
        return horario;
    }
    /**
     * Metodo setHorario que define el nuevo horario laboral del operador
     * @param horario -- El nuevo horario laboral del operador
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }
    /**
     * Metodo getDias que obtiene los dias que labora el Operador
     * @return dias -- Los dias que labora el Operador
     */
    public String getDias() {
        return dias;
    }
    /**
     * Metodo setDias que define los nuevos dias que labora el Operador
     * @param dias -- Los nuevos dias que labora el Operador
     */
    public void setDias(String dias) {
        this.dias = dias;
    }

    /**
     * Metodo ToString de Operador
     * @return Regresa la representación de un operador para generar el CSV
     */
    @Override
    public String toString() {
        return this.nombre +","+this.apellidoP+","+this.apellidoM+","+this.fecha
                +","+this.direccion+","+this.genero+","+this.gradoMaximo+","+
                this.telefono+","+this.horario+","+this.dias;
    }



}
