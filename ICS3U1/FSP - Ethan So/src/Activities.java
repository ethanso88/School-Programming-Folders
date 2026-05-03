//imports for GUI components
import java.awt.*;
import javax.swing.*;

//imports to listen for actions
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.*;

//this class is the activities GUI screen and its background processes
//the activities GUI screen is for the user reinforce their learning by playing activities that enhances their knowledge
public class Activities extends JFrame implements ActionListener, MenuListener {

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

    //description panel
    private JPanel descriptionPanel = new JPanel();
    private JButton activity1descStartButton = new JButton("Start");
    private JButton activity2descStartButton = new JButton("Start");

    //matching game panel
    private JPanel matchingGamePanel = new JPanel();
    //Add a Label Array for each answer
    //Make each label draggable (an object that are labels that can be moved) by adding the mouse adapter
    //center text in a JLabel: https://stackoverflow.com/questions/6810581/how-to-center-the-text-in-a-jlabel
    JLabel[] matchingAnswerArray = {
            new JLabel("Instance", SwingConstants.CENTER),
            new JLabel("Reference", SwingConstants.CENTER),
            new JLabel("Constructor Method", SwingConstants.CENTER),
            new JLabel("Template Class", SwingConstants.CENTER),
            new JLabel("Field", SwingConstants.CENTER),
            new JLabel("Object", SwingConstants.CENTER),
            new JLabel("Application Class", SwingConstants.CENTER)
    };
    //Add a destination box Array for each question
    //Add boundaries (a “coordinate zone”) to “snap” label in place
    DestinationBox[] destinationBoxArray1 = {
            new DestinationBox(48 + 450, 177, 299, 106),
            new DestinationBox(48 + 450, 177 + 139, 299, 106),
            new DestinationBox(48 + 450, 177 + 139 * 2, 299, 106),
            new DestinationBox(48 + 450, 177 + 139 * 3, 299, 106)
    };
    //exit and submit buttons
    private JButton exitMatchingGameButton = new JButton("Exit");
    private JButton submitMatchingGameButton = new JButton("Submit");

    //code template class activity panel
    private JPanel codeTemplateClassPanel = new JPanel();
    //Add a Label Array for each answer
    //Make each label draggable (an object that are labels that can be moved) by adding the mouse adapter
    //center text in a JLabel: https://stackoverflow.com/questions/6810581/how-to-center-the-text-in-a-jlabel
    JLabel[] itemArray = {
            new JLabel("Getters and Setters", SwingConstants.CENTER),
            new JLabel("toString Method", SwingConstants.CENTER),
            new JLabel("Constructor Method", SwingConstants.CENTER),
            new JLabel("Instance Variables (Fields)", SwingConstants.CENTER),
    };
    //Add a destination box Array for each question
    //Add boundaries (a “coordinate zone”) to “snap” label in place
    DestinationBox[] destinationBoxArray2 = {
            new DestinationBox(64, 198, 732, 93),
            new DestinationBox(64, 198 + 138, 732, 93),
            new DestinationBox(64, 198 + 138 * 2, 732, 93),
            new DestinationBox(64, 198 + 138 * 3, 732, 93)
    };
    //exit and submit buttons
    private JButton exitCodeTemplateClassButton = new JButton("Exit");
    private JButton submitCodeTemplateClassButton = new JButton("Submit");


    //constructor method
    public Activities() {

        //Setup menu bar
        setMenuBar();

        //Setup top Labels
        setTopLabels();

        //Setup the description panel
        setDescriptionPanel();

        //Setup the Matching Game (activity 1) Panel
        setMatchingGame();

        //Setup the Code a Template Class activity (activity 2) Panel
        setCodeTemplateClass();

        //Setup the frame
        setFrame();

    }

    //this method sets up the labels at the top of the screen
    private void setTopLabels() {

        //Logo label location and font/color
        JLabel logoLabel = new JLabel(new ImageIcon("images/learning logo.png"));
        logoLabel.setBounds(0,0,200,200);
        add(logoLabel); //add label to frame

        //make Title label
        JLabel screenTitleLabel = new JLabel("Activities");

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

    //this method sets up the description panel
    private void setDescriptionPanel() {

        //setup the panel bounds, layout and colour
        descriptionPanel.setBounds(100, titleLabelPanel.getHeight() + 100,1920 - 200,650);
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.X_AXIS));
        descriptionPanel.setBackground(Color.decode("#666666"));


