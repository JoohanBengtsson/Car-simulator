package car_simulator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnitTest_Car {

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
	public void moveForwardTest() {
		int width = 1;
		int length = 1;
		int direction = 0;
		Point position = new Point(1, 1);
		Car car = new Car(position, direction);
		assertTrue("The car did not have the correct position before moving. ", car.getPosition().equals(new Point(1, 1)));
		car.move(true);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(1, 2)));
	}
	
	@Test
	public void moveBackwardTest() {
		int width = 1;
		int length = 1;
		int direction = 0;
		Point position = new Point(1, 1);
		Car car = new Car(position, direction);
		assertTrue("The car did not have the correct position before moving. ", car.getPosition().equals(new Point(1, 1)));
		car.move(false);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(1, 0)));
	}
	
	@Test
	public void rightTurnTest() {
		int width = 1;
		int length = 1;
		int direction = 0;
		Point position = new Point(1, 1);
		Car car = new Car(position, direction);
		assertTrue("The car did not have the correct position before moving. ", car.getPosition().equals(new Point(1, 1)));
		car.turn(90);
		car.move(true);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(2, 1)));
		car.turn(90);
		car.move(true);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(2, 0)));
		car.turn(90);
		car.move(true);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(1, 0)));
		car.turn(90);
		car.move(true);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(1, 1)));
		car.turn(90);
		car.move(true);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(2, 1)));
	}
	
	@Test
	public void leftTurnTest() {
		int width = 1;
		int length = 1;
		int direction = 0;
		Point position = new Point(1, 1);
		Car car = new Car(position, direction);
		assertTrue("The car did not have the correct position before moving. ", car.getPosition().equals(new Point(1, 1)));
		car.turn(-90);
		car.move(true);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(0, 1)));
		car.turn(-90);
		car.move(true);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(0, 0)));
		car.turn(-90);
		car.move(true);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(1, 0)));
		car.turn(-90);
		car.move(true);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(1, 1)));
		car.turn(-90);
		car.move(true);
		assertTrue("The car did not have the correct position after moving. ", car.getPosition().equals(new Point(0, 1)));
	}
}
