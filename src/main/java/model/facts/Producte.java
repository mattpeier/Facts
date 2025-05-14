/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.facts;

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
    //Utilizando este meetodo vemos si el objecto en este caso repetido
    //Viendo esto se puede usar para comprobrar si el codigo puesto no se repite
    public boolean equals(Object obj) {
        if (this == obj) { // Se verifica en el campo.
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { // Aqui no son la misma clase.
            return false;
        }
        Producte proToCompare = (Producte) obj; // si es un prodcuto, se comprueba su codigo
        if (codigo == 0) {
            // Aqui si pasa se lanzaria una excepcion.
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
