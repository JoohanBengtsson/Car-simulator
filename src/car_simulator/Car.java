/**
 * 
 */
package car_simulator;

/**
 * 
 * This class is set up to implement the abstract class of Vehicle. Its purpose
 * is to define the properties of the car within the simulator. The properties
 * may be where it is created, how long and wide it is, in what direction it is
 * pointing, and to store the position.
 * 
 * @author Johan Bengtsson
 *
 */
public class Car extends Vehicle {
	private Point position;

	/**
	 * The constructor of the Car.
	 * 
	 * @param width     - how wide the car should be.
	 * @param length    - how long the car should be.
	 * @param direction - in what direction is it point towards, anyone of [N, E, S,
	 *                  W].
	 * @param position  - its initial position, represented by the class Point which
	 *                  is a 2-dimensional location on the form (x, y)
	 */
	public Car(int width, int length, int direction, Point position) {
		super(width, length, direction);
		this.position = position;
	}

	/**
	 * The function for making a move. Overrides the move() in the class Vehicle.
	 * Depending on the parameter forward, it either goes forward or backward.
	 * 
	 * @param forward - if true, the car drives one square forward in its direction,
	 *                otherwise one square backwards.
	 * @return Point consisting of the car's new position.
	 */
	@Override
	public Point move(boolean forward) {
		int stepLength;
		if (forward) {
			stepLength = 1;
		} else {
			stepLength = -1;
		}

		return this.position = findNewPos(stepLength);
	}

	/**
	 * An auxiliary function for interpreting what direction to move towards.
	 * 
	 * @param stepLength - either 1 or -1, depending on whether the car drives
	 *                   forward or backwards.
	 * @return Point of the car's new position.
	 */
	private Point findNewPos(int stepLength) {
		Point newPos = new Point(this.position.getX(), this.position.getY());
		switch (this.direction) {
		case 0:
			newPos.updateLocation(0, stepLength);
			break;
		case 90:
			newPos.updateLocation(stepLength, 0);
			break;
		case 180:
			newPos.updateLocation(0, -stepLength);
			break;
		case 270:
			newPos.updateLocation(-stepLength, 0);
			break;
		}
		return newPos;
	}

	/**
	 * The function implements the turn()-function of the Vehicle class. Handles the
	 * command telling the car to turn left or right and stores the direction using
	 * the degree-scale. Also handles the case when the sum of turns either goes
	 * below 0 or above 360.
	 * 
	 * @param degrees - the amount of degrees to turn. Either 90 (right) or -90
	 *                (left).
	 */
	@Override
	public void turn(int degrees) {
		this.direction += degrees;

		if (this.direction >= 360) {
			this.direction -= 360;
		} else if (this.direction < 0) {
			this.direction += 360;
		}
	}

	/**
	 * Function for presenting the car's current position.
	 * @return Point indicating the Car's current position.
	 */
	public Point getPosition() {
		return this.position;
	}

}