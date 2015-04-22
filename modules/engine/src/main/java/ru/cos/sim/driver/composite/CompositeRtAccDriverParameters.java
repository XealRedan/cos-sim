/**
 * 
 */
package ru.cos.sim.driver.composite;

import ru.cos.sim.driver.data.RtAccDriverParameters;

/**
 * 
 * @author zroslaw
 */
public class CompositeRtAccDriverParameters extends CompositeDriverParameters implements RtAccDriverParameters {

	// RT-ACC parameters
	private float rtAccMaxSpeed = 16;
	private float rtAccMaxAcceleration = 2;
	private float rtAccDesiredBraking = -4;
	private float rtAccMinDistance = 2;
	private float rtAccMaxBraking = -8;
	private float rtAccTau = 2;
	
	public float getRtAccMaxSpeed() {
		return rtAccMaxSpeed;
	}

	public void setRtAccMaxSpeed(float rtAccMaxSpeed) {
		this.rtAccMaxSpeed = rtAccMaxSpeed;
	}

	public float getRtAccMaxAcceleration() {
		return rtAccMaxAcceleration;
	}

	public void setRtAccMaxAcceleration(float rtAccMaxAcceleration) {
		this.rtAccMaxAcceleration = rtAccMaxAcceleration;
	}

	public float getRtAccDesiredBraking() {
		return rtAccDesiredBraking;
	}

	public void setRtAccDesiredBraking(float rtAccDesiredBraking) {
		this.rtAccDesiredBraking = rtAccDesiredBraking;
	}

	public float getRtAccMinimalGap() {
		return rtAccMinDistance;
	}

	public void setRtAccMinimalGap(float rtAccMinDistance) {
		this.rtAccMinDistance = rtAccMinDistance;
	}

	public float getRtAccMaxBraking() {
		return rtAccMaxBraking;
	}

	public void setRtAccMaxBraking(float rtAccMaxBraking) {
		this.rtAccMaxBraking = rtAccMaxBraking;
	}

	public float getRtAccTau() {
		return rtAccTau;
	}

	public void setRtAccTau(float rtAccTau) {
		this.rtAccTau = rtAccTau;
	}
}
