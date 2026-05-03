import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 4/5/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Power) Create an application that returns the value of base^exponent .
For example, the program calculates that 34 = 81.
Assume that exponent is a positive, nonzero integer and that base is an integer.
Your solution should use a for statement to control the calculation. Do not use any math library methods.
That program should include separate methods to get the base, get the exponent, calculate the integer power and display the result.

Major Skills: methods, algorithm, arguments, parameters, for loop
 */

public class Power {

    //Field for input
    //Make input usable for all methods
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //1. Get the base
        int base = base();

        //2. Get the exponent
        int exponent = exponent();

        //3. Using the base and exponent calculate the power
        int power = calculatePower(base, exponent);

        //4. Display the power
        displayPower(base, exponent, power);

    }

    //this method gets the base
    private static int base() {

        System.out.println("Enter the base of the power");
        return input.nextInt(); //return base

    }

    //this method gets the exponent
    private static int exponent() {

        System.out.println("Enter the exponent of the power");
        return input.nextInt(); //return exponent

    }

    //this method calculates the power
    private static int calculatePower(int base, int exponent) {

        //initialize power
        int power = 1;

        //calculate power by multiplying the base with each other by the number of times of the exponent number
        for (int num = 1; num <= exponent; num++) {

            power *= base;

        }

        return power;

    }

    //this method displays the power
    private static void displayPower(int base, int exponent, int power) {

        System.out.printf("%d to the exponent %d is %d", base, exponent, power);

    }

}
