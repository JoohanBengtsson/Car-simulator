/**
 * 
 */
package car_simulator;

/**
 * @author Johan Bengtsson
 *
 */
public class ResultTracker {
	private static boolean successful = true;
	private static String reason;
	
	public static void failure(String reasonForFailure) {
		successful = false;
		reason = reasonForFailure;
		presentResults();
		System.exit(0);
	}
	
	public static void presentResults() {
		if (successful) {
			System.out.println("The simulation was successful. ");			
		} else {
			System.err.println("The simulation failed, due to: " + reason);
		}
		System.exit(0);
	}	
	
	public static void presentResults(Point pointOfCar) {
		if (successful) {
			System.out.println("The simulation was successful. The car's end position was " + pointOfCar.toString());			
		} else {
			System.err.println("The simulation failed, due to: " + reason);
		}
	}	
}
