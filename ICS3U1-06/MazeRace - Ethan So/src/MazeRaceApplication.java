/*
PROJECT HEADER

Name: Ethan So

Date: 5/26/2024

Course Code:
ICS3U1-06 Mr.Fernandes
Title: SDP #2 - MazeRace

Description:
-This project creates an application for a video game called MazeRace
-There is an opening screen that allows the user to customize their theme, character and enter their initials
-The actual game is the user running around collecting coins as fast as they can

Major Skills:
-Arrays
-Java swing components
-Loops
-Class and Objects
-Methods
-Input File Reading
-Keyboard Input
-Menu Bar
-Images

Added Features:
-Get player image to Face the Proper Direction as they move
-More Accurate Timing (tenths of seconds)
-Added a Menubar - with a number of options (New Game, Quit, etc.)
-Added a separate Opening Screen before the game starts
-Added more character options and a set default character to mario
-Added a High Score label for the current game session
-Added Music and Sound Effects
-Added Different Board Themes - user can select from different themes
-Added a High score with a player’s initials - save this information to an external text file; shows when the game is played and can get replaced by a new higher score
-Added a High score Table - saves the Top 5 scores to an external text file;this is able to be viewed (scores are sorted) and the information will get updated if a new Top 5 high score is achieved

Areas of Concern:
-when two or more coins are really close to each other the audio doesn't play for the other coins
 */

//imports to read and write files
import java.io.*;

//this class is the application class for the maze race to run the game and hold all the classes, methods, global variables
public class MazeRaceApplication {

    public static User[] userArray = new User[5];

    //this method is the main method to run the program and holds the classes
    public static void main(String[] args) {

        openTitle();
        loadHighScores();

    }

    //this method will read the high scores file to take input to "load" the high scores
    public static void loadHighScores() {

        //count for array index
        int count = 0;

        //reading a file
        //https://stackoverflow.com/questions/4008905/read-multiline-text-with-values-separated-by-whitespaces
        try{
            FileInputStream fstream = new FileInputStream("data/highScore.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] tokens = strLine.split(" ");
                userArray[count] = new User(tokens[0], Double.parseDouble(tokens[1])); //process record , etc
                count++;
            }
            in.close();
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }

    }

    //this method saves the high scores to a text file
    public static void saveHighScores() {

        //write a file
        //https://www.w3schools.com/java/java_files_create.asp
        try {
            //write the high score data file
            FileWriter myWriter = new FileWriter("data/highScore.txt");

            //use information from the user array
            for (int index = 0; index < userArray.length; index++) {
                myWriter.write(userArray[index].getUserInitials() + " " + String.format("%.1f", userArray[index].getHighScore()) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    //this method opens the title screen
    public static void openTitle() {

        //new title screen class by calling constructor
        new OpeningTitleGUI();
    }

    //this method opens the MazeRaceGUI
    public static void openMazeRace() {

        new MazeRaceGUI(); //calls constructor method and makes a new "MazeRaceGUI"

    }

}
