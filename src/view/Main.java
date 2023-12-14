/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Component;
import view.panels.NewProductPanel;

/**
 *
 * @author silva
 */
public class Main extends javax.swing.JFrame {
    public Main() {
        initComponents();
        display(new NewProductPanel());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NavigationBar = new javax.swing.JPanel();
        addProduct = new javax.swing.JButton();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        NavigationBar.setBackground(new java.awt.Color(204, 204, 204));

        addProduct.setText("Adicionar Produto");
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });
        NavigationBar.add(addProduct);

        getContentPane().add(NavigationBar, java.awt.BorderLayout.LINE_START);

        container.setLayout(new java.awt.CardLayout());
        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        display(new NewProductPanel());
    }//GEN-LAST:event_addProductActionPerformed
    
    private void display(Component panel){
        container.removeAll();
        container.add(panel);
        container.repaint();
        container.revalidate();
        panel.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NavigationBar;
    private javax.swing.JButton addProduct;
    private javax.swing.JPanel container;
    // End of variables declaration//GEN-END:variables
}
