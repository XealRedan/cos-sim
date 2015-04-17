/**
 * 
 */
package ru.cos.sim.vehicle.init.data;

import ru.cos.sim.agents.TrafficAgent;
import ru.cos.sim.driver.data.DriverData;
import ru.cos.sim.vehicle.Vehicle;

/**
 * Regular vehicle data.
 * @author zroslaw
 */
public class RegularVehicleData extends VehicleData {
	
	protected float length;
	
	protected float width;
	
	protected Vehicle.VehicleClass vehicleClass;
	
	protected DriverData driverData;
	
	@Override
	public final Vehicle.VehicleType getVehicleType() {
		return Vehicle.VehicleType.RegularVehicle;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public DriverData getDriverData() {
		return driverData;
	}

	public void setDriverData(DriverData driverData) {
		this.driverData = driverData;
	}

	@Override
	public Vehicle.VehicleClass getVehicleClass() {
		return vehicleClass;
	}

	public void setVehicleClass(Vehicle.VehicleClass vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	@Override
	public final TrafficAgent.TrafficAgentType getTrafficAgentType() {
		return TrafficAgent.TrafficAgentType.Vehicle;
	}

}
