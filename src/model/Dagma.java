package model;

import java.util.ArrayList;
/**
 * the terminal for all of the data in the different classes of the package model
 */
public class Dagma{

	private final int MAX_WETLANDS = 80;
	/**
	 * the wetlands of cali
	 */
	private Wetland[] wetlands = new Wetland[MAX_WETLANDS];
	/**
	 * the number of wetlands which have been filled with its information
	 */
	private int regWetlands = 0;
	/**
	 * the total number of species living among all of the wetlands
	 */
	private ArrayList<Specie> species = new ArrayList<Specie>();
	private int regSpecies = 0;
	/**
	 * builder for Dagma
	 */
	public Dagma(){
	}
	/**
	 * registers a wetland
	 * @param name
	 * @param location
	 * @param size
	 * @param type
	 * @param photoUrl
	 * @param protectedStatus
	 * @param zoneName
	 * @param zoneType
	 * @param percentageCompleted
	 */
	public void RegisterWetland(String name, String location, String size, int type, String photoUrl, boolean protectedStatus, String zoneName, int zoneType, double percentageCompleted, int numMaintenance) {
		WetlandType wType = null;
		WetlandLocation wLocation = null;
		switch (type){
			case(1):
				wType = WetlandType.PUBLIC;
				break;
			case(2):
				wType = WetlandType.PRIVATE;
				break;
		}
		switch (zoneType){
			case(1):
				wLocation = WetlandLocation.URBAN;
				break;
			case(2):
				wLocation = WetlandLocation.RURAL;
				break;
		}
		wetlands[FindFirstEmptyWetland()] = new Wetland(name, location, size, wType, photoUrl, protectedStatus, zoneName, wLocation, percentageCompleted, numMaintenance);
		regWetlands++;
	}
	public int getMAX_WETLANDS(){	
		return MAX_WETLANDS;
	}
	/**
	 * registers a specie, assings it to the wetlands it inhabits, and assings the wetlands it inhabits to it
	 * @param name
	 * @param scientificName
	 * @param migratoryStatus
	 * @param type
	 * @param newWetland
	 */
	public void RegisterSpecie(String name, String scientificName, boolean migratoryStatus, int type, int sType, ArrayList<Integer> newWetland) {
		Wetland[] newWetlands = new Wetland[newWetland.size()];
		SpecieType spType = null;
		SpecificType spcType = null;
		for (int counter=0; counter<newWetland.size(); counter++){
			newWetlands[counter] = getWetland(newWetland.get(counter));
		}
		switch (type){
			case (1):
				spType = SpecieType.FLORA;
				break;
			case(2):
				spType = SpecieType.FAUNA;
				break;
		}
		switch (sType){
			case (1):
				spcType = SpecificType.TERRESTRIAL;
				break;
			case(2):
				spcType = SpecificType.AQUATIC;
				break;
			case (3):
				spcType = SpecificType.BIRD;
				break;
			case (4):
				spcType = SpecificType.MAMMAL;
				break;
		}
		species.add(new Specie(name, scientificName, migratoryStatus, spType, spcType, newWetlands));
		regSpecies++;
		for (int counter=0; counter<newWetlands.length; counter++){
			for (int counter2=0; counter2<regWetlands; counter2++){
				if (wetlands[counter2].getName().equals(newWetlands[counter].getName())){
					wetlands[counter2].AssingSpecie(species.get(species.size()-1));
				}
			}
		}
	}
	/**
	 * passes the data necesary to register an event to the pertinent method of the pertinent wetland
	 * @param index
	 * @param type
	 * @param organizer
	 * @param description
	 * @param price
	 * @param date
	 */
	public void RegisterEvent(int index, String type, String organizer, String description, double price, String date){
		wetlands[index].RegisterEvent(type, organizer, description, price, date);
	}
	/**
	 * Looks for the wetland with the least ammount of species in it
	 * @return The name of the least populated wetland
	 */
	public String LeastFloraWetland() {
		int min = Integer.MAX_VALUE, minIndex=0;
		for (int counter=0; counter<regWetlands; counter++){
			if (min>wetlands[counter].getNumFlora()){
				min = wetlands[counter].getNumFlora();
				minIndex = counter;
			}
		}
		return wetlands[minIndex].getName();
	}
	/**
	 * Looks for the wetland with the most amkount of species in it
	 * @return the most populated wetland
	 */
	public String MostFaunaWetland() {
		int max = 0, maxIndex=0;
		for (int counter=0; counter<regWetlands; counter++){
			if (max<wetlands[counter].getNumFauna()){
				max = wetlands[counter].getNumFauna();
				maxIndex = counter;
			}
		}
		return wetlands[maxIndex].getName();
	}

