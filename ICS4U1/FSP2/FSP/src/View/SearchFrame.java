package View;

import Model.Material;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.border.TitledBorder;

public class SearchFrame {

    private JFrame frame;
    private JTextField searchBar;
    private JButton helpButton;
    private JButton exitButton;
    private JButton backButton;
    private JButton resetFiltersButton;
    private JPanel filterPanel;
    // Removed unused variables:
    // private JSlider yearSlider;
    // private JRadioButton[] radioFilters;
    // private JCheckBox[] boxFilters;
    // private ArrayList<JPanel> materialPanels;

    // Example material names and descriptions
    private static final String[] MATERIALS = {
        "Nanotubes", "Fullerenes", "Graphene", "Nanoparticles", "Quantum Dots", "Nanofibers", "Nanowires"
    };
    private static final String[] DESCRIPTIONS = {
        "Description for Nanotubes",
        "Description for Fullerenes",
        "Description for Graphene",
        "Description for Nanoparticles",
        "Description for Quantum Dots",
        "Description for Nanofibers",
        "Description for Nanowires"
    };

    // Nanotube special filters
    private JRadioButton nanotubeAllRadio, nanotubeSingleRadio, nanotubeMultiRadio;
    private JCheckBox[] nanotubeConfigCheckboxes; // Fill with actual config values

    // Nanoparticle special filters
    private JRadioButton nanoparticleAllRadio, nanoparticleElementRadio, nanoparticleCompoundRadio;

    // Quantum dot special filters
    private JCheckBox[] quantumDotSolventCheckboxes; // Fill with actual solvent values

    private double minDiameter, maxDiameter;
    private double minThickness, maxThickness;
    private int minAtoms, maxAtoms;
    private double minEmission, maxEmission;

    // At the top of SearchFrame.java, as a class field:
    private JCheckBox[] materialTypeCheckboxes;

    // Quantity filter radio buttons
    private JRadioButton sizeRadio;
    private JRadioButton thicknessRadio;
    private JRadioButton atomsRadio;
    private JRadioButton emissionRadio;

    // Sliders for min/max diameter
    private JSlider minSlider;
    private JSlider maxSlider;

    // Value labels for sliders
    private JLabel minLabel;
    private JLabel maxLabel;
    private JLabel minValueLabel;
    private JLabel maxValueLabel;

    // Results panel
    private JPanel resultsPanel;
    private JScrollPane resultsScrollPane;

    private Runnable filtersChangedCallback;

    public SearchFrame(
        double minDiameter, double maxDiameter,
        double minThickness, double maxThickness,
        int minAtoms, int maxAtoms,
        double minEmission, double maxEmission
    ) {
        this.minDiameter = minDiameter;
        this.maxDiameter = maxDiameter;
        this.minThickness = minThickness;
        this.maxThickness = maxThickness;
        this.minAtoms = minAtoms;
        this.maxAtoms = maxAtoms;
        this.minEmission = minEmission;
        this.maxEmission = maxEmission;
        frameSetup();
    }

    private void frameSetup() {
        // Frame Setup
        frame = new JFrame("Nanoscale Material Database Application - Search");
        frame.setSize(1366, 768);
        frame.getContentPane().setBackground(new Color(70, 140, 200)); // lighter blue
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Frame Logo (replace text label with image)
        String logoPath = "Icons/nmda_logo.png"; // Updated path
        java.io.File logoFile = new java.io.File(logoPath);
        if (logoFile.exists()) {
            ImageIcon originalIcon = new ImageIcon(logoPath);
            Image img = originalIcon.getImage();
            int maxDim = 220; // moderate large size to avoid overlap
            int width = originalIcon.getIconWidth();
            int height = originalIcon.getIconHeight();
            double scale = (double) maxDim / Math.max(width, height);
            int scaledWidth = (int) (width * scale);
            int scaledHeight = (int) (height * scale);
            Image scaledImg = img.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            ImageIcon logoIcon = new ImageIcon(scaledImg);
            int padding = 5;
            JLabel logoLabel = new JLabel(logoIcon);
            logoLabel.setBounds(padding, padding, scaledWidth, scaledHeight);
            frame.add(logoLabel);
        } else {
            JLabel titleLabel = new JLabel("NMDA");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
            titleLabel.setForeground(Color.WHITE);
            int padding = 5;
            titleLabel.setBounds(padding, padding, 150, 40);
            frame.add(titleLabel);
        }

        // Search Bar
        searchBar = new JTextField("Enter Material Here");
        searchBar.setFont(new Font("Arial", Font.PLAIN, 18));
        searchBar.setBounds(493, 80, 380, 40);
        frame.add(searchBar);

        // --- Create Buttons ---
        helpButton = new CircularButton("?");
        helpButton.setFont(new Font("Arial", Font.BOLD, 32));
        helpButton.setBackground(Color.WHITE);
        helpButton.setForeground(Color.BLACK);

        backButton = new JButton("Back to Title Frame");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(46, 204, 113)); // Green
        backButton.setForeground(Color.WHITE);

        exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Arial", Font.BOLD, 22));
        exitButton.setBackground(new Color(200, 60, 40)); // Red
        exitButton.setForeground(Color.WHITE);

        // Reset Filters button
        resetFiltersButton = new JButton("Reset Filters");
        resetFiltersButton.setFont(new Font("Arial", Font.BOLD, 14));
        resetFiltersButton.setBackground(Color.WHITE);
        resetFiltersButton.setForeground(Color.BLACK);
        resetFiltersButton.setBounds(240, 10, 140, 40); // Adjust position as needed
        frame.add(resetFiltersButton);

        // --- Align the Buttons Horizontally at Top Right ---
        int frameWidth = 1366;
        int buttonGap = 20;

        // Button sizes
        int helpW = 70, helpH = 70;
        int backW = 180, backH = 50;
        int exitW = 120, exitH = 50;

        int y = 30; // vertical position for all buttons

        // Calculate the starting X for the rightmost button (exit)
        int exitX = frameWidth - 30 - exitW; // 30px right margin
        int backX = exitX - buttonGap - backW;
        int helpX = backX - buttonGap - helpW;

        // Set bounds for each button
        helpButton.setBounds(helpX, y - (helpH - backH) / 2, helpW, helpH); // vertically center help
        backButton.setBounds(backX, y, backW, backH);
        exitButton.setBounds(exitX, y, exitW, exitH);

        // --- Add Buttons to Frame ---
        frame.add(helpButton);
        frame.add(backButton);
        frame.add(exitButton);

        // Filter Panel
        setupFilterPanel();

        // Results Panel (for material mini-panels) as a scroll pane
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        resultsPanel.setBackground(new Color(25, 25, 70));

