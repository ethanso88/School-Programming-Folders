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

Write an application that estimates the value of the mathematical constant e by using the following formula.
Allow the user to enter the number of terms to calculate. (E)
Major Skills: Algorithm, while loop
 */

public class E {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int term;
        double factorial = 1; //start value for factorial -> 0! = 1
        int n = 1; //loop number (also current term number)
        double e = 1; //starts at 1 since first term in (e = 1 + 1/1! + 1/2! + 1/3! + ...) is 1
        //**double holds a larger value


        //Enter the number of terms
        System.out.println("Enter the number of terms:");
        int actualTerms = input.nextInt();
        term = actualTerms - 1; //since it starts at the first term

        //Repeat by adding the numbers with increasing factorial (for the denominator)
        while (n <= term) {
            //calculate factorial for term
            factorial *= n;
            //increment term (move onto next term)
            n++;

            //calculate terms
            e += (double) 1/factorial;

        }

        //Display the estimated mathematical constant e
        System.out.printf("e with %d terms = %.100f", actualTerms, e);

    }

}
