/*
Major skills:
GradeBook constructor used to specify the course name and instructor name
at the time each GradeBook object is created.
 */

public class GradeBookTest {

    public static void main(String[] args) {

        //create GradeBook objects (instances)
        GradeBook gradeBook1 = new GradeBook(
                "CS101 Introduction to Java Programming",
                "Mr. Bob");
        GradeBook gradeBook2 = new GradeBook(
                "CS102 Data Structures in Java",
                "Super Bob");

        //Use Gradebook public get methods to display course information
        System.out.printf("gradeBook1 course name is %s\n",
                gradeBook1.getCourseName());
        System.out.printf("gradeBook1 course is taught by %s\n",
                gradeBook1.getCourseInstructorName());

        System.out.printf("gradeBook2 course name is %s\n",
                gradeBook2.getCourseName());
        System.out.printf("gradeBook2 course is taught by %s\n",
                gradeBook2.getCourseInstructorName());

        System.out.println(); //create blank line in output

        //Use Gradebook public set method to change the course instructor for Gradebook
        gradeBook2.setCourseInstructorName("Super Duper Bob");

        //Uses Gradebook public utility method to display a message
        gradeBook1.displayMessage();
        gradeBook2.displayMessage();


    }

} //end class GradeBookTest
