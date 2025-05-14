package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import model.facts.Cliente;
import model.facts.Producte;
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
    
    
    //Aqui podemos modificar el precio del prodcuto cuando el codigo sea el mismo del ya puesto.
    public void modificarProd(Producte Producte) throws SQLException {
        Connection c = conectar();
        String query = "UPDATE Producte set preu = ? WHERE codi = '" + Producte.getCodigo() + "';";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setDouble(1, Producte.getPrecio());
        ps.executeUpdate();
        ps.close();
        desconectar(c);

    }
    
    
    //Aqui insertamos al cliente cuando tenga los diferentes campos bien puestos.
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
    //Con este metodo revisamos en la base de datos si los clientes ya tienen un nif repetido
    //para poder verificar que no lo tienen.
    public boolean existCliente(Cliente Cliente) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select * from clientes where nif = '" + Cliente.getNif() + "';");
        boolean existe = rs.next();
        rs.close();
        desconectar(c);

        return existe;
    }
    
    //Aqui podemos llegar a seleccionar los clientes para poder añadirlos a la base de datos para poder
    //crear el query y poner los clientes en la base de datos.
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
    //Este meetodo lo usamos para poder insertar los campos seleccionados para poder insertalos y registrarlos en la base de datos
    //, depende si tienes tematica qu eponer o no, con el NULL VARCHAR se puede dejar vacio o llenar.
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
    //Aqui verificamos junto al codigo para saber si el producto existe dependiendo del codigo puesto en el 
    //registrar producto para poder verficiar si se repite y así, si ya hay uno igual al puesto por el usuario, se lenza una excepcion.
    public boolean existProducte(Producte producte) throws SQLException {
        Connection prod = conectar();
        Statement st = prod.createStatement();
        ResultSet rs = st.executeQuery("select * from producte where codi = '" + producte.getCodigo() + "';");
        boolean existe = rs.next();
        rs.close();
        desconectar(prod);
        return existe;
    }
//Este metodo se usa a la hora de inicar cualquier aparatado para poder conectarse a la base de datos, ponemos directamente 
    //el user y la contraseña para conectarse.
    private Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/registrefacts";
        String user = "root";
        String pass = "root";
        Connection c = DriverManager.getConnection(url, user, pass);
        return c;
    }
    
    //Sirve para poder cerrar cuando se acabe de rellenar en la base.
    private void desconectar(Connection c) throws SQLException {
        c.close();
    }
    
    //Utilizamos este para verificar que el codi del producto no sea igual y se pueda cmabiar en la base de datos.
    public boolean codiDevuelve(int nuevo) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select * from producte where codi = '" + nuevo + "';");
        boolean existe = rs.next();
        rs.close();
        desconectar(c);
        return existe;

    }
    //Utilizamos este metodo para cuando el nif sea igual y poder cambiarlo en la base de datos.
    public boolean letraDevuelve(String nuevo) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("select * from clientes where nif = '" + nuevo + "';");
        boolean existe = rs.next();
        rs.close();
        desconectar(c);
        return existe;

    }
}
