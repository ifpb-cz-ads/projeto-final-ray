/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panels;

import dao.TransactionDao;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.Transaction;
import view.AddProductPopup;
import view.AddPurchasePopup;
import view.AddSalePopup;
import view.TransactionDetailsPopup;

/**
 *
 * @author silva
 */
public class TransactionsPanel extends javax.swing.JPanel {
    private final TransactionDao dao;
    private Object[][] data;
    private final String[] columnNames = {"Código", "Valor (R$)", "Tipo", "Data"};
    
    public TransactionsPanel() {
        initComponents();
        this.dao = new TransactionDao();
        updateTable();
    }

    public void updateTable(){
        getData();
        
        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.repaint();
        table.revalidate();
    }
    
    private Transaction getSelectedTransaction(){
        int i = table.getSelectedRow();
        if(i != -1){
            int code = (int) table.getValueAt(i, 0);
            return dao.getTransaction(code);
        }
        else{
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado.");
            return null;
        }
    }

    private void getData(){
        try{
            dao.load();
        } catch (ClassNotFoundException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar as transações.");
            System.out.println(ex);
        }

        var transactions = dao.getTransactions();
        data = new Object[transactions.size()][4];
        int i = 0;
        for(var t : transactions){
            data[i][0] = t.getCode();
            data[i][1] = t.getTotalValue();
            data[i][2] = t.getType();
            data[i][3] = t.getDateTime().format(DateTimeFormatter.ISO_DATE);
            i++;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        details = new javax.swing.JButton();
        purchase = new javax.swing.JButton();
        sale = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        details.setText("Ver Detalhes");
        details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsActionPerformed(evt);
            }
        });
        jPanel1.add(details);

        purchase.setText("Adicionar Compra");
        purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseActionPerformed(evt);
            }
        });
        jPanel1.add(purchase);

        sale.setText("Adicionar Venda");
        sale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleActionPerformed(evt);
            }
        });
        jPanel1.add(sale);

        remove.setText("Remover");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void saleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleActionPerformed
        var popup = new AddSalePopup();
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popup.setVisible(true);
        popup.setParent(this);
    }//GEN-LAST:event_saleActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        var transaction = getSelectedTransaction();
        if(transaction != null){
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "selecione uma opção", 0);
            if(option == 0){
                try{
                    if(dao.deleteTransaction(transaction.getCode())){
                        dao.save();
                        updateTable();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Não foi possível remover a transação.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível remover a transação.");
                }
            }
        }
    }//GEN-LAST:event_removeActionPerformed

    private void purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseActionPerformed
        var popup = new AddPurchasePopup();
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popup.setVisible(true);
        popup.setParent(this);
    }//GEN-LAST:event_purchaseActionPerformed

    private void detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsActionPerformed
        var transaction = getSelectedTransaction();
        if(transaction != null){
            var popup = new TransactionDetailsPopup();
            popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            popup.setVisible(true);
            popup.setParent(this);
            popup.setSelectedTransaction(transaction);
            popup.updateData();
        }
    }//GEN-LAST:event_detailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton details;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton purchase;
    private javax.swing.JButton remove;
    private javax.swing.JButton sale;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
