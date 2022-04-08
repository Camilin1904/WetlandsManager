package model;
/**
 * Stores a date
 */
public class Date {
	/**
	 * The day in the date
	 */
	private int day;
	/**
	 * The month in the date
	 */
	private int month;
	/**
	 * The year of the date
	 */
	private int year;
	/**
	 * Builder for the class Date, taking the date as a string
	 * @param date
	 */
	public Date(String date) {
		day = Integer.parseInt(date.substring(0,2));
		month = Integer.parseInt(date.substring(3,5));
		year = Integer.parseInt(date.substring(6));
	}
	public String toString(){
		return day + "/" + month + "/" + year;
	}

}