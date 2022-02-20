/**
 * 
 */
package car_simulator;

/**
 * @author Johan Bengtsson
 *
 */
public class ResultTracker {
	private boolean successful = true;
	private String reason;

	public void failure(String reasonForFailure) {
		this.successful = false;
		this.reason = reasonForFailure;
	}

	public boolean presentResults(Point pointOfCar) {
		if (this.successful) {
			System.out.println("The simulation was successful. The car's end position was " + pointOfCar.toString());
		} else {
			System.err.println("The simulation failed, due to: " + this.reason);
		}
		return successful;
	}

	public boolean getSuccess() {
		return this.successful;
	}
}
