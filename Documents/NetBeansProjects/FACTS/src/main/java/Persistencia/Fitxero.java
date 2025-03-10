/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import factsMain.Model.Cliente;
import factsMain.Model.Producte;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Fitxero {

    private String nameProducte = "productes.txt";
    private String nameCliente = "clientes.txt";
    private String nameFolder = "data";
    private String pathFolder;
    private String pathFileProducte;
    private String pathFileCliente;

    public Fitxero() throws IOException {
        pathFolder = "." + File.separator + nameFolder;
        pathFileProducte = pathFolder + File.separator + nameProducte;
        pathFileCliente = pathFolder + File.separator + nameCliente;

        File Folder = new File(pathFolder);
        if (!Folder.exists()) {
            Folder.mkdir();
        }
        File producte = new File(pathFileProducte);
        if (!producte.exists()) {
            producte.createNewFile();
        }
        
        File cliente = new File(pathFileCliente);
        if (!cliente.exists()) {
            cliente.createNewFile();

        }
    }

    public void writerProducteInFile(Producte myProducte) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileProducte, true));
        writer.write(myProducte.getProducto() + "/" + myProducte.getPrecio());
        writer.newLine();
        writer.close();
    }

    public ArrayList<Producte> readproducte(/*Producte myProducte*/) throws IOException {
        ArrayList<Producte> productes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(pathFileProducte));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("/");
            String producto = data[0];
            double precio = Double.parseDouble(data[1]);
            productes.add(new Producte(producto, precio));
        }
        return productes;
    }

    public void writerCliente(Cliente myCliente) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileCliente, true));
        writer.write(myCliente.getNom() + "/" + myCliente.getNif() + "/" + myCliente.getDireccio() + "/" + myCliente.getNumero());
        writer.newLine();
        writer.close();
    }

    public ArrayList<Cliente> readCliente(/*Cliente myCliente*/) throws IOException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(pathFileCliente));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("/");
            String nom = data[0];
            String nif = data[1];
            String direccio = data[2];
            String numero = data[3];
            clientes.add(new Cliente(nom, nif, direccio, numero));
        }
        return clientes;
    }
    
        public void ReescribirProducte(ArrayList<Producte> productes) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileProducte, false));
        for (Producte p : productes) {
            writerProducteInFile(p);
        }
        writer.close();
    }
}
