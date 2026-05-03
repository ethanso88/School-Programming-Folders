//Template Class
public class Invoice {

    //Fields
    private String partNumber; //part identification number
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    //Constructor Method
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        super(); //creates an object, implicit call

        //No validation code
        //Set the fields directly to the parameters
        this.partNumber = partNumber;
        this.partDescription = partDescription;

        //Since these two fields have validation code (so they are not negative)
        //we will call their set methods
        setQuantity(quantity);
        setPricePerItem(pricePerItem);

    }

    //Getters and setters
    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        //Validation code
        if (quantity < 0)
            this.quantity = 0;
        else
            this.quantity = quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {

        //Validation code
        if (pricePerItem < 0)
            this.pricePerItem = 0;
        else
            this.pricePerItem = pricePerItem;
    }

    //To display the object on the console
    @Override
    public String toString() {
        return "Invoice{" +
                "partNumber='" + partNumber + '\'' +
                ", partDescription='" + partDescription + '\'' +
                ", quantity=" + quantity +
                ", pricePerItem=" + pricePerItem +
                '}';
    }

    //Utility Method
    public double getInvoiceAmount() {

        return getQuantity() * getPricePerItem();

    }
}
