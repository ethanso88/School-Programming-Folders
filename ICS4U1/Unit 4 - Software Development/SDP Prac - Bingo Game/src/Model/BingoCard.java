package Model;

import java.util.Arrays;

//object class for the bingo card
public class BingoCard {

    //field(s)
    private int[][] grid = new int[5][5];

    //constructor
    public BingoCard(int[][] grid) {
        this.grid = grid;
    }

    //getters and setters
    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    //toString method
    @Override
    public String toString() {
        return "BingoCard{" +
                "grid=" + Arrays.toString(grid) +
                '}';
    }

    //utility methods

    private void createCard() {



    }


    public boolean checkForBingo() {



    }

}
