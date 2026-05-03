package View.FarmProductionPackage;

import Controller.MainController;
import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

//this class is the main panel for showing farm production data and graphs
public class FarmProductionPanel extends JPanel {

    //GLOBAL VARIABLES
    //these store all the data arrays for the different crops and costs
    private MainController controller;
    private String[][][] productionCostArray;
    private String[][][] beansProductionArray;
    private String[][][] cornProductionArray;
    private String[][][] wheatProductionArray;
    private String[][][] cropProductionArray; //points to current crop

    //these are the main components used in the panel
    private JPanel chartPanel;
    private JPanel modifierPanel;
    private JLabel titleLabel;
    private JButton changeYearButton, overTimeButton, changeCropButton;
    private JRadioButton[] dataSelectArray;
    private CircleButton helpButton;
    private JButton exitButton;

    //these store the current state of the panel
    private int currentYearIndex = 0;
    private boolean overTimeMode = false;
    private int overTimeRegionIndex = 0;
    private int lastRadioButtonIndex = 0;
    private int currentCropIndex = 0;

    //CONSTANTS
    private static final String[] REGIONS = {
            "Ontario", "Southern Ontario", "Western Ontario",
            "Central Ontario", "Eastern Ontario", "Northern Ontario"
    };
    private static final int[] YEARS = {2006, 2011, 2016, 2021};
    private static final String[] CROP_NAMES = {"beans", "corn", "wheat"};
    private static final int SPACING = 20;
    private static final int MODIFIER_PANEL_WIDTH = 200;
    private static final int HELP_EXIT_HEIGHT = 60;
    private static final int HELP_EXIT_SPACING = SPACING;
    private static final int TITLE_TOP_SPACE = 20;

