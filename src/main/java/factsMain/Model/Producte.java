/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factsMain.Model;

/**
 *
 * @author hp
 */
public class Producte {
    
   private int codigo;
   private String producto;
   private double precio;

    public Producte(int codigo,String producto, double precio) {
        
        this.codigo = codigo;
        this.producto = producto;
        this.precio = precio;
        
        
    }

    public Producte(int codigo) {
        this.codigo = codigo;
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

      @Override
    public boolean equals(Object obj) {
        Producte p = (Producte) obj;
        return this.codigo==(p.getCodigo());
    }
}