        resultsScrollPane = new JScrollPane(resultsPanel);
        resultsScrollPane.setBounds(420, 160, 900, 540); // y and height match filterPanel
        frame.add(resultsScrollPane);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void setupFilterPanel() {
        filterPanel = new JPanel();
        filterPanel.setLayout(null);
        filterPanel.setBackground(new Color(15, 15, 60));
        filterPanel.setBounds(40, 160, 350, 540); // Example: x, y, width, height

        int y = 10;

        // --- Material Filters Section ---
        JLabel materialFiltersLabel = new JLabel("Material Filters");
        materialFiltersLabel.setFont(new Font("Arial", Font.BOLD, 16));
        materialFiltersLabel.setForeground(Color.WHITE);
        materialFiltersLabel.setBounds(20, y, 200, 25);
        filterPanel.add(materialFiltersLabel);
        y += 30;

        // Material type checkboxes (Nanotubes, Fullerenes, etc.)
        String[] materialNames = {"Nanotubes", "Fullerenes", "Graphene", "Nanoparticles", "Quantum Dots", "Nanofibers", "Nanowires"};
        materialTypeCheckboxes = new JCheckBox[materialNames.length];
        for (int i = 0; i < materialNames.length; i++) {
            materialTypeCheckboxes[i] = new JCheckBox(materialNames[i]);
            materialTypeCheckboxes[i].setFont(new Font("Arial", Font.PLAIN, 14));
            materialTypeCheckboxes[i].setForeground(Color.WHITE);
            materialTypeCheckboxes[i].setBackground(new Color(15, 15, 60));
            materialTypeCheckboxes[i].setBounds(30, y, 200, 22);
            filterPanel.add(materialTypeCheckboxes[i]);
            y += 25;
        }

        // --- Quantity Filters Section ---
        JLabel quantityFiltersLabel = new JLabel("Quantity Filters");
        quantityFiltersLabel.setFont(new Font("Arial", Font.BOLD, 16));
        quantityFiltersLabel.setForeground(Color.WHITE);
        quantityFiltersLabel.setBounds(20, y, 200, 25);
        filterPanel.add(quantityFiltersLabel);
        y += 30;

        // Radio buttons for quantity filters
        sizeRadio = new JRadioButton("Size");
        sizeRadio.setFont(new Font("Arial", Font.PLAIN, 14));
        sizeRadio.setForeground(Color.WHITE);
        sizeRadio.setBackground(new Color(15, 15, 60));
        sizeRadio.setBounds(30, y, 100, 22);
        filterPanel.add(sizeRadio);
        y += 25;

        thicknessRadio = new JRadioButton("Thickness (graphene)");
        thicknessRadio.setFont(new Font("Arial", Font.PLAIN, 14));
        thicknessRadio.setForeground(Color.WHITE);
        thicknessRadio.setBackground(new Color(15, 15, 60));
        thicknessRadio.setBounds(30, y, 200, 22);
        filterPanel.add(thicknessRadio);
        y += 25;

        atomsRadio = new JRadioButton("Atoms (fullerene)");
        atomsRadio.setFont(new Font("Arial", Font.PLAIN, 14));
        atomsRadio.setForeground(Color.WHITE);
        atomsRadio.setBackground(new Color(15, 15, 60));
        atomsRadio.setBounds(30, y, 200, 22);
        filterPanel.add(atomsRadio);
        y += 25;

        emissionRadio = new JRadioButton("Emission peak (quantum dot)");
        emissionRadio.setFont(new Font("Arial", Font.PLAIN, 14));
        emissionRadio.setForeground(Color.WHITE);
        emissionRadio.setBackground(new Color(15, 15, 60));
        emissionRadio.setBounds(30, y, 250, 22);
        filterPanel.add(emissionRadio);
        y += 30;

        // Group them
        ButtonGroup quantityGroup = new ButtonGroup();
        quantityGroup.add(sizeRadio);
        quantityGroup.add(thicknessRadio);
        quantityGroup.add(atomsRadio);
        quantityGroup.add(emissionRadio);

        // Add change listeners to radio buttons
        sizeRadio.addActionListener(e -> updateSlidersForQuantity("size"));
        thicknessRadio.addActionListener(e -> updateSlidersForQuantity("thickness"));
        atomsRadio.addActionListener(e -> updateSlidersForQuantity("atoms"));
        emissionRadio.addActionListener(e -> updateSlidersForQuantity("emission"));

        // Sliders for min/max (default: diameter)
        minLabel = new JLabel("Min Diameter:");
        minLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        minLabel.setForeground(Color.WHITE);
        minLabel.setBounds(30, y, 100, 20);
        filterPanel.add(minLabel);

        // Initialize sliders with diameter values
        minSlider = new JSlider(JSlider.HORIZONTAL, (int)minDiameter, (int)maxDiameter, (int)minDiameter);
        maxSlider = new JSlider(JSlider.HORIZONTAL, (int)minDiameter, (int)maxDiameter, (int)maxDiameter);

        // Enable painting of ticks and labels
        minSlider.setPaintTicks(true);
        minSlider.setPaintLabels(true);
        maxSlider.setPaintTicks(true);
        maxSlider.setPaintLabels(true);

        // Set major/minor ticks and paint labels
        updateSliderTicks("size");

        minSlider.setBounds(130, y, 180, 40);
        filterPanel.add(minSlider);
        y += 40;

        maxLabel = new JLabel("Max Diameter:");
        maxLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        maxLabel.setForeground(Color.WHITE);
        maxLabel.setBounds(30, y, 100, 20);
        filterPanel.add(maxLabel);

        maxSlider.setBounds(130, y, 180, 40);
        filterPanel.add(maxSlider);
        y += 50;

        // Value labels for sliders
        minValueLabel = new JLabel(String.valueOf(minSlider.getValue()));
        minValueLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        minValueLabel.setForeground(Color.WHITE);
        minValueLabel.setBounds(270, minSlider.getY(), 40, 20);
        filterPanel.add(minValueLabel);

        maxValueLabel = new JLabel(String.valueOf(maxSlider.getValue()));
        maxValueLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        maxValueLabel.setForeground(Color.WHITE);
        maxValueLabel.setBounds(270, maxSlider.getY(), 40, 20);
        filterPanel.add(maxValueLabel);

        // Update these labels when the sliders move:
        minSlider.addChangeListener(e -> {
            int value = minSlider.getValue();
            maxSlider.setMinimum(value); // Ensure max slider can't go below min
            minValueLabel.setText(String.valueOf(value));
            onFiltersChanged();
        });
        maxSlider.addChangeListener(e -> {
            int value = maxSlider.getValue();
            minSlider.setMaximum(value); // Ensure min slider can't go above max
            maxValueLabel.setText(String.valueOf(value));
            onFiltersChanged();
        });

        y += 10;

        // --- Other Filters Section ---
        JLabel otherFiltersLabel = new JLabel("Other Filters");
        otherFiltersLabel.setFont(new Font("Arial", Font.BOLD, 16));
        otherFiltersLabel.setForeground(Color.WHITE);
        otherFiltersLabel.setBounds(20, y, 200, 25);
        filterPanel.add(otherFiltersLabel);
        y += 30;

        // Nanotube subtype radio buttons (vertical layout)
        JLabel nanotubeSubtypeLabel = new JLabel("Nanotube Subtype:");
        nanotubeSubtypeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        nanotubeSubtypeLabel.setForeground(Color.WHITE);
        nanotubeSubtypeLabel.setBounds(30, y, 200, 20);
        filterPanel.add(nanotubeSubtypeLabel);
        y += 20;

        ButtonGroup nanotubeGroup = new ButtonGroup();
        String[] nanotubeRadioLabels = {"All", "Single-walled", "Multi-walled"};
        JRadioButton[] nanotubeRadios = new JRadioButton[nanotubeRadioLabels.length];
        for (int j = 0; j < nanotubeRadioLabels.length; j++) {
            nanotubeRadios[j] = new JRadioButton(nanotubeRadioLabels[j]);
            nanotubeRadios[j].setFont(new Font("Arial", Font.PLAIN, 13));
            nanotubeRadios[j].setForeground(Color.WHITE);
            nanotubeRadios[j].setBackground(new Color(15, 15, 60));
            nanotubeRadios[j].setBounds(40, y, 150, 20); // All on the same x, different y
            nanotubeGroup.add(nanotubeRadios[j]);
            filterPanel.add(nanotubeRadios[j]);
            y += 22; // Move down for next button
        }
        y += 10;

        // Nanotube configuration checkboxes (example values)
        JLabel nanotubeConfigLabel = new JLabel("Nanotube Configurations:");
        nanotubeConfigLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        nanotubeConfigLabel.setForeground(Color.WHITE);
        nanotubeConfigLabel.setBounds(30, y, 200, 20);
        filterPanel.add(nanotubeConfigLabel);
        y += 20;

        String[] nanotubeConfigs = {"Pure", "Filtered", "Functionalized"}; // Add more as needed
        nanotubeConfigCheckboxes = new JCheckBox[nanotubeConfigs.length];
        for (int k = 0; k < nanotubeConfigs.length; k++) {
            nanotubeConfigCheckboxes[k] = new JCheckBox(nanotubeConfigs[k]);
            nanotubeConfigCheckboxes[k].setFont(new Font("Arial", Font.PLAIN, 13));
            nanotubeConfigCheckboxes[k].setForeground(Color.WHITE);
            nanotubeConfigCheckboxes[k].setBackground(new Color(15, 15, 60));
            nanotubeConfigCheckboxes[k].setBounds(40, y, 120, 20);
            filterPanel.add(nanotubeConfigCheckboxes[k]);
            y += 22;
        }

        y += 10;

        // Nanoparticle subtype radio buttons
        JLabel nanoparticleSubtypeLabel = new JLabel("Nanoparticle Subtype:");
        nanoparticleSubtypeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        nanoparticleSubtypeLabel.setForeground(Color.WHITE);
        nanoparticleSubtypeLabel.setBounds(30, y, 200, 20);
        filterPanel.add(nanoparticleSubtypeLabel);
        y += 20;

        ButtonGroup nanoparticleGroup = new ButtonGroup();
        nanoparticleAllRadio = new JRadioButton("All");
        nanoparticleElementRadio = new JRadioButton("Element");
        nanoparticleCompoundRadio = new JRadioButton("Compound");
        JRadioButton[] nanoparticleRadios = {nanoparticleAllRadio, nanoparticleElementRadio, nanoparticleCompoundRadio};
        String[] nanoparticleRadioLabels = {"All", "Element", "Compound"};
        for (int m = 0; m < nanoparticleRadios.length; m++) {
            nanoparticleRadios[m].setText(nanoparticleRadioLabels[m]);
            nanoparticleRadios[m].setFont(new Font("Arial", Font.PLAIN, 13));
            nanoparticleRadios[m].setForeground(Color.WHITE);
            nanoparticleRadios[m].setBackground(new Color(15, 15, 60));
            nanoparticleRadios[m].setBounds(40 + m * 90, y, 90, 20);
            nanoparticleGroup.add(nanoparticleRadios[m]);
            filterPanel.add(nanoparticleRadios[m]);
        }
        y += 25;

        // Quantum dot solvent checkboxes (example values)
        JLabel quantumDotSolventLabel = new JLabel("Quantum Dot Solvents:");
        quantumDotSolventLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        quantumDotSolventLabel.setForeground(Color.WHITE);
        quantumDotSolventLabel.setBounds(30, y, 200, 20);
        filterPanel.add(quantumDotSolventLabel);
        y += 20;

        String[] quantumDotSolvents = {"Water", "Toluene", "Hexane"}; // Replace with actual solvents
        quantumDotSolventCheckboxes = new JCheckBox[quantumDotSolvents.length];
        for (int n = 0; n < quantumDotSolvents.length; n++) {
            quantumDotSolventCheckboxes[n] = new JCheckBox(quantumDotSolvents[n]);
            quantumDotSolventCheckboxes[n].setFont(new Font("Arial", Font.PLAIN, 13));
            quantumDotSolventCheckboxes[n].setForeground(Color.WHITE);
            quantumDotSolventCheckboxes[n].setBackground(new Color(15, 15, 60));
            quantumDotSolventCheckboxes[n].setBounds(40, y, 120, 20);
            filterPanel.add(quantumDotSolventCheckboxes[n]);
            y += 22;
        }

        // If the panel is too tall, use a scroll pane
        filterPanel.setPreferredSize(new Dimension(350, y + 30));
        JScrollPane filterScrollPane = new JScrollPane(filterPanel);
        filterScrollPane.setBounds(40, 160, 350, 540);
        filterScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        filterScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Add to frame (replace old filterPanel.add)
        frame.add(filterScrollPane);
    }

