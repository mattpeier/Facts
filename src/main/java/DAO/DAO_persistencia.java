package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import factsModel.Cliente;
import factsModel.Producte;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class DAO_persistencia {

    public void modificarProd(Producte Producte) throws SQLException {
        Connection c = conectar();
        String query = "UPDATE Producte set preu = ? WHERE codi = '" + Producte.getCodigo() + "';";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setDouble(1, Producte.getPrecio());
        ps.executeUpdate();
        ps.close();
        desconectar(c);

    }

    public void insertCliente(Cliente Cliente) throws SQLException {
        Connection c = conectar();
        PreparedStatement ps = c.prepareStatement("insert into clientes values (?,?,?,?);");
        ps.setString(1, Cliente.getNif());
        ps.setString(2, Cliente.getNom());
        ps.setString(3, Cliente.getDireccio());
        ps.setString(4, Cliente.getNumero());
        ps.executeUpdate();
        ps.close();
        desconectar(c);
    }

    public boolean existCliente(Cliente Cliente) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select * from clientes where nif = '" + Cliente.getNif() + "';");
        boolean existe = rs.next();
        rs.close();
        desconectar(c);

        return existe;
    }

    public List<Cliente> selectAllCliente() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        Connection c = conectar();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select * from clientes");
        while (rs.next()) {
            String nif = rs.getString("nif");
            String nom = rs.getString("nombre");
            String direccio = rs.getString("direccio");
            String numero = rs.getString("numero");
            Cliente cliente = new Cliente(nif, nom, direccio, numero);
            clientes.add(cliente);
            rs.close();
            desconectar(c);
        }
        return clientes;
    } 

    public void insertProducte(Producte producte) throws SQLException {
        Connection prod = conectar();
        PreparedStatement ps = prod.prepareStatement("insert into producte values (?,?,?,?);");
        ps.setInt(1, producte.getCodigo());
        ps.setString(2, producte.getProducto());
        if (producte.getTematica() == null) {
            ps.setNull(3, java.sql.Types.VARCHAR);
        } else {
            ps.setString(3, producte.getTematica());
        }
        ps.setDouble(4, producte.getPrecio());

        ps.executeUpdate();
        ps.close();
        desconectar(prod);
    }

    public boolean existProducte(Producte producte) throws SQLException {
        Connection prod = conectar();
        Statement st = prod.createStatement();
        ResultSet rs = st.executeQuery("select * from producte where codi = '" + producte.getCodigo() + "';");
        boolean existe = rs.next();
        rs.close();
        desconectar(prod);
        return existe;
    }

    private Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/registrefacts";
        String user = "root";
        String pass = "root";
        Connection c = DriverManager.getConnection(url, user, pass);
        return c;
    }

    private void desconectar(Connection c) throws SQLException {
        c.close();
    }

    public boolean codiDevuelve(int nuevo) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select * from producte where codi = '" + nuevo + "';");
        boolean existe = rs.next();
        rs.close();
        desconectar(c);
        return existe;

    }
}
