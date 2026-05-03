import java.util.Scanner;

/*
Name: Ethan So
Date: 2/20/2024
Course: ICS3U1-06 Mr. Fernandes
Description: a program that displays the future value FV of an investment
for a principal P at a rate R compounded yearly for n years
Major Skills: casting, multiple variables in an equation
 */

public class FutureValue {

    public static void main(String[] args) {

        //Variables
        Scanner input = new Scanner(System.in);
        int principle, rate, years; //Input variables
        double futureValue; //Output variable

        //I - Input values needed to calculate Future Value
        System.out.println("Enter the principal (in $):");
        principle = input.nextInt();
        System.out.println("Enter the Rate (whole number to be converted to %):");
        rate = input.nextInt();
        System.out.println("Enter the number of years:");
        years = input.nextInt();

        //P - Calculate Future Value
        futureValue = principle * Math.pow(1 + (double)rate/100, years); //remember to cast division or else it will round to nearest integer

        //O - Display Future Value
        System.out.printf("If a future investment has a principal of %d, a rate of %d%%, and %d years long\n",
                principle, rate, years); //%% prints % in a printf
        System.out.printf("The future value of an investment will be $%.2f", futureValue);

    }

}
