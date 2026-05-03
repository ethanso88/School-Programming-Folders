/*
Names:
Group #4
Nikki Chen, Bryan Huang, Ethan So, Jacky Xue

Date:
2024-05-14

Course Code:
ICS3U1-06 Mr. Fernandes

Title:
SDP #1 - Laptop Store

Description:
-This project creates an application for a laptop store
-This application’s purpose is to either help the user with finding a laptop or helping the user to learn more about laptops
-To learn more about laptops and laptop components the user can go to the education screen
-The inventory frame is to show the user all the laptop information the laptop store has.
-If the user is struggling with finding laptops they can take a survey for specific attributes they want in a laptop and then go to a results screen to show the top 3 recommendations

Major Skills:
-Swing GUI components
-ActionListener
-MouseListener
-Taking input from a file
-Arrays
-Opening a link through Java
-Scaling an image
-IOException

Added Features:
-Help Button
-Menu Bar
-Link to website on Results Frame
-Survey Checker: so that the Survey Frame is opened before the Results Frame
-Search Button (Inventory) - click on search button to see all the images

Areas of Concern:
not fully completing survey

Ethan So:
-File Input Class
-Laptop Class: score field, resized image field
-(partial) LaptopStoreApplication Class: all open frame methods
-Survey Results Frame Class: constructor method, top3 method, ActionListener method, MouseListener method (menubar - all code, survey results checker + dialog box in menubar)
-(partial) Education Frame class - partially coded the helpMessageBox method (dialog box)
Nikki Chen:
-Laptop Class: Additional price range method for inventory frame
-Inventory Frame Class: LaptopStoreInventoryFrame, clearSearchFilters, showSelectedLaptopInfo, searchLaptop, updateLaptopImageList, mouseClicked, actionperformed
-(partial) File Input: get resources with class loader
Jacky Xue:
-sets up a GUI frame for a survey in a laptop store. The frame includes various radio buttons for selecting budget, laptop type, brand, CPU brand, CPU speed, CPU core, RAM, and SSD storage. It also includes buttons for navigating the survey and menus for different
 */

import java.io.IOException;

//This class is the application for the laptop store
public class LaptopStoreApplication {

    //shared laptop array for the whole application/class
    public static Laptop[] laptopArray = new Laptop[40];    //40 laptops

    //to check if the survey frame has been accessed at least once
    public static int surveyChecker = 0;

    public static void main(String[] args) {

        //store the input from the file
        new LaptopStoreFileInput();

        //title screen for the laptop store app
        openLaptopStoreTitleFrame();

        //all other frames are accessed by the menuBar which calls the methods below

    }

    //this method opens the title frame
    public static void openLaptopStoreTitleFrame() {

        //survey results screen for the laptop store app
        new LaptopStoreTitleFrame();

    }

    //this method opens the inventory frame
    public static void openLaptopStoreInventoryFrame() {

        //survey results screen for the laptop store app
        try{
            new LaptopStoreInventoryFrame();
        }catch (IOException e){

            e.printStackTrace();
        }

    }

    //this method opens the survey frame
    public static void openLaptopStoreSurveyFrame() {

        //survey results screen for the laptop store app
        new LaptopStoreSurveyFrame();

        //to check that the survey frame has been opened
        surveyChecker++;

    }

    //this method opens the results frame
    public static void openLaptopStoreResultsFrame() {

        //survey results screen for the laptop store app
        new LaptopStoreResultsFrame();

    }

    //this method opens the results frame
    public static void openLaptopStoreEducationFrame() {

        //survey results screen for the laptop store app
        new LaptopStoreEducationFrame();

    }

}
