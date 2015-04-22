/**
 * 
 */
package ru.cos.sim.driver.data;

import ru.cos.sim.driver.Driver.DriverType;
import ru.cos.sim.driver.composite.CompositeRtAccXDriverParameters;

import java.util.List;


/**
 * 
 * @author alombard
 */
public class CompositeRtAccXDriverData extends DriverData {

	protected List<Integer> route;
	
	protected int destinationNodeId;

	public CompositeRtAccXDriverParameters getParameters() {
		return parameters;
	}

	public void setParameters(CompositeRtAccXDriverParameters parameters) {
		this.parameters = parameters;
	}

	protected CompositeRtAccXDriverParameters parameters;
	
	@Override
	public final DriverType getDriverType() {
		return DriverType.RtAccComposite;
	}

	public List<Integer> getRoute() {
		return route;
	}

	public void setRoute(List<Integer> route) {
		this.route = route;
	}

	public int getDestinationNodeId() {
		return destinationNodeId;
	}

	public void setDestinationNodeId(int destinationNodeId) {
		this.destinationNodeId = destinationNodeId;
	}
	
}
