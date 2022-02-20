package car_simulator;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import car_simulator.Room;

public class SystemTest_NorthBorder {
	private String[] args;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int lengthArgs = 10;
		args = new String[lengthArgs];
		args[0] = "5";
		args[1] = "5";
		args[2] = "4";
		args[3] = "4";
		args[4] = "N";
		Room room = Simulator.interpretRoomParams(args);
		Simulator.carCreation(args, room);
		for (int i = 5; i < lengthArgs; i++) {
			args[i] = "F";
			room.interpretCommand(args[i]);
		}
	}

}