        //add glue to fill the space b/w the panel and the side
        descriptionPanel.add(Box.createHorizontalGlue());


        //Setup Activity 1 description Panel
        JPanel activity1descPanel = new JPanel();
        activity1descPanel.setSize(601,550);
        activity1descPanel.setBackground(Color.decode("#666666"));
        activity1descPanel.setLayout(new BoxLayout(activity1descPanel, BoxLayout.Y_AXIS));

        //Title
        JLabel activity1descTitleLabel = new JLabel("Matching Game"); //title
        activity1descTitleLabel.setSize(activity1descPanel.getWidth(),100); //bounds
        activity1descTitleLabel.setFont(MainMenu.headingFont); //font
        activity1descTitleLabel.setForeground(Color.decode("#ffffff")); //text colour
        activity1descTitleLabel.setBackground(Color.decode("#6d9eeb")); //background colour
        //https://stackoverflow.com/questions/2380314/how-do-i-set-a-jlabels-background-color
        activity1descTitleLabel.setOpaque(true); //see the background
        activity1descTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //align to center

        //Image
        JLabel activity1descImage = new JLabel(new ImageIcon("images/activity1descImage.png"));
        activity1descImage.setAlignmentX(Component.CENTER_ALIGNMENT); //align to center

        //Start Button
        activity1descStartButton.setSize(activity1descPanel.getWidth(),100);
        activity1descStartButton.setFont(MainMenu.headingFont);
        activity1descStartButton.setForeground(Color.decode("#ffffff"));
        activity1descStartButton.setBackground(Color.decode("#45818e"));
        activity1descStartButton.addActionListener(this);
        activity1descStartButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        //add components to panel
        activity1descPanel.add(activity1descTitleLabel);
        activity1descPanel.add(activity1descImage);
        activity1descPanel.add(activity1descStartButton);
        //add panel to main panel
        descriptionPanel.add(activity1descPanel);


        //add glue to fill the space b/w the panels
        descriptionPanel.add(Box.createHorizontalGlue());


        //Setup Activity 2 description Panel
        JPanel activity2descPanel = new JPanel();
        activity2descPanel.setSize(601,550);
        activity2descPanel.setBackground(Color.decode("#666666"));
        activity2descPanel.setLayout(new BoxLayout(activity2descPanel, BoxLayout.Y_AXIS));

        //Add Title
        JLabel activity2descTitleLabel = new JLabel("Code a Template Class"); //title
        activity2descTitleLabel.setSize(activity2descPanel.getWidth(),100); //bounds
        activity2descTitleLabel.setFont(MainMenu.headingFont); //font
        activity2descTitleLabel.setForeground(Color.decode("#ffffff")); //text colour
        activity2descTitleLabel.setBackground(Color.decode("#6d9eeb")); //background colour
        //https://stackoverflow.com/questions/2380314/how-do-i-set-a-jlabels-background-color
        activity2descTitleLabel.setOpaque(true); //see the background
        activity2descTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //align to center

        //Image
        JLabel activity2descImage = new JLabel(new ImageIcon("images/activity2descImage.png"));
        activity2descImage.setAlignmentX(Component.CENTER_ALIGNMENT); //align to center

        //Start Button
        activity2descStartButton.setSize(activity1descPanel.getWidth(),100);
        activity2descStartButton.setFont(MainMenu.headingFont);
        activity2descStartButton.setForeground(Color.decode("#ffffff"));
        activity2descStartButton.setBackground(Color.decode("#45818e"));
        activity2descStartButton.addActionListener(this);
        activity2descStartButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        //add components to panel
        activity2descPanel.add(activity2descTitleLabel);
        activity2descPanel.add(activity2descImage);
        activity2descPanel.add(activity2descStartButton);
        //add panel to main panel
        descriptionPanel.add(activity2descPanel);


