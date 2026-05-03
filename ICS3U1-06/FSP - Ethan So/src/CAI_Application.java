/*
PROJECT HEADER

Name:
Ethan So

Date:
6/14/2024

Course Code:
ICS3U1-06 Mr. Fernandes

Title:
Project: Final Summative Project
Product: Computer-Assisted Instruction Application: Objects and Classes

Description:
The software being created is a Computer-Assisted Instruction Application.
A learning app of some sorts to teach a Unit in the ICS3U1 course, Objects and Classes specifically.
This software will teach the learner with slides with course content, reinforce topics learned with an interactive activity, and a quiz to test the user’s knowledge.

This application will have a Main Menu Screen leading to Concepts, Activities, Assessment.
In the Main Menu section there will be a title of the application (CAI Application),
with the topic that will be covered in the application (objects and classes) and small descriptions of the other screens.

In the Concepts section it is divided into three sections of topics.
A brief analogy to explain classes and objects. A summary of the important content in the unit (unit 3).
And then an explanation of how to make a template class and a test class with coding examples.

In the Activity section there is an activity to match terms (uses drag and drop) and an activity to drag and move the order of how to code a template class.

The Assessment section contains questions to test the user’s knowledge and understanding of objects and classes.
Questions of definitions of terms related to classes and objects. Also questions related to template classes and test/application classes.

Features:
-JMenuBar
-4 Frames that have multiple panels that are displayed one at a time using setVisible.
-A Unique Learning Logo
https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html#glue
-Usages of BoxLayout and Glue to center GUI components

-Mini Description Panels on Main Screen

-Buttons that jump to different sections of the slideshow (Concepts)
-Buttons to switch between slides (Concepts)
-How to generate code in Eclipse and IntelliJ

-A Matching Game Activity and another activity to sort the order of code for a template class
-A Destination box object class for an area to put ("snap") a draggable label
-Draggable labels so the user can drag and drop terms/items for the activity
-Ability to "snap" or drop draggable labels in place on a destination box

-2 quizzes to test the user's knowledge on Objects and Classes that use two sets of "slideshow" panels of questions
-Each quiz having the ability to go back and forth between questions
-When moving onto the next question a dialog box either displays "correct" or "incorrect" and the full correct answer
-A Quiz Question object class for the information required for each question
-A Quiz Option object class for each radiobutton option to show whether it is the correct answer or not

Major Skills:4
-Arrays
-2D Arrays
-Java swing components
-Images
-Setting fonts and colour for Java swing components
-BoxLayout
-Conditionals/Selection
-Loops
-Classes and Objects
-Methods
-JMenuBar
-ActionListener, MenuListener, MouseListener, MouseMotionListener, MouseAdapter
-Point Class (for coordinates)
-Rectangle Class (for ranges for "snapping)
-Global Variables

Areas of Concern:
-When the user goes back to the previous question on the quiz they can answer again,
 in the future would implement a way to "lock" the question once answered
-multiple labels can be dragged onto the same destination box
-NOTE: this application was created using IntelliJ not Eclipse
 */


//this class is the application class for the CAI program
//it contains all the classes, and also static methods + global variables used in the program
public class CAI_Application {

    //this method is the main method to run the program
    public static void main(String[] args) {

        openMainMenu();

    }

    //this method opens the main menu
    public static void openMainMenu() {

        //new main menu screen class by calling constructor
        new MainMenu();

    }

    //this method opens the concepts screen
    public static void openConcepts() {

        //new main menu screen class by calling constructor
        new Concepts();

    }

    //this method opens the activities screen
    public static void openActivities() {

        //new main menu screen class by calling constructor
        new Activities();

    }

    //this method opens the assessment screen
    public static void openAssessment() {

        //new main menu screen class by calling constructor
        new Assessment();

    }


}
