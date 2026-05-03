package Maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//this class is the maze object class
public class Maze {


    //global variables for the starting rows and columns
    public static int rowStart;
    public static int colStart = 0; //maze always starts in column 0

    //assign global constants (final, uppercase), number indicators for each possible direction
    private static final int RIGHT = 0; //priority
    private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;

    private int moveNumber  = 0; //number of moves

    private char[][] mazeArray; //2D mazeArray (visual maze)

    private Scanner input; //input


    //this method reads the maze file
    public Maze(String fileName) {

        //try reading the file
        try {

            //take the file as input
            input = new Scanner(new File(fileName));

            //take the first two numbers in the file and assign them as the row and column nums
            int rows = input.nextInt();
            int columns = input.nextInt();

            //initialize array
            mazeArray = new char[rows][columns];

            //traverse mazeArray
            for (int row = 0; row < mazeArray.length; row++) {

                //add each column to each row
                mazeArray[row] = input.next().toCharArray();
                //converts a string "xxx...xx"
                //into ['x','x','x',...]

                //check for start
                if (mazeArray[row][0] == '.')
                    rowStart = row;

            }

            //display the maze
            printMaze();

            //
            input.close();

            //
            input = new Scanner(System.in);

        //if the file cannot be read
        } catch (FileNotFoundException error) {

            System.out.println("File not found " + error);

        }


    }

    //This method prints the maze
    private void printMaze() {

        //traverse each row
        for (char[] row : mazeArray) {

            //traverse and print each cell in each row
            for (char cell : row)

                System.out.print(" " + cell);

            //next line
            System.out.println();

        }

        //next line
        System.out.println();

    }

    //this method traverses the maze one time
    public boolean mazeTraversal(int row, int column) {

        //set current point as char x
        mazeArray[row][column] = 'x';
        printMaze(); //print the maze again (with the new information)
        moveNumber++;

        //check the position and moveNumber of the starting position
        if (row == rowStart && column == colStart && moveNumber > 1) {

            System.out.println("Returned to starting location!");
            return false;

        //if it exited the maze return and display true
        } else if (mazeExited(column)) {

            System.out.println("Maze successfully exited!");
            return true;

        //otherwise prompt the user to traverse the maze again for a solution
        } else {

            //prompt user
            System.out.printf("Total moves: %d - Press 'Enter' to continue...", moveNumber);
            input.nextLine();

            //check for possible moves
            if (nextMove(row, column) == false) {

                //if not then seal it and backtrack
                mazeArray[row][column] = '0';
                printMaze();

                //prompt user for next move
                System.out.printf("Total moves: %d - Press 'Enter' to continue...", moveNumber);
                input.nextLine();

                //return false for no moves
                return false;

            }

            return true;

        }


    }

    //this method does the next move in the maze
    private boolean nextMove(int row, int column) {

        //displacement numbers (delta, change in)
        int dRow = 0;
        int dCol = 0;

        //0-3, check each direction
        for (int count = 0; count < 4; count++) {

            //use a switch statement to check all possible directions
            switch (count) {

                case DOWN:
                    dRow = 1;
                    dCol = 0;
                    break;

                case RIGHT:
                    dRow = 0;
                    dCol = 1;
                    break;

                case UP:
                    dRow = -1;
                    dCol = 0;
                    break;

                case LEFT:
                    dRow = 0;
                    dCol = -1;
                    //no break (already exits)

            }

            //**indirect recursion
            //its indirect since a another method is called (nextMove in this case)
            // before the original method is called

            //check if the new position is valid
            if (validMove(row + dRow, column + dCol))
                //move to new position through a recursive call
                if (mazeTraversal(row + dRow, column + dCol))
                    return true;

        }

        //otherwise the new position is not possible
        return false;

    }

    //this method checks if a move is valid
    private boolean validMove(int row, int column) {

        //check if move is within bounds and walls
        return ((row >= 0) && (row < mazeArray.length) &&
                (column >= 0 && (column < mazeArray.length) &&
                        (mazeArray[row][column] == '.')));

    }

    //this method checks if the maze has been exited
    private boolean mazeExited(int column) {

        //if the maze reaches the last column it has left the maze
        if (column == mazeArray[0].length - 1)
            return true;
        else
            return false;

    }

}
