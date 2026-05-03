//imports for GUI components
import java.awt.*;
import javax.swing.*;

//imports to listen for actions
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class is the assessment GUI screen and its background processes
//the assessment GUI screen is for the user test their learning by doing quizzes that tests their knowledge
public class Assessment extends JFrame implements ActionListener, MenuListener {

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
    private JButton quiz1descStartButton = new JButton("Start");
    private JButton quiz2descStartButton = new JButton("Start");


    //Definitions Quiz (quiz 1) Panel array
    private JPanel[] definitionQuizPanelArray = new JPanel[5];

    //title label array
    JLabel[] definitionTitleLabelArray = new JLabel[5];

    //QuizQuestion Array
    //*Note a classmate briefly mentioned to me about creating an object for the questions and the thought did occur to me in the planning phase
    //*of the project but I didn't think it was necessary. But I reconsidered and made a QuizQuestion Class for QuizQuestion objects
    QuizQuestion[] definitionQuizQuestionArray = {
            new QuizQuestion("A ______ in java is a virtual _____ to represent any person, place, or thing",
                    "A object in java is a virtual object to represent any person, place, or thing",
                    false), //set default to incorrect
            new QuizQuestion("A _____ is a blueprint or a plan used to make objects",
                    "A class is a blueprint or a plan used to make objects",
                    false),
            new QuizQuestion("An object that is created using a class is said to be an _____ of that class",
                    "An object that is created using a class is said to be an instance of that class",
                    false),
            new QuizQuestion("Instance variables are also typically called?",
                    "Fields",
                    false),
            new QuizQuestion("A _____ is the method we use at the top of our class to create new objects",
                    "A constructor method is the method we use at the top of our class to create new objects",
                    false)
    };

    //question label array
    JLabel[] definitionQuestionLabelArray = new JLabel[5];

    //Exit button
    JButton[] definitionQuizExitButtonArray = new JButton[5];

    //radio buttons for question options
    //*created quiz option class which allows me to tell if selected radiobutton is the correct answer or not
    QuizOption[][] definitionQuizAnswerOptionsArray = new QuizOption[5][4];
    //5 arrays of radio buttons each with 4 radio buttons
    //5 questions each with 4 options in each question

    //Radio button group
    ButtonGroup[] definitionQuizAnswerOptionsButtonGroupArray = new ButtonGroup[5];

    //previous slide button
    JButton[] definitionQuizPreviousButtonArray = new JButton[5];

    //next slide button
    JButton[] definitionQuizNextButtonArray = new JButton[5];

    //int for the current slide number
    private int currentSlideDefinitionQuiz = 0;

    //int for the current score number
    private int currentScoreDefinitionQuiz = 0;


    //Implementing Code Quiz (quiz 2) Panel array
    private JPanel[] implementingCodeQuizPanelArray = new JPanel[3];

    //title label array
    JLabel[] implementingCodeTitleLabelArray = new JLabel[3];

    //QuizQuestion Array
    //*Note a classmate briefly mentioned to me about creating an object for the questions and the thought did occur to me in the planning phase
    //*of the project but I didn't think it was necessary. But I reconsidered and made a QuizQuestion Class for QuizQuestion objects
    QuizQuestion[] implementingCodeQuizQuestionArray = {
            new QuizQuestion("Second Step in Coding a Template Class",
                    "Constructor Method",
                    false), //set default to incorrect
            new QuizQuestion("Third Step in Coding a Template Class",
                    "Getters and Setters",
                    false),
            new QuizQuestion("What does calling the toString Method do?",
                    "Displays the contents of each field for an object",
                    false),
    };

    //question label array
    JLabel[] implementingCodeQuestionLabelArray = new JLabel[3];

    //Exit button
    JButton[] implementingCodeQuizExitButtonArray = new JButton[3];

    //radio buttons for question options
    //*created quiz option class which allows me to tell if selected radiobutton is the correct answer or not
    QuizOption[][] implementingCodeQuizAnswerOptionsArray = new QuizOption[3][4];
    //3 arrays of radio buttons each with 4 radio buttons
    //3 questions each with 4 options in each question

    //Radio button group
    ButtonGroup[] implementingCodeQuizAnswerOptionsButtonGroupArray = new ButtonGroup[3];

    //previous slide button
    JButton[] implementingCodeQuizPreviousButtonArray = new JButton[3];

