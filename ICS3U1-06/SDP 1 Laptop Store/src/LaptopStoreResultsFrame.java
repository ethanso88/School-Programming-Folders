/*
Name: Ethan So
Date: May 14, 2024
Course: ICS3U1-6 Mr. Fernandes
Description: This is the survey results frame, and it displays the results of the recommended laptops from the data filled out in the survey frame
             It shows the correct image, data and link for the top 3 recommended laptops
Major Skills: Swing GUI components, Color, Font, MenuBar, ActionListener, MouseListener
*/


//imports used for colours and fonts
import java.awt.*;

//imports used for actions
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//imports used to open a link
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//imports used to sort the array
import java.util.Arrays;
import java.util.Comparator;

//imports used for GUI elements
import javax.swing.*;

//This class makes a GUI frame to display and calculate the survey results for the user
public class LaptopStoreResultsFrame extends JFrame implements ActionListener, MouseListener {

    //I added a field to hold all resized Laptop images for Results Frame in the laptop array
        //This resized all my images except for the company logo which I will have to do here:
    ImageIcon originalCompanyLogo = new ImageIcon("images/companyLogo.png");
    //Scale the company logo
    ImageIcon scaledCompanyLogo = new ImageIcon(originalCompanyLogo.getImage().
            getScaledInstance(60,40, Image.SCALE_SMOOTH));


    //GUI elements:

    //menus
    JMenuBar menuBar = new JMenuBar();
    JMenu titleMenu = new JMenu("Title");
    JMenu inventoryMenu = new JMenu("Inventory");
    JMenu surveyMenu = new JMenu("Survey");
    JMenu resultsMenu = new JMenu("Results");
    JMenu educationMenu = new JMenu("Education");

    //labels
    JLabel companyLabel = new JLabel("Good Buy");
    JLabel companyLogo = new JLabel(scaledCompanyLogo);
    //logo from: "https://www.freepnglogos.com/images/best-buy-png-logo-3003.html
    JLabel titleLabel = new JLabel("Your Top 3 choices based on survey results:");

    //labels for laptop choices
    JLabel laptopTitle1 = new JLabel("Best Match:");
    JLabel laptopTitle2 = new JLabel("Second Best:");
    JLabel laptopTitle3 = new JLabel("Third Best:");
        //The rest of the laptop labels need to be updated after the sorting so they are left empty
    JLabel laptopImage1 = new JLabel();
    JLabel laptopImage2 = new JLabel();
    JLabel laptopImage3 = new JLabel();
    JLabel laptopName1 = new JLabel();
    JLabel laptopName2 = new JLabel();
    JLabel laptopName3 = new JLabel();
    JLabel laptopDescription1 = new JLabel();
    JLabel laptopDescription2 = new JLabel();
    JLabel laptopDescription3 = new JLabel();

    //panels
    JPanel laptopPanel1 = new JPanel();
    JPanel laptopPanel2 = new JPanel();
    JPanel laptopPanel3 = new JPanel();

    //buttons
    JButton backButton = new JButton("Back");
    JButton helpButton = new JButton("Help");
    JButton toWebsiteButton1 = new JButton("To Website");
    JButton toWebsiteButton2 = new JButton("To Website");
    JButton toWebsiteButton3 = new JButton("To Website");


