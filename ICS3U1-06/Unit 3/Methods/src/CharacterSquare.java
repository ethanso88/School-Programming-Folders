import java.util.Scanner;

/*
(CharacterSquare) Create a similar method, squareOfCharacters, as created in Exercise 12,
to form the square out of whatever character is contained in character parameter fillCharacter.
Thus, if side is 5 and fillCharacter is “#”, the method should display:

# # # # #
# # # # #
# # # # #
# # # # #
# # # # #

 */

public class CharacterSquare {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int side;
        String character;

        //1. get input for side length from the user
        System.out.println("Enter the side length:");
        side = input.nextInt();

        //2. get input for character from the user
        System.out.println("Enter the desired character:");
        character = input.next();

        //3. display the square of asterisks based on the side length
        squareOfCharacters(side, character);

    }

    //this method makes displays the square of asterisks based on the side length in the parameter
    private static void squareOfCharacters(int side, String fillCharacter) {

        //display number of rows as inputted
        for (int row = 1; row <= side; row++) {
            //for each row:

            //display characters required in the row (side length)
            for (int character = 1; character <= side; character++)
                System.out.printf("%s ", fillCharacter); //ad a space to appear as a 'square'
                //could also use System.out.print(fillCharacter + " ");

            //new line for end of row
            System.out.println();
        }

    }

}
