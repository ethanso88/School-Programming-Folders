//import classes that are not part of the basic Java language

//Import classes necessary for the window and images
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
//Import classes necessary for the timer/moving asteroid
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

//Import classes necessary to move the mouse
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;


//This class creates a window that holds the game objects
public class AsteroidGameFrame extends JFrame implements ActionListener, MouseMotionListener{
		//extend allows you to add more things to the JFrame program (default java frame)
		//implements will implement ActionListener to listen for the timer action

	
	//These objects hold the different images
	JLabel background = new JLabel(new ImageIcon("images/space.jpg")); 
	JLabel asteroid = new JLabel(new ImageIcon("images/asteroid.gif"));
	JLabel saucer = new JLabel(new ImageIcon("images/saucer.gif"));
	
	//Create a timer to move the object (will do the "action" every tick(s) set) 
	Timer moveTimer = new Timer(1, this); //1000 ticks = 1 second
	
	//To hold the change in x and y (vector)
	int dX = 5;
	int dY = -2;
	
	//Code to hide cursor
	//https://stackoverflow.com/questions/1984071/how-to-hide-cursor-in-a-swing-application
	//Transparent 16 x 16 pixel cursor image.
	BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
	//Create a new blank cursor.
	Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
	    cursorImg, new Point(0, 0), "blank cursor");
	
	
	//constructor method (method to build a window)
	public AsteroidGameFrame() {
		
		//setup the frame 
		setSize(500,500);
		setTitle("Ethan's Asteroid Game");
		
		//Code to hide cursor
		//https://stackoverflow.com/questions/1984071/how-to-hide-cursor-in-a-swing-application 
		//Set the blank cursor to the JFrame.
		this.getContentPane().setCursor(blankCursor); //'this' frame that we are using
		
		//create the asteroid and add it to the background
		asteroid.setBounds(100,100,50,50); //first two nums are coordinates other two nums are size
		background.setLayout(null); //get rid of layout for the background
		background.add(asteroid);
		
		//create the saucer and add it to the background 
		saucer.setBounds(300,200,75,60);
		background.add(saucer);
		
		//add the background
		add(background);
		
		//start the timer
		moveTimer.start();
		
		//add mouse motion listener
		addMouseMotionListener(this);
		
		//show the frame 
		setVisible(true);
		
	}
	
	
	//This method responds to actions in the frame 
	@Override
	public void actionPerformed(ActionEvent e) {
		//remember that the coordinates of (0,0) are in the top left corner
		
		//"top wall"
		if (asteroid.getY() < 0)  
			dY = -dY; //it will "bounce" (inverse direction y value *up to down*)
		
		//"left wall"
		if (asteroid.getX() < 0)
			dX = -dX; //it will "bounce" (inverse direction x value *left to right*)
		
		//"bottom wall"
		if (asteroid.getY() > 410) //note that even tho the window is 500 the asteroid is taken from the top left corner
			dY = -dY; //inverse the direction when it "hits" the wall
		
		//"right wall"
		if (asteroid.getX() > 430)
			dX = -dX;
		
		asteroid.setBounds(
				asteroid.getX()+dX, //the change in x value
				asteroid.getY()+dY, //the change in y value
				50,50);
		
		//set the asteroid to "bounce" up if it intersects with the saucer bounds
		if (asteroid.getBounds().intersects(saucer.getBounds())) dY = -5;
		
		
	}
	
	@Override
	public void mouseDragger(MouseEvent e) {
		
		//MUST BE KEPT TO SATISFY THE CODE INTERFACE
		
	}
	
	@Override
	public void mouseMoved(MouseEvent mouse) {
		
		//make the saucer bound match the mouse coordinates
		saucer.setBounds(mouse.getX()+37, mouse.getY()+30, 75, 60);
		
	}
	
}
