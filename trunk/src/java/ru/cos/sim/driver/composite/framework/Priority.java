/**
 * 
 */
package ru.cos.sim.driver.composite.framework;

/**
 * 
 * @author zroslaw
 */
public enum Priority {
	
	Lowest, 
	LaneAlign,
	CarFollowing, 
	LaneChanging, 
	ForthcomingNode,
	RespectQueueCase,
	TrafficLightCase,
	SafetyCase;

	public Priority getHighest(Priority priority){
		return this.compareTo(priority)>0?this:priority;
	}
	
}
