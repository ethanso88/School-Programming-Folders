import javax.swing.*;

//Player template class to create the object
public class Player extends Cell{
    //extends cell, so you don't have to add row and column anymore

    //constructor
    public Player (ImageIcon image) {

        setIcon(image);

    }

    //utility method - to move the character
    public void move (int dRow, int dColumn) {

        setRow( getRow() + dRow);
        setCol( getCol() + dColumn);

    }


}
