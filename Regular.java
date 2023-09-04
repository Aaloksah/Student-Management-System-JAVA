//This is a child class of Students
public class Regular extends Student {
    //Initializing all the attributes
    private int numOfModules;
    private int numOfCreditHours;
    private int daysPresent;
    private boolean isGrantedScholarship;
    private double percentage;

    //Making constructor method for this class
    public Regular(String dateOfBirth, String studentName, int courseDuration, int tuitionFee, int enrollmentID, String courseName, String dateOfEnrollment,
                   int numOfModules, int numOfCreditHours, int daysPresent) {
        //calling super class constructor
        super(dateOfBirth, studentName, courseDuration, tuitionFee);
        //calling super class mutator method
        super.setEnrollmentID(enrollmentID);
        super.setCourseName(courseName);
        super.setDateOfEnrollment(dateOfEnrollment);

        //assigning parameters to attributes of main class
        this.numOfModules = numOfModules;
        this.numOfCreditHours = numOfCreditHours;
        this.daysPresent = daysPresent;
        this.isGrantedScholarship = false;
    }

    //Accessor Methods
    public int getNumOfModules() {
        return numOfModules;
    }

    public int getNumOfCreditHours() {
        return numOfCreditHours;
    }

    public int getDaysPresent() {
        return daysPresent;
    }

    public double getPercentage() {
        return percentage;
    }

    public boolean isGrantedScholarship() {
        return isGrantedScholarship;
    }

    //Method to change Number of days present into Percentage form
    public String presentPercentage(int daysPresent) {
        percentage = (daysPresent / (double) getCourseDuration()) * 100;
        this.isGrantedScholarship = false;
        //Initializing empty string to store attendance grade value
        String attendanceGrade = "";
        if (getPercentage() > 100) {
            System.out.println("Percentage exceeds 100%. Please input correctly! ");
        } else if (getPercentage() >= 80) {
            this.isGrantedScholarship = true;
            attendanceGrade = "A";
        } else if (getPercentage() >= 60) {
            attendanceGrade = "B";
        } else if (getPercentage() >= 40) {
            attendanceGrade = "C";
        } else if (getPercentage() >= 20) {
            attendanceGrade = "D";
        } else {
            attendanceGrade = "E";
        }
        return attendanceGrade;

    }

    //Method to check if Student has been  graduated and granted Scholarship or not
    public boolean grantCertificate(String courseName, int enrollmentID, String dateOfEnrollment) {
//        System.out.println("The student has Graduated from this college successfully!");
//        System.out.println("Course: " + courseName);
//        System.out.println("Enrollment ID: " + enrollmentID);
//        System.out.println("Date of Enrollment: " + dateOfEnrollment);
        if (isGrantedScholarship) {
//            System.out.println("The scholarship has been granted!");
        } else {
//            System.out.println("Sorry, the scholarship has not been granted!");
        }

        return isGrantedScholarship;
    }

    //Method to display details of Regular and Parent class by Overriding Display Method of parent class
    public void display() {
        //calling super class display method to override it
        super.display();
        System.out.println("Number of Modules is: " + getNumOfModules());
        System.out.println("Number of Credit Hours is: " + getNumOfCreditHours());
        System.out.println("Days Present is: " + getDaysPresent());
    }

}
