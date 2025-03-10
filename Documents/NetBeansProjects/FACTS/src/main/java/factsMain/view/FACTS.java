/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package factsMain.view;

import Persistencia.Fitxero;
import factsMain.Model.Cliente;
import factsMain.Model.Producte;
import factsMain.Model.Servei;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class FACTS {

    private static AskData ask;
    private static ArrayList<Producte> productes;
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Servei> serveis;
    private static ArrayList<Cliente> clientes;
    public static Fitxero fix;

    public static void main(String[] args) throws IOException {

        ask = new AskData();
        productes = new ArrayList<>();
        serveis = new ArrayList<>();
        clientes = new ArrayList<>();
        fix = new Fitxero();
        productes = fix.readproducte();
        clientes = fix.readCliente();

        int opcion = 0;
        do {
            menuFack();
            opcion = ask.askInt("Que vols fer avuí:  ", "Aquesta opció no es valida, posa una correcta.", 1, 6);
            switch (opcion) {
                case 1:
                    registraProducto();
                    break;
                case 2:
                    registrarClient();
                    break;
                case 3:
                    cambiarPrecio();
                    break;
                case 4:
                    System.out.println("Aquest apartata encara esta en proces. :)");
                    break;
                case 5:
                    System.out.println("Has sortit.");

                    return;
            }
        } while (opcion != 5);

    }

    private static void menuFack() {
        System.out.println("-------- Estampats Myck -------");
        System.out.println("1. Registrar un nou producte.");
        System.out.println("2. Registrar un nou client.");
        System.out.println("3. Cambiar preu d'un producto.");
        System.out.println("4. ***En proceso***.");
        System.out.println("5. Sortir");
        System.out.println("-------------------------------");

    }

    private static void registraProducto() throws IOException {
        String producto = ask.askProducto("Que producte registaras avuí (ponlo sin espacios)? [CamisetaSimple | Bossadetela | Fundademóvil | Fundadetablet] : ", "El prodcuto que quieres registrar no concuerda con nuestros datos, intenta-ho.", "CamisetaSimple", "Bossadetela", "Fundademóvil", "Fundadetablet");
        double precio = ask.askDouble("Ingresa el preu de tu producte: ", "Ingresa el preu correctamente", 0);
        Producte myProducte = new Producte(producto, precio);
        productes.add(myProducte);
        fix.writerProducteInFile(myProducte);
        return;
    }

    private static void registrarClient() throws IOException {
        String nom = nomClient();
        String nif = ask.askNif("Digam el nif del client a registrar: ");
        String direccio = ask.askString("Digam la localització per les seves entregues: ");
        String numero = numeroTelefono();
        Cliente myCliente = new Cliente(nom, nif, direccio, numero);
        clientes.add(myCliente);
        fix.writerCliente(myCliente);
        return;
    }

    private static void cambiarPrecio() throws IOException {
        String nom = ask.askString("Que precio del producto deseas cambiar: ");
        int total = 0;
        for (Producte p : productes) {
            if (p.getProducto().equalsIgnoreCase(nom)) {
                double precioNuevo = ask.askDouble("Ingresa el preu nou de tu producte: ", "Ingresa el preu correctamente", 0);
                p.setPrecio(precioNuevo);
                total += 1;
            }
        }
        if (total <1){
            System.out.println("No hay ningun producte con ese nombre");
        }
        fix.ReescribirProducte(productes);
    }

    private static String numeroTelefono() {
        String numero = pedirNumero();
        System.out.println("El número de 9 dígitos ingresado es: " + numero);
        return numero;
    }

    public static String pedirNumero() {
        Scanner scanner = new Scanner(System.in);
        String numero = ask.askString("Dime numero de telefono: ");
        while (numero.length() != 9) {
            System.out.print("Por favor, introduce un número de 9 dígitos: ");
            numero = scanner.nextLine();
        }
        return numero;

    }

    private static String nomClient() {
        String nombre;
        boolean encontrado;
        do {
            System.out.println("Digam el nom del client que hi ha que registrar: ");
            nombre = scanner.nextLine();
            encontrado = (elegirObjeto(nombre));
            if (encontrado) {
                System.out.println("El client que has posat esta registrat, intenta-ho amb un altre.");
            }
        } while (encontrado);
        System.out.println("El client " + nombre + " ha sigut registrat.");
        return nombre;
    }

    private static boolean elegirObjeto(String nombreProducto) {
        for (Producte i : productes) {
            if (i.getProducto().equalsIgnoreCase(nombreProducto)) {
                return true;
            }
        }
        return false;
    }
}
