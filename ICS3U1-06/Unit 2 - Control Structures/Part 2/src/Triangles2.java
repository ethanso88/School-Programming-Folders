public class Triangles2 {

    public static void main(String[] args) {

        //Create starting values
        int outerLeftStars = 1;
        int outerLeftSpaces = 9;
        int leftStars = 10;
        int middleSpaces = 0;
        int rightStars = 10;
        int outerRightSpaces = 9;
        int outerRightStars = 1;

        //Repeat for 10 rows
        for (int row = 1; row <= 10; row++) {
            //Section 1 - display outer left stars
            for (int stars = 1; stars <= outerLeftStars; stars++) //displays number of stars required
                System.out.print("*");

            //Section 2 - display outer left spaces
            for (int spaces = 1; spaces <= outerLeftSpaces; spaces++) //displays number of stars required
                System.out.print(" ");

            //Section 3 - display left stars
            for (int stars = 1; stars <= leftStars; stars++) //displays number of stars required
                System.out.print("*");

            //Section 4 - display middle spaces
            for (int spaces = 1; spaces <= middleSpaces; spaces++) //displays number of stars required
                System.out.print(" ");

            //Section 5 - display right stars
            for (int stars = 1; stars <= rightStars; stars++) //displays number of stars required
                System.out.print("*");

            //Section 6 - display outer right spaces
            for (int spaces = 1; spaces <= outerRightSpaces; spaces++) //displays number of stars required
                System.out.print(" ");

            //Section 7 - display outer right stars
            for (int stars = 1; stars <= outerRightStars; stars++) //displays number of stars required
                System.out.print("*");

            //Move onto the next row
            System.out.println();

            //Make adjustments for each section
            outerLeftStars++; //section 1 won't increase in stars each row without this step
            outerLeftSpaces--;
            leftStars--;

            middleSpaces += 2; //middle spaces increase by 2

            rightStars--; //section 1 won't increase in stars each row without this step
            outerRightSpaces--;
            outerRightStars++;

        }
    }

}
