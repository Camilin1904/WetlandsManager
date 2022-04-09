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
	private double size;
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
	private double percentageManagePlan;
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
	public Wetland(String name, String location, double size, WetlandType type, String photoUrl, boolean protectedStatus, String zoneName, WetlandLocation zoneType, double percentage){
		this.name =  name;	
		this.location = location;
		this.size = size;
		this.type = type;
		this.photoUrl = photoUrl;
		this.protectedStatus = protectedStatus;
		this.zoneName = zoneName;
		this.zoneType = zoneType;
		percentageManagePlan = percentage;
		speciesFound = new ArrayList<Specie>();
	}

	/**
	 * Assings a new specie to the ones found in the wetland
	 * @param specie
	 */
	public void AssingSpecie(Specie specie){
		speciesFound.add(specie);
	}
	/**
	 * retuns all of the species of the wetland
	 * @return a String with the names of the species
	 */
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
	public void RegisterEvent(Event event){
		events.add(event);
	}
	/**
	 * returns the amount of flora pecies there are in the wetland
	 * @return the amount of flora
	 */
	public int getNumFlora(){
		int size = 0;
		for (int counter=0; counter<speciesFound.size(); counter++){
			if(speciesFound.get(counter).getType().equals(SpecieType.FLORA)){
				size++;
			}
		}
		return size;
	}
	/**
	 * retunrs teh num of fauna species there are in the wetland
	 * @return the amount of fauna
	 */
	public int getNumFauna(){
		int size = 0;
		for (int counter=0; counter<speciesFound.size(); counter++){
			if(speciesFound.get(counter).getType().equals(SpecieType.FAUNA)){
				size++;
			}
		}
		return size;
	}
	/**
	 * returns teh number of maintenance a wetland gets per year
	 * @return teh number of maintenance
	 */
	public int getNumMaintenance(int year){
		int NumMaintenance = 0;
		for (int counter=0; counter<events.size(); counter++){
			if(events.get(counter).getType().equals(model.EventType.MAINTENANCE)){
				if (events.get(counter).getYear()==year){
					NumMaintenance++;
				}
			}
		}
		return NumMaintenance;
	}
	/**
	 * checks if a specie is in the wetland
	 * @param specie
	 * @return a boolean referencin gthe existance of the specie in teh wetland
	 */
	public boolean IsSpecieInHere(Specie specie){
		boolean check = false;
		for(int counter=0; counter<speciesFound.size(); counter++){
			if(specie.equals(speciesFound.get(counter))){
				check = true;
			}
		}
		return check;
	}
	/**
	 * retunrs a string with all of the information for all of the events
	 * @return a mesage with the info
	 */
	public String getEvents(){
		String message = "";
		for (int counter=0; counter<events.size(); counter++){
			message += "\n Event " + (counter+1) + ":" + events.get(counter).toString();
		}
		return message;
	}
	/**
	 * Returns all of the information for a wetland
	 */
	public String toString(){
		return("Name: " + name + "\n" + "Location: " + location + "\n" +"Size: " + size + "m^2" + "\n" +"Type: " + type + "\n" + "Photo url: " + photoUrl + "\n" + "Protected status: " + protectedStatus + "\n" + "Zone name: " + zoneName + "\n" + "Zone type: " + zoneType + "\n" + "percentage completed out of the environment manage plan: " + percentageManagePlan + "%\n" + "The species living in this wetland are: " + getSpeciesAssigned() + "\n" + "The events are: " + getEvents());
	}

}