	public int getRegWetlands(){
		return regWetlands;
	}
	/**
	 * assings a specie to a new wetland
	 * @param newWetland
	 * @param index
	 */
	public void AssingHabitat(int wetlandIndex, int specieIndex){
		species.get(specieIndex).NewHabitat(wetlands[wetlandIndex]);
		wetlands[wetlandIndex].AssingSpecie(species.get(specieIndex));
	}

	public Wetland getWetland(int index){
		return wetlands[index];
	}
	public int getNumHabitats(int index){
		return species.get(index).getNumWetlandsWhereIsFound();
	}
	public int getNumSpecies(){
		return species.size();
	}
	/**
	 * Returns a String with all of the information for a given wetland
	 * @param index
	 * @return The String with all of the information about the wetland
	 */
	public String PrintAllWetlands(int index){
		return wetlands[index].toString();
	}
	/**
	 * Returns a String with all of the information for a given Specie
	 * @param index
	 * @return The String with all of the information about the Specie
	 */
	public String PrintAllSpecies(int index){
		return species.get(index).toString();
	}

	public int getNumMaintenance(int index){
		return wetlands[index].getNumMaintenance();
	}
	public String getAllHabitats(int index){
		return species.get(index).getHabitats();
	}
	public int FindFirstEmptyWetland(){
		int index = -1;
		for(int counter=0; counter<MAX_WETLANDS&&index<0; counter++){
			if(wetlands[counter]==null){
				index = counter;
			}
		}
		return index;
	}
	public String DisplayWetlands(){
		String message = "";
		int enumeration = 1;
		for (int counter=0; counter<MAX_WETLANDS; counter++){
			if (wetlands[counter]!=null){
				message += enumeration + "). " + wetlands[counter].getName() + "\n";
				enumeration++;
			}
		}
		return message;
	}
	public int FindWetlandIndexDisplay(int index){
		int counter = 0, counter2 = 0;
		if(index<=regWetlands){
			while(counter<index-1){
				counter2++;
				if (wetlands[counter2]!=null){
					counter++;
				}
			}
		}
		else{
			counter2 = -1;
		}
		return counter2;
	}
	public int FindSpecieIndex(String specie){
		int index = -1;
		for (int counter=0; counter<species.size()&&index==-1; counter++){
			if (specie.equals(species.get(counter).getName())){
				index = counter;
			}
		}
		return index;
	}
	public boolean IsSpecieInWetland(int wetlandIndex, int specieIndex){
		return wetlands[wetlandIndex].isSpecieInHere(species.get(specieIndex));
	}
	public String DisplaySpecies(){
		String message = "";
		int enumeration = 1;
		for (int counter=0; counter<species.size(); counter++){
			if (species.get(counter)!=null){
				message += enumeration + "). " + species.get(counter).getName() + "\n";
				enumeration++;
			}
		}
		return message;
	}
	public int FindSpecieIndexDisplay(int index){
		int counter = 0, counter2 = 0;
		if(index<=regSpecies){
			while(counter<index-1){
				counter2++;
				if (species.get(counter2)!=null){
					counter++;
				}
			}
		}
		else{
			counter2 = -1;
		}
		return counter2;
	}
}