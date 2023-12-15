/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Component;
import view.panels.StockPanel;
import view.panels.TransactionsPanel;

/**
 *
 * @author silva
 */
public class Main extends javax.swing.JFrame {
    public Main() {
        initComponents();
        display(new StockPanel());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NavigationBar = new javax.swing.JPanel();
        Btns = new javax.swing.JPanel();
        stock = new javax.swing.JButton();
        Transactions = new javax.swing.JButton();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        NavigationBar.setBackground(new java.awt.Color(51, 102, 255));
        NavigationBar.setLayout(new java.awt.BorderLayout());

        Btns.setBackground(new java.awt.Color(102, 153, 255));
        Btns.setOpaque(false);

        stock.setText("Estoque");
        stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockActionPerformed(evt);
            }
        });

        Transactions.setText("Transações");
        Transactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransactionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BtnsLayout = new javax.swing.GroupLayout(Btns);
        Btns.setLayout(BtnsLayout);
        BtnsLayout.setHorizontalGroup(
            BtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Transactions, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(stock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        BtnsLayout.setVerticalGroup(
            BtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(Transactions, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(375, Short.MAX_VALUE))
        );

        NavigationBar.add(Btns, java.awt.BorderLayout.CENTER);

        getContentPane().add(NavigationBar, java.awt.BorderLayout.LINE_START);

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new java.awt.CardLayout());
        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockActionPerformed
        display(new StockPanel());
    }//GEN-LAST:event_stockActionPerformed

    private void TransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransactionsActionPerformed
        display(new TransactionsPanel());
    }//GEN-LAST:event_TransactionsActionPerformed
    
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
    private javax.swing.JPanel Btns;
    private javax.swing.JPanel NavigationBar;
    private javax.swing.JButton Transactions;
    private javax.swing.JPanel container;
    private javax.swing.JButton stock;
    // End of variables declaration//GEN-END:variables
}
