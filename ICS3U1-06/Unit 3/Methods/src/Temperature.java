import java.util.Scanner;

/*
Method celsius returns the Celsius equivalent of a Fahrenheit temperature, using the formula c = 5.0 / 9.0 * ( f - 32 );
Method fahrenheit returns the Fahrenheit equivalent of a Celsius temperature, using the formula f = 9.0 / 5.0 * c + 32;
Use the methods from parts (a) and (b) to write an application that enables the user to either enter a Fahrenheit temperature
and display the Celsius equivalent or to enter a Celsius temperature and display the Fahrenheit equivalent.
 */

public class Temperature {

    public static void main(String[] args) {

        //1. get the choice of conversion
        int choice = getChoice();

        //2. get the temperature inputted
        double temperature = getTemperature();

        //3. find the right converted temperature based on the choice inputted
        if (choice == 1) //convert celsius to fahrenheit
            System.out.printf("%.2f degrees Celsius is %.2f degrees Fahrenheit", temperature, fahrenheit(temperature));
        else if (choice == 2) //convert fahrenheit to celsius
            System.out.printf("%.2f degrees Fahrenheit is %.2f degrees Celsius", temperature, celsius(temperature));
        else
            System.out.println("Please enter a valid number for choice");



    }

    //method finds selected conversion
    private static int getChoice() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter 1 for Celsius to Fahrenheit or 2 for Fahrenheit to Celsius:");
        return input.nextInt(); //return choice

    }

    //method finds magnitude of temperature
    private static double getTemperature() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the magnitude of the temperature to be converted:");
        return input.nextDouble(); //return magnitude (size) of temperature

    }

    //Method celsius returns the Celsius equivalent of a Fahrenheit temperature, using the formula c = 5.0 / 9.0 * ( f - 32 );
    private static double celsius(double fahrenheit) {

        return 5.0 / 9.0 * (fahrenheit - 32 );

    }

    //Method fahrenheit returns the Fahrenheit equivalent of a Celsius temperature, using the formula f = 9.0 / 5.0 * c + 32;
    private static double fahrenheit(double celsius) {

        return 9.0 / 5.0 * celsius + 32;

    }

}
