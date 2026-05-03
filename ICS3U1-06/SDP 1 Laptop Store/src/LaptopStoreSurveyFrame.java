import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.*;

//This class makes a GUI frame to display and ask customers for what they are looking for in a computer
public class LaptopStoreSurveyFrame extends JFrame implements ActionListener, MouseListener {

    //global variables
    public static String type, cpuBrand, laptopBrand;
    public static int priceMin, priceMax, ram, ssd, coresMin, coreMax;
    public static double speedMin, speedMax;

    //GUI Elements or GUI SetUp

    //budget options
    JRadioButton lessThan500RadioButton = new JRadioButton("less than $500");
    JRadioButton lowerClassRadioButton = new JRadioButton("$500-$1000");
    JRadioButton middleClassRadioButton = new JRadioButton("$1000-$2000");
    JRadioButton richRadioButton = new JRadioButton("$2000+");

    //Laptop need options
    JRadioButton studentRadioButton = new JRadioButton("students");
    JRadioButton gamingRadioButton = new JRadioButton("gaming");
    JRadioButton professionalRadioButton = new JRadioButton("professional");

    //Laptop brand option
    JRadioButton AsusRadioButton = new JRadioButton("Asus");
    JRadioButton AppleRadioButton = new JRadioButton("Apple");
    JRadioButton DellRadioButton = new JRadioButton("Dell");
    JRadioButton HPRadioButton = new JRadioButton("HP");
    JRadioButton LenovoRadioButton = new JRadioButton("Lenovo");

    //CPU Brand option
    JRadioButton intelRadioButton = new JRadioButton("intel");
    JRadioButton AMDRadioButton = new JRadioButton("AMD");
    JRadioButton MediaTekRadioButton = new JRadioButton("MediaTek");
    JRadioButton AppleGPURadioButton = new JRadioButton("Apple");

    //CPU speed option
    JRadioButton lowSpeedRadioButton = new JRadioButton("1-2");
    JRadioButton mediumSpeedRadioButton = new JRadioButton("2-3");
    JRadioButton highSpeedRadioButton = new JRadioButton("3-4");
    JRadioButton hyperSpeedRadioButton = new JRadioButton("4+");

    //CPU Core option
    JRadioButton lowCoreRadioButton = new JRadioButton("1-3");
    JRadioButton mediumCoreRadioButton = new JRadioButton("3-7");
    JRadioButton highCoreRadioButton = new JRadioButton("8-10");
    JRadioButton hyperCoreRadioButton = new JRadioButton("10+");

    //RAM option
    JRadioButton fourGBOfRamRadioButton = new JRadioButton("4");
    JRadioButton eightGBOfRamRadioButton = new JRadioButton("8");
    JRadioButton sixteenGBOfRamRadioButton = new JRadioButton("16");
    JRadioButton thirtyTwoGBOfRamRadioButton = new JRadioButton("32");

    //SSD option
    JRadioButton superLowGBOfStorageRadioButton = new JRadioButton("64");
    JRadioButton lowGBOfStorageRadioButton = new JRadioButton("128");
    JRadioButton mediumGBOfStorageRadioButton = new JRadioButton("256");
    JRadioButton highGBStorageRadioButton = new JRadioButton("512");
    JRadioButton oneTStorageRadioButton = new JRadioButton("1000");
    JRadioButton twoTStorageRadioButton = new JRadioButton("2000");

    //questions that are going to be asked later on
    JTextArea question1 = new JTextArea("What is your budget?");
    JTextArea question2 = new JTextArea("What do you need \n this computer for?");
    JTextArea question3 = new JTextArea("Which Laptop Type \n are you looking for");
    JTextArea question4 = new JTextArea("What CPU Brand \n are you interested in? ");
    JTextArea question5 = new JTextArea("What CPU speed do \n you want?");
    JTextArea question6 = new JTextArea("what core do you \n want for your CPU?");
    JTextArea question7 = new JTextArea("How much RAM \n memory do you want?");
    JTextArea question8 = new JTextArea("How much SSD \n storage do you want");

