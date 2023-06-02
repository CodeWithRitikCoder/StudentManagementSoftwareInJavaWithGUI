/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_Software;

import java.awt.HeadlessException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.sql.*;
//import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author RitikCoder
 */
public class AdmissionForm extends javax.swing.JFrame {

//    private Object studentImage1;

    /**
     * Creates new form AdmissionForm
     */
    public AdmissionForm() {
        initComponents();
        mysqlConnection();
        AddmissionCountFun();
        System.out.println("index is := "+ jComboBoxForCourse.getSelectedIndex());
    }
    
    //Globally Variables and Reference variables;
    java.sql.Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String stringForImagePath= null;
    byte[] studentImage= null;
    boolean booleanForCheckExceptionOfAllFields= true;
    
    //This method is used to Estabilized mysql database connection.
    public void mysqlConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String stringForURL= "jdbc:mysql://localhost:3306/learningcomputer";
            String stringForUser= "root";
            String stringForPassword= "RitikCoder@mysql";
            connection= (java.sql.Connection) DriverManager.getConnection(stringForURL, stringForUser, stringForPassword);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error Occure inside of Mysql connection method.");
        }
    }
    
    
    public void unpaidFee(){
        int intForPaidFee= Integer.parseInt(jTextFieldForPaidFee.getText());
        String stringForCourseFee= jLabelForCourseFee.getText();
        intForCourseFee= Integer.parseInt(stringForCourseFee.substring(6));
        jLabelForUnpaidFee.setText("Unpaid Fee.:- "+ (intForCourseFee- intForPaidFee));
    }
    
    //This Method is used to Get count of all the Rows of mysql table.
    public void AddmissionCountFun(){
        try{
        String stringForExecuteQuery= "select COUNT(*) from studentdata";
        preparedStatement= connection.prepareStatement(stringForExecuteQuery);
        resultSet= preparedStatement.executeQuery();
        while(resultSet.next()){
            //int count= resultSet.getInt("AdmissionRowCount");
            int count= resultSet.getInt(1);
            jLabelForAdmissionCount.setText("Ad-Count- "+ String.valueOf(count));
        }
        
        }catch(SQLException exception){
            System.out.println("Error occure inside of Addmission Count Method.");
        }
    }
            
    //Here I am having empty all fields after press admission button.
    public void refrestAllAdimssionFields(){
        jTextFieldForFirstName.setText("");
        jTextFieldForLastName.setText("");
        jTextFieldForStudentID.setText("");
        if(StringFormGenderMatching.equalsIgnoreCase("male")){
            jRadioButtonAdmissionMale.setSelected(false);
        }else if(StringFormGenderMatching.equalsIgnoreCase("Female")){
            jRadioButtonAdmissionFemale.setSelected(false);
        }else if(StringFormGenderMatching.equalsIgnoreCase("custom")){
            jRadioButtonAdmissionCustom.setSelected(false);
        }
        jTextFieldForFatherName.setText("");
        jTextFieldForMotherName.setText("");
        jTextFieldForPhoneNo.setText("");
        jTextFieldForEmailID.setText("");
        jComboBoxForCourse.setSelectedIndex(0);
        jLabelForCourseFee.setText("Rs.:- 00000");
        jTextFieldForPaidFee.setText("");
        jLabelForUnpaidFee.setText("");
    }
    
    //This method is used to Check exception of all fields of Admission Form.
    public boolean checkingExceptionOfAllFields(){
        if(jTextFieldForFirstName.getText().trim().isEmpty()){
            jLabelForCheckFirstName.setText("Field Empty");
            booleanForCheckExceptionOfAllFields= false;
        }
        if(jTextFieldForLastName.getText().trim().isEmpty()){
            jLabelForCheckLastName.setText("Field Empty");
            booleanForCheckExceptionOfAllFields= false;
        }
        if(jTextFieldForStudentID.getText().trim().isEmpty()){
            jLabelForCheckStudentID.setText("Field Empty");
            booleanForCheckExceptionOfAllFields= false;
        }
//        if(jDateChooserForDOB.getToolTipText().trim().isEmpty()){
//            jLabelForCheckDOB.setText("Select Date");
//            booleanForCheckExceptionOfAllFields= false;
//        }
        //Gender Exception checking is here.
        boolean booleanForCheckGenderException= true;
        if(jRadioButtonAdmissionMale.isSelected()){
            booleanForCheckGenderException= false;
        }
        if(jRadioButtonAdmissionFemale.isSelected()){
            booleanForCheckGenderException= false;
        }
        if(jRadioButtonAdmissionCustom.isSelected()){
            booleanForCheckGenderException= false;
        }
        if(booleanForCheckGenderException){
            jLabelForCheckGender.setText("Select Gender");
        }
        //that's all about checking Gender Exception.
        if(jTextFieldForFatherName.getText().trim().isEmpty()){
            jLabelForCheckFatherName.setText("Field Empty");
            booleanForCheckExceptionOfAllFields= false;
        }
        if(jTextFieldForMotherName.getText().trim().isEmpty()){
            jLabelForCheckMotherName.setText("Field Empty");
            booleanForCheckExceptionOfAllFields= false;
        }
        if(jTextFieldForPhoneNo.getText().trim().isEmpty()){
            jLabelForCheckPhoneNo.setText("Field Empty");
            booleanForCheckExceptionOfAllFields= false;
        }
        if(jTextFieldForEmailID.getText().trim().isEmpty()){
            jLabelForCheckEmailID.setText("Field Empty");
            booleanForCheckExceptionOfAllFields= false;
        }
//        if(jDateChooserForAdmissionData.getToolTipText().trim().isEmpty()){
//            jLabelForCheckAdmissionDate.setText("Select Date");
//            booleanForCheckExceptionOfAllFields= false;
//        }
        if(jComboBoxForCourse.getSelectedIndex()== 0){
            jLabelForCheckCourse.setText("Select Course");
            booleanForCheckExceptionOfAllFields= false;
        }
        if(jTextFieldForPaidFee.getText().trim().isEmpty()){
            jLabelForCheckPaidFee.setText("Pay Fee");
            booleanForCheckExceptionOfAllFields= false;
        }
        return (booleanForCheckExceptionOfAllFields);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelForUnpaidFee = new javax.swing.JLabel();
        jTextFieldForFirstName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldForLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonAdmissionCustom = new javax.swing.JRadioButton();
        jRadioButtonAdmissionMale = new javax.swing.JRadioButton();
        jRadioButtonAdmissionFemale = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldForStudentID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldForFatherName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldForMotherName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldForPhoneNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldForPaidFee = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxForCourse = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldForEmailID = new javax.swing.JTextField();
        jDateChooserForAdmissionData = new com.toedter.calendar.JDateChooser();
        jDateChooserForDOB = new com.toedter.calendar.JDateChooser();
        jLabelForCourseFee = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelForAdmissionCount = new javax.swing.JLabel();
        jLabelForCheckFirstName = new javax.swing.JLabel();
        jLabelForCheckLastName = new javax.swing.JLabel();
        jLabelForCheckStudentID = new javax.swing.JLabel();
        jLabelForCheckDOB = new javax.swing.JLabel();
        jLabelForCheckGender = new javax.swing.JLabel();
        jLabelForCheckFatherName = new javax.swing.JLabel();
        jLabelForCheckMotherName = new javax.swing.JLabel();
        jLabelForCheckPhoneNo = new javax.swing.JLabel();
        jLabelForCheckEmailID = new javax.swing.JLabel();
        jLabelForCheckAdmissionDate = new javax.swing.JLabel();
        jLabelForCheckCourse = new javax.swing.JLabel();
        jLabelForCheckStudentImage = new javax.swing.JLabel();
        jLabelForCheckPaidFee = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admission window");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Admission");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Last Name*");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jLabelForUnpaidFee.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(jLabelForUnpaidFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 630, 170, 30));

        jTextFieldForFirstName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldForFirstName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldForFirstNameMouseClicked(evt);
            }
        });
        jTextFieldForFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForFirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldForFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 180, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("First Name*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jTextFieldForLastName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldForLastName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldForLastNameMouseClicked(evt);
            }
        });
        jTextFieldForLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForLastNameActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldForLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 210, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Student ID* :- ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("DOB* :-");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jRadioButtonAdmissionCustom.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jRadioButtonAdmissionCustom.setText("Custom");
        jRadioButtonAdmissionCustom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonAdmissionCustomMouseClicked(evt);
            }
        });
        jRadioButtonAdmissionCustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAdmissionCustomActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonAdmissionCustom, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        jRadioButtonAdmissionMale.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jRadioButtonAdmissionMale.setText("Male");
        jRadioButtonAdmissionMale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonAdmissionMaleMouseClicked(evt);
            }
        });
        jRadioButtonAdmissionMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAdmissionMaleActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonAdmissionMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, -1));

        jRadioButtonAdmissionFemale.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jRadioButtonAdmissionFemale.setText("Female");
        jRadioButtonAdmissionFemale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonAdmissionFemaleMouseClicked(evt);
            }
        });
        jRadioButtonAdmissionFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAdmissionFemaleActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonAdmissionFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setText("Gender* :- ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jTextFieldForStudentID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldForStudentID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldForStudentIDMouseClicked(evt);
            }
        });
        jTextFieldForStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForStudentIDActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldForStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 260, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setText("Father's name* :- ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jTextFieldForFatherName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldForFatherName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldForFatherNameMouseClicked(evt);
            }
        });
        jTextFieldForFatherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForFatherNameActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldForFatherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 260, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setText("Mother's name* :- ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jTextFieldForMotherName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldForMotherName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldForMotherNameMouseClicked(evt);
            }
        });
        jTextFieldForMotherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForMotherNameActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldForMotherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 260, 30));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setText("Phone no*. :- ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jTextFieldForPhoneNo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldForPhoneNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldForPhoneNoMouseClicked(evt);
            }
        });
        jTextFieldForPhoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForPhoneNoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldForPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 260, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setText("Email ID :- ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        jTextFieldForPaidFee.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldForPaidFee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldForPaidFeeMouseClicked(evt);
            }
        });
        jTextFieldForPaidFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForPaidFeeActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldForPaidFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 120, 30));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel12.setText("Admission data* :-");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        jComboBoxForCourse.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jComboBoxForCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Your Course", "DCA", "ADCA", "ADCP", "Programming", "Android development", "Web development", "Telly" }));
        jComboBoxForCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxForCourseMouseClicked(evt);
            }
        });
        jComboBoxForCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxForCourseActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxForCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 260, 30));

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("@RitikCoder.com");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 690, -1, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 730, 150, 40));

        jButton2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton2.setText("Admission");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 730, 160, 40));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel14.setText("Paid Fee* :-");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, -1, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel15.setText("Course Fee* :-");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        jTextFieldForEmailID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldForEmailID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldForEmailIDMouseClicked(evt);
            }
        });
        jTextFieldForEmailID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForEmailIDActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldForEmailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 260, 30));

        jDateChooserForAdmissionData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooserForAdmissionDataMouseClicked(evt);
            }
        });
        jPanel1.add(jDateChooserForAdmissionData, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 260, 30));

        jDateChooserForDOB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooserForDOBMouseClicked(evt);
            }
        });
        jPanel1.add(jDateChooserForDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 260, 30));

        jLabelForCourseFee.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelForCourseFee.setText("Rs.:- 00000");
        jPanel1.add(jLabelForCourseFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 130, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel16.setText("Course* :-");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, -1, -1));

        jLabelForAdmissionCount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelForAdmissionCount.setForeground(new java.awt.Color(255, 255, 0));
        jLabelForAdmissionCount.setText("Ad-Count");
        jPanel1.add(jLabelForAdmissionCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));
        jPanel1.add(jLabelForCheckFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 170, 20));
        jPanel1.add(jLabelForCheckLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 200, 20));
        jPanel1.add(jLabelForCheckStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 250, 20));
        jPanel1.add(jLabelForCheckDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 260, 20));
        jPanel1.add(jLabelForCheckGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 220, 20));
        jPanel1.add(jLabelForCheckFatherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 250, 20));
        jPanel1.add(jLabelForCheckMotherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 240, 20));
        jPanel1.add(jLabelForCheckPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 250, 20));
        jPanel1.add(jLabelForCheckEmailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 250, 20));
        jPanel1.add(jLabelForCheckAdmissionDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 250, 20));
        jPanel1.add(jLabelForCheckCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 250, 20));
        jPanel1.add(jLabelForCheckStudentImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 610, 120, 20));
        jPanel1.add(jLabelForCheckPaidFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 660, 120, 20));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Choose");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 580, 120, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI_Software/BG-11.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    String StringFormGenderMatching= new String();
    String stringForCourse= new String();
    int intForCourseFee;
    private void jTextFieldForFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForFirstNameActionPerformed

    private void jTextFieldForLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForLastNameActionPerformed

    private void jRadioButtonAdmissionCustomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAdmissionCustomActionPerformed
        // TODO add your handling code here:
        if(jRadioButtonAdmissionCustom.isSelected()){
            jRadioButtonAdmissionMale.setSelected(false);
            jRadioButtonAdmissionFemale.setSelected(false);
            StringFormGenderMatching= "Custom";
        }
    }//GEN-LAST:event_jRadioButtonAdmissionCustomActionPerformed

    private void jRadioButtonAdmissionFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAdmissionFemaleActionPerformed
        // TODO add your handling code here:
        if(jRadioButtonAdmissionFemale.isSelected()){
            jRadioButtonAdmissionMale.setSelected(false);
            jRadioButtonAdmissionCustom.setSelected(false);
            StringFormGenderMatching= "Female";
        }
    }//GEN-LAST:event_jRadioButtonAdmissionFemaleActionPerformed

    private void jTextFieldForStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForStudentIDActionPerformed

    private void jTextFieldForFatherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForFatherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForFatherNameActionPerformed

    private void jTextFieldForMotherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForMotherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForMotherNameActionPerformed

    private void jTextFieldForPhoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForPhoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForPhoneNoActionPerformed

    private void jTextFieldForPaidFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForPaidFeeActionPerformed
        // TODO add your handling code here:
            unpaidFee();
    }//GEN-LAST:event_jTextFieldForPaidFeeActionPerformed

    private void jComboBoxForCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxForCourseActionPerformed
        // TODO add your handling code here:
        int intForCourse= jComboBoxForCourse.getSelectedIndex();
        if(intForCourse== 1){
            jLabelForCourseFee.setText("Rs.:- 4500");
            stringForCourse= "DCA";
        }else if(intForCourse== 2){
            jLabelForCourseFee.setText("Rs.:- 6500");
            stringForCourse= "ADCA";
        }else if(intForCourse== 3){
            jLabelForCourseFee.setText("Rs.:- 12500");
            stringForCourse= "ADCP";
        }else if(intForCourse== 4){
            jLabelForCourseFee.setText("Rs.:- 12500");
            stringForCourse= "Programming";
        }else if(intForCourse== 5){
            jLabelForCourseFee.setText("Rs.:- 12500");
            stringForCourse= "Android development";
        }else if(intForCourse== 6){
            jLabelForCourseFee.setText("Rs.:- 12500");
            stringForCourse= "Web development";
        }else if(intForCourse== 7){
            jLabelForCourseFee.setText("Rs.:- 6000");
            stringForCourse= "Telly";
        }else{
            jLabelForCourseFee.setText("Rs.:- 00000");
        }
