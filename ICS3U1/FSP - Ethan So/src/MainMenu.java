//for GUI components
import javax.swing.*;
import java.awt.*;

//to listen for actions for the menu
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

//this class is the first GUI screen and its background processes the user sees when they first run the app
public class MainMenu extends JFrame implements MenuListener {

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

    //Fonts
    public static Font titleFont = new Font("Helvetica", Font.BOLD, 65);
    public static Font headingFont = new Font("Helvetica", Font.BOLD, 50);
    public static Font subheadingFont = new Font("Helvetica", Font.BOLD, 40);
    public static Font buttonFont = new Font("Helvetica", Font.BOLD, 18);
    public static Font textFont = new Font("Helvetica", Font.PLAIN, 30);

    //Main Panels
    private JPanel labelPanel = new JPanel();
    private JPanel descriptionPanel = new JPanel(); //(holds the 3 mini panels)

    //Label Panel components
    //logo
    private JLabel logoLabel = new JLabel(new ImageIcon("images/learning logo.png"));
    //2 titles at the top of the screen
    private JLabel screenTitleLabel1 = new JLabel("Modular Programming");
    private JLabel screenTitleLabel2 = new JLabel("Learning about Objects and Classes");
    //title above the 3 description panels
    private JLabel topicsHeaderLabel = new JLabel("Topics in Menu Items Above:");

    //Description Panel components (hold 3 mini description panels)
    //panel for title for each mini panel
    private JPanel titleLabelPanelArray[] = new JPanel[3]; //NOTE - currently this is just an array of panels without any panels in it, we instantiate the panels later
    //panel for description for each mini panel
    private JPanel descriptionLabelPanelArray[] = new JPanel[3];
    //topic for each mini panel
    private JLabel topicTitleLabelArray[] = {
            new JLabel("Concepts:"),
            new JLabel("Activities:"),
            new JLabel("Assessment:")
    };
    //initialize actual description for each mini panel
    private JLabel topicDescriptionLabelArray[] = {
            new JLabel("Learn about terminology\n" +
                    "related to Objects and\n" +
                    "Classes.\n" +
                    "\n" +
                    "Understand how to create\n" +
                    "an Object and apply it in\n" +
                    "a Test Application Class"),
            new JLabel("Reinforce your\n" +
                    "knowledge with more\n" +
                    "interactive activities such as:\n" +
                    "\n" +
                    "Drag and Drop matching\n" +
                    "terms! Object Creator!\n"),
            new JLabel("Test knowledge of\n" +
                    "definitions for Objects\n" +
                    "and Classes.\n" +
                    "\n" +
                    "As well as steps to code\n" +
                    "a template class and how\n" +
                    "to use test/application\n" +
                    "class")
    };


    //constructor method
    public MainMenu() {
        //using the word 'set' instead of 'setup'

        //Setup menu bar
        setMenuBar();

        //setup top labels
        setLabelPanel();

        //setup the description panel
        setDescriptionPanel();

        //setup the frame
        setFrame();

    }

    //this method sets up the menu bar
    private void setMenuBar() {

        //add menu items to menu bar
        for (int index = 0; index < menuBarItemsArray.length; index++)
            menuBar.add(menuBarItemsArray[index]);

        //add menu font
        for (int index = 0; index < menuBarItemsArray.length; index++)
            menuBarItemsArray[index].setFont(buttonFont);

        //add menuListeners
        for (int index = 0; index < menuBarItemsArray.length; index++)
            menuBarItemsArray[index].addMenuListener(this);

    }

    //this method sets up the label panel for the labels at the top
    private void setLabelPanel() {
        //https://stackoverflow.com/questions/42848309/how-to-center-jlabel-in-a-panel-with-boxlayout
        //how to center JLabels with boxlayout

        //setup size and layout
        labelPanel.setSize(1920,450);
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
        labelPanel.setBackground(Color.decode("#073763"));


        //setup labels
        screenTitleLabel1.setFont(headingFont);
        //https://stackoverflow.com/questions/27176436/how-to-add-hex-font-col
        screenTitleLabel1.setForeground(Color.decode("#d9d9d9"));

        screenTitleLabel2.setFont(titleFont);
        screenTitleLabel2.setForeground(Color.decode("#d9d9d9"));

        topicsHeaderLabel.setFont(subheadingFont);
        topicsHeaderLabel.setForeground(Color.decode("#ffffff"));

        //align the labels to be centered in the middle horizontally
        screenTitleLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        screenTitleLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        topicsHeaderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //add labels in order
        labelPanel.add(logoLabel);
        labelPanel.add(Box.createRigidArea(new Dimension(0, 50)));  //add empty box space
        labelPanel.add(screenTitleLabel1);
        labelPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        labelPanel.add(screenTitleLabel2);
        labelPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        labelPanel.add(topicsHeaderLabel);


    }

