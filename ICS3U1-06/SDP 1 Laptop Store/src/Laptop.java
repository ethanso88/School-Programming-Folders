import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//this class is the template class for the laptop object
public class Laptop extends JLabel{

    //laptop
    private String image;
    private String brand;
    private String model;
    private String type;
    private double price;
    private int qualityRating;

    //CPU
    private String cpuBrand;
    private String cpuType;
    private int cpuModel;
    private int cores;
    private double speed;
    private int speedRating;

    //Memory
    private int ram;
    private int ssd;
    private int memoryRating;

    //GPU
    private String gpuBrand;
    private String gpuModel;

    //Connectivity
    private String usbPorts;
    private String otherConnection;

    //Operating System
    private String operatingSystem;

    //Display
    private double laptopSize;
    private int resolutionWidth;
    private int resolutionHeight;
    private String touchScreen;
    private int displayRating;

    //weight
    private double weight;

    //hyperlink
    private String hyperlink;

    //laptop score (to sort results)
    private int score;

    //laptop image (resized for results frame)
    private ImageIcon resizedLaptopImageForResultsFrame;

    public Laptop(String image, String brand, String model, String type, double price, int qualityRating,
                  String cpuBrand, String cpuType, int cpuModel, int cores, double speed, int speedRating, int ram,
                  int ssd, int memoryRating, String gpuBrand, String gpuModel, String usbPorts, String otherConnection,
                  String operatingSystem, double laptopSize, int resolutionWidth, int resolutionHeight, String touchScreen,
                  int displayRating, double weight, String hyperlink, int score, ImageIcon resizedLaptopImageForResultsFrame) {
        super();
        this.image = image;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.price = price;
        this.qualityRating = qualityRating;
        this.cpuBrand = cpuBrand;
        this.cpuType = cpuType;
        this.cpuModel = cpuModel;
        this.cores = cores;
        this.speed = speed;
        this.speedRating = speedRating;
        this.ram = ram;
        this.ssd = ssd;
        this.memoryRating = memoryRating;
        this.gpuBrand = gpuBrand;
        this.gpuModel = gpuModel;
        this.usbPorts = usbPorts;
        this.otherConnection = otherConnection;
        this.operatingSystem = operatingSystem;
        this.laptopSize = laptopSize;
        this.resolutionWidth = resolutionWidth;
        this.resolutionHeight = resolutionHeight;
        this.touchScreen = touchScreen;
        this.displayRating = displayRating;
        this.weight = weight;
        this.hyperlink = hyperlink;
        this.score = score;
        this.resizedLaptopImageForResultsFrame = resizedLaptopImageForResultsFrame;
    }

    public String getImage() {
        return image;
    }

    //read the image based on the name
    public ImageIcon getImageIcon() throws IOException {

        URL source = getClass().getClassLoader().getResource(getImage()+".jpg");
        if (source == null) {
            source = getClass().getClassLoader().getResource("tag.png");
        }
        return new ImageIcon(ImageIO.read(source));
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceRange() {
        String priceRange = null;
        // "$100-$500", "$500-$1000", "$1000-$2000", "$2000+"
        if (price >= 100 && price < 500)
            priceRange = "1";
        if (price >= 500 && price < 1000)
            priceRange = "2";
        if (price >= 1000 && price < 2000)
            priceRange = "3";
        if (price >= 2000)
            priceRange = "4";

        return priceRange;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQualityRating() {
        return qualityRating;
    }

    public void setQualityRating(int qualityRating) {
        this.qualityRating = qualityRating;
    }

    public String getCpuBrand() {
        return cpuBrand;
    }

    public void setCpuBrand(String cpuBrand) {
        this.cpuBrand = cpuBrand;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public int getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(int cpuModel) {
        this.cpuModel = cpuModel;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getSpeedRating() {
        return speedRating;
    }

    public void setSpeedRating(int speedRating) {
        this.speedRating = speedRating;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public int getMemoryRating() {
        return memoryRating;
    }

    public void setMemoryRating(int memoryRating) {
        this.memoryRating = memoryRating;
    }

    public String getGpuBrand() {
        return gpuBrand;
    }

    public void setGpuBrand(String gpuBrand) {
        this.gpuBrand = gpuBrand;
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public void setGpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }

    public String getUsbPorts() {
        return usbPorts;
    }

    public void setUsbPorts(String usbPorts) {
        this.usbPorts = usbPorts;
    }

    public String getOtherConnection() {
        return otherConnection;
    }

    public void setOtherConnection(String otherConnection) {
        this.otherConnection = otherConnection;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getLaptopSize() {
        return laptopSize;
    }

    public void setLaptopSize(double laptopSize) {
        this.laptopSize = laptopSize;
    }

    public int getResolutionWidth() {
        return resolutionWidth;
    }

    public void setResolutionWidth(int resolutionWidth) {
        this.resolutionWidth = resolutionWidth;
    }

    public int getResolutionHeight() {
        return resolutionHeight;
    }

    public void setResolutionHeight(int resolutionHeight) {
        this.resolutionHeight = resolutionHeight;
    }

    public String getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(String touchScreen) {
        this.touchScreen = touchScreen;
    }

    public int getDisplayRating() {
        return displayRating;
    }

    public void setDisplayRating(int displayRating) {
        this.displayRating = displayRating;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ImageIcon getResizedLaptopImageForResultsFrame() {
        return resizedLaptopImageForResultsFrame;
    }

    public void setResizedLaptopImageForResultsFrame(ImageIcon resizedLaptopImageForResultsFrame) {
        this.resizedLaptopImageForResultsFrame = resizedLaptopImageForResultsFrame;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "image='" + image + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", qualityRating=" + qualityRating +
                ", cpuBrand='" + cpuBrand + '\'' +
                ", cpuType='" + cpuType + '\'' +
                ", cpuModel=" + cpuModel +
                ", cores=" + cores +
                ", speed=" + speed +
                ", speedRating=" + speedRating +
                ", ram=" + ram +
                ", ssd=" + ssd +
                ", memoryRating=" + memoryRating +
                ", gpuBrand='" + gpuBrand + '\'' +
                ", gpuModel='" + gpuModel + '\'' +
                ", usbPorts='" + usbPorts + '\'' +
                ", otherConnection='" + otherConnection + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", laptopSize=" + laptopSize +
                ", resolutionWidth=" + resolutionWidth +
                ", resolutionHeight=" + resolutionHeight +
                ", touchScreen='" + touchScreen + '\'' +
                ", displayRating=" + displayRating +
                ", weight=" + weight +
                ", hyperlink='" + hyperlink + '\'' +
                ", score=" + score +
                ", resizedLaptopImageForResultsFrame=" + resizedLaptopImageForResultsFrame +
                '}';
    }
}