    //making it so later we can group the first radio buttons together
    ButtonGroup radioButtonGroup1 = new ButtonGroup();
    ButtonGroup radioButtonGroup2 = new ButtonGroup();
    ButtonGroup radioButtonGroup3 = new ButtonGroup();
    ButtonGroup radioButtonGroup4 = new ButtonGroup();
    ButtonGroup radioButtonGroup5 = new ButtonGroup();
    ButtonGroup radioButtonGroup6 = new ButtonGroup();
    ButtonGroup radioButtonGroup7 = new ButtonGroup();
    ButtonGroup radioButtonGroup8 = new ButtonGroup();

    //Buttons
    JButton backButton = new JButton("Back");
    JButton helpButton = new JButton("Help");
    JButton enterResultButton = new JButton("Submit");

    //menus
    JMenuBar menuBar = new JMenuBar();
    JMenu titleMenu = new JMenu("Title");
    JMenu inventoryMenu = new JMenu("Inventory");
    JMenu surveyMenu = new JMenu("Survey");
    JMenu resultsMenu = new JMenu("Results");
    JMenu educationMenu = new JMenu("Education");

    //company brand
    JLabel titleLabel = new JLabel("Survey Frame");
    JLabel companyLabel = new JLabel("Good Buy");
    //logo from: "https://www.freepnglogos.com/images/best-buy-png-logo-3003.html
    ImageIcon originalCompanyLogo = new ImageIcon("images/companyLogo.png");
    //Scale the company logo
    ImageIcon scaledCompanyLogo = new ImageIcon(originalCompanyLogo.getImage().
            getScaledInstance(60,40, Image.SCALE_SMOOTH));
    JLabel companyLogo = new JLabel(scaledCompanyLogo);


    //the panels for the questions
    JPanel radioButtonPanel1 = new JPanel();
    JPanel radioButtonPanel2 = new JPanel();
    JPanel radioButtonPanel3 = new JPanel();
    JPanel radioButtonPanel4 = new JPanel();
    JPanel radioButtonPanel5 = new JPanel();
    JPanel radioButtonPanel6 = new JPanel();
    JPanel radioButtonPanel7 = new JPanel();
    JPanel radioButtonPanel8 = new JPanel();


    //The different font choices
    Font titleFont = new Font("Arial", Font.BOLD, 30);
    Font buttonButtonFont = new Font("Arial", Font.BOLD, 18);
    Font headingFont = new Font("Arial", Font.BOLD, 15);
    Font buttonFont = new Font("Arial", Font.BOLD, 12);
    Font menuFont = new Font("Arial", Font.BOLD, 15);

    public LaptopStoreSurveyFrame() {

        //set up the frame
        setSize(1366, 780); //Set up the frame to be 1366x768
        setTitle("Laptop Store Survey Frame"); //Add the title name
        setLayout(null); //we want to manually place elements on the frame
        //set the background to blue
        getContentPane().setBackground(Color.decode("#3d85c6"));

        //placing objects into the frame
        titleLabel.setBounds(300, 25, 400, 50);
        titleLabel.setFont(titleFont);
        add(titleLabel);

        //Add a Menu Item for each screen (5 choices)
        menuBar.add(titleMenu);
        menuBar.add(inventoryMenu);
        menuBar.add(surveyMenu);
        menuBar.add(resultsMenu);
        menuBar.add(educationMenu);
        setJMenuBar(menuBar);

        //add menu fonts
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

        //Add the company name (JLabel)
        companyLabel.setBounds(30, 30, 140, 40);
        companyLabel.setFont(titleFont); //change font
        //https://stackoverflow.com/questions/2966334/how-do-i-set-the-colour-of-a-label-coloured-text-in-java
        companyLabel.setForeground(Color.yellow); //change color
        add(companyLabel);

        //Add a label to hold the company logo image (JLabel)
        companyLogo.setBounds(180, 30, 60, 40);
        add(companyLogo);

        //Add the screen title to top center of the background (JLabel)
        //x is from 1366/2 - (640/2)
        titleLabel.setBounds(363, 60, 640, 50);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.yellow);
        add(titleLabel);

