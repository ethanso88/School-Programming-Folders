//Name: Bryan Huang

//Date: May 14, 2024
//Course: ICS3U1-6
//Description: it is the title frame and introduces the user to the Laptop Store
//Title: SDP #1 - Laptop Store
//Major Skills: JLabel, JFont and actionListener

//imports
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


//This class is the Title Frame
public class LaptopStoreTitleFrame extends JFrame implements ActionListener, MouseListener {

    //GUI Elements

    //Button Elements
    static private JButton help = new JButton("Help");

    //This resized all my images except for the company logo which I will have to do here:
    ImageIcon originalCompanyLogo = new ImageIcon("images/companyLogo.png");
    //Scale the company logo
    ImageIcon scaledCompanyLogo = new ImageIcon(originalCompanyLogo.getImage().
            getScaledInstance(60,40, Image.SCALE_SMOOTH));

    //Menu bar elements
    JMenuBar menuBar = new JMenuBar();
    JMenu titleMenu = new JMenu("Title");
    JMenu inventoryMenu = new JMenu("Inventory");
    JMenu surveyMenu = new JMenu("Survey");
    JMenu resultsMenu = new JMenu("Results");
    JMenu educationMenu = new JMenu("Education");
    JLabel companyLogo = new JLabel(scaledCompanyLogo);

    // 1. GUI TitleWindow Setup
    public LaptopStoreTitleFrame() {
        // 1.1 Set the frame to be 1366 by 768
        setSize(1366, 768);
        setLayout(null);

        // 1.2 Set the background color
        getContentPane().setBackground(Color.decode("#3d85c6"));

        // 1.3 Set the frame title
        setTitle("Good Application - Title Frame");


        //1.4 Add the Menu Bar
        //1.4.1 Add a Menu Item for each screen (5 choices)
        menuBar.add(titleMenu);
        menuBar.add(inventoryMenu);
        menuBar.add(surveyMenu);
        menuBar.add(resultsMenu);
        menuBar.add(educationMenu);
        setJMenuBar(menuBar);

        //1.4.2 add menu fonts
        Font menuFont = new Font("Arial", Font.BOLD, 15);
        titleMenu.setFont(menuFont);
        inventoryMenu.setFont(menuFont);
        surveyMenu.setFont(menuFont);
        resultsMenu.setFont(menuFont);
        educationMenu.setFont(menuFont);

        //1.4.3 add action listener to menuBar items
        titleMenu.addMouseListener(this);
        inventoryMenu.addMouseListener(this);
        surveyMenu.addMouseListener(this);
        resultsMenu.addMouseListener(this);
        educationMenu.addMouseListener(this);

        //1.5 Set the company name and logo
        JLabel companyLabel = new JLabel("Good Buy");
        Font companyFont = new Font("Arial", Font.BOLD, 30);

        //1.5.1 Display the Company name and logo
        companyLabel.setForeground(Color.YELLOW);
        companyLabel.setFont(companyFont);
        companyLabel.setBounds(30,30,140,40);
        add(companyLabel);
        companyLogo.setBounds(180,30,60,40);
        add(companyLogo);

        //1.6 Set the title
        JLabel titleLabel = new JLabel("Welcome to Good Buy!");
        Font titleFont = new Font("Arial", Font.BOLD, 30);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.YELLOW);

        //1.6.1 Display the title
        titleLabel.setBounds(363,60,640,50);
        add(titleLabel);

        //1.7 Set the Help button
        Font helpFont = new Font("Arial", Font.BOLD, 18);
        help.setBackground(Color.YELLOW);

        //1.7.1 Display the Help button
        help.addActionListener(this);
        help.setFont(helpFont);
        help.setBounds(10,610,100,50);
        add(help);

        //1.9 Set the welcome Label
        // https://stackoverflow.com/questions/685521/multiline-text-in-jlabel
        JLabel welcomeLabel = new JLabel(
                "<html>Good Buy is a laptop Company. We sell some of the best laptops in the world. </html>");
        Font welcomeFont = new Font("Arial", Font.PLAIN, 30);

        //1.9.1 Display a white box
        welcomeLabel.setBackground(Color.WHITE);
        welcomeLabel.setOpaque(true);

        //1.9.2 Display the Welcome Label
        welcomeLabel.setBounds(150, 200, 1000, 100);
        welcomeLabel.setFont(welcomeFont);
        add(welcomeLabel);

