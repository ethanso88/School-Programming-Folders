//HEADER
/*
Name: Ethan So
Date: 3/25/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Factorial2) Factorials are used frequently in probability problems.
The factorial of a positive integer n (written n! and pronounced “n factorial”) is equal to the product of the positive integers from 1 to n.
Write an application that evaluates the factorials of the integers from 1 to 5.
Display the results in tabular format.
Major Skills: Algorithm, for loop, proper SYNTAX to make a TABLE
 */

public class Factorial2 {

    public static void main(String[] args) {

        //variables
        double factorial = 1; //initialize

        //Display the table headers
        System.out.println("n\tn!");

        //Display the factorials for each row of the table
        for (int n = 1; n <= 200; n++) {
            //Display the current term (n)
            System.out.printf("%d\t", n);

            //Calculate the factorial value
            factorial *= n;

            //Display the factorial value
            System.out.printf("%.0f\n", factorial);
        }
    }
}
