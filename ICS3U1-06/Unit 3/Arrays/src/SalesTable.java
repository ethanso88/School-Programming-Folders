package arrays;

/*
(SalesTable) Use an array of arrays (‘two-dimensional’ array) to solve the following problem:

A company has four salespeople (1 to 4) who sell five different products (1 to 5).
Once a day, each salesperson fills out a slip for each type of product sold.
Each slip contains the following:

    The salesperson number
    The product number
    The total dollar value of that product sold that day

Write an application that will read each slip (one at a time) and store the values in a matrix (‘two-dimensional’ array),
with each row representing a salesperson and each column a product.
Next, cross-total each row and each column to get the total sales by each salesperson and the total amount sold for each product.
Note: the cross-totals should also be stored in the matrix too (add an extra row and extra column to your matrix to store these values).
After processing all the information for last month and calculating the cross-totals the results should be displayed in a tabular format.
 */

import java.util.Scanner;

public class SalesTable {

    //make the array a field
    static double[][] salesTotalMatrix = new double[6][7];   //6 first because 4 salespeople and a total (5 rows)
                                                            //7 second because 6 columns
                                                            //ignore row 0 and column 0 for clarity

    public static void main(String[] args) {

        // 1. Read each slip
        readSlips();

        // 2. Display the table
        displaySalesTable();

    }

    //This method takes input from the slips and organizes it
    private static void readSlips() {

        Scanner input = new Scanner(System.in);

        //Read each slip (4 slips) from each salesperson
        for (int slip = 1; slip <= 4; slip++) {

            System.out.printf("Salesperson %d please enter:\n", slip);

            //Input each product in the slip
            for (int product = 1; product <= 5; product++) {

                //enter product
                System.out.printf("Product %d\n", product);
                double productValue = input.nextDouble();

                //set product to corresponding row and column
                salesTotalMatrix[slip][product] = productValue;

                //add product to row/slip/salesperson total
                salesTotalMatrix[slip][6] += productValue;

                //add product to product total
                salesTotalMatrix[5][product] += productValue;

            }
        }
    }

    //This method displays the table
    private static void displaySalesTable() {

        //display the table title
        System.out.print("Table of Sales ($)\n\t\t\t\t");

        //display headers
        for (int num = 1; num < salesTotalMatrix[0].length-2; num++)
            System.out.printf("Product %d\t", num);

        System.out.println("Total");

        //Display table info
        for (int row = 1; row <= 5; row++) {

            //final row (total)
            if (row == 5) {

                //row label
                System.out.print("Total\t\t\t");

                //display data
                for (int column = 1; column <= 5; column++) {

                    System.out.printf("%.2f\t\t", salesTotalMatrix[row][column]);

                }
            }

            //All other rows
            else {

                //row label
                System.out.printf("Salesperson %d\t", row);

                //display data
                for (int column = 1; column <= 6; column++) {

                    System.out.printf("%.2f\t\t", salesTotalMatrix[row][column]);

                }
            }

            //start new row
            System.out.println();

        }

    }

}

