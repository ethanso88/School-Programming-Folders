package View.FarmProductionPackage;

//this class is for loading multiple production cost files into a 3d array
public class ProductionCostManager {
    private String[][][] productionCostArray;

    //this method reads all files in filePaths and stores their data
    public void readMultipleProductionCostFiles(String[] filePaths) {
        productionCostArray = new String[filePaths.length][][];
        ProductionCostReader costReader = new ProductionCostReader();

        //go through each file and read its data
        for (int fileIndex = 0; fileIndex < filePaths.length; fileIndex++) {
            productionCostArray[fileIndex] = costReader.productionCostFileInput(filePaths[fileIndex]);
        }
    }

    //this method returns the 3d array with all the production cost data
    public String[][][] getProductionCostArray() {
        return productionCostArray;
    }
}
