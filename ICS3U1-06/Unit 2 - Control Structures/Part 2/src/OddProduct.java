//HEADER
/*
Name: Ethan So
Date: 3/25/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
(OddProduct) Write an application that uses a For Loop to calculate the product of the odd integers from 1 to 15 (inclusive)
Major Skills: Algorithm, for loop, accumulating product
 */

public class OddProduct {

    public static void main(String[] args) {

        //variables
        double product = 1; //initialize product

        //Calculate the product of odd integers from 1 to 15
        //total odd integers (by multiplication) from 1 to 15
        for (int number = 1; number <= 15; number += 2) { //Start from 1 and increase by 2 each time until 15
            product *= number; //multiply the accumulating total
        }

        //display product
        System.out.printf("The product of odd integers from 1 to 15 is %.0f", product);

    }
}
