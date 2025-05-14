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
public class Cliente {

    private String nif;
    private String nom;
    private String direccio;
    private String numero;

    public Cliente(String nom, String direccio, String direccio1, String numero) {
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

    @Override
    public boolean equals(Object obj) {
        Cliente c = (Cliente) obj;
        return this.nif.equalsIgnoreCase(c.getNif());
    }

    public String[] toArrayString() {
        return new String[]{nif, nom, direccio, numero};
    }
    
    
}
