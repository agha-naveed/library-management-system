package com.naveed.library_managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aghanaveed_
 */
public class report_form extends javax.swing.JInternalFrame {

    /**
     * Creates new form report_form
     */
    public report_form() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
        
        String databaseURL = "jdbc:ucanaccess://BookList.accdb";
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT Book_Name, Book_Author, CategoryID, Code, Qty, Entry_Date FROM BookList";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            DefaultTableModel model = (DefaultTableModel) report_form_table.getModel();
            
//            Search pr click krne se old wala remove hojaye
//            Delete from bottom to top
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
            
            while (rs.next()) {
                model.addRow(new Object[] {rs.getString("Book_Name"), rs.getString("Book_Author"), rs.getString("CategoryID"),
                    rs.getString("Code") , rs.getString("Qty"), rs.getDate("Entry_Date")});
                
            }
            
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        report_form_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(null);
        setFrameIcon(null);

        report_form_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        report_form_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Books", "Author", "Category", "Code", "Qty", "Entry Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(report_form_table);
        if (report_form_table.getColumnModel().getColumnCount() > 0) {
            report_form_table.getColumnModel().getColumn(0).setResizable(false);
            report_form_table.getColumnModel().getColumn(0).setPreferredWidth(150);
            report_form_table.getColumnModel().getColumn(1).setResizable(false);
            report_form_table.getColumnModel().getColumn(1).setPreferredWidth(150);
            report_form_table.getColumnModel().getColumn(2).setResizable(false);
            report_form_table.getColumnModel().getColumn(2).setPreferredWidth(150);
            report_form_table.getColumnModel().getColumn(3).setResizable(false);
            report_form_table.getColumnModel().getColumn(3).setPreferredWidth(80);
            report_form_table.getColumnModel().getColumn(4).setResizable(false);
            report_form_table.getColumnModel().getColumn(4).setPreferredWidth(30);
            report_form_table.getColumnModel().getColumn(5).setResizable(false);
            report_form_table.getColumnModel().getColumn(5).setPreferredWidth(90);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Report");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable report_form_table;
    // End of variables declaration//GEN-END:variables
}