    //constructor method
    public LaptopStoreResultsFrame() {

        //sort through data to get top 3 results based on survey questions
        top3();
            //Laptop Array index 39 will have the highest score meaning its the best match
            //Laptop Array index 38 will have the second highest score meaning its the second best match
            //Laptop Array index 37 will have the third highest score meaning its the third best match

        //setup frame
        setSize(1366,768);     //Set up the frame to be 1366x768
        setLayout(null);    //we want to manually place elements on the frame
        //https://stackoverflow.com/questions/27176436/how-to-add-hex-font-col
        getContentPane().setBackground(Color.decode("#3d85c6")); //Set up frame background to be darker blue
        setTitle("Good Buy Application - Results Frame"); //Add the Frame Title

        //make fonts
        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font laptopTitleFont = new Font("Arial", Font.BOLD, 20);
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        Font menuFont = new Font("Arial", Font.BOLD, 15);

        //Add the Menu Bar
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
        companyLabel.setBounds(30,30,140,40);
        companyLabel.setFont(titleFont); //change font
            //https://stackoverflow.com/questions/2966334/how-do-i-set-the-colour-of-a-label-coloured-text-in-java
        companyLabel.setForeground(Color.yellow);   //change colour
        add(companyLabel);
        //Add a label to hold the company logo image (JLabel)
        companyLogo.setBounds(180,30,60,40);
        add(companyLogo);

        //Add the screen title to top center of the background (JLabel)
            //x is from 1366/2 - (640/2)
        titleLabel.setBounds(363,60,640,50);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.yellow);
        add(titleLabel);

        //Add laptop titles (JLabel)
        //Add best match title (JLabel)
        laptopTitle1.setBounds(15,10,200,30);
        laptopTitle1.setFont(laptopTitleFont);
        laptopPanel1.add(laptopTitle1);
        //Add second best match title (JLabel)
        laptopTitle2.setBounds(15,10,200,30);
        laptopTitle2.setFont(laptopTitleFont);
        laptopPanel2.add(laptopTitle2);
        //Add third best match title (JLabel)
        laptopTitle3.setBounds(15,10,200,30);
        laptopTitle3.setFont(laptopTitleFont);
        laptopPanel3.add(laptopTitle3);
        
        //Add labels to hold the laptop images for choices (JLabel)
        //Add best match image (JLabel)
            //x is from (400-20)/2 - 200/2 = 90
        laptopImage1.setBounds(90,50,200,200);
        laptopImage1.setIcon(LaptopStoreApplication.laptopArray[39].getResizedLaptopImageForResultsFrame());
        laptopPanel1.add(laptopImage1);
        //Add second best match image (JLabel)
        laptopImage2.setBounds(90,50,200,200);
        laptopImage2.setIcon(LaptopStoreApplication.laptopArray[38].getResizedLaptopImageForResultsFrame());
        laptopPanel2.add(laptopImage2);
        //Add third best match image (JLabel)
        laptopImage3.setBounds(90,50,200,200);
        laptopImage3.setIcon(LaptopStoreApplication.laptopArray[37].getResizedLaptopImageForResultsFrame());
        laptopPanel3.add(laptopImage3);

        //Add laptop names (JLabel)
        //Add best match title (JLabel)
        laptopName1.setBounds(70,260,380,30);
        laptopName1.setText(LaptopStoreApplication.laptopArray[39].getBrand()+" "+LaptopStoreApplication.laptopArray[39].getModel());
        laptopName1.setForeground(Color.BLUE);
        laptopPanel1.add(laptopName1);
        //Add second best match title (JLabel)
        laptopName2.setBounds(70,260,380,30);
        laptopName2.setText(LaptopStoreApplication.laptopArray[38].getBrand()+" "+LaptopStoreApplication.laptopArray[38].getModel());
        laptopName2.setForeground(Color.BLUE);
        laptopPanel2.add(laptopName2);
        //Add third best match title (JLabel)
        laptopName3.setBounds(70,260,380,30);
        laptopName3.setText(LaptopStoreApplication.laptopArray[37].getBrand()+" "+LaptopStoreApplication.laptopArray[37].getModel());
        laptopName3.setForeground(Color.BLUE);
        laptopPanel3.add(laptopName3);

