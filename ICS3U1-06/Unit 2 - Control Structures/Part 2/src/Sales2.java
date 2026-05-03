import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/26/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Sales2) An online store sells five different products.
Write an application that prompts the user to enter the quantity sold for each product.
Next, the program should determine the value of the selected product (see table below)
and add the appropriate amount to the total retail value.
When the user has entered all the data the program should display the total retail value of all products sold.
Note: Your solution must use continue, switch and break statements to control the flow of logic in the program.

Major Skills: Algorithm, for loop, SWITCH, BREAK, CONTINUE
*/

public class Sales2 {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in);
        int quantity = 0;
        double value = 0;
        double total = 0;

        //Get the data for the 5 products
        for (int product = 1; product <= 5; product++) {

            //Get the quantity for one product at a time
            System.out.printf("Enter the quantity of product #%d:", product);
            quantity = input.nextInt();

            //If the user did not sell any of that product then continue to the next product
            if (quantity == 0)
                continue; //will skip the rest of the code and move onto the next iteration(or product)

            //Otherwise determine the value of the product
            else {
                //Based on the table set the values
                switch(product){
                    //instead of 'if (product == 1)'
                    case 1: //when product == 1
                        value = 2.98;
                        break;  //NOTE: need 'break' or else it will slide down to the next case
                                //'break' will exit the structure immediately

                    case 2:
                        value = 4.50;
                        break;

                    case 3:
                        value = 9.98;
                        break;

                    case 4:
                        value = 4.49;
                        break;

                    case 5:
                        value = 6.87;
                        break; //optional
                }
            }

            //Add the value * quantity of the product to the total
            total += value * quantity;
        }

        //Display the total for all the products
        System.out.printf("The total value is $%.2f", total);
    }
}
