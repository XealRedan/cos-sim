/**
 * 
 */
package ru.cos.sim.driver.data;

/**
 * Driver parameters of RT-ACC model
 * @author alombard
 */
public interface RTACCDriverParameters {

	public float getRtAccMaxAcceleration();

	public float getRtAccMaxSpeed();

	public float getRtAccMinimalGap();

	public float getRtAccDesiredBraking();

	public float getRtAccMaxBraking();

	public float getRtAccTau();

	public void setRtAccMaxAcceleration(float rtAccMaxAcceleration);

	public void setRtAccMaxSpeed(float rtAccMaxSpeed);

	public void setRtAccMinimalGap(float rtAccMinimalGap);

	public void setRtAccDesiredBraking(float rtAccDesiredBraking);

	public void setRtAccMaxBraking(float rtAccMaxBraking);

	public void setRtAccTau(float rtAccTau);
	
}
