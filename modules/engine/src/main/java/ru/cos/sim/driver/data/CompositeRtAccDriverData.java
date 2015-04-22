/**
 * 
 */
package ru.cos.sim.driver.data;

import ru.cos.sim.driver.Driver.DriverType;
import ru.cos.sim.driver.composite.CompositeRtAccDriverParameters;

import java.util.List;


/**
 * 
 * @author alombard
 */
public class CompositeRtAccDriverData extends DriverData {

	protected List<Integer> route;
	
	protected int destinationNodeId;

	public CompositeRtAccDriverParameters getParameters() {
		return parameters;
	}

	public void setParameters(CompositeRtAccDriverParameters parameters) {
		this.parameters = parameters;
	}

	protected CompositeRtAccDriverParameters parameters;
	
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
