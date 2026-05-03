import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 4/5/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Parking) Create an application that manages the charges for a parking garage.
The parking garage charges a $2.00 minimum fee to park for up to three hours.
The garage charges an additional $0.50 per hour for each hour or part thereof in excess of three hours.
The maximum charge for any given 24-hour period is $10.00. Assume that no car parks for longer than 24 hours at a time.
Write an application that calculates and displays the parking charges for each customer who parked in the garage yesterday.
You should enter the hours parked for each customer.
The program should display the charge for the current customer and should calculate and display the total of yesterday’s receipts.
The program should include separate methods to get the hours for the current customer, calculate the charges for the current customer,
total the charges (update the overall total), display the results for the current customer, check if there are more customers and finally,
when done, display the total of all the receipts.

Major Skills: methods, for loop, algorithm, arguments, parameters
 */

public class Parking {

    //global variable - field
    static double totalCharges = 0.0;
        //static means its stays there, is always there for all methods

    public static void main(String[] args) {

        boolean answer;

        do {
            //1. Get the hours for the current customer
            double hours = getHoursCurrentCustomer();

            //2. Calculate the charges for the current customer
            double charge = calculateCurrentCharges(hours);

            //3. Total the charges (update the overall total)
            totalCharges(charge);

            //4. Display the results for the current customer
            displayResults(hours, charge);

            //5. Check if there are more customers
            answer = checkCustomers();

            //6. Repead Steps 1 to 5 for each customer
        } while (answer); //while answer == true

        //7. Finally, when done, display the total of all the receipts.
        displayTotalReceipts();

    }

    //This method
    private static double getHoursCurrentCustomer() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the hours parked: ");
        double hours = input.nextDouble();

        return hours;

    }

    private static double calculateCurrentCharges(double hours) {

        if (hours < 3)
            return 2.00;
        else {

            //Calculate charge
            double charge = 2 + 0.50 * Math.ceil(hours - 3); //Math.ceil takes the ceiling number
            //ceiling number is for example 3.12 -> 4

            //if charge is greater than 10 set it to 10 (capped at 10)
            if (charge > 10.00)
                charge = 10.00;

            return charge;

        }

    }

    private static void totalCharges(double charge) {

        //Add current charge to total charges
        totalCharges += charge;

    }

    private static void displayResults(double hours, double charge) {

        System.out.printf("The charge for %.1f hours is $%.2f\n", hours, charge);

    }

    private static boolean checkCustomers() {

        Scanner input = new Scanner(System.in);

        System.out.println("Are there more customers? (Y/N)");
        String answer = input.next();

        if (answer.equalsIgnoreCase("Y"))
            return true;
        else
            return false;

    }

    private static void displayTotalReceipts() {

        System.out.printf("The total of all the receipts is $%.2f", totalCharges);

    }

}
