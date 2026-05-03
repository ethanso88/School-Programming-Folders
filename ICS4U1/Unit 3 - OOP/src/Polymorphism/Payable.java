package Polymorphism;

//a collection of method headings that must be
//included in any class that 'implements' the interface
//sort of like a 'contract' or 'contracting'
public interface Payable {

    //how much to pay out to the employee
    //gives access to functions like this method to the entire app
    double getPaymentAmount();

}
