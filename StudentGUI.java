
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class StudentGUI implements ActionListener {
    private JFrame frame;

    //Login Page
    //Initializing swing components for Login page Panel
    private JPanel panelLoginPage;
    private JLabel userName, password, loginTitle, passwordUsername;
    private JTextField userNameTF;
    private JPasswordField passwordTF;
    private JButton login;

    //Regular
    //Initializing swing components for Regular GUI Panel
    private JPanel panelTop, panelMid, panelBottomMid, panelBottom;
    private JLabel title, studName, enrollId, courseName, courseDuraition, tuitionFee, numOfModules, daysPresent, creditHours, dateOfBirth, enrollDate, ppEnrollId, ppDayPresent, gcEnrollId, gcCourseName, gcEnrollDate, regularSwitch, dropoutSwitch;
    private JTextField studNameTF, enrollIdTF, courseDurationTF, tuitionFeeTF, numOfModulesTF, daysPresentTF, creditHoursTF, ppEnrollIdTF, ppDayPresentTF, gcEnrollIdTF, gcCourseNameTF;
    private JComboBox dobD, dobM, dobY, doeD, doeM, doeY, gcDoeD, gcDoeM, gcDoeY, courseNameTF;
    private JButton addStudent, grantCertificate, clear, calculatePresentPercentage, display;
    private ArrayList<Student> studentArray = new ArrayList<>();

    //Dropout
    //Initializing swing components for Dropout GUI panels
    private JPanel panelMid1, panelBottomMid1, panelBottom1;
    private JLabel studName1, enrollId1, courseName1, courseDuraition1, tuitionFee1, numOfMonthAttended, dateOfBirth1, enrollDate1, numOfremainingModules, dateOfDropout, billsPaybleEnrollId, removeStudentEnrollId;
    private JTextField studName1TF, enrollId1TF, courseDuration1TF, tuitionFee1TF, numOfMonthAttendedTF, numOfRemainingModules1TF, billsPaybleEnrollIdTF, removeStudentEnrollIdTF;
    private JComboBox dobD1, dobM1, dobY1, doeD1, doeM1, doeY1, dodD, dodM, dodY, courseName1TF;
    private JButton addDropout, payBills, removeDropout, display1, clear1, switchRegular, switchDropout;
    Font font = new Font("Helvetica", Font.BOLD, 14); //Creating custom font with object
    Font font1 = new Font("Helvetica", Font.BOLD, 12);
    Color darkBlue = new Color(29, 54, 95);  //Creating new color
    Color white = new Color(247, 248, 250);
    Color lightGrey = new Color(0, 0, 0, 129);
    Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Desktop\\Logo.png");

    //Constructor for this class
    public StudentGUI() {
//    ---------------------------------------------------   Login Page   -------------------------------------------

        panelLoginPage = new JPanel(); //Making new object
        panelLoginPage.setBounds(304, 180, 262, 300); //Defining where the component should sit
        panelLoginPage.setLayout(null);
        panelLoginPage.setBackground(white); //Changing background color

        //Title
        loginTitle = new JLabel("LOGIN HERE");
        loginTitle.setBounds(75, 36, 122, 25);
        loginTitle.setFont(new Font("Helvetica", Font.BOLD, 18)); //Setting font
        panelLoginPage.add(loginTitle); //Adding to Panel

        //Username
        userName = new JLabel("Username");
        userName.setBounds(35, 85, 60, 17);
        userName.setFont(font1);
        panelLoginPage.add(userName);
        userNameTF = new JTextField();
        userNameTF.setBounds(35, 104, 191, 27);
        panelLoginPage.add(userNameTF);

        //Password
        password = new JLabel("Password");
        password.setBounds(35, 136, 56, 17);
        password.setFont(font1);
        panelLoginPage.add(password);
        passwordTF = new JPasswordField();
        passwordTF.setBounds(35, 155, 191, 27);
        panelLoginPage.add(passwordTF);

        //Login Button
        login = new JButton("Login");
        login.setBounds(59, 216, 144, 32);
        login.setBackground(darkBlue);  //Changing color of Background
        login.setForeground(Color.white); //Changing color of Text
        login.addActionListener(this); //Adding action listener to this button
        panelLoginPage.add(login);

        //For Password Username hints
        passwordUsername = new JLabel("*Username: Admin ,Password: Pass* ");
        passwordUsername.setBounds(100, 282, 150, 11);
        passwordUsername.setFont(new Font("Helvetica", Font.BOLD, 8));
        passwordUsername.setForeground(lightGrey);
        panelLoginPage.add(passwordUsername);

// ----------------------------------------------------    Frame     ---------------------------------------------
        frame = new JFrame("Student Management System");
        frame.setIconImage(icon);  //Setting logo to this software

//    ---------------------------------------------------   Panel Top   -------------------------------------------
        panelTop = new JPanel();
        panelTop.setBounds(0, 0, 870, 121);
        panelTop.setBackground(Color.gray);
        panelTop.setLayout(null);
        panelTop.setBackground(darkBlue);

//        Title
        title = new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Helvetica", Font.BOLD, 20));
        title.setBounds(248, 43, 354, 35);
        title.setForeground(white);
        panelTop.add(title);

//       ------------------------------ Switch Buttons  ---------------------------
        switchRegular = new JButton("Switch To Regular");
        panelTop.add(switchRegular);
        switchRegular.setBounds(680, 74, 140, 27);
        switchRegular.addActionListener(this);
        switchRegular.setVisible(false);

        switchDropout = new JButton("Switch To Dropout");
        panelTop.add(switchDropout);
        switchDropout.setBounds(680, 74, 140, 27);
        switchDropout.addActionListener(this);
        switchDropout.setBackground(new Color(29, 54, 95, 218));
        switchDropout.setForeground(white);
        switchRegular.setBackground(new Color(29, 54, 95, 218));
        switchRegular.setForeground(white);


//      ======================================================    Regular    ==================================================================

//        -----------------------------------    PanelMid     ---------------------------------------------------

        panelMid = new JPanel();
        panelMid.setBounds(0, 121, 870, 282);
        panelMid.setLayout(null);
        panelMid.setBackground(white);

//      Student Name
        studName = new JLabel("Student Name:");
        studName.setBounds(45, 39, 108, 20);
        studName.setFont(font);
        panelMid.add(studName);
        studNameTF = new JTextField();
        studNameTF.setBounds(173, 33, 250, 32);
        panelMid.add(studNameTF);

//        Course Name
        courseName = new JLabel("Course Name:");
        courseName.setBounds(45, 86, 108, 20);
        courseName.setFont(font);
        panelMid.add(courseName);
        String[] courses = {"Java", "Python", "Logic and Problem", "Networking", "Database", "Software Development", "App Development", "AI and ML", "Java Frameworks"};
        courseNameTF = new JComboBox(courses);
        courseNameTF.setBounds(173, 82, 250, 32);
        panelMid.add(courseNameTF);
        courseNameTF.setBackground(white);  //setting background color
        courseNameTF.setForeground(Color.black); //Setting text color

//        Tuition Fee
        tuitionFee = new JLabel("Tuition Fee:");
        tuitionFee.setBounds(45, 133, 108, 20);
        tuitionFee.setFont(font);
        panelMid.add(tuitionFee);
        tuitionFeeTF = new JTextField();
        tuitionFeeTF.setBounds(173, 127, 250, 32);
        panelMid.add(tuitionFeeTF);

//        Enrollment Date
        String[] days = new String[30];
        for (int i = 1; i <= 30; i++) {
//        Tuition Fee
            tuitionFee = new JLabel("Tuition Fee:");
            tuitionFee.setBounds(20, 75, 100, 40);
            days[i - 1] = Integer.toString(i);
        }
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] years = new String[25];
        for (int i = 1999; i <= 2023; i++) {
            years[i - 1999] = Integer.toString(i);
        }
        enrollDate = new JLabel("Enroll Date:");
        enrollDate.setFont(font);
        enrollDate.setBounds(45, 179, 108, 20);
        panelMid.add(enrollDate);
        doeD = new JComboBox(days);
        doeD.setBounds(173, 174, 54, 32);
        doeM = new JComboBox(months);
        doeM.setBounds(236, 174, 107, 32);
        doeY = new JComboBox(years);
        doeY.setBounds(352, 174, 71, 32);
        dateComboboxStyle(doeD, doeM, doeY);
        panelMid.add(doeY);
        panelMid.add(doeM);
        panelMid.add(doeD);


//        Date of Birth
        dateOfBirth = new JLabel("Date of Birth:");
        dateOfBirth.setBounds(45, 223, 108, 20);
        dateOfBirth.setFont(font);
        panelMid.add(dateOfBirth);
        dobD = new JComboBox(days);
        dobD.setBounds(173, 218, 54, 32);
        dobM = new JComboBox(months);
        dobM.setBounds(236, 218, 107, 32);
        dobY = new JComboBox(years);
        dobY.setBounds(352, 218, 71, 32);
        dateComboboxStyle(dobD, dobM, dobY);
        panelMid.add(dobD);
        panelMid.add(dobM);
        panelMid.add(dobY);

//        Enrollment ID
        enrollId = new JLabel("Enrollment ID:");
        enrollId.setBounds(529, 38, 108, 20);
        enrollId.setFont(font);
        panelMid.add(enrollId);
        enrollIdTF = new JTextField();
        enrollIdTF.setBounds(665, 33, 140, 32);
        panelMid.add(enrollIdTF);

//        Course Duration
        courseDuraition = new JLabel("Course Duration:");
        courseDuraition.setBounds(529, 86, 124, 20);
        courseDuraition.setFont(font);
        panelMid.add(courseDuraition);
        courseDurationTF = new JTextField();
        courseDurationTF.setBounds(665, 80, 140, 32);
        panelMid.add(courseDurationTF);

//        Number Of Modules
        numOfModules = new JLabel("Total Modules:");
        numOfModules.setBounds(529, 134, 108, 20);
        numOfModules.setFont(font);
        panelMid.add(numOfModules);
        numOfModulesTF = new JTextField();
        numOfModulesTF.setBounds(665, 127, 140, 32);
        panelMid.add(numOfModulesTF);

        //        Days Present
        daysPresent = new JLabel("Days Present:");
        daysPresent.setBounds(529, 178, 108, 20);
        daysPresent.setFont(font);
        panelMid.add(daysPresent);
        daysPresentTF = new JTextField();
        daysPresentTF.setBounds(665, 172, 140, 32);
        panelMid.add(daysPresentTF);

//        Credit Hours
        creditHours = new JLabel("Credit Hours:");
        creditHours.setBounds(529, 222, 108, 20);
        creditHours.setFont(font);
        panelMid.add(creditHours);
        creditHoursTF = new JTextField();
        creditHoursTF.setBounds(665, 218, 140, 32);
        panelMid.add(creditHoursTF);

//     --------------------------------------------   Panel Bottom Mid -----------------------------------------------------
        panelBottomMid = new JPanel();
        panelBottomMid.setBounds(0, 403, 870, 68);
        panelBottomMid.setLayout(null);

//        Add Student Button
        addStudent = new JButton("Add Student");
        addStudent.setBounds(67, 18, 195, 32);
        addStudent.addActionListener(this);
        panelBottomMid.add(addStudent);
        buttonStyle(addStudent);

//        Clear Button
        clear = new JButton("Clear All");
        clear.setBounds(328, 18, 195, 32);
        clear.addActionListener(this);
        panelBottomMid.add(clear);
        buttonStyle(clear);

//        Display Button
        display = new JButton("Display Information");
        display.setBounds(589, 18, 195, 32);
        display.addActionListener(this);
        panelBottomMid.add(display);
        buttonStyle(display);
//        ----------------------------------------  Panel Bottom  --------------------------------------------------------
        panelBottom = new JPanel();
        panelBottom.setBounds(0, 471, 870, 210);
//        panelBottom.setBorder(blackline);
        panelBottom.setLayout(null);
        panelBottom.setBackground(white);


        ppEnrollId = new JLabel("Enrollment ID");
        ppEnrollId.setFont(font);
        ppEnrollId.setBounds(45, 19, 109, 21);
        panelBottom.add(ppEnrollId);
        ppEnrollIdTF = new JTextField();
        ppEnrollIdTF.setBounds(45, 38, 213, 28);
        panelBottom.add(ppEnrollIdTF);

//        Present Percentage - Days Present
        ppDayPresent = new JLabel("Days Present ");
        ppDayPresent.setBounds(45, 68, 104, 21);
        ppDayPresent.setFont(font);
        panelBottom.add(ppDayPresent);
        ppDayPresentTF = new JTextField();
        ppDayPresentTF.setBounds(45, 88, 213, 28);
        panelBottom.add(ppDayPresentTF);

//       Present Percentage - Calculate Percentage Button
        calculatePresentPercentage = new JButton("Calculate Present Percent");
        calculatePresentPercentage.setBounds(45, 129, 213, 35);
        calculatePresentPercentage.addActionListener(this);
        buttonStyle(calculatePresentPercentage);
        panelBottom.add(calculatePresentPercentage);

//        Grant Certificate - Enrollment ID
        gcEnrollId = new JLabel("Enrollment ID");
        gcEnrollId.setFont(font);
        gcEnrollId.setBounds(555, 19, 109, 21);
        panelBottom.add(gcEnrollId);

        gcEnrollIdTF = new JTextField();
        gcEnrollIdTF.setBounds(555, 38, 98, 28);
        panelBottom.add(gcEnrollIdTF);

//        Grant Certificate - Course name
        gcCourseName = new JLabel("Course Name");
        gcCourseName.setFont(font);
        gcCourseName.setBounds(700, 19, 110, 21);
        panelBottom.add(gcCourseName);

        gcCourseNameTF = new JTextField();
        gcCourseNameTF.setBounds(662, 38, 143, 28);
        panelBottom.add(gcCourseNameTF);

//        Grant Certificate - Date of Enrollment
        gcEnrollDate = new JLabel("Enrollment Date");
        gcEnrollDate.setFont(font);
        gcEnrollDate.setBounds(555, 67, 120, 21);
        panelBottom.add(gcEnrollDate);
        gcDoeD = new JComboBox(days);
        gcDoeD.setBounds(555, 89, 54, 32);
        gcDoeM = new JComboBox(months);
        gcDoeM.setBounds(618, 89, 107, 32);
        gcDoeY = new JComboBox(years);
        gcDoeY.setBounds(734, 89, 71, 32);
        dateComboboxStyle(gcDoeD, gcDoeM, gcDoeY);
        panelBottom.add(gcDoeD);
        panelBottom.add(gcDoeM);
        panelBottom.add(gcDoeY);

        grantCertificate = new JButton("Grant Certificate");
        grantCertificate.setBounds(555, 129, 250, 35);
        grantCertificate.addActionListener(this);
        panelBottom.add(grantCertificate);
        buttonStyle(grantCertificate);

// ========================================================================   Dropout Class  ====================================================================


//        -------------------------------------------------------------   PanelMid1    -----------------------------------------------------------------------------
        panelMid1 = new JPanel();
        panelMid1.setBounds(0, 121, 870, 282);
//        panelMid1.setBorder(blackline);
        panelMid1.setLayout(null);
        panelMid1.setBackground(white);

//        Student Name
        studName1 = new JLabel("Student Name:");
        studName1.setBounds(45, 39, 108, 20);
        studName1.setFont(font);
        panelMid1.add(studName1);
        studName1TF = new JTextField();
        studName1TF.setBounds(173, 33, 250, 32);
        panelMid1.add(studName1TF);

//        Course Name
        courseName1 = new JLabel("Course Name:");
        courseName1.setBounds(45, 86, 108, 20);
        courseName1.setFont(font);
        panelMid1.add(courseName1);
        courseName1TF = new JComboBox(courses);
        courseName1TF.setBounds(173, 82, 250, 32);
        courseName1TF.setBackground(white);
        courseName1TF.setForeground(Color.black);
        panelMid1.add(courseName1TF);

        //        Dropout Date
        dateOfDropout = new JLabel("Dropout Date:");
        dateOfDropout.setFont(font);
        dateOfDropout.setBounds(45, 133, 108, 20);
        panelMid1.add(dateOfDropout);
        dodD = new JComboBox(days);
        dodD.setBounds(175, 127, 54, 32);
        dodM = new JComboBox(months);
        dodM.setBounds(238, 127, 107, 32);
        dodY = new JComboBox(years);
        dodY.setBounds(354, 127, 69, 32);
        dateComboboxStyle(dodD, dodM, dodY);
        panelMid1.add(dodD);
        panelMid1.add(dodM);
        panelMid1.add(dodY);


//      Enrollment Date
        enrollDate1 = new JLabel("Enroll Date:");
        enrollDate1.setFont(font);
        enrollDate1.setBounds(45, 179, 108, 20);
        panelMid1.add(enrollDate1);
        doeD1 = new JComboBox(days);
        doeD1.setBounds(173, 174, 54, 32);
        doeM1 = new JComboBox(months);
        doeM1.setBounds(236, 174, 107, 32);
        doeY1 = new JComboBox(years);
        doeY1.setBounds(352, 174, 71, 32);
        dateComboboxStyle(doeD1, doeM1, doeY1);
        panelMid1.add(doeY1);
        panelMid1.add(doeM1);
        panelMid1.add(doeD1);

//        Date of Birth
        dateOfBirth1 = new JLabel("Date of Birth:");
        dateOfBirth1.setBounds(45, 223, 108, 20);
        dateOfBirth1.setFont(font);
        panelMid1.add(dateOfBirth1);
        dobD1 = new JComboBox(days);
        dobD1.setBounds(173, 218, 54, 32);
        dobM1 = new JComboBox(months);
        dobM1.setBounds(236, 218, 107, 32);
        dobY1 = new JComboBox(years);
        dobY1.setBounds(352, 218, 71, 32);
        dateComboboxStyle(dobD1, dobM1, dobY1);
        panelMid1.add(dobD1);
        panelMid1.add(dobM1);
        panelMid1.add(dobY1);

//        Enrollment ID
        enrollId1 = new JLabel("Enrollment ID:");
        enrollId1.setBounds(529, 38, 108, 20);
        enrollId1.setFont(font);
        panelMid1.add(enrollId1);
        enrollId1TF = new JTextField();
        enrollId1TF.setBounds(665, 33, 140, 32);
        panelMid1.add(enrollId1TF);

//        Course Duration
        courseDuraition1 = new JLabel("Course Duration:");
        courseDuraition1.setBounds(529, 86, 124, 20);
        courseDuraition1.setFont(font);
        panelMid1.add(courseDuraition1);
        courseDuration1TF = new JTextField();
        courseDuration1TF.setBounds(665, 80, 140, 32);
        panelMid1.add(courseDuration1TF);

        //      Tuition Fee
        tuitionFee1 = new JLabel("Tuition Fee:");
        tuitionFee1.setBounds(529, 131, 88, 20);
        tuitionFee1.setFont(font);
        panelMid1.add(tuitionFee1);
        tuitionFee1TF = new JTextField();
        tuitionFee1TF.setBounds(665, 126, 139, 32);
        panelMid1.add(tuitionFee1TF);


//        Num of Month attended
        numOfMonthAttended = new JLabel("Month Attended:");
        numOfMonthAttended.setBounds(529, 178, 140, 20);
        numOfMonthAttended.setFont(font);
        panelMid1.add(numOfMonthAttended);
        numOfMonthAttendedTF = new JTextField();
        numOfMonthAttendedTF.setBounds(665, 172, 140, 32);
        panelMid1.add(numOfMonthAttendedTF);

//        Number Of Remaining Modules
        numOfremainingModules = new JLabel("Remaining Modules:");
        numOfremainingModules.setBounds(515, 224, 140, 20);
        numOfremainingModules.setFont(font);
        panelMid1.add(numOfremainingModules);
        numOfRemainingModules1TF = new JTextField();
        numOfRemainingModules1TF.setBounds(665, 218, 140, 32);
        panelMid1.add(numOfRemainingModules1TF);

//        --------------------------------------------------------------    PanelBottomMid1    -------------------------------------------------------------
        panelBottomMid1 = new JPanel();
        panelBottomMid1.setBounds(0, 403, 870, 68);
        panelBottomMid1.setLayout(null);

//        Add Dropout Button
        addDropout = new JButton("Add Dropout");
        addDropout.setBounds(67, 18, 195, 32);
        addDropout.addActionListener(this);
        panelBottomMid1.add(addDropout);
        buttonStyle(addDropout);

//        Clear Button
        clear1 = new JButton("Clear All");
        clear1.setBounds(328, 18, 195, 32);
        clear1.addActionListener(this);
        buttonStyle(clear1);
        panelBottomMid1.add(clear1);


//        Display Button
        display1 = new JButton("Display Information");
        display1.setBounds(589, 18, 195, 32);
        display1.addActionListener(this);
        buttonStyle(display1);
        panelBottomMid1.add(display1);

//        ---------------------------------------------------------  PanelBottom1  ------------------------------------------------------------------------------

        panelBottom1 = new JPanel();
        panelBottom1.setBounds(0, 455, 870, 225);
        panelBottom1.setLayout(null);
        panelBottom1.setBackground(white);

//-------------------------------  Bills Payable ---------------------------
        billsPaybleEnrollId = new JLabel("Enrollment ID");
        billsPaybleEnrollId.setBounds(70, 54, 109, 21);
        billsPaybleEnrollId.setFont(font);
        panelBottom1.add(billsPaybleEnrollId);
        billsPaybleEnrollIdTF = new JTextField();
        billsPaybleEnrollIdTF.setBounds(70, 75, 187, 28);
        panelBottom1.add(billsPaybleEnrollIdTF);

        payBills = new JButton("Pay Bills");
        payBills.setBounds(70, 109, 187, 35);
        buttonStyle(payBills);
        panelBottom1.add(payBills);
        payBills.addActionListener(this);

//----------------------------  Remove Dropout ---------------
        removeStudentEnrollId = new JLabel("Enrollment ID");
        removeStudentEnrollId.setBounds(682, 54, 109, 21);
        removeStudentEnrollId.setFont(font);
        panelBottom1.add(removeStudentEnrollId);
        removeStudentEnrollIdTF = new JTextField();
        removeStudentEnrollIdTF.setBounds(593, 75, 187, 28);
        panelBottom1.add(removeStudentEnrollIdTF);

        removeDropout = new JButton("Remove Student");
        removeDropout.setBounds(593, 109, 187, 35);
        buttonStyle(removeDropout);
        panelBottom1.add(removeDropout);
        removeDropout.addActionListener(this);

//      ====================================================================     FRAME    ====================================================================

        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setLayout(null);
        getFrame().setSize(870, 720);
        getFrame().setVisible(true);
        getFrame().setResizable(false);
        getFrame().add(getPanelTop());
        getFrame().add(getPanelMid());
        getFrame().add(getPanelBottomMid());
        getFrame().add(getPanelBottom());
        getFrame().add(panelLoginPage);
        getPanelMid().setVisible(false);
        getPanelBottomMid().setVisible(false);
        getPanelBottom().setVisible(false);
        switchDropout.setVisible(false);
        getPanelTop().setVisible(false);

    }

    //    =================================================================   Getters    =============================================================================
    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanelTop() {
        return panelTop;
    }

    public JPanel getPanelMid() {
        return panelMid;
    }

    public JPanel getPanelBottomMid() {
        return panelBottomMid;
    }

    public JPanel getPanelBottom() {
        return panelBottom;
    }

    public JTextField getStudNameTF() {
        return studNameTF;
    }

    public JTextField getEnrollIdTF() {
        return enrollIdTF;
    }

    public JComboBox getCourseNameTF() {
        return courseNameTF;
    }

    public JTextField getCourseDurationTF() {
        return courseDurationTF;
    }

    public JTextField getTuitionFeeTF() {
        return tuitionFeeTF;
    }

    public JTextField getNumOfModulesTF() {
        return numOfModulesTF;
    }

    public JTextField getDaysPresentTF() {
        return daysPresentTF;
    }

    public JTextField getCreditHoursTF() {
        return creditHoursTF;
    }

    public JTextField getPpEnrollIdTF() {
        return ppEnrollIdTF;
    }

    public JTextField getPpDayPresentTF() {
        return ppDayPresentTF;
    }

    public JTextField getGcEnrollIdTF() {
        return gcEnrollIdTF;
    }

    public JTextField getGcCourseNameTF() {
        return gcCourseNameTF;
    }

    public JComboBox getDobD() {
        return dobD;
    }

    public JComboBox getDobM() {
        return dobM;
    }

    public JComboBox getDobY() {
        return dobY;
    }

    public JComboBox getDoeD() {
        return doeD;
    }

    public JComboBox getDoeM() {
        return doeM;
    }

    public JComboBox getDoeY() {
        return doeY;
    }

    public JComboBox getGcDoeD() {
        return gcDoeD;
    }

    public JComboBox getGcDoeM() {
        return gcDoeM;
    }

    public JComboBox getGcDoeY() {
        return gcDoeY;
    }

    public JTextField getStudName1TF() {
        return studName1TF;
    }

    public JTextField getEnrollId1TF() {
        return enrollId1TF;
    }

    public JTextField getCourseDuration1TF() {
        return courseDuration1TF;
    }

    public JTextField getTuitionFee1TF() {
        return tuitionFee1TF;
    }

    public JTextField getNumOfRemainingModules1TF() {
        return numOfRemainingModules1TF;
    }

    public JTextField getBillsPaybleEnrollIdTF() {
        return billsPaybleEnrollIdTF;
    }

    public JTextField getRemoveStudentEnrollIdTF() {
        return removeStudentEnrollIdTF;
    }

    public JTextField getNumOfMonthAttendedTF() {
        return numOfMonthAttendedTF;
    }

    public JComboBox getDobD1() {
        return dobD1;
    }

    public JComboBox getDobM1() {
        return dobM1;
    }

    public JComboBox getDobY1() {
        return dobY1;
    }

    public JComboBox getDoeD1() {
        return doeD1;
    }

    public JComboBox getDoeM1() {
        return doeM1;
    }

    public JComboBox getDoeY1() {
        return doeY1;
    }

    public JComboBox getDodD() {
        return dodD;
    }

    public JComboBox getDodM() {
        return dodM;
    }

    public JComboBox getDodY() {
        return dodY;
    }

    public JComboBox getCourseName1TF() {
        return courseName1TF;
    }

    public JPanel getPanelMid1() {
        return panelMid1;
    }

    public JPanel getPanelBottomMid1() {
        return panelBottomMid1;
    }

    public JPanel getPanelBottom1() {
        return panelBottom1;
    }

    public ArrayList<Student> getStudentArray() {
        return studentArray;
    }

    public JTextField getUserNameTF() {
        return userNameTF;
    }

    public JPasswordField getPasswordTF() {
        return passwordTF;
    }

    public JPanel getPanelLoginPage() {
        return panelLoginPage;
    }

    public void actionPerformed(ActionEvent e) {

        //When user press login button
        if (e.getSource() == login) {
            login();
        }

//When switchDropout button is pressed
        if (e.getSource() == switchDropout) {
            switchToDropout();
        }
// When switchRegular button is pressed
        if (e.getSource() == switchRegular) {
            switchToRegular();
        }
//        When Add Student button is clicked
        if (e.getSource() == addStudent) {
            try {
                addRegularStudent();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(getFrame(), "Something went wrong! \n Make sure to provide integers value inside required text fields.\n Error Type: " + error, "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }

//        When Add Dropout button is clicked
        if (e.getSource() == addDropout) {
            try {
                addDropoutStudent();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(getFrame(), "Something went wrong! \n Make sure to provide integers value inside required text fields. \n Error Type: " + error, "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == calculatePresentPercentage) {
            try {
                findPresentPercentageFromEnrollId();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(getFrame(), "Please Enter the values in correct manner ! \n Error Type: " + error, "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
//       When Grant Certificate button is Clicked
        if (e.getSource() == grantCertificate) {
            try {
                findGrantCertificateAndDisplayInfo();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(getFrame(), "Please Enter the values in correct manner ! \n Error Type: " + error, "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
//        When Clear All button is clicked
        if (e.getSource() == clear) {
            clearRegular();
            JOptionPane.showMessageDialog(getFrame(), "Cleared Successfully!", "Cleared", JOptionPane.INFORMATION_MESSAGE);
        }
//        When pay bill button is clicked
        if (e.getSource() == payBills) {
            try {
                payBills();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(getFrame(), "Something went wrong ! \n Error Type: " + error, "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
//        When Clear All button is clicked
        if (e.getSource() == clear1) {
            clearDropout();
            JOptionPane.showMessageDialog(getFrame(), "Cleared Successfully!", "Cleared", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == removeDropout) {
            try {
                removeStudent();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(getFrame(), "Please Enter the values in correct manner ! \n Error Type: " + error, "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == display) {
            displayRegular();
        }

        if (e.getSource() == display1) {
            displayDropout();
        }
    }

    //    Method for Adding regular Student into ArrayList of Student Object
    public void addRegularStudent() {
        if (checkRegularInputs()) {
            String studentName = getStudNameTF().getText();

            String courseName = (String) getCourseNameTF().getSelectedItem();
            int tuitionFee = parseInt(getTuitionFeeTF().getText());
            int enrollmentId = parseInt(getEnrollIdTF().getText());
            int courseDuration = parseInt(getCourseDurationTF().getText());
            int numOfModules = parseInt(getNumOfModulesTF().getText());
            int daysPresent = parseInt(getDaysPresentTF().getText());
            int creditHours = parseInt(getCreditHoursTF().getText());
            String enrollmentDate = getDoeD().getSelectedItem() + "-" + getDoeM().getSelectedItem() + "-" + getDoeY().getSelectedItem();
            String dateOfBirth = getDobD().getSelectedItem() + "-" + getDobM().getSelectedItem() + "-" + getDobY().getSelectedItem();
            boolean duplicateRegular = false; //Only true when duplicate found
            //For each loop to iterate through array list
            for (Student students : getStudentArray()) {
                //Check if object is of Regular class or not
                if (students instanceof Regular) {
                    //Verify the enrollment ID
                    if (students.getEnrollmentID() == enrollmentId) {
                        JOptionPane.showMessageDialog(getFrame(), "Duplicate found ! \nCan't add student of same Enrollment ID twice", "Duplicate Found", JOptionPane.OK_OPTION);
                        duplicateRegular = true;
                        break;
                    }
                }
            }
            //If no duplicate found
            if (!duplicateRegular) {
                //Check if days present is greater than course duration
                if (daysPresent > courseDuration) {
                    JOptionPane.showMessageDialog(getFrame(), "Days present can't be greater than total course duration !", "Warning", JOptionPane.ERROR_MESSAGE);
                } else {
                    //Create object of Regular
                    Regular stud = new Regular(dateOfBirth, studentName, courseDuration, tuitionFee, enrollmentId, courseName, enrollmentDate, numOfModules, creditHours, daysPresent);
                    //Add object to array list
                    getStudentArray().add(stud);
                    JOptionPane.showMessageDialog(getFrame(), "Student added Successfully!");

                }
            }
        }
        else {
            JOptionPane.showMessageDialog(getFrame(), "Fields are empty. Please make sure to fill every text fields properly!", "Empty Text Field Found", JOptionPane.ERROR_MESSAGE);
        }
    }

    //    Method for Adding dropout Student into ArrayList of Student Object
    public void addDropoutStudent() {
        if (checkDropoutInputs()) {
            String studentName = getStudName1TF().getText();
            String courseName = (String) getCourseName1TF().getSelectedItem();
            int tuitionFee = parseInt(getTuitionFee1TF().getText());
            int enrollmentId = parseInt(getEnrollId1TF().getText());
            int courseDuration = parseInt(getCourseDuration1TF().getText());
            int numOfRemainingModules = parseInt(getNumOfRemainingModules1TF().getText());
            String enrollmentDate = getDoeD1().getSelectedItem() + "-" + getDoeM1().getSelectedItem() + "-" + getDoeY1().getSelectedItem();
            String dateOfBirth = getDobD1().getSelectedItem() + "-" + getDobM1().getSelectedItem() + "-" + getDobY1().getSelectedItem();
            String dateOfDropout = getDodD().getSelectedItem() + "-" + getDodM().getSelectedItem() + "-" + getDodY().getSelectedItem();
            int numOfMonthAttended = parseInt(getNumOfMonthAttendedTF().getText());
            boolean duplicateDropout = false;  //Only true when duplicate found
            for (Student students : getStudentArray()) {
                if (students instanceof Dropout) {
                    if (students.getEnrollmentID() == enrollmentId) {
                        JOptionPane.showMessageDialog(getFrame(), "Duplicate found ! \nCan't add student of same Enrollment ID twice", "Duplicate Found", JOptionPane.OK_OPTION);
                        duplicateDropout = true;
                        break;
                    }
                }
            }
            if (!duplicateDropout) {
                //Check if number of month attended is greater than course duration or not
                if (courseDuration < numOfMonthAttended * 30) {
                    JOptionPane.showMessageDialog(getFrame(), "Months attended can't be greater than total course duration !", "Warning", JOptionPane.ERROR_MESSAGE);
                } else {
                    Dropout stud = new Dropout(dateOfBirth, studentName, courseDuration, tuitionFee, enrollmentId, courseName, enrollmentDate, numOfRemainingModules, numOfMonthAttended, dateOfDropout);
                    getStudentArray().add(stud);
                    JOptionPane.showMessageDialog(getFrame(), "Dropout student added Successfully!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(getFrame(), "Fields are empty. Please make sure to fill every text fields properly!", "Empty Text Field Found", JOptionPane.ERROR_MESSAGE);
        }
    }


    //    Method for clearing all the inputs of TedxFields
    public void clearRegular() {
        getStudNameTF().setText(""); //Setting text field value to empty string
        getEnrollIdTF().setText("");
        getCourseNameTF().setSelectedIndex(0);  //Setting comboBox to default first option
        getDaysPresentTF().setText("");
        getCreditHoursTF().setText("");
        getCourseDurationTF().setText("");
        getTuitionFeeTF().setText("");
        getNumOfModulesTF().setText("");
        getDoeY().setSelectedIndex(0);
        getDoeM().setSelectedIndex(0);
        getDoeD().setSelectedIndex(0);
        getDobY().setSelectedIndex(0);
        getDobM().setSelectedIndex(0);
        getDobD().setSelectedIndex(0);
        getPpEnrollIdTF().setText("");
        getPpDayPresentTF().setText("");
        getGcEnrollIdTF().setText("");
        getGcCourseNameTF().setText("");
        getGcDoeY().setSelectedIndex(0);
        getGcDoeM().setSelectedIndex(0);
        getGcDoeD().setSelectedIndex(0);

    }

    public void clearDropout() {
        getStudName1TF().setText("");
        getCourseName1TF().setSelectedIndex(0);
        getEnrollId1TF().setText("");
        getCourseDurationTF().setText("");
        getTuitionFee1TF().setText("");
        getNumOfMonthAttendedTF().setText("");
        getNumOfRemainingModules1TF().setText("");
        getCourseDuration1TF().setText("");
        getDobD().setSelectedIndex(0);
        getDobM().setSelectedIndex(0);
        getDodY().setSelectedIndex(0);
        getDobY1().setSelectedIndex(0);
        getDobM1().setSelectedIndex(0);
        getDobD1().setSelectedIndex(0);
        getDoeY1().setSelectedIndex(0);
        getDoeM1().setSelectedIndex(0);
        getDoeD1().setSelectedIndex(0);
        getBillsPaybleEnrollIdTF().setText("");
        getRemoveStudentEnrollIdTF().setText("");
    }

    //    Method for find Present Percentage and Attendance Grade
    public void findPresentPercentageFromEnrollId() {
        int ppEnrollId = Integer.parseInt(ppEnrollIdTF.getText());
        int daysPresent = Integer.parseInt(ppDayPresentTF.getText());
        boolean found = false;  //Only true if student with provided enrollment id is found
        for (Student students : getStudentArray()) {
            if (students instanceof Regular) {
                if (students.getEnrollmentID() == ppEnrollId) {
                    Regular student = ((Regular) students); //Typecasting Student object into Regular
                    //Checking is days present is greater than course uration or not
                    if (daysPresent > student.getCourseDuration()) {
                        JOptionPane.showMessageDialog(getFrame(), "Present days can't be greater then total course duration !", "Waring", JOptionPane.ERROR_MESSAGE);

                    }
                    //If course duration is not greater than course duration
                    else {
                        JOptionPane.showMessageDialog(getFrame(), "Attendance Information ! \n" +
                                "Name: " + student.getStudentName() + "\n" +
                                "Attendance Grade: " + student.presentPercentage(daysPresent) + "\n" +
                                "Present Percentage: " + new DecimalFormat("##.##").format(student.getPercentage()) + " %", "Attendance Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                    found = true;
                    break;

                }
            }
        }
        //If student with given enrollment id not found
        if (!found) {
            JOptionPane.showMessageDialog(getFrame(), "Sorry! The can't find student you're searching for.", "Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }

    //    Method to grant certificate and scholarship is deserved
    public void findGrantCertificateAndDisplayInfo() {
        int gcEnrollmentId = parseInt(gcEnrollIdTF.getText());
        String gcCourseName = gcCourseNameTF.getText();
        String gcEnrollDate = getGcDoeD().getSelectedItem() + " - " + getGcDoeM().getSelectedItem() + " - " + getGcDoeY().getSelectedItem();
        boolean gcFound = false; ////Only true if student with provided enrollment id is found
        for (Student students : getStudentArray()) {
            if (students instanceof Regular) {
                if (students.getEnrollmentID() == gcEnrollmentId) {
                    Regular student = ((Regular) students);
                    boolean isGrantedScholarship = student.grantCertificate(gcCourseName, gcEnrollmentId, gcEnrollDate); //Calling method of Regular class
                    if (isGrantedScholarship) {
                        JOptionPane.showMessageDialog(getFrame(), student.getStudentName() + " has been graduated successfully ! \n Course Name: " + gcCourseName + "\n Enrollment Id: " + student.getEnrollmentID() + "\n Enrollment Date: " + gcEnrollDate + "\n Congratulation, The student is also awarded with Scholarship.", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(getFrame(), student.getStudentName() + " has been graduated successfully ! \n Course Name: " + gcCourseName + "\n Enrollment Id: " + student.getEnrollmentID() + "\n Enrollment Date: " + gcEnrollDate, "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                    }
                    gcFound = true;
                    break;
                }
            }
        }
        if (!gcFound) {
            JOptionPane.showMessageDialog(getFrame(), "Sorry! The can't find student you're searching for.", "Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }

    //    Method to find bills payable of Dropout Student
    public void payBills() {
        int enrollmentID = parseInt(getBillsPaybleEnrollIdTF().getText());
        boolean payBillsFound = false; //Only true if student with provided enrollment id is found
        for (Student students : getStudentArray()) {
            if (students instanceof Dropout) {
                if (students.getEnrollmentID() == enrollmentID) {
                    Dropout student = ((Dropout) students); //Typecasting Student object into Dropout
                    student.billsPayable(); //Calling method of Dropout class
                    student.setHasPaid(false); //
                    JOptionPane.showMessageDialog(getFrame(), "Remaining amount for " + student.getStudentName() + " is: Rs." + student.getRemainingAmount() + "\nPlease proceed to pay the bill !", "Remaining Amount", JOptionPane.INFORMATION_MESSAGE);
                    int receivedAmount = parseInt(JOptionPane.showInputDialog(getFrame(), "Due Amount " + student.getRemainingAmount() + "\nEnter the amount to be paid:"));
//                    Checking if remaining amount matches the user entered amount or not
                    if (student.getRemainingAmount() == receivedAmount) {
                        student.setHasPaid(true);
                        JOptionPane.showMessageDialog(getFrame(), "Bills paid Successfully!", "Bill Paid", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(getFrame(), "Received amount doesn't match to total remaining due. \n Please try again !", "Bill Paid", JOptionPane.WARNING_MESSAGE);
                    }
                    payBillsFound = true;
                    break;
                }
            }
        }
        if (!payBillsFound) {
            JOptionPane.showMessageDialog(getFrame(), "Sorry! The can't find student you're searching for.", "Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to remove dropout student if dues are cleared
    public void removeStudent() {
        int enrollmentID = parseInt(getRemoveStudentEnrollIdTF().getText());
        boolean removeStudent = false; ////Only true if student with provided enrollment id is found
        for (Student students : getStudentArray()) {
            if (students instanceof Dropout) {
                if (students.getEnrollmentID() == enrollmentID) {
                    Dropout student = ((Dropout) students);
                    student.removeStudent(); //calling method from Dropout class
                    if (student.getHasPaid()) {
                        JOptionPane.showMessageDialog(getFrame(), "Student removed Successfully !");
                        studentArray.remove(student); //Remove from array list
                    } else {
                        JOptionPane.showMessageDialog(getFrame(), "Dues not cleared. Please clear all the Dues first !", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    removeStudent = true;
                    break;
                }
            }
        }
        if (!removeStudent) {
            JOptionPane.showMessageDialog(getFrame(), "Sorry! The can't find student you're searching for.", "Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayRegular() {
        System.out.println("\n\n+++++++++++++++++++++++++++\nDetails of Regular Students\n+++++++++++++++++++++++++++\n \n");
        for (Student students : getStudentArray()) {
            if (students instanceof Regular) {
                students.display(); //Calling method from Regular class
                System.out.println("\n");
            }
        }
    }

    public void displayDropout() {
        System.out.println("\n\n+++++++++++++++++++++++++++\nDetails of Dropout Students\n+++++++++++++++++++++++++++\n \n");
        for (Student students : getStudentArray()) {
            if (students instanceof Dropout) {
                students.display();  //Calling method from Dropout class
                System.out.println("\n");
            }
        }
    }

    // Add style to the JButtons
    public void buttonStyle(JButton button) {
        button.setBackground(darkBlue);
        button.setForeground(white);
    }

    // Add style to JCombo box of Date input
    public void dateComboboxStyle(JComboBox comboBoxD, JComboBox comboBoxM, JComboBox comboBoxY) {
        comboBoxM.setBackground(white);
        comboBoxM.setForeground(Color.black);
        comboBoxD.setBackground(white);
        comboBoxD.setForeground(Color.black);
        comboBoxY.setBackground(white);
        comboBoxY.setForeground(Color.black);
    }

    public void switchToDropout() {
        // Hide panels of Regular class GUI
        getPanelMid().setVisible(false);
        getPanelBottomMid().setVisible(false);
        getPanelBottom().setVisible(false);
        //Add panels of Dropout class GUI to frame
        getFrame().add(getPanelMid1());
        getFrame().add(getPanelBottomMid1());
        getFrame().add(getPanelBottom1());
        //Unhide panels of Dropout class GUI
        getPanelMid1().setVisible(true);
        getPanelBottomMid1().setVisible(true);
        getPanelBottom1().setVisible(true);
        //Hide button that switch GUI to dropout
        switchDropout.setVisible(false);
        //Unhide button that switch GUI to regular
        switchRegular.setVisible(true);

    }

    public void switchToRegular() {
        //Unide panels of regular class GUI
        getPanelMid().setVisible(true);
        getPanelBottomMid().setVisible(true);
        getPanelBottom().setVisible(true);
        //Hide panels of Dropout class GUI
        getPanelMid1().setVisible(false);
        getPanelBottomMid1().setVisible(false);
        getPanelBottom1().setVisible(false);
        switchRegular.setVisible(false);
        switchDropout.setVisible(true);
    }

    public void switchLoginPage() {
        getPanelLoginPage().setVisible(false);
        getPanelMid().setVisible(true);
        getPanelBottomMid().setVisible(true);
        getPanelBottom().setVisible(true);
        switchDropout.setVisible(true);
        getPanelTop().setVisible(true);
        getPanelMid1().setVisible(false);
        getPanelBottomMid1().setVisible(false);
        getPanelBottom1().setVisible(false);
        switchRegular.setVisible(false);
    }

    public void login() {
        //Check if entered Password and username is valid or not
        if (getUserNameTF().getText().equals("Admin") && String.valueOf(getPasswordTF().getPassword()).equals("Pass")) {
            switchLoginPage();
        } else {
            JOptionPane.showMessageDialog(getFrame(), "Username and Password didn't matched !\n Please try again with valid credentials.", "Unothorized Access", JOptionPane.ERROR_MESSAGE);
            getUserNameTF().setText("");
            getPasswordTF().setText("");
        }
    }

    //Method to verify if all the text field of Dropout class is filled or not
    public boolean checkDropoutInputs() {
        return !getStudName1TF().getText().isEmpty() &&
                !getTuitionFee1TF().getText().isEmpty() &&
                !getEnrollId1TF().getText().isEmpty() &&
                !getCourseDuration1TF().getText().isEmpty() &&
                !getNumOfRemainingModules1TF().getText().isEmpty() &&
                !getNumOfMonthAttendedTF().getText().isEmpty();
    }
    //Method to verify if all the text field of Regular class is filled or not
    public boolean checkRegularInputs() {
        return !getStudNameTF().getText().isEmpty() &&
                !getEnrollIdTF().getText().isEmpty() &&
                !getDaysPresentTF().getText().isEmpty() &&
                !getCreditHoursTF().getText().isEmpty() &&
                !getCourseDurationTF().getText().isEmpty() &&
                !getTuitionFeeTF().getText().isEmpty() &&
                !getNumOfModulesTF().getText().isEmpty();
    }

    public static void main(String[] args) {
        new StudentGUI(); //Creating a object of StudentGUI
    }
}
