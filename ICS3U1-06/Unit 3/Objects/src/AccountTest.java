import java.util.Scanner;

public class AccountTest {

    public static void main(String[] args) {

        Account account1 = new Account(50.00); //create Account object
        Account account2 = new Account(-7.53); //create Account object


        //display initial balance of each object
        System.out.printf("account1 balance: $%.2f\n",
                account1.getBalance());
        System.out.printf("account2 balance: $%.2f\n",
                account2.getBalance());

        //create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);
        double depositAmount; //deposit amount read from user
        double withdrawalAmount; //withdrawal amount read from user


        //add deposit to account1 and display new balance
        System.out.println("Enter amount to deposit into account1: ");
        depositAmount = input.nextDouble(); //take deposit

        account1.credit(depositAmount); //add deposit

        System.out.printf("account1 balance: $%.2f\n", //display new balance
                account1.getBalance());


        //subtract withdrawal to account1 and display new balance
        System.out.println("Enter amount to withdraw from account1: ");
        withdrawalAmount = input.nextDouble(); //take withdrawal

        account1.debit(withdrawalAmount); //subtract withdrawal

        System.out.printf("account1 balance: $%.2f\n", //display new balance
                account1.getBalance());






    }

}