        //Add laptop descriptions for choices (JLabel)
        //Add best match description (JLabel)
        laptopDescription1.setBounds(75,240,380,200);
        laptopDescription1.setText(" - Price: $"+LaptopStoreApplication.laptopArray[39].getPrice()+"\n"+
                " - Type: "+LaptopStoreApplication.laptopArray[39].getType()+"\n"+
                " - CPU: "+LaptopStoreApplication.laptopArray[39].getCpuBrand()+" "+LaptopStoreApplication.laptopArray[39].getCpuType()+" "+LaptopStoreApplication.laptopArray[39].getCpuModel()+"\n"+
                " - RAM: "+LaptopStoreApplication.laptopArray[39].getRam()+"\n - SSD: "+LaptopStoreApplication.laptopArray[39].getSsd()+"\n"+
                " - GPU: "+LaptopStoreApplication.laptopArray[39].getGpuBrand()+" "+LaptopStoreApplication.laptopArray[39].getGpuModel());
        //JLabels can't actually use \n but they can display HTML
            //using https://stackoverflow.com/questions/1090098/newline-in-jlabel#:~:text=JLabel%20is%20actually%20capable%20of,you%20would%20get%20your%20newlines.
            //we can add an escape character:
        laptopDescription1.setText("<html>" + laptopDescription1.getText().replaceAll("\n", "<br/>") + "</html>");
        laptopPanel1.add(laptopDescription1);
        //Add second best match description (JLabel)
        laptopDescription2.setBounds(75,240,380,200);
        laptopDescription2.setText(" - Price: $"+LaptopStoreApplication.laptopArray[38].getPrice()+"\n"+
                " - Type: "+LaptopStoreApplication.laptopArray[38].getType()+"\n"+
                " - CPU: "+LaptopStoreApplication.laptopArray[38].getCpuBrand()+" "+LaptopStoreApplication.laptopArray[38].getCpuType()+" "+LaptopStoreApplication.laptopArray[38].getCpuModel()+"\n"+
                " - RAM: "+LaptopStoreApplication.laptopArray[38].getRam()+"\n - SSD: "+LaptopStoreApplication.laptopArray[38].getSsd()+"\n"+
                " - GPU: "+LaptopStoreApplication.laptopArray[38].getGpuBrand()+" "+LaptopStoreApplication.laptopArray[38].getGpuModel());
            //https://stackoverflow.com/questions/1090098/newline-in-jlabel#:~:text=JLabel%20is%20actually%20capable%20of,you%20would%20get%20your%20newlines.
        laptopDescription2.setText("<html>" + laptopDescription2.getText().replaceAll("\n", "<br/>") + "</html>");
        laptopPanel2.add(laptopDescription2);
        //Add third best match description (JLabel)
        laptopDescription3.setBounds(75,240,380,200);
        laptopDescription3.setText(" - Price: $"+LaptopStoreApplication.laptopArray[37].getPrice()+"\n"+
                " - Type: "+LaptopStoreApplication.laptopArray[37].getType()+"\n"+
                " - CPU: "+LaptopStoreApplication.laptopArray[37].getCpuBrand()+" "+LaptopStoreApplication.laptopArray[37].getCpuType()+" "+LaptopStoreApplication.laptopArray[37].getCpuModel()+"\n"+
                " - RAM: "+LaptopStoreApplication.laptopArray[37].getRam()+"\n - SSD: "+LaptopStoreApplication.laptopArray[37].getSsd()+"\n"+
                " - GPU: "+LaptopStoreApplication.laptopArray[37].getGpuBrand()+" "+LaptopStoreApplication.laptopArray[37].getGpuModel());
            //https://stackoverflow.com/questions/1090098/newline-in-jlabel#:~:text=JLabel%20is%20actually%20capable%20of,you%20would%20get%20your%20newlines.
        laptopDescription3.setText("<html>" + laptopDescription3.getText().replaceAll("\n", "<br/>") + "</html>");
        laptopPanel3.add(laptopDescription3);

