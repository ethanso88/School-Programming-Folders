import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/6/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
Develop a Java application that determines whether any of several department-store customers has
exceeded the credit limit on a charge account.  For each customer, the following facts are available:
-account number
-balance at the beginning of the month
-total of all items charged by the customer this month
-total of all credits applied to the customer’s account this month
-allowed credit limit
The program should input all of these facts as integers, calculate the new balance ( = beginning balance + charges – credits), display the new balance and determine whether the new balance exceeds the customer’s credit limit.  For those customers whose credit limit is exceeded, the program should display the message “Credit limit exceeded.” (Credit)
.
Major Skills: Conditional(do-while loop), calculations, control structure (if statements), Algorithm
 */

public class Credit {

    public static void main(String[] args) {

        //variables
        Scanner input = new Scanner(System.in); //input

        String accNum; //account number is a string because the value is not used in calculations
        int beginBalance //note that the balance is what you owe
                ,charges
                ,credits //total of all items charged by the customer this month
                ,creditLimit //total of all credits applied to the customer’s account this month
                ;//credit info
        //credits are things the credit card company owes you/customer
        int newBalance;
        String answer; //if there are more customers


        do {
        //Ask the customer for the required credit information
        //account number
        System.out.println("Enter the account number:");
        accNum = input.next();

        //balance at the beginning of the month
        System.out.println("Enter the beginning balance (of the month):");
        beginBalance = input.nextInt();

        //total of all items charged by the customer this month
        System.out.println("Enter the total charges:");
        charges = input.nextInt();

        //total of all credits applied to the customer’s account this month
        System.out.println("Enter the total credits applied:");
        credits = input.nextInt();

        //allowed credit limit
        System.out.println("Enter the credit limit:");
        creditLimit = input.nextInt();

        //Calculate the new balance
        newBalance = beginBalance + charges - credits;

        //Display the new balance and whether the credit limit has been exceeded
        System.out.printf("For the account number %s. " +
                "Your new balance should be $%d", accNum, newBalance);

        //Display either “under credit limit” or “credit limit exceeded”
        if (newBalance > creditLimit) { //balance is more than credit limit

            System.out.println("\nCredit limit exceeded"); //display that limit is exceeded

        } else { //credit limit less than balance

            System.out.println("\nUnder credit limit");

        }

        //Ask if there are more customers
        System.out.println("Is there another customer? (Y/N)");
        answer = input.next();

        //If there are more customers than repeat steps 1-3
    } while (answer.equalsIgnoreCase("Y")); //ignores upper or lower case

        //If there are no more customers, then end the program
        System.out.println("Thank you, have a nice day :)");

    }

}
