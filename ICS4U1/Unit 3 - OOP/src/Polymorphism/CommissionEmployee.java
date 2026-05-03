package Polymorphism;

public class CommissionEmployee extends Employee {

	// fields
	private double grossSales;
	private double commissionRate;

	// constructor
	public CommissionEmployee(String firstName, String lastName, Date birthDate, String sinNumber, double grossSales,
			double commissionRate) {
		super(firstName, lastName, birthDate, sinNumber);
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	// getters and setters (include validation code later)
	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	// to display on the console
	@Override
	public String toString() {
		return super.toString() + "\n\tCommissionEmployee [grossSales=" + grossSales + ", commissionRate=" + commissionRate + "]";
	}

	@Override
	public double earnings() {

		// safer to use the get methods rather than the fields; in case there is any
		// code within the methods
		return getGrossSales() * getCommissionRate();
	}

}
