/**
 * 
 */
package car_simulator;

/**
 * @author Johan Bengtsson
 *
 */
public abstract class Vehicle {
	private int width;
	private int length;
	protected int direction;
	private int regNr;
	private static int globalRegNr = 1;

	public Vehicle(int width, int length, int direction) {
		this.width = width;
		this.length = length;
		this.direction = direction;
		this.regNr = globalRegNr;
		globalRegNr++;
	}

	abstract Point move(boolean forward);

	abstract void turn(int degrees);
}