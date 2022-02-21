package car_simulator;

import static org.junit.Assert.*;

import org.junit.Test;

public class SystemTest_Middle {
	private String[] args;

	@Test
	public void middleDriveAroundTest() {
		int lengthArgs = 20;
		args = new String[lengthArgs];
		args[0] = "20";
		args[1] = "20";
		args[2] = "10";
		args[3] = "10";
		args[4] = "N";
		Room room = Simulator.interpretRoomParams(args);
		Simulator.carCreation(args, room);

		// First combination of cmds and test
		room.interpretCommand("R");
		room.interpretCommand("F");
		assertEquals("The car could not turn right and then drive forward. Instead had position: " + room.getCarPosition().toString(),
				room.getCarPosition().toString(), "11, 10");

		// Second combination
		room.interpretCommand("R");
		room.interpretCommand("F");
		assertEquals("The car could not turn right and then drive forward. Instead had position: " + room.getCarPosition().toString(),
				room.getCarPosition().toString(), "11, 9");

		// Third combination
		room.interpretCommand("R");
		room.interpretCommand("F");
		assertEquals("The car could not turn right and then drive forward. Instead had position: " + room.getCarPosition().toString(),
				room.getCarPosition().toString(), "10, 9");

		// Fourth combination
		room.interpretCommand("R");
		room.interpretCommand("F");
		room.interpretCommand("F");
		assertEquals("The car could not turn right and then drive forward. Instead had position: " + room.getCarPosition().toString(),
				room.getCarPosition().toString(), "10, 11");

		// Fifth combination
		room.interpretCommand("R");
		room.interpretCommand("F");
		assertEquals("The car could not turn right and then drive forward. Instead had position: " + room.getCarPosition().toString(),
				room.getCarPosition().toString(), "11, 11");

		// Sixth combination
		room.interpretCommand("B");
		assertEquals("The car could not reverse properly. Instead had position: " + room.getCarPosition().toString(),
				room.getCarPosition().toString(), "10, 11");

		// Last combination
		room.interpretCommand("L");
		room.interpretCommand("F");
		assertEquals("The car could not turn left and then drive forward. Instead had position: " + room.getCarPosition().toString(),
				room.getCarPosition().toString(), "10, 12");
	}
}
