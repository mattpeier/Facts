/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorRegistro;

import DAO.DAO_persistencia;
import factsModel.Cliente;
import factsModel.Producte;
import java.sql.SQLException;
import mainFacts.menuDigital;
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

//Aqui podem instanciar el controlador i initsialitsarlo amb les altres clase
    public static Controlador getInstance() {
        if (controller == null) {
            controller = new Controlador();
        }
        return controller;
    }

    public Map<Integer, Producte> getProductes() {
        return productes;
    }
    
    public Map<Integer, Cliente> getClientes() {
        return clientes;
    }

    public boolean comprobarCodi(int codigo) {
        return codigo >= 10000 && codigo <= 99999;

    }

    public void addProduct(Producte producte) {
        productes.put(producte.getCodigo(), producte);
    }

    public boolean checkEnableAccept(int codigo) {
        throw new UnsupportedOperationException();
    }

    public void addCliente(Cliente Cliente) throws SQLException, FactsException {
        if (dao.existCliente(Cliente)) {
            throw new FactsException("Ya existe un cliente con este nif.");
        }
        dao.insertCliente(Cliente);
    }

    public void addProducte(Producte Producte) throws SQLException, FactsException {
        if (dao.existProducte(Producte)) {
            throw new FactsException("Ya existe este producto con este codigo.");
        }
        dao.insertProducte(Producte);
    }

    public boolean existProducte(int num) throws SQLException, FactsException {
        if (dao.codiDevuelve(num)) {
            return true;
        } else {
            return false;
        }

    }

    public void cambiarPrecio(int codigo, double precioNuevo) {
        Producte p = productes.get(codigo);
        if (p != null) {
            p.setPrecio(precioNuevo);
        }
    }

}
