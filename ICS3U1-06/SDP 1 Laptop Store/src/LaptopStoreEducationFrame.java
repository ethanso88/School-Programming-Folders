//Name: Bryan Huang

//Date: May 14, 2024
//Course: ICS3U1-6
//Description: it is the education frame and introduces the user to terms while buying a laptop
//Title: SDP #1 - Laptop Store
//Major Skills: JLabel, JFont and actionListener

//imports
import java.awt.Color;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

//This class runs the education frame
public class LaptopStoreEducationFrame extends JFrame implements ActionListener, MouseListener {

    // GUI elements

    //This resized all my images except for the company logo which I will have to do here:
    ImageIcon originalCompanyLogo = new ImageIcon("images/companyLogo.png");
    //Scale the company logo
    ImageIcon scaledCompanyLogo = new ImageIcon(originalCompanyLogo.getImage().
            getScaledInstance(60,40, Image.SCALE_SMOOTH));


    private JButton backButton = new JButton("Back");
    private JButton helpButton = new JButton("Help");
    JMenuBar menuBar = new JMenuBar();
    JMenu titleMenu = new JMenu("Title");
    JMenu inventoryMenu = new JMenu("Inventory");
    JMenu surveyMenu = new JMenu("Survey");
    JMenu resultsMenu = new JMenu("Results");
    JMenu educationMenu = new JMenu("Education");
    JLabel companyLogo = new JLabel(scaledCompanyLogo);


    // 1. GUI EducationWindow Setup
    public LaptopStoreEducationFrame() {
        // 1.1 Set the frame to be 1366 by 768
        setSize(1366, 768);
        setLayout(null);
        // 1.2 Set the background color
        getContentPane().setBackground(Color.decode("#3d85c6"));
        // 1.2.1 Display the background color
        // 1.3 Set the frame title
        setTitle("Good Application - Good Buy");
        // 1.3.1 Display the frame title

        //Add the Menu Bar
        //Add a Menu Item for each screen (5 choices)
        menuBar.add(titleMenu);
        menuBar.add(inventoryMenu);
        menuBar.add(surveyMenu);
        menuBar.add(resultsMenu);
        menuBar.add(educationMenu);
        setJMenuBar(menuBar);
        //add menu fonts
        Font menuFont = new Font("Arial", Font.BOLD, 15);
        titleMenu.setFont(menuFont);
        inventoryMenu.setFont(menuFont);
        surveyMenu.setFont(menuFont);
        resultsMenu.setFont(menuFont);
        educationMenu.setFont(menuFont);
        //add action listener to menuBar items
        titleMenu.addMouseListener(this);
        inventoryMenu.addMouseListener(this);
        surveyMenu.addMouseListener(this);
        resultsMenu.addMouseListener(this);
        educationMenu.addMouseListener(this);

        // 1.5 Set the company name and logo
        JLabel companyLabel = new JLabel("Good Buy");
        Font companyFont = new Font("Arial", Font.BOLD, 30);

        // 1.5.1 Display the Company name and logo
        companyLabel.setForeground(Color.YELLOW);
        companyLabel.setFont(companyFont);
        companyLabel.setBounds(30,30,140,40);
        add(companyLabel);
        companyLogo.setBounds(180,30,60,40);
        add(companyLogo);

        // 1.6 Set the title
        JLabel titleLabel = new JLabel("Education");
        Font titleFont = new Font("Arial", Font.BOLD, 30);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.YELLOW);

        // 1.6.1 isplay the title
        titleLabel.setBounds(363,60,640,50);
        add(titleLabel);

        // 1.7 Set the Help button
        Font helpFont = new Font("Arial", Font.BOLD, 18);
        helpButton.setBackground(Color.YELLOW);

        // 1.7.1 Display the Help button
        helpButton.addActionListener(this);
        helpButton.setFont(helpFont);
        helpButton.setBounds(10,610,100,50);
        add(helpButton);

        // 1.8 Set the back button
        Font backFont = new Font("Arial", Font.BOLD, 18);
        backButton.setBackground(Color.YELLOW);

        // 1.8.1 Display the back button
        backButton.addActionListener(this);
        backButton.setFont(backFont);
        backButton.setBounds(1256,10,100,50);
        add(backButton);

        // 1.9 Set the CPU Label
        JLabel cpuLabel = new JLabel(
                "<html>CPU - stands for<br> Central<br> Processing Unit<br>  - Intel<br> - AMD<html>");
        Font cpuFont = new Font("Arial", Font.PLAIN, 30);

        // 1.9.1 Display a white box
        cpuLabel.setBackground(Color.WHITE);
        cpuLabel.setOpaque(true);

        // 1.9.2 Display the CPU Label
        cpuLabel.setBounds(25, 200, 300, 200);
        cpuLabel.setFont(cpuFont);
        add(cpuLabel);

