package model;

public class Event{
	/**
	 * Stores the type of event
	 */
	private String type;
	/**
	 * Stores the name of the organizer of the event
	 */
	private String organizer;
	/**
	 * Stores the price of the event
	 */
	private double price;
	/**
	 * Stores a description for the event
	 */
	private String description;
	/**
	 * Object containing the date of the event
	 */
	private Date date;

	/**
	 * Builder for the class Event
	 * @param type
	 * @param organizer
	 * @param price
	 * @param description
	 */
	public Event(String type, String organizer, double price, String description, String date) {
		this.type = type;
		this.organizer = organizer;
		this.description = description;
		this.price = price;
		this.date = new Date(date);
	}

	public String toString(){
		return "\n Type: " + type + "\n Organizer: " + organizer + "\n Price: " + price + "\n Description: " + description +"\n Date: " + date.toString();
	}

}