        //add glue to fill the space b/w the panel and the side
        descriptionPanel.add(Box.createHorizontalGlue());

    }

    //this method sets up the matching game (panel)
    private void setMatchingGame() {
        /*
        for the matching game there will be labels for each question,
        labels for each answer and a destination box for the answer labels to be dragged to.

        The matching game is a game for the user to drag labels to their matching definitions/terms
        The users score is then kept tracked of and given at the end
         */

        //setup the panel bounds, layout and colour
        matchingGamePanel.setBounds(100,titleLabelPanel.getHeight() + 50,1720,750);
        matchingGamePanel.setLayout(null);
        matchingGamePanel.setBackground(Color.decode("#666666"));
        matchingGamePanel.setVisible(false); //set default to not shown

        //add title labels
        JLabel matchingGameTitleLabel = new JLabel("Matching Game");
        matchingGameTitleLabel.setBounds(48,30,1000,100); //bounds
        matchingGameTitleLabel.setFont(MainMenu.headingFont); //font
        matchingGameTitleLabel.setForeground(Color.decode("#ffffff")); //text colour
        matchingGamePanel.add(matchingGameTitleLabel);

        JLabel termsTitleLabel = new JLabel("Terms:");
        termsTitleLabel.setBounds(matchingGamePanel.getWidth() - 500,177 - 50 - 48,250,50); //bounds
        termsTitleLabel.setFont(MainMenu.headingFont); //font
        termsTitleLabel.setForeground(Color.decode("#ffffff")); //text colour
        matchingGamePanel.add(termsTitleLabel);


        //Add a Label Array for each question
        //center text in a JLabel: https://stackoverflow.com/questions/6810581/how-to-center-the-text-in-a-jlabel
        JLabel[] matchingQuestionArray = {
                new JLabel("A Class used to create an object", SwingConstants.CENTER),
                new JLabel("A particular Object", SwingConstants.CENTER),
                new JLabel("The method we use at the top of\n our class to create new objects", SwingConstants.CENTER),
                new JLabel("A virtual representation", SwingConstants.CENTER)
        };
        //replace \n with html since a JLabel can't read \n
        //https://stackoverflow.com/questions/1090098/newline-in-jlabel
        matchingQuestionArray[2].setText("<html>" + matchingQuestionArray[2].getText().replaceAll("\n", "<br/>") + "</html>");


        //Setup each label
        for (int index = 0; index < matchingQuestionArray.length; index++) {
            //set bounds
            matchingQuestionArray[index].setBounds(48,177 + (index * 139),299,106);
            //x stays the same,y starts at 177 and has 139 gap b/w labels, width and height stay the same

            //setup everything else
            matchingQuestionArray[index].setFont(MainMenu.buttonFont); //font
            matchingQuestionArray[index].setForeground(Color.decode("#ffffff")); //text colour
            matchingQuestionArray[index].setBackground(Color.decode("#02084B")); //background colour
            matchingQuestionArray[index].setOpaque(true); //see the background

            //add labels to the panel
            matchingGamePanel.add(matchingQuestionArray[index]);

        }

        //Setup exit button
        exitMatchingGameButton.setBounds(1720 - 150 - 30,750 - 75 - 30,150,75);
        exitMatchingGameButton.setFont(MainMenu.subheadingFont);
        exitMatchingGameButton.setForeground(Color.decode("#ffffff"));
        exitMatchingGameButton.setBackground(Color.decode("#45818e"));
        exitMatchingGameButton.addActionListener(this);
        matchingGamePanel.add(exitMatchingGameButton);

        //Setup each label in the label array
        for (int index = 0; index < matchingAnswerArray.length; index++) {
            //set bounds
            if (index <= 3)
                matchingAnswerArray[index].setBounds(48 + 925,177 + (index * 139),299,106);
            //x stays the same,y starts at 177 and has 139 gap b/w labels, width and height stay the same

            //set bounds for the other 3 answer labels not in the same row
            if (index >= 4)
                matchingAnswerArray[index].setBounds(48 + 925 + 335,177 + 56 + ((index - 4) * 139),299,106);

            //setup everything else
            matchingAnswerArray[index].setFont(MainMenu.buttonFont); //font
            matchingAnswerArray[index].setForeground(Color.decode("#ffffff")); //text colour
            matchingAnswerArray[index].setBackground(Color.decode("#6d9eeb")); //background colour
            matchingAnswerArray[index].setOpaque(true); //see the background
            matchingAnswerArray[index].addMouseListener(matchingGameJLabelAdapter);
            matchingAnswerArray[index].addMouseMotionListener(matchingGameJLabelAdapter);

            //add labels to the panel
            matchingGamePanel.add(matchingAnswerArray[index]);

        }

        //Setup destination box array
        //Make a gray plain label box to visually represent the destination box
        for (int index = 0; index < destinationBoxArray1.length; index++) {
            destinationBoxArray1[index].setBackground(Color.decode("#d9dfdb")); //background colour
            destinationBoxArray1[index].setOpaque(true); //see the background
            matchingGamePanel.add(destinationBoxArray1[index]); //add destination box
        }

        //Setup submit button
        submitMatchingGameButton.setBounds(1720 - 150 - 30 - 200 - 30,750 - 75 - 30,200,75);
        submitMatchingGameButton.setFont(MainMenu.subheadingFont);
        submitMatchingGameButton.setForeground(Color.decode("#ffffff"));
        submitMatchingGameButton.setBackground(Color.decode("#45818e"));
        submitMatchingGameButton.addActionListener(this);
        matchingGamePanel.add(submitMatchingGameButton);

    }

    //this method sets up the code a template class activity (panel)
    private void setCodeTemplateClass() {
        /*
        for the code template class activity there will be 4 "item" labels
        and a destination box for the item to be dragged to.

        The code template class activity is a activity for the user to drag labels in the right order
        The right order being the right order a template class is coded from top to bottom
        The users score is then kept tracked of and given at the end
         */

        //setup the panel bounds, layout and colour
        codeTemplateClassPanel.setBounds(100,titleLabelPanel.getHeight() + 50,1720,750);
        codeTemplateClassPanel.setLayout(null);
        codeTemplateClassPanel.setBackground(Color.decode("#666666"));
        codeTemplateClassPanel.setVisible(false); //set default to not shown

        //setup title label for the whole activity
        JLabel codeTemplateClassTitleLabel = new JLabel("Code a Template Class");
        codeTemplateClassTitleLabel.setBounds(64,30,1000,100); //bounds
        codeTemplateClassTitleLabel.setFont(MainMenu.headingFont); //font
        codeTemplateClassTitleLabel.setForeground(Color.decode("#ffffff")); //text colour
        codeTemplateClassPanel.add(codeTemplateClassTitleLabel);

        //setup title label above the destination boxes
        JLabel destinationBoxesTitleLabel = new JLabel("Sections of a template class from top to bottom:");
        destinationBoxesTitleLabel.setBounds(64,198 - 50 - 20,700,50); //bounds
        destinationBoxesTitleLabel.setFont(new Font("Helvetica", Font.BOLD, 25)); //font
        destinationBoxesTitleLabel.setForeground(Color.decode("#ffffff")); //text colour
        codeTemplateClassPanel.add(destinationBoxesTitleLabel);

        //setup title label above the draggable labels
        JLabel itemsTitleLabel = new JLabel("Arrange these items in order:");
        itemsTitleLabel.setBounds(codeTemplateClassPanel.getWidth() - 580,198 - 50 - 20,700,50); //bounds
        itemsTitleLabel.setFont(new Font("Helvetica", Font.BOLD, 25)); //font
        itemsTitleLabel.setForeground(Color.decode("#ffffff")); //text colour
        codeTemplateClassPanel.add(itemsTitleLabel);

        //Setup exit button
        exitCodeTemplateClassButton.setBounds(1720 - 150 - 30,750 - 75 - 30,150,75);
        exitCodeTemplateClassButton.setFont(MainMenu.headingFont);
        exitCodeTemplateClassButton.setForeground(Color.decode("#ffffff"));
        exitCodeTemplateClassButton.setBackground(Color.decode("#45818e"));
        exitCodeTemplateClassButton.addActionListener(this);
        codeTemplateClassPanel.add(exitCodeTemplateClassButton);

        //Setup each label in the item label array
        for (int index = 0; index < itemArray.length; index++) {
            //set bounds
            itemArray[index].setBounds(64 + 884,178 + 22 + (index * 108),732,93);
            //x stays the same,y starts at 200 and has 108 gap b/w labels, width and height stay the same

            //setup everything else
            itemArray[index].setFont(MainMenu.buttonFont); //font
            itemArray[index].setForeground(Color.decode("#ffffff")); //text colour
            itemArray[index].setBackground(Color.decode("#6d9eeb")); //background colour
            itemArray[index].setOpaque(true); //see the background
            itemArray[index].addMouseListener(codeTemplateClassJLabelAdapter);
            itemArray[index].addMouseMotionListener(codeTemplateClassJLabelAdapter);

            //add labels to the panel
            codeTemplateClassPanel.add(itemArray[index]);

        }

        //Setup destination box array
        //Make a gray plain label box to visually represent the destination box
        //NOTE: this needs to be added after the item array otherwise it will "be on top of" the draggable labels when you drag them
        for (int index = 0; index < destinationBoxArray2.length; index++) {
            destinationBoxArray2[index].setBackground(Color.decode("#d9dfdb")); //background colour
            destinationBoxArray2[index].setOpaque(true); //see the background
            codeTemplateClassPanel.add(destinationBoxArray2[index]); //add destination box
        }

        //Setup submit button
        submitCodeTemplateClassButton.setBounds(1720 - 150 - 30 - 200 - 30,750 - 75 - 30,200,75);
        submitCodeTemplateClassButton.setFont(MainMenu.subheadingFont);
        submitCodeTemplateClassButton.setForeground(Color.decode("#ffffff"));
        submitCodeTemplateClassButton.setBackground(Color.decode("#45818e"));
        submitCodeTemplateClassButton.addActionListener(this);
        codeTemplateClassPanel.add(submitCodeTemplateClassButton);

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

    //this method sets up the frame
    private void setFrame() {

        //Set menuBar
        this.setJMenuBar(menuBar);

        //Setup the frame
        setTitle("CAI App: Objects and Classes - ACTIVITIES"); //Title
        setSize(1920,1080); //Size
        getContentPane().setBackground(Color.decode("#073763")); //Background color
        setLayout(null); //Layout

        //Add panels
        add(titleLabelPanel);
        add(descriptionPanel);
        add(matchingGamePanel);
        add(codeTemplateClassPanel);

        //Miscellaneous setup
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    //this method performs actions
    @Override
    public void actionPerformed(ActionEvent event) {

        //if the start button for the matching game is selected
        if (event.getSource() == activity1descStartButton) {

            //set description panel to not visible
            descriptionPanel.setVisible(false);

            //reset the bounds of the answer labels so they return to their initial position
            for (int index = 0; index < matchingAnswerArray.length; index++) {
                //set bounds
                if (index <= 3)
                    matchingAnswerArray[index].setBounds(48 + 925, 177 + (index * 139), 299, 106);
                //x stays the same,y starts at 177 and has 139 gap b/w labels, width and height stay the same

                //set bounds for the other 3 answer labels not in the same row
                if (index >= 4)
                    matchingAnswerArray[index].setBounds(48 + 925 + 335, 177 + 56 + ((index - 4) * 139), 299, 106);
            }

            //set game to be visible
            matchingGamePanel.setVisible(true);

        }

        //if the start button for the code template class activity is selected
        if (event.getSource() == activity2descStartButton) {

            //set description panel to not visible
            descriptionPanel.setVisible(false);

            //reset the bounds of the item labels so they return to their initial position
            for (int index = 0; index < itemArray.length; index++) {
                //set bounds
                itemArray[index].setBounds(64 + 884, 178 + 22 + (index * 108), 732, 93);
                //x stays the same,y starts at 200 and has 108 gap b/w labels, width and height stay the same
            }

            //set game to be visible
            codeTemplateClassPanel.setVisible(true);

        }

        //if the exit button for the matching game is selected
        if (event.getSource() == exitMatchingGameButton) {

            //set game to not visible
            matchingGamePanel.setVisible(false);

            //set description panel to be visible
            descriptionPanel.setVisible(true);

        }

        //if the submit button for the matching game is selected
        if (event.getSource() == submitMatchingGameButton) {
            //At the end of the activity calculate the final score of the user and display it in a dialog box
            //Also return to the beginning of the activity screen

            //check scores for activity
            int score = checkLabelScoresForMatchingGame();
            String stringScore = Integer.toString(score);

            //display a dialog box
            //https://stackoverflow.com/questions/42725666/how-can-i-display-a-message-dialog-box-in-java
            //using showMessageDialog(component parentComponent,String message,String messageTitle,int optionType) method to display a message dialog box
            JOptionPane.showMessageDialog(null,"Score: " + stringScore + "/4  :)","Matching Game Score", JOptionPane.INFORMATION_MESSAGE);

            //set game to not visible
            matchingGamePanel.setVisible(false);

            //set description panel to be visible
            descriptionPanel.setVisible(true);

        }

        //if the exit button for the code template class activity is selected
        if (event.getSource() == exitCodeTemplateClassButton) {

            //set activity to not visible
            codeTemplateClassPanel.setVisible(false);

            //set description panel to be visible
            descriptionPanel.setVisible(true);

        }

        //if the submit button for the code template class activity is selected
        if (event.getSource() == submitCodeTemplateClassButton) {
            //At the end of the activity calculate the final score of the user and display it in a dialog box
            //Also return to the beginning of the activity screen

            //check scores for activity
            int score = checkLabelScoresForCodeTemplateClass();
            String stringScore = Integer.toString(score);

            //display a dialog box
            //https://stackoverflow.com/questions/42725666/how-can-i-display-a-message-dialog-box-in-java
            //using showMessageDialog(component parentComponent,String message,String messageTitle,int optionType) method to display a message dialog box
            JOptionPane.showMessageDialog(null,"Score: " + stringScore + "/4  :)","Matching Game Score", JOptionPane.INFORMATION_MESSAGE);

            //set activity to not visible
            codeTemplateClassPanel.setVisible(false);

            //set description panel to be visible
            descriptionPanel.setVisible(true);

        }

    }

    //this method checks for the labels in the destination boxes when the submit button is pressed for the matching game
    private int checkLabelScoresForMatchingGame() {
        //tally score
        int score = 0;

        //check if the destination box contains the label that correctly answers the questions
        if (destinationBoxArray1[0].containsLabel(matchingAnswerArray[3])) {
            //in this case the first box matches with the fourth answer

            score++;
        }

        //do the same for the other questions
        if (destinationBoxArray1[1].containsLabel(matchingAnswerArray[0])) {
            score++;
        }

        if (destinationBoxArray1[2].containsLabel(matchingAnswerArray[2])) {
            score++;
        }

        if (destinationBoxArray1[3].containsLabel(matchingAnswerArray[5])) {
            score++;
        }

        //return the tallied score
        return score;
    }

    //this method checks for the labels in the destination boxes when the submit button is pressed for the code template class activity
    private int checkLabelScoresForCodeTemplateClass() {
        //tally score
        int score = 0;

        //check if the destination box contains the label that is in the correct order
        if (destinationBoxArray2[0].containsLabel(itemArray[3])) {
            //in this case the first box matches with the fourth answer
            //first thing in a template class is the instance variables
            score++;
        }

        //do the same for the other questions
        if (destinationBoxArray2[1].containsLabel(itemArray[2])) {
            //second thing in a template class is the constructor method
            score++;
        }

        if (destinationBoxArray2[2].containsLabel(itemArray[0])) {
            //third thing in a template class is the getters and setters
            score++;
        }

        if (destinationBoxArray2[3].containsLabel(itemArray[1])) {
            //last thing in a template class is the toString Method
            score++;
        }

        //return the tallied score
        return score;
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

    //while researching I found out about mouse adapters, mouse adapters allow the programmer to only use the listener methods they need instead of all of them
    //the link below explains the difference:
    //https://stackoverflow.com/questions/44268617/difference-between-mouselistener-and-mouseadapter-in-java#:~:text=MouseListener%20is%20preferred%20only%20when,MouseAdapter%20is%20the%20preferred%20choice.&text=MouseListener%20is%20an%20Interface%20and,that%20you%20use%20a%20MouseListener.
    //this mouse adapter is for the matching game
    MouseAdapter matchingGameJLabelAdapter = new MouseAdapter() {

        //initialize the current draggable label (so we don't check for each individual draggable label, only the current one)
        private JLabel currentJLabel;

        public void mousePressed(MouseEvent mouseEvent) {
            //set the current label that will be dragged
            //idea from: https://www.reddit.com/r/javahelp/comments/3csa2n/java_swingdrag_and_drop_of_a_jlabel_with_an_image/
            currentJLabel = (JLabel) mouseEvent.getSource();
        }

        public void mouseDragged(MouseEvent mouseEvent) {
            //I also found out about the point class and how Point objects are coordinates
            //https://stackoverflow.com/questions/18951124/an-example-of-the-use-of-the-point-class
            Point currentPoint = mouseEvent.getPoint();
            Point labelLocation = currentJLabel.getLocation();

            //this uses this code: https://gist.github.com/OscarAMS/dec2ac8c13af8b4a0888508e685bbfd6
            //From here --> Dragging and moving a label on a window in Java: https://forum.level1techs.com/t/dragging-and-moving-a-label-on-a-window-in-java/109258/1
            //but with points instead of raw x and y
            currentJLabel.setLocation(labelLocation.x + currentPoint.x - currentJLabel.getWidth()/2,
                    labelLocation.y + currentPoint.y - currentJLabel.getHeight()/2);
        }

        public void mouseReleased(MouseEvent mouseEvent) {
            //the point to be checked for snapping should be in the center of the draggable label
            Point currentCenterPoint = new Point(currentJLabel.getX() + currentJLabel.getWidth()/2,
                    currentJLabel.getY() + currentJLabel.getHeight()/2);

            //check if the draggable label is in the snapping range of the destination box
            if (destinationBoxArray1[0].getSnappingRange().contains(currentCenterPoint)) {
                //snap the label to the position of the destination box
                currentJLabel.setLocation(destinationBoxArray1[0].getLocation());
            }

            //do the same for all the other destination boxes
            if (destinationBoxArray1[1].getSnappingRange().contains(currentCenterPoint))
                currentJLabel.setLocation(destinationBoxArray1[1].getLocation());

            if (destinationBoxArray1[2].getSnappingRange().contains(currentCenterPoint))
                currentJLabel.setLocation(destinationBoxArray1[2].getLocation());

            if (destinationBoxArray1[3].getSnappingRange().contains(currentCenterPoint))
                currentJLabel.setLocation(destinationBoxArray1[3].getLocation());
        }

    };

    //this mouse adapter is for the code template class activity
    MouseAdapter codeTemplateClassJLabelAdapter = new MouseAdapter() {

        //initialize the current draggable label (so we don't check for each individual draggable label, only the current one)
        private JLabel currentJLabel;

        public void mousePressed(MouseEvent mouseEvent) {
            //set the current label that will be dragged
            //idea from: https://www.reddit.com/r/javahelp/comments/3csa2n/java_swingdrag_and_drop_of_a_jlabel_with_an_image/
            currentJLabel = (JLabel) mouseEvent.getSource();
        }

        public void mouseDragged(MouseEvent mouseEvent) {
            //I also found out about the point class and how Point objects are coordinates
            //https://stackoverflow.com/questions/18951124/an-example-of-the-use-of-the-point-class
            Point currentPoint = mouseEvent.getPoint();
            Point labelLocation = currentJLabel.getLocation();

            //this uses this code: https://gist.github.com/OscarAMS/dec2ac8c13af8b4a0888508e685bbfd6
            //From here --> Dragging and moving a label on a window in Java: https://forum.level1techs.com/t/dragging-and-moving-a-label-on-a-window-in-java/109258/1
            //but with points instead of raw x and y
            currentJLabel.setLocation(labelLocation.x + currentPoint.x - currentJLabel.getWidth()/2,
                    labelLocation.y + currentPoint.y - currentJLabel.getHeight()/2);
        }

        public void mouseReleased(MouseEvent e) {
            //the point to be checked for snapping should be in the center of the draggable label
            Point currentCenterPoint = new Point(currentJLabel.getX() + currentJLabel.getWidth()/2,
                    currentJLabel.getY() + currentJLabel.getHeight()/2);

            //(just so happens the 2nd activity also has 4 destination boxes :) )
            //check if the draggable label is in the snapping range of the destination box
            if (destinationBoxArray2[0].getSnappingRange().contains(currentCenterPoint)) {
                //snap the label to the position of the destination box
                currentJLabel.setLocation(destinationBoxArray2[0].getLocation());
            }

            //do the same for all the other destination boxes
            if (destinationBoxArray2[1].getSnappingRange().contains(currentCenterPoint))
                currentJLabel.setLocation(destinationBoxArray2[1].getLocation());

            if (destinationBoxArray2[2].getSnappingRange().contains(currentCenterPoint))
                currentJLabel.setLocation(destinationBoxArray2[2].getLocation());

            if (destinationBoxArray2[3].getSnappingRange().contains(currentCenterPoint))
                currentJLabel.setLocation(destinationBoxArray2[3].getLocation());
        }

    };

}
