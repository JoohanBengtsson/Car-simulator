package car_simulator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SystemTest_NorthBorder {
	private String[] args;

	@Test
	public void forwardBorderTest() {
		int lengthArgs = 6;
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
		assertFalse("The simulation was successful, when it should not. ", room.presentResults());
	}

	@Test
	public void reverseBorderTest() {
		int lengthArgs = 10;
		args = new String[lengthArgs];
		args[0] = "5";
		args[1] = "5";
		args[2] = "4";
		args[3] = "4";
		args[4] = "S";
		Room room = Simulator.interpretRoomParams(args);
		Simulator.carCreation(args, room);
		for (int i = 5; i < lengthArgs; i++) {
			args[i] = "B";
			room.interpretCommand(args[i]);
		}
		assertFalse("The simulation was successful, when it should not. ", room.presentResults());
	}

	@Test
	public void outsideBorder() {
		int lengthArgs = 10;
		args = new String[lengthArgs];
		args[0] = "5";
		args[1] = "5";
		args[2] = "3";
		args[3] = "10";
		args[4] = "W";
		Room room = Simulator.interpretRoomParams(args);
		Simulator.carCreation(args, room);
		assertFalse("The car was created outside the room.", room.presentResults());
	}
}
