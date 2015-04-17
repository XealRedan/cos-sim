package ru.cos.sim.visualizer.scene.impl;

import ru.cos.sim.visualizer.trace.item.base.TrafficLight;

public interface ITrafficLight extends IPlaceable{
	public void switchLight(TrafficLight.Color color);
	public TrafficLight.Color getLightColor();
	public Float getPosition();
}
