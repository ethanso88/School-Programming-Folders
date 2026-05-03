import java.util.Scanner;

//THIS IS AN EXAMPLE FOR METHODS

//HEADER
/*
Name: Ethan So
Date: 4/5/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(AreaCircle) Create an application that prompts the user for the radius of a circle and calculates the area of the circle.
The program should include separate methods to manage the IPO.
That is, to get the radius, calculate the area and display the results.

Major Skills: methods, algorithm, arguments, parameters
 */

public class AreaCircle {

    //This method runs the other methods
    public static void main(String[] args) {

        //1. Get the radius
        double radius = getRadius(); //writing the name of the method "calls" the method

        //2. Calculate the area
        double area = calculateArea(radius); //argument to go to parameter

        //3. Display the area
        displayArea(radius, area); //arguments to go to the parameters in that order

        //NOTE fix errors and create the methods from BOTTOM TO TOP
            //so BELOW it is TOP TO BOTTOM


    }

    //This method gets the radius of the circle
    private static double getRadius() { //DOUBLE

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the radius: ");
        double radius = input.nextDouble();

        return radius; //returns DOUBLE

    }

    //this method calculates the area of the circle
    private static double calculateArea(double radius) { //need radius parameter (stores value given from argument)

        return Math.PI * Math.pow(radius, 2);

    }

    //this method displays the area of the circle
    private static void displayArea(double radius, double area) { //need parameters to store arguments

        System.out.printf("The are of the circle with radius %.1f units is %.1f units squared",
                radius, area);

    }

}