        //Add laptop panels
        laptopPanel1.setBounds(25,120,400,475);
        laptopPanel1.setBackground(Color.white);
        laptopPanel1.setLayout(null);   //manually place elements on laptop panel
        add(laptopPanel1);
        //
        laptopPanel2.setBounds(475,120,400,475);
        laptopPanel2.setBackground(Color.white);
        laptopPanel2.setLayout(null);   //manually place elements on laptop panel
        add(laptopPanel2);
        //
        laptopPanel3.setBounds(925,120,400,475);
        laptopPanel3.setBackground(Color.white);
        laptopPanel3.setLayout(null);   //manually place elements on laptop panel
        add(laptopPanel3);

        //Add the Back button (JButton)
        backButton.setBounds(1256,10,100,50);
        backButton.setFont(buttonFont);
            //https://stackoverflow.com/questions/1065691/how-to-set-the-background-color-of-a-jbutton-on-the-mac-os
        backButton.setBackground(Color.yellow);
        add(backButton);
        backButton.addActionListener(this);

        //Add the Help button (JButton)
        helpButton.setBounds(10,610,100,50);
        helpButton.setFont(buttonFont);
        helpButton.setBackground(Color.yellow);
        add(helpButton);
        helpButton.addActionListener(this);

        //Add the To Website buttons (JButton)
        toWebsiteButton1.setBounds(100,415,200,50);
        toWebsiteButton1.setFont(buttonFont);
        toWebsiteButton1.setBackground(Color.yellow);
        laptopPanel1.add(toWebsiteButton1);
        toWebsiteButton1.addActionListener(this);
        //
        toWebsiteButton2.setBounds(100,415,200,50);
        toWebsiteButton2.setFont(buttonFont);
        toWebsiteButton2.setBackground(Color.yellow);
        laptopPanel2.add(toWebsiteButton2);
        toWebsiteButton2.addActionListener(this);
        //
        toWebsiteButton3.setBounds(100,415,200,50);
        toWebsiteButton3.setFont(buttonFont);
        toWebsiteButton3.setBackground(Color.yellow);
        laptopPanel3.add(toWebsiteButton3);
        toWebsiteButton3.addActionListener(this);