//        System.out.println(jLabelForCourseFee.getText());
//        System.out.println(stringForCourse);
    }//GEN-LAST:event_jComboBoxForCourseActionPerformed

    private void jRadioButtonAdmissionMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAdmissionMaleActionPerformed
        // TODO add your handling code here:
        if(jRadioButtonAdmissionMale.isSelected()){
            jRadioButtonAdmissionFemale.setSelected(false);
            jRadioButtonAdmissionCustom.setSelected(false);   
            StringFormGenderMatching= "Male";
        }
    }//GEN-LAST:event_jRadioButtonAdmissionMaleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //My name is Admission Button.
        if(checkingExceptionOfAllFields()){
//        if(true){
        String stringForFirstName= jTextFieldForFirstName.getText();
        String stringForLastName= jTextFieldForLastName.getText();
        String stringForFullname= new String(stringForFirstName+" "+ stringForLastName);
        String stringForStudentID= jTextFieldForStudentID.getText();
        SimpleDateFormat simpleDateFormatForDOB= new SimpleDateFormat("dd-MM-yyyy");
        String stringForDOB= simpleDateFormatForDOB.format(jDateChooserForDOB.getDate());
        String stringForGender= StringFormGenderMatching;
        String stringForFatherName= jTextFieldForFatherName.getText();
        String stringForMotherName= jTextFieldForMotherName.getText();
        String stringForPhoneNo= jTextFieldForPhoneNo.getText();
        String stringForEmailID= jTextFieldForEmailID.getText();
        SimpleDateFormat simpleDateFormatForAdmissionDate= new SimpleDateFormat("dd-MM-yyyy");
        String stringForAdmissionData= simpleDateFormatForAdmissionDate.format(jDateChooserForAdmissionData.getDate());
        String stringForSelectCourse= stringForCourse;
        int intForCourseFeeMain= intForCourseFee;
        int intforPaidFee= Integer.parseInt(jTextFieldForPaidFee.getText());
        String stringForUnpaidFee= jLabelForUnpaidFee.getText();
        String stringForUnpaidFee1= stringForUnpaidFee.substring(14);
        int intForUnpaidFee= Integer.parseInt(stringForUnpaidFee1);
//        System.out.println(stringForDOB);
//        System.out.println(stringForAdmissionData);
        try {
            //MySQL Connection is here.
            Class<?> forName = Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Driver Loaded Successfully.");
            java.sql.Connection connection= (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/learningcomputer", "root", "RitikCoder@mysql");
            String stringForExecuteQuery= "insert into studentdata(Student_ID, Name, DOB, Gender, Father_Name, Mother_Name, Phone_No, "
                    + "Email_ID, Admission_Date, Course, Course_Fee, Paid_Fee, Unpaid_Fee/*, Profile_Image*/) values(?,?,?,?,?,?,?,?,?,?,?,?,?/*,?*/)";
            PreparedStatement preparedStatement= connection.prepareStatement(stringForExecuteQuery);
            //System.out.println("Connection Estabilish Successfully.");
            preparedStatement.setString(1,stringForStudentID);
            preparedStatement.setString(2, stringForFullname);
            preparedStatement.setString(3, stringForDOB);
            preparedStatement.setString(4, stringForGender);
            preparedStatement.setString(5, stringForFatherName);
            preparedStatement.setString(6, stringForMotherName);
            preparedStatement.setString(7, stringForPhoneNo);
            preparedStatement.setString(8, stringForEmailID);
            preparedStatement.setString(9, stringForAdmissionData);
            preparedStatement.setString(10, stringForSelectCourse);
            preparedStatement.setInt(11, intForCourseFeeMain);
            preparedStatement.setInt(12, intforPaidFee);
            preparedStatement.setInt(13, intForUnpaidFee);
//            try{
//                FileInputStream fileInputStream= new FileInputStream(stringForImagePath);
//                preparedStatement.setBlob(14, fileInputStream);
//            }catch(FileNotFoundException | SQLException exception){
//                JOptionPane.showMessageDialog(this, "Image Statement Error : "+ exception.getMessage());
//            }
            //System.out.println("Proper running till the here.");
            try{
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Admission Successfully.");
                refrestAllAdimssionFields();
                AddmissionCountFun();
                
            }catch(HeadlessException | SQLException exception){
                JOptionPane.showMessageDialog(this, "Database query Update Error : "+ exception.getMessage());
            }  
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error Occur here.");
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldForEmailIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForEmailIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForEmailIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        this.setVisible(false);
        this.dispose();
        //System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
//        JFileChooser jFileChooser= new JFileChooser("C:\\Users\\codew\\OneDrive\\Pictures\\");
//        jFileChooser.showOpenDialog(null);
//        File file= jFileChooser.getSelectedFile();
//        stringForImagePath= file.getAbsolutePath();
//        
//        try{
//            File image= new File(stringForImagePath);
//            FileInputStream fileInputStream= new FileInputStream(image);
//            ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
//            byte[] buf= new byte[1024];
//            for(int readNum; (readNum= fileInputStream.read(buf)) != -1;){
//                byteArrayOutputStream.write(buf, 0, readNum);    
//            }
//            System.out.println("- "+ Arrays.toString(studentImage));
//            studentImage= byteArrayOutputStream.toByteArray();
//            System.out.println("- "+ Arrays.toString(studentImage));
//            
//        }catch(IOException exception){
//            JOptionPane.showMessageDialog(null, exception);
//        }
        JFileChooser jFileChooser= new JFileChooser("C:\\Users\\codew\\OneDrive\\Pictures\\");
        FileNameExtensionFilter fileNameExtensionFilter= new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "jpeg", "gif");
        jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);
        int result= jFileChooser.showSaveDialog(this);
        if(result== JFileChooser.APPROVE_OPTION){
            File selectedImage= jFileChooser.getSelectedFile();
            String imagePath= selectedImage.getAbsolutePath();
            try{
                stringForImagePath= imagePath;
            }catch(Exception exception){
                JOptionPane.showMessageDialog(this, "Image error : "+ exception.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFieldForFirstNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldForFirstNameMouseClicked
        // TODO add your handling code here:
        jLabelForCheckFirstName.setText("");
    }//GEN-LAST:event_jTextFieldForFirstNameMouseClicked

    private void jTextFieldForLastNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldForLastNameMouseClicked
        // TODO add your handling code here:
        jLabelForCheckLastName.setText("");
    }//GEN-LAST:event_jTextFieldForLastNameMouseClicked

    private void jTextFieldForStudentIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldForStudentIDMouseClicked
        // TODO add your handling code here:
        jLabelForCheckStudentID.setText("");
    }//GEN-LAST:event_jTextFieldForStudentIDMouseClicked

    private void jDateChooserForDOBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserForDOBMouseClicked
        // TODO add your handling code here:
        jLabelForCheckDOB.setText("");
    }//GEN-LAST:event_jDateChooserForDOBMouseClicked

    private void jRadioButtonAdmissionMaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonAdmissionMaleMouseClicked
        // TODO add your handling code here:
        jLabelForCheckGender.setText("");
    }//GEN-LAST:event_jRadioButtonAdmissionMaleMouseClicked

    private void jRadioButtonAdmissionFemaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonAdmissionFemaleMouseClicked
        // TODO add your handling code here:
        jLabelForCheckGender.setText("");
    }//GEN-LAST:event_jRadioButtonAdmissionFemaleMouseClicked

    private void jRadioButtonAdmissionCustomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonAdmissionCustomMouseClicked
        // TODO add your handling code here:
        jLabelForCheckGender.setText("");
    }//GEN-LAST:event_jRadioButtonAdmissionCustomMouseClicked

    private void jTextFieldForFatherNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldForFatherNameMouseClicked
        // TODO add your handling code here:
        jLabelForCheckFatherName.setText("");
    }//GEN-LAST:event_jTextFieldForFatherNameMouseClicked

    private void jTextFieldForMotherNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldForMotherNameMouseClicked
        // TODO add your handling code here:
        jLabelForCheckMotherName.setText("");
    }//GEN-LAST:event_jTextFieldForMotherNameMouseClicked

    private void jTextFieldForPhoneNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldForPhoneNoMouseClicked
        // TODO add your handling code here:
        jLabelForCheckPhoneNo.setText("");
    }//GEN-LAST:event_jTextFieldForPhoneNoMouseClicked

    private void jTextFieldForEmailIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldForEmailIDMouseClicked
        // TODO add your handling code here:
        jLabelForCheckEmailID.setText("");
    }//GEN-LAST:event_jTextFieldForEmailIDMouseClicked

    private void jDateChooserForAdmissionDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserForAdmissionDataMouseClicked
        // TODO add your handling code here:
        jLabelForCheckAdmissionDate.setText("");
    }//GEN-LAST:event_jDateChooserForAdmissionDataMouseClicked

    private void jComboBoxForCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxForCourseMouseClicked
        // TODO add your handling code here:
        jLabelForCheckCourse.setText("");
    }//GEN-LAST:event_jComboBoxForCourseMouseClicked

    private void jTextFieldForPaidFeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldForPaidFeeMouseClicked
        // TODO add your handling code here:
        jLabelForCheckPaidFee.setText("");
    }//GEN-LAST:event_jTextFieldForPaidFeeMouseClicked

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
            java.util.logging.Logger.getLogger(AdmissionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmissionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmissionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmissionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdmissionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxForCourse;
    private com.toedter.calendar.JDateChooser jDateChooserForAdmissionData;
    private com.toedter.calendar.JDateChooser jDateChooserForDOB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelForAdmissionCount;
    private javax.swing.JLabel jLabelForCheckAdmissionDate;
    private javax.swing.JLabel jLabelForCheckCourse;
    private javax.swing.JLabel jLabelForCheckDOB;
    private javax.swing.JLabel jLabelForCheckEmailID;
    private javax.swing.JLabel jLabelForCheckFatherName;
    private javax.swing.JLabel jLabelForCheckFirstName;
    private javax.swing.JLabel jLabelForCheckGender;
    private javax.swing.JLabel jLabelForCheckLastName;
    private javax.swing.JLabel jLabelForCheckMotherName;
    private javax.swing.JLabel jLabelForCheckPaidFee;
    private javax.swing.JLabel jLabelForCheckPhoneNo;
    private javax.swing.JLabel jLabelForCheckStudentID;
    private javax.swing.JLabel jLabelForCheckStudentImage;
    private javax.swing.JLabel jLabelForCourseFee;
    private javax.swing.JLabel jLabelForUnpaidFee;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonAdmissionCustom;
    private javax.swing.JRadioButton jRadioButtonAdmissionFemale;
    private javax.swing.JRadioButton jRadioButtonAdmissionMale;
    private javax.swing.JTextField jTextFieldForEmailID;
    private javax.swing.JTextField jTextFieldForFatherName;
    private javax.swing.JTextField jTextFieldForFirstName;
    private javax.swing.JTextField jTextFieldForLastName;
    private javax.swing.JTextField jTextFieldForMotherName;
    private javax.swing.JTextField jTextFieldForPaidFee;
    private javax.swing.JTextField jTextFieldForPhoneNo;
    private javax.swing.JTextField jTextFieldForStudentID;
    // End of variables declaration//GEN-END:variables
}
