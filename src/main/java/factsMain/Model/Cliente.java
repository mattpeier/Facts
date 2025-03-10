/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factsMain.Model;

/**
 *
 * @author hp
 */
public class Cliente {
    
    private String nom;
    private String nif;
    private String direccio;
    private String numero;

    public Cliente(String nom, String nif, String direccio, String numero) {
        this.nom = nom;
        this.nif = nif;
        this.direccio = direccio;
        this.numero = numero;
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

    public String getNumero() {
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

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
