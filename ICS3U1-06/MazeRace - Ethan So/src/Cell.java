import javax.swing.*;

//Cell template class to create the object
public class Cell extends JLabel {

    //fields for cell object
    private int row;
    private int col; //column

    //empty constructor (for cells that we don't know where we want to put it)
    public Cell() {

    }


    //constructor method (for cells that we know where we want to put it)
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    //getters and setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    //toString method
    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