        //1.10 Set the Inventory Frame Label
        JLabel inventoryLabel = new JLabel("<html>Inventory Frame:" + "<br> This frame shows<br>" + "what type of<br>"
                + " Laptops our <br> company sells.<html>");
        Font inventoryFont = new Font("Arial", Font.PLAIN, 18);

        //1.10.1 Display a white box
        inventoryLabel.setBackground(Color.WHITE);
        inventoryLabel.setOpaque(true);

        //1.10.2 Display the Inventory Frame Label
        inventoryLabel.setBounds(200, 325, 200, 150);
        inventoryLabel.setFont(inventoryFont);
        add(inventoryLabel);

        //1.11 Set the Survey Frame Label
        JLabel surveyLabel = new JLabel(
                "<html>Survey Frame:<br> This Frame asks<br> you questions see<br> which laptops are<br>the best for you."
                        + "<br>The Survey frame will lead<br> to the Results frame.<html>");
        Font surveyFont = new Font("Arial", Font.PLAIN, 18);

        //1.11.1 Display a white box
        surveyLabel.setBackground(Color.WHITE);
        surveyLabel.setOpaque(true);

        //1.11.2 Display the Survey Frame Label
        surveyLabel.setBounds(500, 325, 200, 200);
        surveyLabel.setFont(surveyFont);
        add(surveyLabel);

        //1.12 Set the Education Frame Label
        JLabel educationLabel = new JLabel("<html>Education Frame:<br> This frame teaches<br> you the different<br>"
                + " parts of a laptop.<html>");
        Font educationFont = new Font("Arial", Font.PLAIN, 18);

        //1.12.1 Display a white box
        educationLabel.setBackground(Color.WHITE);
        educationLabel.setOpaque(true);

        //1.12.2 Display the Education Frame Label
        educationLabel.setBounds(800, 325, 200, 150);
        educationLabel.setFont(educationFont);
        add(educationLabel);

        //1.13 Display the frame
        setVisible(true);

    }

    //2. Controls for buttons
    @Override
    public void actionPerformed(ActionEvent event) {

        // 2.2 If the user selects the help button
        if (event.getSource() == help) {

            //2.2.1 calls a method for the help message
            LaptopStoreEducationFrame.helpMessageBox();

        }

    }

    // 3. This method runs whenever the mouse is clicked
    @Override
    public void mouseClicked(MouseEvent event) {

        //For menuBar items:
        //NOTE this menuBar code is designed to be able to be copied into any frame in the LaptopStoreApplication

        // 3.1 when the titleMenu is clicked
        if (event.getSource() == titleMenu) {
            //&& !this.isVisible() makes sure that the current frame is not shown

            //https://stackoverflow.com/questions/4716372/java-how-do-i-close-a-jframe-while-opening-another-one#:~:text=Here%2C%20you%20would%20call%20setVisible,frame%20to%20make%20it%20visible

            //3.1.2 close the current frame
            this.setVisible(false);

            //3.1.3 open the title frame
            LaptopStoreApplication.openLaptopStoreTitleFrame();
        }

        //3.2 when the inventoryMenu is clicked
        if (event.getSource() == inventoryMenu) {

            //3.2.1 close the current frame
            this.setVisible(false);

            //3.2.2 open the inventory frame
            LaptopStoreApplication.openLaptopStoreInventoryFrame();
        }

        //3.3 when the surveyMenu is clicked
        if (event.getSource() == surveyMenu) {

            //3.3.1 close the current frame
            this.setVisible(false);

            //3.3.2 open the survey frame
            LaptopStoreApplication.openLaptopStoreSurveyFrame();
        }

        //3.4 when the resultsMenu is clicked
        if (event.getSource() == resultsMenu) {

            //check if the survey frame has been opened before the laptop frame
            if (LaptopStoreApplication.surveyChecker >= 1) {

                //close the current frame
                this.setVisible(false);

                //open the results frame
                LaptopStoreApplication.openLaptopStoreResultsFrame();
            }

            //display warning message
            else {

                JOptionPane.showMessageDialog(null, "Please complete the survey before accessing survey results");

            }
        }

        //3.5 when the educationMenu is clicked
        if (event.getSource() == educationMenu) {

            //3.5.1 close the current frame
            this.setVisible(false);

            //3.5.2 open the education frame
            LaptopStoreApplication.openLaptopStoreEducationFrame();
        }

    }

    //NOTE: the rest of the methods aren't used but are necessary for the program to run

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