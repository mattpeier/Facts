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


    private int codigo;
    private String producto;
    private double precio;
    private String tematica;
    private Cliente cliente;

    public Producte(int codigo, String producto, String tematica, double precio) {

        this.codigo = codigo;
        this.producto = producto;
        this.precio = precio;
        this.tematica = tematica;
        this.cliente = cliente;

    }

    public Producte(int codigo, double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }
    

    public Producte(int codigo) {
        this.codigo = codigo;
        this.producto = producto;
        this.precio = precio;
        this.tematica = tematica;
        this.cliente = cliente;

    }

    public Producte(int codigo, String producto, Cliente cliente) {
        this.codigo = codigo;
        this.producto = producto;
        this.precio = precio;
        this.cliente = cliente;

    }

    public String[] toArrayString() {
       
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
