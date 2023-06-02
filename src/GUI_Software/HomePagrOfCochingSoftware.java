/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_Software;

import SnakeGame.MainClassOfSnakeGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import javax.swing.Timer;

/**
 *
 * @author RitikCoder
 */
public class HomePagrOfCochingSoftware extends javax.swing.JFrame {

    /**
     * Creates new form HomePagrOfCochingSoftware
     */
    public HomePagrOfCochingSoftware() {
        initComponents();
        mysqlConnection();
        AddmissionCountFun();
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                exitConformDilog();
            }
        });
        startClockTimer();
        
    }
    
    //This method is used to show Conform dilog box to Exit jfram or not my clicking on the close button.
    void exitConformDilog(){
        int a= JOptionPane.showConfirmDialog(null, "Do you want to exit", "Close window", JOptionPane.YES_NO_OPTION);
        if(a== JOptionPane.YES_OPTION){
            this.dispose();
        }
    }
    
    //This method is used to Estabilized mysql database connection.
    Connection connection;
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
            System.out.println("Error Occure inside of Mysql connection method.");
        }
    }
    
    //Admission Count method in java.
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    int RowsCount;
    public void AddmissionCountFun(){
        try{
        String stringForExecuteQuery= "select COUNT(*) from studentdata";
        preparedStatement= connection.prepareStatement(stringForExecuteQuery);
        resultSet= preparedStatement.executeQuery();
        while(resultSet.next()){
            //int count= resultSet.getInt("AdmissionRowCount");
            RowsCount= resultSet.getInt(1);
            //System.out.println(RowsCount);
        }
        
        }catch(SQLException exception){
            System.out.println("Error occure inside of Addmission Count Method.");
        }
    }
    
    //Method to Search bar.
    public void searchBarMethod(String strringSearch){
        String stringforSearchBar= strringSearch.toLowerCase();
        switch (stringforSearchBar) {
            case "countdata":{
                JOptionPane.showMessageDialog(null, ""+ RowsCount+ " Rows are inserted.");
                break;
            }case "about":{
                //JOptionPane.showMessageDialog(null, "RitikCoder is a Founder of this software.");
                HomeAboutWindow homeAboutWindow= new HomeAboutWindow();
                homeAboutWindow.setVisible(true);
                break;
            }case "contactus":{
                HomeContactUsWindow homeContactUsWindow= new HomeContactUsWindow();
                homeContactUsWindow.setVisible(true);
                break;
            }case "courses":{
                HomeCoursesWindow homeCoursesWindow= new HomeCoursesWindow();
                homeCoursesWindow.setVisible(true);
                break;
            }case "searchinglist":{
                SearchingList searchingList= new SearchingList();
                searchingList.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Searching list is comming soon");
                break;
            }case "ritikcoder":{
                JOptionPane.showMessageDialog(null, "RitikCoder is the Founder of this Software");
                break;
            }
            default:
                if(jTextFieldForSearch.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Search Field is Empty");
                }else{
                JOptionPane.showMessageDialog(null, "This Search is not Avilable Right now.");
                }
        }
        if(jTextFieldForSearch.getText().trim().isEmpty()){
            jTextFieldForSearch.setText("Search here");
        }
    }
    
    //Method of Time to Passwrod Error.
    public void startClockTimer(){
        Timer timer= new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                java.util.Date date= new java.util.Date();
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("hh:mm:ss - a");
                String dateTime= simpleDateFormat.format(date);
                jLabelForShowTime.setText(dateTime);
            }
        });
        timer.start();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonForSearchBar = new javax.swing.JButton();
        jButtonForCourse = new javax.swing.JButton();
        jButtonForAbout = new javax.swing.JButton();
        jButtonForContactUs = new javax.swing.JButton();
        jTextFieldForSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonForFunWithCode = new javax.swing.JButton();
        jButtonForLoginWindow = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelForShowTime = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Learning Computer Education & Carrer Planning Centeer");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 255));
        jLabel3.setText("Career Planning Center");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 450, 50));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 255));
        jLabel4.setText("Learning Computer Education");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 610, 50));

        jButtonForSearchBar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonForSearchBar.setText("Search");
        jButtonForSearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForSearchBarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonForSearchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, 110, 40));

        jButtonForCourse.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonForCourse.setText("Courses");
        jButtonForCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForCourseActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonForCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 110, 40));

        jButtonForAbout.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonForAbout.setText("About");
        jButtonForAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForAboutActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonForAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 110, 40));

        jButtonForContactUs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonForContactUs.setText("Contact us");
        jButtonForContactUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForContactUsActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonForContactUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 120, 40));

        jTextFieldForSearch.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldForSearch.setText("Search here");
        jTextFieldForSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldForSearchMouseClicked(evt);
            }
        });
        jTextFieldForSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldForSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 240, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Code With @Pro-Coder's...");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 580, 70));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 255));
        jLabel2.setText("The Feature of Education is here.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 530, 40));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 204));
        jLabel5.setText("Education is Here.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 160, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 204));
        jLabel6.setText("In This world 7 Billion People We Need to All Education.");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 460, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 204));
        jLabel7.setText("Then. This is the Feature of an Educated World and");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 430, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 204));
        jLabel8.setText("We are Proud to Say That The Feature of the");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 370, 30));

        jButtonForFunWithCode.setBackground(new java.awt.Color(70, 51, 89));
        jButtonForFunWithCode.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButtonForFunWithCode.setForeground(new java.awt.Color(0, 0, 0));
        jButtonForFunWithCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_Software/FunWithCode2.png"))); // NOI18N
        jButtonForFunWithCode.setBorder(null);
        jButtonForFunWithCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForFunWithCodeActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonForFunWithCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 260, 40));

        jButtonForLoginWindow.setBackground(new java.awt.Color(70, 51, 89));
        jButtonForLoginWindow.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButtonForLoginWindow.setForeground(new java.awt.Color(0, 0, 0));
        jButtonForLoginWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_Software/HomePageLoginButton.png"))); // NOI18N
        jButtonForLoginWindow.setBorder(null);
        jButtonForLoginWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonForLoginWindowActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonForLoginWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 130, 40));

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RitikCoder", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(0, 255, 255))); // NOI18N

        jLabelForShowTime.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelForShowTime.setForeground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 385, Short.MAX_VALUE)
                .addComponent(jLabelForShowTime, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 126, Short.MAX_VALUE)
                .addComponent(jLabelForShowTime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 530, 180));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 255));
        jLabel9.setText("&");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 40, 50));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_Software/Desktop With Media icons.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 250, 250));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_Software/BG-7.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldForSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForSearchActionPerformed
        // TODO add your handling code here:
        String stringForGetTextIntoTheJTextFieldForSearch= jTextFieldForSearch.getText();
        searchBarMethod(stringForGetTextIntoTheJTextFieldForSearch);
    }//GEN-LAST:event_jTextFieldForSearchActionPerformed

    private void jButtonForLoginWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForLoginWindowActionPerformed
        // TODO add your handling code here:
        LoginFormForCotching loginFormForCotching= new LoginFormForCotching();
        loginFormForCotching.setVisible(true);
    }//GEN-LAST:event_jButtonForLoginWindowActionPerformed

    private void jButtonForFunWithCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForFunWithCodeActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, "Only one Game is Avliable Right now.");
        int a= JOptionPane.showConfirmDialog(null, "Do you want to Play Games", "Play Games", JOptionPane.YES_NO_OPTION);
        if(a== JOptionPane.YES_OPTION){
            SnakeGame.MainClassOfSnakeGame mainClassOfSnakeGame= new MainClassOfSnakeGame();
        }
    }//GEN-LAST:event_jButtonForFunWithCodeActionPerformed

    private void jButtonForSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForSearchBarActionPerformed
        // TODO add your handling code here:
        String stringForGetTextIntoTheJTextFieldForSearch= jTextFieldForSearch.getText();
        searchBarMethod(stringForGetTextIntoTheJTextFieldForSearch);
    }//GEN-LAST:event_jButtonForSearchBarActionPerformed

    private void jTextFieldForSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldForSearchMouseClicked
        // TODO add your handling code here:
        jTextFieldForSearch.setText("");
    }//GEN-LAST:event_jTextFieldForSearchMouseClicked

    private void jButtonForCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForCourseActionPerformed
        // TODO add your handling code here:
        HomeCoursesWindow homeCoursesWindow= new HomeCoursesWindow();
        homeCoursesWindow.setVisible(true);
    }//GEN-LAST:event_jButtonForCourseActionPerformed

    private void jButtonForAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForAboutActionPerformed
        // TODO add your handling code here:
        HomeAboutWindow homeAboutWindow= new HomeAboutWindow();
        homeAboutWindow.setVisible(true);
    }//GEN-LAST:event_jButtonForAboutActionPerformed

    private void jButtonForContactUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonForContactUsActionPerformed
        // TODO add your handling code here:
        HomeContactUsWindow homeContactUsWindow= new HomeContactUsWindow();
        homeContactUsWindow.setVisible(true);
    }//GEN-LAST:event_jButtonForContactUsActionPerformed

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
            java.util.logging.Logger.getLogger(HomePagrOfCochingSoftware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePagrOfCochingSoftware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePagrOfCochingSoftware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePagrOfCochingSoftware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePagrOfCochingSoftware().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonForAbout;
    private javax.swing.JButton jButtonForContactUs;
    private javax.swing.JButton jButtonForCourse;
    private javax.swing.JButton jButtonForFunWithCode;
    private javax.swing.JButton jButtonForLoginWindow;
    private javax.swing.JButton jButtonForSearchBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelForShowTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldForSearch;
    // End of variables declaration//GEN-END:variables
}
