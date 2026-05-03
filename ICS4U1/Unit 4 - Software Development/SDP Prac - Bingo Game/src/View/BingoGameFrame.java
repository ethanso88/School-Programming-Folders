package View;

import javax.swing.*;
import java.awt.*;

public class BingoGameFrame extends JFrame {

    //panels
    private NumberPanel numberPanel = new NumberPanel();
    private BingoCardPanel bingoCardPanel = new BingoCardPanel();

    //constructor method
    public BingoGameFrame() {

        //setup frame
        setSize(600,700);
        setLayout(null);
        getContentPane().setBackground(Color.RED);
        setTitle("Bingo Game - Group 7");

        //first panel
        numberPanel.setBounds(0,0,600,100);
        numberPanel.setBackground(Color.red);
        numberPanel.setLayout(null);
        add(numberPanel);

        //second panel
        bingoCardPanel.setBounds(0,100,600,600);
        bingoCardPanel.setBackground(Color.white);
        bingoCardPanel.setLayout(null);
        add(bingoCardPanel);

        //display the frame
        setVisible(true);

    } //end of constructor method

    //getters and setters
    public View.NumberPanel getNumberPanel() {
        return numberPanel;
    }

    public void setNumberPanel(View.NumberPanel numberPanel) {
        this.numberPanel = numberPanel;
    }

    public View.BingoCardPanel getCardPanel() {
        return bingoCardPanel;
    }

    public void setCardPanel(View.BingoCardPanel bingoCardPanel) {
        this.bingoCardPanel = bingoCardPanel;
    }

}
