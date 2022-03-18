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
public class Operador {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String fecha;
    private String direccion;
    private char genero;
    private String gradoMaximo;
    private String telefono;
    private String horario;
    private String dias;
    /**
     * Constructor por omision
     */
    public Operador() {
        this.nombre = "Ricardo";
        this.apellidoP = "Badillo";
        this.apellidoM = "Macias";
        this.fecha = "12/06/1998";
        this.direccion = "1era Cerrada ...";
        this.genero = 'M';
        this.gradoMaximo = "Licenciatura";
        this.telefono = "55555555555";
        this.horario = "10am a 12pm";
        this.dias = "Lunes";
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
    
    public Operador(String nombre, String apellidoP, String apellidoM, String fecha, String direccion, char genero, String gradoMaximo, String telefono, String horario, String dias) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fecha = fecha;
        this.direccion = direccion;
        this.genero = genero;
        this.gradoMaximo = gradoMaximo;
        this.telefono = telefono;
        this.horario = horario;
        this.dias = dias;
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
    public String getApellidoP() {
        return apellidoP;
    }
    /**
     * Metodo setAPellidoP que define el nuevo apellido del Operador
     * @param apellidoP -- El nuevo Apellido del Operador
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    
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
