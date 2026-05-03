package Polymorphism;

public abstract class Employee implements Payable   {

	// fields
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String sinNumber;

	// contructor method
	public Employee(String firstName, String lastName, Date birthDate, String sinNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.sinNumber = sinNumber;
	}

	// getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSinNumber() {
		return sinNumber;
	}

	public void setSinNumber(String sinNumber) {
		this.sinNumber = sinNumber;
	}

	// to display on the console
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", sinNumber=" + sinNumber + "]";
	}

	@Override
	public double getPaymentAmount() {
		return earnings();

	}

	public abstract double earnings();

}
