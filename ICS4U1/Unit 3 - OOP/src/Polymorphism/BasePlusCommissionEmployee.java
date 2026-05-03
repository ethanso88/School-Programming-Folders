package Polymorphism;

public class BasePlusCommissionEmployee extends CommissionEmployee{

	//fields
	private double baseSalary;

	//constructor
	public BasePlusCommissionEmployee(String firstName, String lastName, Date birthDate, String sinNumber,
			double grossSales, double commissionRate, double baseSalary) {
		super(firstName, lastName, birthDate, sinNumber, grossSales, commissionRate);
		this.baseSalary = baseSalary;
	}

	//getters and setters
	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	//to display on the console
	@Override
	public String toString() {
		return super.toString() + "\n\tBasePlusCommissionEmployee [baseSalary=" + baseSalary + "]";
	}
	
	@Override
	public double earnings() {
		
		return getBaseSalary() + super.earnings();
	}
	
}
