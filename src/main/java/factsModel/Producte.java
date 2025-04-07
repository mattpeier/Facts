/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factsModel;

import java.util.HashMap;

/**
 *
 * @author hp
 */
public class Producte {

    private static HashMap<String, Producte> productes = new HashMap<>();
    public static HashMap<String, Producte> getProductes() {
        return productes;
    }

    private int codigo;
    private String producto;
    private double precio;
    private String tematica;

    public Producte(int codigo, String producto, double precio, String tematica) {

        this.codigo = codigo;
        this.producto = producto;
        this.precio = precio;
        this.tematica = tematica;

    }

    public Producte(int codigo) {
        this.codigo = codigo;
        this.producto = producto;
        this.precio = precio;
        this.tematica = tematica;

    }

    public Producte(int codigo, String producto) {
        this.codigo = codigo;
        this.producto = producto;
        this.precio = precio;

    }

    public String[] toArrayString() {
        //String[] arrStrings = new String[4];
        //arrStrings[0]=Integer.toString(codigo);
        //arrStrings[1]= produto;
        //arrStrings[2]=Double.toString(precio);
        //arrStrings[3]= tematica;
        return new String[]{Integer.toString(codigo), producto, Double.toString(precio), tematica};
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // mateixa direcció de memòria.
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { // no son la mateixa classe
            return false;
        }
        Producte proToCompare = (Producte) obj; // si es un cotxe, encara que s'hagi de fer casting, comprovo matrícula
        if (codigo == 0) {
            // Això no hauria de passar mai, hauria de treure una excepció.
            return false;
        } else {
            return codigo == (proToCompare.codigo);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public String getProducto() {
        return producto;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTematica() {
        return tematica;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;

    }
}
