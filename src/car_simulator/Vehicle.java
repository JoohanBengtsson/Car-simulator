/**
 * 
 */
package car_simulator;

/**
 * The abstract class show-casing what needs to be implemented. Provides the
 * possibility to create new kinds of Vehicles, should it be necessary.
 * 
 * @author Johan Bengtsson
 *
 */
public abstract class Vehicle {
	private int width;
	private int length;
	protected int direction;
	private int regNr;
	private static int globalRegNr = 1;

	/**
	 * The constructor of the Vehicle. States what attributes are common for all
	 * Vehicles in the simulator.
	 * 
	 * @param width     - how wide should the Vehicle be. (Currently only width=1 is
	 *                  fully supported)
	 * @param length    - how long should the Vehicle be. (Currently only length=1
	 *                  is fully supported)
	 * @param direction - in what direction the Vehicle should be headed. Anyone of
	 *                  [N, E, S, W].
	 */
	public Vehicle(int width, int length, int direction) {
		this.width = width;
		this.length = length;
		this.direction = direction;
		this.regNr = globalRegNr;
		globalRegNr++;
	}

	/**
	 * Method for what happens when the Vehicle should move. Either forward or
	 * backward.
	 * 
	 * @param forward - true if it should move forward, false if it should move
	 *                backwards.
	 * @return the Point which is the Vehicles new position after the move.
	 */
	abstract Point move(boolean forward);

	/**
	 * The method for turning the Vehicle according to the commands. Either right or
	 * left, which here is stated as either 90 or -90 degrees.
	 * 
	 * @param degrees - an Integer on how many degrees to turn. Either right (90) or
	 *                left (-90).
	 */
	abstract void turn(int degrees);
}