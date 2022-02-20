/**
 * 
 */
package car_simulator;

/**
 * 
 * Class for keeping track of the results of a simulation. Is instantiated when
 * the Room is instantiated.
 * 
 * @author Johan Bengtsson
 *
 */
public class ResultTracker {
	private boolean successful = true;
	private String reason;

	/**
	 * Function called when a failure has happened. Stores that the simulation was a
	 * failure and also stores the reason for the failure to be written.
	 * 
	 * @param reasonForFailure - the reason for which the simulation was not
	 *                         successful.
	 */
	public void failure(String reasonForFailure) {
		this.successful = false;
		this.reason = reasonForFailure;
	}

	/**
	 * The function which in the end presents the results of the simulation.
	 * 
	 * @param pointOfCar - the Car's last position if the simulation is successful,
	 *                   null otherwise.
	 * @return true or false, depending on whether the script was successful or not.
	 */
	public boolean presentResults(Point pointOfCar) {
		if (this.successful) {
			System.out.println("The simulation was successful. The car's end position was " + pointOfCar.toString());
		} else {
			System.err.println("The simulation failed, due to: " + this.reason);
		}
		return successful;
	}

	/**
	 * Method for getting the success-boolean of the simulation. Just for accessing
	 * the attribute.
	 * 
	 * @return true if no error has occurred, false if it has occurred.
	 */
	public boolean getSuccess() {
		return this.successful;
	}
}
