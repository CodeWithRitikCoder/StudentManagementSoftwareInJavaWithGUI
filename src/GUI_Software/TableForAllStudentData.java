/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_Software;

import java.awt.Color;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author codew
 */
public class TableForAllStudentData extends javax.swing.JFrame {

    /**
     * Creates new form TableForAllStudentData
     */
    //default constructor is here.
    public TableForAllStudentData() {
        initComponents();
        jTableDegine();
        mysqlConnection();
        AddmissionCountFun();
        jLabelForSearchBy.setText("@RitikCoder");
        DataFillIntoTheTableRows();
        jButtonForPrevious.setVisible(false);
    }
    //parameterized constructor is here.
    public TableForAllStudentData(String stringForStudentID) {
        initComponents();
        jLabelForSearchBy.setText(stringForStudentID);
        mysqlConnection();
        jTableDegine();
        DataFillIntoTheTableRows();
        AddmissionCountFun();
        jButtonForPrevious.setVisible(false);
    }
    
    //Globally Variables and Reference variables;
    java.sql.Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    int intForPageCount= 1;
    int RowsCount;
    int i= 13, forLoopForTableMoving, OffsetCount= 0;//12
    
    //This method is used to Estabilized mysql database connection.
    public void mysqlConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String stringForURL= "jdbc:mysql://localhost:3306/learningcomputer";
            String stringForUser= "root";
            String stringForPassword= "RitikCoder@mysql";
            connection= (java.sql.Connection) DriverManager.getConnection(stringForURL, stringForUser, stringForPassword);
            Statement statement= connection.createStatement();
            //System.out.println("Connection Estabilized successfully.");
            
        } catch (ClassNotFoundException | SQLException ex) {
            //System.out.println("Error Occure inside of Mysql connection method.");
            JOptionPane.showMessageDialog(this, "MySQL Connection Error := "+ ex);
        }
    }
    
    //This method is used to initialization of table rows.
    public void DataFillIntoTheTableRows(){
        try{
            String stringForExecuteQuery= "Select Sr_No, Student_ID, Name, Father_Name, Mother_Name, Phone_No from studentdata limit "
                    + "12 offset "+ OffsetCount;
            PreparedStatement preparedStatement= connection.prepareStatement(stringForExecuteQuery);
            ResultSet resultSet= preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData= (ResultSetMetaData) resultSet.getMetaData();
            int columnCount= resultSetMetaData.getColumnCount();
            DefaultTableModel defaultTableModel= (DefaultTableModel) jTableForViewWholeRecord.getModel();
            defaultTableModel.setRowCount(0);
            while(resultSet.next()){
                Vector vector= new Vector();
                for(int i= 1; i<= columnCount; i++){
                    vector.add(resultSet.getInt(1));
                    vector.add(resultSet.getString(2));
                    vector.add(resultSet.getString(3));
                    vector.add(resultSet.getString(4));
                    vector.add(resultSet.getString(5));
                    vector.add(resultSet.getString(6));
                }
                defaultTableModel.addRow(vector);
            }
            jLabelForPageCount.setText(String.valueOf(intForPageCount));
            
        }catch(SQLException exception){
            System.out.println("Error Occure inside of DataFillIntoTheTableRows Methodd");
        }
    }
    
    //This method is used to be Increse JTable header font size, BG color and Forground color.
    private void jTableDegine(){
        JTableHeader jTableHeader= jTableForViewWholeRecord.getTableHeader();
        jTableHeader.setForeground(Color.BLACK);
        //jTableHeader.setBackground(Color.GREEN);
        jTableHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));   
    }

    //This Method is used to Get count of all the Rows of mysql table.
    public void AddmissionCountFun(){
        try{
        String stringForExecuteQuery= "select COUNT(*) from studentdata";
        preparedStatement= connection.prepareStatement(stringForExecuteQuery);
        resultSet= preparedStatement.executeQuery();
        while(resultSet.next()){
            //int count= resultSet.getInt("AdmissionRowCount");
            RowsCount= resultSet.getInt(1);
            jLabelForTotalRecord.setText(String.valueOf(resultSet.getInt(1)));
            
        }
        
        }catch(SQLException exception){
            System.out.println("Error occure inside of Addmission Count Method.");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableForViewWholeRecord = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonForPrevious = new javax.swing.JButton();
        jButtonForNext = new javax.swing.JButton();
        jLabelForPageCount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelForSearchBy = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelForTotalRecord = new javax.swing.JLabel();
        jButtonForView2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonForView1 = new javax.swing.JButton();
        jButtonForView3 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Record");
        setBackground(new java.awt.Color(33, 200, 99));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(105, 72, 213));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableForViewWholeRecord.setBackground(new java.awt.Color(0, 0, 0));
        jTableForViewWholeRecord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 255)));
        jTableForViewWholeRecord.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTableForViewWholeRecord.setForeground(new java.awt.Color(255, 255, 0));
        jTableForViewWholeRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sr-No.", "Student_ID", "Name", "Father's name", "Mother's name", "Phone no."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableForViewWholeRecord.setRowHeight(25);
        jScrollPane1.setViewportView(jTableForViewWholeRecord);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 37, 1000, 340));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Student Record");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 0, 191, 31));

        jButtonForPrevious.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonForPrevious.setText("Previous");
        jButtonForPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForPreviousActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonForPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 32));

        jButtonForNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonForNext.setText("Next");
        jButtonForNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForNextActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonForNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 390, -1, 32));

        jLabelForPageCount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelForPageCount.setForeground(new java.awt.Color(255, 255, 255));
        jLabelForPageCount.setText("0");
        jPanel1.add(jLabelForPageCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 37, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 204));
        jLabel3.setText("Search by :-");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

        jLabelForSearchBy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelForSearchBy.setForeground(new java.awt.Color(255, 255, 0));
        jLabelForSearchBy.setText("No one");
        jPanel1.add(jLabelForSearchBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 174, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Record :- ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, -1, -1));

        jLabelForTotalRecord.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelForTotalRecord.setForeground(new java.awt.Color(255, 255, 0));
        jLabelForTotalRecord.setText("No Record");
        jPanel1.add(jLabelForTotalRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 140, -1));

        jButtonForView2.setBackground(new java.awt.Color(51, 51, 255));
        jButtonForView2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonForView2.setText("Print");
        jButtonForView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForView2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonForView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 340, 80, 30));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 260, 80, 30));

        jButtonForView1.setBackground(new java.awt.Color(51, 51, 255));
        jButtonForView1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonForView1.setText("Certi-F");
        jButtonForView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForView1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonForView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 300, 80, 30));

        jButtonForView3.setBackground(new java.awt.Color(51, 51, 255));
        jButtonForView3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonForView3.setText("View");
        jButtonForView3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForView3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonForView3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 80, 30));

        jButton3.setBackground(new java.awt.Color(0, 0, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 220, 80, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_Software/Asus Walpaper.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonForPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForPreviousActionPerformed
        // TODO add your handling code here:
        
        OffsetCount= OffsetCount- 12;
        intForPageCount--;
        jLabelForPageCount.setText(String.valueOf(intForPageCount));
        try{
            String stringForExecuteQuery= "Select Sr_No, Student_ID, Name, Father_Name, Mother_Name, Phone_No from studentdata limit 12 "
                    + "offset "+ OffsetCount;
            PreparedStatement preparedStatement= connection.prepareStatement(stringForExecuteQuery);
            ResultSet resultSet= preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData= (ResultSetMetaData) resultSet.getMetaData();
            int columnCount= resultSetMetaData.getColumnCount();
            DefaultTableModel defaultTableModel= (DefaultTableModel) jTableForViewWholeRecord.getModel();
            defaultTableModel.setRowCount(0);
            while(resultSet.next()){
                Vector vector= new Vector();
                for(int i= 1; i<= columnCount; i++){
                    vector.add(resultSet.getInt(1));
                    vector.add(resultSet.getString(2));
                    vector.add(resultSet.getString(3));
                    vector.add(resultSet.getString(4));
                    vector.add(resultSet.getString(5));
                    vector.add(resultSet.getString(6));
                }
                defaultTableModel.addRow(vector);
            }
            
        }catch(SQLException exception){
            System.out.println("Error Occure inside of Previous Button Methodd");
        }
        
        //OffsetCount= OffsetCount+ 12;
        if(OffsetCount== 0){
        jButtonForPrevious.setVisible(false);
        }else{
        jButtonForNext.setVisible(true);
        }
    }//GEN-LAST:event_jButtonForPreviousActionPerformed

    private void jButtonForNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForNextActionPerformed
        // TODO add your handling code here:
            OffsetCount+= 12;
            intForPageCount+= 1;
        //for(forLoopForTableMoving= 0; forLoopForTableMoving<= RowsCount; forLoopForTableMoving+= 12){
            jLabelForPageCount.setText(String.valueOf(intForPageCount));
        try{
            String stringForExecuteQuery= "Select Sr_No, Student_ID, Name, Father_Name, Mother_Name, Phone_No from studentdata limit 12 "
                    + "offset "+ OffsetCount;
            PreparedStatement preparedStatement= connection.prepareStatement(stringForExecuteQuery);
            ResultSet resultSet= preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData= (ResultSetMetaData) resultSet.getMetaData();
            int columnCount= resultSetMetaData.getColumnCount();
            DefaultTableModel defaultTableModel= (DefaultTableModel) jTableForViewWholeRecord.getModel();
            defaultTableModel.setRowCount(0);
            while(resultSet.next()){
                Vector vector= new Vector();
                for(int i= 1; i<= columnCount; i++){
                    vector.add(resultSet.getInt(1));
                    vector.add(resultSet.getString(2));
                    vector.add(resultSet.getString(3));
                    vector.add(resultSet.getString(4));
                    vector.add(resultSet.getString(5));
                    vector.add(resultSet.getString(6));
                }
                defaultTableModel.addRow(vector);
            }
            
        }catch(SQLException exception){
            System.out.println("Error Occure inside of Next Button Methodd");
        }
        //}
        if(OffsetCount!= 0){
        jButtonForPrevious.setVisible(true);
        }
    }//GEN-LAST:event_jButtonForNextActionPerformed

    private void jButtonForView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForView1ActionPerformed
        // TODO add your handling code here:
        int rowCount= -1;
        rowCount= jTableForViewWholeRecord.getSelectedRow();
        if(rowCount== -1){
            JOptionPane.showMessageDialog(this, "Please Select any Row to View");
        }else{
            DefaultTableModel model= (DefaultTableModel) jTableForViewWholeRecord.getModel();
            String stringForStudentIDFromTable= (String) model.getValueAt(rowCount, 1);
            //System.out.println("Selected Row is := "+ rowCount);
            //System.out.println("ID is := "+ stringForStudentIDFromTable);
            ViewProfileWindow viewProfileWindow= new ViewProfileWindow(stringForStudentIDFromTable);
            viewProfileWindow.setVisible(true);
        }
        
    }//GEN-LAST:event_jButtonForView1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //System.out.println("Here I am in the Edit button");
