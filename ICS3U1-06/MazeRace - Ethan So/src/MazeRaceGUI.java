//imports for GUI components
import javax.swing.*;
import java.awt.*;

//imports for actions
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

//imports for reading files
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//this class is the GUI program and shows the visual maze in a new window
public class MazeRaceGUI extends JFrame implements ActionListener, KeyListener, MenuListener {

    //MenuBar
    //https://stackoverflow.com/questions/9862165/jmenu-actionlistener
    //Source used to create the menu bar
    private JMenuBar menuBar = new JMenuBar();
    private JMenu titleMenu = new JMenu("Title");
    private JMenu quitMenu = new JMenu("Quit");

    //constants for cell layout
        //final = can't be changes
    public static final int CELL_SIZE = 25;
    public static final int NUM_CELLS_WIDTH = 27;
    private final int NUM_CELLS_HEIGHT = 27;
    private final int NUM_COINS = 10;

    //constants for cell images
    private ImageIcon WALL = OpeningTitleGUI.wallIcon;
    private ImageIcon OUT_OF_BOUNDS = OpeningTitleGUI.outOfBoundsIcon;
    private ImageIcon PATH = new ImageIcon("images/grey square.png");
    private ImageIcon COIN = new ImageIcon("images/gold coin.gif");
    private ImageIcon[] SONIC = { //an array because there are 4 player positions, braces for Array Initializer
            new ImageIcon("images/" + OpeningTitleGUI.character + "0.gif"),
            new ImageIcon("images/" + OpeningTitleGUI.character + "1.gif"),
            new ImageIcon("images/" + OpeningTitleGUI.character + "2.gif"),
            new ImageIcon("images/" + OpeningTitleGUI.character + "3.gif")
    };

    //build player object
    private Player player = new Player(SONIC[1]);

    //mazes components
    private JPanel mazePanel = new JPanel();
    private JPanel scoreboardPanel = new JPanel();
    private JPanel highScorePanel = new JPanel();
    private Cell[][] maze = new Cell[NUM_CELLS_WIDTH][NUM_CELLS_HEIGHT];

    //create changing variables
    private int numCoinsCollected = 0;
    private double time = 0;

    //create game timer
    private Timer gameTimer = new Timer(100,this); //100 ms, tenths of a second
    private JLabel scoreLabel = new JLabel("Score: 0");
    private JLabel timerLabel = new JLabel("Time: 0s");

    //create current game session high score
    private JLabel currentHighScoreLabel = new JLabel();
    public static double currentHighScore = 0;

    //create high score labels
    private JLabel top5Label = new JLabel("Top 5 High Scores:");
    private JLabel[] highScoreLabelArray = new JLabel[5];
    //create high scores
        //set default score to 0
    public static double[] highScoreArray = {0,0,0,0,0};


    //constructor method
    public MazeRaceGUI() {

        menuBarSetup();
        scoreboardPanelSetup();
        mazePanelSetup();
        highScorePanelSetup();
        frameSetup();

    }

    //this method sets up the menuBar
    private void menuBarSetup() {

        //add menu items to menuBar
        menuBar.add(titleMenu);
        menuBar.add(quitMenu);

        //add menuListeners
        titleMenu.addMenuListener(this);
        quitMenu.addMenuListener(this);

    }

    //this method will setup the panel to hold the time and hold the score
    private void scoreboardPanelSetup() {

        //setup position and layout
        scoreboardPanel.setBounds(0,0,CELL_SIZE * NUM_CELLS_WIDTH,75); //cell width is game width
        scoreboardPanel.setLayout(null);

        //setup labels
        scoreLabel.setBounds(scoreboardPanel.getWidth()/2,0,100,25);
        timerLabel.setBounds(scoreboardPanel.getWidth()/2,25,100,25);
        currentHighScoreLabel.setBounds(scoreboardPanel.getWidth()/2 - 50,50,200,25);

        //update text for current high score
        currentHighScoreLabel.setText("Current High Score: " + String.format("%.1f", currentHighScore) + "s");

        //add labels
        scoreboardPanel.add(scoreLabel);
        scoreboardPanel.add(timerLabel);
        scoreboardPanel.add(currentHighScoreLabel);

    }

