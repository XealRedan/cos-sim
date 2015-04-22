/**
 * 
 */
package ru.cos.sim.driver.composite.cases;

import static ru.cos.sim.driver.composite.framework.Priority.CarFollowing;

import ru.cos.sim.driver.AbstractDriver;
import ru.cos.sim.driver.composite.CompositeDriver;
import ru.cos.sim.driver.composite.Perception;
import ru.cos.sim.driver.composite.cases.utils.AccelerationModelCalculator;
import ru.cos.sim.driver.composite.cases.utils.IDMCalculator;
import ru.cos.sim.driver.composite.framework.AbstractBehaviorCase;
import ru.cos.sim.driver.composite.framework.RectangleCCRange;
import ru.cos.sim.driver.data.IDMDriverParameters;
import ru.cos.sim.driver.composite.Percepts;
import ru.cos.sim.driver.composite.framework.CCRange;


/**
 * Abstract car following road case.<br>
 * @author zroslaw
 * @author alombard
 */
public abstract class AbstractCarFollowingCase<AccelerationModelParameters> extends AbstractBehaviorCase {
	
	protected AccelerationModelCalculator<AccelerationModelParameters> accelerationModelCalculator;

	public AbstractCarFollowingCase(AbstractDriver driver) {
		super(driver);
	}
	
	// init case
	public void init(AccelerationModelParameters parameters){
		this.accelerationModelCalculator.init(parameters);
	}

	@Override
	public CCRange behave(float dt) {
		// retrieve information about front car
		Percepts percepts = driver.getPercepts();
		Perception frontObstacle = percepts.getCurrentPercepts().getFrontObstacle();

		float acceleration = this.accelerationModelCalculator.calculate(driver.getVehicle(),frontObstacle);
		
		RectangleCCRange result = new RectangleCCRange();
		result.getAccelerationRange().setHigher(acceleration);
		result.setPriority(CarFollowing);
		
		return result;
	}

}
