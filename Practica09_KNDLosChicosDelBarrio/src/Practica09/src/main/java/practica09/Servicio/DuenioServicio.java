/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica09.Servicio;

import java.util.List;

import practica09.Modelo.Duenio;
import practica09.Repositorio.DuenioRepositorio;

/**
 * Clase que se encarga de hacer CRUD con los duenios
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class DuenioServicio {
    private DuenioRepositorio duenioRepositorio = new DuenioRepositorio();

    /**
     * Metodo que se encarga de obtener a todos los duenios
     * 
     * @return List<Duenio> -- La lista de los duenios
     * @throws Exception -- En caso de que suceda algun error
     */
    public List<Duenio> getDuenios() throws Exception {
        return duenioRepositorio.getDuenios();
    }

    /**
     * Metodo que se encarga de insertar un duenio
     * 
     * @param duenio -- El duenio a insertar
     * @throws Exception -- En caso de que suceda algun error
     */
    public void insertarDuenio(Duenio duenio) throws Exception {
        duenioRepositorio.insertarDuenio(duenio);
    }

    /**
     * Metodo que se encarga de obtener un duenio
     * 
     * @param curp -- El curp del duenio a buscar
     * @throws Exception -- En caso de que ocurra algun error
     */
    public Duenio getDuenio(String curp) throws Exception {
        return duenioRepositorio.getDuenio(curp);
    }

    /**
     * Metodo que actualiza un duenio
     * 
     * @param curp   -- EL curp del duenio a buscar
     * @param duenio -- Los valores nuevos a actualizar
     * @throws Exception -- En caso de que ocurra algun error
     */
    public void actualizarDuenio(String curp, Duenio duenio) throws Exception {
        duenioRepositorio.actualizarDuenio(curp, duenio);
    }

    /**
     * Metodo que borra un duenio
     * 
     * @param curp -- El curp del duenio a borrar
     * @throws Exception -- EN caso de que ocurra algun error
     */
    public void borrarDuenio(String curp) throws Exception {
        duenioRepositorio.borrarDuenio(curp);
    }
}
