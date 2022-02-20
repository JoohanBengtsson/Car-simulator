/**
 * 
 */
package car_simulator;

/**
 * @author Johan Bengtsson
 *
 */
public class Simulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (Config.DEBUG) {
			args = specifyArgsFromIde();
		}
		
		try {
			Room room = interpretRoomParams(args);
			carCreation(args, room);
			interpretActionCmds(args, room);
			room.presentResults();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("There weren't enough parameters provided, so " + e + " was received.");
		}
	}

	private static String[] specifyArgsFromIde() {
		String[] args = new String[25];
		args[0] = "20";
		args[1] = "20";
		args[2] = "0";
		args[3] = "0";
		args[4] = "N";
		for (int i = 5; i < 25; i++) {
			args[i] = "F";
		}
		return args;
	}
	
	public static Room interpretRoomParams(String[] args) {
		try {
			return new Room(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		} catch (NumberFormatException e) {
			System.err.println("Error, could not parse the first two arguments as integers. Got " + e);
			System.exit(1);
		}
		return null;
	}

	public static void carCreation(String[] args, Room room) {
		int startPosX = Integer.parseInt(args[2]);
		int startPosY = Integer.parseInt(args[3]);
		int directionCar = Room.parseCmdDirection(args[4]);
		room.createCar(new Point(startPosX, startPosY), directionCar);
	}

	public static void interpretActionCmds(String[] args, Room room) {
		int argsLength = args.length;
		for (int i = 5; i < argsLength; i++) {
			room.interpretCommand(args[i]);
		}
	}
}
