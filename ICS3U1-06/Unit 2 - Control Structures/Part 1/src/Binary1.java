import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/19/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
Write an application that inputs an integer containing only 0s and 1s (binary) and prints its decimal equivalent. (Binary)
NOTE: Since it is STRING MANIPULATION it will read the binary LEFT to RIGHT
Major Skills: Algorithm, if and else statements, while loop, length of a string
 */

public class Binary1 {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        String binary;
        int decimal = 0;
        int power;
        int digit = 0;


        //Prompt the user to enter a binary integer
        System.out.println("Enter a binary number (1s or 0s):");
        binary = input.next();


        //Find the power of the binary integer
        //e.g. 5-digit number starts at power 4
        power = binary.length() - 1;

        //Calculate the value of each binary digit
        while (power >= 0) {
            //If the digit equals 1
            if (binary.charAt(digit) == '1') { //Find the digit
                //note that ' ' is used and not " " since it is a char

                //Multiply 2 by the power that matches the digit place
                    //and add it to a running total
                decimal += (int) Math.pow(2, power); //int cast cause Math.pow returns a double value

            } //If the digit equals 0 we don't do anything

            //Move onto the next digit
            digit++;

            //Decrease power
            power--;
        } //loop ends when power is -1 (not possible) and thus reaches the end of the binary number


        //Print the decimal equivalent
        System.out.printf("The decimal equivalent of %s is %d", binary, decimal);

    }
}
