package car_simulator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UnitTest_Car.class, UnitTest_Point.class, UnitTest_ResultTracker.class })
public class UnitTests_Suite {

}
