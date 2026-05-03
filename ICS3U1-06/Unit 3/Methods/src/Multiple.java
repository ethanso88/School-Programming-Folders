import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 4/5/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Multiple) Create an application that determines, for a pair of integers, whether the second integer is a multiple of the first.
The program should include a method that takes two integer arguments, and it returns true if the second is a multiple of the first and false otherwise.
[Hint: Use the remainder operator.- %] Incorporate this method into the application that inputs a series of pairs of integers (one pair at a time)
and determines whether the second value in each pair is a multiple of the first.

Major Skills: methods, algorithm, arguments, parameters, while loop
 */

public class Multiple {

    //Field for input
    //Make input usable for all methods
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //initialize answer
        boolean answer = true;

        do {
            //1. Get the first integer
            int num1 = getNum1();

            //2. Get the second integer
            int num2 = getNum2();

            //3. Determine whether the second integer is a multiple of the first
            boolean result = multiple(num1, num2);

            //4. Display results
            displayResults(num1, num2, result);

            //5. Ask if there is another pair of integers
            answer = another();

            //6. Repeat steps 1-5 until there are no more integer pairs
        } while (answer); //repeat while answer is true

    }

    //this method gets first number
    private static int getNum1() {

        System.out.println("Enter the first integer: ");
        return input.nextInt();

    }

    //this method gets second number
    private static int getNum2() {

        System.out.println("Enter the second integer: ");
        return input.nextInt();

    }

    //this method determines whether num2 is a multiple of num1
    private static boolean multiple(int num1, int num2) {

        if (num2 % num1 == 0)
            return true;
        else
            return false;

    }

    //this method displays the results
    private static void displayResults(int num1, int num2, boolean result) {

        if (result) //if result == true
            System.out.printf("%d IS a multiple of %d\n", num2, num1);
        else
            System.out.printf("%d is NOT a multiple of %d\n", num2, num1);

    }

    //this method determines if there are more number pairs
    private static boolean another() {

        System.out.println("Are there more number pairs? (Y/N)");
        String answer = input.next();

        if (answer.equalsIgnoreCase("y"))
            return true;
        else
            return false;

    }

}
