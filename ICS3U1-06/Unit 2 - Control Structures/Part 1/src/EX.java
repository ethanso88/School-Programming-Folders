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

Write an application that estimates the value of the mathematical constant ex by using the following formula.
Allow the user to enter the x value and the number of terms to calculate. (EX)
Major Skills: Algorithm, while loop
 */

public class EX {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int term;
        int x;
        double factorial = 1; //start value for factorial -> 0! = 1
        int n = 1; //current term number, power and loop number
        double ex = 1; //starts at 1 since first term in (e = 1 + x/1! + x^2/2! + x^3/3! + ...) is 1
        //**double holds a larger value


        //Enter the x value and number of terms
        System.out.println("Enter the x value:");
        x = input.nextInt();
        System.out.println("Enter the number of terms:");
        int actualTerms = input.nextInt();
        term = actualTerms - 1; //since it starts at the first term

        //Repeat by increasing the power for x with increasing factorial (for the denominator)
        while (n <= term) {
            //calculate factorial for term
            factorial *= n;

            //calculate terms
            ex += Math.pow(x, n)/factorial;

            //increment term, power and loop number
            n++;

        }

        //Display the estimated mathematical constant e^x
        System.out.printf("e^x with %d terms and %d x-value = %.2f", actualTerms, x, ex);

    }

}
