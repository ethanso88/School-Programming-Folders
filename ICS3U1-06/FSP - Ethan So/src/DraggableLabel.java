import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//this class is a template class to create objects that are labels that can be moved
public class DraggableLabel extends JLabel implements MouseMotionListener, MouseListener {

    private Point centerLocation;
    private int x1;
    private int y1;
    private int width;
    private int height;

    //constructor method for a draggable label
    public DraggableLabel(String text) {
        super.setText(text);
        centerLocation = new Point(getX() + getWidth()/2, getY() + getHeight()/2);

//        addMouseMotionListener(this);
    }

    //getters and setters
//    @Override
//    public Point getLocation() {
//        return location;
//    }
//
//    @Override
//    public void setLocation(Point location) {
//        this.location = location;
//    }
    public Point getCenterLocation() {
        return centerLocation;
    }

    public void setCenterLocation(Point centerLocation) {
        this.centerLocation = centerLocation;
    }


    @Override
    public void mouseDragged(MouseEvent e){
//        //I believe this sets the location of the mouse to the coordinates
//        //the coordinates being the center of the label
//        setLocation(this.getX()+e.getX()-this.getWidth()/2,this.getY()+e.getY()-this.getHeight()/2);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {



    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
