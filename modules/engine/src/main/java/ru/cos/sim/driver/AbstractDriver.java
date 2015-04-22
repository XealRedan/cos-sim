/**
 * 
 */
package ru.cos.sim.driver;

import ru.cos.sim.driver.composite.CompositeDriverParameters;
import ru.cos.sim.driver.composite.Percepts;
import ru.cos.sim.driver.composite.cases.MandatoryLaneChangingCase;
import ru.cos.sim.driver.composite.cases.RouterCase;
import ru.cos.sim.road.link.Lane;
import ru.cos.sim.vehicle.RegularVehicle;

/**
 * 
 * @author zroslaw
 */
public abstract class AbstractDriver implements Driver{

	protected static float frontVisibleRange = 200f;

	protected int destinationNodeId;
	
	protected RegularVehicle vehicle;

	protected Percepts percepts;

	protected CompositeDriverParameters parameters;

	protected RouterCase routerCase;
	protected MandatoryLaneChangingCase mandatoryLaneChangingCase;

	@Override
	public RegularVehicle getVehicle() {
		return vehicle;
	}

	@Override
	public void setVehicle(RegularVehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getDestinationNodeId() {
		return destinationNodeId;
	}

	public void setDestinationNodeId(int destinationNodeId) {
		this.destinationNodeId = destinationNodeId;
	}

	public Percepts getPercepts() {
		return percepts;
	}

	public RouterCase getRouter() {
		return routerCase;
	}

	/**
	 * Retrieve lane from which driver wants to enter the node.
	 * @return desired incoming lane
	 */
	public Lane getNodesDesiredIncomingLane() {
		return mandatoryLaneChangingCase.getDesiredLane();
	}

	public float getFrontVisibleRange() {
		return frontVisibleRange;
	}

	public CompositeDriverParameters getParameters() {
		return parameters;
	}
}
