/**
 * 
 */
package car_simulator;

/**
 * @author Johan Bengtsson
 *
 */
public class Car extends Vehicle {
	private Point position;

	public Car(int width, int length, int direction, Point position) {
		super(width, length, direction);
		this.position = position;
	}

	@Override
	public void move(boolean forward) {
		int stepLength;
		if (forward) {
			stepLength = 1;
		} else {
			stepLength = -1;
		}

		this.position = findNewPos(stepLength);
	}

	private Point findNewPos(int stepLength) {
		Point newPos = new Point(this.position.getX(), this.position.getY());
		switch (this.direction) {
		case 'N':
			newPos.updateLocation(0, stepLength);
			break;
		case 'E':
			newPos.updateLocation(stepLength, 0);
			break;
		case 'S':
			newPos.updateLocation(0, -stepLength);
			break;
		case 'W':
			newPos.updateLocation(-stepLength, 0);
			break;
		}
		return newPos;
	}

	@Override
	public void turn(int degrees) {
		this.direction += degrees;
		
		if (this.direction >= 360) {
			this.direction -= 360;
		} else if (this.direction < 0) {
			this.direction += 360;
		}
	}

}