/*
GradeBook class with a constructor to initialize the course name and
course's instructor
 */

public class GradeBook {

    private String courseName; //course name for this Gradebook
    private String courseInstructorName;


    //constructor initializes courseName with String argument
    public GradeBook(String courseName, String instructorName) {
        this.courseName = courseName; //associate the field with the parameter
        courseInstructorName = instructorName; //don't need 'this.' if its a different name
    }


    //method to set the course name
    public void setCourseName(String courseName) {
        this.courseName = courseName; //store the course name
    }

    //method to retrieve the course name
    public String getCourseName() {
        return courseName;
    }

    //method to set course's instructor
    public void setCourseInstructorName(String courseInstructorName) {
        this.courseInstructorName = courseInstructorName;
    }

    //method to retrieve course's instructor
    public String getCourseInstructorName() {
        return courseInstructorName;
    }

    //utility method displays a formatted message
    public void displayMessage() {

        //this statement calls getCourseName to get the name of
        // the course this GradeBook represents and also also getCourseInstructorName
        // to get the name of the Instructor of the course
        System.out.printf("Welcome to the grade book for\n%s!\n" +
                        "This course is presented by: %s\n",
                getCourseName(), getCourseInstructorName());

    }

} //end class GradeBook