        //Add the Back button (JButton)
        backButton.setBounds(1256, 10, 100, 50);
        backButton.setFont(buttonButtonFont);
        //https://stackoverflow.com/questions/1065691/how-to-set-the-background-color-of-a-jbutton-on-the-mac-os
        backButton.setBackground(Color.yellow);
        add(backButton);
        backButton.addActionListener(this);

        //Add the Help button (JButton)
        helpButton.setBounds(10, 610, 100, 50);
        helpButton.setFont(buttonButtonFont);
        helpButton.setBackground(Color.yellow);
        add(helpButton);
        helpButton.addActionListener(this);

        //1st question
        question1.setBounds(200, 200, 150, 25);
        question1.setFont(headingFont);
        add(question1);

        //option 1
        lessThan500RadioButton.setBounds(200, 250, 150, 25);
        lessThan500RadioButton.setFont(buttonFont);
        add(lessThan500RadioButton);

        //options 2
        lowerClassRadioButton.setBounds(200, 275, 100, 25);
        lowerClassRadioButton.setFont(buttonFont);
        add(lowerClassRadioButton);

        //option 3
        middleClassRadioButton.setBounds(200, 300, 100, 25);
        middleClassRadioButton.setFont(buttonFont);
        add(middleClassRadioButton);

        //option 4
        richRadioButton.setBounds(200, 325, 100, 25);
        richRadioButton.setFont(buttonFont);
        add(richRadioButton);
        richRadioButton.addActionListener(this);

        //grouping the first group of questions
        radioButtonGroup1.add(lessThan500RadioButton);
        radioButtonGroup1.add(lowerClassRadioButton);
        radioButtonGroup1.add(middleClassRadioButton);
        radioButtonGroup1.add(richRadioButton);

        //the first question background
        radioButtonPanel1.setBackground(Color.white);
        radioButtonPanel1.setBounds(185, 175, 175, 200);
        add(radioButtonPanel1);

        //2nd question
        question2.setBounds(425, 200, 150, 35);
        question2.setFont(headingFont);
        add(question2);

        //option 1
        studentRadioButton.setBounds(425, 250, 100, 25);
        studentRadioButton.setFont(buttonFont);
        add(studentRadioButton);
        studentRadioButton.addActionListener(this);

        //option 2
        gamingRadioButton.setBounds(425, 275, 100, 25);
        gamingRadioButton.setFont(buttonFont);
        add(gamingRadioButton);
        gamingRadioButton.addActionListener(this);

        //option 3
        professionalRadioButton.setBounds(425, 300, 100, 25);
        professionalRadioButton.setFont(buttonFont);
        add(professionalRadioButton);
        professionalRadioButton.addActionListener(this);

        //Grouping the second questions together
        radioButtonGroup2.add(studentRadioButton);
        radioButtonGroup2.add(gamingRadioButton);
        radioButtonGroup2.add(professionalRadioButton);

        //the second question background
        radioButtonPanel2.setBackground(Color.white);
        radioButtonPanel2.setBounds(410, 175, 175, 200);
        add(radioButtonPanel2);

        //3 question
        question3.setBounds(625, 200, 150, 35);
        question3.setFont(headingFont);
        add(question3);

        //option 1
        AsusRadioButton.setBounds(625, 250, 100, 25);
        AsusRadioButton.setFont(buttonFont);
        add(AsusRadioButton);

        //option 2
        AppleRadioButton.setBounds(625, 275, 100, 25);
        AppleRadioButton.setFont(buttonFont);
        add(AppleRadioButton);

        //option 3
        DellRadioButton.setBounds(625, 300, 100, 25);
        DellRadioButton.setFont(buttonFont);
        add(DellRadioButton);

        //option 4
        HPRadioButton.setBounds(625, 325, 100, 25);
        HPRadioButton.setFont(buttonFont);
        add(HPRadioButton);

        //option 5
        LenovoRadioButton.setBounds(625, 350, 100, 25);
        LenovoRadioButton.setFont(buttonFont);
        add(LenovoRadioButton);