    //this method will setup the maze panel
    private void mazePanelSetup() {

        //setup panel bounds and layout
        mazePanel.setBounds(0,scoreboardPanel.getHeight(),CELL_SIZE * NUM_CELLS_WIDTH,CELL_SIZE * NUM_CELLS_HEIGHT);
        mazePanel.setLayout(new GridLayout(NUM_CELLS_WIDTH,NUM_CELLS_HEIGHT));

        //methods for setup
        loadMaze();
        placeCoins();
        placePlayer();

    }

    //this method places coins in the maze
    private void placeCoins() {

        //place as many coins randomly as set (NUM COINS)
        for (int coin = 1; coin <= NUM_COINS; coin++) {

            Cell cell = findEmptyCell(); //only place coins in empty cells

            //"place" a coin by setting the coin image in the empty cell's coordinates
            maze[cell.getRow()][cell.getCol()].setIcon(COIN);

        }

    }

    //this method will return an "empty" cell
    private Cell findEmptyCell() {

        //create a new cell instance but with no parameters because we don't know the location yet
        Cell cell = new Cell();

        //randomize empty cell location, continue until landing on a PATH
        do{
            cell.setRow((int) (Math.random() * 24) + 2);
            cell.setCol((int) (Math.random() * 24) + 2);
        } while (maze[cell.getRow()][cell.getCol()].getIcon() != PATH); //if its a path (path = empty) then we exit the loop

        //return empty cell
        return cell;

    }

    //this method places the player in the maze
    private void placePlayer() {

        //find a randomized empty cell
        Cell cell = findEmptyCell();

        //place player on empty cell
        player.setRow(cell.getRow());
        player.setCol(cell.getCol());

        //make sure player orientation is correct
        maze[cell.getRow()][cell.getCol()].setIcon(player.getIcon());

    }

    //this method will read the maze file to take input to "load" the maze
    private void loadMaze() {

        //variables for file input
        int row = 0;
        char[] line;

        try {

            //set .txt file as input
            Scanner inputFile = new Scanner(new File("maze.txt"));

            //read the file until there are no more lines
            while (inputFile.hasNext()) {

                //read in one line at a time and then convert it to character array
                line = inputFile.nextLine().toCharArray();

                //traverse through the line that is now an array
                for (int column = 0; column < line.length; column++)
                    fillCell(line[column], row, column);

                //move to next line
                row++;

            }

            inputFile.close();

        } catch (FileNotFoundException error) {
            System.out.println(error);
        }

    }

    //this method will fill the Cell maze array with Cell data
    private void fillCell(char character, int row, int column) {

        //build a new cell (instance) with matching row and column as array position
        maze[row][column] = new Cell(row, column);

        //set image depending on character
        if (character == 'W')
            maze[row][column].setIcon(WALL);
        else if (character == 'X')
            maze[row][column].setIcon(OUT_OF_BOUNDS);
        else if (character == '.')
            maze[row][column].setIcon(PATH);

        //add maze to the panel
        mazePanel.add(maze[row][column]);

    }

