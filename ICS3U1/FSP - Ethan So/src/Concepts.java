//imports for GUI components
import javax.swing.*;
import java.awt.*;

//imports to listen for actions
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class is the concepts GUI screen and its background processes
//the concepts GUI screen is for the user to study the objects and classes unit concepts
public class Concepts extends JFrame implements ActionListener, MenuListener {

    //MenuBar
    //https://stackoverflow.com/questions/9862165/jmenu-actionlistener
    private JMenuBar menuBar = new JMenuBar();
    private JMenu[] menuBarItemsArray = {
            new JMenu("Main Menu"),
            new JMenu("Concepts"),
            new JMenu("Activities"),
            new JMenu("Assessment"),
            new JMenu("Quit")
    };

    //panel to hold the title label
    private JPanel titleLabelPanel = new JPanel();

    //panel to hold the selection buttons
    private JPanel selectionButtonPanel = new JPanel();

    /*create the 3 selection buttons:
        -Analogy intro button
        -Terminology button
        -Coding examples button
    */
    private JButton[] selectionButtonArray = {
                    new JButton("Analogy Intro"),
                    new JButton("Terminology"),
                    new JButton("Coding Examples")
            };

    //Previous and next buttons for the slideshow
    JButton previousButton = new JButton("Previous");
    JButton nextButton = new JButton("Next");

    //slideshow panel array
    private JPanel[] slideShowArray = new JPanel[10];

    //slide descriptions
    JLabel[] descriptionLabelArray = {
            new JLabel(new ImageIcon("images/slide1.png")),
            new JLabel(new ImageIcon("images/slide2.png")),
            new JLabel(new ImageIcon("images/slide3.png")),
            new JLabel(new ImageIcon("images/slide4.png")),
            new JLabel(new ImageIcon("images/slide5.png")),
            new JLabel(new ImageIcon("images/slide6.png")),
            new JLabel(new ImageIcon("images/slide7.png")),
            new JLabel(new ImageIcon("images/slide8.png")),
            new JLabel(new ImageIcon("images/slide9.png")),
            new JLabel(new ImageIcon("images/slide10.png")),
    };

    //int for the current slide number
    private int currentSlide = 0;

    //constructor method
    public Concepts() {

        //Setup menu bar
        setMenuBar();

        //Setup top Labels
        setTopLabels();

        //Setup the selection buttons
        setSelectionsButtons();

        //Setup correlating panels to each button
        setSlideshow();

        //Setup previous and next buttons
        setSlideChangeButtons();

        //Setup the frame
        setFrame();

    }

    //this method sets up the menu bar
    private void setMenuBar() {

        //Add menu items to menu bar
        for (int index = 0; index < menuBarItemsArray.length; index++)
            menuBar.add(menuBarItemsArray[index]);

        //add menu font
        for (int index = 0; index < menuBarItemsArray.length; index++)
            menuBarItemsArray[index].setFont(MainMenu.buttonFont);

        //Let menu items able to listen to actions
        for (int index = 0; index < menuBarItemsArray.length; index++)
            menuBarItemsArray[index].addMenuListener(this);

    }

    //this method sets up the labels at the top of the screen
    private void setTopLabels() {

        //Logo label location and font/color
        JLabel logoLabel = new JLabel(new ImageIcon("images/learning logo.png"));
        logoLabel.setBounds(0,0,200,200);
        add(logoLabel); //add label to frame

        //make Title label
        JLabel screenTitleLabel = new JLabel("Concepts");

        //set the panel that hold the title label
        titleLabelPanel.setSize(1920,150);
        titleLabelPanel.setLayout(new BoxLayout(titleLabelPanel, BoxLayout.Y_AXIS));
        titleLabelPanel.setBackground(Color.decode("#073763"));

        //set title label font and colour and position
        screenTitleLabel.setFont(MainMenu.titleFont);
        screenTitleLabel.setForeground(Color.decode("#d9d9d9"));
        screenTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //add the label
        titleLabelPanel.add(Box.createRigidArea(new Dimension(0, 50)));  //add empty box space
        titleLabelPanel.add(screenTitleLabel); //add label to created panel

    }

    //this method sets up the selection buttons
    private void setSelectionsButtons() {

        //set the panel to hold the buttons
        selectionButtonPanel.setBounds(100, titleLabelPanel.getHeight() + 50,1920 - 200,50);
        selectionButtonPanel.setLayout(new BoxLayout(selectionButtonPanel, BoxLayout.X_AXIS));
        selectionButtonPanel.setBackground(Color.decode("#073763"));

        //set button fonts, colour, size and ActionListener
        for (int index = 0; index < selectionButtonArray.length; index++) {
            selectionButtonArray[index].setFont(MainMenu.buttonFont);
            selectionButtonArray[index].setForeground(Color.decode("#efefef"));
            selectionButtonArray[index].setBackground(Color.decode("#6d9eeb"));
            selectionButtonArray[index].setPreferredSize(new Dimension(250,75));
            selectionButtonArray[index].addActionListener(this);
        }
        //set button positions
        selectionButtonArray[0].setAlignmentX(Component.LEFT_ALIGNMENT);
        selectionButtonArray[1].setAlignmentX(Component.CENTER_ALIGNMENT);
        selectionButtonArray[2].setAlignmentX(Component.RIGHT_ALIGNMENT);

        //add buttons to array
        for (int index = 0; index < selectionButtonArray.length; index++) {
            selectionButtonPanel.add(selectionButtonArray[index]); //add label to created panel
            if (index != 2) //don't want extra space to the right of the last button
                selectionButtonPanel.add(Box.createHorizontalGlue());
        }

    }

