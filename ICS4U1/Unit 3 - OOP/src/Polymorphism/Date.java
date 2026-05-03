package Polymorphism;

public class Date {

	private int day;
	private int month;
	private int year;

	// to determine the month name
	private String[] monthArray = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	// used to determine the number of days in each month
	private int[] dayArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// constant variables for different windows
	public static final int DAY = 0;
	public static final int MONTH = 1;
	public static final int YEAR = 2;

	public Date(String m, int d, int y) {
		day = d;

		int i;
		for (i = 0; i < monthArray.length; i++) {
			if (m.equals(monthArray[i])) {
				month = i + 1;
				break;
			}
		}

		year = y;
	}

	public Date(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}

	public boolean isLeap(int y) {
		if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
			return true;
		}

		// adjust February for leap year
		if (isLeap(year)) {
			dayArray[1] = 29;
		} else {
			dayArray[1] = 28;
		}

		for (int index = 0; index < dayArray.length; index++) {
			if (dayArray[index] < day) {
				day = 1;
				month = index + 1;
			} else {
				day = dayArray[index];
			}
		}

		year = y;
		return false;
	}

	// constructor and mutators
	public Date(Date anotherDay) {
		this.day = anotherDay.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setMonth(String month) {
		for (int i = 0; i < monthArray.length; i++) {
			if (month.equals(monthArray[i])) {
				this.month = i + 1;
			}
		}
	}

	public void setYear(int year) {
		this.year = year;
	}

	// accessor methods
	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	// utility method
	public String toString() {
		return "Date: [day = " + day + ", month = " + month + ", year = " + year + "]";
	}

	public void displayDate() {
		System.out.println(getDay() + "/" + getMonth() + "/" + getYear());
	}

	public void displayDate1() {
		System.out.println(monthArray[getMonth() - 1] + " " + getDay() + ", " + getYear());
	}

	public void displayDate2() {
		System.out.println(getDay() + " " + monthArray[getMonth() - 1] + " " + getYear());
	}

	private int dayNum() {
		int num = 0;
		for (int i = 0; i < (month - 1); i++) {
			num += dayArray[i];
		}
		return num + day;
	}

	public int dayOfYear() {
		return dayNum();
	}
}