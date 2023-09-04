/*This is the main parent class
and it has 2 inherited child class*/
public class Student {
    //Initializing all the attributes
    private int enrollmentID;
    private String dateOfBirth;
    private String courseName;
    private String studentName;
    private String dateOfEnrollment;
    private int courseDuration;
    private int tuitionFee;

    //Making constructor for this parent class
    public Student(String dateOfBirth, String studentName, int courseDuration, int tuitionFee) {
        this.dateOfBirth = dateOfBirth;
        this.studentName = studentName;
        this.courseDuration = courseDuration;
        this.tuitionFee = tuitionFee;
        this.courseName = "";    //keeping the default value to empty
        this.dateOfEnrollment = "";
        this.enrollmentID = 0;
    }

    //Getter Methods to access the value of the private instance variable of this class into any other class within the package
    public int getEnrollmentID() {
        return this.enrollmentID;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getDateOfEnrollment() {
        return this.dateOfEnrollment;
    }

    public int getCourseDuration() {
        return this.courseDuration;
    }

    public int getTuitionFee() {
        return this.tuitionFee;
    }

    //Setter Methods to change the value of the private instance variable of this class into any other class within the package
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public void setTuitionFee(int tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public void setCourseName(String courseName) { this.courseName = courseName;
    }

    public void setDateOfEnrollment(String dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    //Display Method to display all the attributes values
    public void display() {
        if (enrollmentID == 0 || dateOfBirth.isEmpty() || studentName.isEmpty() || courseName.isEmpty() || dateOfEnrollment.isEmpty()) {
            System.out.println("Some parameters are missing. Please check and set again in correct manner!");
            //Display this if any parameter is empty
        }
        System.out.println("Enrollment ID is: " + getEnrollmentID());
        System.out.println("Date of birth is: " + getDateOfBirth());
        System.out.println("Course name is: " + getCourseName());
        System.out.println("Student name is: " + getStudentName());
        System.out.println("Years enrolled is: " + getDateOfEnrollment());
        System.out.println("Course duration is: " + getCourseDuration() + " days");
        System.out.println("Tuition fee is: " + getTuitionFee());
    }
}

