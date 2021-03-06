package model;

import java.util.ArrayList;
/**
 * The characteristics of a specie inhabiting one or more wetlands
 */
public class Specie {
	/**
	 * The wetlands where this specie is found
	 */
	private ArrayList<Wetland> wetlandsWhereIsFound = new ArrayList<Wetland>();
	/**
	 * The name of the specie
	 */
	private String name;
	/**
	 * The scientific name of the specie
	 */
	private String scientificName;
	/**
	 * Whether the specie migrates or not
	 */
	private boolean migratoryStatus;
	/**
	 * The type of specie
	 */
	private SpecieType type;

	private SpecificType sType;

	/**
	 * Builder for the class Specie
	 * @param name
	 * @param scientificName
	 * @param migratoryStatus
	 * @param type
	 */
	public Specie(String name, String scientificName, boolean migratoryStatus, SpecieType type, SpecificType sType, Wetland[] newWetlands) {
		for (int counter=0; counter<newWetlands.length; counter++){
			this.wetlandsWhereIsFound.add(newWetlands[counter]);
		}
		this.name =  name;
		this.scientificName = scientificName;
		this.migratoryStatus = migratoryStatus;
		this.type = type;
		this.sType = sType;
	}

	public String getName() {
		return this.name;
	}
	
	public String getScientificName(){
		return scientificName;
	}

	/**
	 * Adds a new wetland to the congloperate of wetlands that the specie inhabits
	 * @param newWetland
	 */
	public void NewHabitat(Wetland newWetland){
		wetlandsWhereIsFound.add(newWetland);
	}
	/**
	 * returns the type pf the specie
	 */
	public SpecieType getType(){	
		return type;
	}
	/**
	 * returns all of the wetlands teh specie is found
	 * @return a String with the name of the wetlands
	 */
	public String getHabitats(){
		String message = "";
		for (int counter=0; counter<wetlandsWhereIsFound.size(); counter++){
			message += " " + wetlandsWhereIsFound.get(counter).getName() + ",";
		}
		return message;
	}
	/**
	 * returns the ammount of habitatas
	 * @return wetlandsWhereIsFound-size()
	 */
	public int getNumWetlandsWhereIsFound(){
		return wetlandsWhereIsFound.size();
	}
	/**
	 * returns a string with all of the information of a specie
	 */
	public String toString(){
		return ("Name : " + name + "\n Scientific name: " + scientificName + "\nMigratory status: " + migratoryStatus + "\nType: " + type + " " + sType + "\nHabitats: " + getHabitats() + "\n");
	}

}