    //this method sets up the description panel for the descriptions for each topic
    private void setDescriptionPanel() {

        //setup position and layout
        descriptionPanel.setBounds(labelPanel.getX(),labelPanel.getHeight(),labelPanel.getWidth(),400);
        descriptionPanel.setLayout(null);
        descriptionPanel.setBackground(Color.decode("#073763"));

        //for each title label panel
        for (int index = 0; index < titleLabelPanelArray.length; index++) {

            //instantiate the panel
            titleLabelPanelArray[index] = new JPanel();
            titleLabelPanelArray[index].setLayout(new BoxLayout(titleLabelPanelArray[index], BoxLayout.PAGE_AXIS));

            //set the bounds of the panel
            titleLabelPanelArray[index].setBounds(20 + 500 * index + (360/2) * index,0,
                    500,50);
                //20 pixel gap from the left, 500 for each additional panel, 2 gaps taking 380px total b/w panels
                //400px of gap (supposed to be 420px of gap but frame isn't in fullscreen so subtract another 20px) - 380px used = 20px gap from the left

            //set color of the panel
            titleLabelPanelArray[index].setBackground(Color.decode("#6d9eeb"));

            //setup the title label in the panel (indices in label array match with indices in panel array)
            topicTitleLabelArray[index].setAlignmentX(CENTER_ALIGNMENT);
            topicTitleLabelArray[index].setFont(subheadingFont);
            topicTitleLabelArray[index].setForeground(Color.decode("#ffffff"));

            //add labels
            titleLabelPanelArray[index].add(topicTitleLabelArray[index]);

            //add the panel to the main panel
            descriptionPanel.add(titleLabelPanelArray[index]);

        }

        //for each description label panel
        for (int index = 0; index < titleLabelPanelArray.length; index++) {

            //instantiate the panel
            descriptionLabelPanelArray[index] = new JPanel();
            descriptionLabelPanelArray[index].setLayout(new BoxLayout(descriptionLabelPanelArray[index], BoxLayout.PAGE_AXIS));

            //set the bounds of the panel
            descriptionLabelPanelArray[index].setBounds(20 + 500 * index + (360 / 2) * index, titleLabelPanelArray[0].getHeight(),
                    500, 350);
            //20 pixel gap from the left, 500 for each additional panel, 2 gaps taking 380px total b/w panels
            //400px of gap (supposed to be 420px of gap but frame isn't in fullscreen so subtract another 20px) - 380px used = 20px gap from the left

            //set color of the panel
            descriptionLabelPanelArray[index].setBackground(Color.decode("#666666"));

            //setup the description label in the panel
            topicDescriptionLabelArray[index].setHorizontalAlignment(SwingConstants.CENTER);
            topicDescriptionLabelArray[index].setFont(textFont);
            topicDescriptionLabelArray[index].setForeground(Color.decode("#ffffff"));

            //setup text for \n to work
            //https://stackoverflow.com/questions/1090098/newline-in-jlabel#:~:text=JLabel%20is%20actually%20capable%20of,you%20would%20get%20your%20newlines.
            topicDescriptionLabelArray[index].setText("<html>" +
                    topicDescriptionLabelArray[index].getText().replaceAll("\n", "<br/>") + "</html>");

            //add labels
            descriptionLabelPanelArray[index].add(topicDescriptionLabelArray[index]);

            //add the panel to the main panel
            descriptionPanel.add(descriptionLabelPanelArray[index]);

        }

    }

    //this method sets up the frame
    private void setFrame() {

        //set menuBar
        this.setJMenuBar(menuBar);

        //frame setup
        setTitle("CAI App: Objects and Classes - MAIN MENU");
        setSize(1920,1080);
        getContentPane().setBackground(Color.decode("#073763")); //colour to dark blue
        setLayout(null);

        //setup logo separately
        logoLabel.setBounds(0,0,200,200);
        add(logoLabel);

        //add panels
        add(labelPanel);
        add(descriptionPanel);

        //miscellaneous setup
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

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
