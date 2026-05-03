//imports for GUI components
import javax.swing.*;
import java.awt.*;

//this class is the template class for the Destination box object
public class DestinationBox extends JLabel {
    //used code below but mainly tried to figure it out myself:
    //https://forum.level1techs.com/t/dragging-and-moving-a-label-on-a-window-in-java/109258/1
    //https://gist.github.com/OscarAMS/dec2ac8c13af8b4a0888508e685bbfd6

    //fields
    //Coordinates of correct box (x1, y1) and (x2, y2)
    //I found out about the Rectangle class so that can act as the "box" to act as the range for the label to snap to
    //a rectangle has x1, y2, a width and a height
    private int x1;
    private int y1;
    private int width;
    private int height;
    private Rectangle snappingRange;

    //constructor method
    public DestinationBox(int x1, int y1, int width, int height) {

        //sets the bounds based on the coordinates
        this.setBounds(x1, y1, width, height);

        //set the snapping range
        snappingRange = new Rectangle(x1, y1, width, height);

    }

    //getters and setters
    public Rectangle getSnappingRange() {
        return snappingRange;
    }

    public void setSnappingRange(Rectangle snappingRange) {
        this.snappingRange = snappingRange;
    }

    //toString method
    @Override
    public String toString() {
        return "DestinationBox{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", width=" + width +
                ", height=" + height +
                ", snappingRange=" + snappingRange +
                '}';
    }

    //this utility method checks for a specific JLabel in any destination box
    public boolean containsLabel(JLabel label) {
        //check if the label coordinates are in the destination box coordinates
            //check if the rectangles intersect (setBounds/getBounds uses rectangles anyway)
            //https://stackoverflow.com/questions/12325553/how-do-i-detect-the-collison-of-components
        return this.getBounds().intersects(label.getBounds());
    }

}


