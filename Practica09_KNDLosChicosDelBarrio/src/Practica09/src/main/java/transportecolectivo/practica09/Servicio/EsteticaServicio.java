/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportecolectivo.practica09.Servicio;

import java.util.List;
import transportecolectivo.practica09.Modelo.Estetica;
import transportecolectivo.practica09.Repositorio.EsteticaRepositorio;

/**
 * Clase que se encarga de hacer CRUD con las esteticas
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class EsteticaServicio {
    private EsteticaRepositorio esteticaRepositorio = new EsteticaRepositorio();

    /**
     * Metodo que se encarga de obtener a todas las esteticas
     * 
     * @return List<Estetica> -- La lista de las esteticas
     * @throws Exception -- En caso de que suceda algun error
     */
    public List<Estetica> getEsteticas() throws Exception {
        return esteticaRepositorio.getEsteticas();
    }

    /**
     * Metodo que se encarga de insertar una estetica
     * 
     * @param estetica -- La estetica a insertar
     * @throws Exception -- En caso de que suceda algun error
     */
    public void insertarEstetica(Estetica estetica) throws Exception {
        esteticaRepositorio.insertarEstetica(estetica);
    }

    /**
     * Metodo que se encarga de obtener una estetica
     * 
     * @param idEstetica -- El id de la estetica a buscar
     * @throws Exception -- En caso de que ocurra algun error
     */
    public Estetica getEstetica(int idEstetica) throws Exception {
        return esteticaRepositorio.getEstetica(idEstetica);
    }

    /**
     * Metodo que actualiza una estetica
     * 
     * @param idEstetica -- EL id de la estetica a buscar
     * @param estetica   -- Los valores nuevos a actualizar
     * @throws Exception -- En caso de que ocurra algun error
     */
    public void actualizarEstetica(int idEstetica, Estetica estetica) throws Exception {
        esteticaRepositorio.actualizarEstetica(idEstetica, estetica);
    }

    /**
     * Metodo que borra una estetica
     * 
     * @param idEstetica -- El id de la estetica a borrar
     * @throws Exception -- EN caso de que ocurra algun error
     */
    public void borrarEstetica(int idEstetica) throws Exception {
        esteticaRepositorio.borrarEstetica(idEstetica);
    }
}
