/**
 * 
 */
package ru.cos.sim.driver.composite.cases;

import ru.cos.sim.driver.AbstractDriver;
import ru.cos.sim.driver.composite.cases.utils.RtAccXCalculator;
import ru.cos.sim.driver.data.RtAccXDriverParameters;


/**
 * Car following road case.<br>
 * Current implementation employs RT-ACC car-following model.
 * @author alombard
 */
public class RtAccXCarFollowingCase extends AbstractCarFollowingCase<RtAccXDriverParameters> {

	public RtAccXCarFollowingCase(AbstractDriver driver) {
		super(driver);
		this.accelerationModelCalculator = new RtAccXCalculator();
	}
	
	// init case
	@Override
	public void init(RtAccXDriverParameters parameters){
		this.accelerationModelCalculator.init(parameters);
	}

}
