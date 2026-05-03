import java.util.Scanner;

/*
(Min3) Write a method, minimum3, that returns the smallest of three floating-point numbers.
Use the Math.min method to implement minimum3. Incorporate the method into an application that reads three values from the user,
determines the smallest value and displays the result.
Your solution should remind you of “Composite Functions” from math class.
 */

public class Min3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //1. Get 3 numbers to find the minimum
        System.out.println("Enter 3 numbers: ");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();

        //2. Determine the smallest number of the 3 (with a min method) and display the result
        System.out.printf("The minimum of %.2f, %.2f, and %.2f is %.2f", num1, num2, num3, min3(num1, num2 ,num3));


    }

    //This method determines the smallest of 3 numbers
    private static double min3(double num1, double num2, double num3) {

        //finds the minimum of 2 numbers then compares the result with a third number
        return Math.min(Math.min(num1, num2), num3);

    }

}
