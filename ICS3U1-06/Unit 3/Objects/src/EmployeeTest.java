public class EmployeeTest {

    //MAIN METHOD
    public static void main(String[] args) {

        //create objects
        Employee e1 = new Employee();
        Employee e2 = new Employee("Super Bob", "Guy", -2300);
        Employee e3 = new Employee("Bob", "Guy");

        //Display annual salary
        System.out.printf("employee2's annual salary is %.2f\n", e2.getMonthlySalary() * 12);
            //DON'T DO Employee.getMonthlySalary(), DO e2.getMonthlySalary()

        //Raise salaries
        e2.raise(500);

        System.out.println();

        //Display new  monthly salary
        System.out.printf("employee2's monthly salary is %.2f\n", e2.getMonthlySalary());

        //Display employee 3
        System.out.println();
        System.out.printf("employee3's name is %s %s", e3.getFirstName(), e3.getLastName());

    }

}