    //next slide button
    JButton[] implementingCodeQuizNextButtonArray = new JButton[3];

    //int for the current slide number
    private int currentSlideImplementingCode = 0;

    //int for the current score number
    private int currentScoreImplementingCode = 0;


    //constructor method
    public Assessment() {

        //Setup menu bar
        setMenuBar();

        //Setup top Labels
        setTopLabels();

        //Setup the description Panel
        setDescriptionPanel();

        //Setup the Definitions Quiz (quiz1) Panels
        setDefinitionsQuiz();

        //Setup the Implementing Code Quiz (quiz2) Panels
        setImplementingCodeQuiz();

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
        JLabel screenTitleLabel = new JLabel("Assessment");

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
        descriptionPanel.setBounds(100, titleLabelPanel.getHeight() + 50,1920 - 200,750);
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.X_AXIS));
        descriptionPanel.setBackground(Color.decode("#666666"));


        //add glue to fill the space b/w the panel and the side
        descriptionPanel.add(Box.createHorizontalGlue());


        //Setup quiz 1 description Panel
        JPanel quiz1descPanel = new JPanel();
        quiz1descPanel.setSize(601,550);
        quiz1descPanel.setBackground(Color.decode("#666666"));
        quiz1descPanel.setLayout(new BoxLayout(quiz1descPanel, BoxLayout.Y_AXIS));

        //Title and description in an image
        JLabel quiz1descLabel = new JLabel(new ImageIcon("images/quiz1descLabel.png")); //title
        quiz1descLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //align to center

        //Start Button
        quiz1descStartButton.setSize(quiz1descPanel.getWidth(),100);
        quiz1descStartButton.setFont(MainMenu.headingFont);
        quiz1descStartButton.setForeground(Color.decode("#ffffff"));
        quiz1descStartButton.setBackground(Color.decode("#45818e"));
        quiz1descStartButton.addActionListener(this);
        quiz1descStartButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        //add components to panel
        quiz1descPanel.add(quiz1descLabel);
        quiz1descPanel.add(quiz1descStartButton);
        //add panel to main panel
        descriptionPanel.add(quiz1descPanel);


        //add glue to fill the space b/w the panels
        descriptionPanel.add(Box.createHorizontalGlue());


        //Setup quiz 2 description Panel
        JPanel quiz2descPanel = new JPanel();
        quiz2descPanel.setSize(601,550);
        quiz2descPanel.setBackground(Color.decode("#666666"));
        quiz2descPanel.setLayout(new BoxLayout(quiz2descPanel, BoxLayout.Y_AXIS));

        //Title and description in an image
        JLabel quiz2descLabel = new JLabel(new ImageIcon("images/quiz2descLabel.png")); //title
        quiz2descLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //align to center

        //Start Button
        quiz2descStartButton.setSize(quiz1descPanel.getWidth(),100);
        quiz2descStartButton.setFont(MainMenu.headingFont);
        quiz2descStartButton.setForeground(Color.decode("#ffffff"));
        quiz2descStartButton.setBackground(Color.decode("#45818e"));
        quiz2descStartButton.addActionListener(this);
        quiz2descStartButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        //add components to panel
        quiz2descPanel.add(quiz2descLabel);
        quiz2descPanel.add(quiz2descStartButton);
        //add panel to main panel
        descriptionPanel.add(quiz2descPanel);


        //add glue to fill the space b/w the panel and the side
        descriptionPanel.add(Box.createHorizontalGlue());

    }

    //this method sets up the definition quiz panels
    private void setDefinitionsQuiz() {

        //initialize the slideshow
        for (int index = 0; index < definitionQuizPanelArray.length; index++)
            definitionQuizPanelArray[index] = new JPanel();

        //Setup title labels
        for (int index = 0; index < definitionTitleLabelArray.length; index++) {
            //make 5 title labels for each question
            definitionTitleLabelArray[index] = new JLabel("Definition Quiz");

            //set the bounds font and colour
            definitionTitleLabelArray[index].setBounds(50,0,700,75);
            definitionTitleLabelArray[index].setFont(MainMenu.headingFont);
            definitionTitleLabelArray[index].setForeground(Color.decode("#ffffff")); //text colour

            //add to panel
            definitionQuizPanelArray[index].add(definitionTitleLabelArray[index]);
        }

        //Setup question labels
        for (int index = 0; index < definitionQuestionLabelArray.length; index++) {
            //set the text of the question to the label from each matching question
            definitionQuestionLabelArray[index] = new JLabel(definitionQuizQuestionArray[index].getQuestion());

            //set the bounds font and colour
            definitionQuestionLabelArray[index].setBounds(50,75 + 50,1000,75);
            definitionQuestionLabelArray[index].setFont(new Font("Helvetica", Font.BOLD, 25));
            definitionQuestionLabelArray[index].setForeground(Color.decode("#ffffff")); //text colour

            //add to panel
            definitionQuizPanelArray[index].add(definitionQuestionLabelArray[index]);
        }

        //initialize the radio buttons for question options
        //setup first question multiple choice (mc)
        definitionQuizAnswerOptionsArray[0] = new QuizOption[] {
                new QuizOption("Class, Class", false),
                new QuizOption("Class, Object", false),
                new QuizOption("Object, Object", true),
                new QuizOption("Object, Class", false)
        };
        //do the same for the other questions
        definitionQuizAnswerOptionsArray[1] = new QuizOption[] {
                new QuizOption("Plan", false),
                new QuizOption("Class", true),
                new QuizOption("Object", false),
                new QuizOption("Reference", false)
        };
        definitionQuizAnswerOptionsArray[2] = new QuizOption[] {
                new QuizOption("Reference", false),
                new QuizOption("Part", false),
                new QuizOption("Iteration", false),
                new QuizOption("Instance", true)
        };
        definitionQuizAnswerOptionsArray[3] = new QuizOption[] {
                new QuizOption("Qualities", false),
                new QuizOption("Features", false),
                new QuizOption("Fields", true),
                new QuizOption("Traits", false)
        };
        definitionQuizAnswerOptionsArray[4] = new QuizOption[] {
                new QuizOption("Set Method", false),
                new QuizOption("Constructor Method", true),
                new QuizOption("toString Method", false),
                new QuizOption("Main Method", false)
        };

        //Create button groups
        for (int index = 0; index < definitionQuizAnswerOptionsButtonGroupArray.length; index++) {
            //make 5 button groups for each question
            definitionQuizAnswerOptionsButtonGroupArray[index] = new ButtonGroup();
        }

        //setup the radio buttons
        for (int mainIndex = 0; mainIndex < 5; mainIndex++) {
            //there are 5 radio button arrays each with 4 radio buttons
            //add the radio buttons to their corresponding group by mainIndex
            for (int index = 0; index < definitionQuizAnswerOptionsArray[mainIndex].length; index++) {

                //setup bounds, font, and colour
                definitionQuizAnswerOptionsArray[mainIndex][index].setBounds(50,125 + 75 + index * 75,1000,75);
                definitionQuizAnswerOptionsArray[mainIndex][index].setFont(MainMenu.headingFont);
                definitionQuizAnswerOptionsArray[mainIndex][index].setForeground(Color.decode("#ffffff"));
                definitionQuizAnswerOptionsArray[mainIndex][index].setForeground(Color.decode("#02084b"));

                //add to button group
                definitionQuizAnswerOptionsButtonGroupArray[mainIndex].add(definitionQuizAnswerOptionsArray[mainIndex][index]);

                //add to panel
                definitionQuizPanelArray[mainIndex].add(definitionQuizAnswerOptionsArray[mainIndex][index]);
            }
        }

        //Setup previous slide buttons
        for (int index = 0; index < definitionQuizPreviousButtonArray.length; index++) {
            //make 5 exit buttons for each question
            definitionQuizPreviousButtonArray[index] = new JButton("Previous");

            //setup bounds, font, and colour
            definitionQuizPreviousButtonArray[index].setBounds(50,750 - 75 - 30,250,75);
            definitionQuizPreviousButtonArray[index].setFont(MainMenu.headingFont);
            definitionQuizPreviousButtonArray[index].setForeground(Color.decode("#ffffff"));
            definitionQuizPreviousButtonArray[index].setBackground(Color.decode("#45818e"));

            //add action listener
            definitionQuizPreviousButtonArray[index].addActionListener(this);

            //add to panel
            definitionQuizPanelArray[index].add(definitionQuizPreviousButtonArray[index]);
        }

        //Setup next slide buttons
        for (int index = 0; index < definitionQuizNextButtonArray.length; index++) {
            //make 5 exit buttons for each question
            definitionQuizNextButtonArray[index] = new JButton("Next");

            //setup bounds, font, and colour
            definitionQuizNextButtonArray[index].setBounds(50 + 250 + 30,750 - 75 - 30,150,75);
            definitionQuizNextButtonArray[index].setFont(MainMenu.headingFont);
            definitionQuizNextButtonArray[index].setForeground(Color.decode("#ffffff"));
            definitionQuizNextButtonArray[index].setBackground(Color.decode("#45818e"));

            //treat last next label as submit button
            if (index == 4) {
                definitionQuizNextButtonArray[index].setText("Submit");
                definitionQuizNextButtonArray[index].setBounds(50 + 250 + 30, 750 - 75 - 30, 250, 75);
            }

            //add action listener
            definitionQuizNextButtonArray[index].addActionListener(this);

            //add to panel
            definitionQuizPanelArray[index].add(definitionQuizNextButtonArray[index]);
        }

        //Setup exit buttons
        for (int index = 0; index < definitionQuizExitButtonArray.length; index++) {
            //make 5 exit buttons for each question
            definitionQuizExitButtonArray[index] = new JButton("Exit");

            //setup bounds, font, and colour
            definitionQuizExitButtonArray[index].setBounds(1720 - 150 - 30,750 - 75 - 30,150,75);
            definitionQuizExitButtonArray[index].setFont(MainMenu.headingFont);
            definitionQuizExitButtonArray[index].setForeground(Color.decode("#ffffff"));
            definitionQuizExitButtonArray[index].setBackground(Color.decode("#45818e"));

            //add action listener
            definitionQuizExitButtonArray[index].addActionListener(this);

            //add to panel
            definitionQuizPanelArray[index].add(definitionQuizExitButtonArray[index]);
        }

        //setup for each question which is a panel in the array
        for (int index = 0; index < definitionQuizPanelArray.length; index++) {
            //set the bounds of the "slide"
            definitionQuizPanelArray[index].setBounds(100,
                    titleLabelPanel.getHeight() + 50, 1920 - 200, 750);
            definitionQuizPanelArray[index].setLayout(null);

            //set color of the panel
            definitionQuizPanelArray[index].setBackground(Color.decode("#666666"));

            //add all components are already added to the panel

            //add the panel to the frame
            add(definitionQuizPanelArray[index]);

            //default to panel not visible
            definitionQuizPanelArray[index].setVisible(false);

        }

    }

    //this method sets up the implementing code quiz panels
    private void setImplementingCodeQuiz() {

        //initialize the slideshow
        for (int index = 0; index < implementingCodeQuizPanelArray.length; index++)
            implementingCodeQuizPanelArray[index] = new JPanel();

        //Setup title labels
        for (int index = 0; index < implementingCodeTitleLabelArray.length; index++) {
            //make 5 title labels for each question
            implementingCodeTitleLabelArray[index] = new JLabel("Implementing Code Evaluation");

            //set the bounds font and colour
            implementingCodeTitleLabelArray[index].setBounds(50,0,1000,75);
            implementingCodeTitleLabelArray[index].setFont(MainMenu.headingFont);
            implementingCodeTitleLabelArray[index].setForeground(Color.decode("#ffffff")); //text colour

            //add to panel
            implementingCodeQuizPanelArray[index].add(implementingCodeTitleLabelArray[index]);
        }

        //Setup question labels
        for (int index = 0; index < implementingCodeQuestionLabelArray.length; index++) {
            //set the text of the question to the label from each matching question
            implementingCodeQuestionLabelArray[index] = new JLabel(implementingCodeQuizQuestionArray[index].getQuestion());

            //set the bounds font and colour
            implementingCodeQuestionLabelArray[index].setBounds(50,75 + 50,1000,75);
            implementingCodeQuestionLabelArray[index].setFont(new Font("Helvetica", Font.BOLD, 25));
            implementingCodeQuestionLabelArray[index].setForeground(Color.decode("#ffffff")); //text colour

            //add to panel
            implementingCodeQuizPanelArray[index].add(implementingCodeQuestionLabelArray[index]);
        }

        //initialize the radio buttons for question options
        //setup first question multiple choice (mc)
        implementingCodeQuizAnswerOptionsArray[0] = new QuizOption[] {
                new QuizOption("toSting Method", false),
                new QuizOption("Instance Variables (Fields)", false),
                new QuizOption("Getters and Setters", false),
                new QuizOption("Constructor Method", true)
        };
        //do the same for the other questions
        implementingCodeQuizAnswerOptionsArray[1] = new QuizOption[] {
                new QuizOption("Instance Variables (Fields)", false),
                new QuizOption("Getters and Setters", true),
                new QuizOption("Constructor Method", false),
                new QuizOption("toSting Method", false)
        };
        implementingCodeQuizAnswerOptionsArray[2] = new QuizOption[] {
                new QuizOption("Displays the contents of each field for an object", true),
                new QuizOption("Turns the object into a string", false),
                new QuizOption("Does nothing, the object isn't a string", false),
                new QuizOption("Displays the fields that are strings in an object", false)
        };

        //Create button groups
        for (int index = 0; index < implementingCodeQuizAnswerOptionsButtonGroupArray.length; index++) {
            //make 5 button groups for each question
            implementingCodeQuizAnswerOptionsButtonGroupArray[index] = new ButtonGroup();
        }

        //setup the radio buttons
        for (int mainIndex = 0; mainIndex < implementingCodeQuizPanelArray.length; mainIndex++) {
            //there are 5 radio button arrays each with 4 radio buttons
            //add the radio buttons to their corresponding group by mainIndex
            for (int index = 0; index < implementingCodeQuizAnswerOptionsArray[mainIndex].length; index++) {

                //setup bounds, font, and colour
                implementingCodeQuizAnswerOptionsArray[mainIndex][index].setBounds(50,125 + 75 + index * 75,1300,75);
                implementingCodeQuizAnswerOptionsArray[mainIndex][index].setFont(MainMenu.headingFont);
                implementingCodeQuizAnswerOptionsArray[mainIndex][index].setForeground(Color.decode("#ffffff"));
                implementingCodeQuizAnswerOptionsArray[mainIndex][index].setForeground(Color.decode("#02084b"));

                //add to button group
                implementingCodeQuizAnswerOptionsButtonGroupArray[mainIndex].add(implementingCodeQuizAnswerOptionsArray[mainIndex][index]);

                //add to panel
                implementingCodeQuizPanelArray[mainIndex].add(implementingCodeQuizAnswerOptionsArray[mainIndex][index]);
            }
        }

        //Setup previous slide buttons
        for (int index = 0; index < implementingCodeQuizPreviousButtonArray.length; index++) {
            //make 5 exit buttons for each question
            implementingCodeQuizPreviousButtonArray[index] = new JButton("Previous");

            //setup bounds, font, and colour
            implementingCodeQuizPreviousButtonArray[index].setBounds(50,750 - 75 - 30,250,75);
            implementingCodeQuizPreviousButtonArray[index].setFont(MainMenu.headingFont);
            implementingCodeQuizPreviousButtonArray[index].setForeground(Color.decode("#ffffff"));
            implementingCodeQuizPreviousButtonArray[index].setBackground(Color.decode("#45818e"));

            //add action listener
            implementingCodeQuizPreviousButtonArray[index].addActionListener(this);

            //add to panel
            implementingCodeQuizPanelArray[index].add(implementingCodeQuizPreviousButtonArray[index]);
        }

        //Setup next slide buttons
        for (int index = 0; index < implementingCodeQuizNextButtonArray.length; index++) {
            //make 5 exit buttons for each question
            implementingCodeQuizNextButtonArray[index] = new JButton("Next");

            //setup bounds, font, and colour
            implementingCodeQuizNextButtonArray[index].setBounds(50 + 250 + 30,750 - 75 - 30,150,75);
            implementingCodeQuizNextButtonArray[index].setFont(MainMenu.headingFont);
            implementingCodeQuizNextButtonArray[index].setForeground(Color.decode("#ffffff"));
            implementingCodeQuizNextButtonArray[index].setBackground(Color.decode("#45818e"));

            //treat last next label as submit button
            if (index == 2) {
                implementingCodeQuizNextButtonArray[index].setText("Submit");
                implementingCodeQuizNextButtonArray[index].setBounds(50 + 250 + 30, 750 - 75 - 30, 250, 75);
            }

            //add action listener
            implementingCodeQuizNextButtonArray[index].addActionListener(this);

            //add to panel
            implementingCodeQuizPanelArray[index].add(implementingCodeQuizNextButtonArray[index]);
        }

        //Setup exit buttons
        for (int index = 0; index < implementingCodeQuizExitButtonArray.length; index++) {
            //make 5 exit buttons for each question
            implementingCodeQuizExitButtonArray[index] = new JButton("Exit");

            //setup bounds, font, and colour
            implementingCodeQuizExitButtonArray[index].setBounds(1720 - 150 - 30,750 - 75 - 30,150,75);
            implementingCodeQuizExitButtonArray[index].setFont(MainMenu.headingFont);
            implementingCodeQuizExitButtonArray[index].setForeground(Color.decode("#ffffff"));
            implementingCodeQuizExitButtonArray[index].setBackground(Color.decode("#45818e"));

            //add action listener
            implementingCodeQuizExitButtonArray[index].addActionListener(this);

            //add to panel
            implementingCodeQuizPanelArray[index].add(implementingCodeQuizExitButtonArray[index]);
        }

        //setup for each question which is a panel in the array
        for (int index = 0; index < implementingCodeQuizPanelArray.length; index++) {
            //set the bounds of the "slide"
            implementingCodeQuizPanelArray[index].setBounds(100,
                    titleLabelPanel.getHeight() + 50, 1920 - 200, 750);
            implementingCodeQuizPanelArray[index].setLayout(null);

            //set color of the panel
            implementingCodeQuizPanelArray[index].setBackground(Color.decode("#666666"));

            //add all components are already added to the panel

            //add the panel to the frame
            add(implementingCodeQuizPanelArray[index]);

            //default to panel not visible
            implementingCodeQuizPanelArray[index].setVisible(false);

        }

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
        setTitle("CAI App: Objects and Classes - ASSESSMENT"); //Title
        setSize(1920,1080); //Size
        getContentPane().setBackground(Color.decode("#073763")); //Background color
        setLayout(null); //Layout

        //Add panels
        add(titleLabelPanel);
        add(descriptionPanel);

        //Miscellaneous setup
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }


    //this method performs actions
    @Override
    public void actionPerformed(ActionEvent event) {

        //if the start button for the definitions quiz is selected
        if (event.getSource() == quiz1descStartButton) {

            //set description panel to not visible
            descriptionPanel.setVisible(false);

            //set fist quiz question to be visible
            definitionQuizPanelArray[0].setVisible(true);
        }

        //if the start button for the implementing code evaluation is selected
        if (event.getSource() == quiz2descStartButton) {

            //set description panel to not visible
            descriptionPanel.setVisible(false);

            //set quiz to be visible
            implementingCodeQuizPanelArray[0].setVisible(true);
        }



        //ACTIONS FOR THE DEFINITIONS QUIZ
        //for the exit buttons for quiz1
        //check exit buttons for current slide and not last slide
        if (event.getSource() == definitionQuizExitButtonArray[currentSlideDefinitionQuiz] && currentSlideDefinitionQuiz != 4) {

            //set current panel to not visible
            definitionQuizPanelArray[currentSlideDefinitionQuiz].setVisible(false);

            //set description panel to visible
            descriptionPanel.setVisible(true);

            //reset variables
            currentSlideDefinitionQuiz = 0;
            currentScoreDefinitionQuiz = 0;
        }
        //if the last exit button is pressed display the score
        else if (event.getSource() == definitionQuizExitButtonArray[4]) {

            //display score
            JOptionPane.showMessageDialog(null,"Score: " + currentScoreDefinitionQuiz + "/5  :)","Definition Quiz Score", JOptionPane.INFORMATION_MESSAGE);

            //set current panel to not visible
            definitionQuizPanelArray[currentSlideDefinitionQuiz].setVisible(false);

            //set description panel to visible
            descriptionPanel.setVisible(true);

            //reset variables
            currentSlideDefinitionQuiz = 0;
            currentScoreDefinitionQuiz = 0;

        }

        //for the previous buttons
        for (int index = 0; index < definitionQuizPreviousButtonArray.length; index++) {

            //if the source of the previous button is on the current slide
            if (event.getSource() == definitionQuizPreviousButtonArray[currentSlideDefinitionQuiz]) {

                //set previous panel to not visible (current panel technically)
                definitionQuizPanelArray[currentSlideDefinitionQuiz].setVisible(false);

                //change constant to required slide
                if (currentSlideDefinitionQuiz > 0)
                    currentSlideDefinitionQuiz -= 1;

                //show required panel
                definitionQuizPanelArray[currentSlideDefinitionQuiz].setVisible(true);

            }

        }

        //for the next buttons
        for (int index = 0; index < definitionQuizNextButtonArray.length; index++) {

            //if the source of the next button is on the current slide and not the last slide
            if (event.getSource() == definitionQuizNextButtonArray[currentSlideDefinitionQuiz] && event.getSource() != definitionQuizNextButtonArray[4]) {

                //check through all radio buttons
                //how to check through all radio buttons for selected one:
                //https://stackoverflow.com/questions/201287/how-do-i-get-which-jradiobutton-is-selected-from-a-buttongroup
                for (int radioButtonIndex = 0; radioButtonIndex < definitionQuizAnswerOptionsArray[currentSlideDefinitionQuiz].length; radioButtonIndex++) {

                    //find selected button
                    if (definitionQuizAnswerOptionsArray[currentSlideDefinitionQuiz][radioButtonIndex].isSelected()) {

                        //if its correct increase score and display dialog box
                        if (definitionQuizAnswerOptionsArray[currentSlideDefinitionQuiz][radioButtonIndex].getCorrect()) {
                            JOptionPane.showMessageDialog(null,"Correct!","Correct Answer", JOptionPane.INFORMATION_MESSAGE);
                            currentScoreDefinitionQuiz++;
                        }

                        //else display incorrect and provide correct solution
                        else {
                            String correctAnswer = definitionQuizQuestionArray[currentSlideDefinitionQuiz].getAnswer();
                            JOptionPane.showMessageDialog(null,"Incorrect :(\n Correct Answer:\n" + correctAnswer,"Incorrect Answer", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }

                }

                //set previous panel to not visible (current panel technically)
                definitionQuizPanelArray[currentSlideDefinitionQuiz].setVisible(false);

                //change constant to required slide
                if (currentSlideDefinitionQuiz < definitionQuizPanelArray.length - 1)
                    currentSlideDefinitionQuiz += 1;

                //show required panel
                definitionQuizPanelArray[currentSlideDefinitionQuiz].setVisible(true);

            }

            //if the source of the next button is on the last slide treat it as a submit button
            else if (event.getSource() == definitionQuizNextButtonArray[4]) {

                //check through all radio buttons
                //https://stackoverflow.com/questions/201287/how-do-i-get-which-jradiobutton-is-selected-from-a-buttongroup
                for (int radioButtonIndex = 0; radioButtonIndex < definitionQuizAnswerOptionsArray[currentSlideDefinitionQuiz].length; radioButtonIndex++) {

                    //find selected button
                    if (definitionQuizAnswerOptionsArray[currentSlideDefinitionQuiz][radioButtonIndex].isSelected()) {

                        //if its correct increase score and display dialog box
                        if (definitionQuizAnswerOptionsArray[currentSlideDefinitionQuiz][radioButtonIndex].getCorrect()) {
                            JOptionPane.showMessageDialog(null, "Correct!", "Correct Answer", JOptionPane.INFORMATION_MESSAGE);
                            currentScoreDefinitionQuiz++;
                        }

                        //else display incorrect and provide correct solution
                        else {
                            String correctAnswer = definitionQuizQuestionArray[currentSlideDefinitionQuiz].getAnswer();
                            JOptionPane.showMessageDialog(null, "Incorrect :(\n Correct Answer:\n" + correctAnswer, "Incorrect Answer", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }

                }

                //stop loop
                break;

            }

        }



        //ACTIONS FOR THE IMPLEMENTING CODE EVALUATION
        //for the exit buttons for quiz2
        //check exit buttons for current slide and not last slide
        if (event.getSource() == implementingCodeQuizExitButtonArray[currentSlideImplementingCode] && currentSlideImplementingCode != 2) {

            //set current panel to not visible
            implementingCodeQuizPanelArray[currentSlideImplementingCode].setVisible(false);

            //set description panel to visible
            descriptionPanel.setVisible(true);

            //reset variables
            currentSlideImplementingCode = 0;
            currentScoreImplementingCode = 0;
        }
        //if the last exit button is pressed display the score
        else if (event.getSource() == implementingCodeQuizExitButtonArray[2]) {

            //display score
            JOptionPane.showMessageDialog(null,"Score: " + currentScoreImplementingCode + "/3  :)","Implementing Code Evaluation Score", JOptionPane.INFORMATION_MESSAGE);

            //set current panel to not visible
            implementingCodeQuizPanelArray[currentSlideImplementingCode].setVisible(false);

            //set description panel to visible
            descriptionPanel.setVisible(true);

            //reset variables
            currentSlideImplementingCode = 0;
            currentScoreImplementingCode = 0;
        }

        //for the previous buttons
        for (int index = 0; index < implementingCodeQuizPreviousButtonArray.length; index++) {

            //if the source of the previous button is on the current slide
            if (event.getSource() == implementingCodeQuizPreviousButtonArray[currentSlideImplementingCode]) {

                //set previous panel to not visible (current panel technically)
                implementingCodeQuizPanelArray[currentSlideImplementingCode].setVisible(false);

                //change constant to required slide
                if (currentSlideImplementingCode > 0)
                    currentSlideImplementingCode -= 1;

                //show required panel
                implementingCodeQuizPanelArray[currentSlideImplementingCode].setVisible(true);
            }
        }

        //for the next buttons
        for (int index = 0; index < implementingCodeQuizNextButtonArray.length; index++) {

            //if the source of the next button is on the current slide and not the last slide
            if (event.getSource() == implementingCodeQuizNextButtonArray[currentSlideImplementingCode] && event.getSource() != implementingCodeQuizNextButtonArray[2]) {

                //check through all radio buttons
                //https://stackoverflow.com/questions/201287/how-do-i-get-which-jradiobutton-is-selected-from-a-buttongroup
                for (int radioButtonIndex = 0; radioButtonIndex < implementingCodeQuizAnswerOptionsArray[currentSlideImplementingCode].length; radioButtonIndex++) {

                    //find selected button
                    if (implementingCodeQuizAnswerOptionsArray[currentSlideImplementingCode][radioButtonIndex].isSelected()) {

                        //if its correct increase score and display dialog box
                        if (implementingCodeQuizAnswerOptionsArray[currentSlideImplementingCode][radioButtonIndex].getCorrect()) {
                            JOptionPane.showMessageDialog(null,"Correct!","Correct Answer", JOptionPane.INFORMATION_MESSAGE);
                            currentScoreImplementingCode++;
                        }

                        //else display incorrect and provide correct solution
                        else {
                            String correctAnswer = implementingCodeQuizQuestionArray[currentSlideImplementingCode].getAnswer();
                            JOptionPane.showMessageDialog(null,"Incorrect :(\n Correct Answer:\n" + correctAnswer,"Incorrect Answer", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }

                }

                //set previous panel to not visible (current panel technically)
                implementingCodeQuizPanelArray[currentSlideImplementingCode].setVisible(false);

                //change constant to required slide
                if (currentSlideImplementingCode < implementingCodeQuizPanelArray.length - 1)
                    currentSlideImplementingCode += 1;

                //show required panel
                implementingCodeQuizPanelArray[currentSlideImplementingCode].setVisible(true);

            }

            //if the source of the next button is on the last slide treat it as a submit button
            else if (event.getSource() == implementingCodeQuizNextButtonArray[2]) {

                //check through all radio buttons
                //how to check through all radio buttons for selected one:
                //https://stackoverflow.com/questions/201287/how-do-i-get-which-jradiobutton-is-selected-from-a-buttongroup
                for (int radioButtonIndex = 0; radioButtonIndex < implementingCodeQuizAnswerOptionsArray[currentSlideImplementingCode].length; radioButtonIndex++) {

                    //find selected button
                    if (implementingCodeQuizAnswerOptionsArray[currentSlideImplementingCode][radioButtonIndex].isSelected()) {

                        //if its correct increase score and display dialog box
                        if (implementingCodeQuizAnswerOptionsArray[currentSlideImplementingCode][radioButtonIndex].getCorrect()) {
                            JOptionPane.showMessageDialog(null, "Correct!", "Correct Answer", JOptionPane.INFORMATION_MESSAGE);
                            currentScoreImplementingCode++;
                        }

                        //else display incorrect and provide correct solution
                        else {
                            String correctAnswer = implementingCodeQuizQuestionArray[currentSlideImplementingCode].getAnswer();
                            JOptionPane.showMessageDialog(null, "Incorrect :(\n Correct Answer:\n" + correctAnswer, "Incorrect Answer", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }

                }

                //stop loop
                break;

            }

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
