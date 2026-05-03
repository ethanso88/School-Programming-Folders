package Controller;

import View.TitleFrame;
import View.SearchFrame;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import Model.*;
import Model.Material;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

//main controller for the nanomaterials database app
//handles loading data, switching between title and search screens, and filter logic
public class MainNanoDatabaseController {
    //fields for the main frames and all the material lists
    private TitleFrame titleFrame;
    private SearchFrame searchFrame;
    private ArrayList<Nanotube> nanotubes;
    private ArrayList<Nanoparticle> nanoparticles;
    private ArrayList<Nanofiber> nanofibers;
    private ArrayList<Nanowire> nanowires;
    private ArrayList<Graphene> graphenes;
    private ArrayList<Fullerene> fullerenes;
    private ArrayList<QuantumDot> quantumDots;
    private FileInputController fileInputController;

    //constructor sets up all the lists and loads the data
    public MainNanoDatabaseController() {
        nanotubes = new ArrayList<>();
        nanoparticles = new ArrayList<>();
        nanofibers = new ArrayList<>();
        nanowires = new ArrayList<>();
        graphenes = new ArrayList<>();
        fullerenes = new ArrayList<>();
        quantumDots = new ArrayList<>();
        setupFileInput();
        setup();
    }

    //loads all the data from the file input controller into the lists
    private void setupFileInput() {
        fileInputController = new FileInputController();
        
        nanotubes = new ArrayList<>();
        nanotubes.addAll(fileInputController.getNanotubesSingleWalled());
        nanotubes.addAll(fileInputController.getNanotubesMultiWalled());

        nanoparticles = new ArrayList<>();
        nanoparticles.addAll(fileInputController.getNanoparticlesElements());
        nanoparticles.addAll(fileInputController.getNanoparticlesBinary());
        nanoparticles.addAll(fileInputController.getNanoparticlesComplex());

        nanofibers = fileInputController.getNanofibers();
        nanowires = fileInputController.getNanowires();
        graphenes = fileInputController.getGraphenes();
        fullerenes = fileInputController.getFullerenes();
        quantumDots = fileInputController.getQuantumDots();
    }

