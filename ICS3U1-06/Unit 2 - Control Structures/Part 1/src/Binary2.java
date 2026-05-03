import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/19/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
Write an application that inputs an integer containing only 0s and 1s (binary) and prints its decimal equivalent. (Binary)
NOTE: Since it is done MATHEMATICALLY it will read the binary RIGHT to LEFT
Major Skills: Algorithm, if and else statements, while loop
 */

public class Binary2 {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int binary;
        int decimal = 0;
        int power = 0;
        int digit;


        //Prompt the user to enter a binary integer
        System.out.println("Enter a binary number (1s or 0s):");
        binary = input.nextInt();

        //set original binary for the displayed statement
        int originalBinary = binary;


        //Calculate the value of each binary digit
        while (binary > 0) { //when binary == 0 there are no digits left
            //Find the digit using modulus
            digit = binary % 10;

            if (digit == 1) { //If the digit equals 1
                //Multiply 2 by the power that matches the digit place
                    //and add it to a running total
                decimal += (int) Math.pow(2, power); //int cast cause Math.pow returns a double value

            } //If the value equals 0 we don’t do anything

            //Move onto the next digit using div
            binary /= 10;

            //Increase power
            power++;

        } //Repeat step until all the digits have been processed


        //Print the decimal equivalent
        System.out.printf("The decimal equivalent of %d is %d", originalBinary, decimal);

    }
}