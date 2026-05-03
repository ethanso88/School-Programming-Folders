package Maze;

//this class is the application class that creates a new maze object
public class MazeTest {

   //this main method makes and traverses an array

   public static void main(String[] args) {

       //create new maze object
       Maze myMaze = new Maze("Unit 2 - Recursion/Maze.txt");

       //if there is no solution after recursion
       if (myMaze.mazeTraversal(Maze.rowStart, Maze.colStart) == false)
           System.out.println("Maze.Maze has no solution.");

   }

}
