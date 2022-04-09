package model;
/**
 * Holds the percentage of completion of the environment manage plan
 */
public class EnvironmentManagePlan {
	/**
	 * The percentage completed out of the environment manage plan
	 */
	private double percentageCompleted;
	/**
	 * the number of maintenance a wetland recieves a year
	 */
	private int numMaintenance;
	/**
	 * Builder for the environment manage plan
	 * @param percentageCompleted
	 * @param numMaintenance
	 */
	public EnvironmentManagePlan(double percentageCompleted, int numMaintenance){
		this.percentageCompleted = percentageCompleted;
		this.numMaintenance = numMaintenance;
	}
	/**
	 * get
	 * @return percentageCompleted
	 */
	public double getPercentageCompleted() {
		return this.percentageCompleted;
	}
	/**
	 * get
	 * @return numMaintenance
	 */
	public int getNumMaintenance() {
		return this.numMaintenance;
	}
	/**
	 * returns all of the data about the environment manage plan
	 */
	public String toString(){
		return "the percentage of the environment manage plan completed is:" + percentageCompleted + "the cuantity of maintenance a year is: " + numMaintenance;
	}

}