package View;

import javax.swing.*;
import java.awt.*;

public class NumberPanel extends JPanel {

    //Java swing components
    private JLabel instructionLabel = new JLabel();
    private JButton nextNumberButton = new JButton();

    //constructor
    public NumberPanel() {

        instructionLabel.setText("Click the button to pick the next number:");
        instructionLabel.setBounds(150,0,200,25);
        instructionLabel.setBackground(Color.red);
        add(instructionLabel);

        nextNumberButton.setBounds(350,0,50,25);
        nextNumberButton.setText("0");
        add(nextNumberButton);

    }

    //getters and setters
    public JLabel getInstructionLabel() {
        return instructionLabel;
    }

    public void setInstructionLabel(JLabel instructionLabel) {
        this.instructionLabel = instructionLabel;
    }

    public JButton getNextNumberButton() {
        return nextNumberButton;
    }

    public void setNextNumberButton(JButton nextNumberButton) {
        this.nextNumberButton = nextNumberButton;
    }

}
