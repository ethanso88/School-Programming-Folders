import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/26/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Pi) Calculate an approximation for the value of π from the infinite series:
The program should prompt the user for the amount of terms they want to use in the PI approximation.
Next, the program should calculate the approximation by adding/subtracting the desired number of terms.
Lastly, the program should display the PI approximation to the user.

Hint: When calculating the PI approximation, use separate variables to manage the coefficient (+1/-1) and the denominator for the terms.

Major Skills: Algorithm, for loop, switching coefficient
*/

public class Pi {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int terms;
        int denominator;
        int coefficient = 1;
        double pi = 0; //initialize pi


        //Prompt the user for the amount of terms in the PI approximation
        System.out.println("Enter the number of terms in the PI approximation:");
        terms = input.nextInt();

        //Repeat this step for as many terms entered:
        for (int term = 1; term <= terms; term++) {
            //calculate denominator
            denominator = 2 * term - 1; //denominator will always be an increasing odd number

            //calculate the term
            pi += coefficient * (double) 4 / denominator;

            coefficient *= -1; //flip the sign of coefficient +/- since it alternates with every term
        }

        //Display approximated pi
        System.out.printf("Pi with %d terms is %f", terms, pi);

    }

}