        //grouping the third question together
        radioButtonGroup3.add(AsusRadioButton);
        radioButtonGroup3.add(AppleRadioButton);
        radioButtonGroup3.add(DellRadioButton);
        radioButtonGroup3.add(HPRadioButton);
        radioButtonGroup3.add(LenovoRadioButton);

        //the third question background
        radioButtonPanel3.setBackground(Color.white);
        radioButtonPanel3.setBounds(615, 175, 175, 200);
        add(radioButtonPanel3);

        //4th question
        question4.setBounds(850, 200, 150, 35);
        question4.setFont(headingFont);
        add(question4);

        //option 1
        intelRadioButton.setBounds(850, 250, 100, 25);
        intelRadioButton.setFont(buttonFont);
        add(intelRadioButton);

        //option 2
        AMDRadioButton.setBounds(850, 275, 100, 25);
        AMDRadioButton.setFont(buttonFont);
        add(AMDRadioButton);

        //option 3
        MediaTekRadioButton.setBounds(850, 300, 100, 25);
        MediaTekRadioButton.setFont(buttonFont);
        add(MediaTekRadioButton);

        //option 4
        AppleGPURadioButton.setBounds(850, 325, 100, 25);
        AppleGPURadioButton.setFont(buttonFont);
        add(AppleGPURadioButton);

        //grouping for the fourth group
        radioButtonGroup4.add(intelRadioButton);
        radioButtonGroup4.add(AMDRadioButton);
        radioButtonGroup4.add(MediaTekRadioButton);
        radioButtonGroup4.add(AppleGPURadioButton);

        //the fourth question background
        radioButtonPanel4.setBackground(Color.white);
        radioButtonPanel4.setBounds(835, 175, 175, 200);
        add(radioButtonPanel4);

        //question 5
        question5.setBounds(200, 450, 150, 35);
        question5.setFont(headingFont);
        add(question5);

        //option 1
        lowSpeedRadioButton.setBounds(200, 500, 150, 25);
        lowSpeedRadioButton.setFont(buttonFont);
        add(lowSpeedRadioButton);

        //option 2
        mediumSpeedRadioButton.setBounds(200, 525, 150, 25);
        mediumSpeedRadioButton.setFont(buttonFont);
        add(mediumSpeedRadioButton);

        //option 3
        highSpeedRadioButton.setBounds(200, 550, 150, 25);
        highSpeedRadioButton.setFont(buttonFont);
        add(highSpeedRadioButton);

        //option 4
        hyperSpeedRadioButton.setBounds(200, 575, 150, 25);
        hyperSpeedRadioButton.setFont(buttonFont);
        add(hyperSpeedRadioButton);

        //grouping the fifth questions together
        radioButtonGroup5.add(lowSpeedRadioButton);
        radioButtonGroup5.add(mediumSpeedRadioButton);
        radioButtonGroup5.add(highSpeedRadioButton);
        radioButtonGroup5.add(hyperSpeedRadioButton);

        //the five question background
        radioButtonPanel5.setBackground(Color.white);
        radioButtonPanel5.setBounds(185, 425, 175, 200);
        add(radioButtonPanel5);

        //question 6
        question6.setBounds(425, 450, 150, 35);
        question6.setFont(headingFont);
        add(question6);

        //option 1
        lowCoreRadioButton.setBounds(425, 500, 100, 25);
        lowCoreRadioButton.setFont(buttonFont);
        add(lowCoreRadioButton);

        //option 2
        mediumCoreRadioButton.setBounds(425, 525, 100, 25);
        mediumCoreRadioButton.setFont(buttonFont);
        add(mediumCoreRadioButton);

        //option 3
        highCoreRadioButton.setBounds(425, 550, 100, 25);
        highCoreRadioButton.setFont(buttonFont);
        add(highCoreRadioButton);

        //option 4
        hyperCoreRadioButton.setBounds(425, 575, 100, 25);
        hyperCoreRadioButton.setFont(buttonFont);
        add(hyperCoreRadioButton);

