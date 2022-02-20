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
	private static int reg_nr = 1;

	public Vehicle(int width, int length, int direction) {
		this.width = width;
		this.length = length;
		this.direction = direction;
		this.reg_nr = this.reg_nr;
		this.reg_nr++;
	}

	abstract Point move(boolean forward);

	abstract void turn(int degrees);
}