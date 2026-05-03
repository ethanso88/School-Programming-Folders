import java.util.Scanner;

//HEADER
/*
Name: Ethan So
Date: 3/18/2024
Course: ISC3U1-06 Mr. Fernandes
Description:
Write an application that reads three natural numbers entered by the user
and determines and prints if they could represent the sides of a triangle.
Next, modify the program to also determine and print if the sides could represent the sides of a right triangle. (Triangle)
Major Skills: Algorithm, multiple if and else statements, reassigning variables
 */

public class Triangle {

    public static void main(String[] args){

        //variables
        Scanner input = new Scanner(System.in);
        int num1, num2, num3;
        int largest;
        int smaller1, smaller2;


        //Ask the user for three natural numbers
        //Take input for 3 numbers
        System.out.println("Enter a natural number:");
        num1 = input.nextInt();
        System.out.println("Enter a natural number:");
        num2 = input.nextInt();
        System.out.println("Enter a natural number:");
        num3 = input.nextInt();


        //Find out if they could represent the sides of a triangle
            //Determine which of the side is the largest (hypotenuse)
        largest = num1; //assume num1 is largest
        smaller1 = num2; //assume this
        smaller2 = num3; //assume this
        if (num2 > largest && num2 > num3) { //set num2 to largest if it is bigger than the other numbers
            largest = num2;
            smaller1 = num1; //set num1 to smaller
        } else if (num3 > largest && num3 > num2){ //set num3 to largest if it is bigger than the other numbers
            largest = num3;
            smaller2 = num1; //set num1 to smaller
        }
        //Use the Triangle Inequality Theorem to find out if the 3 numbers can form a triangle
            //The 2 smaller sides added together need to be greater than the largest side
        if ((smaller1 + smaller2) > largest) {
            System.out.println("The three numbers CAN form a triangle");

            //Also find out if they could represent the sides of a right triangle
            //Use the largest side again (hypotenuse)
            //Use Pythagorean Theorem to find out if the 3 numbers can form a right angle triangle
            //a^2 + b^2 = c^2 needs to be true (c being the hypotenuse)
            if (Math.pow(largest,2) > (Math.pow(smaller1,2) + Math.pow(smaller2,2)) ) {
                System.out.println("The three numbers CAN form a RIGHT triangle");
            } else {
                System.out.println("The three numbers CANNOT form a RIGHT triangle");
            } //NOTE: it has to be a triangle to be able to form a right triangle
            // 1, 2, 3 would work if it is not nested

        } else {
            System.out.println("The three numbers CANNOT form a triangle");
        }





    }

}
