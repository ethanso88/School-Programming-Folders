package Controller;

import Model.*;
import View.SearchFrame;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchController {
    private final SearchFrame searchFrame;
    private final List<Material> allMaterials;

    public SearchController(SearchFrame searchFrame, List<Material> allMaterials) {
        this.searchFrame = searchFrame;
        this.allMaterials = allMaterials;
        setupFilterListeners();
        updateList(); // Initial display
    }

    private void setupFilterListeners() {
        // Material type checkboxes
        JCheckBox[] typeBoxes = searchFrame.getMaterialTypeCheckboxes();
        if (typeBoxes != null) {
            for (int i = 0; i < typeBoxes.length; i++) {
                if (typeBoxes[i] != null) {
                    typeBoxes[i].addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            updateList();
                        }
                    });
                }
            }
        }

        // Size radio
        if (searchFrame.getSizeRadio() != null) {
            searchFrame.getSizeRadio().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JCheckBox[] typeBoxes = searchFrame.getMaterialTypeCheckboxes();
                    if (typeBoxes != null) {
                        for (JCheckBox box : typeBoxes) {
                            if (box != null) {
                                String text = box.getText().toLowerCase();
                                if (text.contains("nanotube") || text.contains("nanoparticle") ||
                                        text.contains("nanofiber") || text.contains("nanowire")) {
                                    box.setSelected(true);
                                } else {
                                    box.setSelected(false);
                                }
                            }
                        }
                    }
                    updateList();
                }
            });
        }

        // Thickness (only Graphene) radio
        if (searchFrame.getThicknessRadio() != null) {
            searchFrame.getThicknessRadio().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JCheckBox[] typeBoxes = searchFrame.getMaterialTypeCheckboxes();
                    if (typeBoxes != null) {
                        for (JCheckBox box : typeBoxes) {
                            if (box != null) {
                                String text = box.getText().toLowerCase();
                                if (text.contains("graphene")) {
                                    box.setSelected(true);
                                } else {
                                    box.setSelected(false);
                                }
                            }
                        }
                    }
                    updateList();
                }
            });
        }

        // Atoms (only Fullerene) radio
        if (searchFrame.getAtomsRadio() != null) {
            searchFrame.getAtomsRadio().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JCheckBox[] typeBoxes = searchFrame.getMaterialTypeCheckboxes();
                    if (typeBoxes != null) {
                        for (JCheckBox box : typeBoxes) {
                            if (box != null) {
                                String text = box.getText().toLowerCase();
                                if (text.contains("fullerene")) {
                                    box.setSelected(true);
                                } else {
                                    box.setSelected(false);
                                }
                            }
                        }
                    }
                    updateList();
                }
            });
        }

        // Emission peak (only Quantum Dot) radio
        if (searchFrame.getEmissionRadio() != null) {
            searchFrame.getEmissionRadio().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JCheckBox[] typeBoxes = searchFrame.getMaterialTypeCheckboxes();
                    if (typeBoxes != null) {
                        for (JCheckBox box : typeBoxes) {
                            if (box != null) {
                                String text = box.getText().toLowerCase();
                                if (text.contains("quantum")) {
                                    box.setSelected(true);
                                } else {
                                    box.setSelected(false);
                                }
                            }
                        }
                    }
                    updateList();
                }
            });
        }

        // Sliders
        if (searchFrame.getMinSlider() != null) {
            searchFrame.getMinSlider().addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(javax.swing.event.ChangeEvent e) {
                    updateList();
                }
            });
        }
        if (searchFrame.getMaxSlider() != null) {
            searchFrame.getMaxSlider().addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(javax.swing.event.ChangeEvent e) {
                    updateList();
                }
            });
        }

        // Nanotube subtype radios
        JRadioButton[] nanotubeRadios = searchFrame.getNanotubeRadios();
        if (nanotubeRadios != null) {
            for (int i = 0; i < nanotubeRadios.length; i++) {
                if (nanotubeRadios[i] != null) {
                    nanotubeRadios[i].addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            updateList();
                        }
                    });
                }
            }
        }

        // Nanotube config checkboxes
        JCheckBox[] nanotubeConfigCheckboxes = searchFrame.getNanotubeConfigCheckboxes();
        if (nanotubeConfigCheckboxes != null) {
            for (int i = 0; i < nanotubeConfigCheckboxes.length; i++) {
                if (nanotubeConfigCheckboxes[i] != null) {
                    nanotubeConfigCheckboxes[i].addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            updateList();
                        }
                    });
                }
            }
        }

        // Nanoparticle subtype radios
        if (searchFrame.getNanoparticleAllRadio() != null) {
            searchFrame.getNanoparticleAllRadio().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    updateList();
                }
            });
        }
        if (searchFrame.getNanoparticleElementRadio() != null) {
            searchFrame.getNanoparticleElementRadio().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    updateList();
                }
            });
        }
        if (searchFrame.getNanoparticleCompoundRadio() != null) {
            searchFrame.getNanoparticleCompoundRadio().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    updateList();
                }
            });
        }

        // Reset filters button
        if (searchFrame.getResetFiltersButton() != null) {
            searchFrame.getResetFiltersButton().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    // Deselect all material type checkboxes
                    JCheckBox[] typeBoxes = searchFrame.getMaterialTypeCheckboxes();
                    if (typeBoxes != null) {
                        for (JCheckBox box : typeBoxes) {
                            if (box != null) box.setSelected(false);
                        }
                    }
                    // Deselect all quantity radios
                    if (searchFrame.getSizeRadio() != null) searchFrame.getSizeRadio().setSelected(false);
                    if (searchFrame.getThicknessRadio() != null) searchFrame.getThicknessRadio().setSelected(false);
                    if (searchFrame.getAtomsRadio() != null) searchFrame.getAtomsRadio().setSelected(false);
                    if (searchFrame.getEmissionRadio() != null) searchFrame.getEmissionRadio().setSelected(false);

                    // Reset sliders (set to full range)
                    if (searchFrame.getMinSlider() != null && searchFrame.getMaxSlider() != null) {
                        searchFrame.getMinSlider().setValue(searchFrame.getMinSlider().getMinimum());
                        searchFrame.getMaxSlider().setValue(searchFrame.getMaxSlider().getMaximum());
                    }

                    // Deselect nanotube subtype radios
                    JRadioButton[] nanotubeRadios = searchFrame.getNanotubeRadios();
                    if (nanotubeRadios != null) {
                        for (JRadioButton rb : nanotubeRadios) {
                            if (rb != null) rb.setSelected(false);
                        }
                    }

                    // Deselect nanotube config checkboxes
                    JCheckBox[] nanotubeConfigCheckboxes = searchFrame.getNanotubeConfigCheckboxes();
                    if (nanotubeConfigCheckboxes != null) {
                        for (JCheckBox cb : nanotubeConfigCheckboxes) {
                            if (cb != null) cb.setSelected(false);
                        }
                    }

                    // Deselect nanoparticle subtype radios
                    if (searchFrame.getNanoparticleAllRadio() != null) searchFrame.getNanoparticleAllRadio().setSelected(false);
                    if (searchFrame.getNanoparticleElementRadio() != null) searchFrame.getNanoparticleElementRadio().setSelected(false);
                    if (searchFrame.getNanoparticleCompoundRadio() != null) searchFrame.getNanoparticleCompoundRadio().setSelected(false);

                    // Deselect quantum dot solvent checkboxes
                    JCheckBox[] quantumDotSolventCheckboxes = searchFrame.getQuantumDotSolventCheckboxes();
                    if (quantumDotSolventCheckboxes != null) {
                        for (JCheckBox cb : quantumDotSolventCheckboxes) {
                            if (cb != null) cb.setSelected(false);
                        }
                    }

                    updateList();
                }
            });
        }

        // Search bar listener
        if (searchFrame.getSearchBar() != null) {
            searchFrame.getSearchBar().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String text = searchFrame.getSearchBar().getText().trim().toLowerCase();

                    // --- Reset all filters ---
                    JCheckBox[] typeBoxes = searchFrame.getMaterialTypeCheckboxes();
                    if (typeBoxes != null) {
                        for (JCheckBox box : typeBoxes) {
                            if (box != null) box.setSelected(false);
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

                    // --- Only select filters that match the search text ---
                    boolean filterMatched = false;
                    // Material type auto-select
                    if (typeBoxes != null) {
                        for (JCheckBox box : typeBoxes) {
                            if (box != null) {
                                String boxText = box.getText().toLowerCase();
                                if (boxText.contains(text) && !text.isEmpty()) {
                                    box.setSelected(true);
                                    filterMatched = true;
                                }
                            }
                        }
                    }
                    // Quantity filter auto-select
                    if (searchFrame.getSizeRadio() != null && text.contains("size")) {
                        searchFrame.getSizeRadio().setSelected(true);
                        filterMatched = true;
                    }
                    if (searchFrame.getThicknessRadio() != null && text.contains("thickness")) {
                        searchFrame.getThicknessRadio().setSelected(true);
                        filterMatched = true;
                    }
                    if (searchFrame.getAtomsRadio() != null && text.contains("atom")) {
                        searchFrame.getAtomsRadio().setSelected(true);
                        filterMatched = true;
                    }
                    if (searchFrame.getEmissionRadio() != null && (text.contains("emission") || text.contains("peak"))) {
                        searchFrame.getEmissionRadio().setSelected(true);
                        filterMatched = true;
                    }

                    updateList();
                }
            });
        }
    }

    public void updateList() {
        List<Material> filtered = new ArrayList<>(allMaterials);

        // --- Material Type Filter ---
        JCheckBox[] typeBoxes = searchFrame.getMaterialTypeCheckboxes();
        List<String> selectedTypes = new ArrayList<>();
        if (typeBoxes != null) {
            for (JCheckBox box : typeBoxes) {
                if (box != null && box.isSelected()) {
                    // When building selectedTypes:
                    String normalized = box.getText().trim();
                    if (normalized.endsWith("s")) normalized = normalized.substring(0, normalized.length() - 1);
                    selectedTypes.add(normalized.replaceAll("\\s", "").toLowerCase());
                }
            }
        }
        if (selectedTypes.isEmpty()) {
            searchFrame.displayMaterials(new ArrayList<>()); // Show nothing if none selected
            return;
        }
        filtered.removeIf(m -> {
            // When matching:
            String type = m.getClass().getSimpleName().replaceAll("\\s", "").toLowerCase();
            return !selectedTypes.contains(type);
        });

        // --- Size (Diameter) Filter ---
        if (searchFrame.getSizeRadio() != null && searchFrame.getSizeRadio().isSelected()) {
            double min = searchFrame.getMinSlider() != null ? searchFrame.getMinSlider().getValue() : Double.NEGATIVE_INFINITY;
            double max = searchFrame.getMaxSlider() != null ? searchFrame.getMaxSlider().getValue() : Double.POSITIVE_INFINITY;
            filtered.removeIf(m -> {
                Double diameter = null;
                if (m instanceof Model.Nanotube) diameter = ((Model.Nanotube)m).getDiameter();
                else if (m instanceof Model.Nanoparticle) diameter = ((Model.Nanoparticle)m).getDiameter();
                else if (m instanceof Model.Nanofiber) diameter = ((Model.Nanofiber)m).getDiameter();
                else if (m instanceof Model.Nanowire) diameter = ((Model.Nanowire)m).getDiameter();
                return diameter == null || diameter.isNaN() || diameter < min || diameter > max;
            });
        }

        // --- Thickness (Graphene) Filter ---
        if (searchFrame.getThicknessRadio() != null && searchFrame.getThicknessRadio().isSelected()) {
            double min = searchFrame.getMinSlider() != null ? searchFrame.getMinSlider().getValue() : Double.NEGATIVE_INFINITY;
            double max = searchFrame.getMaxSlider() != null ? searchFrame.getMaxSlider().getValue() : Double.POSITIVE_INFINITY;
            filtered.removeIf(m -> {
                if (m instanceof Model.Graphene) {
                    double thickness = ((Model.Graphene)m).getThickness();
                    return Double.isNaN(thickness) || thickness < min || thickness > max;
                }
                return false;
            });
        }

        // --- Atoms (Fullerene) Filter ---
        if (searchFrame.getAtomsRadio() != null && searchFrame.getAtomsRadio().isSelected()) {
            double min = searchFrame.getMinSlider() != null ? searchFrame.getMinSlider().getValue() : Double.NEGATIVE_INFINITY;
            double max = searchFrame.getMaxSlider() != null ? searchFrame.getMaxSlider().getValue() : Double.POSITIVE_INFINITY;
            filtered.removeIf(m -> {
                if (m instanceof Model.Fullerene) {
                    double atoms = ((Model.Fullerene)m).getAtoms();
                    return Double.isNaN(atoms) || atoms < min || atoms > max;
                }
                return false;
            });
        }

        // --- Emission Peak (Quantum Dot) Filter ---
        if (searchFrame.getEmissionRadio() != null && searchFrame.getEmissionRadio().isSelected()) {
            double min = searchFrame.getMinSlider() != null ? searchFrame.getMinSlider().getValue() : Double.NEGATIVE_INFINITY;
            double max = searchFrame.getMaxSlider() != null ? searchFrame.getMaxSlider().getValue() : Double.POSITIVE_INFINITY;
            filtered.removeIf(m -> {
                if (m instanceof Model.QuantumDot) {
                    double emission = ((Model.QuantumDot)m).getEmissionPeak();
                    return Double.isNaN(emission) || emission < min || emission > max;
                }
                return false;
            });
        }

        // --- Nanotube Subtype Filter ---
        JRadioButton[] nanotubeRadios = searchFrame.getNanotubeRadios();
        String nanotubeSubtype = null;
        if (nanotubeRadios != null) {
            for (JRadioButton rb : nanotubeRadios) {
                if (rb != null && rb.isSelected()) {
                    nanotubeSubtype = rb.getText();
                    break;
                }
            }
        }
        if (nanotubeSubtype != null) {
            final String finalNanotubeSubtype = nanotubeSubtype;
            filtered.removeIf(m -> m instanceof Model.Nanotube && !finalNanotubeSubtype.equalsIgnoreCase(((Model.Nanotube)m).getSubtype()));
        }

        // --- Nanotube Configuration Filter ---
        JCheckBox[] nanotubeConfigCheckboxes = searchFrame.getNanotubeConfigCheckboxes();
        List<String> selectedConfigs = new ArrayList<>();
        if (nanotubeConfigCheckboxes != null) {
            for (JCheckBox cb : nanotubeConfigCheckboxes) {
                if (cb != null && cb.isSelected()) {
                    selectedConfigs.add(cb.getText().trim().toLowerCase());
                }
            }
        }
        if (!selectedConfigs.isEmpty()) {
            filtered.removeIf(m -> !(m instanceof Model.Nanotube) ||
                    !selectedConfigs.contains(((Model.Nanotube)m).getConfiguration().trim().toLowerCase()));
        }

        // --- Nanoparticle Subtype Filter ---
        String nanoparticleSubtype = null;
        if (searchFrame.getNanoparticleElementRadio() != null && searchFrame.getNanoparticleElementRadio().isSelected())
            nanoparticleSubtype = "Element";
        else if (searchFrame.getNanoparticleCompoundRadio() != null && searchFrame.getNanoparticleCompoundRadio().isSelected())
            nanoparticleSubtype = "Compound";
        if (nanoparticleSubtype != null) {
            final String finalNanoparticleSubtype = nanoparticleSubtype;
            filtered.removeIf(m -> m instanceof Model.Nanoparticle && !finalNanoparticleSubtype.equalsIgnoreCase(((Model.Nanoparticle)m).getSubtype()));
        }

        // --- Quantum Dot Solvent Filter ---
        JCheckBox[] quantumDotSolventCheckboxes = searchFrame.getQuantumDotSolventCheckboxes();
        List<String> selectedSolvents = new ArrayList<>();
        if (quantumDotSolventCheckboxes != null) {
            for (JCheckBox cb : quantumDotSolventCheckboxes) {
                if (cb != null && cb.isSelected()) {
                    selectedSolvents.add(cb.getText().trim().toLowerCase());
                }
            }
        }
        if (!selectedSolvents.isEmpty()) {
            filtered.removeIf(m -> !(m instanceof Model.QuantumDot) ||
                    !selectedSolvents.contains(((Model.QuantumDot)m).getSolvent().trim().toLowerCase()));
        }

        // --- Search Bar Filter (by name or company) ---
        String searchText = searchFrame.getSearchBar() != null ? searchFrame.getSearchBar().getText().trim().toLowerCase() : "";
        if (!searchText.isEmpty() && !searchText.equals("enter material here")) {
            filtered.removeIf(m -> {
                String name = m.getName() != null ? m.getName().toLowerCase() : "";
                String company = m.getCompany() != null ? m.getCompany().toLowerCase() : "";
                return !(name.contains(searchText) || company.contains(searchText));
            });
        }

        // --- Sort by selected quantity filter ---
        if (searchFrame.getSizeRadio() != null && searchFrame.getSizeRadio().isSelected()) {
            filtered.sort(new Comparator<Material>() {
                public int compare(Material a, Material b) {
                    double da = getDiameter(a);
                    double db = getDiameter(b);
                    return Double.compare(da, db);
                }
                private double getDiameter(Material m) {
                    if (m instanceof Model.Nanotube) return ((Model.Nanotube)m).getDiameter();
                    if (m instanceof Model.Nanoparticle) return ((Model.Nanoparticle)m).getDiameter();
                    if (m instanceof Model.Nanofiber) return ((Model.Nanofiber)m).getDiameter();
                    if (m instanceof Model.Nanowire) return ((Model.Nanowire)m).getDiameter();
                    return Double.MAX_VALUE;
                }
            });
        } else if (searchFrame.getThicknessRadio() != null && searchFrame.getThicknessRadio().isSelected()) {
            filtered.sort(new Comparator<Material>() {
                public int compare(Material a, Material b) {
                    double ta = (a instanceof Model.Graphene) ? ((Model.Graphene)a).getThickness() : Double.MAX_VALUE;
                    double tb = (b instanceof Model.Graphene) ? ((Model.Graphene)b).getThickness() : Double.MAX_VALUE;
                    return Double.compare(ta, tb);
                }
            });
        } else if (searchFrame.getAtomsRadio() != null && searchFrame.getAtomsRadio().isSelected()) {
            filtered.sort(new Comparator<Material>() {
                public int compare(Material a, Material b) {
                    double aa = (a instanceof Model.Fullerene) ? ((Model.Fullerene)a).getAtoms() : Double.MAX_VALUE;
                    double ab = (b instanceof Model.Fullerene) ? ((Model.Fullerene)b).getAtoms() : Double.MAX_VALUE;
                    return Double.compare(aa, ab);
                }
            });
        } else if (searchFrame.getEmissionRadio() != null && searchFrame.getEmissionRadio().isSelected()) {
            filtered.sort(new Comparator<Material>() {
                public int compare(Material a, Material b) {
                    double ea = (a instanceof Model.QuantumDot) ? ((Model.QuantumDot)a).getEmissionPeak() : Double.MAX_VALUE;
                    double eb = (b instanceof Model.QuantumDot) ? ((Model.QuantumDot)b).getEmissionPeak() : Double.MAX_VALUE;
                    return Double.compare(ea, eb);
                }
            });
        }

        // --- Display the filtered list ---
        searchFrame.displayMaterials(filtered);
    }
}