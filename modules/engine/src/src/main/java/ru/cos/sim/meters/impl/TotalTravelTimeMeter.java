/**
 * 
 */
package ru.cos.sim.meters.impl;

import ru.cos.sim.meters.impl.data.Time;
import ru.cos.sim.meters.framework.ModesInitData;

/**
 *
 * @author zroslaw
 */
public class TotalTravelTimeMeter extends AbstractMeter<Time> {

	public TotalTravelTimeMeter(int id,
			ModesInitData modesInitData) {
		super(id, MeterType.TotalTravelTimeMeter, modesInitData, null, new DumbAverageDataCollectorFactory<Time>());
	}

}
