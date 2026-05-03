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
NOTE: Done using STRING MANIPULATION
Major Skills: Algorithm, if and else statements, do-while loop
 */

public class Palindrome1 {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int number; //5 digit number
        String stringNum; //hold 5 digit number as a string
        char d1, d2, d4, d5; //variables for digits


        //Prompt the user to enter a 5 digit number
        System.out.println("Enter a 5 digit number:");
        number = input.nextInt();
        stringNum = Integer.toString(number); //convert to string

        //Repeat until the user enters a 5 digit number
        if (number < 10000 || number > 99999) { //need if or else it will just start the loop
            do {
                System.out.println("Error");
                System.out.println("Please enter a 5 digit number:");
                number = input.nextInt();
                //repeat when the number is less than 10000 or greater than 99999
            } while (number < 10000 || number > 99999);
        } //0 breaks palindrome calculator so ignore "00000"


        //Take the number and isolate the digits
        d1 = stringNum.charAt(0); //first character in the string
        d2 = stringNum.charAt(1);
            //skip d3
        d4 = stringNum.charAt(3);
        d5 = stringNum.charAt(4);


        //Find out if the number is a palindrome
        if (d1 == d5 && d2 == d4) { //If d1 is equal to d5 AND d2 is equal to d4 then it is a Palindrome
            System.out.println("This number IS a palindrome");

        } else {
            System.out.println("This number IS NOT a palindrome");
        }

    }
}
