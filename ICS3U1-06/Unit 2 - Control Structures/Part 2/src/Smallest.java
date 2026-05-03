import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/25/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Smallest) Write an application that finds the smallest of several integers.
Assume that the first number read specifies the number of values to input from the user.
Major Skills: Algorithm, for loop
 */

public class Smallest {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int amount; //number of integers
        int integer;
        int smallest;

        //Find the number of integers to input
        System.out.println("Enter the number of integers to input:");
        amount = input.nextInt();

        //Assume the first number inputted is the smallest integer
        System.out.println("Enter an integer:");
        integer = input.nextInt();
        smallest = integer;

        //Compare it with the next integer
        for (int x = 2; x <= amount; x++) { //x is two since we already got the first number

            //Get the next input
            System.out.println("Enter an integer:");
            integer = input.nextInt();

            //If the next integer is smaller, then replace the previous integer with the new one as the smallest integer
            if (integer < smallest)
                smallest = integer;

            //Repeat however many times the user said they were going to input
        }

        //Display the smallest integer
        System.out.printf("The smallest integer out of %d numbers was %d", amount, smallest);
    }

}