    //this is the constructor it sets up the whole panel and all the buttons and chart area
    public FarmProductionPanel() {
        setSize(1186, 628); //set the size of the panel
        setBackground(Color.DARK_GRAY); //set the background color of the panel
        setLayout(null); //use absolute positioning for all components

        Font smallFont = new Font("SansSerif", Font.PLAIN, 18); //font for smaller buttons
        Font radioFont = new Font("SansSerif", Font.PLAIN, 13); //font for radio buttons
        Font normalFont = new Font("SansSerif", Font.BOLD, 28); //font for the title label

        //make the title label for the top of the panel
        titleLabel = new JLabel("Farm Production", SwingConstants.CENTER); //create the label and center the text
        titleLabel.setFont(normalFont); //set the font of the label
        titleLabel.setForeground(Color.WHITE); //set the text color to white
        //make the label as wide as the panel so long titles fit
        titleLabel.setBounds(0, TITLE_TOP_SPACE, 1186, 40); //set the position and size of the label
        add(titleLabel); //add the label to the panel

        int chartY = titleLabel.getY() + titleLabel.getHeight() + SPACING; //calculate the y position for the chart panel
        int totalAvailableHeight = getHeight() - chartY - SPACING; //calculate the total height available for the chart and modifier panels
        int reservedHelpExitSpace = HELP_EXIT_HEIGHT + HELP_EXIT_SPACING; //space reserved for help and exit buttons at the bottom
        int panelHeight = totalAvailableHeight - reservedHelpExitSpace; //height for the chart panel
        int modifierPanelHeight = panelHeight - HELP_EXIT_HEIGHT - HELP_EXIT_SPACING; //height for the modifier panel

        //make the panel that will hold the chart
        chartPanel = new JPanel(); //create the panel for the chart
        chartPanel.setBounds(30, chartY, 900 - SPACING, panelHeight); //set position and size of the chart panel
        chartPanel.setBackground(Color.white); //set chart panel background to white
        add(chartPanel); //add chart panel to the main panel

        //make the panel on the right for the buttons and radio buttons
        modifierPanel = new JPanel(); //create the panel for controls
        modifierPanel.setBounds(chartPanel.getX() + chartPanel.getWidth() + SPACING,
                chartY, MODIFIER_PANEL_WIDTH, modifierPanelHeight); //set position and size of the modifier panel
        modifierPanel.setBackground(new Color(0x06, 0x06, 0x44)); //set a dark blue background
        //BoxLayout lets you stack components vertically
        //see: https://docs.oracle.com/javase/8/docs/api/javax/swing/BoxLayout.html
        modifierPanel.setLayout(new BoxLayout(modifierPanel, BoxLayout.Y_AXIS)); //use vertical BoxLayout

        //make the three main buttons
        changeYearButton = new JButton("display per year"); //button to change the year
        overTimeButton = new JButton("display over time"); //button to switch to over-time chart
        changeCropButton = new JButton("change crop"); //button to switch crops
        JButton[] modButtons = {changeYearButton, overTimeButton, changeCropButton}; //array of the main buttons

        //style and add the main buttons to the modifier panel
        for (JButton button : modButtons) {
            button.setFont(smallFont); //set font
            button.setBackground(new Color(0x06, 0x06, 0x44)); //set background color
            button.setForeground(Color.WHITE); //set text color
            button.setFocusPainted(false); //remove focus border
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE)); //add a white border
            button.setAlignmentX(Component.CENTER_ALIGNMENT); //center horizontally in BoxLayout
            button.setMaximumSize(new Dimension(MODIFIER_PANEL_WIDTH - 10, 40)); //set max size
            modifierPanel.add(Box.createRigidArea(new Dimension(0, 10))); //add vertical space before each button
            modifierPanel.add(button); //add the button to the panel
        }

        modifierPanel.add(Box.createRigidArea(new Dimension(0, 20))); //add extra space after the main buttons

        //set up the radio buttons for choosing the data type
        String[] radioLabels = {
                "<html>Production ('000 cwt)<br>vs Operating Expenses ($)</html>",
                "<html>Yield (cwt/ac)<br>vs Net Operating Income<br>per Farm ($)</html>",
                "<html>Acres Harvested (acres)<br>vs Farms Reporting<br>(number of farms)</html>"
        };
        dataSelectArray = new JRadioButton[3]; //array to hold the radio buttons
        ButtonGroup radioGroup = new ButtonGroup(); //group so only one can be selected at a time
        for (int radioIndex = 0; radioIndex < dataSelectArray.length; radioIndex++) {
            dataSelectArray[radioIndex] = new JRadioButton(radioLabels[radioIndex]); //create the radio button
            dataSelectArray[radioIndex].setFont(radioFont); //set font
            dataSelectArray[radioIndex].setBackground(new Color(0x06, 0x06, 0x44)); //set background color
            dataSelectArray[radioIndex].setForeground(Color.WHITE); //set text color
            dataSelectArray[radioIndex].setFocusPainted(false); //remove focus border
            dataSelectArray[radioIndex].setBorder(BorderFactory.createLineBorder(Color.WHITE)); //add a white border
            dataSelectArray[radioIndex].setAlignmentX(Component.CENTER_ALIGNMENT); //center horizontally
            dataSelectArray[radioIndex].setMaximumSize(new Dimension(MODIFIER_PANEL_WIDTH - 10, 60)); //set max size
            dataSelectArray[radioIndex].setPreferredSize(new Dimension(MODIFIER_PANEL_WIDTH - 10, 60)); //set preferred size
            radioGroup.add(dataSelectArray[radioIndex]); //add to the button group
            modifierPanel.add(Box.createRigidArea(new Dimension(0, 8))); //add vertical space before each radio button
            modifierPanel.add(dataSelectArray[radioIndex]); //add the radio button to the panel
        }
        modifierPanel.add(Box.createVerticalGlue()); //add space at the bottom to push everything up
        add(modifierPanel); //add the modifier panel to the main panel

        //make the help and exit buttons
        helpButton = new CircleButton("?"); //create the help button
        helpButton.setFont(new Font("SansSerif", Font.BOLD, 28)); //set font for the help button
        helpButton.setForeground(Color.BLACK); //set text color for the help button
        int helpSize = 60; //size for the help button

        exitButton = new JButton("Exit"); //create the exit button
        exitButton.setFont(new Font("SansSerif", Font.BOLD, 24)); //set font for the exit button
        exitButton.setBackground(new Color(0xc4, 0x39, 0x1d)); //set background color for the exit button
        exitButton.setForeground(Color.WHITE); //set text color for the exit button
        exitButton.setFocusPainted(false); //remove focus border
        exitButton.setBorder(BorderFactory.createLineBorder(Color.WHITE)); //add a white border

        int exitWidth = 100; //width for the exit button
        int exitHeight = 60; //height for the exit button
        int totalButtonWidth = helpSize + exitWidth; //total width for both buttons
        int numSpaces = 3; //number of spaces between and around the buttons
        int space = (MODIFIER_PANEL_WIDTH - totalButtonWidth) / numSpaces; //space between buttons
        int helpY = modifierPanel.getY() + modifierPanel.getHeight() + HELP_EXIT_SPACING; //y position for help button
        int helpX = modifierPanel.getX() + space; //x position for help button
        int exitX = helpX + helpSize + space; //x position for exit button
        helpButton.setBounds(helpX, helpY, helpSize, helpSize); //set position and size of help button
        add(helpButton); //add help button to the panel
        exitButton.setBounds(exitX, helpY, exitWidth, exitHeight); //set position and size of exit button
        add(exitButton); //add exit button to the panel

        //exit button closes the panel and goes back to menu
        exitButton.addActionListener(event -> {
            if (controller != null) {
                controller.switchToMenuPanel(); //tell the controller to go back to the menu panel
            }
        });

        //help button shows instructions for the panel
        helpButton.addActionListener(event -> {
            String message =
                    "- the display over year button shows crop production and overall cost for one year each time you click it you see a different year\n"
                            + "- the display over-time button shows the same data as a double bar chart for one region at a time each time you click it you see a different region\n"
                            + "- the change crop button lets you switch between beans corn and wheat\n"
                            + "* the double bar graph needs four legends because it uses two datasets for each year one for the real bar and one for an empty bar this keeps the bars from overlapping you can ignore the empty bar legends\n"
                            + "* northern ontario is not shown in the over time chart because there is not enough data for that region in most years";
            JOptionPane.showMessageDialog(this, message, "Help", JOptionPane.INFORMATION_MESSAGE);
        });

        //load production cost data from all four years into a 3d array
        ProductionCostManager prodManager = new ProductionCostManager();
        String[] files1 = {
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\noibyfarmsize_en - 2006.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\noibyfarmsize_en - 2011.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\noibyfarmsize_en - 2016.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\noibyfarmsize_en - 2021.csv"
        };
        prodManager.readMultipleProductionCostFiles(files1); //reads all the csv files and stores them in prodManager
        productionCostArray = prodManager.getProductionCostArray(); //get the 3d array with all the production cost data

        //load beans data from all four years into a 3d array
        CropProductionManager beansManager = new CropProductionManager();
        String[] beansFiles = {
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctycbeans - 2006E.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctycbeans - 2011E.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctycbeans - 2016E.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctycbeans - 2021E.csv"
        };
        beansManager.readMultipleCropProductionFiles(beansFiles); //reads all the beans csv files and stores them in beansManager
        beansProductionArray = beansManager.getCropProductionArray(); //get the 3d array with all the beans data

        //load corn data from all four years into a 3d array
        CropProductionManager cornManager = new CropProductionManager();
        String[] cornFiles = {
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctygcorn - 2006E.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctygcorn - 2011E.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctygcorn - 2016E.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctygcorn - 2021E.csv"
        };
        cornManager.readMultipleCropProductionFiles(cornFiles); //reads all the corn csv files and stores them in cornManager
        cornProductionArray = cornManager.getCropProductionArray(); //get the 3d array with all the corn data

        //load wheat data from all four years into a 3d array
        CropProductionManager wheatManager = new CropProductionManager();
        String[] wheatFiles = {
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctyswheat - 2006E.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctyswheat - 2011E.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctyswheat - 2016E.csv",
                "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\Unit 4 - Software Development\\SDP 2 - Data Mining Project\\data\\FarmProductionData\\ctyswheat - 2021E.csv"
        };
        wheatManager.readMultipleCropProductionFiles(wheatFiles); //reads all the wheat csv files and stores them in wheatManager
        wheatProductionArray = wheatManager.getCropProductionArray(); //get the 3d array with all the wheat data

        //set default crop to beans
        cropProductionArray = beansProductionArray;
        currentCropIndex = 0;

        //default: show first comparison for 2006
        dataSelectArray[0].setSelected(true);
        lastRadioButtonIndex = 0;
        updateChart(lastRadioButtonIndex, currentYearIndex);

        //as I was doing research on event handling I found a better method to add actionlisteners than the typical @override method
        //lambda expressions let you write short event handlers
        //https://stackoverflow.com/questions/16859992/java-lambda-expressions
        //radio button listeners (these will "stick" to the graph type)
        for (int radioIndex = 0; radioIndex < dataSelectArray.length; radioIndex++) {
            final int index = radioIndex;
            dataSelectArray[radioIndex].addActionListener(event -> {
                lastRadioButtonIndex = index; //remember which radio was last clicked
                if (overTimeMode) { //if we are in over-time mode
                    updateOverTimeChart(index, overTimeRegionIndex); //show the over-time chart for this type
                    //update the title to show which region and crop
                    titleLabel.setText("Farm Production Over Time (" + REGIONS[overTimeRegionIndex] + ") - " + CROP_NAMES[currentCropIndex]);
                } else { //if we are in per-year mode
                    updateChart(index, currentYearIndex); //show the regular chart for this type
                    //update the title to show which year and crop
                    titleLabel.setText("Farm Production (" + YEARS[currentYearIndex] + ") - " + CROP_NAMES[currentCropIndex]);
                }
            });
        }

        //change year button cycles through years ("stick" radiobuttons)
        changeYearButton.addActionListener(event -> {
            overTimeMode = false; //make sure we are in per-year mode
            currentYearIndex = (currentYearIndex + 1) % YEARS.length; //go to the next year (wrap around)
            updateChart(lastRadioButtonIndex, currentYearIndex); //update the chart for the new year and last radio type
            //update the title to show the new year and crop
            titleLabel.setText("Farm Production (" + YEARS[currentYearIndex] + ") - " + CROP_NAMES[currentCropIndex]);
        });

        //over time button cycles through regions 0 to 4 (this will also skip northern ontario data) (also "stick" radiobuttons)
        overTimeButton.addActionListener(event -> {
            overTimeMode = true; //switch to over-time mode
            overTimeRegionIndex = (overTimeRegionIndex + 1) % (REGIONS.length - 1); //cycle through regions except last one (northern ontario)
            updateOverTimeChart(lastRadioButtonIndex, overTimeRegionIndex); //update the over-time chart for this region and type
            //update the title to show the region and crop
            titleLabel.setText("Farm Production Over Time (" + REGIONS[overTimeRegionIndex] + ") - " + CROP_NAMES[currentCropIndex]);
        });

        //change crop button cycles through beans, corn, wheat
        changeCropButton.addActionListener(event -> {
            currentCropIndex = (currentCropIndex + 1) % 3; //cycle through 0, 1, 2 (beans, corn, wheat)
            //pick which data array to use based on the crop index
            if (currentCropIndex == 0) {
                cropProductionArray = beansProductionArray; //use beans data
            } else if (currentCropIndex == 1) {
                cropProductionArray = cornProductionArray; //use corn data
            } else {
                cropProductionArray = wheatProductionArray; //use wheat data
            }
            //update the chart and title based on which mode we are in
            if (overTimeMode) {
                updateOverTimeChart(lastRadioButtonIndex, overTimeRegionIndex); //update over-time chart for new crop
                titleLabel.setText("Farm Production Over Time (" + REGIONS[overTimeRegionIndex] + ") - " + CROP_NAMES[currentCropIndex]);
            } else {
                updateChart(lastRadioButtonIndex, currentYearIndex); //update per-year chart for new crop
                titleLabel.setText("Farm Production (" + YEARS[currentYearIndex] + ") - " + CROP_NAMES[currentCropIndex]);
            }
        });
    }

    //this method lets the controller switch panels
    public void setController(MainController controller) {
        this.controller = controller;
    }

    //this method is important because all data from the csv file is read as a string
    //we need to convert (parse) these strings into doubles so we can do math and make graphs
    //if the string is not a number (like "-" or ""), this method returns 0 instead of crashing
    //see: https://stackoverflow.com/questions/3543729/how-to-check-that-a-string-is-parseable-to-a-double
    private double safeConvert(String value) {
        if (value == null) return 0;
        value = value.replace("\"", "").replace(",", "").trim();
        if (value.equals("-") || value.isEmpty()) return 0;
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException exception) {
            return 0;
        }
    }

    //this method updates the chart for a single year
    //it rebuilds the chart from scratch with new data for the selected year and comparison type
    //see: https://stackoverflow.com/questions/6199498/jfreechart-refresh-a-chart-according-to-changing-data
    private void updateChart(int comparisonIndex, int yearIndex) {
        if (overTimeMode) return; //if we are in over-time mode, don't update this chart

        //these datasets will store the data for the bar and line on the chart
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();

        //labels and title for the chart (will be set below)
        String barLabel = "";
        String lineLabel = "";
        String chartTitle = "";

        //grab the data for the selected year
        String[][] cropData = cropProductionArray[yearIndex];
        String[][] prodData = productionCostArray[yearIndex];

        //decide what to compare based on which radio button is selected
        switch (comparisonIndex) {
            case 0:
                barLabel = "Production ('000 cwt)";
                lineLabel = "Operating Expenses ($)";
                chartTitle = "Production vs Operating Expenses (" + YEARS[yearIndex] + ")";
                //loop through all regions and add their data to the datasets
                for (int regionIndex = 0; regionIndex < REGIONS.length; regionIndex++) {
                    //skip if data is missing for this region
                    if (regionIndex >= cropData.length || regionIndex >= prodData.length) continue;
                    double cropProduction = safeConvert(cropData[regionIndex][4]); //convert string to double for production
                    double operatingExpenses = safeConvert(prodData[regionIndex][8]); //convert string to double for expenses
                    barDataset.addValue(cropProduction, barLabel, REGIONS[regionIndex]); //add bar value
                    lineDataset.addValue(operatingExpenses, lineLabel, REGIONS[regionIndex]); //add line value
                }
                break;
            case 1:
                barLabel = "Yield (cwt/ac)";
                lineLabel = "Net Operating Income per Farm ($)";
                chartTitle = "Yield vs Net Income per Farm (" + YEARS[yearIndex] + ")";
                for (int regionIndex = 0; regionIndex < REGIONS.length; regionIndex++) {
                    if (regionIndex >= cropData.length || regionIndex >= prodData.length) continue;
                    double cropYield = safeConvert(cropData[regionIndex][3]); //convert to double for yield
                    double netOperatingIncome = safeConvert(prodData[regionIndex][9]); //convert to double for net income
                    barDataset.addValue(cropYield, barLabel, REGIONS[regionIndex]);
                    lineDataset.addValue(netOperatingIncome, lineLabel, REGIONS[regionIndex]);
                }
                break;
            case 2:
                barLabel = "Acres Harvested (acres)";
                lineLabel = "Farms Reporting (number of farms)";
                chartTitle = "Acres Harvested vs Farms Reporting (" + YEARS[yearIndex] + ")";
                for (int regionIndex = 0; regionIndex < REGIONS.length; regionIndex++) {
                    if (regionIndex >= cropData.length || regionIndex >= prodData.length) continue;
                    double acresHarvested = safeConvert(cropData[regionIndex][2]); //convert to double for acres
                    double farmsReporting = safeConvert(prodData[regionIndex][6]); //convert to double for number of farms
                    barDataset.addValue(acresHarvested, barLabel, REGIONS[regionIndex]);
                    lineDataset.addValue(farmsReporting, lineLabel, REGIONS[regionIndex]);
                }
                break;
        }

        //set up the chart axes and renderers
        BarRenderer barRenderer = new BarRenderer(); //draws the bars
        org.jfree.chart.renderer.category.LineAndShapeRenderer lineRenderer = new org.jfree.chart.renderer.category.LineAndShapeRenderer(); //draws the line

        CategoryAxis domainAxis = new CategoryAxis("Region"); //x-axis for region names
        NumberAxis barAxis = new NumberAxis(barLabel); //y-axis for the bar values
        NumberAxis lineAxis = new NumberAxis(lineLabel); //y-axis for the line values

        //create a plot and add both datasets and axes
        CategoryPlot plot = new CategoryPlot();
        plot.setDomainAxis(domainAxis); //set x-axis
        plot.setRangeAxis(0, barAxis); //set y-axis for bars
        plot.setRangeAxis(1, lineAxis); //set y-axis for line

        plot.setDataset(0, barDataset); //add bar data
        plot.setRenderer(0, barRenderer); //add bar renderer
        plot.mapDatasetToRangeAxis(0, 0); //map bar data to bar axis

        plot.setDataset(1, lineDataset); //add line data
        plot.setRenderer(1, lineRenderer); //add line renderer
        plot.mapDatasetToRangeAxis(1, 1); //map line data to line axis

        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD); //draw bars first, then line

        //make the chart with the plot and title
        JFreeChart comboChart = new JFreeChart(
                chartTitle,
                new Font("SansSerif", Font.BOLD, 18),
                plot,
                true //show legend
        );

        //put the chart into a ChartPanel so it shows up in the GUI
        ChartPanel chartComponent = new ChartPanel(comboChart);
        chartComponent.setPreferredSize(chartPanel.getSize()); //make it fit the area
        chartPanel.setLayout(new BorderLayout()); //use BorderLayout for the chart panel
        chartPanel.removeAll(); //clear out any old chart
        chartPanel.add(chartComponent, BorderLayout.CENTER); //add the new chart
        chartPanel.validate(); //refresh the panel so the new chart shows up
    }

    //this method updates the chart to show data over time for a region
    //it rebuilds the chart with new data for the selected region and comparison type (like production vs cost)
    //see: https://stackoverflow.com/questions/6199498/jfreechart-refresh-a-chart-according-to-changing-data
    private void updateOverTimeChart(int comparisonIndex, int regionIndex) {
        overTimeMode = true; //make sure we are in over-time mode

        //these datasets will store the data for the two bars on the chart
        DefaultCategoryDataset cropDataset = new DefaultCategoryDataset(); //for crop data (like production)
        DefaultCategoryDataset prodDataset = new DefaultCategoryDataset(); //for production cost data

        //labels and title for the chart (set below)
        String cropLabel = "";
        String prodLabel = "";
        String chartTitle = "";

        //these are the column indices for the data we want from the arrays
        int cropDataIndex = 0, prodDataIndex = 0;

        //decide what to compare based on which radio button is selected
        switch (comparisonIndex) {
            case 0:
                cropLabel = "Production ('000 cwt)";
                prodLabel = "Operating Expenses ($)";
                cropDataIndex = 4; //column for production in crop array
                prodDataIndex = 8; //column for expenses in prod array
                chartTitle = "Production vs Operating Expenses Over Time (" + REGIONS[regionIndex] + ")";
                break;
            case 1:
                cropLabel = "Yield (cwt/ac)";
                prodLabel = "Net Operating Income per Farm ($)";
                cropDataIndex = 3; //column for yield
                prodDataIndex = 9; //column for net income
                chartTitle = "Yield vs Net Income per Farm Over Time (" + REGIONS[regionIndex] + ")";
                break;
            case 2:
                cropLabel = "Acres Harvested (acres)";
                prodLabel = "Farms Reporting (number of farms)";
                cropDataIndex = 2; //column for acres
                prodDataIndex = 6; //column for farms reporting
                chartTitle = "Acres Harvested vs Farms Reporting Over Time (" + REGIONS[regionIndex] + ")";
                break;
        }

        //loop through each year and add the data for this region to the datasets
        for (int yearIndex = 0; yearIndex < YEARS.length; yearIndex++) {
            //skip if data is missing for this region in this year
            if (regionIndex >= cropProductionArray[yearIndex].length || regionIndex >= productionCostArray[yearIndex].length) continue;
            //add the crop data (like production or yield) for this year
            cropDataset.addValue(safeConvert(cropProductionArray[yearIndex][regionIndex][cropDataIndex]), cropLabel, "" + YEARS[yearIndex]);
            //add null for the other bar so it doesn't overlap
            cropDataset.addValue(null, prodLabel, "" + YEARS[yearIndex]);
            //add null for the first bar in the prod dataset
            prodDataset.addValue(null, cropLabel, "" + YEARS[yearIndex]);
            //add the production cost data (like expenses or farms reporting) for this year
            prodDataset.addValue(safeConvert(productionCostArray[yearIndex][regionIndex][prodDataIndex]), prodLabel, "" + YEARS[yearIndex]);
        }

        //set up the chart axes
        CategoryAxis domainAxis = new CategoryAxis("Year"); //x-axis for years
        NumberAxis cropAxis = new NumberAxis(cropLabel); //y-axis for the crop data
        NumberAxis prodAxis = new NumberAxis(prodLabel); //y-axis for the production cost data

        //set up the two bar renderers (one for each dataset)
        BarRenderer cropRenderer = new BarRenderer();
        cropRenderer.setSeriesPaint(0, new Color(0x3B, 0x6E, 0xA5)); //set color for crop bars
        BarRenderer prodRenderer = new BarRenderer();
        prodRenderer.setSeriesPaint(1, new Color(0xC4, 0x39, 0x1D)); //set color for prod bars

        //create the plot and add both datasets and axes
        CategoryPlot plot = new CategoryPlot();
        plot.setDomainAxis(domainAxis); //set x-axis

        plot.setDataset(0, cropDataset); //add crop data
        plot.setRenderer(0, cropRenderer); //add crop renderer
        plot.setRangeAxis(0, cropAxis); //set y-axis for crop
        plot.mapDatasetToRangeAxis(0, 0); //link crop data to crop axis

        plot.setDataset(1, prodDataset); //add prod data
        plot.setRenderer(1, prodRenderer); //add prod renderer
        plot.setRangeAxis(1, prodAxis); //set y-axis for prod
        plot.mapDatasetToRangeAxis(1, 1); //link prod data to prod axis

        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD); //draw crop bars first, then prod bars

        //make the chart with the plot and title
        JFreeChart chart = new JFreeChart(
                chartTitle,
                new Font("SansSerif", Font.BOLD, 18),
                plot,
                true //show legend
        );

        //put the chart into a ChartPanel so it shows up in the GUI
        ChartPanel chartComponent = new ChartPanel(chart);
        chartComponent.setPreferredSize(chartPanel.getSize()); //make it fit the area
        chartPanel.setLayout(new BorderLayout());
        chartPanel.removeAll(); //clear out any old chart
        chartPanel.add(chartComponent, BorderLayout.CENTER); //add the new chart
        chartPanel.validate(); //refresh the panel so the new chart shows up
    }
}
