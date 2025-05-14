/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import view.menudigital.MenuDigital;
import controlador.excepcion.Controlador;
import controlador.excepcion.FactsException;
import model.facts.Cliente;
import model.facts.Producte;
import java.sql.SQLException;

/**
 *
 * @author alget
 */
public class Main {

    public static void main(String[] args)  {

        MenuDigital menu = new MenuDigital();
        menu.setVisible(true);
    }
}
