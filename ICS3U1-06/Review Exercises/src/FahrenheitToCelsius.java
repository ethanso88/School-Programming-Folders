import java.util.Scanner;

/*
Name: Ethan So
Date: 2/20/2024
Course: ICS3U1-06 Mr. Fernandes
Description: A program that converts a temperature from Fahrenheit to Celsius
Major Skills: casting, researching the formula
 */

public class FahrenheitToCelsius {

    public static void main(String[] args) {

        //Variables
        Scanner input = new Scanner(System.in);
        double fahrenheit, celsius;

        //I - Input temperature in fahrenheit
        System.out.println("Enter a temperature in degrees Fahrenheit:");
        fahrenheit = input.nextDouble();

        //P - Convert Fahrenheit to Celsius
        //Formula: Celsius (°C) = (Fahrenheit (°F) - 32) * 5/9
        celsius = (fahrenheit - 32) * (double) 5/9; //remember to double 5/9 or else it will round to int

        //O - Display temperature in Fahrenheit
        System.out.printf("%.1f°F is %.1f°C", fahrenheit, celsius);

    }

}