        //Display the frame
        setVisible(true);

    } //end of constructor method

    //this method finds laptops that match the inputted survey choices and then sorts them to find the best laptops that match
    private void top3() {

        //variables for information
        int priceMin = LaptopStoreSurveyFrame.priceMin;
        int priceMax = LaptopStoreSurveyFrame.priceMax;
        String brand = LaptopStoreSurveyFrame.laptopBrand;
        String type = LaptopStoreSurveyFrame.type;
        String cpuBrand = LaptopStoreSurveyFrame.cpuBrand;
        int coresMin = LaptopStoreSurveyFrame.coresMin;
        int coresMax = LaptopStoreSurveyFrame.coreMax;
        double speedMin = LaptopStoreSurveyFrame.speedMin;
        double speedMax = LaptopStoreSurveyFrame.speedMax;
        int ram = LaptopStoreSurveyFrame.ram;
        int ssd = LaptopStoreSurveyFrame.ssd;

        //traverse the array to check for matching fields
            //some fields have a higher score as they are more important
            //ex price is more important than type
        for (int index = 0; index < 40; index++) { //although 1st budget is below 500 all laptops in that range are below 500 so the <= is fine for priceMax

            //check for matching price range
            if (LaptopStoreApplication.laptopArray[index].getPrice() >= priceMin && LaptopStoreApplication.laptopArray[index].getPrice() <= priceMax)
                LaptopStoreApplication.laptopArray[index].setScore(
                        LaptopStoreApplication.laptopArray[index].getScore() + 15);

            //check for matching brand
            if (LaptopStoreApplication.laptopArray[index].getBrand().equalsIgnoreCase(brand))
                LaptopStoreApplication.laptopArray[index].setScore(
                        LaptopStoreApplication.laptopArray[index].getScore() + 5);


            //check for matching type
            if (LaptopStoreApplication.laptopArray[index].getType().equalsIgnoreCase(type))
                LaptopStoreApplication.laptopArray[index].setScore(
                        LaptopStoreApplication.laptopArray[index].getScore() + 5);

            //check for matching CPU brand
            if (LaptopStoreApplication.laptopArray[index].getCpuBrand().equalsIgnoreCase(cpuBrand))
                LaptopStoreApplication.laptopArray[index].setScore(
                        LaptopStoreApplication.laptopArray[index].getScore() + 5);

            //check for matching range of cores
            if (LaptopStoreApplication.laptopArray[index].getCores() >= coresMin && LaptopStoreApplication.laptopArray[index].getCores() <= coresMax)
                LaptopStoreApplication.laptopArray[index].setScore(
                        LaptopStoreApplication.laptopArray[index].getScore() + 10);

            //check for matching speed range
            if (LaptopStoreApplication.laptopArray[index].getSpeed() >= speedMin && LaptopStoreApplication.laptopArray[index].getSpeed() <= speedMax)
                LaptopStoreApplication.laptopArray[index].setScore(
                        LaptopStoreApplication.laptopArray[index].getScore() + 10);

            //check for matching RAM
            if (LaptopStoreApplication.laptopArray[index].getRam() == ram)
                LaptopStoreApplication.laptopArray[index].setScore(
                        LaptopStoreApplication.laptopArray[index].getScore() + 10);

            //check for matching SSD
            if (LaptopStoreApplication.laptopArray[index].getSsd() == ssd)
                LaptopStoreApplication.laptopArray[index].setScore(
                        LaptopStoreApplication.laptopArray[index].getScore() + 10);

        }

        //sort the array by score to get best matching laptops
            //NOTE it will sort score from lowest to highest meaning that
            //index 39 will have the highest score, index 28 with the second highest and so on
        Arrays.sort(LaptopStoreApplication.laptopArray, Comparator.comparing(Laptop::getScore));

    } //end of top3 method

    //this method runs whenever an action occurs
    @Override
    public void actionPerformed(ActionEvent event) {

        //when the back button is clicked
        if (event.getSource() == backButton) {

            //used source to find out how close a JFrame while opening another one
            //https://stackoverflow.com/questions/4716372/java-how-do-i-close-a-jframe-while-opening-another-one#:~:text=Here%2C%20you%20would%20call%20setVisible,frame%20to%20make%20it%20visible.

            //close the current frame
            this.setVisible(false);

            //open the title frame
            LaptopStoreApplication.openLaptopStoreTitleFrame();
        }

        //when the help button is clicked
        if (event.getSource() == helpButton) {

            //show a dialog box with text to help the user of the application
            //https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/dialog.html#:~:text=The%20JDialog%20class%20is%20a,very%20similar%20to%20using%20JFrame%20.
            //the dialog box is in a method in the education frame
            //call the method for the help message
            LaptopStoreEducationFrame.helpMessageBox();

        }

        //when the first to website button is clicked
        if (event.getSource() == toWebsiteButton1) {

            //opens a URL in default browser using Java
            //https://stackoverflow.com/questions/5226212/how-to-open-url-in-default-webbrowser-using-java
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI(LaptopStoreApplication.laptopArray[39].getHyperlink()));
                } catch (IOException | URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //when the second to website button is clicked
        if (event.getSource() == toWebsiteButton2) {

            //opens a URL in default browser using Java
            //https://stackoverflow.com/questions/5226212/how-to-open-url-in-default-webbrowser-using-java
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI(LaptopStoreApplication.laptopArray[38].getHyperlink()));
                } catch (IOException | URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //when the third to website button is clicked
        if (event.getSource() == toWebsiteButton3) {

            //opens a URL in default browser using Java
            //https://stackoverflow.com/questions/5226212/how-to-open-url-in-default-webbrowser-using-java
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI(LaptopStoreApplication.laptopArray[37].getHyperlink()));
                } catch (IOException | URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    } //end of action performed method

    //You cannot make a JMenu ActionListener
    //but we can use the MouseListener instead, idea is from:
        //https://stackoverflow.com/questions/9862165/jmenu-actionlistener
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

} //end of class
