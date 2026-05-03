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

//reads all the data files and loads them into arraylists for the app
//each method loads a different type of material
public class FileInputController {

    //fields for all the material lists
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

    //constructor loads all the data from files
    public FileInputController() {
        String basePath = "Data\\";

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
    }

    //loads fullerenes from file
    private void loadFullerenes(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); //skip header
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

    //loads quantum dots from file
    private void loadQuantumDots(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); //skip header
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
                String emissionPeakStr = parts[2].trim();
                String specification = parts[3].trim();
                double emissionPeak = parseDouble(emissionPeakStr);
                quantumDots.add(new QuantumDot(name, company, "", emissionPeak, specification));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //loads graphenes from file
    private void loadGraphenes(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); //skip header
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

    //loads nanowires from file
    private void loadNanowires(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); //skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\t", -1);
                if (parts.length < 3) continue;
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

    //loads nanoparticles from file
    private void loadNanoparticles(String filePath, ArrayList<Nanoparticle> list, String subtype) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); //skip header
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
                list.add(new Nanoparticle(name, company, diameter, specification, subtype));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //loads nanotubes from file
    private void loadNanotubes(String filePath, ArrayList<Nanotube> nanotubeList, String subtype) {
        System.out.println("Loading nanotubes from: " + filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); //skip header
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
                nanotubeList.add(new Nanotube(name, company, diameter, specification, subtype, ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //loads nanofibers from file
    private void loadNanofibers(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); //skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\t", -1);
                if (parts.length < 3) continue;
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

    //parses a double from a string, handles ranges and units
    private double parseDouble(String value) {
        if (value == null || value.isEmpty()) return Double.NaN;
        value = value.trim().toLowerCase();
        value = value.replaceAll("\\s*(nm|mm|μm|um|pm|cm|m)\\b", "");
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
        if (value.startsWith("<") || value.startsWith(">")) {
            value = value.substring(1).trim();
        }
        value = value.replaceAll("[^0-9.\\-]", "");
        if (value.isEmpty()) return Double.NaN;
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

    //getters for all the lists
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

