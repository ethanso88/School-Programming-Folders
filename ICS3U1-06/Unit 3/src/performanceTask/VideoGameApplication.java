package performanceTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//Ethan So
//4/26/2024

//a class that creates video game library and shows count of the most viewed games
public class VideoGameApplication {

    //shared array for the whole class
    private static VideoGame[] videoGameArray = new VideoGame[5]; //5 video games

    //Calls the other methods
    public static void main(String[] args) {

        //fill library of video games
        fillLibrary();

        //display application title
        showTitle();

        //display the video game library sorted by increasing year
        showLibraryByYear();

        //prompt user for minimum number of viewers
        double minimumViewers = getMinimumViewers();

        //find out how many video games have more or equal viewers as inputted
        int count = getVideoGames(minimumViewers);

        //display final message
        showMessage(count, minimumViewers);

    }

    //Fills the library of video games
    private static void fillLibrary() {

        //create 5 objects and fill the "library" or video game array
        videoGameArray[0] = new VideoGame("Fortnite", "Epic Games", 2017, 54.3);
        videoGameArray[1] = new VideoGame("Minecraft", "Mojang Studios", 2011, 20.9);
        videoGameArray[2] = new VideoGame("Roblox", "Roblox Corporation", 2006, 4.3);
        videoGameArray[3] = new VideoGame("Counter-Strike 2", "Valve", 2012, 90.2);
        videoGameArray[4] = new VideoGame("League of Legends", "Riot Games", 2009, 112.0);

    }

    //Displays the title of the application
    private static void showTitle() {

        //display title
        System.out.println("Video Game Library" );
        System.out.println("==================");

    }

    //Displays all the video games sorted by increasing year (using code)
    private static void showLibraryByYear() {

        //sort the array or library with all the video games by year
        Arrays.sort(videoGameArray, Comparator.comparing(VideoGame::getYear));

        //display all the sorted video games
        for (int index = 0; index < videoGameArray.length; index++)
            System.out.println(videoGameArray[index]);

    }

    //Prompts the user for the minimum amount of viewers and returns its value
    private static double getMinimumViewers() {

        //variables
        Scanner input = new Scanner(System.in);
        double minimumViewers;

        do {
            //prompt the user for the minimum amount of viewers
            System.out.println("What is the minimum number of viewers? (millions)");
            minimumViewers = input.nextDouble();

            //re-prompt while minimum viewers is negative
        } while (minimumViewers < 0);

        //return the value inputted
        return minimumViewers;

    }

    //Reads in the minimum number of viewers and returns the number of video games that meet the criteria
    private static int getVideoGames(double minimumViewers) {

        //count number of games that meet the criteria
        int count = 0;

        //check how many of the games meet the criteria
        for (int index = 0; index < videoGameArray.length; index++) {

            //check if the viewers of the game are greater or equal to the minimum viewers
            if (videoGameArray[index].getViewers() >= minimumViewers)
                count++; //increment count if true

        }

        //return the count of the number of games that meet the criteria
        return count;

    }

    //Reads in both the count and the minimum viewers as parameters and displays the final message
    private static void showMessage(int count, double minimumViewers) {

        //display different final message if there are no games that have
        //equal to or more than the minimum viewers
        if (count == 0)
            System.out.printf("There are no video games in the library that had at " +
                    "least %.1f million viewers last month", minimumViewers);
        else //display final message
            System.out.printf("There is/are %d video game(s) in the library that had at least " +
                        "%.1f million viewers last month.", count, minimumViewers);

    }

}
