import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/20/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
The factorial of a non-negative integer n is written as n! (pronounced “n factorial”) and is defined as follows:

n! = n • (n-1) • (n-2) • …• 1 (for values of n greater than or equal to 1)
and
	n! = 1 (for n = 0).

	For example, 5! = 5 • 4 • 3 • 2 • 1 = 120.

Write an application that reads a non-negative integer from an input dialog and computes and prints its factorial. (Factorial)
Major Skills: Algorithm, while loop
 */

public class Factorial {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int num;                //size of factorial
        int n = 1;              //loop number (also current multiplied number)
        double factorial = 1;   //start value for factorial -> 0! = 1
        //value of the factorial; double can hold a larger number

        //Enter the size of the factorial
        System.out.println("Enter the size of the factorial:");
        num = input.nextInt();

        //Repeat by multiplying the numbers up to the size
        while (n <= num) {
            //multiply by the current number
            factorial *= n;

            //move onto the next number
            n++; //increment
        }

        //Display the factorial
        System.out.printf("Factorial %d! = %.0f", num, factorial);

    }

}


