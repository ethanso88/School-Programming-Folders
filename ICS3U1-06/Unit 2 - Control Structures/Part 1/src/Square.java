import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/8/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
Write an application that prompts the user to enter the size of the side of a square,
and then displays a hollow square of that size made out of asterisks.
Your program should work for squares of all side lengths between 3 and 20 (inclusive) - re-prompt any invalid side lengths.
Note: To create the appearance of a square you will need to add an extra space between each star when printing the top and bottom row. (Square)

For example:

Enter the size of one side of the square:
5
* * * * *
*       *
*       *
*       *
* * * * *
Major Skills: Algorithm, if and else statements, while loop, accumulating count, reassigning variables
 */

public class Square {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int size;
        int row = 1;
        int countStars, spaces;

        do {
            //Ask the user for the size of the sides of the square
            System.out.println("Enter the size of a square side:");
            size = input.nextInt();

            //Repeat step 1 until the user enters a side between 3 and 20 (inclusive)
        } while (size < 3 || size > 20); // '||' means OR

        //Calculate and display the rows
        do {
            countStars = 1;
            spaces = 1;

            //If the row = 1 display the top row
            //Or the row is equal to the size display the bottom row
            if (row == 1 || row == size)  {
                while (countStars <= size) { //print # of stars equal to the size
                    System.out.print("*  ");
                    countStars++;
                }//If the row is between 1 and the size then display a middle row
            } else {
                //start of the middle row
                System.out.print("*  ");

                while (spaces <= size - 2) { //# of spaces is 2 less than size
                    System.out.print("   ");
                    spaces++;
                }

                //end of middle row
                System.out.print("*  ");
            }

            //add a line to move to the next row
            System.out.println();

            //increment row number
            row++;

            //Repeat until all the rows have been displayed
        } while (row <= size);
    }
}