        //grouping the sixth questions together
        radioButtonGroup6.add(lowCoreRadioButton);
        radioButtonGroup6.add(mediumCoreRadioButton);
        radioButtonGroup6.add(highCoreRadioButton);
        radioButtonGroup6.add(hyperCoreRadioButton);

        //the sixth question background
        radioButtonPanel6.setBackground(Color.white);
        radioButtonPanel6.setBounds(410, 425, 175, 200);
        add(radioButtonPanel6);


        //question 7
        question7.setBounds(625, 450, 150, 35);
        question7.setFont(headingFont);
        add(question7);

        //option 1
        fourGBOfRamRadioButton.setBounds(625, 500, 100, 25);
        fourGBOfRamRadioButton.setFont(buttonFont);
        add(fourGBOfRamRadioButton);

        //option 2
        eightGBOfRamRadioButton.setBounds(625, 525, 100, 25);
        eightGBOfRamRadioButton.setFont(buttonFont);
        add(eightGBOfRamRadioButton);

        //option 3
        sixteenGBOfRamRadioButton.setBounds(625, 550, 100, 25);
        sixteenGBOfRamRadioButton.setFont(buttonFont);
        add(sixteenGBOfRamRadioButton);

        //option 4
        thirtyTwoGBOfRamRadioButton.setBounds(625, 575, 100, 25);
        thirtyTwoGBOfRamRadioButton.setFont(buttonFont);
        add(thirtyTwoGBOfRamRadioButton);

        //grouping the seventh questions together
        radioButtonGroup7.add(fourGBOfRamRadioButton);
        radioButtonGroup7.add(eightGBOfRamRadioButton);
        radioButtonGroup7.add(sixteenGBOfRamRadioButton);
        radioButtonGroup7.add(thirtyTwoGBOfRamRadioButton);

        //seventh question background
        radioButtonPanel7.setBackground(Color.white);
        radioButtonPanel7.setBounds(610, 425, 175, 200);
        add(radioButtonPanel7);

        //question 8
        question8.setBounds(850, 450, 150, 35);
        question8.setFont(headingFont);
        add(question8);

        //option 1
        superLowGBOfStorageRadioButton.setBounds(850, 500, 100, 25);
        superLowGBOfStorageRadioButton.setFont(buttonFont);
        add(superLowGBOfStorageRadioButton);

        //option 2
        lowGBOfStorageRadioButton.setBounds(850, 525, 100, 25);
        lowGBOfStorageRadioButton.setFont(buttonFont);
        add(lowGBOfStorageRadioButton);

        //option 3
        mediumGBOfStorageRadioButton.setBounds(850, 550, 100, 25);
        mediumGBOfStorageRadioButton.setFont(buttonFont);
        add(mediumGBOfStorageRadioButton);

        //option 4
        highGBStorageRadioButton.setBounds(850, 575, 100, 25);
        highGBStorageRadioButton.setFont(buttonFont);
        add(highGBStorageRadioButton);

        //option 5
        oneTStorageRadioButton.setBounds(850, 600, 100, 25);
        oneTStorageRadioButton.setFont(buttonFont);
        add(oneTStorageRadioButton);

        //option 6
        twoTStorageRadioButton.setBounds(850, 625, 100, 25);
        twoTStorageRadioButton.setFont(buttonFont);
        add(twoTStorageRadioButton);

        //grouping the 8th questions options together
        radioButtonGroup8.add(superLowGBOfStorageRadioButton);
        radioButtonGroup8.add(lowGBOfStorageRadioButton);
        radioButtonGroup8.add(mediumGBOfStorageRadioButton);
        radioButtonGroup8.add(highGBStorageRadioButton);
        radioButtonGroup8.add(oneTStorageRadioButton);
        radioButtonGroup8.add(twoTStorageRadioButton);

        //the background for the eighth question
        radioButtonPanel8.setBackground(Color.white);
        radioButtonPanel8.setBounds(835, 425, 175, 225);
        add(radioButtonPanel8);

