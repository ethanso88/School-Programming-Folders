package Polymorphism;

import java.util.ArrayList;
import java.util.Calendar;

public class PayableTest {

	public static void main(String[] args) {
		
		ArrayList<Payable> payableList = new ArrayList<Payable>();
		
		payableList.add(new HourlyEmployee("Karen", "Price", new Date(4,2,1990) ,
				"111-11-1111" , 25.50, 40));
		payableList.add(new CommissionEmployee("Joe", "Smith", new Date(1,13,1980) ,
				"222-22-2222" , 5000, 0.15));
		payableList.add(new BasePlusCommissionEmployee("Kelly", "Murphy", new Date(9,21,1985) ,
				"333-33-3333" , 10000, 0.05, 2000));

		//add some invoices to the payable list


		//Process all the items in the payable list
		for (Payable currentPayable: payableList) {

			//check if the item is an employee
			if (currentPayable instanceof Employee) {

				//check if the item is a base plus commission employee
				if (currentPayable instanceof BasePlusCommissionEmployee) {

					//first we need to downcast
					BasePlusCommissionEmployee bpcEmployee = (BasePlusCommissionEmployee) currentPayable;

					//update with new salary
					bpcEmployee.setBaseSalary(bpcEmployee.getBaseSalary() * 1.10);

				}

				//downcast the current payment to an Employee object in order to access their birth month
				Employee employee = (Employee) currentPayable;

				//get a calender object so we can access the current month from the operating system
				Calendar calendar = Calendar.getInstance();


				//check if it is the current employee's birth month. if it is then give them a $100 raise
				//Note: In the calendar class January is month 0 so we add 1 to the current month number
				if (employee.getBirthDate().getMonth() == calendar.get(Calendar.MONTH) + 1) {

					//birthday money
					System.out.printf("HAPPY BIRTH MONTH your new earnings are: $%.2f\n", currentPayable.getPaymentAmount() + 100);

				}

			} else //otherwise the item is an Invoice

				System.out.printf("Payment Due: $%.2f\n", currentPayable.getPaymentAmount());
			
			System.out.println(currentPayable);

		}
		
	}
	
}
