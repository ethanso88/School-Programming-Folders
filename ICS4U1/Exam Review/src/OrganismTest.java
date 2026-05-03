public class OrganismTest {

    public static void main(String[] args) {

        Organism[] organismArray = new Organism[6]; //NEW ORGANISM

        organismArray[0] = new Plant("Rose", 50);
        organismArray[1] = new Plant("Cactus", 300);
        organismArray[2] = new Mammal("Human", 25);
        organismArray[3] = new Mammal("Cheetah", 120);
        organismArray[4] = new Fish("Goldfish", 10);
        organismArray[5] = new Fish("Shark", 540);

        increase(organismArray);
        quickSort(organismArray, 0, organismArray.length - 1);
        display(organismArray);

    }

    private static void increase(Organism[] organismArray) {

//        for (int x = 0; x < organismArray.length; x++)

        //traverse array
        for (Organism organism : organismArray) {

            //check if organism is a mammal
            if (organism instanceof Mammal) {

                Mammal mammal = (Mammal) organism; //downcast the object
                mammal.setSpeed(mammal.getSpeed() + 5); //increase speed by 5

            }

        }

    }

    private static void quickSort(Organism[] organismArray, int start, int end) {
        int left = start;
        int right = end;
        String pivot = organismArray[(start + end)/2].getName();

        // PARTITION
        while (left <= right) {
            // Compare strings using compareTo() instead of <
            while (organismArray[left].getName().compareTo(pivot) < 0) {
                left++;
            }
            // Compare strings using compareTo() instead of >
            while (organismArray[right].getName().compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                swap(organismArray, left, right);
                left++;
                right--;
            }
        }

        // RECURSION
        if (start < right) {
            quickSort(organismArray, start, right);
        }
        if (left < end) {
            quickSort(organismArray, left, end);
        }
    }

    private static void swap(Organism[] organismArray, int x, int y) {
        Organism temp = organismArray[x];
        organismArray[x] = organismArray[y];
        organismArray[y] = temp;
    }

    private static void display(Organism[] organismArray) {

        System.out.println("Organisms in alphabetical order:\n");

        for (Organism organism : organismArray) {
            System.out.println(organism.toString());
        }

    }

}

