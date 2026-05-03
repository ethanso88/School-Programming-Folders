//imports for GUI components
import javax.swing.*;
import java.awt.*;

//imports for actions
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//imports for sounds
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//this class is the first GUI screen the user sees to then customize or start the game.
public class OpeningTitleGUI extends JFrame implements ActionListener, MenuListener {

    //MenuBar
    //https://stackoverflow.com/questions/9862165/jmenu-actionlistener
        //Source used to create the menu bar
    private JMenuBar menuBar = new JMenuBar();
    private JMenu titleMenu = new JMenu("Title");
    private JMenu newGameMenu = new JMenu("New Game");
    private JMenu quitMenu = new JMenu("Quit");

    //Panels
    private JPanel titlePanel = new JPanel();
    private JPanel characterPanel = new JPanel();
    private JPanel themePanel = new JPanel();
    private JPanel initialsPanel = new JPanel();

    //Fonts
    public static Font titleFont = new Font("Helvetica", Font.BOLD, 50);
    public static Font headingFont = new Font("Helvetica", Font.BOLD, 40);
    public static Font subheadingFont = new Font("Helvetica", Font.PLAIN, 30);
    public static Font buttonFont = new Font("Helvetica", Font.BOLD, 18);


    //Title Panel components
    private JLabel titleLabel = new JLabel("MazeRace Game :)");
    private JLabel creditsLabel = new JLabel("- this version is made by Ethan So");

    //Character Panel components
    public static String character = "mario"; //global variable for character name
    private JLabel characterTitleLabel = new JLabel("Select Your Character:");
    private JRadioButton marioButton = new JRadioButton("mario");
    private JRadioButton sonicButton = new JRadioButton("sonic");
    private ButtonGroup characterGroup = new ButtonGroup();

    //Theme Panel components
    public static ImageIcon wallIcon = new ImageIcon("images/red square.png"); //global variable for wall icon
    public static ImageIcon outOfBoundsIcon = new ImageIcon("images/black square.png"); //global variable for out of bounds icon
    private JLabel themeTitleLabel = new JLabel("Select Game Theme:");
    private JRadioButton[] themeButtonArray = {
            new JRadioButton("red and black"),
            new JRadioButton("yellow and slate blue"),
            new JRadioButton("turquoise and dark green")
    };
    private ButtonGroup themeGroup = new ButtonGroup();

    //User Initials Panel components
    public static String currentUserInitials = "unknown";
    private JLabel initialsTitleLabel = new JLabel("Please enter your initials:");
    private JTextField initialsTextField = new JTextField("unknown");
    private JButton enterInitialsButton = new JButton("Enter Initials");

    //create clips for sound
        //must be initialized here to be used in the game
    public static Clip backgroundMusic;
    public static Clip coinSoundEffect;
    
    //constructor method
    public OpeningTitleGUI() {

        menuBarSetup();
        titlePanelSetup();
        characterPanelSetup();
        themePanelSetup();
        initialsPanelSetup();
        soundSetup();
        frameSetup();
        
    }

    //this method sets up the menuBar
    private void menuBarSetup() {

        //add menu items to menuBar
        menuBar.add(titleMenu);
        menuBar.add(newGameMenu);
        menuBar.add(quitMenu);

        //add menu font
        titleMenu.setFont(buttonFont);
        newGameMenu.setFont(buttonFont);
        quitMenu.setFont(buttonFont);

        //add menuListeners
        titleMenu.addMenuListener(this);
        newGameMenu.addMenuListener(this);
        quitMenu.addMenuListener(this);

    }

    //this method sets up the title panel
    private void titlePanelSetup() {

        //setup position and layout
        titlePanel.setBounds(20,0,1000,120 + 20);
        titlePanel.setLayout(null);

        //setup labels
        titleLabel.setBounds(100,0,titlePanel.getWidth(),80);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(new Color(0, 0, 0));

        creditsLabel.setBounds(titleLabel.getX() + 10,titleLabel.getHeight(),titlePanel.getWidth(),40);
        creditsLabel.setFont(subheadingFont);
        creditsLabel.setForeground(new Color(241, 27, 27));

        //add labels
        titlePanel.add(titleLabel);
        titlePanel.add(creditsLabel);
        
    }