    private void updateSlidersForQuantity(String quantity) {
        double min, max;
        String label;
        
        switch (quantity) {
            case "size":
                min = minDiameter;
                max = maxDiameter;
                label = "Diameter";
                break;
            case "thickness":
                min = minThickness;
                max = maxThickness;
                label = "Thickness";
                break;
            case "atoms":
                min = minAtoms;
                max = maxAtoms;
                label = "Atoms";
                break;
            case "emission":
                min = minEmission;
                max = maxEmission;
                label = "Emission";
                break;
            default:
                return;
        }

        // Store current relative positions
        double minRatio = (double)(minSlider.getValue() - minSlider.getMinimum()) / 
                         (minSlider.getMaximum() - minSlider.getMinimum());
        double maxRatio = (double)(maxSlider.getValue() - maxSlider.getMinimum()) / 
                         (maxSlider.getMaximum() - maxSlider.getMinimum());

        // Update slider ranges
        minSlider.setMinimum((int)min);
        minSlider.setMaximum((int)max);
        maxSlider.setMinimum((int)min);
        maxSlider.setMaximum((int)max);

        // Restore relative positions
        minSlider.setValue((int)(min + minRatio * (max - min)));
        maxSlider.setValue((int)(min + maxRatio * (max - min)));

        // Update labels
        minLabel.setText("Min " + label + ":");
        maxLabel.setText("Max " + label + ":");

        // Update tick spacing
        updateSliderTicks(quantity);

        // Trigger filter update
        onFiltersChanged();
    }