//        JOptionPane.showMessageDialog(null, "Here Edit button is pressed");
        int rowCount= -1;
        rowCount= jTableForViewWholeRecord.getSelectedRow();
        if(rowCount== -1){
            JOptionPane.showMessageDialog(this, "Please Select any Row to Edit");
        }else{
            DefaultTableModel model= (DefaultTableModel) jTableForViewWholeRecord.getModel();
            String stringForStudentIDFromTable= (String) model.getValueAt(rowCount, 1);
//            System.out.println("Selected Row is := "+ rowCount);
//            System.out.println("ID is := "+ stringForStudentIDFromTable);
            UpdateForm updateForm= new UpdateForm(stringForStudentIDFromTable);
            updateForm.setVisible(true);
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //System.out.println("Here I ma in the Delete button");
//        JOptionPane.showMessageDialog(null, "Here delete button is pressed");
        int rowCount= -1;
        rowCount= jTableForViewWholeRecord.getSelectedRow();
        if(rowCount== -1){
            JOptionPane.showMessageDialog(this, "Please Select any Row to Delete");
        }else{
            DefaultTableModel model= (DefaultTableModel) jTableForViewWholeRecord.getModel();
            String stringForStudentIDFromTable= (String) model.getValueAt(rowCount, 1);
//            System.out.println("Selected Row is := "+ rowCount);
//            System.out.println("ID is := "+ stringForStudentIDFromTable);
            int conformDilogBox = JOptionPane.showConfirmDialog(null, "Do you want to delete", "Delete", JOptionPane.YES_NO_OPTION);
            if (conformDilogBox == 0) {
                try{
                String stringForExecuteQuery2 = "delete from studentdata where Student_ID= ?";
                //System.out.println("query run successfully.");
                //resultSet= statement.executeQuery(stringForExecuteQuery2);
                PreparedStatement preparedStatement = connection.prepareStatement(stringForExecuteQuery2);
                preparedStatement.setString(1, stringForStudentIDFromTable);
                preparedStatement.executeUpdate();
                //System.out.println("query update successfully.");
                JOptionPane.showMessageDialog(rootPane, "Record is Deleted successfully on ID= " + stringForStudentIDFromTable + "");
                DataFillIntoTheTableRows();
                AddmissionCountFun();
                }catch(SQLException exception){
                    System.out.println("Error Found inside of delete record.");
                }
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonForView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForView2ActionPerformed
        // TODO add your handling code here:
        //This is my print button
        MessageFormat messageFormatForHeader= new MessageFormat("Learning Computer & Career Planning Center");
        MessageFormat messageFormatForFooter= new MessageFormat("@RitikCoder.com");
        
        try{
            jTableForViewWholeRecord.print(JTable.PrintMode.NORMAL, messageFormatForHeader, messageFormatForFooter);
            
        }catch (PrinterException ex) {
            Logger.getLogger(TableForAllStudentData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonForView2ActionPerformed

    private void jButtonForView3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForView3ActionPerformed
        // TODO add your handling code here:
        //This is View data button.
        //JOptionPane.showMessageDialog(this, "My name is View button");
        int rowCount= -1;
        rowCount= jTableForViewWholeRecord.getSelectedRow();
        if(rowCount== -1){
            JOptionPane.showMessageDialog(this, "Please Select any Row to View");
        }else{
            DefaultTableModel model= (DefaultTableModel) jTableForViewWholeRecord.getModel();
            String stringForStudentIDFromTable= (String) model.getValueAt(rowCount, 1);
//            System.out.println("Selected Row is := "+ rowCount);
//            System.out.println("ID is := "+ stringForStudentIDFromTable);
            SearchedInformation searchedInformation= new SearchedInformation(stringForStudentIDFromTable);
            searchedInformation.setVisible(true);
        }
    }//GEN-LAST:event_jButtonForView3ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableForAllStudentData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableForAllStudentData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableForAllStudentData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableForAllStudentData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableForAllStudentData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonForNext;
    private javax.swing.JButton jButtonForPrevious;
    private javax.swing.JButton jButtonForView1;
    private javax.swing.JButton jButtonForView2;
    private javax.swing.JButton jButtonForView3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelForPageCount;
    private javax.swing.JLabel jLabelForSearchBy;
    private javax.swing.JLabel jLabelForTotalRecord;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableForViewWholeRecord;
    // End of variables declaration//GEN-END:variables
}
