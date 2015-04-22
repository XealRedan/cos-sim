/**
 * 
 */
package ru.cos.sim.driver.composite.cases.utils;

import ru.cos.sim.driver.composite.Perception;
import ru.cos.sim.driver.data.RtAccXDriverParameters;
import ru.cos.sim.road.objects.BlockRoadObject;
import ru.cos.sim.road.objects.RoadObject;
import ru.cos.sim.vehicle.RegularVehicle;

/**
 * Calculation of acceleration according to RT-ACC model.
 * @author alombard
 */
// TODO Change this class to use the RT-ACC model
public class RtAccXCalculator implements AccelerationModelCalculator<RtAccXDriverParameters> {
	private float maxAcceleration = 2f; // 4 m/s^2
	private float maxSpeed = 15; //
	private float minDistance = 2.f; // 2m
	private float comfortDeceleration = -2.f; // 2 m/s^2
	private float maxBraking = -8.f; // 8 m/s^2
	private float tau = 2;	// 2s
	
	private float speed = 0;
	private float frontVehicleSpeed = 0;
	private float distance = 5.f; // 5m
	
	// precompiled values
	private float denominator = (float) (2*Math.sqrt(maxAcceleration*comfortDeceleration));

	public void init(RtAccXDriverParameters driver) {
		maxAcceleration = driver.getRtAccMaxAcceleration();
		maxSpeed = driver.getRtAccMaxSpeed();
		minDistance = driver.getRtAccMinimalGap();
		comfortDeceleration = driver.getRtAccDesiredBraking();
		maxBraking = driver.getRtAccMaxBraking();
		tau = driver.getRtAccTau();
	}

	public float calculate(RegularVehicle vehicle, Perception frontVehicle) {
		if (frontVehicle==null) frontVehicle = new Perception(Float.MAX_VALUE, new BlockRoadObject());
		setSpeed(vehicle.getSpeed());
		RoadObject roadObject = frontVehicle.getRoadObject();
		setFrontVehicleSpeed(roadObject.getSpeed());
		setDistance(frontVehicle.getDistance());
		return calculate();
	}

	/**
	 * Calculate acceleration
	 * @return
	 */
	public float calculate(){
		float result=0;

		final double underSquareRoot =
				(this.maxBraking * this.comfortDeceleration * Math.pow(this.tau, 2) +
						4 * this.maxBraking * this.speed * this.tau +
						4 * Math.pow(this.frontVehicleSpeed, 2) -
						8 * this.maxBraking * (this.distance - this.minDistance))
				/ (4 * this.maxBraking * this.comfortDeceleration);

		if(underSquareRoot >= 0) {
			final double as = Math.sqrt(underSquareRoot);

			final double ar =
					(this.comfortDeceleration * this.tau - 2 * this.speed - 2 * this.comfortDeceleration * as) /
							(2 * this.tau);

			result = (float)ar;
		} else {
			// TODO Implement multi-level braking
			result = this.maxBraking;
		}

		return result;
	}

	/**
	 * @return the maxAcceleration
	 */
	public float getMaxAcceleration() {
		return maxAcceleration;
	}

	/**
	 * @return the maxSpeed
	 */
	public float getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @return the minDistance
	 */
	public float getMinDistance() {
		return minDistance;
	}

	/**
	 * @return the maxBraking
	 */
	public float getMaxBraking() {
		return maxBraking;
	}

	/**
	 * @return the comfortDeceleration
	 */
	public float getComfortDeceleration() {
		return comfortDeceleration;
	}

	/**
	 * @return the tau
	 */
	public float getTau() {
		return tau;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @return the frontVehicleSpeed
	 */
	public float getFrontVehicleSpeed() {
		return frontVehicleSpeed;
	}

	/**
	 * @return the distance
	 */
	public float getDistance() {
		return distance;
	}

	/**
	 * @return the denominator
	 */
	public float getDenominator() {
		return denominator;
	}

	/**
	 * @param maxAcceleration the maxAcceleration to set
	 */
	public void setMaxAcceleration(float maxAcceleration) {
		this.maxAcceleration = maxAcceleration;
	}

	/**
	 * @param maxSpeed the maxSpeed to set
	 */
	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * @param minDistance the minDistance to set
	 */
	public void setMinDistance(float minDistance) {
		this.minDistance = minDistance;
	}

	/**
	 * @param maxBraking the desiredTimeHeadway to set
	 */
	public void setMaxBraking(float maxBraking) {
		this.maxBraking = maxBraking;
	}

	/**
	 * @param comfortDeceleration the comfortDeceleration to set
	 */
	public void setComfortDeceleration(float comfortDeceleration) {
		this.comfortDeceleration = comfortDeceleration;
	}

	/**
	 * @param tau the abruptness to set
	 */
	public void setTau(float tau) {
		this.tau = tau;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @param frontVehicleSpeed the frontVehicleSpeed to set
	 */
	public void setFrontVehicleSpeed(float frontVehicleSpeed) {
		this.frontVehicleSpeed = frontVehicleSpeed;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(float distance) {
		this.distance = distance;
	}

	/**
	 * @param denominator the denominator to set
	 */
	public void setDenominator(float denominator) {
		this.denominator = denominator;
	}
	
}
