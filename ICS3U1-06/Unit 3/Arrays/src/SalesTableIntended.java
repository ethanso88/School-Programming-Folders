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

public class SalesTableIntended {

    //make the array a field
    static double[][] salesTotalMatrix = new double[5][6];  //4 salespeople and a total (5 rows)
                                                            //6 columns


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String more;

        // 1. read slips
        do {
            //ask for salesperson number
            System.out.print("Enter the salesperson number (1 to 4): ");
            int salesperson = input.nextInt();

            //ask for product number
            System.out.print("Enter the product number (1 to 5): ");
            int productNumber = input.nextInt();

            //ask for product value
            System.out.printf("Enter the total dollar value of Product %d by Salesperson %d today: ",
                    productNumber, salesperson);
                //put product value in table, -1 since the Array starts at 0
                salesTotalMatrix[salesperson-1][productNumber-1] = input.nextDouble();


            //prompt to continue
            System.out.print("Are there more slips to enter (y/n)? ");
            more = input.next();

        } while (more.equalsIgnoreCase("y"));

        // 2. Calculate Cross-Totals
        calculateCrossTotals();

        // 3. Display the table
        displaySalesTable();

    }

    //This method totals each product and salesperson's sales
    private static void calculateCrossTotals() {


        //Calculate the total in each row and put it in the last column
            //data rows end at 3
        for (int row = 0; row < 4; row++) {

            for (int column = 0; column < 5; column++)
                salesTotalMatrix[row][5] += salesTotalMatrix[row][column];

        }

        //Calculate the total in each column and put it in the last row
            //data columns end at 4
        for (int column = 0; column < 5; column++) {

            for (int row = 0; row < 5; row++)
                salesTotalMatrix[4][column] += salesTotalMatrix[row][column];

        }

    }

    //This method displays the table
    private static void displaySalesTable() {

        //display the table title
        System.out.print("Table of Sales ($)\n\t\t\t\t");

        //display headers
        for (int num = 1; num <= salesTotalMatrix[0].length-1; num++) //need [0] for column length
            System.out.printf("Product %d\t", num);

        System.out.println("Total");

        //display table data
        for (int row = 0; row < salesTotalMatrix.length; row++) { //don't' need [0] for row length

            //display salesperson number and total for each row
            if (row < salesTotalMatrix.length - 1)
                System.out.printf("Salesperson %d\t", row);
            else
                System.out.print("Total\t\t\t");

            //display sales for each product and total for salesperson
            for (int column = 0; column < salesTotalMatrix[row].length; column++)
                System.out.printf("%.2f\t\t", salesTotalMatrix[row][column]);

            //skip to next line
            System.out.println();

        }

    }

}