    //this method sets up the high score panel
    private void highScorePanelSetup() {

        //setup position and layout
        highScorePanel.setBounds(0,scoreboardPanel.getHeight() + mazePanel.getHeight(),CELL_SIZE * NUM_CELLS_WIDTH,150);
        highScorePanel.setLayout(null);

        //setup labels
        for (int index = 0; index < MazeRaceApplication.userArray.length; index++)
            highScoreLabelArray[index] = new JLabel(index+1 + ". "
                    + MazeRaceApplication.userArray[index].getUserInitials() + " - "
                    + String.format("%.1f", MazeRaceApplication.userArray[index].getHighScore()) + "s");
        
        //setup label bounds
        top5Label.setBounds(highScorePanel.getWidth()/2 - 50, 0,200,25);

        for (int index = 0; index < MazeRaceApplication.userArray.length; index++)
            highScoreLabelArray[index].setBounds(highScorePanel.getWidth()/2 - 50,index * 25 + 25,100,25);

        //add labels
       highScorePanel.add(top5Label);

        for (int index = 0; index < MazeRaceApplication.userArray.length; index++)
            highScorePanel.add(highScoreLabelArray[index]);

    }

    //this method updates the high scores
    private void updateHighScore() {

        //https://www.geeksforgeeks.org/convert-string-to-double-in-java/
        //convert string to double
        double score = time;


        //attempted efficiency which didn't work:
            //-high score updates as the lowest possible recorded high score instead of the lower time
//        for (int limit = 1; limit < highScoreArray.length; limit++) {
//
//            if (score <= highScoreArray[limit - 1] || highScoreArray[limit - 1] == 0) {
//
//                for (int count = 4; count > 0; count--) {
//
//                    if (count != limit)
//                        highScoreArray[count] = highScoreArray[count - 1];
//                    else
//                        highScoreArray[count - 1] = score;
//
//                }
//
//                for (int i = 0; i < MazeRaceApplication.userArray.length; i++)
//                    highScoreLabelArray[i].setText(i+1 + ". " + String.format("%.1f", highScoreArray[i]) + "s");
//
//                break;
//
//            }
//
//        }

        //check if score is greater than highest high score
        if (score <= MazeRaceApplication.userArray[0].getHighScore() || MazeRaceApplication.userArray[0].getHighScore() == 0) {
            //scores start at 0, the current score will always be greater than 0 so 0 is an acceptable value to change the score

            //update scores
            MazeRaceApplication.userArray[4].setHighScore(MazeRaceApplication.userArray[3].getHighScore());
            MazeRaceApplication.userArray[3].setHighScore(MazeRaceApplication.userArray[2].getHighScore());
            MazeRaceApplication.userArray[2].setHighScore(MazeRaceApplication.userArray[1].getHighScore());
            MazeRaceApplication.userArray[1].setHighScore(MazeRaceApplication.userArray[0].getHighScore());
            MazeRaceApplication.userArray[0].setHighScore(score);

            //update initials
            MazeRaceApplication.userArray[4].setUserInitials(MazeRaceApplication.userArray[3].getUserInitials());
            MazeRaceApplication.userArray[3].setUserInitials(MazeRaceApplication.userArray[2].getUserInitials());
            MazeRaceApplication.userArray[2].setUserInitials(MazeRaceApplication.userArray[1].getUserInitials());
            MazeRaceApplication.userArray[1].setUserInitials(MazeRaceApplication.userArray[0].getUserInitials());
            MazeRaceApplication.userArray[0].setUserInitials(OpeningTitleGUI.currentUserInitials);

            //set text
            for (int index = 0; index < MazeRaceApplication.userArray.length; index++)
                highScoreLabelArray[index].setText(index+1 + ". "
                        + MazeRaceApplication.userArray[index].getUserInitials() + " - "
                        + String.format("%.1f", MazeRaceApplication.userArray[index].getHighScore()) + "s");

            //check next high score
        } else if (score <= MazeRaceApplication.userArray[1].getHighScore() || MazeRaceApplication.userArray[1].getHighScore() == 0) {

            //update scores
            MazeRaceApplication.userArray[4].setHighScore(MazeRaceApplication.userArray[3].getHighScore());
            MazeRaceApplication.userArray[3].setHighScore(MazeRaceApplication.userArray[2].getHighScore());
            MazeRaceApplication.userArray[2].setHighScore(MazeRaceApplication.userArray[1].getHighScore());
            MazeRaceApplication.userArray[1].setHighScore(score);

            //update initials
            MazeRaceApplication.userArray[4].setUserInitials(MazeRaceApplication.userArray[3].getUserInitials());
            MazeRaceApplication.userArray[3].setUserInitials(MazeRaceApplication.userArray[2].getUserInitials());
            MazeRaceApplication.userArray[2].setUserInitials(MazeRaceApplication.userArray[1].getUserInitials());
            MazeRaceApplication.userArray[1].setUserInitials(OpeningTitleGUI.currentUserInitials);

            //set text
            for (int index = 0; index < MazeRaceApplication.userArray.length; index++)
                highScoreLabelArray[index].setText(index+1 + ". "
                        + MazeRaceApplication.userArray[index].getUserInitials() + " - "
                        + String.format("%.1f", MazeRaceApplication.userArray[index].getHighScore()) + "s");

            //check next high score
        } else if (score <= MazeRaceApplication.userArray[2].getHighScore() || MazeRaceApplication.userArray[2].getHighScore() == 0) {

            //update score
            MazeRaceApplication.userArray[4].setHighScore(MazeRaceApplication.userArray[3].getHighScore());
            MazeRaceApplication.userArray[3].setHighScore(MazeRaceApplication.userArray[2].getHighScore());
            MazeRaceApplication.userArray[2].setHighScore(score);

            //update initials
            MazeRaceApplication.userArray[4].setUserInitials(MazeRaceApplication.userArray[3].getUserInitials());
            MazeRaceApplication.userArray[3].setUserInitials(MazeRaceApplication.userArray[2].getUserInitials());
            MazeRaceApplication.userArray[2].setUserInitials(OpeningTitleGUI.currentUserInitials);

            //set text
            for (int index = 0; index < MazeRaceApplication.userArray.length; index++)
                highScoreLabelArray[index].setText(index+1 + ". "
                        + MazeRaceApplication.userArray[index].getUserInitials() + " - "
                        + String.format("%.1f", MazeRaceApplication.userArray[index].getHighScore()) + "s");

            //check next high score
        } else if (score <= MazeRaceApplication.userArray[3].getHighScore() || MazeRaceApplication.userArray[3].getHighScore() == 0) {

            //update score
            MazeRaceApplication.userArray[4].setHighScore(MazeRaceApplication.userArray[3].getHighScore());
            MazeRaceApplication.userArray[3].setHighScore(score);

            //update initials
            MazeRaceApplication.userArray[4].setUserInitials(MazeRaceApplication.userArray[3].getUserInitials());
            MazeRaceApplication.userArray[3].setUserInitials(OpeningTitleGUI.currentUserInitials);

            //set text
            for (int index = 0; index < MazeRaceApplication.userArray.length; index++)
                highScoreLabelArray[index].setText(index+1 + ". "
                        + MazeRaceApplication.userArray[index].getUserInitials() + " - "
                        + String.format("%.1f", MazeRaceApplication.userArray[index].getHighScore()) + "s");

            //check next high score
        } else if (score <= MazeRaceApplication.userArray[4].getHighScore() || MazeRaceApplication.userArray[4].getHighScore() == 0) {

            //update score
            MazeRaceApplication.userArray[4].setHighScore(score);

            //update initials
            MazeRaceApplication.userArray[4].setUserInitials(OpeningTitleGUI.currentUserInitials);

            //set text
            for (int index = 0; index < MazeRaceApplication.userArray.length; index++)
                highScoreLabelArray[index].setText(index+1 + ". "
                        + MazeRaceApplication.userArray[index].getUserInitials() + " - "
                        + String.format("%.1f", MazeRaceApplication.userArray[index].getHighScore()) + "s");

        }

    }

