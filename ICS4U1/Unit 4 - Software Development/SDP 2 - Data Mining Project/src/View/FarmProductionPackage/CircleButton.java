package View.FarmProductionPackage;

import javax.swing.*;
import java.awt.*;

//this class makes a round button for things like a help button
public class CircleButton extends JButton {
    public CircleButton(String buttonLabel) {
        super(buttonLabel);
        //make the button background invisible so only the circle shows
        setContentAreaFilled(false);
        //remove the focus border so it does not show a box when clicked
        setFocusPainted(false);
        //remove the default border so only the circle border shows
        setBorderPainted(false);
        //make sure the button is not opaque so background does not draw
        setOpaque(false);
    }

    @Override
    //Graphics is used to draw shapes and text on components
    //see: https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html
    public void paintComponent(Graphics graphics) {
        //set the color based on if the button is pressed or not
        if (getModel().isArmed()) {
            graphics.setColor(Color.LIGHT_GRAY);
        } else {
            graphics.setColor(Color.WHITE);
        }
        //draw the filled circle for the button background
        graphics.fillOval(0, 0, getWidth(), getHeight());

        //draw the black outline of the circle
        graphics.setColor(Color.BLACK);
        graphics.drawOval(0, 0, getWidth() - 1, getHeight() - 1);

        //FontMetrics is used to measure the size of text for centering
        //see: https://docs.oracle.com/javase/8/docs/api/java/awt/FontMetrics.html
        graphics.setFont(getFont());
        FontMetrics fontMetrics = graphics.getFontMetrics();
        String buttonText = getText();
        //find out how wide and tall the label is
        int textWidth = fontMetrics.stringWidth(buttonText);
        int textHeight = fontMetrics.getAscent();
        //figure out where to draw the label so it is centered
        int labelX = (getWidth() - textWidth) / 2;
        int labelY = (getHeight() + textHeight) / 2 - 2;
        //set the color for the label
        graphics.setColor(getForeground());
        //draw the label
        graphics.drawString(buttonText, labelX, labelY);
    }

    @Override
    public boolean contains(int mouseX, int mouseY) {
        int radius = getWidth() / 2;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        //check if the mouse click is inside the circle
        return Math.pow(mouseX - centerX, 2) + Math.pow(mouseY - centerY, 2) <= Math.pow(radius, 2);
    }
}
