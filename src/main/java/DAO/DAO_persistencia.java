package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import factsModel.Producte;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class DAO_persistencia {

    public boolean existProducte(Producte producte) throws SQLException {
        Connection prod = conectar();
        Statement st = prod.createStatement();
        ResultSet rs = st.executeQuery("seelct * from prodcute where codi = '" + producte.getCodigo() + "';");
        boolean existe = rs.next();
        rs.close();
        return existe;

    }
    private Connection conectar() throws SQLException {
        String url = "jbdc:mysql://localhost:3306/consecionario";
        String user = "root";
        String pass = "root";
        Connection c = DriverManager.getConnection(url, user, pass);
        return c;
    }

    private void desconectar(Connection c) throws SQLException {
        c.close();

    }

}
