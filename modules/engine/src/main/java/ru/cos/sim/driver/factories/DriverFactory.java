/**
 * 
 */
package ru.cos.sim.driver.factories;

import ru.cos.cs.agents.framework.Universe;
import ru.cos.sim.driver.Driver;
import ru.cos.sim.driver.data.CompositeDriverData;
import ru.cos.sim.driver.data.CompositeRtAccDriverData;
import ru.cos.sim.driver.data.DriverData;
import ru.cos.sim.driver.DriverException;

/**
 * 
 * @author zroslaw
 */
public class DriverFactory {

	public static Driver createDriver(DriverData driverData, Universe universe) {
		Driver driver;
		
		switch (driverData.getDriverType()){
		case Composite:
			driver = CompositeDriverFactory.createDriver((CompositeDriverData) driverData, universe);
			break;
		case RtAccComposite:
			driver = CompositeRtAccDriverFactory.createDriver((CompositeRtAccDriverData) driverData, universe);
			break;
		default: throw new DriverException("Unable to create driver instance, unexpected driver type"+driverData.getDriverType());
		}
		
		return driver;
	}

}
