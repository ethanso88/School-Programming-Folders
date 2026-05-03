import java.util.*;

public class TipCalculator {

    public static void main(String[] args) {

        //Variables
        Scanner input = new Scanner(System.in);
        double bill, tipPercent; //Input variables
        double tip; //Output variable

        //I - Input payment and percentage of tip
        System.out.println("This is a tip calculator.");
        System.out.print("Enter the bill (in $): ");
        bill = input.nextDouble();
        System.out.print("Enter the tip%; e.g. 5 will be 5%: ");
        tipPercent = input.nextDouble();

        //P - Calculate tip
        tip = bill * tipPercent/100;

        //O - Display tip
        System.out.printf("The amount of tip you should give for a bill of %.2f with a tip " +
                        "percentage of %.1f%% is $%.2f", bill, tipPercent, tip);


    }

}
