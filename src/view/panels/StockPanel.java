/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panels;

import dao.StockDao;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import models.Product;
import view.AddProductPopup;
import view.EditProductPopup;
import view.ProductDetailsPopup;

/**
 *
 * @author silva
 */
public class StockPanel extends javax.swing.JPanel {
    private final StockDao stock;
    private Object[][] data;
    private final String[] columnNames = {"Código", "Nome", "Preço (R$)", "Quantidade"};
    
    public StockPanel() {
        initComponents();
        this.stock = new StockDao();
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

    private void getData(){
        try{
            stock.load();
        } catch (ClassNotFoundException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o estoque.");
        }

        var products = stock.getProducts();
        data = new Object[products.size()][4];
        int i = 0;
        for(var p : products){
            data[i][0] = p.getCode();
            data[i][1] = p.getName();
            data[i][2] = p.getPrice();
            data[i][3] = p.getAmount();
            i++;
        }
    }
    
    private Product getSelectedProduct(){
        int i = table.getSelectedRow();
        if(i != -1){
            int code = (int) table.getValueAt(i, 0);
            return stock.getProduct(code);
        }
        else{
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado.");
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        details = new javax.swing.JButton();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        remove = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        details.setText("Ver Detalhes");
        details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsActionPerformed(evt);
            }
        });
        jPanel1.add(details);

        add.setText("Adicionar");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);

        edit.setText("Editar");
        edit.setToolTipText("");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit);

        remove.setText("Remover");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        var popup = new AddProductPopup();
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popup.setVisible(true);
        popup.setParent(this);
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        var product = getSelectedProduct();
        if(product != null){
            var popup = new EditProductPopup();
            popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            popup.setVisible(true);
            popup.setParent(this);
            popup.setSelectedProduct(product);
            popup.updateData();
        }
    }//GEN-LAST:event_editActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        var product = getSelectedProduct();
        if(product != null){
            int option = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "selecione uma opção", 0);
            if(option == 0){
                try{
                    if(stock.deleteProduct(product.getCode())){
                        stock.save();
                        updateTable();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Não foi possível remover o produto.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível remover o produto.");
                }
            }
        }
    }//GEN-LAST:event_removeActionPerformed

    private void detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsActionPerformed
        var product = getSelectedProduct();
        if(product != null){
            var popup = new ProductDetailsPopup();
            popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            popup.setVisible(true);
            popup.setParent(this);
            popup.setSelectedProduct(product);
            popup.updateData();
        }
    }//GEN-LAST:event_detailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton details;
    private javax.swing.JButton edit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton remove;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
