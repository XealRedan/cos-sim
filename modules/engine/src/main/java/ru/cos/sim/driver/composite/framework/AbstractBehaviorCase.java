/**
 * 
 */
package ru.cos.sim.driver.composite.framework;

import ru.cos.sim.driver.AbstractDriver;
import ru.cos.sim.driver.composite.CompositeDriver;

/**
 * 
 * @author zroslaw
 */
public abstract class AbstractBehaviorCase extends BehaviorCase {

	protected AbstractDriver driver;
	
	public AbstractBehaviorCase(AbstractDriver driver){
		this.driver = driver;
	}

}
