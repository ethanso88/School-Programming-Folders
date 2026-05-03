import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/7/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
The process of finding the highest value is used frequently in computer applications.
Create a Java application that inputs a series of 10 integers and determines and prints the highest integer.
Hint: use variables: counter, number, and highest. (Highest)
Major Skills: Algorithm, if and else-if statements, do-while loop, accumulating count
 */

public class Highest {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int counter = 1; //for the user to enter the next number
        int number;
        int highest;

        //Ask the user to input a number
        System.out.println("Enter a number (this is #1):");
        number = input.nextInt();

        //Assume the number is the highest
        highest = number;

        do {
            //add 1 to counter as the user will input another number
            counter++;

            //Ask the user to enter another number
            System.out.printf("Enter a number (this is #%d):\n", counter);
            number = input.nextInt();

            //Calculate which one is the highest
            if (number > highest) { //set highest to the new number if higher
                highest = number;
            }

            //Repeat step 2 until all numbers have been compared with the highest number
        } while (counter < 10);

        //Display the highest number
        System.out.printf("The highest number was %d", highest);

    }

}
