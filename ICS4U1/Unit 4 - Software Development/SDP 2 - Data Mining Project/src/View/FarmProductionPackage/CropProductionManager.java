package View.FarmProductionPackage;

//this class is for loading multiple crop production files into a 3d array
public class CropProductionManager {
    private String[][][] cropProductionArray;

    //this method reads all files in filePaths and stores their data
    public void readMultipleCropProductionFiles(String[] filePaths) {
        cropProductionArray = new String[filePaths.length][][];
        CropProductionReader cropReader = new CropProductionReader();

        //go through each file and read its data
        for (int fileIndex = 0; fileIndex < filePaths.length; fileIndex++) {
            cropProductionArray[fileIndex] = cropReader.cropProductionFileInput(filePaths[fileIndex]);
        }
    }

    //this method returns the 3d array with all the crop data
    public String[][][] getCropProductionArray() {
        return cropProductionArray;
    }
}