    //this method sets up the option panel
    private void characterPanelSetup() {

        //setup position and layout
        characterPanel.setBounds(titlePanel.getX(),titlePanel.getHeight(),titlePanel.getWidth() - 20,140 + 20);
        characterPanel.setLayout(null);
        //https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/border.html#:~:text=To%20put%20a%20border%20around,a%20variable%20of%20type%20Border%20.
        //create a border surrounding the panel
        characterPanel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));

        //setup labels
        characterTitleLabel.setBounds(100,0,characterPanel.getWidth(),80);
        characterTitleLabel.setFont(headingFont);
        characterTitleLabel.setForeground(new Color(0, 0, 0));

        //setup buttons
        marioButton.setBounds(100,characterTitleLabel.getHeight(),200,30);
        marioButton.setFont(buttonFont);

        sonicButton.setBounds(100,characterTitleLabel.getHeight() + marioButton.getHeight(),marioButton.getWidth(),marioButton.getHeight());
        sonicButton.setFont(buttonFont);

        //add components
        characterPanel.add(characterTitleLabel);
        characterPanel.add(marioButton);
        characterPanel.add(sonicButton);

        //group buttons
        characterGroup.add(marioButton);
        characterGroup.add(sonicButton);

        //add actionListeners
        marioButton.addActionListener(this);
        sonicButton.addActionListener(this);

        //select mario as default
        //https://coderanch.com/t/334519/java/set-default-radio-button
        marioButton.setSelected(true);

    }

    //this method will setup the theme panel
    private void themePanelSetup() {

        //setup position and layout
        themePanel.setBounds(characterPanel.getX(),titlePanel.getHeight() + characterPanel.getHeight(),
                titlePanel.getWidth() - 20,170 + 20);
        themePanel.setLayout(null);
        //https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/border.html#:~:text=To%20put%20a%20border%20around,a%20variable%20of%20type%20Border%20.
        //create a border surrounding the panel
        themePanel.setBorder(BorderFactory.createMatteBorder(0,5,5,5,Color.BLACK));

        //setup labels
        themeTitleLabel.setBounds(100,0,themePanel.getWidth(),80);
        themeTitleLabel.setFont(headingFont);
        themeTitleLabel.setForeground(new Color(0, 0, 0));

        //setup buttons
        themeButtonArray[0].setBounds(100,themeTitleLabel.getHeight(),300,30);
        themeButtonArray[0].setFont(buttonFont);

        themeButtonArray[1].setBounds(100,themeTitleLabel.getHeight() + themeButtonArray[0].getHeight(),
                themeButtonArray[0].getWidth(),themeButtonArray[0].getHeight());
        themeButtonArray[1].setFont(buttonFont);

        themeButtonArray[2].setBounds(100,themeTitleLabel.getHeight() + themeButtonArray[0].getHeight() + themeButtonArray[1].getHeight(),
                themeButtonArray[0].getWidth(),themeButtonArray[0].getHeight());
        themeButtonArray[2].setFont(buttonFont);

        //add components
        themePanel.add(themeTitleLabel);
        for (int index = 0; index < themeButtonArray.length; index++) {
            themePanel.add(themeButtonArray[index]);
        }

        //group buttons
        for (int index = 0; index < themeButtonArray.length; index++) {
            themeGroup.add(themeButtonArray[index]);
        }

        //add actionListeners
        for (int index = 0; index < themeButtonArray.length; index++) {
            themeButtonArray[index].addActionListener(this);
        }

        //select theme1 as default
        //https://coderanch.com/t/334519/java/set-default-radio-button
        themeButtonArray[0].setSelected(true);

    }

    //this method will setup the user initials panel
    private void initialsPanelSetup() {

        //setup position and layout
        initialsPanel.setBounds(titlePanel.getX(),titlePanel.getHeight() + characterPanel.getHeight() + themePanel.getHeight()
                ,titlePanel.getWidth() - 20,140 + 20);
        initialsPanel.setLayout(null);
        //https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/border.html#:~:text=To%20put%20a%20border%20around,a%20variable%20of%20type%20Border%20.
        //create a border surrounding the panel
        initialsPanel.setBorder(BorderFactory.createMatteBorder(0,5,5,5,Color.BLACK));

        //setup labels
        initialsTitleLabel.setBounds(100,0,initialsPanel.getWidth(),80);
        initialsTitleLabel.setFont(headingFont);
        initialsTitleLabel.setForeground(new Color(0, 0, 0));

        //setup JTextField and JButton
        initialsTextField.setBounds(100,initialsTitleLabel.getHeight(),200,30);

        enterInitialsButton.setBounds(100,initialsTitleLabel.getHeight() + initialsTextField.getHeight(),200,30);
        enterInitialsButton.setFont(buttonFont);

        //add action listener
        initialsTextField.addActionListener(this);
        enterInitialsButton.addActionListener(this);

        //add components
        initialsPanel.add(initialsTitleLabel);
        initialsPanel.add(initialsTextField);
        initialsPanel.add(enterInitialsButton);

    }

    //this method will setup the sounds used
    private void soundSetup() {

        //https://www.youtube.com/watch?v=P856ukheHeE
        //how to add background music

        //https://www.youtube.com/watch?v=SyZQVJiARTQ
        //how to add a clip


        //add background music
            //try catch to attempt reading the file and catching errors
        try {
            //use file from sound folder for the background music
            File backgroundMusicFile = new File("sound/background music.wav");
            //https://www.youtube.com/watch?v=mRN_T6JkH-c&list=PLwJjxqYuirCLkq42mGw4XKGQlpZSfxsYd&index=1
            //music source

            //put our sound file into our audio input
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(backgroundMusicFile);

            //assign our audio/sound to our clip (this is the sound that we will be playing)
            backgroundMusic = AudioSystem.getClip();

            //Open the clip and transfer the audio input into it
            backgroundMusic.open(audioInput);
            //loop music as we want the background music to keep running
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);

            //set default to not played
            backgroundMusic.stop();

            //this clip will continue to loop when called or referenced until stopped
        } catch (Exception e) {
            System.out.print("error");
        }

        //add coin sound effect
            //try catch to attempt reading the file and catching errors
        try {
            //use file from sound folder for the coin sound efect
            File backgroundMusicFile = new File("sound/coin sound effect.wav");
            //https://www.youtube.com/watch?v=5v20ztxGvQ0
            //sound source

            //put our sound file into our audio input
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(backgroundMusicFile);

            //assign our audio/sound to our clip (this is the sound that we will be playing)
            coinSoundEffect = AudioSystem.getClip();

            //Open the clip and transfer the audio input into it
            coinSoundEffect.open(audioInput);

            //set default to not played
            coinSoundEffect.stop();

            //this clip will play when called or referenced
        } catch (Exception e) {
            System.out.print("error");
        }

    }

    //this method sets up the frame
    private void frameSetup() {

        //set menuBar
        this.setJMenuBar(menuBar);

        //frame setup
        setTitle("Ethan's MazeRace - Opening Screen");
        setSize(titlePanel.getX() + titlePanel.getWidth() + 20,
                titlePanel.getHeight() + characterPanel.getHeight()
                        + themePanel.getHeight() + initialsPanel.getHeight() + 80);
        setLayout(null);

        //add the panels to the frame
        add(titlePanel);
        add(characterPanel);
        add(themePanel);
        add(initialsPanel);

        //miscellaneous setup
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }


    //this method performs actions
    @Override
    public void actionPerformed(ActionEvent event) {

        //Actions for character select
        //if mario button is selected
        if (marioButton.isSelected()) {
            //change global variable to desired character
            character = "mario";
        }
        //if sonic button is selected
        else if (sonicButton.isSelected()) {
            //change global variable to desired character
            character = "sonic";
        }

        //Actions for theme select
        //Actions for character select
        //if theme1 is selected
        if (themeButtonArray[0].isSelected()) {
            //change icons for theme
            wallIcon = new ImageIcon("images/red square.png");
            outOfBoundsIcon = new ImageIcon("images/black square.png");
        }
        //if theme2 is selected
        else if (themeButtonArray[1].isSelected()) {
            //change icons for theme
            wallIcon = new ImageIcon("images/yellow square.png");
            outOfBoundsIcon = new ImageIcon("images/slate blue square.png");
        }
        //if theme3 is selected
        else if (themeButtonArray[2].isSelected()) {
            //change icons for theme
            wallIcon = new ImageIcon("images/turquoise square.png");
            outOfBoundsIcon = new ImageIcon("images/dark green square.png");
        }

        //Actions for initials
        if (event.getSource() == initialsTextField) {
             currentUserInitials = initialsTextField.getText();
        }
        if (event.getSource() == enterInitialsButton) {
            currentUserInitials = initialsTextField.getText();
        }

    }

    //this method performs actions when the menuBar is selected
    @Override
    public void menuSelected(MenuEvent event) {

        //if titleMenu is selected
        if (event.getSource() == titleMenu) {

            //close current screen
            this.setVisible(false);

            //stop background music
            OpeningTitleGUI.backgroundMusic.stop();

            //open the title screen
            MazeRaceApplication.openTitle();
        }

        //if newGameMenu is selected
        if (event.getSource() == newGameMenu) {

            //close current screen
            this.setVisible(false);

            //start background music
            OpeningTitleGUI.backgroundMusic.start();

            //open the title screen
            MazeRaceApplication.openMazeRace();
        }

        //if quit is selected
        if (event.getSource() == quitMenu) {

            //stop background music
            OpeningTitleGUI.backgroundMusic.stop();

            //save high scores before quitting
            MazeRaceApplication.saveHighScores();

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
