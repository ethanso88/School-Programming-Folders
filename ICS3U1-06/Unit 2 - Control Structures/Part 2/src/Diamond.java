//HEADER
/*
Name: Ethan So
Date: 3/29/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Diamond) Write an application that prints the following diamond shape.
You may only use output statements that print a single asterisk (*), a single space or a single newline character.
[Hint: Establish a pattern for the top half and bottom half of the diamond]

Major Skills: Algorithm; for loop; nested for loop; if else statements to SWITCH INCREMENTS
 */

public class Diamond {

    public static void main(String[] args) {

        //variables
        int totalStars = 1; //Start with total stars = 1
        int totalSpaces = 4; //Start with total spaces = 4

        //Create 9 rows for the Diamond
        for (int row = 1; row <= 9; row++) {

            //Display the spaces in the row
            for (int spaces = 1; spaces <= totalSpaces; spaces++)
                System.out.print(" ");

            //Display the stars in the row
            for (int stars = 1; stars <= totalStars; stars++)
                System.out.print("*");

            //The end of the row
            System.out.println();

            //Top half (increases capacity of the stars for the top half)
            if (row < 5) {
                //Increment total stars by 2
                totalStars += 2;

                //Decrement spaces by 1
                totalSpaces--;
            }

            //Bottom half (decreases capacity of the stars for the bottom half)
            else {
                //Decrement total stars by 2
                totalStars -= 2;

                //Increment spaces by 1
                totalSpaces++;
            }
        }
    }

}
