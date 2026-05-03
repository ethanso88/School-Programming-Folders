import java.util.Scanner;

/*
(PointsDistance) Write a method, distance, used to calculate the distance between two points (x1, y1) and (x2, y2).
All numbers and return values should be of type DOUBLE.
Incorporate this method into an application that enables the user to enter the coordinates of the points.
 */

public class PointsDistance {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double x1, y1;
        double x2, y2;
        double distance;


        //1. get the coordinates from the user
        System.out.println("Enter first coordinate (x1, y1). Enter like this: 'x y'");
        x1 = input.nextDouble();
        y1 = input.nextDouble();

        System.out.println("Enter second coordinate (x2, y2). Enter like this: 'x y'");
        x2 = input.nextDouble();
        y2 = input.nextDouble();


        //2. calculate the distance based on the coordinates
        distance = distance(x1, x2, y1, y2);


        //3. display the calculated distance
        System.out.printf("The distance between (%.2f, %.2f) and (%.2f, %.2f) is %.2f",
                x1, y1, x2, y2, distance);


    }

    //this method calculates the distance of 2 coordinates
    private static double distance(double x1, double x2, double y1, double y2) {

        //distance = sqrt{(x2 - x1)^2 + (y2-y1)^2}
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

    }

}
