/**
 * 
 */
package car_simulator;

import java.util.ArrayList;

/**
 * @author Johan Bengtsson
 *
 */
public class Room {
	private int width;
	private int height;
	private Object[][] room_spots;
	private ArrayList<Car> vehicles;

	public Room(int width, int height) {
		this.width = width;
		this.height = height;
		this.room_spots = new Object[width][height];
		this.vehicles = new ArrayList<>();
	}

	public void createCar(Point startPos, int direction) {
		Car newCar = new Car(1, 1, direction, startPos);
		this.vehicles.add(newCar);
		try {
			room_spots[startPos.getX()][startPos.getY()] = newCar;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: Car was created outside of the room.");
			ResultTracker.failure("The car was created outside of the room. ");
			return;
		}
	}

	public void moveCar(boolean forward) {
		Car car = this.vehicles.get(0);
		Point currSpot = car.getPosition();

		try {
			Point newSpot = car.move(forward);
			changeSpot(newSpot, currSpot);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: The car hit the wall. ");
			ResultTracker.failure("The car hit the wall. ");
			return;
		}

	}

	public void changeSpot(Point newSpot, Point currSpot) {
		this.room_spots[newSpot.getX()][newSpot.getY()] = this.room_spots[currSpot.getX()][currSpot.getY()];
		this.room_spots[currSpot.getX()][currSpot.getY()] = null;
	}

	public boolean interpretCommand(String cmd) {
		Car car = this.vehicles.get(0);
		boolean success = true;
		switch (cmd) {
		case "l":
			car.turn(-90);
			break;
		case "r":
			car.turn(90);
			break;
		case "b":
			moveCar(false);
			break;
		case "f":
			moveCar(true);
			break;
		}
		return success;
	}
	
	public Point writeCarPosition() {
		return this.vehicles.get(0).getPosition();
	}
}
