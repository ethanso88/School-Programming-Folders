import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopGrowthFrame extends JFrame implements ActionListener, ChangeListener {
    //make sure to extend JFrame and implement ActionListener, ChangeListener

    //GUI Objects

    //Labels
    JLabel titleLabel = new JLabel("Population Growth Calculator");
    JLabel selectCountryLabel = new JLabel("Select the Country");
    JLabel growthRateLabel = new JLabel("Growth Rate (in %)");
    JLabel growthRateValueLabel = new JLabel("0");
    JLabel currentPopulationLabel = new JLabel("Current Population");
    JLabel currentPopulationValueLabel = new JLabel("0");
    JLabel numberYearsLabel = new JLabel("Number of Years");
    JLabel futurePopulationLabel = new JLabel("Future Population");
    JLabel futurePopulationValueLabel = new JLabel("0");

    //Combo box
    JComboBox<String> countryComboBox = new JComboBox<String>(); //string is the datatype

    //Slider
    JSlider yearsSlider = new JSlider(0,200,0);
    //minimum value, maximum value, value that you start at

    //Custom Font
    Font titleFont = new Font("Arial", Font.BOLD, 24);
    Font headerFont = new Font("Arial", Font.BOLD, 14);


    //Constructor Build
    public PopGrowthFrame(){

        //setup the frame
        setSize(700,700);
        setTitle("Ethan's Population Growth Calculator");
        setLayout(null);
        getContentPane().setBackground(Color.lightGray);


        //place objects on the frame
        //add labels
        titleLabel.setBounds(175,50,500,50);
        add(titleLabel);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(new Color(0,0,139)); //set color

        selectCountryLabel.setBounds(50,150,300,25);
        add(selectCountryLabel);
        selectCountryLabel.setFont(headerFont);
        selectCountryLabel.setForeground(new Color(0,0,139));
        countryComboBox.setBounds(250,150,300,25);
        countryComboBox.addItem("Australia"); //add each country to the ComboBox
        countryComboBox.addItem("Canada"); //right now it is added in alphabetical order
        countryComboBox.addItem("China");
        countryComboBox.addItem("United Kingdom");
        countryComboBox.addItem("Egypt");
        countryComboBox.addActionListener(this); //make it so that is can be selected
        countryComboBox.setSelectedItem("Australia"); //make it so it selects the first country by default
        add(countryComboBox);

        growthRateLabel.setBounds(50,250,300,25); //set bounds
        add(growthRateLabel);                                      //add label
        growthRateLabel.setFont(headerFont);                       //set font
        growthRateLabel.setForeground(new Color(0,0,139)); //set color
        growthRateValueLabel.setBounds(250,250,300,25);
        add(growthRateValueLabel);
        growthRateValueLabel.setFont(headerFont);
        growthRateValueLabel.setForeground(new Color(0,0,139));

        currentPopulationLabel.setBounds(50,350,300,25);
        add(currentPopulationLabel);
        currentPopulationLabel.setFont(headerFont);
        currentPopulationLabel.setForeground(new Color(0,0,139));
        currentPopulationValueLabel.setBounds(250,350,300,25);
        add(currentPopulationValueLabel);
        currentPopulationValueLabel.setFont(headerFont);
        currentPopulationValueLabel.setForeground(new Color(0,0,139));

        numberYearsLabel.setBounds(50,450,300,50);
        add(numberYearsLabel);
        numberYearsLabel.setFont(headerFont);
        numberYearsLabel.setForeground(new Color(0,0,139));
        yearsSlider.setBounds(250,450,300,50);
        yearsSlider.setMajorTickSpacing(50); //make MAJOR tick marks for the slider (those little line notches)
        yearsSlider.setMinorTickSpacing(10); //make MINOR tick marks
        yearsSlider.setPaintTicks(true); //make paint ticks and labels visible
        yearsSlider.setPaintLabels(true);
        yearsSlider.addChangeListener(this); //make it so it can be selected
        add(yearsSlider);

        futurePopulationLabel.setBounds(50,550,300,25);
        add(futurePopulationLabel);
        futurePopulationLabel.setFont(headerFont);
        futurePopulationLabel.setForeground(new Color(0,0,139));
        futurePopulationValueLabel.setBounds(250,550,300,25);
        add(futurePopulationValueLabel);
        futurePopulationValueLabel.setFont(headerFont);
        futurePopulationValueLabel.setForeground(new Color(0,0,139));


        //show the frame
        setVisible(true);

    }

    //This method responds to selected countries on the ComboBox (or technically any other action)
    @Override
    public void actionPerformed(ActionEvent event) {

        if (countryComboBox.getSelectedItem().equals("Canada")) { //if Canada gets selected

            growthRateValueLabel.setText("1.8"); //set growth rate to 1.8
            currentPopulationValueLabel.setText("38929902"); //set population
            //NOTE: 38939902 can't have spaces or commas like 38,929,902 because it
            //won't be able to read it when it switches to an integer

        } else if (countryComboBox.getSelectedItem().equals("Australia")) {

            growthRateValueLabel.setText("1.2");
            currentPopulationValueLabel.setText("26005540");

        } else if (countryComboBox.getSelectedItem().equals("United Kingdom")) {

            growthRateValueLabel.setText("-0.1");
            currentPopulationValueLabel.setText("66971400");

        } else if (countryComboBox.getSelectedItem().equals("China")) {

            growthRateValueLabel.setText("1.0");
            currentPopulationValueLabel.setText("1412175000");

        } else if (countryComboBox.getSelectedItem().equals("Egypt")) {

            growthRateValueLabel.setText("1.6");
            currentPopulationValueLabel.setText("110990100");

        }

        futurePopulationEquation(); //changes the equation everytime a new country is selected

    }

    //This method responds to changes on the slider
    @Override
    public void stateChanged(ChangeEvent event) {

        futurePopulationEquation();

    }

    //utility method to calculate future population
    private void futurePopulationEquation() {

        //variables (and input)
        int numYears = yearsSlider.getValue();
        int currentPopulation = Integer.parseInt(currentPopulationValueLabel.getText());
        double growthRate = Double.parseDouble(growthRateValueLabel.getText());
        double futurePopulation; //value calculated will be a decimal

        //P - calculate future population, remember FV = P(1 + r)^n
        futurePopulation = currentPopulation * Math.pow(1+growthRate/100,numYears);
        //growthRate needs to be /100 since it is percent

        //O - set future population value label to the future population
        futurePopulationValueLabel.setText(String.format("%.0f", futurePopulation)); //String.format is like printf
        //set to no decimal places since population can't be a decimal

    }

}