    //this method sets up the "slideshow" of panels in the concepts screen
    private void setSlideshow() {

        //for each "slide" which is a panel in the array
        for (int index = 0; index < slideShowArray.length; index++) {

            //initialize the slideshow
            slideShowArray[index] = new JPanel();

            //set the bounds of the "slide"
            slideShowArray[index].setBounds(selectionButtonPanel.getX(),
                    selectionButtonPanel.getY() + selectionButtonPanel.getHeight(),
                    selectionButtonPanel.getWidth(), 650);
            slideShowArray[index].setLayout(null);

            //set color of the panel
            slideShowArray[index].setBackground(Color.decode("#666666"));

            //setup description label for the panel
            descriptionLabelArray[index].setBounds(0,0,selectionButtonPanel.getWidth(),650);

            //add description label to panel
            slideShowArray[index].add(descriptionLabelArray[index]);

            //add the panel to the frame
            add(slideShowArray[index]);

            //default to panel not visible
            slideShowArray[index].setVisible(false);

        }

        //set first panel to be visible
        slideShowArray[currentSlide].setVisible(true);

    }

    //this method sets up the previous and next buttons
    private void setSlideChangeButtons() {

        //setup the button that goes to the previous slide
        previousButton.setFont(MainMenu.buttonFont);    //font
        previousButton.setForeground(Color.decode("#efefef"));  //text colour
        previousButton.setBackground(Color.decode("#6d9eeb"));  //background colour
        previousButton.setBounds(slideShowArray[0].getX() + 100,slideShowArray[0].getY() + slideShowArray[0].getHeight() + 30,250,30);  //bounds
        previousButton.addActionListener(this); //actionlistener
        add(previousButton); //add to frame

        //setup the button that goes to the next slide
        nextButton.setFont(MainMenu.buttonFont);
        nextButton.setForeground(Color.decode("#efefef"));
        nextButton.setBackground(Color.decode("#6d9eeb"));
        nextButton.setBounds(slideShowArray[0].getX() + slideShowArray[0].getWidth() - 250 - 100,slideShowArray[0].getY() + slideShowArray[0].getHeight() + 30,250,30);
        nextButton.addActionListener(this);
        add(nextButton);

    }

    //this method sets up the frame
    private void setFrame() {

        //Set menuBar
        this.setJMenuBar(menuBar);

        //Setup the frame
        setTitle("CAI App: Objects and Classes - CONCEPTS"); //Title
        setSize(1920,1080); //Size
        getContentPane().setBackground(Color.decode("#073763")); //Background color
        setLayout(null); //Layout

        //Add panels
        add(titleLabelPanel); //add panel to frame
        add(selectionButtonPanel); //add panel to frame

        //Miscellaneous setup
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }



    //this method performs actions
    @Override
    public void actionPerformed(ActionEvent event) {

        //if Analogy Intro button is selected
        if (event.getSource() == selectionButtonArray[0]) {

            //set previous panel to not visible
            slideShowArray[currentSlide].setVisible(false);

            //change constant to required slide (first slide)
            currentSlide = 0;

            //show required panel
            slideShowArray[currentSlide].setVisible(true);

        }

        //if Terminology button is selected
        if (event.getSource() == selectionButtonArray[1]) {

            //set previous panel to not visible
            slideShowArray[currentSlide].setVisible(false);

            //change constant to required slide (second slide)
            currentSlide = 1;

            //show required panel
            slideShowArray[currentSlide].setVisible(true);

        }

        //if Coding Examples button is selected
        if (event.getSource() == selectionButtonArray[2]) {

            //set previous panel to not visible
            slideShowArray[currentSlide].setVisible(false);

            //change constant to required slide (second slide)
            currentSlide = 4;

            //show required panel
            slideShowArray[currentSlide].setVisible(true);

        }

        //if previous button is selected
        if (event.getSource() == previousButton) {

            //set previous panel to not visible
            slideShowArray[currentSlide].setVisible(false);

            //change constant to required slide
            if (currentSlide > 0)
                currentSlide -= 1;

            //show required panel
            slideShowArray[currentSlide].setVisible(true);

        }

        //if next button is selected
        if (event.getSource() == nextButton) {

            //set previous panel to not visible
            slideShowArray[currentSlide].setVisible(false);

            //change constant to required slide
            if (currentSlide < slideShowArray.length - 1)
                currentSlide += 1;

            //show required panel
            slideShowArray[currentSlide].setVisible(true);

        }


    }

    //this method performs actions when the menuBar is selected
    @Override
    public void menuSelected(MenuEvent event) {

        //if main menu is selected
        if (event.getSource() == menuBarItemsArray[0]) {

            //close current screen
            this.setVisible(false);

            //open the main menu screen
            CAI_Application.openMainMenu();
        }

        //if concepts is selected
        if (event.getSource() == menuBarItemsArray[1]) {

            //close current screen
            this.setVisible(false);

            //open the main menu screen
            CAI_Application.openConcepts();
        }

        //if activities is selected
        if (event.getSource() == menuBarItemsArray[2]) {

            //close current screen
            this.setVisible(false);

            //open the main menu screen
            CAI_Application.openActivities();
        }

        //if assessment is selected
        if (event.getSource() == menuBarItemsArray[3]) {

            //close current screen
            this.setVisible(false);

            //open the main menu screen
            CAI_Application.openAssessment();
        }

        //if quit is selected
        if (event.getSource() == menuBarItemsArray[4]) {

            //close the current screen
            this.dispose();
        }

    }

    //NOT USED - must be kept for MenuListener
    @Override
    public void menuDeselected(MenuEvent e) {

    }

    //NOT USED - must be kept for MenuListener
    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
