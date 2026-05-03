import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/19/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
A palindrome is a sequence of characters that reads the same backward as forward.
Write an application that reads in a five-digit integer and determines whether it’s a palindrome.
If the number is not five digits long, display an error message and allow the user to enter a new value. (Palindrome)
NOTE: Done MATHEMATICALLY
Major Skills: Algorithm, if and else statements, do-while loop
 */

public class Palindrome2 {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int number; //5 digit number
        int d1, d2, d4, d5; //variables for digits


        //Prompt the user to enter a 5 digit number
        System.out.println("Enter a 5 digit number:");
        number = input.nextInt();

        //Repeat until the user enters a 5 digit number
        if (number < 10000 || number > 99999) {
            do {
                System.out.println("Error");
                System.out.println("Please enter a 5 digit number:");
                number = input.nextInt();
                //repeat when the number is less than 10000 or greater than 99999
            } while (number < 10000 || number > 99999);
        } //0 breaks palindrome calculator so ignore "00000"


        //Take the number and isolate the digits using modulus and div
        d5 = number % 10; //digit5
        number /= 10;
        d4 = number % 10; //digit4
        number /= 10; //skip digit3
        number /= 10;
        d2 = number % 10; //digit2
        number /= 10;
        d1 = number % 10; //digit1
            //skip div cause no more digits


        //Find out if the number is a palindrome
        if (d1 == d5 && d2 == d4) { //If d1 is equal to d5 AND d2 is equal to d4 then it is a Palindrome
            System.out.println("This number IS a palindrome");

        } else {
            System.out.println("This number IS NOT a palindrome");
        }

    }
}
