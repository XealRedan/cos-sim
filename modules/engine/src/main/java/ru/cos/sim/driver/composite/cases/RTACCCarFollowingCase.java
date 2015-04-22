/**
 * 
 */
package ru.cos.sim.driver.composite.cases;

import ru.cos.sim.driver.composite.CompositeDriver;
import ru.cos.sim.driver.composite.Perception;
import ru.cos.sim.driver.composite.Percepts;
import ru.cos.sim.driver.composite.cases.utils.AccelerationModelCalculator;
import ru.cos.sim.driver.composite.cases.utils.IDMCalculator;
import ru.cos.sim.driver.composite.cases.utils.RTACCCalculator;
import ru.cos.sim.driver.composite.framework.CCRange;
import ru.cos.sim.driver.composite.framework.RectangleCCRange;
import ru.cos.sim.driver.data.IDMDriverParameters;
import ru.cos.sim.driver.data.RTACCDriverParameters;

import static ru.cos.sim.driver.composite.framework.Priority.CarFollowing;


/**
 * Car following road case.<br>
 * Current implementation employs RT-ACC car-following model.
 * @author alombard
 */
public class RTACCCarFollowingCase extends AbstractCarFollowingCase<RTACCDriverParameters> {

	public RTACCCarFollowingCase(CompositeDriver driver) {
		super(driver);
		this.accelerationModelCalculator = new RTACCCalculator();
	}
	
	// init case
	@Override
	public void init(RTACCDriverParameters parameters){
		this.accelerationModelCalculator.init(parameters);
	}

}
