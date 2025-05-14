/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.excepcion;

import DAO.DAO_persistencia;
import model.facts.Cliente;
import model.facts.Producte;
import java.sql.SQLException;
import view.menudigital.MenuDigital;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hp
 */
public class Controlador {

    private static Controlador controller;
    private Map<Integer, Producte> productes;
    private Map<Integer, Cliente> clientes;

    // private static HashMap<String, Cliente> clients;
    private static DAO_persistencia dao;

    private Controlador() {
        this.productes = new HashMap<Integer, Producte>();
        this.clientes = new HashMap<Integer, Cliente>();
        dao = new DAO_persistencia();
    }

//Aqui podemos instaciar el controlador i inicializarlo con las otras clases.
    public static Controlador getInstance() {
        if (controller == null) {
            controller = new Controlador();
        }
        return controller;
    }
    
    //Este sirve para llamar a los productos agragados a este map
    public Map<Integer, Producte> getProductes() {
        return productes;
    }
    
    //este sirve para llamar a los clientes guardados en este map
    public Map<Integer, Cliente> getClientes() {
        return clientes;
    }
    //El codigo de producto que verifica si 
    public boolean comprobarCodi(int codigo) {
        return codigo >= 10000 && codigo <= 99999;

    }

    
    //Se checkea el codigo puesto para poder verificar si el codgio es acpetable.
    public boolean checkEnableAccept(int codigo) {
        throw new UnsupportedOperationException();
    }
    
    //Se usa este para poder lanzar la excepcion a la hora si existe el codigo insertado a la hora de añadir clietne
    //en el metodo creado en la persistencia.
    public void addCliente(Cliente Cliente) throws SQLException, FactsException {
        if (dao.existCliente(Cliente)) {
            throw new FactsException("Ya existe un cliente con este nif.");
        }
        dao.insertCliente(Cliente);
    }
    //Se usa este para poder lanzar la excepcion a la hora si existe el codigo insertado a la hora de añadir producto
    //en el metodo creado en la persistencia.
    public void addProducte(Producte Producte) throws SQLException, FactsException {
        if (dao.existProducte(Producte)) {
            throw new FactsException("Ya existe este producto con este codigo.");
        }
        dao.insertProducte(Producte);
    }
    //Aqui verificamos si el DAO de la base de datos existe ya algo con su codigo.

    public boolean existProducte(int num) throws SQLException, FactsException {
        if (dao.codiDevuelve(num)) {
            return true;
        } else {
            return false;
        }

    }
    //Aqui verificamos si el DAO de la base de datos existe ya alguien con su NIF.
    public boolean existCliente(String nif) throws SQLException {
        if (dao.letraDevuelve(nif)) {
            return true;
        } else {
            return false;
        }
    }
    //Utilizamos el DAO de la base de datos para poder modificar un proyecto.
    public void cambiarPrecio(Producte p) throws SQLException {
        dao.modificarProd(p);
        
    }

}
