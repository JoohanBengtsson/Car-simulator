/**
 * 
 */
package car_simulator;

/**
 * Class for setting up the simulation environment specified in the assignment.
 * When Config.DEBUG == false, the script takes command-line commands in the
 * order as specified in the assignment, and then performs the simulation. In
 * the end, the results of the simulation is presented, and if not successful
 * the reason for failure is presented.
 * 
 * @author Johan Bengtsson
 *
 */
public class Simulator {

	/**
	 * The main-method driving the whole simulator. Note: if Config.DEBUG == true,
	 * args are specified in the function specifyArgsFromIde(), used for
	 * debugging-purposes.
	 * 
	 * @param args - the command-line arguments that are parsed and then used to set
	 *             up the script and run it.
	 */
	public static void main(String[] args) {
		if (Config.DEBUG) {
			args = specifyArgsFromIde();
		}

		if (args.length < 5) {
			System.out.println("Not enough arguments were provided. Terminates the script");
			System.exit(1);
		}

		Room room = interpretRoomParams(args);
		boolean success = carCreation(args, room);
		if (success) {
			interpretActionCmds(args, room);
		}
		room.presentResults();
	}

	/**
	 * Auxiliary function used for running the script from within the IDE. Helpful
	 * for debugging purposes.
	 * 
	 * @return the args as specified here on the form they should be from the CLI.
	 */
	private static String[] specifyArgsFromIde() {
		int lengthArgs = 20;
		String[] args = new String[lengthArgs];
		args[0] = "1";
		args[1] = "1";
		args[2] = "0";
		args[3] = "0";
		args[4] = "w";
		for (int i = 5; i < lengthArgs; i++) {
			args[i] = "F";
		}
		return args;
	}

	/**
	 * Function for interpreting CLI-commands regarding the properties of the room
	 * (width, height).
	 * 
	 * @param args - the command-line arguments that are interpreted for setting up
	 *             the Room.
	 * @return the created Room if the arguments were Integers, otherwise the script
	 *         is stopped.
	 */
	public static Room interpretRoomParams(String[] args) {
		try {
			return new Room(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		} catch (NumberFormatException e) {
			System.err.println("Error, could not parse the first two arguments as integers. Got " + e);
			System.exit(1);
		} catch (NegativeArraySizeException e) {
			System.err.println("Error, a room with negative dimensions cannot be created. Terminates script. ");
			System.exit(1);
		}
		return null;
	}

	/**
	 * Interprets the arguments and creates the car with the specified properties.
	 * 
	 * @param args - the CLI-commands provided and are then interpreted.
	 * @param room - the room in which the car should be created.
	 * @return true if the car was successfully created, otherwise false.
	 */
	public static boolean carCreation(String[] args, Room room) {
		boolean success;
		try {
			int startPosX = Integer.parseInt(args[2]);
			int startPosY = Integer.parseInt(args[3]);
			int directionCar = Room.parseCmdDirection(args[4]);
			success = room.createCar(new Point(startPosX, startPosY), directionCar);
		} catch (NumberFormatException e) {
			System.err.println("Error, could not parse the two arguments as integers. Got " + e);
			System.exit(1);
			success = false;
		}
		return success;
	}

	/**
	 * The function for parsing the action-commands from the CLI. Those are 'F',
	 * 'B', 'L', 'R'. Those are interpreted and then executed.
	 * 
	 * @param args - the CLI-commands provided that are interpreted.
	 * @param room - the Room in which the commands should be executed.
	 */
	public static void interpretActionCmds(String[] args, Room room) {
		int argsLength = args.length;
		for (int i = 5; i < argsLength; i++) {
			room.interpretCommand(args[i]);
		}
	}
}
