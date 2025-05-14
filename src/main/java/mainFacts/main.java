/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainFacts;

import controladorRegistro.Controlador;
import controladorRegistro.FactsException;
import factsModel.Cliente;
import factsModel.Producte;
import java.sql.SQLException;

/**
 *
 * @author alget
 */
public class main {

    public static void main(String[] args) throws FactsException, SQLException {
        Controlador controlador = Controlador.getInstance();
        controlador.addProduct(new Producte(1, "Camiseta", 9.99, "Star Wars"));
        controlador.addProduct(new Producte(2, "Bossa", 5.00, "Marvel"));
        controlador.addCliente(new Cliente("53319061R", "Aroa", "Avenida Corazon", "685703376"));

        menuDigital menu = new menuDigital();
        menu.setVisible(true);
    }
}
