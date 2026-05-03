import java.util.Scanner;


/*
(RightTriangle) Define a method. hypotenuse.
that calculates the length of the hypotenuse of a right triangle when the lengths of the other two sides are given.
The method should take two arguments of type double and return the hypotenuse as a double.
Incorporate this method into an application that reads values for side1 and side2 and performs the calculation with the hypotenuse method.
Determine the length of the hypotenuse for each of the triangles:

Triangle 	Side 1 	Side 2
1 	        3.0 	4.0
2 	        5.0 	12.0
3 	        8.0 	15.0
 */

public class RightTriangle {

    //field (must be static to use across all code)
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //variables
        double side1;
        double side2;
        double hyp;


        //1. get side 1
        side1 = getSide1();

        //2. get side 2
        side2 = getSide2();

        //3. calculate hypotenuse
        hyp = hypotenuse(side1, side2);

        //4. Display hypotenuse
        System.out.printf("The hypotenuse of the triangle is %.1f\n", hyp);
    }

    //method gets side 1
    private static double getSide1() {

        System.out.println("Enter side 1:");
        return input.nextDouble();

    }

    //method gets side 2
    private static double getSide2() {

        System.out.println("Enter side 2:");
        return input.nextDouble();

    }

    //method calculates the hypotenuse when given the other sides of the right angle triangle
    private static double hypotenuse(double side1, double side2) {

        //c^2 = a^2 + b^2
        //c = sqrt of a^2 + b^2
        return Math.sqrt( Math.pow(side1, 2) + Math.pow(side2, 2) );

        //can also use Math.hypot(a, b) instead in the future.

    }

}
