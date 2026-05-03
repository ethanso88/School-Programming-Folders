import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 4/5/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Even) Create an application that uses the remainder operator (%) to determine whether an integer is even.
The program should include a method that accepts an integer and returns true if the integer is even and false otherwise.
Incorporate this method into an application that inputs a sequence of integers (one at a time) and determines whether each is even or odd.

Major Skills: methods, algorithm, arguments, parameters, do while loop, boolean
 */

public class Even {

    public static void main(String[] args) {

        //initialize answer
        boolean answer;

        do {
            //1. Get the integer
            int num = getNum();

            //2. Determine if it is even
            boolean result = even(num);

            //3. Display result
            displayResult(num, result);

            //4. Check for more integers
            answer = more();

            //5. Repeat 1-4 until there are not more integers
        } while (answer);

    }

    //this method gets number
    private static int getNum() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number: ");
        return input.nextInt(); //return number

    }

    //this method determines if number is even
    private static boolean even(int num) {

        if (num % 2 == 0)
            return true;
        else
            return false;

    }

    //this method displays the result
    private static void displayResult(int num, boolean result) {

        if (result)
            System.out.printf("%d IS even\n", num);
        else
            System.out.printf("%d IS NOT even\n", num);


    }

    //this method determines if the user wants to input another number
    private static boolean more() {

        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to input another number? (Y/N)");
        String answer = input.next();

        if (answer.equalsIgnoreCase("y"))
            return true;
        else
            return false;

    }

}
