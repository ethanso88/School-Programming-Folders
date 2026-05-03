import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

//this class will read in the laptop data from a .csv file
public class LaptopStoreFileInput {

    //constructor method
    public LaptopStoreFileInput() {

        //try ("if") reading in the inputs
        try {

            //set .csv file as input
            Scanner inputFile = new Scanner(new File("data/laptop.csv"));

            //read first row AND second row and ignore it
            inputFile.nextLine();
            inputFile.nextLine();

            //separate each item (data) by commas
            inputFile.useDelimiter(",|\r\n");

            //fill the array with laptop data
            for (int index = 0; index < 40; index++) {

                //set inputs as fields
                //laptop
                String image = inputFile.next();
                String brand = inputFile.next();
                String model = inputFile.next();
                String type = inputFile.next();
                double price = inputFile.nextDouble();
                int qualityRating = inputFile.nextInt();

                //CPU
                String cpuBrand = inputFile.next();
                String cpuType = inputFile.next();
                int cpuModel = inputFile.nextInt();
                int cores = inputFile.nextInt();
                double speed = inputFile.nextDouble();
                int speedRating = inputFile.nextInt();

                //Memory
                int ram = inputFile.nextInt();
                int ssd = inputFile.nextInt();
                int memoryRating = inputFile.nextInt();

                //GPU
                String gpuBrand = inputFile.next();
                String gpuModel = inputFile.next();

                //Connectivity
                String usbPorts = inputFile.next();
                String otherConnection = inputFile.next();

                //Operating System
                String operatingSystem = inputFile.next();

                //Display
                double laptopSize = inputFile.nextDouble();
                int resolutionWidth = inputFile.nextInt();
                int resolutionHeight = inputFile.nextInt();
                String touchScreen = inputFile.next();
                int displayRating = inputFile.nextInt();

                //weight
                double weight = inputFile.nextDouble();

                //hyperlink
                String hyperlink = inputFile.next();

                //score
                    //set laptop score to 0 be default
                int score = 0;

                //resize the laptop images for results frame
                ImageIcon originalLaptopImage = new ImageIcon("images/laptop" + index + ".jpg");
                ImageIcon resizedLaptopImageForResultsFrame = new ImageIcon(
                        originalLaptopImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));


                //create the laptop instance
                LaptopStoreApplication.laptopArray[index] = new Laptop(image, brand, model, type, price, qualityRating,     //laptop
                        cpuBrand, cpuType, cpuModel, cores, speed, speedRating,                                             //cpu
                        ram, ssd, memoryRating, gpuBrand, gpuModel,                                                         //gpu
                        usbPorts, otherConnection,                                                                          //connectivity
                        operatingSystem,                                                                                    //OS
                        laptopSize, resolutionWidth, resolutionHeight, touchScreen, displayRating,                          //display
                        weight,                                                                                             //weight
                        hyperlink,                                                                                          //hyperlink
                        score,                                                                                              //score
                        resizedLaptopImageForResultsFrame);                                                                 //resized laptop image for results frame

            }

            //close input
            inputFile.close();

        }

        //catch ("else") the errors
        catch (FileNotFoundException e) {

            System.out.println("File Error");
        }
    }

}