    //this method will setup the maze frame
    private void frameSetup() {

        //set menuBar
        this.setJMenuBar(menuBar);

        //frame setup
        setTitle("Ethan's MazeRace");
        setSize(mazePanel.getWidth()+ 15,
                scoreboardPanel.getHeight() + mazePanel.getHeight() + highScorePanel.getHeight() + 75);
        setLayout(null);

        //add the panels to the frame
        add(mazePanel);
        add(scoreboardPanel);
        add(highScorePanel);

        //add keyListener so that keyListener can respond to arrow movements
        addKeyListener(this);

        //miscellaneous setup
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //start the timer
        gameTimer.start();

    }

    //this method performs actions
    @Override
    public void actionPerformed(ActionEvent event) {

        //check if source is game timer
        if (event.getSource() == gameTimer) {

            time += 0.1; //clock goes up by 0.1 each time (100 ms, tenths of a second)
            timerLabel.setText("Time: " + String.format("%.1f", time) + "s");  //format the time as a string by 2 decimal places

        }

    }


    //these methods respond to the keyboard key:
    //responds to press and let go
        //NOT USED - must be kept for the keyListener
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //responds to press
    @Override
    public void keyPressed(KeyEvent key) {

        //check if the "Virtual Key" pressed is up and that the icon isn't a wall
        if (key.getKeyCode() == KeyEvent.VK_UP && maze[player.getRow() - 1][player.getCol() + 0].getIcon() != WALL) {
            player.setIcon(SONIC[0]);         //change player icon according to direction
            movePlayer(-1, 0);  //move the player
        }

        //check for right key pressed
        else if (key.getKeyCode() == KeyEvent.VK_RIGHT && maze[player.getRow() + 0][player.getCol() + 1].getIcon() != WALL) {
            player.setIcon(SONIC[1]);         //change player icon according to direction
            movePlayer(0, 1);   //move the player
        }

        //check for down key pressed
        else if (key.getKeyCode() == KeyEvent.VK_DOWN && maze[player.getRow() + 1][player.getCol() + 0].getIcon() != WALL) {
            player.setIcon(SONIC[2]);         //change player icon according to direction
            movePlayer(1, 0);   //move the player
        }

        //check for left key pressed
        else if (key.getKeyCode() == KeyEvent.VK_LEFT && maze[player.getRow() + 0][player.getCol() - 1].getIcon() != WALL) {
            player.setIcon(SONIC[3]);         //change player icon according to direction
            movePlayer(0, -1);  //move the player
        }



    }

