package Polymorphism;

public class Invoice implements Payable {

    //fields
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    //constructor
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    //set part number
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    //get part number
    public String getPartNumber() {
        return partNumber;
    }

    //set part description
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    //get part description
    public String getPartDescription() {
        return partDescription;
    }

    //set quantity
    public void setQuantity(int quantity) {
        if (quantity > 0)
            this.quantity = quantity;
        else
            this.quantity = 0;
    }

    //get quantity
    public int getQuantity() {
        return quantity;
    }

    //set price per item
    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem > 0)
            this.pricePerItem = pricePerItem;
        else
            this.pricePerItem = 0;
    }

    //get price per item
    public double getPricePerItem() {
        return pricePerItem;
    }

    //calculate payment amount
    @Override
    public double getPaymentAmount() {
        return (getQuantity() * getPricePerItem());
    }

    //return string representation of invoice
    @Override
    public String toString() {
        return String.format("%s%npart number: %s%npart description: %s%nquantity: %d%nprice per item: $%.2f",
                getClass().getSimpleName(), getPartNumber(), getPartDescription(), getQuantity(), getPricePerItem());
    }
}
