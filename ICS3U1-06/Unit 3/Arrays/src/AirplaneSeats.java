package arrays;

import java.util.Scanner;

/*
(AirplaneSeats) A small airline has just purchased a computer for its new automated reservations system.
You have been asked to develop the new system.
You are to write an application to assign seats on each flight of the airline’s only plane (capacity: 10 seats, with just 1 seat per row).
 */

public class AirplaneSeats {

    //field Array
    static boolean[] seatStatusArray = new boolean[11];    //size 11 since 10 seats

    //field input
    static Scanner input = new Scanner(System.in);

    //field for availability variables
    static int firstClassAvailability = 1;  //first class starts at 1
    static int economyAvailability = 6;     //economy class starts at 6

    //field for full variables
    static boolean firstClassFull;
    static boolean economyClassFull;

    public static void main(String[] args) {

        int answer;

        //1. Assign seats until take off
        do {
            //if plane is full
            if (firstClassFull && economyClassFull) //when both classes are full
                break;


            //2. Ask user for first class, economy or take off
            System.out.print("Enter 1) First Class, 2) Economy 3) Take Off: ");
            answer = input.nextInt();

            //2.1 if user selects first class
            if (answer == 1) {
                //assign first class seats
                firstClass();
            }
            //2.2 if user selects economy
            else if (answer == 2) {
                //assign economy class seats
                economyClass();
            }


            //3. display the status of the seats in the plane
            displaySeatStatus();

        } while (answer != 3);

        //4. when the user selects take off the loop ends and a message is displayed
        System.out.println("Bon Voyage!");

    }

    //This method assigns a seat in First Class or provides alternatives if full
    private static void firstClass() {

        //Check for availability

        if (firstClassAvailability <= 5) {  //if available, assign a seat and increment availability
            seatStatusArray[firstClassAvailability] = true;
            firstClassAvailability++;

            //when all seats are taken set First Class as full
            if (firstClassAvailability > 5)
                firstClassFull = true;
        }
        else {  //if not available, assign a seat to Economy or tell user to wait for next flight
            System.out.println("First Class is full. Would you like to be seated in Economy?");
            String answer = input.next();

            if (answer.equalsIgnoreCase("yes"))
                economyClass();
            else
                System.out.println("Next flight leaves in 3 hours.");

        }

    }

    //This method assigns a seat in Economy or provides alternatives if full
    private static void economyClass() {

        //Check for availability

        if (economyAvailability <= 10) {    //if available, assign a seat and increment availability
            seatStatusArray[economyAvailability] = true;
            economyAvailability++;

            //when all seats are taken set Economy Class as full
            if (economyAvailability > 10)
                economyClassFull = true;
        }
        else {  //if not available, assign a seat to First Class or tell user to wait for next flight

            System.out.println("Economy is full. Would you like to be seated in First Class?");
            String answer = input.next();

            if (answer.equalsIgnoreCase("yes"))
                firstClass();
            else
                System.out.println("Next flight leaves in 3 hours.");

        }

    }

    //This method displays the airplane's seat status
    private static void displaySeatStatus() {

        //Display seat status heading
        System.out.print("Airplane Seat Status: ");

        //Display actual seat status by traversing the Array
        for (int index = 1; index < seatStatusArray.length; index++) {

            if (seatStatusArray[index])
                System.out.print("true ");
            else
                System.out.print("false ");

        }

        System.out.println();

    }

}
