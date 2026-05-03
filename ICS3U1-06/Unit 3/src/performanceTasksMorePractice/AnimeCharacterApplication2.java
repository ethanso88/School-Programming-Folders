package performanceTasksMorePractice;

//Ethan So
//4/25/2024

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//a class that builds the anime library and creates the anime list
public class AnimeCharacterApplication2 {

    //shared array for the class
    private static AnimeCharacter2[] animeCharacterArray = new AnimeCharacter2[4];

    //Calls the other methods
    public static void main(String[] args) {

        fillLibrary();
        showTitle();
        showLibrary();
        int answer = getFavourite();
        showAnimeCharacter(answer - 1); //subtract one as array indices are one less than list number

    }

    //Fills the library of anime characters
    private static void fillLibrary() {

        //create 4 anime character objects
        animeCharacterArray[0] = new AnimeCharacter2("Son Goku", "Dragon Ball", 1984);
        animeCharacterArray[1] = new AnimeCharacter2("Monkey D. Luffy", "One Piece", 1997);
        animeCharacterArray[2] = new AnimeCharacter2("Naruto Uzumaki", "Naruto", 1999);
        animeCharacterArray[3] = new AnimeCharacter2("Ichigo Kurosaki", "Bleach", 2001);

    }

    //Displays the title of the application
    private static void showTitle() {

        System.out.println("Anime Character Library\n" +
                "=======================");

    }

    //Displays the library of anime characters, sorted alphabetically by name (using code)
    private static void showLibrary() {

        //sort the library of anime characters
        Arrays.sort(animeCharacterArray, Comparator.comparing(AnimeCharacter2::getName));


        //display the sorted array
        for (int index = 0; index < animeCharacterArray.length; index++) {

            //display number in list
            System.out.printf("%d. ", index + 1);

            //display character
            System.out.println(animeCharacterArray[index]);

        }

    }

    //Prompts the user for their favourite anime character based on the list and returns the value (re-prompt invalid entries)
    private static int getFavourite() {

        Scanner input = new Scanner(System.in);

        //prompt user for favourite anime character
        System.out.println("Which number is your favourite character?");

        //return the value
        return input.nextInt();

    }

    //Reads in the character number and displays the final message about the user’s favourite character
    private static void showAnimeCharacter(int answer) {

        //display final message based on user's favourite character
        System.out.printf("Your favourite character is %s from %s and their first appearance was in %d.",
                animeCharacterArray[answer].getName(), animeCharacterArray[answer].getSeries(),
                animeCharacterArray[answer].getFirstAppearance());

    }


}
