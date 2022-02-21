/**
 * 
 */
package car_simulator;

import java.util.ArrayList;

/**
 * Function for setting up the room in which the Car will be doing the
 * simulation.
 * 
 * @author Johan Bengtsson
 *
 */
public class Room {
	/**
	 * room_spots - is the matrix containing the Cars, in order to keep track of
	 * whether they are behaving correctly on behalf of the simulation rules.
	 * vehicles - an ArrayList of vehicles which should be useful if the simulation
	 * were to be extended towards housing more than one vehicle. resTracker - the
	 * ResultTracker keeping track of the success of the simulation.
	 */
	//private int width;
	//private int height;
	private Object[][] roomSpots;
	private ArrayList<Car> vehicles;
	private ResultTracker resTracker;

	/**
	 * The constructor of the room. Initiates the attributes.
	 * 
	 * @param width  - how wide the room should be.
	 * @param height - how high the room should be.
	 */
	public Room(int width, int height) {
		//this.width = width;
		//this.height = height;
		this.roomSpots = new Object[width][height];
		this.vehicles = new ArrayList<>();
		this.resTracker = new ResultTracker();
	}

	/**
	 * The method used for creating a car. Adds it to this.vehicles in order to be
	 * able to access it later on. This function handles the potential error of
	 * creating cars outside the room, which is a potential cause to errors within
	 * the simulator. Currently, only support for cars of size 1x1 are supported. To
	 * have cars of other sizes, it is necessary to develop some additional support
	 * for that logic.
	 * 
	 * @param startPos  - the start position-Point of the Car.
	 * @param direction - the direction in which the car should initially be headed
	 *                  towards. Anyone of [N, E, S, W].
	 */
	public void createCar(Point startPos, int direction) {
		Car newCar = new Car(1, 1, direction, startPos);
		this.vehicles.add(newCar);
		try {
			roomSpots[startPos.getX()][startPos.getY()] = newCar;
		} catch (ArrayIndexOutOfBoundsException e) {
			if (Config.DEBUG) {
				System.out.println("Error: Car was created outside of the room.");
			}
			this.resTracker.failure("Error: Car was created outside of the room.");
		}
	}

	/**
	 * Method for moving the car within the roomSpots-matrix, used for embodying the
	 * room. Moves the car in this matrix, which then handles the potential errors
	 * of moving outside of the room.
	 * 
	 * @param forward - true if the car should move one step forwards in its
	 *                direction, false if the car should move one step backwards.
	 */
	public void moveCar(boolean forward) {
		Car car = this.vehicles.get(0);
		Point currSpot = car.getPosition();

		try {
			Point newSpot = car.move(forward);
			changeSpot(newSpot, currSpot);
		} catch (ArrayIndexOutOfBoundsException e) {
			if (Config.DEBUG) {
				System.out.println("Error: The car hit the wall. ");
			}
			this.resTracker.failure("Error: The car hit the wall. ");
		}
	}

	/**
	 * A help function for making the change of location in the matrix
	 * this.roomSpots. Moves the Car to the specified Point and nullifies the old
	 * position, which together is an update of the car's position.
	 * 
	 * @param newSpot  - the Point to which the car should move.
	 * @param currSpot - the current Point at which the car is located which should
	 *                 become null.
	 */
	private void changeSpot(Point newSpot, Point currSpot) {
		this.roomSpots[newSpot.getX()][newSpot.getY()] = this.roomSpots[currSpot.getX()][currSpot.getY()];
		this.roomSpots[currSpot.getX()][currSpot.getY()] = null;
	}

	/**
	 * Function for interpreting the command line commands. First makes the command
	 * lower-case to avoid case-sensitiveness. Then using a switch-case, the car
	 * executes the specific command.
	 * 
	 * @param cmd - the String containing the command that should be executed.
	 * @return success - true if the command was successfully executed, false
	 *         otherwise.
	 */
	public void interpretCommand(String cmd) {
		cmd = cmd.toLowerCase();
		Car car = this.vehicles.get(0);
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
		default:
			if (Config.DEBUG) {
				System.out
						.println("An invalid command was used. Ignores it and continues with the remaining commands.");
			}
		}
	}

	/**
	 * A static function for translating String directions into Integers. Namely, it
	 * performs the translation ["N": 0, "E": 90, "S": 180, "W": 270]
	 * 
	 * @param direction - the direction sourcing from the command, any of [N, E, S,
	 *                  W].
	 * @return the integer of how many degrees that direction is.
	 */
	public static int parseCmdDirection(String direction) {
		direction = direction.toLowerCase();
		int intDirection = 0;
		boolean success = false;
		switch (direction) {
		case "n":
			intDirection = 0;
			success = true;
			break;
		case "e":
			intDirection = 90;
			success = true;
			break;
		case "s":
			intDirection = 180;
			success = true;
			break;
		case "w":
			intDirection = 270;
			success = true;
			break;
		}
		if (success == false) {
			System.out.println("Error: An incorrect direction was given. Terminates the script. ");
			System.exit(1);
		}
		return intDirection;
	}

	/**
	 * Function for getting the position of the car, should it be relevant.
	 * 
	 * @return the Point showing the position of the car at the moment.
	 */
	public Point getCarPosition() {
		return this.vehicles.get(0).getPosition();
	}

	/**
	 * The function for presenting the results of the simulation.
	 * 
	 * @return
	 */
	public boolean presentResults() {
		return this.resTracker.presentResults(this.getCarPosition());
	}
}
