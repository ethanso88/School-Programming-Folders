import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class LaptopStoreInventoryFrame extends JFrame implements ActionListener, MouseListener {


    JList<ImageIcon> laptopImageList = new JList<ImageIcon>();
    JList<String> laptopInfoList = new JList<String>();
    Laptop[] searchResult = new Laptop[0];// = LaptopStoreApplication.laptopArray;

    JScrollPane imageScrollPane, textScrollPane;
    JSplitPane splitPane;

    // Add label for the company name
    ImageIcon icon = new ImageIcon("images/companyLogo.png");

    private JLabel titleLabel = new JLabel("Good Buy Application");

    // Add label for the logo icon
    ImageIcon scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 40, java.awt.Image.SCALE_SMOOTH));

    JLabel scaledIconLabel = new JLabel(scaledIcon);

    // Add the screen title
    private JLabel screenTitleLabel = new JLabel("Inventory");

    // Add a back button
    private JButton backButton = new JButton("Back");

    // Add a help button
    private JButton helpButton = new JButton("Help");

    // Add the menu bar
    // Add Menu Item for each screen(5 choices)
    JMenuBar menuBar = new JMenuBar();
    JMenu titleMenu = new JMenu("Title");
    JMenu inventoryMenu = new JMenu("Inventory");
    JMenu surveyMenu = new JMenu("Survey");
    JMenu resultsMenu = new JMenu("Results");
    JMenu educationMenu = new JMenu("Education");

    // add a panel to hold all the content
    JScrollPane scrollPane;

    // Make a label for the title of the filter
    private JLabel filterTitle = new JLabel("Filter");

    // Make panel to hold the options on the filter table
    JPanel filterPanel = new JPanel();
    // Add dropbox to each option label on the filter table
    JLabel brand = new JLabel("Brand : ");
    JLabel price = new JLabel("Price Range : ");
    JLabel type  = new JLabel("Type : ");
    JLabel cpu   = new JLabel("CPU Brand : ");
    JLabel ram   = new JLabel("RAM(GB) : ");
    JLabel ssd   = new JLabel("SSD(GB) : ");
    JLabel gpu   = new JLabel("GPU : ");

    // Add a button to search the computers
    JButton search = new JButton("Search");

    // Add a button to clear search filters
    JButton clearFilter = new JButton("Clear Filter");

    JComboBox<Object> comboBrand, comboPrice, comboType, comboCPU, comboRAM, comboSSD, comboGPU;

    // constructor method
    public LaptopStoreInventoryFrame() throws IOException {

        // Set up the frame to be 1366*768
        // With a background color blue******
        // Add the frame title
        setSize(1366, 768);
        setTitle("Good Buy Application");
        setLayout(null);
        getContentPane().setBackground(Color.decode("#3d85c6"));

        scaledIconLabel.setBounds(240, 15, 50, 40);
        add(scaledIconLabel);

        // Add the menu bar
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

        // Add label for the company name on the top left corner

        titleLabel.setBounds(20, 5, 300, 50);
        titleLabel.setFont(new Font("Ariel", Font.BOLD, 20));
        titleLabel.setForeground(Color.yellow);
        add(titleLabel);

        // Add label for the logo icon on the top left corner
        // Add the screen title to top center of the background(label)
        screenTitleLabel.setBounds(650, 35, 100, 50);
        add(screenTitleLabel);
        screenTitleLabel.setFont(new Font("Ariel", Font.BOLD, 20));
        screenTitleLabel.setForeground(Color.yellow);

        // Add a back button on the top right corner of the background
        backButton.setBounds(1256, 10, 100, 50);
        backButton.setBackground(Color.yellow);
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.addActionListener(this);
        add(backButton);

        // Add a help button on the bottom left corner of the background
        helpButton.setBounds(10, 610, 100, 50);
        helpButton.setBackground(Color.yellow);
        helpButton.setFont(new Font("Arial", Font.BOLD, 18));
        helpButton.addActionListener(this);
        add(helpButton);

        // Add a Scrollbar to scroll up and down to view the content

        laptopImageList.addListSelectionListener(e ->
                showSelectedLaptopInfo(laptopImageList.getSelectedIndices(), searchResult));

        // JSplitPane/JScrollPane/JList alignment
        // https://coderanch.com/t/338787/java/JSplitPane-JScrollPane-JList-alignment
        DefaultListCellRenderer renderer = (DefaultListCellRenderer)laptopImageList.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        imageScrollPane = new JScrollPane(laptopImageList);

        // Microsoft-Supplied Monospaced TrueType Fonts
        // https://support.microsoft.com/en-us/topic/microsoft-supplied-monospaced-truetype-fonts-93aa7a47-2149-be09-31a9-c22df598c952
        laptopInfoList.setFont(new Font("Courier New", Font.BOLD, 12));
        textScrollPane = new JScrollPane(laptopInfoList);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, imageScrollPane, textScrollPane);
        splitPane.setDividerLocation(350);
        splitPane.setBounds(600, 150, 700, 400);

        add(splitPane);

        // Make a label for the title of the filter
        filterTitle.setBounds(100, 100, 100, 50);
        filterTitle.setFont(new Font("Ariel", Font.BOLD, 20));
        filterTitle.setForeground(Color.white);
        add(filterTitle);

        // Make panel to hold the options on the filter table
        filterPanel.setBounds(100, 150, 400, 300);
        filterPanel.setBackground(Color.white);
        filterPanel.setLayout(null);

        add(filterPanel);

        // Add dropbox to each option label on the filter table
        brand.setBounds(5, 0, 100, 50);
        String Brand[] = {"All", "Lenovo", "Apple", "Microsoft", "HP", "Acer", "Dell", "MSI", "ASUS" };
        comboBrand = new JComboBox<Object>(Brand);
        comboBrand.setBounds(120, 10, 200, 30);
        filterPanel.add(brand);
        filterPanel.add(comboBrand);

        price.setBounds(5, 30, 100, 50);
        String Price[] = {"All", "$100-$500", "$500-$1000", "$1000-$2000", "$2000+" };
        comboPrice = new JComboBox<Object>(Price);
        comboPrice.setBounds(120, 40, 200, 30);
        filterPanel.add(price);
        filterPanel.add(comboPrice);

        type.setBounds(5, 60, 100, 50);
        String Type[] = {"All", "Student", "Gaming", "Professional" };
        comboType = new JComboBox<Object>(Type);
        comboType.setBounds(120, 70, 200, 30);
        filterPanel.add(type);
        filterPanel.add(comboType);

        cpu.setBounds(5, 90, 100, 50);
        String CPU[] = {"All", "Intel", "Apple", "AMD", "Media Tek" };
        comboCPU = new JComboBox<Object>(CPU);
        comboCPU.setBounds(120, 100, 200, 30);
        filterPanel.add(cpu);
        filterPanel.add(comboCPU);

        ram.setBounds(5, 120, 100, 50);
        String RAM[] = {"All", "4", "8", "16", "32" };
        comboRAM = new JComboBox<Object>(RAM);
        comboRAM.setBounds(120, 130, 200, 30);
        filterPanel.add(ram);
        filterPanel.add(comboRAM);

        ssd.setBounds(5, 150, 100, 50);
        String SSD[] = {"All", "64", "128", "256", "512", "1000", "2000" };
        comboSSD = new JComboBox<Object>(SSD);
        comboSSD.setBounds(120, 160, 200, 30);
        filterPanel.add(ssd);
        filterPanel.add(comboSSD);

        gpu.setBounds(5, 180, 100, 50);
        String GPU[] = {"All", "Integrated", "NVIDIA GeForce", "Intel", "Liquid Retina" };
        comboGPU = new JComboBox<Object>(GPU);
        comboGPU.setBounds(120, 190, 200, 30);
        filterPanel.add(gpu);
        filterPanel.add(comboGPU);

        // Add a button to search the computers
        search.setBounds(240, 250, 100, 30);
        filterPanel.add(search);
        search.addActionListener(e -> {
            try {
                searchLaptop();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        // Add a button to clear search filters
        clearFilter.setBounds(60, 250, 100, 30);
        filterPanel.add(clearFilter);
        clearFilter.addActionListener(e -> clearSearchFilters());


        setVisible(true);
    }

    private void clearSearchFilters() {
        // TODO Auto-generated method stub

        comboBrand.setSelectedIndex(0);
        comboPrice.setSelectedIndex(0);
        comboType.setSelectedIndex(0);
        comboCPU.setSelectedIndex(0);
        comboRAM.setSelectedIndex(0);
        comboSSD.setSelectedIndex(0);
        comboGPU.setSelectedIndex(0);

        return;
    }

    private void showSelectedLaptopInfo(int[] selectedIndices, Laptop[] laptopArray) {
        // TODO Auto-generated method stub

        // Add and Remove Elements in JList Dynamically
        // https://java-demos.blogspot.com/2012/10/add-remove-contents-jlist-dynamically.html
        // How to Use HTML in Swing Components
        // https://docs.oracle.com/javase/tutorial/uiswing/components/html.html
        // Customize Your JList Display
        // https://www.oracle.com/technical-resources/articles/javase/oconner-customlist-gd-aurev.html

        int selected = selectedIndices.length;
        int total    = laptopArray.length;
        int lines   = 10;

        String[] InfoList = new String[selected*lines+5];

        InfoList[0] = "<html></html>";
        InfoList[1] = "<html>Laptop Information :<i><b><u> "
                + selected + " </u></b></i> out of<i><b><u> " + total + " </u></b></i> Selected.</html>";
        InfoList[2] = "=========================================";
//		"<html>Search Result :<i><b><u>    "+searchResult.length+"    </u></b></i>product(s) matched.</html>",

        for(int i=0;i<selected;i++) {

//			InfoList[ 2+i*lines] = "<html></html>";
//			InfoList[ 3+i*lines] = "<html></html>";
            InfoList[ 4+i*lines] = "<html><li>Selected Laptop No.<b><u><i> " + (i+1) +" </i></u></b></html>";

            InfoList[ 5+i*lines] = String.format("Brand................%s", laptopArray[selectedIndices[i]].getBrand());
            InfoList[ 6+i*lines] = String.format("Price................$%s", laptopArray[selectedIndices[i]].getPrice());
            InfoList[ 7+i*lines] = String.format("Type.................%s", laptopArray[selectedIndices[i]].getType());
            InfoList[ 8+i*lines] = String.format("CPU..................%s", laptopArray[selectedIndices[i]].getCpuBrand());
            InfoList[ 9+i*lines] = String.format("RAM..................%sGB", laptopArray[selectedIndices[i]].getRam());
            InfoList[10+i*lines] = String.format("SSD..................%sGB", laptopArray[selectedIndices[i]].getSsd());
            InfoList[11+i*lines] = String.format("GPU..................%s", laptopArray[selectedIndices[i]].getGpuBrand());

        }

        laptopInfoList.setListData(InfoList);

    }

    private void searchLaptop() throws IOException {

        DefaultListModel<Integer> indexList = new DefaultListModel<Integer>();

        String brand = (String) comboBrand.getSelectedItem();
        String price = (String) comboPrice.getSelectedItem();
        String priceRange = Integer.toString(comboPrice.getSelectedIndex());
        String type  = (String) comboType.getSelectedItem();
        String cpu   = (String) comboCPU.getSelectedItem();
        String ram   = (String) comboRAM.getSelectedItem();
        String ssd   = (String) comboSSD.getSelectedItem();
        String gpu   = (String) comboGPU.getSelectedItem();

        for (int i = 0; i < LaptopStoreApplication.laptopArray.length; i++) {

            if (	("All".equalsIgnoreCase(brand) ||
                    LaptopStoreApplication.laptopArray[i].getBrand().equalsIgnoreCase(brand))
                    &&  ("All".equalsIgnoreCase(price) ||
                    LaptopStoreApplication.laptopArray[i].getPriceRange().equalsIgnoreCase(priceRange))
                    &&  ("All".equalsIgnoreCase(type) ||
                    LaptopStoreApplication.laptopArray[i].getType().equalsIgnoreCase(type))
                    &&  ("All".equalsIgnoreCase(cpu) ||
                    LaptopStoreApplication.laptopArray[i].getCpuBrand().equalsIgnoreCase(cpu))
                    &&  ("All".equalsIgnoreCase(ram) ||
                    String.valueOf(LaptopStoreApplication.laptopArray[i].getRam()).equalsIgnoreCase(ram))
                    &&  ("All".equalsIgnoreCase(ssd) ||
                    String.valueOf(LaptopStoreApplication.laptopArray[i].getSsd()).equalsIgnoreCase(ssd))
                    &&  ("All".equalsIgnoreCase(gpu) ||
                    LaptopStoreApplication.laptopArray[i].getGpuBrand().equalsIgnoreCase(gpu))
            ){

                indexList.addElement(i);

            }

        }

        searchResult = new Laptop[indexList.getSize()];

        for (int i = 0; i < searchResult.length; i++) {

            searchResult[i] = LaptopStoreApplication.laptopArray[indexList.getElementAt(i)];

        }

        updateLaptopImageList(searchResult);

        String[] InfoList = {
                "<html></html>",
                "<html>Search Result :<i><b><u> "+searchResult.length+" </u></b></i> product(s) matched.</html>",
                "<html>======================================</html>"
        };
        laptopInfoList.setListData(InfoList);

        // JOptionPane.showMessageDialog(this, brand+price+type+cpu+ram+ssd+gpu);
//			JOptionPane.showMessageDialog(this, s);

    }

    private void updateLaptopImageList(Laptop[] laptopArray) throws IOException {

        ImageIcon[] ImageIconList = new ImageIcon[laptopArray.length];

        for(int i=0;i<laptopArray.length;i++) {

//			ImageIconList[i] = new ImageIcon(laptopArray[i].getImageIcon().getImage().getScaledInstance(240, 210, 0));
            ImageIconList[i] = laptopArray[i].getResizedLaptopImageForResultsFrame();

        }

        laptopImageList.setListData(ImageIconList);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

            //show a dialog box with text to help the user of the application
            //https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/dialog.html#:~:text=The%20JDialog%20class%20is%20a,very%20similar%20to%20using%20JFrame%20.
            //the dialog box is in a method in the education frame
            //call the method for the help message
            LaptopStoreEducationFrame.helpMessageBox();

        }
    }

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
            //&& !this.isVisible() makes sure that the current frame is not shown

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

}