    private void updateSliderTicks(String quantity) {
        int range = 0;
        switch (quantity) {
            case "size":
                range = (int)(maxDiameter - minDiameter);
                break;
            case "thickness":
                range = (int)(maxThickness - minThickness);
                break;
            case "atoms":
                range = maxAtoms - minAtoms;
                break;
            case "emission":
                range = (int)(maxEmission - minEmission);
                break;
        }

        // Calculate appropriate tick spacing based on range
        int majorTickSpacing = Math.max(1, range / 10);
        int minorTickSpacing = Math.max(1, majorTickSpacing / 5);

        // Create a dictionary for the labels
        java.util.Dictionary<Integer, JLabel> labelTable = new java.util.Hashtable<>();
        for (int i = (int)minSlider.getMinimum(); i <= (int)minSlider.getMaximum(); i += majorTickSpacing) {
            labelTable.put(i, new JLabel(String.valueOf(i)));
        }

        minSlider.setLabelTable(labelTable);
        maxSlider.setLabelTable(labelTable);
        
        minSlider.setMajorTickSpacing(majorTickSpacing);
        minSlider.setMinorTickSpacing(minorTickSpacing);
        maxSlider.setMajorTickSpacing(majorTickSpacing);
        maxSlider.setMinorTickSpacing(minorTickSpacing);
    }

