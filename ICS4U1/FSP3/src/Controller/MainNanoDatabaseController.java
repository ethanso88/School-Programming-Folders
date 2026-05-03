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

public class MainNanoDatabaseController {
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

    public void setup() {
        titleFrame = new TitleFrame();
        titleFrame.getSearchBar().addActionListener(e -> initialSearch());
        titleFrame.getHelpButton().addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Help info here!");
        });
        defaultFilterLinks();
    }

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

    public void initialSearch() {
        String text = titleFrame.getSearchBar().getText().trim();
        String searchText = text.toLowerCase();
        
        double[] values = calculateMinMaxValues();
        SearchFrame searchFrame = new SearchFrame(
            values[0], values[1],  // min/max diameter
            values[2], values[3],  // min/max thickness
            (int)values[4], (int)values[5],  // min/max atoms
            values[6], values[7]   // min/max emission
        );
        setupSearchFrameListeners(searchFrame);
        titleFrame.dispose();

        // Select all material type checkboxes by default
        JCheckBox[] materialTypeCheckboxes = searchFrame.getMaterialTypeCheckboxes();
        if (materialTypeCheckboxes != null) {
            for (JCheckBox cb : materialTypeCheckboxes) {
                if (cb != null) cb.setSelected(true);
            }
        }

        // Call updateList() to show all materials
        new SearchController(searchFrame, getAllMaterials());
    }

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
