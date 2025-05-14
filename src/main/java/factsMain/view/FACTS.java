///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// */
//package factsMain.view;
//
//import Persistencia.Fitxero;
//import factsModel.Cliente;
//import factsModel.Producte;
//import factsModel.Servei;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
///**
// *
// * @author hp
// */
//public class FACTS {
//
//    private static AskData ask;
//    private static ArrayList<Producte> productes;
//    public static Scanner scanner = new Scanner(System.in);
//    private static ArrayList<Servei> serveis;
//    private static ArrayList<Cliente> clientes;
//    public static Fitxero fix;
//
//    public static void main(String[] args) throws IOException {
//        System.out.println("");
//        ask = new AskData();
//        productes = new ArrayList<>();
//        serveis = new ArrayList<>();
//        clientes = new ArrayList<>();
//        fix = new Fitxero();
//        productes = fix.readproducte();
//        clientes = fix.readCliente();
//
//        int opcion = 0;
//        do {
//            menuFack();
//            opcion = ask.askInt("Que vols fer avuí:  ", "Aquesta opció no es valida, posa una correcta.", 1, 10);
//            switch (opcion) {
//                case 1:
//                    registraProducto();
//                    break;
//                case 2:
//                    registrarClient();
//                    break;
//                case 3:
//                    cambiarPrecio();
//                    break;
//                case 4:
//                    System.out.println("Aquest apartata encara esta en proces. :)");
//                case 5:
//                    System.out.println("Aquest apartata encara esta en proces. :)");
//                case 6:
//                    System.out.println("Aquest apartata encara esta en proces. :)");
//                    break;
//                case 7:
//                    System.out.println("Aquest apartata encara esta en proces. :)");
//                    break;
//                case 8:
//                    System.out.println("Aquest apartata encara esta en proces. :)");
//                    break;
//                case 9:
//                    System.out.println("Aquest apartata encara esta en proces. :)");
//                    break;
//                case 10:
//                    System.out.println("Has sortit.");
//
//            }
//        } while (opcion != 10);
//
//    }
//
//    private static void menuFack() {
//        System.out.println("-------- Estampats Myck -------");
//        System.out.println("1. Registrar un nou producte.");
//        System.out.println("2. Registrar un nou client.");
//        System.out.println("3. Cambiar preu d'un producto.");
//        System.out.println("4. ***En proceso***.");
//        System.out.println("5. ***En proceso***.");
//        System.out.println("6. ***En proceso***.");
//        System.out.println("7. ***En proceso***.");
//        System.out.println("8. ***En proceso***.");
//        System.out.println("9. ***En proceso***.");
//        System.out.println("10. Sortir");
//        System.out.println("-------------------------------");
//
//    }
//
//    private static void registraProducto() throws IOException {
//        int codigo = ask.askInt("insereix el codi del producte: ", "Aquest codi no es valid.", 1, 10000);
//        if (productes.contains(new Producte(codigo))) {
//            System.out.println("Aquest codi ja esta utiliztat. ");
//        } else {
//            System.out.println("PRODUCTOS VALIDOS: \n"
//                    + "CAMISETASIMPLE\n"
//                    + "BOSSADETELA\n"
//                    + "FUNDADEMÓVIL\n"
//                    + "FUNDADETABLET");
//            String producto = ask.askProducto("Que producte registaras avuí? : ", "El prodcuto que quieres registrar no concuerda con nuestros datos, intenta-ho.", "CamisetaSimple", "Bossadetela", "Fundademóvil", "Fundadetablet");
//            double precio = ask.askDouble("Ingresa el preu de tu producte: ", "Ingresa el preu correctamente", 0);
//            String tematica = "";
//            Producte myProducte = new Producte(codigo, producto, precio, tematica);
//            productes.add(myProducte);
//            fix.writerProducteInFile(myProducte);
//        }
//    }
//
//    private static void registrarClient() throws IOException {
//        String nif = ask.askNif("Digam el nif del client a registrar: ");
//        if (clientes.contains(new Cliente(nif))) {
//            System.out.println("Este nif ya estaba registrado. ");
//        } else {
//            String nom = ask.askNif("Dime el nombre del cliente: ");
//            String direccio = ask.askString("Digam la localització per les seves entregues: ");
//            int numero = ask.askInt("Dime el numero de telefono: ", "Numero no valido. ", 100000000, 999999999);
//            Cliente myCliente = new Cliente(nif, nom, direccio, numero);
//            clientes.add(myCliente);
//            fix.writerCliente(myCliente);
//        }
//    }
//
//    private static void cambiarPrecio() throws IOException {
//        String nom = ask.askString("Que precio del producto deseas cambiar: ");
//        int total = 0;
//        for (Producte p : productes) {
//            if (p.getProducto().equalsIgnoreCase(nom)) {
//                double precioNuevo = ask.askDouble("Ingresa el preu nou de tu producte: ", "Ingresa el preu correctamente", 0);
//                p.setPrecio(precioNuevo);
//                total += 1;
//            }
//        }
//        if (total < 1) {
//            System.out.println("No hay ningun producte con ese nombre");
//        }
//        fix.ReescribirProducte(productes);
//    }
//
//    private static boolean elegirObjeto(String nombreProducto) {
//        for (Producte i : productes) {
//            if (i.getProducto().equalsIgnoreCase(nombreProducto)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
