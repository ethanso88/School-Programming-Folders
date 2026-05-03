import java.util.Scanner;

/*
Name: Ethan So
Date: 2/20/2024
Course: ICS3U1-06 Mr. Fernandes
Description: A program to calculate the Heart Rate of a person
             given the age and resting heart rate from the user
Major Skills: variables, inputs, camelcase, calculating, display output
 */

public class HeartRate {

    public static void main(String[] args) {

        //Variables
        Scanner input = new Scanner(System.in);
        int age, restingHeartRate;
        double targetHeartRate;

        //I - Input age and Resting Heart Rate
        System.out.println("Enter your age: ");
        age = input.nextInt();
        System.out.println("Enter your Resting Heart Rate: ");
        restingHeartRate = input.nextInt();

        //P - Calculate Target Heart Rate
        targetHeartRate =  0.7 * (220 - age) + 0.3 * restingHeartRate;

        //O - Display Target Heart Rate
        System.out.printf("Your Target Heart Rate with age:%d and " +
                "Resting Heart Rate:%d bpm is %.1f bpm", age, restingHeartRate,
                targetHeartRate);

    }

}
