public class Account {

    private double balance; //field to store the balance


    //constructor
    public Account(double initialBalance) {

        setBalance(initialBalance);     //use set method to associate the field with the parameter
                                        //since it contains validation code (validate the initial balance

    }

    //
    public void setBalance(double initialBalance) {

        //validate that the initial balance is greater than 0
        //if it is not, balance is initialized to the default value 0
        if (initialBalance < 0.0)
            balance = 0.0;
        else
            balance = initialBalance;
        }

    //return the account balance
    public double getBalance() {
        return balance; //gives the value of balance to the calling method
    }

    //credit (add) an amount to the account
        //utility method
    public void credit (double amount) {
        if (amount <= 0) //check if credit amount is valid (positive)
            System.out.println("Invalid deposit amount - account balance unchanged.\n");
        else
            balance += amount; //add amount to balance
    }

    //debit (subtract) an amount to the account
        //utility method
    public void debit (double amount) {
        if (amount > balance) //if withdrawal exceeds balance
            System.out.println("Withdrawal amount exceeded account balance.\n");
        else
            balance -= amount; //subtract amount ot balance
    }

 } //end class Account
