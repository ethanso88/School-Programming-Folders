import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/7/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
A large company pays its salespeople on a commission basis.
The salespeople receive $200 per week, plus 9% of their gross sales for that week.
You have been supplied with a list of items sold by each salesperson.  The values of the items are as follows:

Item	Value ($)
1 	    239.99
2 	    129.75
3 	    99.95
4 	    350.89

Develop a Java application that inputs one salesperson’s items sold for last week
and calculates and displays the salesperson’s earnings.
There is no limit to the number of items that can be sold. (Sales)
Major Skills: Algorithm, if and else-if statements, do-while loop, running total
 */


public class Sales {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);

        double sales = 0; //needs to have a value to be a part of running total
        int productNum, quantity;
        double totalSales = 0; //running/accumulating total of sales
        String answer; //used to continue loop

        double totalEarnings; //total earnings


        //Continue to accumulate sales until the user wants to quit
        do {
            //Prompt the user to enter the product number and quantity sold
            System.out.println("Enter the product number:");
            productNum = input.nextInt();
            System.out.println("Enter the quantity sold:");
            quantity = input.nextInt();

            //Add an amount to the total sales based on the product number
            if (productNum == 1) { //Item 1 is worth $239.99
                sales = 239.99 * quantity;

            } else if (productNum == 2) { //Item 2 is worth $129.75
                sales = 129.75 * quantity;

            } else if (productNum == 3) { //Item 3 is worth $99.95
                sales = 99.95 * quantity;

            } else if (productNum == 4) { //Item 4 is worth $350.89
                sales = 350.89 * quantity;
            }

            //add sales to the running/accumulating total
            totalSales += sales;

            //Ask if the user wants to enter more items
            System.out.println("Do you want to enter another item? (yes/no)");
            answer = input.next();

            //If they want to enter more items, then repeat Step 1
        } while(answer.equalsIgnoreCase("yes"));

        //Calculate the total earnings
        totalEarnings = 200 + totalSales * 0.09;
            //$200 per week, plus 9% of their gross sales

        //Display the total earnings
        System.out.printf("Your earnings this week are $%.2f", totalEarnings);

    }

}
