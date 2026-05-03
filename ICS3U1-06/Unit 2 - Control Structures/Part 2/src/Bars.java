import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/26/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Bars) One interesting application of computers is to display graphs and bar charts.
Write an application that reads five numbers between 1 and 30 (re-prompt invalid entries).
As each number is read, your program should display the same number of adjacent asterisks in a row. For example:

Enter a number between (1 and 30): 7
*******
Enter a number between (1 and 30): 10
**********
etc.

Major Skills: Algorithm, for loop, do while loop to re-prompt for valid number, nested loop
 */

public class Bars {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int number;

        //Read 5 numbers inputted by the user by repeating this step 5 times
        for (int count = 1; count <= 5; count++) {
            //Ask the user to enter a number
            System.out.print("Enter a number between (1 and 30): ");
            number = input.nextInt();

            //Re-prompt if the number is not between 1 and 30
            if (number < 1 || number > 30) {
                do {
                    System.out.println("Invalid number");
                    System.out.print("Enter a number between (1 and 30): ");
                    number = input.nextInt();
                } while (number < 1 || number > 30);
            }

            //Calculate the number of stars required (number inputted)
            for (int stars = 1; stars <= number; stars++) {
                //Display the stars required
                System.out.print("*");
            }

            //print a new line for the next input
            System.out.println();
        }
    }

}
