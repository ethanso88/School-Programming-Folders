package View.FarmProductionPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//this class reads production cost data from a csv file and puts it into a 2d array
public class ProductionCostReader {

    //this method reads a single production cost csv file and returns a 2d string array
    public String[][] productionCostFileInput(String filePath) {
        List<String[]> rowsList = new ArrayList<>();

        //BufferedReader is used to read text files line by line
        //see: https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            int currentLineNumber = 0;

            //go through each line in the file
            while ((currentLine = bufferedReader.readLine()) != null) {
                currentLineNumber++;
                //skip the first 4 lines because they are headers or not region data
                if (currentLineNumber <= 4) continue;
                //only keep lines 5 to 10, which are the 6 regions
                if (currentLineNumber > 10) break;

                //split the line into columns, but ignore commas inside quotes
                //see: https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
                String[] columns = currentLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                //remove any quotes and extra spaces from each column
                for (int columnIndex = 0; columnIndex < columns.length; columnIndex++) {
                    if (columns[columnIndex] != null) {
                        columns[columnIndex] = columns[columnIndex].replace("\"", "").trim();
                    }
                }
                //add this row to the list of rows
                rowsList.add(columns);
            }
        } catch (IOException ioException) {
            //show an error if the file cannot be read
            ioException.printStackTrace();
        }

        //turn the list of rows into a 2d array and return it
        return rowsList.toArray(new String[0][]);
    }
}
