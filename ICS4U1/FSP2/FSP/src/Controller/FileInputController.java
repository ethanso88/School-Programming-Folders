package Controller;

import Model.Fullerene;
import Model.QuantumDot;
import Model.Graphene;
import Model.Nanowire;
import Model.Nanoparticle;
import Model.Nanotube;
import Model.Nanofiber;

import java.io.*;
import java.util.ArrayList;

public class FileInputController {

    private ArrayList<Fullerene> fullerenes;
    private ArrayList<QuantumDot> quantumDots;
    private ArrayList<Graphene> graphenes;
    private ArrayList<Nanowire> nanowires;
    private ArrayList<Nanoparticle> nanoparticlesElements;
    private ArrayList<Nanoparticle> nanoparticlesBinary;
    private ArrayList<Nanoparticle> nanoparticlesComplex;
    private ArrayList<Nanotube> nanotubesSingleWalled;
    private ArrayList<Nanotube> nanotubesMultiWalled;
    private ArrayList<Nanofiber> nanofibers;

    public FileInputController() {
        String basePath = "C:\\Users\\easo8\\OneDrive\\Desktop\\ICS4U1\\FSP\\Data\\";

        fullerenes = new ArrayList<>();
        quantumDots = new ArrayList<>();
        graphenes = new ArrayList<>();
        nanowires = new ArrayList<>();
        nanoparticlesElements = new ArrayList<>();
        nanoparticlesBinary = new ArrayList<>();
        nanoparticlesComplex = new ArrayList<>();
        nanotubesSingleWalled = new ArrayList<>();
        nanotubesMultiWalled = new ArrayList<>();
        nanofibers = new ArrayList<>();

        loadFullerenes(basePath + "Nanoscale Material Datasheet - Fullerenes.tsv");
        loadQuantumDots(basePath + "Nanoscale Material Datasheet - Quantom Dot.tsv");
        loadGraphenes(basePath + "Nanoscale Material Datasheet - Graphene.tsv");
        loadNanowires(basePath + "Nanoscale Material Datasheet - Nanowires.tsv");
        loadNanoparticles(basePath + "Nanoscale Material Datasheet - Nanoparticles (Elements).tsv", nanoparticlesElements, "Elements");
        loadNanoparticles(basePath + "Nanoscale Material Datasheet - Nanoparticles (Binary Compounds).tsv", nanoparticlesBinary, "Binary");
        loadNanoparticles(basePath + "Nanoscale Material Datasheet - Nanoparticles (Complex Compounds).tsv", nanoparticlesComplex, "Complex");
        loadNanotubes(basePath + "Nanoscale Material Datasheet - Nanotubes (Single-walled).tsv", nanotubesSingleWalled, "Single-walled");
        loadNanotubes(basePath + "Nanoscale Material Datasheet - Nanotubes (Multi-walled).tsv", nanotubesMultiWalled, "Multi-walled");
        loadNanofibers(basePath + "Nanoscale Material Datasheet - Nanofibers.tsv");

        // Debug: Print the number of loaded items
        System.out.println("Loaded fullerenes: " + fullerenes.size());
        System.out.println("Loaded quantum dots: " + quantumDots.size());
        System.out.println("Loaded graphenes: " + graphenes.size());
        System.out.println("Loaded nanowires: " + nanowires.size());
        System.out.println("Loaded nanoparticles (elements): " + nanoparticlesElements.size());
        System.out.println("Loaded nanoparticles (binary): " + nanoparticlesBinary.size());
        System.out.println("Loaded nanoparticles (complex): " + nanoparticlesComplex.size());
        System.out.println("Loaded nanotubes (single-walled): " + nanotubesSingleWalled.size());
        System.out.println("Loaded nanotubes (multi-walled): " + nanotubesMultiWalled.size());
        System.out.println("Loaded nanofibers: " + nanofibers.size());
    }

