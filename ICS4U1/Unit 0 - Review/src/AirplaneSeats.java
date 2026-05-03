import java.util.Scanner;

public class AirplaneSeats {

    //make array
    static boolean[] airplaneSeatArray = new boolean[10];
    static int firstClassCount = 0;
    static int economyClassCount = 5;

    public static void main(String[] args) {

        int count;

        do {
            count = takeInput();

            if (count == 1)
                firstClassSeat();

            else if (count == 2)
                economyClassSeat();

        } while (count != 3);

        //loop ends when user doesn't input a 1 or 2
        takeOff();
    }

    private static int takeInput() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter 1) First Class, 2) Economy 3) Take Off: ");

        return input.nextInt();

    }

    private static void firstClassSeat() {

        //give a seat
        if (firstClassCount < 5) {

            airplaneSeatArray[firstClassCount] = true;

            firstClassCount++;

        } else {

            System.out.println("First Class is full would you like to switch?");
            Scanner input = new Scanner(System.in);

            String answer = input.next();

            if (answer == "yes") {

                economyClassSeat();

            }

        }
        //display seats
        System.out.print("Airplane Seat Status: ");
        for (boolean n : airplaneSeatArray) {

            System.out.printf("%b ", n);

        }

        System.out.println();

    }

    private static void economyClassSeat() {

        //give a seat
        if (economyClassCount < 5) {

            airplaneSeatArray[economyClassCount] = true;

            economyClassCount++;

        } else {

            System.out.println("Economy Class is full would you like to switch?");
            Scanner input = new Scanner(System.in);

            String answer = input.next();

            if (answer == "yes") {

                firstClassSeat();

            }

    }

    private static void takeOff() {


        }
    }

}
