import java.util.Scanner;

/*
(AsteriskSquare) Write a method, squareOfAsterisks, that displays a solid square (the same number of rows and columns)
of asterisks whose side is specified in integer parameter side. For example, if side is 4, the method should display:

* * * *
* * * *
* * * *
* * * *

Incorporate this method into an application that reads an integer value for side from the user
and outputs the asterisks with the squareOfAsterisks method.
 */

public class AsteriskSquare {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int side;

        //1. get input for side length from the user
        System.out.println("Enter the side length:");
        side = input.nextInt();

        //2. display the square of asterisks based on the side length
        squareOfAsterisks(side);

    }

    //this method makes displays the square of asterisks based on the side length in the parameter
    private static void squareOfAsterisks(int side) {

        //display number of rows as inputted
        for (int row = 1; row <= side; row++) {
            //for each row:

            //display asterisks required in the row (side length)
            for (int asterisk = 1; asterisk <= side; asterisk++)
                System.out.print("* "); //extra spaces added to form a 'square' shape

            //new line for end of row
            System.out.println();
        }

    }

}