        // 1.10 Set the Operating System Label
        JLabel operatingSystemLabel = new JLabel("<html>Operating System: <br> a system that runs <br> the laptop "
                + "<br>- Windows 11" + "<br>- Chrome OS" + "<br>macOS <html>");
        Font operatingSystemFont = new Font("Arial", Font.PLAIN, 30);

        // 1.10.1 Display a white box
        operatingSystemLabel.setBackground(Color.WHITE);
        operatingSystemLabel.setOpaque(true);

        // 1.10.2 Display the Operating System Label
        operatingSystemLabel.setBounds(375, 200, 300, 240);
        operatingSystemLabel.setFont(operatingSystemFont);
        add(operatingSystemLabel);

        // 1.11 Set the GPU Label
        JLabel gpuLabel = new JLabel("<html>GPU - stands for<br> Graphics <br> Processing Unit "
                + "- <br>Integrated same as CPU" + "<br>- Intel" + "<br>- NVIDIA GeForce<html>");
        Font gpuFont = new Font("Arial", Font.PLAIN, 30);

        // 1.11.1 Display a white box
        gpuLabel.setBackground(Color.WHITE);
        gpuLabel.setOpaque(true);

        // 1.11.2 Display the GPU Label
        gpuLabel.setBounds(725, 200, 300, 275);
        gpuLabel.setFont(gpuFont);
        add(gpuLabel);

        // 1.12 Set the RAM Label
        JLabel ramLabel = new JLabel(
                "<html>RAM: how<br> much storage a<br> laptop has<br> ( measured in<br> GB)<html>");
        Font ramFont = new Font("Arial", Font.PLAIN, 30);

        // 1.12.1 Display a white box
        ramLabel.setBackground(Color.WHITE);
        ramLabel.setOpaque(true);

        // 1.12.2 Display the RAM Label
        ramLabel.setBounds(1075, 200, 200, 275);
        ramLabel.setFont(ramFont);
        add(ramLabel);

        //1.13 Display the frame
        setVisible(true);

    }

    // 2. Controls for the buttons
    @Override
    public void actionPerformed(ActionEvent e) {

        //int assistance = JOptionPane.showConfirmDialog(null, inputs, "Welcome to the Help box", JOptionPane.DEFAULT_OPTION);
        //JTextField assistanceLabel = new JTextField("This program educates you different parts of a computer");


        // 2.1 If the user selects the Help button
        if(e.getSource() == helpButton){

            //calls the method for the help message
            LaptopStoreEducationFrame.helpMessageBox();

        }

        // 2.2 If the user selects the Back button
        if(e.getSource() == backButton){

            //close the current frame
            this.setVisible(false);

            //open the title frame
            LaptopStoreApplication.openLaptopStoreTitleFrame();
        }

    }

    //this method runs whenever the mouse is clicked
    @Override
    public void mouseClicked(MouseEvent event) {

        //For menuBar items:
        //NOTE this menuBar code is designed to be able to be copied into any frame in the LaptopStoreApplication

        //when the titleMenu is clicked
        if (event.getSource() == titleMenu) {

            //https://stackoverflow.com/questions/4716372/java-how-do-i-close-a-jframe-while-opening-another-one#:~:text=Here%2C%20you%20would%20call%20setVisible,frame%20to%20make%20it%20visible

            //close the current frame
            this.setVisible(false);

            //open the title frame
            LaptopStoreApplication.openLaptopStoreTitleFrame();
        }

        //when the inventoryMenu is clicked
        if (event.getSource() == inventoryMenu) {

            //close the current frame
            this.setVisible(false);

            //open the inventory frame
            LaptopStoreApplication.openLaptopStoreInventoryFrame();
        }

        //when the surveyMenu is clicked
        if (event.getSource() == surveyMenu) {

            //close the current frame
            this.setVisible(false);

            //open the survey frame
            LaptopStoreApplication.openLaptopStoreSurveyFrame();
        }

        //when the resultsMenu is clicked
        if (event.getSource() == resultsMenu) {

            //close the current frame
            this.setVisible(false);

            //open the results frame
            LaptopStoreApplication.openLaptopStoreResultsFrame();
        }

        //when the educationMenu is clicked
        if (event.getSource() == educationMenu) {

            //close the current frame
            this.setVisible(false);

            //open the education frame
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

    //this method displays the dialog box
    static void helpMessageBox() {

        //4.1 shows the dialog box
        JOptionPane.showMessageDialog(null, "Welcome to the Help Box"
                + "\n-There is a menu bar above and click the different options to see different screens"
                + "\n-You can click 'back' to go back to the start where there are definitions to explain the different frames that can be accessed by the menu bar"
                + "\nYou can go to the survey, education and inventory Frames: "
                + "\n-The Education frame teaches you important terminology to know when buying a computer"
                + "\n-The Inventory Frame shows different brands, costs and types of computers you can buy"
                + "\n-The Survey Frame asks you questions to see which computer is the best for you to buy"
                + "\nNOTE: If there are errors with the Results Frame it is because you didn't go to the Survey frame to complete the survey first"
                + "\nHope that helps :) - Bryan and Ethan");
    }

}