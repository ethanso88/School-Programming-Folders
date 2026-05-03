package performanceTasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
Ethan So
4/23/2024
 */

// a class that builds the anime library and creates the anime list - COMMENT COPIED FROM THE DOC
public class AnimeCharacterApplication {

    //shared array for the class
    private static AnimeCharacter[] animeCharacterArray = new AnimeCharacter[4];

    //Calls the other methods
    public static void main(String[] args) {

        //Fills the library of anime characters (see table below)
        fillLibrary();

        //Displays the title of the application
        showTitle();

        //Displays the library of anime characters, sorted alphabetically by name (using code)
        showLibrary();

        //Prompts the user for their favourite anime character based on the list and returns the value (reprompt invalid entries)
        int favourite = getFavourite();

        //Reads in the character number and displays the final message about the user’s favourite character(see sample)
        showAnimeCharacter(favourite);


    }

    //Fills the library of anime characters (see table below)
    private static void fillLibrary() {

        animeCharacterArray[0] = new AnimeCharacter("Son Goku", "Dragon Ball", 1984);
            //remember that strings need " "
        animeCharacterArray[1] = new AnimeCharacter("Monkey D. Luffy", "One Piece", 1997);
        animeCharacterArray[2] = new AnimeCharacter("Naruto Uzumaki", "Naruto", 1999);
        animeCharacterArray[3] = new AnimeCharacter("Ichigo Kurosaki", "Bleach", 2001);


    }

    //Displays the title of the application
    private static void showTitle() {

        System.out.println("Anime Character Library\n" + "=======================");

    }

    //Displays the library of anime characters, sorted alphabetically by name (using code)
    private static void showLibrary() {

        //sort characters by name
        Arrays.sort(animeCharacterArray,                        //Array with objects that are being compared
                Comparator.comparing(AnimeCharacter::getName)   //characteristic that is compared (name because of getName in this case)
        );

        for (int index = 0; index < animeCharacterArray.length; index++) {
                //remember to use 'animeCharacterArray.length' instead of '4'

            //print NUMBER and anime character in each line
            System.out.printf("%d. ", index + 1);
            System.out.println(animeCharacterArray[index].toString());
                //note that 'toString()' is an implicit call

        }

    }

    //Prompts the user for their favourite anime character based on the list and returns the value (reprompt invalid entries)
    private static int getFavourite() {

        Scanner input = new Scanner(System.in);
        int answer;

        do {

            //ask for favourite character
            System.out.println("Which number is your favourite character?");
            answer = input.nextInt();

            //reprompt invalid entries
        } while (answer < 1 || answer > animeCharacterArray.length);
                //remember to use 'animeCharacterArray.length' instead of '4'

        return answer;

    }

    //Reads in the character number and displays the final message about the user’s number character(see sample)
    private static void showAnimeCharacter(int number) {

        System.out.printf("Your number character is %s from %s and their first appearance was in %d.",
                animeCharacterArray[number - 1].getName(), animeCharacterArray[number - 1].getSeries(),
                animeCharacterArray[number - 1].getFirstAppearance());
        //remember that Array numbers start at 0 and so number needs to be shifted 1 number back
        //Another solution is changing the method call from 'showAnimeCharacter(favourite);' to 'showAnimeCharacter(favourite - 1);'

    }

}
