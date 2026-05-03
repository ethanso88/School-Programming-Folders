//HEADER
/*
Name: Ethan So
Date: 3/26/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Triangles) Write an application that displays the following patterns,
one below the other (separate each triangle with a title and a blank line).
Use nested for loops (rows, spaces, stars) to generate the patterns,
and create separate variables to keep track of the number of stars and the number of spaces on each row of the triangle.

Major Skills: Algorithm, for loop, nested for loop
-using FIRST LOOP as number of ROWS and using NEXT LOOP as STARS and/or SPACES in each row
 */

public class Triangles {

    public static void main(String[] args) {
        //Display Triangle A
        System.out.println("Triangle A:");
        System.out.println();

        //Start with total stars = 1
        int totalStars = 1;

        //Create 10 rows for the triangle
        for (int rows = 1; rows <= 10; rows++) {

            //Display the stars in the row
            for (int stars = 1; stars <= totalStars; stars++)
                System.out.print("*");

            //Increment total stars
            totalStars++;

            //Make a new line for the next row
            System.out.println();
        }

        //Display Triangle B
        System.out.println();
        System.out.println("Triangle B:");
        System.out.println();

        //Start with total stars = 10
        totalStars = 10;

        //Create 10 rows for the triangle
        for (int rows = 1; rows <= 10; rows++) {
            //Display the stars in the row
            for (int stars = 1; stars <= totalStars; stars++)
                System.out.print("*");

            //Decrement total stars
            totalStars--;

            //Make a new line for the next row
            System.out.println();
        }


        //Display Triangle C
        System.out.println();
        System.out.println("Triangle C:");
        System.out.println();

        //Start with total spaces = 0
        int totalSpaces = 0;

        //Start with total stars = 10
        totalStars = 10;

        //Create 10 rows for the triangle
        for (int rows = 1; rows <= 10; rows++) {
            //Display the spaces in the row
            for (int spaces = 1; spaces <= totalSpaces; spaces++)
                System.out.print(" ");

            //Increment total spaces
            totalSpaces++;

            //Display the stars in the row
            for (int stars = 1; stars <= totalStars; stars++)
                System.out.print("*");

            //Decrement total stars
            totalStars--;

            //Make a new line for the next row
            System.out.println();
        }

        //Display Triangle D
        System.out.println();
        System.out.println("Triangle D:");
        System.out.println();

        //Start with total spaces = 9
        totalSpaces = 9;

        //Start with total stars = 1
        totalStars = 1;

        //Create 10 rows for the triangle
        for (int rows = 1; rows <= 10; rows++) {
            //Display the spaces in the row
            for (int spaces = 1; spaces <= totalSpaces; spaces++)
                System.out.print(" ");

            //Decrement total spaces
            totalSpaces--;

            //Display the stars in the row
            for (int stars = 1; stars <= totalStars; stars++)
                System.out.print("*");

            //Increment total stars
            totalStars++;

            //Make a new line for the next row
            System.out.println();
        }
    }
}
