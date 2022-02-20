package car_simulator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SystemTest_EastBorder.class, SystemTest_Middle.class, SystemTest_NorthBorder.class,
		SystemTest_SouthBorder.class, SystemTest_WestBorder.class })
public class SystemTests_Suite {

}
