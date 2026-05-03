public class InvoiceTest {

    public static void main(String[] args) {

        //create objects
        Invoice bill1 = new Invoice("12345", "Hammer", 2, 5.00);
        Invoice bill2 = new Invoice("67890", "Nail", 100, 0.10);

        System.out.println(bill1.toString());
        System.out.println(bill2); //remember implied call of .toString()

        System.out.println(bill1.getInvoiceAmount());
        System.out.println(bill2.getInvoiceAmount());

        //test negative validation
        bill1.setQuantity(-5);
        System.out.println(bill1.getInvoiceAmount());
        System.out.println(bill1); //see all fields, quantity should be 0

    }

}
