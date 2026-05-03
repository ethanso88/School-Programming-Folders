import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/8/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
Write a Java application that uses looping to print the following table of values.
Allow the user to enter the number of rows they wish to see.
Note: use the ‘\t’ control character to print tab spaces to create the columns. (Table)

For example:

Enter the number of rows:
4
N	10*N	100*N	1000*N

1	10	100	1000
2	20	200	2000
3	30	300	3000
4	40	400	4000
Major Skills: Algorithm, if and else-if statements, do-while loop, accumulating count,
reassigning variables, making a table with '\t'
 */

public class Table {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int currentRow = 1;
        int numberOfRows; //number of rows the user wants to see
        int tens, hundreds, thousands;

        //Prompt the user for the number of rows they want to see
        System.out.println("Enter the number of rows:");
        numberOfRows = input.nextInt();

        //Display the table headers
        System.out.println("N\t10*N\t100*N\t1000*N \n"); //\t prints a tab for spaces between columns

        do {
            //Calculate and display the values in each header
            //Calculate each row by taking the row number and multiply it by the multiplier in each header
            tens = currentRow * 10;
            hundreds = currentRow * 100;
            thousands = currentRow * 1000;

            //Display the values in the row
            if (currentRow < 10) { //so it will be aligned (# of \ts)
                System.out.printf("%d\t%d\t\t%d\t\t%d \n", currentRow, tens, hundreds, thousands);
            } else if (currentRow < 100) { //so it will be aligned (# of \ts)
                System.out.printf("%d\t%d\t\t%d\t%d \n", currentRow, tens, hundreds, thousands);
            } else { //so it will be aligned (# of \ts)
                System.out.printf("%d\t%d\t%d\t%d \n", currentRow, tens, hundreds, thousands);
            }

            //increment the row number
            currentRow++;

            //Repeat step 3 until the last row has been displayed
        } while (currentRow <= numberOfRows);

    }

}
