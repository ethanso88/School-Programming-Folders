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
Next, create a second program to find the two highest values of the 10 integers entered. (HighestTwo)
Major Skills: Algorithm, if and else-if statements, do-while loop, accumulating count, reassigning variables
 */

public class HighestTwo {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int counter = 1; //for the user to enter the next number, starts as two as we start with 2 numbers
        int number;
        int highest, highestTwo;


        //Ask the user to input 2 numbers
        //Input the first number
        //Set it as both highest and second-highest
        System.out.printf("Enter a number (this is #%d):\n", counter);
        number = input.nextInt();
        highest = number;
        highestTwo = number;

        //Input the second number
        counter++; //second number so counter goes up
        System.out.printf("Enter a number (this is #%d):\n",counter);
        number = input.nextInt();

        //If it is higher than the first number set it as highest
        if (number > highest) {

            highest = number;

        } else { //If lower, then set it as second highest

            highestTwo = number;
        }


        do {
            //add 1 to counter as the user will input another number
            counter++;

            //Ask the user for the next number
            System.out.printf("Enter a number (this is #%d):\n", counter);
            number = input.nextInt();

            //Replace the highest number if the next number is higher
            if (number > highest) {

                //Move the previous highest number to be the second-highest number
                highestTwo = highest;

                //set new highest
                highest = number;

                //or Replace the second-highest number if the next number is higher
            } else if (number > highestTwo) {

                //set new second-highest number
                highestTwo = number;
            }

            //Repeat step 2 until all numbers have been compared with the highest number and second-highest number
        } while (counter < 10);

        //Display the highest number and second-highest number
        System.out.printf("The highest number was %d and " +
                        "the second highest number was %d", highest, highestTwo);

    }

}
