/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factsModel;

/**
 *
 * @author hp
 */
public class Cliente {
    
    private String nom;
    private String nif;
    private String direccio;
    private int numero;

    public Cliente(String nif, String nom, String direccio, int numero) {
        this.nom = nif;
        this.nif = nom;
        this.direccio = direccio;
        this.numero = numero;
    }

    public Cliente(String nif) {
        this.nif = nif;
    }
    

    public String getNom() {
        return nom;
    }

    public String getNif() {
        return nif;
    }

    public String getDireccio() {
        return direccio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
        @Override
    public boolean equals(Object obj) {
        Cliente c = (Cliente) obj;
        return this.nif.equalsIgnoreCase(c.getNif());
    }
    
}
