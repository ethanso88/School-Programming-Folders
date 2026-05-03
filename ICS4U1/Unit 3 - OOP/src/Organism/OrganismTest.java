package Organism;

import java.util.ArrayList;

public class OrganismTest {
    public static void main(String[] args) {
        // Create organisms
        ArrayList<Organism> organismList = new ArrayList<>();

        Plant rose = new Plant("Rose", 50, true);
        Plant cactus = new Plant("Cactus", 300, false);
        Mammal human = new Mammal("Human", "Omnivore", 2);
        Mammal cheetah = new Mammal("Cheetah", "Carnivore", 4);
        Fish shark = new Fish("Shark", "Carnivore", "Cartilaginous");
        Fish parrotfish = new Fish("Parrotfish", "Herbivore", "Bony");

        // Add to the organism list
        organismList.add(rose);
        organismList.add(cactus);
        organismList.add(human);
        organismList.add(cheetah);
        organismList.add(shark);
        organismList.add(parrotfish);

        // Cycle through and display the contents
        for (Organism organism : organismList) {
            if (organism instanceof Plant) {
                Plant plant = (Plant) organism;
                // Increase plant height by growth rate
                int newHeight = (int) (plant.getHeight() * (1 + (double) plant.growthRate()/100));
                plant.setHeight(newHeight);
            }
            System.out.println(organism);
        }
    }
}
