/**
 * 
 */
package ru.cos.sim.driver.composite.cases;

import ru.cos.sim.driver.composite.CompositeDriver;
import ru.cos.sim.driver.composite.Perception;
import ru.cos.sim.driver.composite.Percepts;
import ru.cos.sim.driver.composite.cases.utils.AccelerationModelCalculator;
import ru.cos.sim.driver.composite.cases.utils.IDMCalculator;
import ru.cos.sim.driver.composite.framework.CCRange;
import ru.cos.sim.driver.composite.framework.RectangleCCRange;
import ru.cos.sim.driver.data.IDMDriverParameters;

import static ru.cos.sim.driver.composite.framework.Priority.CarFollowing;


/**
 * Car following road case.<br>
 * Current implementation employs IDM car-following model.
 * @author alombard
 */
public class IDMCarFollowingCase extends AbstractCarFollowingCase<IDMDriverParameters> {

	public IDMCarFollowingCase(CompositeDriver driver) {
		super(driver);
		this.accelerationModelCalculator = new IDMCalculator();
	}
	
	// init case
	@Override
	public void init(IDMDriverParameters parameters){
		this.accelerationModelCalculator.init(parameters);
	}

}
