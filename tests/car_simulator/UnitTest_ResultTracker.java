package car_simulator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnitTest_ResultTracker {
	private ResultTracker rt;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		rt = new ResultTracker();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDefaultSuccess() {
		assertTrue("Success was not true from the beginning", this.rt.getSuccess());
	}
	
	@Test
	public void testFailure() {
		rt.failure("Test reasons");
		assertFalse("Success was not false after calling failure()", this.rt.getSuccess());
	}

}
