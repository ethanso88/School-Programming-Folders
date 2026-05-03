//HEADER
/*
Name: Ethan So
Date: 3/25/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(Compound2) Modify the compound-interest application of Fig. 5.6
to repeat its steps for interest rates of 5%, 6%, 7%, 8%, 9% and 10%.
Use a for loop to vary the interest rate.
Major Skills: Algorithm, for loop, proper SYNTAX to make a TABLE, nested loop
 */

public class Compound2 {

    public static void main(String[] args) {

        //variables
        double displayedRate;
        double amount; //amount on deposit after each year
        double principle; //starting principle before interest

        //Calculate the interest rate of 5%, 6%, 7%, 8%, 9% and 10%
        for (double rate = 0.05; rate <= 0.10; rate += 0.01) {
            //State interest rate
            displayedRate = rate*100;
            System.out.printf("rate = %d%%\n", (int) displayedRate);

            //Display the headers
            System.out.printf("%s%20s\n", "Year", "Amount on deposit");
                //'%' indicates referencing the string
                //20 is the position? (coordinate from the left side)

            //reset (or initialize) principle for each interest rate
            principle = 1000.0;

            //Calculate the amount on deposit for each of ten years (for specified percentage)
            for (int year = 1; year <= 10; year++) {
                //Calculate the amount on deposit for specified year
                amount = principle * Math.pow(1 + rate, year); //compound interest

                //Display year and amount for specified year
                System.out.printf("%4d%,20.2f\n", year, amount);
                    //'%' indicates referencing the string
                    //Comma in format specifier indicates thousands separators
                    //4 and 20 is the position? (coordinate from the left side)
            }

            //print lines to separate different interest rates
            System.out.println();
            System.out.println();
        }
    }
}