    //this method "moves" the player to another square
    private void movePlayer(int dRow, int dColumn) {

        //replace previous square with a path icon
        maze[player.getRow()][player.getCol()].setIcon(PATH);

        //move the player
        player.move(dRow, dColumn);

        //if the square the player moved to is a coin update the score
        if (maze[player.getRow()][player.getCol()].getIcon() == COIN) {
            numCoinsCollected++;
            scoreLabel.setText("Score: " + numCoinsCollected);

            //also play the coin sound effect because the coin is collected
            OpeningTitleGUI.coinSoundEffect.start();
            //set position of the clip to the first frame
            //-start the clip from 0s next time it is played
            //https://www.youtube.com/watch?v=SyZQVJiARTQ (how to reset clip)
            OpeningTitleGUI.coinSoundEffect.setFramePosition(0);
        }

        //replace the new square "moved" to with player icon
        maze[player.getRow()][player.getCol()].setIcon(player.getIcon());

        //check if you won the game
        if (numCoinsCollected == NUM_COINS) {
            //if so then stop the timer and display a "Winner!" dialog box
            gameTimer.stop();
            JOptionPane.showMessageDialog(this, "Winner!\n" +
                    "*Note clicking 'OK' will restart the game"); //display on this frame

            //update current high score when game ends
            if (time < currentHighScore || currentHighScore == 0)
                currentHighScore = time;

            //update high score
            updateHighScore();

            //restart game
            this.dispose();
            new MazeRaceGUI();
        }

    }

    //responds to let go
        //NOT USED - must be kept for the keyListener
    @Override
    public void keyReleased(KeyEvent e) {

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
