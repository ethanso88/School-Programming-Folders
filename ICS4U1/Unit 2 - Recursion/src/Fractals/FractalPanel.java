package Fractals;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class FractalPanel extends JPanel {

    private Color color; // Color of the fractals
    private int level; // Recursion level for fractal detail

    // Constructor initializes the panel with a specific fractal level and sets
    // background
    public FractalPanel(int currentLevel) {
        color = Color.WHITE; // Set the default color to white
        level = currentLevel; // Set the initial fractal depth level
        setBackground(Color.BLACK); // Set the background color to black
        setPreferredSize(new Dimension(1300, 650)); // Set the preferred panel size
    }

    // Dragon Curve Fractal
    public void drawDragonCurveFractal(int level, int x1, int y1, int x2, int y2, Graphics g) {
        // Base case: Draw a straight line when level reaches 0
        if (level == 0)
            g.drawLine(x1, y1, x2, y2);
        else {
            // Calculate the new point (xn, yn) to form the Dragon Curve
            int xn = (x1 + x2) / 2 + (y2 - y1) / 2;
            int yn = (y1 + y2) / 2 - (x2 - x1) / 2;

            // Recursively draw two Dragon Curves
            drawDragonCurveFractal(level - 1, x1, y1, xn, yn, g); // First curve
            drawDragonCurveFractal(level - 1, x2, y2, xn, yn, g); // Second curve
        }
    }

    // Lo Fractal
    public void drawLoFractal(int level, int x1, int y1, int x2, int y2, Graphics g) {
        // Base case: Draw a line when level reaches 0
        if (level == 0)
            g.drawLine(x1, y1, x2, y2);
        else {
            // Calculate intermediate points to divide the line into smaller segments
            int dx = (x2 - x1) / 3;
            int dy = (y2 - y1) / 3;
            int xa = x1 + dx;
            int ya = y1 + dy;
            int xb = x1 + 2 * dx;
            int yb = y1 + 2 * dy;

            // Calculate the new point (xc, yc) for the fractal's jagged part
            int xc = xa + (int) ((xb - xa - dy) / Math.sqrt(2));
            int yc = ya + (int) ((yb - ya + dx) / Math.sqrt(2));

            // Recursively draw the four segments of the Lo Fractal
            drawLoFractal(level - 1, x1, y1, xa, ya, g);
            drawLoFractal(level - 1, xa, ya, xc, yc, g);
            drawLoFractal(level - 1, xc, yc, xb, yb, g);
            drawLoFractal(level - 1, xb, yb, x2, y2, g);
        }
    }

    // Sierpinski Triangle Fractal
    public void drawSierpinskiTriangle(int level, int x, int y, int size, Graphics g) {
        // Base case: Draw a filled triangle when level reaches 0
        if (level == 0) {
            int[] xPoints = { x, x + size / 2, x - size / 2 };
            int[] yPoints = { y, y + size, y + size };
            g.fillPolygon(xPoints, yPoints, 3);
        } else {
            // Calculate the new size for the smaller triangles
            int newSize = size / 2;

            // Recursively draw the three smaller Sierpinski Triangles
            drawSierpinskiTriangle(level - 1, x, y, newSize, g);
            drawSierpinskiTriangle(level - 1, x - newSize / 2, y + newSize, newSize, g);
            drawSierpinskiTriangle(level - 1, x + newSize / 2, y + newSize, newSize, g);
        }
    }

    // Koch Snowflake Fractal
    public void drawKochSnowflake(int level, int x1, int y1, int x2, int y2, Graphics g) {
        // Base case: Draw a line when level reaches 0
        if (level == 0)
            g.drawLine(x1, y1, x2, y2);
        else {
            // Calculate the intermediate points to create the Koch fractal
            int dx = (x2 - x1) / 3;
            int dy = (y2 - y1) / 3;
            int xa = x1 + dx;
            int ya = y1 + dy;
            int xb = x1 + 2 * dx;
            int yb = y1 + 2 * dy;

            // Calculate the new point (xc, yc) for the triangular protrusion
            int xc = (xa + xb) / 2 - (int) ((yb - ya) * Math.sqrt(3) / 2);
            int yc = (ya + yb) / 2 + (int) ((xb - xa) * Math.sqrt(3) / 2);

            // Recursively draw the four segments of the Koch Snowflake
            drawKochSnowflake(level - 1, x1, y1, xa, ya, g);
            drawKochSnowflake(level - 1, xa, ya, xc, yc, g);
            drawKochSnowflake(level - 1, xc, yc, xb, yb, g);
            drawKochSnowflake(level - 1, xb, yb, x2, y2, g);
        }
    }

    // Fractal Tree
    public void drawFractalTree(int level, int x1, int y1, int length, double angle, Graphics g) {
        // Base case: Draw a point at level 0 (optional)
        if (level == 0) {
            g.drawLine(x1, y1, x1, y1); // Draw a single point for level 0
            return;
        }

        // Calculate the end point of the branch based on angle and length
        int x2 = x1 + (int) (Math.cos(angle) * length);
        int y2 = y1 - (int) (Math.sin(angle) * length);

        // Draw the branch (line)
        g.drawLine(x1, y1, x2, y2);

        // Recursively draw the left and right branches
        drawFractalTree(level - 1, x2, y2, length * 2 / 3, angle - Math.PI / 6, g); // Left branch
        drawFractalTree(level - 1, x2, y2, length * 2 / 3, angle + Math.PI / 6, g); // Right branch
    }

    // Paint method to draw the fractal based on the selected type
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call superclass method to ensure proper panel rendering
        g.setColor(color); // Set the current fractal color

        // Check the selected fractal type and draw the corresponding fractal
        if (FractalFrame.fractalType.equals("Dragon Curve"))
            drawDragonCurveFractal(level, 900, 200, 300, 200, g);
        else if (FractalFrame.fractalType.equals("Lo Fractal"))
            drawLoFractal(level, 100, 300, 1200, 300, g);
        else if (FractalFrame.fractalType.equals("Sierpinski Triangle"))
            drawSierpinskiTriangle(level, 650, 50, 500, g);
        else if (FractalFrame.fractalType.equals("Koch Snowflake")) {
            // Draw the three sides of the Koch Snowflake
            drawKochSnowflake(level, 400, 450, 900, 450, g);
            drawKochSnowflake(level, 900, 450, 650, 50, g);
            drawKochSnowflake(level, 650, 50, 400, 450, g);
        } else if (FractalFrame.fractalType.equals("Fractal Tree")) {
            // Starting point of the tree and initial length/angle
            int startX = 650;
            int startY = 600;
            int initialLength = 200; // Initial length of the tree's trunk
            double initialAngle = Math.PI / 2; // Initial angle (upward)

            drawFractalTree(level, startX, startY, initialLength, initialAngle, g);
        }
    }

    // Setter for color to change the fractal drawing color
    public void setColor(Color c) {
        color = c;
    }

    // Setter for the fractal depth (level)
    public void setLevel(int currentLevel) {
        level = currentLevel;
    }

    // Getter for the fractal depth (level)
    public int getLevel() {
        return level;
    }
}