        //entering the results
        enterResultButton.setBounds(1256, 610, 100, 50);
        enterResultButton.setFont(buttonButtonFont);
        enterResultButton.setBackground(Color.yellow);
        add(enterResultButton);
        enterResultButton.addActionListener(this);

        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        //when the back button is clicked
        if (e.getSource() == backButton) {

            //used source to find out how close a JFrame while opening another one
            //https://stackoverflow.com/questions/4716372/java-how-do-i-close-a-jframe-while-opening-another-one#:~:text=Here%2C%20you%20would%20call%20setVisible,frame%20to%20make%20it%20visible.

            //close the current frame
            this.setVisible(false);

            //open the title frame
            LaptopStoreApplication.openLaptopStoreTitleFrame();
        }

        //when the help button is clicked
        if (e.getSource() == helpButton) {
            //call the method for the help message
            LaptopStoreEducationFrame.helpMessageBox();
        }

        //question 1 answers
        if (lessThan500RadioButton.isSelected()){
            priceMin = 0;
            priceMax = 500;
        } else if (lowerClassRadioButton.isSelected()){
            priceMin = 500;
            priceMax = 1000;
        } else if (middleClassRadioButton.isSelected()){
            priceMin = 1000;
            priceMax = 2000;
        } else if (richRadioButton.isSelected()) {
            priceMin = 2000;
            priceMax = 5000;
        }

        if (studentRadioButton.isSelected()){
            type = "Students";
        } else if (gamingRadioButton.isSelected()){
            type = "Gaming";
        } else if (professionalRadioButton.isSelected()){
            type = "Professional";
        }

        if (AsusRadioButton.isSelected()){
            laptopBrand = "Asus";
        } else if (AppleRadioButton.isSelected()){
            laptopBrand = "Apple";
        } else if (DellRadioButton.isSelected()){
            laptopBrand = "Dell";
        } else if (HPRadioButton.isSelected()){
            laptopBrand = "HP";
        } else if (LenovoRadioButton.isSelected()){
            laptopBrand = "Lenovo";
        }

        if (intelRadioButton.isSelected()){
            cpuBrand = "Intel";
        } else if (AMDRadioButton.isSelected()){
            cpuBrand = "AMD";
        } else if (MediaTekRadioButton.isSelected()){
            cpuBrand = "MediaTek";
        } else if (AppleGPURadioButton.isSelected()){
            cpuBrand = "Apple";
        }

        if (lowSpeedRadioButton.isSelected()){
            speedMax = 1;
            speedMin = 2;

        } else if (mediumSpeedRadioButton.isSelected()){
            speedMax = 2;
            speedMin = 3;

        } else if (highSpeedRadioButton.isSelected()){
            speedMax = 3;
            speedMin = 4;

        } else if (hyperSpeedRadioButton.isSelected()){
            speedMax = 4;
            speedMin = 5;

        }

        if (lowCoreRadioButton.isSelected()){
            coresMin = 1;
            coreMax = 3;
        } else if (mediumCoreRadioButton.isSelected()){
            coresMin = 3;
            coreMax = 7;
        } else if (highCoreRadioButton.isSelected()){
            coresMin = 7;
            coreMax = 10;
        } else if (hyperCoreRadioButton.isSelected()){
            coresMin = 10;
            coreMax = 24;
        }

        if (fourGBOfRamRadioButton.isSelected()){
            ram = 4;
        } else if (eightGBOfRamRadioButton.isSelected()){
            ram = 8;
        } else if (sixteenGBOfRamRadioButton.isSelected()){
            ram = 16;
        } else if (thirtyTwoGBOfRamRadioButton.isSelected()){
            ram = 32;
        }

        if (superLowGBOfStorageRadioButton.isSelected()){
            ssd = 64;
        } else if (lowGBOfStorageRadioButton.isSelected()){
            ssd = 128;
        } else if (mediumGBOfStorageRadioButton.isSelected()){
            ssd = 256;
        } else if (highGBStorageRadioButton.isSelected()){
            ssd = 512;
        } else if (oneTStorageRadioButton.isSelected()){
            ssd = 1000;
        } else if (twoTStorageRadioButton.isSelected()){
            ssd = 2000;
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

}
