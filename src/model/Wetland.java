package model;

import java.util.ArrayList;
/**
 * The different wetlands of Cali
 */
public class Wetland{
	/**
	 * The name of the wetland
	 */
	private String name;
	/**
	 * The location of the wetland
	 */
	private String location;
	/**
	 * The size of the wetland in m^2
	 */
	private String size;
	/**
	 * the type of the wetland
	 */
	private WetlandType type;
	/**
	 * the url to a photo of the wetland
	 */
	private String photoUrl;
	/**
	 * Whether the wetland is protecter or not
	 */
	private boolean protectedStatus;
	/**
	 * The name of the zone the wetland is found on
	 */
	private String zoneName;
	/**
	 * The type of the zone the wetland is found on
	 */
	private WetlandLocation zoneType;
	/**
	 * the species that inhabit the wetland
	 */
	private ArrayList<Specie> speciesFound;
	/**
	 * how advanced the envirnment manage plan is
	 */
	private EnvironmentManagePlan maintenance;
	/**
	 * the events being planned in the wetland
	 */
	private ArrayList<Event> events = new ArrayList<Event>();
	/**
	 * getter for name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Builder for Wetland
	 * @param name
	 * @param location
	 * @param size
	 * @param type
	 * @param photoUrl
	 * @param protectedStatus
	 * @param zoneName
	 * @param zoneType
	 */
	public Wetland(String name, String location, String size, WetlandType type, String photoUrl, boolean protectedStatus, String zoneName, WetlandLocation zoneType, double percentageCompleted, int numMaintenance) {
		maintenance = new EnvironmentManagePlan(percentageCompleted, numMaintenance);
		this.name =  name;	
		this.location = location;
		this.size = size;
		this.type = type;
		this.photoUrl = photoUrl;
		this.protectedStatus = protectedStatus;
		this.zoneName = zoneName;
		this.zoneType = zoneType;
		speciesFound = new ArrayList<Specie>();
	}

	/**
	 * Assings a new specie to teh ones found in the wetland
	 * @param specie
	 */
	public void AssingSpecie(Specie specie){
		speciesFound.add(specie);
	}

	public String getSpeciesAssigned(){
		String message = "";
		for (int counter=0; counter<speciesFound.size(); counter++){
			message += " " + speciesFound.get(counter).getName() + ",";
		}
		return message;
	}
	/**
	 * Registers an event
	 * @param type
	 * @param organizer
	 * @param description
	 * @param price
	 * @param date
	 */
	public void RegisterEvent(String type, String organizer, String description, double price, String date){
		events.add(new Event(type, organizer, price, description, date));
	}

	public int getNumFlora(){
		int size = 0;
		for (int counter=0; counter<speciesFound.size(); counter++){
			if(speciesFound.get(counter).gType().equals(SpecieType.FLORA)){
				size++;
			}
		}
		return size;
	}
	public int getNumFauna(){
		int size = 0;
		for (int counter=0; counter<speciesFound.size(); counter++){
			if(speciesFound.get(counter).gType().equals(SpecieType.FAUNA)){
				size++;
			}
		}
		return size;
	}
	public int getNumMaintenance(){
		return maintenance.getNumMaintenance();
	}
	public boolean isSpecieInHere(Specie specie){
		boolean check = false;
		for(int counter=0; counter<speciesFound.size(); counter++){
			if(specie.equals(speciesFound.get(counter))){
				check = true;
			}
		}
		return check;
	}
	public String getEvents(){
		String message = "";
		for (int counter=0; counter<events.size(); counter++){
			message += "\n Event " + (counter+1) + ":" + events.get(counter).toString();
		}
		return message;
	}
	public String toString(){
		return("Name: " + name + "\n" + "Location: " + location + "\n" +"Size: " + size + "m^2" + "\n" +"Type: " + type + "\n" + "Photo url: " + photoUrl + "\n" + "Protected status: " + protectedStatus + "\n" + "Zone name: " + zoneName + "\n" + "Zone type: " + zoneType + "\n" + "percentage completed out of the environment manage plan: " + maintenance.getPercentageCompleted() + "\n" + "The ammount of maintenance a year is: " + maintenance.getNumMaintenance() + "\n" + "The species living in this wetland are: " + getSpeciesAssigned() + "\n" + "The events are: " + getEvents());
	}

}