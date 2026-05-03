package ClassicRecursionProblems;

import java.util.ArrayList;

// This class is used to solve the Eight ClassicRecursionProblems.Queens problem. It uses **‘Recursive Backtracking’
// in an attempt to place all the ClassicRecursionProblems.Queens on the board without any 'collisions'
public class Queens {

    // Global variables (fields)
    private final static int N = 4;       	     //set the number of queens (capital N for a constant value)
    private static int count = 0;                //track number of solutions
    private static int[] queenRow = new int[N];  //track row where queen is placed in each column

    // This method runs the program by finding a row to place a queen in the first column (0)
    public static void main(String[] args) {
        findRow(0); //start by placing the first queen (in column 1) in row 1

        //uses 'Recursive Backtracking' as stated above
    }

    /***********************************************************************
     *  Try all permutations using recursive backtracking,  If you get to the
     *  last column then you have a solution - print it.  Otherwise, try the
     *  rows one at a time and if you find a valid spot ask the next column
     *  to repeat this process.
     ***********************************************************************/
    private static void findRow(int n) {

        //YOUR COMMENTS (Algorithm) AND CODE GOES HERE

        //1. If we've made it to the last column then print results
        if (n == N)
            printQueens();

        //2. otherwise place the queen in a valid row
        else {

            //2.1 try all the rows starting at 0 till N-1
            for (int row = 0; row <= N-1; row++) {

                //2.1.1 set the row in the array
                queenRow[n] = row;

                //2.1.2 if the position is valid then go on to the next column
                if (isValid(n))

                    //2.1.2.1 then search for the row in the next column
                    findRow(n+1); //recursive call
                    //note that everytime it goes into this call it pauses the loop and checks if it is valid before it goes back

            }

        }

    }


    /***********************************************************************
     * Return true if the current queen placement does not 'conflict' with
     * other 'prior' placed queens
     ***********************************************************************/
    private static boolean isValid(int n) {

        //YOUR COMMENTS (Algorithm) AND CODE GOES HERE

        //only check the spaces where queens were placed before it (left side)
        //conflicts include same row or same diagonal as another queen
            //if on same row then conflict
            //if you're on a square (positioning between two queens on a diagonal forms a square) you're on a diagonal then conflict

        //1. check all columns less than the current column (n)
        for (int column = 0; column < n; column ++) {

            //1.1 If there is a queen in the same row then not valid
            if (queenRow[column] == queenRow[n])
                return false;

            //1.2 if there is a diagonal conflict then not valid
            if (Math.abs(queenRow[column] - queenRow[n]) == n - column)
                //if the row difference is the same as the column difference
                return false;

        }

        //2. otherwise it must be valid
        return true;

    }

    /***********************************************************************
     * Print out an N-by-N display of the board
     ***********************************************************************/
    private static void printQueens() {

        //YOUR COMMENTS (Algorithm) AND CODE GOES HERE

        //1. display the solution number
        count++;
        System.out.println("Solution #" + count);

        //2. for each column display the row numbers where the queens have been
        for (int i = 0; i < N; i++)
            System.out.print(queenRow[i] + " ");
        // OR System.out.println(Arrays.toString(queenRow));
        System.out.println();

        //3. display the board
        for (int row = 0; row < N; row++) {

            for (int column = 0; column < N; column++) {

                if (queenRow[column] == row)
                    System.out.print("Q ");
                else
                    System.out.print("* ");

            }

            System.out.println(); //move onto the next row

        }

        //print a blank line in b/w solutions for clarity
        System.out.println();


    }

}
