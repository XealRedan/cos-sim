package ru.cos.sim.driver.composite.cases.utils;

import ru.cos.sim.driver.composite.Perception;
import ru.cos.sim.vehicle.RegularVehicle;

/**
 * Created by alombard on 22/04/2015.
 */
public interface AccelerationModelCalculator<AccelerationModelParameters> {
    public void init(AccelerationModelParameters accelerationModelParameters);
    public float calculate(RegularVehicle vehicle, Perception frontVehicle);
}
