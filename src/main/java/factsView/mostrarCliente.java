/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package factsView;

import controladorRegistro.Controlador;
import factsModel.Cliente;
import factsModel.Producte;
import java.util.HashMap;
import javax.swing.JDialog;
import mainFacts.menuDigital;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class mostrarCliente extends javax.swing.JFrame {

    private Controlador controlador;
    private menuDigital menuDigital;
    private mostrarCliente estaVentana;
    private HashMap<Integer, Cliente> clientes;

    /**
     * Creates new form enProces
     */
    public mostrarCliente(menuDigital aThis, boolean modal) {
        
        mostrarCliente panel = new mostrarCliente(aThis, false);
        JDialog dialog = new JDialog();
        dialog.setContentPane(panel);
        dialog.pack();         
        dialog.setLocationRelativeTo(null);  
        dialog.setModal(true); 
        dialog.setVisible(true);
        initComponents();
        controlador = Controlador.getInstance();
        this.menuDigital = aThis;

        updateTable();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 400));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

public void updateTable() {
        clientes = (HashMap<Integer, Cliente>) Controlador.getInstance().getClientes();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"NIF", "Nom", "Precio", "tematica"});
        for (Cliente c : clientes.values()) {
            dtm.addRow(c.toArrayString());
        }
        jTable1.setModel(dtm);
    }
}