/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorRegistro;

import factsModel.Cliente;
import factsModel.Producte;
import mainFacts.menuDigital;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hp
 */
public class Controlador {

    private static Controlador controller;
    private  Map<Integer, Producte> productes;
    private static HashMap<String, Cliente> clients;
    
    private Controlador() {
        this.productes= new HashMap<Integer,Producte>();
    }
    
//Aqui podem instanciar el controlador i initsialitsarlo amb les altres clase
    public static Controlador getInstance() {
        if (controller == null) {
            controller = new Controlador();
        }
        return controller;
    }

    public  Map<Integer, Producte> getProductes() {
        return productes;
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

}
