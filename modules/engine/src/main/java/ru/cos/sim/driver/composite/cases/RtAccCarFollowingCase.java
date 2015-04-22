/**
 * 
 */
package ru.cos.sim.driver.composite.cases;

import ru.cos.sim.driver.AbstractDriver;
import ru.cos.sim.driver.composite.cases.utils.RtAccCalculator;
import ru.cos.sim.driver.data.RtAccDriverParameters;


/**
 * Car following road case.<br>
 * Current implementation employs RT-ACC car-following model.
 * @author alombard
 */
public class RtAccCarFollowingCase extends AbstractCarFollowingCase<RtAccDriverParameters> {

	public RtAccCarFollowingCase(AbstractDriver driver) {
		super(driver);
		this.accelerationModelCalculator = new RtAccCalculator();
	}
	
	// init case
	@Override
	public void init(RtAccDriverParameters parameters){
		this.accelerationModelCalculator.init(parameters);
	}

}
