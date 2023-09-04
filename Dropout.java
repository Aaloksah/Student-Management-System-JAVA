//This is also a child class of Student class
public class Dropout extends Student {
    //Initializing all the attributes
    private int numOfRemainingModules;
    private int numOfMonthsAttended;
    private String dateOfDropout;
    private int remainingAmount;
    private boolean hasPaid;

    //Constructor for Dropout class
    public Dropout(String dateOfBirth, String studentName, int courseDuration, int tuitionFee, int enrollmentID, String courseName, String dateOfEnrollment,
                   int numOfRemainingModules, int numOfMonthsAttended, String dateOfDropout)
    {
        //calling parent class constructor
        super(dateOfBirth, studentName, courseDuration, tuitionFee);

        // Calling the parent class setter methods for enrollment id, course name and date of enrollment
        super.setEnrollmentID(enrollmentID);
        super.setCourseName(courseName);
        super.setDateOfEnrollment(dateOfEnrollment);

        //Assigning the value
        this.numOfRemainingModules = numOfRemainingModules;
        this.numOfMonthsAttended=numOfMonthsAttended;
        this.dateOfDropout = dateOfDropout;
        this.remainingAmount = 0;  //set default value of remainingAmount to 0
        this.hasPaid = false;  //set default value of hasPaid to false
    }

    //Accessor(Getter) methods for attributes of this class
    public int getNumOfRemainingModules() {
        return numOfRemainingModules;
    }

    public int getNumOfMonthsAttended() {
        return numOfMonthsAttended;
    }

    public String getDateOfDropout() {
        return dateOfDropout;
    }

    public int getRemainingAmount() {
        return remainingAmount;
    }

    public boolean getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid){
        this.hasPaid = hasPaid;
    }

    // Method to calculate pending tuition fee
    public boolean billsPayable() {
        remainingAmount = ( (getCourseDuration()/30)- getNumOfMonthsAttended()) * getTuitionFee(); //used the formula
//        System.out.println("The pending tuition fee (Bills Payable) is: " + getRemainingAmount());
        hasPaid = true;
        return hasPaid;
    }

    //Method to reset all data of the object student
    public void removeStudent() {
        if (hasPaid) {
            //Resseting the value to empty
            setDateOfBirth("");
            setCourseName("");
            setStudentName("");
            setDateOfEnrollment("");
            setCourseDuration(0);
            setTuitionFee(0);
            setEnrollmentID(0);
            numOfRemainingModules = 0;
            numOfMonthsAttended = 0;
            remainingAmount = 0;
            dateOfDropout = "";
        } else {
//            System.out.println("All bills not cleared");
        }
    }

    //Method to display details of Parent class and Dropout class by Overriding Display Method of parent class
    public void display() {
        super.display();
        System.out.println("The number of remaining modules is: "+ getNumOfRemainingModules());
        System.out.println("The numbers of month attended is: "+ getNumOfMonthsAttended());
        System.out.println("The date of Dropout is: "+ getDateOfDropout());
        System.out.println("The remaining amount is: "+ getRemainingAmount());
    }

}