    private void loadFullerenes(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\t", -1);
                if (parts.length < 4) continue;
                boolean hasEmpty = false;
                for (String part : parts) {
                    if (part.trim().isEmpty()) {
                        hasEmpty = true;
                        break;
                    }
                }
                if (hasEmpty) continue;
                String company = parts[0].trim();
                String name = parts[1].trim();
                String atomsStr = parts[2].trim();
                String specification = parts[3].trim();
                double atoms = parseDouble(atomsStr);
                fullerenes.add(new Fullerene(name, company, atoms, specification));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadQuantumDots(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\t", -1);
                if (parts.length < 4) continue; // <-- changed from 5 to 4
                boolean hasEmpty = false;
                for (String part : parts) {
                    if (part.trim().isEmpty()) {
                        hasEmpty = true;
                        break;
                    }
                }
                if (hasEmpty) continue;
                String company = parts[0].trim();
                String name = parts[1].trim();
                String emissionPeakStr = parts[2].trim();
                String specification = parts[3].trim();
                double emissionPeak = parseDouble(emissionPeakStr);
                quantumDots.add(new QuantumDot(name, company, "", emissionPeak, specification));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGraphenes(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\t", -1);
                if (parts.length < 4) continue;
                boolean hasEmpty = false;
                for (String part : parts) {
                    if (part.trim().isEmpty()) {
                        hasEmpty = true;
                        break;
                    }
                }
                if (hasEmpty) continue;
                String company = parts[0].trim();
                String name = parts[1].trim();
                String thicknessStr = parts[2].trim();
                String specification = parts[3].trim();
                double thickness = parseDouble(thicknessStr);
                graphenes.add(new Graphene(name, company, thickness, specification));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNanowires(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\t", -1);
                if (parts.length < 3) continue; // company, name, diameter
                boolean hasEmpty = false;
                for (String part : parts) {
                    if (part.trim().isEmpty()) {
                        hasEmpty = true;
                        break;
                    }
                }
                if (hasEmpty) continue;
                String company = parts[0].trim();
                String name = parts[1].trim();
                String diameterStr = parts[2].trim();
                double diameter = parseDouble(diameterStr);
                nanowires.add(new Nanowire(name, company, diameter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNanoparticles(String filePath, ArrayList<Nanoparticle> list, String subtype) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\t", -1);
                if (parts.length < 4) continue;
                boolean hasEmpty = false;
                for (String part : parts) {
                    if (part.trim().isEmpty()) {
                        hasEmpty = true;
                        break;
                    }
                }
                if (hasEmpty) continue;
                String company = parts[0].trim();
                String name = parts[1].trim();
                String diameterStr = parts[2].trim();
                String specification = parts[3].trim();
                double diameter = parseDouble(diameterStr);
                // Subtype is passed in from the calling method, based on file
                list.add(new Nanoparticle(name, company, diameter, specification, subtype));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNanotubes(String filePath, ArrayList<Nanotube> nanotubeList, String subtype) {
        System.out.println("Loading nanotubes from: " + filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\t", -1);
                if (parts.length < 4) continue; // company, name, diameter, specification
                boolean hasEmpty = false;
                for (String part : parts) {
                    if (part.trim().isEmpty()) {
                        hasEmpty = true;
                        break;
                    }
                }
                if (hasEmpty) continue;
                String company = parts[0].trim();
                String name = parts[1].trim();
                String diameterStr = parts[2].trim();
                String specification = parts[3].trim();
                double diameter = parseDouble(diameterStr);
                // Subtype is passed in from the calling method, based on file
                nanotubeList.add(new Nanotube(name, company, diameter, specification, subtype, ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNanofibers(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\t", -1);
                if (parts.length < 3) continue; // company, name, diameter
                boolean hasEmpty = false;
                for (String part : parts) {
                    if (part.trim().isEmpty()) {
                        hasEmpty = true;
                        break;
                    }
                }
                if (hasEmpty) continue;
                String company = parts[0].trim();
                String name = parts[1].trim();
                String diameterStr = parts[2].trim();
                double diameter = parseDouble(diameterStr);
                nanofibers.add(new Nanofiber(name, company, diameter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper to parse a double, handles ranges and units
    private double parseDouble(String value) {
        if (value == null || value.isEmpty()) return Double.NaN;
        value = value.trim().toLowerCase();

        // Remove common units
        value = value.replaceAll("\\s*(nm|mm|μm|um|pm|cm|m)\\b", "");

        // Handle ranges like "5–10" or "5-10"
        if (value.contains("–") || value.contains("-")) {
            String[] parts = value.split("[–-]");
            if (parts.length == 2) {
                try {
                    double a = Double.parseDouble(parts[0].replaceAll("[^0-9.\\-]", ""));
                    double b = Double.parseDouble(parts[1].replaceAll("[^0-9.\\-]", ""));
                    return (a + b) / 2.0;
                } catch (NumberFormatException e) {
                    return Double.NaN;
                }
            }
        }

        // Handle inequalities like "<10" or ">10"
        if (value.startsWith("<") || value.startsWith(">")) {
            value = value.substring(1).trim();
        }

        // Remove all non-numeric except dot and minus
        value = value.replaceAll("[^0-9.\\-]", "");
        if (value.isEmpty()) return Double.NaN;

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

    // Getters
    public ArrayList<Fullerene> getFullerenes() { return fullerenes; }
    public ArrayList<QuantumDot> getQuantumDots() { return quantumDots; }
    public ArrayList<Graphene> getGraphenes() { return graphenes; }
    public ArrayList<Nanowire> getNanowires() { return nanowires; }
    public ArrayList<Nanoparticle> getNanoparticlesElements() { return nanoparticlesElements; }
    public ArrayList<Nanoparticle> getNanoparticlesBinary() { return nanoparticlesBinary; }
    public ArrayList<Nanoparticle> getNanoparticlesComplex() { return nanoparticlesComplex; }
    public ArrayList<Nanotube> getNanotubesSingleWalled() { return nanotubesSingleWalled; }
    public ArrayList<Nanotube> getNanotubesMultiWalled() { return nanotubesMultiWalled; }
    public ArrayList<Nanofiber> getNanofibers() { return nanofibers; }
}

