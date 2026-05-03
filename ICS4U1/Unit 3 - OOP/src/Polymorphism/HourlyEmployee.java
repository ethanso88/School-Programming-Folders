package Polymorphism;

public class HourlyEmployee extends Employee {

	// fields
	private double wage;
	private double hours;

	// constructor
	public HourlyEmployee(String firstName, String lastName, Date birthDate, String sinNumber, double wage,
			double hours) {
		super(firstName, lastName, birthDate, sinNumber);
		this.wage = wage;
		this.hours = hours;
	}

	// getters and setters
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	// to display on the console
	@Override
	public String toString() {
		return super.toString() + "\n\tHourlyEmployee [wage=" + wage + ", hours=" + hours + "]";
	}

	@Override
	public double earnings() {

		return getHours() * getWage();
	}

}