    // Reuse the CircularButton class from TitleFrame
    private static class CircularButton extends JButton {
        public CircularButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillOval(0, 0, getWidth(), getHeight());
            g2.setColor(getForeground());
            g2.setFont(getFont());
            FontMetrics fm = g2.getFontMetrics();
            int stringWidth = fm.stringWidth(getText());
            int stringHeight = fm.getAscent();
            g2.drawString(getText(), (getWidth() - stringWidth) / 2, (getHeight() + stringHeight) / 2 - 4);
            g2.dispose();
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(2));
            g2.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
            g2.dispose();
        }

        @Override
        public boolean contains(int x, int y) {
            int radius = getWidth() / 2;
            int centerX = radius;
            int centerY = getHeight() / 2;
            return Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2) <= Math.pow(radius, 2);
        }
    }

    public JTextField getSearchBar() { return searchBar; }
    public JButton getHelpButton() { return helpButton; }
    public JButton getExitButton() { return exitButton; }
    public JButton getBackButton() { return backButton; }
    public JButton getResetFiltersButton() { return resetFiltersButton; }
    public JCheckBox[] getMaterialTypeCheckboxes() {
        return materialTypeCheckboxes;
    }

    // Quantity filter radio buttons
    public JRadioButton getSizeRadio() { return sizeRadio; }
    public JRadioButton getThicknessRadio() { return thicknessRadio; }
    public JRadioButton getAtomsRadio() { return atomsRadio; }
    public JRadioButton getEmissionRadio() { return emissionRadio; }

    public JSlider getMinDiameterSlider() {
        return minSlider;
    }

    public JSlider getMaxDiameterSlider() {
        return maxSlider;
    }

    // If you want just the values:
    public double getMinSliderValue() {
        return minSlider.getValue();
    }

    public double getMaxSliderValue() {
        return maxSlider.getValue();
    }

    // Add any other getters you need for your controller logic

    public void dispose() {
        frame.dispose();
    }

    public void showSliders(boolean show) {
        minLabel.setVisible(show);
        maxLabel.setVisible(show);
        minSlider.setVisible(show);
        maxSlider.setVisible(show);
        // If you have min/max value labels, add them too:
        if (minValueLabel != null) minValueLabel.setVisible(show);
        if (maxValueLabel != null) maxValueLabel.setVisible(show);
    }

    // Remove all material boxes from the results panel
    public void clearResultsPanel() {
        resultsPanel.removeAll();
    }

    // Add a material box to the results panel
    public void addToResultsPanel(JPanel materialBox) {
        resultsPanel.add(materialBox);
    }

    // Refresh the results panel UI
    public void refreshResultsPanel() {
        resultsPanel.revalidate();
        resultsPanel.repaint();
    }

    // Display a list of materials in the results panel
    public void displayMaterials(List<Material> materials) {
        clearResultsPanel();
        System.out.println("Displaying " + materials.size() + " materials"); // debug
        for (Material m : materials) {
            JPanel materialBox = createMaterialBox(m);
            addToResultsPanel(materialBox);
        }
        refreshResultsPanel();
    }

    // Example: create a JPanel for a material
    public JPanel createMaterialBox(Material m) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(25, 25, 70));
        panel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 1));
        panel.setPreferredSize(new Dimension(840, 80));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Material type (e.g., Nanoparticle)
        String type = m.getClass().getSimpleName();
        JLabel typeLabel = new JLabel(type);
        typeLabel.setFont(new Font("Arial", Font.BOLD, 12));
        typeLabel.setForeground(Color.CYAN);
        typeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(typeLabel);

        // Name (bold, white)
        JLabel nameLabel = new JLabel(m.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(nameLabel);

        // Company (regular, light gray)
        JLabel companyLabel = new JLabel(m.getCompany());
        companyLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        companyLabel.setForeground(Color.LIGHT_GRAY);
        companyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(companyLabel);

        // Properties (custom for each subclass)
        StringBuilder props = new StringBuilder("<html>");
        if (m instanceof Model.Nanotube n) {
            props.append("Diameter: ").append(n.getDiameter()).append(" nm");
            props.append(", Specification: ").append(n.getSpecification());
            props.append(", Subtype: ").append(n.getSubtype());
            props.append(", Configuration: ").append(n.getConfiguration());
        } else if (m instanceof Model.Nanoparticle np) {
            props.append("Diameter: ").append(np.getDiameter()).append(" nm");
            props.append(", Specification: ").append(np.getSpecification());
            props.append(", Subtype: ").append(np.getSubtype());
        } else if (m instanceof Model.Nanofiber nf) {
            props.append("Diameter: ").append(nf.getDiameter()).append(" nm");
        } else if (m instanceof Model.Nanowire nw) {
            props.append("Diameter: ").append(nw.getDiameter()).append(" nm");
        } else if (m instanceof Model.Graphene g) {
            props.append("Thickness: ").append(g.getThickness()).append(" nm");
            props.append(", Specification: ").append(g.getSpecification());
        } else if (m instanceof Model.Fullerene f) {
            props.append("Atoms: ").append(f.getAtoms());
            props.append(", Specification: ").append(f.getSpecification());
        } else if (m instanceof Model.QuantumDot qd) {
            props.append("Emission Peak: ").append(qd.getEmissionPeak()).append(" nm");
            props.append(", Solvent: ").append(qd.getSolvent());
            props.append(", Specification: ").append(qd.getSpecification());
        }
        props.append("</html>");

        JLabel propsLabel = new JLabel(props.toString());
        propsLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        propsLabel.setForeground(Color.LIGHT_GRAY);
        propsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        propsLabel.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        panel.add(propsLabel);

        return panel;
    }

    public void setFiltersChangedCallback(Runnable callback) { this.filtersChangedCallback = callback; }
    private void onFiltersChanged() { if (filtersChangedCallback != null) filtersChangedCallback.run(); }

    public JSlider getMinSlider() { return minSlider; }
    public JSlider getMaxSlider() { return maxSlider; }
    // For Nanotube subtype radios:
    public JRadioButton[] getNanotubeRadios() { 
        return new JRadioButton[] { nanotubeAllRadio, nanotubeSingleRadio, nanotubeMultiRadio }; 
    }
    public JCheckBox[] getNanotubeConfigCheckboxes() { return nanotubeConfigCheckboxes; }
    public JRadioButton getNanoparticleAllRadio() { return nanoparticleAllRadio; }
    public JRadioButton getNanoparticleElementRadio() { return nanoparticleElementRadio; }
    public JRadioButton getNanoparticleCompoundRadio() { return nanoparticleCompoundRadio; }
    public JCheckBox[] getQuantumDotSolventCheckboxes() { return quantumDotSolventCheckboxes; }

}