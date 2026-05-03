public class Employee {

    //Fields
    private String firstName;
    private String lastName;
    private double monthlySalary;

    //constructor methods
    //constructor for having a job but don't know the employee:
    public Employee() {

    }
    //constructor for having a job and knowing the employee:
    public Employee(String firstName, String lastName, double monthlySalary) {
        super();

        //No validation code
        //Set fields directly to their parameters
        this.firstName = firstName;
        this.lastName = lastName;

        //Validation code
        //will call set method
        setMonthlySalary(monthlySalary);

    }
    //constructor for having a job and knowing the employee:but not their salary:
    public Employee(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;

    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary < 0)
            this.monthlySalary = 0;
        else
            this.monthlySalary = monthlySalary;
    }

    //Display object on console (check parameters)
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", monthlySalary=" + monthlySalary +
                '}';
    }

    //Utility method
    public void raise(double amount) {
        //increase salary with amount inputted
        if (amount > 0)
            this.monthlySalary += amount;

    }

}
