import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class is the BMI Calculator Frame
public class BMICalculatorFrame extends JFrame implements ActionListener {

    //Create the GUI Objects
    //Labels
    JLabel titleLabel = new JLabel( //use HTML tags to change font and colour
            "<HTML><p style=color:#00008b ;>BMI Calculator</p></HTML>");
    JLabel unitsLabel = new JLabel("Units:");
    JLabel sexLabel = new JLabel("Sex:");
    JLabel ageLabel = new JLabel("Age:");
    JLabel weightLabel = new JLabel("Weight:");
    JLabel heightLabel = new JLabel("Height:");
    JLabel resultsLabel = new JLabel("Results:");
    JLabel bmiValueLabel = new JLabel("0");
    JLabel weightUnitLabel = new JLabel("units");
    JLabel heightUnitLabel = new JLabel("units");


    //Custom Font
    //Can also use java code to change Font and Color (color code is down below next to actual label)
    Font titleFont = new Font("Arial", Font.BOLD, 24);
    Font headingFont = new Font("Arial", Font.BOLD, 14);

    //Radio buttons
    JRadioButton imperialRadioButton = new JRadioButton("Imperial");
    JRadioButton metricRadioButton = new JRadioButton("Metric");
    JRadioButton boyRadioButton = new JRadioButton("Boy");
    JRadioButton girlRadioButton = new JRadioButton("Girl");

    //Text fields
    JTextField ageTextField = new JTextField();
    JTextField heightTextField = new JTextField();
    JTextField weightTextField = new JTextField();

    //Button
    JButton calculateButton = new JButton("Calculate BMI");

    //Button Groups
    ButtonGroup unitsButtonGroup = new ButtonGroup();
    ButtonGroup sexButtonGroup = new ButtonGroup();

    //Constructor Build (method)
    public BMICalculatorFrame() {

        //setup the frame
        setSize(900,700);
        setTitle("Ethan's BMI Calculator");
        setLayout(null);
        getContentPane().setBackground(Color.lightGray); //set color for background


        //place the objects on the frame
        //add labels
        titleLabel.setBounds(350,50,400,100);
        add(titleLabel);
        titleLabel.setFont(titleFont);

        unitsLabel.setBounds(100,150,100,25);
        add(unitsLabel);
        unitsLabel.setFont(headingFont);
        unitsLabel.setForeground(new Color(0,0,139)); //set color

        sexLabel.setBounds(100,200,100,25);
        add(sexLabel);
        sexLabel.setFont(headingFont);
        sexLabel.setForeground(new Color(0,0,139));

        ageLabel.setBounds(100,250,100,25);
        add(ageLabel);
        ageLabel.setFont(headingFont);
        ageLabel.setForeground(new Color(0,0,139));

        weightLabel.setBounds(100,300,100,25);
        add(weightLabel);
        weightLabel.setFont(headingFont);
        weightLabel.setForeground(new Color(0,0,139));

        heightLabel.setBounds(100,350,100,25);
        add(heightLabel);
        heightLabel.setFont(headingFont);
        heightLabel.setForeground(new Color(0,0,139));

        resultsLabel.setBounds(100,450,100,25);
        add(resultsLabel);
        resultsLabel.setFont(headingFont);
        resultsLabel.setForeground(new Color(0, 0, 139));

        bmiValueLabel.setBounds(175,450,100,25);
        add(bmiValueLabel);
        bmiValueLabel.setFont(headingFont);
        bmiValueLabel.setForeground(new Color(74, 195, 233));

        weightUnitLabel.setBounds(265,300,100,25);
        add(weightUnitLabel);
        weightUnitLabel.setFont(headingFont);
        weightUnitLabel.setForeground(new Color(0,0,139));

        heightUnitLabel.setBounds(265,350,100,25);
        add(heightUnitLabel);
        heightUnitLabel.setFont(headingFont);
        heightUnitLabel.setForeground(new Color(0,0,139));


        //add radio buttons
        imperialRadioButton.setBounds(140,150,100,25);
        add(imperialRadioButton);
        imperialRadioButton.addActionListener(this); //add ability to be clicked
        metricRadioButton.setBounds(240,150,100,25);
        add(metricRadioButton);
        metricRadioButton.addActionListener(this);

        unitsButtonGroup.add(imperialRadioButton); //add buttons to Button Group
        unitsButtonGroup.add(metricRadioButton);

        boyRadioButton.setBounds(130,200,100,25);
        add(boyRadioButton);
        boyRadioButton.addActionListener(this);
        girlRadioButton.setBounds(230,200,100,25);
        add(girlRadioButton);
        girlRadioButton.addActionListener(this);

        sexButtonGroup.add(boyRadioButton);
        sexButtonGroup.add(girlRadioButton);


        //add text
        ageTextField.setBounds(135,250,100,25);
        add(ageTextField);
        weightTextField.setBounds(155,300,100,25);
        add(weightTextField);
        heightTextField.setBounds(155,350,100,25);
        add(heightTextField);


        //add calculate button
        calculateButton.setBounds(175,400,125,35);
        add(calculateButton);
        calculateButton.addActionListener(this);


        //show the frame
        setVisible(true);


    }

    //this method runs whenever an action occurs
    @Override
    public void actionPerformed(ActionEvent event) {

        //when the calculate button is clicked
        if (event.getSource() == calculateButton) {

            //variables
            double bmiValue;
            double weight = Double.valueOf(weightTextField.getText());
            double height = Double.valueOf(heightTextField.getText());
            //calculate bmi value
            bmiValue = weight / Math.pow(height, 2);

            //metric version; w/h^2
            if (metricRadioButton.isSelected()) {
                bmiValueLabel.setText(Double.toString(bmiValue));
            }

            //imperial version; 703 * w/h^2
            else if (imperialRadioButton.isSelected()) {
                bmiValue *= 703; //*= is the same as bmiValue = bmiValue * 703
                bmiValueLabel.setText(Double.toString(bmiValue));
            }

            //when the imperial radio button is clicked
        } else if (event.getSource() == metricRadioButton) {

            weightUnitLabel.setText("kg");
            heightUnitLabel.setText("m");

            //when the metric radio button is clicked
        } else if (event.getSource() == imperialRadioButton) {
            weightUnitLabel.setText("lbs");
            heightUnitLabel.setText("in");
        }

    }

}

