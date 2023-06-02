/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_Software;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rocky
 */
public class UpdateForm extends javax.swing.JFrame {

    /**
     * Creates new form UpdateForm
     */
    public UpdateForm() {
        initComponents();
        //stringForStudentID= "RitiKCoder101";
        mysqlConnection();
        DataFillIntoTheFormFields("RitikCoder101");
    }

    public UpdateForm(String stringForGetStudentID) {
        initComponents();
        stringForStudentID = stringForGetStudentID;
        //System.out.println(stringForGetStudentID);
        mysqlConnection();
        DataFillIntoTheFormFields(stringForStudentID);
    }

    //Globally Variables and Reference variables;
    int intForStudentSrNo;
    String stringForStudentID;
    java.sql.Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    boolean booleanForMatchedAdminPassword = false;
    boolean booleanForCheckValidationOFAllFields = false;
    String stringForGenderMatching= null;
    String stringForCourse = null;
    int intForCourseFee= 0, intForPaidFee, intForUnpaidFee, intForpayFee;

    //This method is used to Estabilized mysql database connection.
    public void mysqlConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String stringForURL = "jdbc:mysql://localhost:3306/learningcomputer";
            String stringForUser = "root";
            String stringForPassword = "RitikCoder@mysql";
            connection = (java.sql.Connection) DriverManager.getConnection(stringForURL, stringForUser, stringForPassword);
            statement = connection.createStatement();
            System.out.println("Connection Estabilized successfully.");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error Occure inside of Mysql connection method.");
        }
    }

    //This Method is used to Fill all files to this form while showing.
    public void DataFillIntoTheFormFields(String stringForStudentID1) {
        //System.out.println(stringForStudentID1);
        try {
            String stringForExecuteQuery = "Select Student_ID, Name, DOB, Gender, Course, Father_Name, Mother_Name, Phone_No, Email_ID "
                    + ", Course_Fee, Paid_Fee, Unpaid_Fee, Sr_No from studentdata";
            preparedStatement = connection.prepareStatement(stringForExecuteQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (stringForStudentID1.equalsIgnoreCase(resultSet.getString(1))) {
                    String stringForStudentID = resultSet.getString(1);
                    String stringForName = resultSet.getString(2);
                    String stringForDOB = resultSet.getString(3);
                    String stringForGender = resultSet.getString(4);
                    String stringForCourse = resultSet.getString(5);
                    String stringForFatherName = resultSet.getString(6);
                    String stringForMotherName = resultSet.getString(7);
                    String stringForPhoneNo = resultSet.getString(8);
                    String stringForEmailID = resultSet.getString(9);
                    String stringForCourseFee = resultSet.getString(10);
                    String stringForPaidFee = resultSet.getString(11);
                    String stringForUnpaidFee = resultSet.getString(12);
                    intForStudentSrNo= resultSet.getInt(13);
                    //System.out.println(stringForStudentID);
                    //System.out.println(stringForCourseFee);
                    //System.out.println(stringForPaidFee);
                    //System.out.println(stringForUnpaidFee);
//                    System.out.println("Sr_No is := "+ intForStudentSrNo);

                    //Spleteation of Full name into First name and Last name.
                    String str[] = stringForName.split("\\s");
                    String stringForFirstName = str[0];
                    String stringForLastName = str[1];
                    //System.out.println(stringForFirstName);
                    //System.out.println(stringForLastName);
                    //for(String stringForSeperateName: str){
                    //System.out.println(stringForSeperateName);

                    //Initialization of Update form fields.
                    jTextFieldForFirstName.setText(stringForFirstName);//initialization of First Name Field.
                    jTextFieldForLastName.setText(stringForLastName);//initialization of Last Name Field.

                    //String date to jDateChoose conversion is here.
                    Date date = null;
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        date = (Date) simpleDateFormat.parse(stringForDOB);
                        //System.out.println(date);
                        //jDateChooserForDOB.setDate(date);

                    } catch (Exception e) {
                        System.out.println("Error found inside of String date converter");
                    }

                    jDateChooserForDOB.setDate(date);//initialization of JDateChoose DOB Field.

                    //Setting of Gender into the jRadio buuton.
                    if (stringForGender.equals("Male")) {
                        jRadioButtonForUpdateMale.setSelected(true);
                    } else if (stringForGender.equals("Female")) {
                        jRadioButtonForUpdateFemale.setSelected(true);
                    } else if (stringForGender.equals("Custom")) {
                        jRadioButtonForUpdateCustom.setSelected(true);
                    }

                    //Setting of Course into the jCombobox.
                    if (stringForCourse.equals("DCA")) {
                        jComboBoxForCourseSelection.setSelectedIndex(1);
                        jLabelForCourseFee.setText("Course Fee :- 4500");
                    } else if (stringForCourse.equals("ADCA")) {
                        jComboBoxForCourseSelection.setSelectedIndex(2);
                        jLabelForCourseFee.setText("Course Fee :- 6500");
                    } else if (stringForCourse.equals("ADCP")) {
                        jComboBoxForCourseSelection.setSelectedIndex(3);
                        jLabelForCourseFee.setText("Course Fee :- 12500");
                    } else if (stringForCourse.equals("Programming")) {
                        jComboBoxForCourseSelection.setSelectedIndex(4);
                        jLabelForCourseFee.setText("Course Fee :- 12500");
                    } else if (stringForCourse.equals("Android development")) {
                        jComboBoxForCourseSelection.setSelectedItem(5);
                        jLabelForCourseFee.setText("Course Fee :- 12500");
                    } else if (stringForCourse.equals("Web development")) {
                        jComboBoxForCourseSelection.setSelectedItem(6);
                        jLabelForCourseFee.setText("Course Fee :- 12500");
                    } else if (stringForCourse.equals("Telly")) {
                        jComboBoxForCourseSelection.setSelectedIndex(7);
                        jLabelForCourseFee.setText("Course Fee :- 6000");
                    } else {
                        jComboBoxForCourseSelection.setSelectedIndex(0);
                        jLabelForCourseFee.setText("Course Fee :- 000000");
                    }

                    jLabelForPaidFee.setText("Paid Fee :- " + stringForPaidFee);//initialization of Paid Fee Field.
                    jLabelForUnpaidFee.setText("Unpaid Fee :- " + stringForUnpaidFee);

                    //setting Pay Fee field by using some conditions,
                    int Fee1 = Integer.parseInt(stringForUnpaidFee);
                    if (Fee1 == 0) {
                        jTextFieldForPayFee.setText("  Full");//initialization of Pay Fee Field.
                        jTextFieldForPayFee.setEditable(false);
                        jTextFieldForPayFee.setText("");//initialization of Pay Fee Field.
                    }
                    if(intForPaidFee== 0){
                        jTextFieldForPayFee.setText("");
                    }
//                    if(intForUnpaidFee== 0){
//                        jTextFieldForPayFee.setEditable(false);
//                    }

                    jTextFieldForFatherName.setText(stringForFatherName);//initialization of Father Name Field.
                    jTextFieldForMotherName.setText(stringForMotherName);//initialization of Mother Name Field.
                    jTextFieldForPhoneNo.setText(stringForPhoneNo);//initialization of Phone No Field.
                    jTextFieldForEmailID.setText(stringForEmailID);//initialization of Email ID Field.

                    //System.out.println(stringForDOB);
                    //System.out.println(stringForGender);
                    //System.out.println(stringForCourse);
                    //System.out.println(stringForFatherName);
                    //System.out.println(stringForMotherName);
                    //System.out.println(stringForPhoneNo);
                    //System.out.println(stringForEmailID);
                    //System.out.println(stringForAdmissionDate);
                }
            }

        } catch (SQLException exception) {
            System.out.println("Error occur inside of DataFillIntoTheFormFields");
        }
    }

    //Method of close window.
    public void closeMethod() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    //Code to check all fields Exceptions.
    void checkingExceptionOfAllFields(){
        if (jTextFieldForFirstName.getText().trim().isEmpty()) {
                jLabelForInvalidFirstName.setText("Empty First Name");
                booleanForCheckValidationOFAllFields = false;
            }else{
                booleanForCheckValidationOFAllFields= true;
            }
            if (jTextFieldForLastName.getText().trim().isEmpty()) {
                jLabelForInvalidLastName.setText("Empty Last Name");
                booleanForCheckValidationOFAllFields = false;
            }else{
                booleanForCheckValidationOFAllFields= true;
            }
//            SimpleDateFormat simpleDateFormatForDOB= new SimpleDateFormat("dd-MM-yyyy");
//            String stringForDOB= simpleDateFormatForDOB.format(jDateChooserForDOB.getDate());
//            if(stringForDOB.trim().isEmpty()){
//                jLabelForInvalidDOB.setText("Empty Date");
//                booleanForCheckValidationOFAllFields = false;
//            }else{
//                booleanForCheckValidationOFAllFields= true;
//            }
            if(jRadioButtonForUpdateMale.isSelected()){
                booleanForCheckValidationOFAllFields= false;
            }else if(jRadioButtonForUpdateFemale.isSelected()){
                booleanForCheckValidationOFAllFields= false;
            }else if(jRadioButtonForUpdateCustom.isSelected()){
                booleanForCheckValidationOFAllFields= false;
            }else{
                booleanForCheckValidationOFAllFields= true;
            }
            if(jComboBoxForCourseSelection.getSelectedIndex()== 0){
                jLabelForInvalidCourse.setText("Select Course");
                booleanForCheckValidationOFAllFields= false;
            }else{
                booleanForCheckValidationOFAllFields= true;
            }
            if(jTextFieldForFatherName.getText().trim().isEmpty()){
                jLabelForInvalidFatherName.setText("Empty Father name");
                booleanForCheckValidationOFAllFields= false;
            }else{
                booleanForCheckValidationOFAllFields= true;
            }
            if(jTextFieldForMotherName.getText().trim().isEmpty()){
                jLabelForInvalidMotherName.setText("Empty Mother name");
                booleanForCheckValidationOFAllFields= false;
            }else{
                booleanForCheckValidationOFAllFields= true;
            }
            if(jTextFieldForPhoneNo.getText().trim().isEmpty()){
                jLabelForInvalidPhoneNo.setText("Empty Phone no");
                booleanForCheckValidationOFAllFields= false;
            }else{
                booleanForCheckValidationOFAllFields= true;
            }
            if(jTextFieldForEmailID.getText().trim().isEmpty()){
                jLabelForInvalidEmailID.setText("Empty Email");
                booleanForCheckValidationOFAllFields= false;
            }else{
                booleanForCheckValidationOFAllFields= true;
            }
            
            
            //if(intForUpdateCondition== 8){
                //booleanForCheckValidationOFAllFields= true;
            //}
    }
    
    //This Method is used to Calculate Unpaid fee.
    void unpaidFee(){
        if("Full".equals(jTextFieldForPayFee.getText().trim())){
            System.out.println("Fee is := "+ jTextFieldForPayFee.getText().trim());
            intForpayFee= 0;
        }else if(jTextFieldForPayFee.getText().trim().isEmpty()){
            intForpayFee= 0;
        }else{
        intForpayFee= Integer.parseInt(jTextFieldForPayFee.getText());
        }
        String str1= jLabelForCourseFee.getText();
        intForCourseFee= Integer.parseInt(str1.substring(14));
        String str3= jLabelForUnpaidFee.getText();
        intForUnpaidFee= Integer.parseInt(str3.substring(14));
        jLabelForUnpaidFee.setText("Unpaid Fee :- "+ (intForUnpaidFee- intForpayFee));
        String str2= jLabelForPaidFee.getText();
        int int1= Integer.parseInt(str2.substring(12));
        intForPaidFee= (int1+ intForpayFee);
        jLabelForPaidFee.setText("Paid Fee :- "+ intForPaidFee);
        
        //System.out.println(intForpayFee);
        //System.out.println(intForCourseFee);
        //System.out.println(intForPaidFee);
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
        jLabel3 = new javax.swing.JLabel();
        jTextFieldForFirstName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtonForUpdateCustom = new javax.swing.JRadioButton();
        jRadioButtonForUpdateMale = new javax.swing.JRadioButton();
        jRadioButtonForUpdateFemale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldForFatherName = new javax.swing.JTextField();
        jComboBoxForCourseSelection = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldForLastName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldForPayFee = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldForMotherName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldForPhoneNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jDateChooserForDOB = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabelForUnpaidFee = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelForCourseFee = new javax.swing.JLabel();
        jLabelForPaidFee = new javax.swing.JLabel();
        jTextFieldForEmailID = new javax.swing.JTextField();
        jLabelForInvalidPayFee = new javax.swing.JLabel();
        jLabelForInvalidFirstName = new javax.swing.JLabel();
        jLabelForInvalidLastName = new javax.swing.JLabel();
        jLabelForInvalidDOB = new javax.swing.JLabel();
        jLabelForInvalidGender = new javax.swing.JLabel();
        jLabelForInvalidCourse = new javax.swing.JLabel();
        jLabelForInvalidFatherName = new javax.swing.JLabel();
        jLabelForInvalidMotherName = new javax.swing.JLabel();
        jLabelForInvalidPhoneNo = new javax.swing.JLabel();
        jLabelForInvalidEmailID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update window");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Update");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Last Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Father's name :-");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jTextFieldForFirstName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldForFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 180, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("First Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("DOB :-");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jRadioButtonForUpdateCustom.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jRadioButtonForUpdateCustom.setText("Custom");
        jRadioButtonForUpdateCustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonForUpdateCustomActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonForUpdateCustom, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jRadioButtonForUpdateMale.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jRadioButtonForUpdateMale.setText("Male");
        jRadioButtonForUpdateMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonForUpdateMaleActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonForUpdateMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        jRadioButtonForUpdateFemale.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jRadioButtonForUpdateFemale.setText("Female");
        jRadioButtonForUpdateFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonForUpdateFemaleActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonForUpdateFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("Gender :- ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jTextFieldForFatherName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldForFatherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 230, 30));

        jComboBoxForCourseSelection.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jComboBoxForCourseSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Your Course", "DCA", "ADCA", "ADCP", "Programming", "Android development", "Web development", "Telly" }));
        jComboBoxForCourseSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxForCourseSelectionActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxForCourseSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 230, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setText("Course :-");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jTextFieldForLastName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldForLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 180, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel8.setText("@RitikCoder.com");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, -1, 30));

        jTextFieldForPayFee.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldForPayFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForPayFeeActionPerformed(evt);
            }
        });
        jTextFieldForPayFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldForPayFeeKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldForPayFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 100, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setText("Mother's name :-");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jTextFieldForMotherName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldForMotherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 230, 30));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setText("Phone no. :-");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jTextFieldForPhoneNo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldForPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 230, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setText("Email ID :-");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jDateChooserForDOB.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(jDateChooserForDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 230, 30));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 630, 120, 40));

        jButton2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 120, 40));

        jLabelForUnpaidFee.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelForUnpaidFee.setText("Unpaid Fee :- 000000");
        jPanel1.add(jLabelForUnpaidFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 180, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Pay Fee :-");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 90, -1));

        jLabelForCourseFee.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelForCourseFee.setText("Course Fee :- 000000");
        jPanel1.add(jLabelForCourseFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 180, -1));

        jLabelForPaidFee.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelForPaidFee.setText("Paid Fee :- 000000");
        jPanel1.add(jLabelForPaidFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 180, -1));

        jTextFieldForEmailID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(jTextFieldForEmailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 230, 30));

        jLabelForInvalidPayFee.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jPanel1.add(jLabelForInvalidPayFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 190, 20));

        jLabelForInvalidFirstName.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jPanel1.add(jLabelForInvalidFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 180, 20));

        jLabelForInvalidLastName.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jPanel1.add(jLabelForInvalidLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 180, 20));

        jLabelForInvalidDOB.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jPanel1.add(jLabelForInvalidDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 180, 20));

        jLabelForInvalidGender.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jPanel1.add(jLabelForInvalidGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 180, 20));

        jLabelForInvalidCourse.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jPanel1.add(jLabelForInvalidCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 180, 20));

        jLabelForInvalidFatherName.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jPanel1.add(jLabelForInvalidFatherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 180, 20));

        jLabelForInvalidMotherName.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jPanel1.add(jLabelForInvalidMotherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 180, 20));

        jLabelForInvalidPhoneNo.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jPanel1.add(jLabelForInvalidPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 180, 20));

        jLabelForInvalidEmailID.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jPanel1.add(jLabelForInvalidEmailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 180, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonForUpdateMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonForUpdateMaleActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonForUpdateMale.isSelected()) {
            jRadioButtonForUpdateFemale.setSelected(false);
            jRadioButtonForUpdateCustom.setSelected(false);
            stringForGenderMatching= "Male";
        }
    }//GEN-LAST:event_jRadioButtonForUpdateMaleActionPerformed

    private void jRadioButtonForUpdateFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonForUpdateFemaleActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonForUpdateFemale.isSelected()) {
            jRadioButtonForUpdateMale.setSelected(false);
            jRadioButtonForUpdateCustom.setSelected(false);
            stringForGenderMatching= "Female";
        }
    }//GEN-LAST:event_jRadioButtonForUpdateFemaleActionPerformed

    private void jRadioButtonForUpdateCustomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonForUpdateCustomActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonForUpdateCustom.isSelected()) {
            jRadioButtonForUpdateMale.setSelected(false);
            jRadioButtonForUpdateFemale.setSelected(false);
            stringForGenderMatching= "Custom";
        }
    }//GEN-LAST:event_jRadioButtonForUpdateCustomActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

            checkingExceptionOfAllFields();//Method calling to check Exception of all fields.
            booleanForCheckValidationOFAllFields=  true;
            
        if (booleanForCheckValidationOFAllFields) {
            String stringForComformPasswrodToUpdateRecord = JOptionPane.showInputDialog("Enter your password here.");
            //System.out.println(stringForComformPasswrodToUpdateRecord);
            try {
                String stringForExecuteQuery = "SELECT Password from loginadmin";
                preparedStatement = connection.prepareStatement(stringForExecuteQuery);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (stringForComformPasswrodToUpdateRecord.equalsIgnoreCase(resultSet.getString(1))) {
                        booleanForMatchedAdminPassword = false;
                        //Code to Update data into the mysql database;
                        //Variable Creation for get data into the Update form fields.
                        String stringForFirstName= jTextFieldForFirstName.getText();
                        String stringForLastName= jTextFieldForLastName.getText();
                        String stringForFullname= stringForFirstName+" "+ stringForLastName;
                        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy");
                        String stringForDOB= simpleDateFormat.format(jDateChooserForDOB.getDate());
                        String stringForGender= new String();
                        if(stringForGenderMatching== null){
                            if(jRadioButtonForUpdateMale.isSelected()){
                                stringForGender= "Male";
                            }else if(jRadioButtonForUpdateFemale.isSelected()){
                                stringForGender= "Female";
                            }else if(jRadioButtonForUpdateCustom.isSelected()){
                                stringForGender= "Custom";
                            }
                        }else{
                            stringForGender= stringForGenderMatching;
                        }
//                        String stringForGender= stringForGenderMatching;
                        String stringForSelectedCourse= new String();
                        if(stringForCourse== null){
                            int intForGetSelectedIndexOfCourseBox= jComboBoxForCourseSelection.getSelectedIndex();
                            if(intForGetSelectedIndexOfCourseBox== 1){
                                stringForSelectedCourse= "DCA";
                            }else if(intForGetSelectedIndexOfCourseBox== 2){
                                stringForSelectedCourse= "ADCA";
                            }else if(intForGetSelectedIndexOfCourseBox== 3){
                                stringForSelectedCourse= "ADCP";
                            }else if(intForGetSelectedIndexOfCourseBox== 4){
                                stringForSelectedCourse= "Programming";
                            }else if(intForGetSelectedIndexOfCourseBox== 5){
                                stringForSelectedCourse= "Android develeopment";
                            }else if(intForGetSelectedIndexOfCourseBox== 6){
                                stringForSelectedCourse= "Web development";
                            }else if(intForGetSelectedIndexOfCourseBox== 7){
                                stringForSelectedCourse= "Telly";
                            }
                        }else{
                            stringForSelectedCourse= stringForCourse;
                        }
//                        String stringForSelectedCourse= stringForCourse;
                        String stringForFatherName= jTextFieldForFatherName.getText();
                        String stringForMotherName= jTextFieldForMotherName.getText();
                        String stringForPhoneNO= jTextFieldForPhoneNo.getText();
                        String stringForEmailID= jTextFieldForEmailID.getText();
                        unpaidFee();//Methodcolling.
                        int intForCourseFeeMain= intForCourseFee;
                        String stringForPaidFeeString= new String();
                        int intForPaidFeeMain= intForPaidFee;
                        int intForUnpaidFeeMain= intForUnpaidFee- intForpayFee;
                        
//                        System.out.println(stringForFullname);
//                        System.out.println(stringForDOB);
//                        System.out.println(stringForGender);
//                        System.out.println(stringForSelectedCourse);
//                        System.out.println(stringForFatherName);
//                        System.out.println(stringForMotherName);
                        //System.out.println(stringForPhoneNO);
                        //System.out.println(stringForEmailID);
                        //System.out.println("course fee :- "+intForCourseFeeMain);
                        //System.out.println("paid fee :- "+intForPaidFeeMain);
                        //System.out.println("Unpadi fee :- "+ intForUnpaidFeeMain);
                        
                        //mysql connection is here.
                        try{
                            String stringForExecuteQuery1= "UPDATE studentdata set Name=?, DOB=?, Gender=?, Course=?, "
                                    + "Father_Name=?, Mother_Name=?, Phone_No=?, Email_ID=?, Course_Fee=?, Paid_Fee=?, Unpaid_Fee=? "
                                    + "where Sr_No= "+ intForStudentSrNo+"";
                            preparedStatement= connection.prepareStatement(stringForExecuteQuery1);
                            preparedStatement.setString(1, stringForFullname);
                            preparedStatement.setString(2, stringForDOB);
                            preparedStatement.setString(3, stringForGender);
                            preparedStatement.setString(4, stringForSelectedCourse);
                            preparedStatement.setString(5, stringForFatherName);
                            preparedStatement.setString(6, stringForMotherName);
                            preparedStatement.setString(7, stringForPhoneNO);
                            preparedStatement.setString(8, stringForEmailID);
                            preparedStatement.setInt(9, intForCourseFeeMain);
                            preparedStatement.setInt(10, intForPaidFeeMain);
                            preparedStatement.setInt(11, intForUnpaidFeeMain);
                            //resultSet= preparedStatement.executeUpdate();
                            //System.out.println("Fine1 till the here");
                            preparedStatement.executeUpdate();
                            //System.out.println("Fine2 till the here");
                            JOptionPane.showMessageDialog(null, "Record Updated Successfully. !");
                            stringForPaidFeeString= String.valueOf(0);
//                            TableForAllStudentData tableForAllStudentData= new TableForAllStudentData();
//                            tableForAllStudentData.setVisible(false);
//                            tableForAllStudentData.setVisible(true);
//                            this.setVisible(false);
                            this.dispose();
                            break;
                            
                        }catch(SQLException exception){
                            JOptionPane.showMessageDialog(null, "Error occur inside of Update button while updating data := "+ exception);
                            booleanForMatchedAdminPassword = false;
                        }
                    } else {
                        booleanForMatchedAdminPassword = true;
                    }
                }

                //Password Checking condition.
                if (booleanForMatchedAdminPassword) {
                    JOptionPane.showMessageDialog(null, "Password is Invalid!");
                }else{
                connection.close();
                }

            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, "Error Occur inside of Update button := "+ exception);
            }
            booleanForCheckValidationOFAllFields= false;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        System.exit(0);
        closeMethod();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxForCourseSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxForCourseSelectionActionPerformed
        // TODO add your handling code here:
        int SelectIndexOfJComboBoxForCourse = jComboBoxForCourseSelection.getSelectedIndex();
        if (SelectIndexOfJComboBoxForCourse == 1) {
            jLabelForCourseFee.setText("Course Fee :- 4500");
            stringForCourse = "DCA";
        } else if (SelectIndexOfJComboBoxForCourse == 2) {
            jLabelForCourseFee.setText("Course Fee :- 6500");
            stringForCourse = "ADCA";
        } else if (SelectIndexOfJComboBoxForCourse == 3) {
            jLabelForCourseFee.setText("Course Fee :- 12500");
            stringForCourse = "ADCP";
        } else if (SelectIndexOfJComboBoxForCourse == 4) {
            jLabelForCourseFee.setText("Course Fee :- 12500");
            stringForCourse = "Programming";
        } else if (SelectIndexOfJComboBoxForCourse == 5) {
            jLabelForCourseFee.setText("Course Fee :- 12500");
            stringForCourse = "Android development";
        } else if (SelectIndexOfJComboBoxForCourse == 6) {
            jLabelForCourseFee.setText("Course Fee :- 12500");
            stringForCourse = "Web development";
        } else if (SelectIndexOfJComboBoxForCourse == 7) {
            jLabelForCourseFee.setText("Course Fee :- 6000");
            stringForCourse = "Telly";
        } else {
            jLabelForCourseFee.setText("Course Fee :- 000000");
            //jLabelForPaidFee.setText("Paid Fee :- 000000");
            //jLabelForUnpaidFee.setText("Unpaid Fee :- 000000");
        }
    }//GEN-LAST:event_jComboBoxForCourseSelectionActionPerformed

    private void jTextFieldForPayFeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldForPayFeeKeyPressed
        // TODO add your handling code here:
//        unpaidFee();
    }//GEN-LAST:event_jTextFieldForPayFeeKeyPressed

    private void jTextFieldForPayFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForPayFeeActionPerformed
        // TODO add your handling code here:
        unpaidFee();
    }//GEN-LAST:event_jTextFieldForPayFeeActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxForCourseSelection;
    private com.toedter.calendar.JDateChooser jDateChooserForDOB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelForCourseFee;
    private javax.swing.JLabel jLabelForInvalidCourse;
    private javax.swing.JLabel jLabelForInvalidDOB;
    private javax.swing.JLabel jLabelForInvalidEmailID;
    private javax.swing.JLabel jLabelForInvalidFatherName;
    private javax.swing.JLabel jLabelForInvalidFirstName;
    private javax.swing.JLabel jLabelForInvalidGender;
    private javax.swing.JLabel jLabelForInvalidLastName;
    private javax.swing.JLabel jLabelForInvalidMotherName;
    private javax.swing.JLabel jLabelForInvalidPayFee;
    private javax.swing.JLabel jLabelForInvalidPhoneNo;
    private javax.swing.JLabel jLabelForPaidFee;
    private javax.swing.JLabel jLabelForUnpaidFee;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonForUpdateCustom;
    private javax.swing.JRadioButton jRadioButtonForUpdateFemale;
    private javax.swing.JRadioButton jRadioButtonForUpdateMale;
    private javax.swing.JTextField jTextFieldForEmailID;
    private javax.swing.JTextField jTextFieldForFatherName;
    private javax.swing.JTextField jTextFieldForFirstName;
    private javax.swing.JTextField jTextFieldForLastName;
    private javax.swing.JTextField jTextFieldForMotherName;
    private javax.swing.JTextField jTextFieldForPayFee;
    private javax.swing.JTextField jTextFieldForPhoneNo;
    // End of variables declaration//GEN-END:variables
}
