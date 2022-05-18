/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica09.Servicio;

import java.util.List;

import practica09.Modelo.Operador;
import practica09.Repositorio.OperadorRepositorio;

/**
 * Clase que se encarga de hacer CRUD con los operadores
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class OperadorServicio {
    private OperadorRepositorio operadorRepositorio = new OperadorRepositorio();

    /**
     * Metodo que se encarga de obtener a todos los operadores
     * 
     * @return List<Operador> -- La lista de los operadores
     * @throws Exception -- En caso de que suceda algun error
     */
    public List<Operador> getOperadores() throws Exception {
        return operadorRepositorio.getOperadores();
    }

    /**
     * Metodo que se encarga de insertar un operador
     * 
     * @param operador -- EL operador a insertar
     * @throws Exception -- En caso de que suceda algun error
     */
    public void insertarOperador(Operador operador) throws Exception {
        operadorRepositorio.insertarOperador(operador);
    }

    /**
     * Metodo que se encarga de obtener un operador
     * 
     * @param curp -- El curp del operador a buscar
     * @throws Exception -- En caso de que ocurra algun error
     */
    public Operador getOperador(String curp) throws Exception {
        return operadorRepositorio.getOperador(curp);
    }

    /**
     * Metodo que actualiza un operador
     * 
     * @param curp     -- EL curp del operador a buscar
     * @param operador -- Los valores nuevos a actualizar
     * @throws Exception -- En caso de que ocurra algun error
     */
    public void actualizarOperador(String curp, Operador operador) throws Exception {
        operadorRepositorio.actualizarOperador(curp, operador);
    }

    /**
     * Metodo que borra un operador
     * 
     * @param curp -- El curp del operador a borrar
     * @throws Exception -- EN caso de que ocurra algun error
     */
    public void borrarOperador(String curp) throws Exception {
        operadorRepositorio.borrarOperador(curp);
    }
}