    //sets up the title frame and its listeners
    public void setup() {
        titleFrame = new TitleFrame();
        titleFrame.getSearchBar().addActionListener(e -> initialSearch());
        titleFrame.getHelpButton().addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Help info here!");
        });
        defaultFilterLinks();
    }

    //calculates min and max values for all sliders based on the data
    private double[] calculateMinMaxValues() {
        double minDiameter = Double.MAX_VALUE, maxDiameter = Double.MIN_VALUE;
        for (Nanotube n : nanotubes) {
            if (!Double.isNaN(n.getDiameter())) {
                minDiameter = Math.min(minDiameter, n.getDiameter());
                maxDiameter = Math.max(maxDiameter, n.getDiameter());
            }
        }
        for (Nanoparticle n : nanoparticles) {
            if (!Double.isNaN(n.getDiameter())) {
                minDiameter = Math.min(minDiameter, n.getDiameter());
                maxDiameter = Math.max(maxDiameter, n.getDiameter());
            }
        }
        for (Nanofiber n : nanofibers) {
            if (!Double.isNaN(n.getDiameter())) {
                minDiameter = Math.min(minDiameter, n.getDiameter());
                maxDiameter = Math.max(maxDiameter, n.getDiameter());
            }
        }
        for (Nanowire n : nanowires) {
            if (!Double.isNaN(n.getDiameter())) {
                minDiameter = Math.min(minDiameter, n.getDiameter());
                maxDiameter = Math.max(maxDiameter, n.getDiameter());
            }
        }

        double minThickness = Double.MAX_VALUE, maxThickness = Double.MIN_VALUE;
        for (Graphene g : graphenes) {
            minThickness = Math.min(minThickness, g.getThickness());
            maxThickness = Math.max(maxThickness, g.getThickness());
        }

        int minAtoms = Integer.MAX_VALUE, maxAtoms = Integer.MIN_VALUE;
        for (Fullerene f : fullerenes) {
            minAtoms = Math.min(minAtoms, (int)f.getAtoms());
            maxAtoms = Math.max(maxAtoms, (int)f.getAtoms());
        }

        double minEmission = Double.MAX_VALUE, maxEmission = Double.MIN_VALUE;
        for (QuantumDot q : quantumDots) {
            minEmission = Math.min(minEmission, q.getEmissionPeak());
            maxEmission = Math.max(maxEmission, q.getEmissionPeak());
        }

        // If no valid data found, set reasonable defaults
        if (minDiameter == Double.MAX_VALUE) minDiameter = 0;
        if (maxDiameter == Double.MIN_VALUE) maxDiameter = 100;
        if (minThickness == Double.MAX_VALUE) minThickness = 0;
        if (maxThickness == Double.MIN_VALUE) maxThickness = 100;
        if (minAtoms == Integer.MAX_VALUE) minAtoms = 0;
        if (maxAtoms == Integer.MIN_VALUE) maxAtoms = 100;
        if (minEmission == Double.MAX_VALUE) minEmission = 0;
        if (maxEmission == Double.MIN_VALUE) maxEmission = 100;

        return new double[] {
            minDiameter, maxDiameter,
            minThickness, maxThickness,
            minAtoms, maxAtoms,
            minEmission, maxEmission
        };
    }

    //this is called when the user searches from the title screen
    //it sets up the search frame and filters the materials
    public void initialSearch() {
        String text = titleFrame.getSearchBar().getText().trim();
        String searchText = text.toLowerCase();
        if (text.isEmpty() || text.equalsIgnoreCase("Enter Material Here")) {
            double[] values = calculateMinMaxValues();
            SearchFrame searchFrame = new SearchFrame(
                values[0], values[1],  // min/max diameter
                values[2], values[3],  // min/max thickness
                (int)values[4], (int)values[5],  // min/max atoms
                values[6], values[7]   // min/max emission
            );
            setupSearchFrameListeners(searchFrame);
            titleFrame.dispose();

            JCheckBox[] materialTypeCheckboxes = searchFrame.getMaterialTypeCheckboxes();
            for (JCheckBox cb : materialTypeCheckboxes) {
                cb.setSelected(true);
            }

            List<Material> allMaterials = new ArrayList<>();
            allMaterials.addAll(nanotubes);
            allMaterials.addAll(nanoparticles);
            allMaterials.addAll(nanofibers);
            allMaterials.addAll(nanowires);
            allMaterials.addAll(graphenes);
            allMaterials.addAll(fullerenes);
            allMaterials.addAll(quantumDots);

            allMaterials.sort(Comparator.comparing(Material::getName, String.CASE_INSENSITIVE_ORDER));

            new SearchController(searchFrame, allMaterials);
        } else {
            double minDiameter = Double.MAX_VALUE, maxDiameter = Double.MIN_VALUE;
            for (Nanotube n : nanotubes) {
                if (!Double.isNaN(n.getDiameter())) {
                    minDiameter = Math.min(minDiameter, n.getDiameter());
                    maxDiameter = Math.max(maxDiameter, n.getDiameter());
                }
            }
            for (Nanoparticle n : nanoparticles) {
                if (!Double.isNaN(n.getDiameter())) {
                    minDiameter = Math.min(minDiameter, n.getDiameter());
                    maxDiameter = Math.max(maxDiameter, n.getDiameter());
                }
            }
            for (Nanofiber n : nanofibers) {
                if (!Double.isNaN(n.getDiameter())) {
                    minDiameter = Math.min(minDiameter, n.getDiameter());
                    maxDiameter = Math.max(maxDiameter, n.getDiameter());
                }
            }
            for (Nanowire n : nanowires) {
                if (!Double.isNaN(n.getDiameter())) {
                    minDiameter = Math.min(minDiameter, n.getDiameter());
                    maxDiameter = Math.max(maxDiameter, n.getDiameter());
                }
            }

            double minThickness = Double.MAX_VALUE, maxThickness = Double.MIN_VALUE;
            for (Graphene g : graphenes) {
                minThickness = Math.min(minThickness, g.getThickness());
                maxThickness = Math.max(maxThickness, g.getThickness());
            }

            int minAtoms = Integer.MAX_VALUE, maxAtoms = Integer.MIN_VALUE;
            for (Fullerene f : fullerenes) {
                minAtoms = Math.min(minAtoms, (int)f.getAtoms());
                maxAtoms = Math.max(maxAtoms, (int)f.getAtoms());
            }

            double minEmission = Double.MAX_VALUE, maxEmission = Double.MIN_VALUE;
            for (QuantumDot q : quantumDots) {
                minEmission = Math.min(minEmission, q.getEmissionPeak());
                maxEmission = Math.max(maxEmission, q.getEmissionPeak());
            }

            if (minDiameter == Double.MAX_VALUE) minDiameter = 0;
            if (maxDiameter == Double.MIN_VALUE) maxDiameter = 100;
            if (minThickness == Double.MAX_VALUE) minThickness = 0;
            if (maxThickness == Double.MIN_VALUE) maxThickness = 100;
            if (minAtoms == Integer.MAX_VALUE) minAtoms = 0;
            if (maxAtoms == Integer.MIN_VALUE) maxAtoms = 100;
            if (minEmission == Double.MAX_VALUE) minEmission = 0;
            if (maxEmission == Double.MIN_VALUE) maxEmission = 100;

            searchFrame = new SearchFrame(
                minDiameter, maxDiameter,
                minThickness, maxThickness,
                minAtoms, maxAtoms,
                minEmission, maxEmission
            );
            setupSearchFrameListeners(searchFrame);
            titleFrame.dispose();

            JCheckBox[] materialTypeCheckboxes = searchFrame.getMaterialTypeCheckboxes();
            for (JCheckBox cb : materialTypeCheckboxes) {
                cb.setSelected(true);
            }

            JCheckBox[] materialTypeCheckboxes2 = searchFrame.getMaterialTypeCheckboxes();
            if (materialTypeCheckboxes2 != null) {
                for (JCheckBox cb : materialTypeCheckboxes2) {
                    if (cb != null) cb.setSelected(false);
                }
            }
            if (searchFrame.getSizeRadio() != null) searchFrame.getSizeRadio().setSelected(false);
            if (searchFrame.getThicknessRadio() != null) searchFrame.getThicknessRadio().setSelected(false);
            if (searchFrame.getAtomsRadio() != null) searchFrame.getAtomsRadio().setSelected(false);
            if (searchFrame.getEmissionRadio() != null) searchFrame.getEmissionRadio().setSelected(false);
            if (searchFrame.getMinSlider() != null && searchFrame.getMaxSlider() != null) {
                searchFrame.getMinSlider().setValue(searchFrame.getMinSlider().getMinimum());
                searchFrame.getMaxSlider().setValue(searchFrame.getMaxSlider().getMaximum());
            }
            JRadioButton[] nanotubeRadios = searchFrame.getNanotubeRadios();
            if (nanotubeRadios != null) {
                for (JRadioButton rb : nanotubeRadios) {
                    if (rb != null) rb.setSelected(false);
                }
            }
            JCheckBox[] nanotubeConfigCheckboxes = searchFrame.getNanotubeConfigCheckboxes();
            if (nanotubeConfigCheckboxes != null) {
                for (JCheckBox cb : nanotubeConfigCheckboxes) {
                    if (cb != null) cb.setSelected(false);
                }
            }
            if (searchFrame.getNanoparticleAllRadio() != null) searchFrame.getNanoparticleAllRadio().setSelected(false);
            if (searchFrame.getNanoparticleElementRadio() != null) searchFrame.getNanoparticleElementRadio().setSelected(false);
            if (searchFrame.getNanoparticleCompoundRadio() != null) searchFrame.getNanoparticleCompoundRadio().setSelected(false);
            JCheckBox[] quantumDotSolventCheckboxes = searchFrame.getQuantumDotSolventCheckboxes();
            if (quantumDotSolventCheckboxes != null) {
                for (JCheckBox cb : quantumDotSolventCheckboxes) {
                    if (cb != null) cb.setSelected(false);
                }
            }

            boolean filterMatched = false;

            if (materialTypeCheckboxes != null) {
                for (JCheckBox box : materialTypeCheckboxes) {
                    if (box != null) {
                        String boxText = box.getText().toLowerCase();
                        if (boxText.contains(searchText) && !searchText.isEmpty()) {
                            box.setSelected(true);
                            filterMatched = true;
                        }
                    }
                }
            }

            if (searchFrame.getSizeRadio() != null && searchText.contains("size")) {
                searchFrame.getSizeRadio().setSelected(true);
                filterMatched = true;
            }
            if (searchFrame.getThicknessRadio() != null && searchText.contains("thickness")) {
                searchFrame.getThicknessRadio().setSelected(true);
                filterMatched = true;
            }
            if (searchFrame.getAtomsRadio() != null && searchText.contains("atom")) {
                searchFrame.getAtomsRadio().setSelected(true);
                filterMatched = true;
            }
            if (searchFrame.getEmissionRadio() != null && (searchText.contains("emission") || searchText.contains("peak"))) {
                searchFrame.getEmissionRadio().setSelected(true);
                filterMatched = true;
            }

            List<Material> filteredMaterials = new ArrayList<>();
            for (Material m : getAllMaterials()) {
                String name = m.getName() != null ? m.getName().toLowerCase() : "";
                String company = m.getCompany() != null ? m.getCompany().toLowerCase() : "";
                if (filterMatched) {
                    filteredMaterials.add(m);
                } else if (name.contains(searchText) || company.contains(searchText)) {
                    filteredMaterials.add(m);
                }
            }

            filteredMaterials.sort(Comparator.comparing(Material::getName, String.CASE_INSENSITIVE_ORDER));

            SearchFrame searchFrame = new SearchFrame(
                minDiameter, maxDiameter,
                minThickness, maxThickness,
                minAtoms, maxAtoms,
                minEmission, maxEmission
            );
            new SearchController(searchFrame, filteredMaterials);
            titleFrame.dispose();
        }
    }

    //sets up the default filter buttons on the title screen
    public void defaultFilterLinks() {
        JButton[] filterButtons = titleFrame.getFilterButtons();
        for (int i = 0; i < filterButtons.length; i++) {
            final int index = i;
            filterButtons[i].addActionListener(e -> {
                double minDiameter = Double.MAX_VALUE, maxDiameter = Double.MIN_VALUE;
                for (Nanotube n : nanotubes) {
                    minDiameter = Math.min(minDiameter, n.getDiameter());
                    maxDiameter = Math.max(maxDiameter, n.getDiameter());
                }
                for (Nanoparticle n : nanoparticles) {
                    minDiameter = Math.min(minDiameter, n.getDiameter());
                    maxDiameter = Math.max(maxDiameter, n.getDiameter());
                }
                for (Nanofiber n : nanofibers) {
                    minDiameter = Math.min(minDiameter, n.getDiameter());
                    maxDiameter = Math.max(maxDiameter, n.getDiameter());
                }
                for (Nanowire n : nanowires) {
                    minDiameter = Math.min(minDiameter, n.getDiameter());
                    maxDiameter = Math.max(maxDiameter, n.getDiameter());
                }

                double minThickness = Double.MAX_VALUE, maxThickness = Double.MIN_VALUE;
                for (Graphene g : graphenes) {
                    minThickness = Math.min(minThickness, g.getThickness());
                    maxThickness = Math.max(maxThickness, g.getThickness());
                }

                int minAtoms = Integer.MAX_VALUE, maxAtoms = Integer.MIN_VALUE;
                for (Fullerene f : fullerenes) {
                    minAtoms = Math.min(minAtoms, (int)f.getAtoms());
                    maxAtoms = Math.max(maxAtoms, (int)f.getAtoms());
                }

                double minEmission = Double.MAX_VALUE, maxEmission = Double.MIN_VALUE;
                for (QuantumDot q : quantumDots) {
                    minEmission = Math.min(minEmission, q.getEmissionPeak());
                    maxEmission = Math.max(maxEmission, q.getEmissionPeak());
                }

                searchFrame = new SearchFrame(
                    minDiameter, maxDiameter,
                    minThickness, maxThickness,
                    minAtoms, maxAtoms,
                    minEmission, maxEmission
                );
                setupSearchFrameListeners(searchFrame);
                titleFrame.dispose();

                JCheckBox[] materialTypeCheckboxes = searchFrame.getMaterialTypeCheckboxes();
                for (int j = 0; j < materialTypeCheckboxes.length; j++) {
                    materialTypeCheckboxes[j].setSelected(j == index);
                }

                List<Material> filteredMaterials = new ArrayList<>();
                switch (index) {
                    case 0: filteredMaterials.addAll(nanotubes); break;
                    case 1: filteredMaterials.addAll(fullerenes); break;
                    case 2: filteredMaterials.addAll(graphenes); break;
                    case 3: filteredMaterials.addAll(nanoparticles); break;
                    case 4: filteredMaterials.addAll(quantumDots); break;
                    case 5: filteredMaterials.addAll(nanofibers); break;
                    case 6: filteredMaterials.addAll(nanowires); break;
                    default: break;
                }

                filteredMaterials.sort(Comparator.comparing(Material::getName, String.CASE_INSENSITIVE_ORDER));

                new SearchController(searchFrame, filteredMaterials);
            });
        }
    }

    //shows the search frame (not used much)
    public void showSearchFrame() {
        double minDiameter = Double.MAX_VALUE, maxDiameter = Double.MIN_VALUE;
        for (Nanotube n : nanotubes) {
            minDiameter = Math.min(minDiameter, n.getDiameter());
            maxDiameter = Math.max(maxDiameter, n.getDiameter());
        }
        for (Nanoparticle n : nanoparticles) {
            minDiameter = Math.min(minDiameter, n.getDiameter());
            maxDiameter = Math.max(maxDiameter, n.getDiameter());
        }
        for (Nanofiber n : nanofibers) {
            minDiameter = Math.min(minDiameter, n.getDiameter());
            maxDiameter = Math.max(maxDiameter, n.getDiameter());
        }
        for (Nanowire n : nanowires) {
            minDiameter = Math.min(minDiameter, n.getDiameter());
            maxDiameter = Math.max(maxDiameter, n.getDiameter());
        }

        double minThickness = Double.MAX_VALUE, maxThickness = Double.MIN_VALUE;
        for (Graphene g : graphenes) {
            minThickness = Math.min(minThickness, g.getThickness());
            maxThickness = Math.max(maxThickness, g.getThickness());
        }

        int minAtoms = Integer.MAX_VALUE, maxAtoms = Integer.MIN_VALUE;
        for (Fullerene f : fullerenes) {
            minAtoms = Math.min(minAtoms, (int)f.getAtoms());
            maxAtoms = Math.max(maxAtoms, (int)f.getAtoms());
        }

        double minEmission = Double.MAX_VALUE, maxEmission = Double.MIN_VALUE;
        for (QuantumDot q : quantumDots) {
            minEmission = Math.min(minEmission, q.getEmissionPeak());
            maxEmission = Math.max(maxEmission, q.getEmissionPeak());
        }

        SearchFrame searchFrame = new SearchFrame(
            minDiameter, maxDiameter,
            minThickness, maxThickness,
            minAtoms, maxAtoms,
            minEmission, maxEmission
        );
    }

    //sets up listeners for the search frame (exit, help, back)
    public void setupSearchFrameListeners(SearchFrame searchFrame) {
        searchFrame.getExitButton().addActionListener(e -> System.exit(0));
        searchFrame.getHelpButton().addActionListener(e ->
            JOptionPane.showMessageDialog(null, "Help info for using the search frame goes here!")
        );
        searchFrame.getBackButton().addActionListener(e -> {
            searchFrame.dispose();
            setup();
        });
    }
    
    //sets up listeners for the title frame search bar
    public void setupTitleFrameListeners(TitleFrame titleFrame) {
        if (titleFrame.getSearchBar() != null) {
            titleFrame.getSearchBar().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String searchText = titleFrame.getSearchBar().getText().trim().toLowerCase();
                    if (searchText.isEmpty() || searchText.equals("enter material or company here")) return;

                    List<Material> filteredMaterials = new ArrayList<>();
                    for (Material m : getAllMaterials()) {
                        String name = m.getName() != null ? m.getName().toLowerCase() : "";
                        String company = m.getCompany() != null ? m.getCompany().toLowerCase() : "";
                        if (name.contains(searchText) || company.contains(searchText)) {
                            filteredMaterials.add(m);
                        }
                    }

                    double[] values = calculateMinMaxValues();
                    SearchFrame searchFrame = new SearchFrame(
                        values[0], values[1],  // min/max diameter
                        values[2], values[3],  // min/max thickness
                        (int)values[4], (int)values[5],  // min/max atoms
                        values[6], values[7]   // min/max emission
                    );
                    new SearchController(searchFrame, filteredMaterials);
                    titleFrame.dispose();
                }
            });
        }
    }

    //returns a list of all materials
    private List<Material> getAllMaterials() {
        List<Material> all = new ArrayList<>();
        all.addAll(nanotubes);
        all.addAll(fullerenes);
        all.addAll(graphenes);
        all.addAll(nanoparticles);
        all.addAll(quantumDots);
        all.addAll(nanofibers);
        all.addAll(nanowires);
        return all;
    }
}
