/**
 * 
 */
package ru.cos.sim.driver.factories;

import ru.cos.cs.agents.framework.Universe;
import ru.cos.sim.driver.RoadRoute;
import ru.cos.sim.driver.composite.CompositeRtAccDriver;
import ru.cos.sim.driver.data.CompositeRtAccDriverData;
import ru.cos.sim.driver.route.RouteProviderFactory;

import java.util.List;

/**
 * 
 * @author zroslaw
 */
public class CompositeRtAccDriverFactory {

	public static CompositeRtAccDriver createDriver(CompositeRtAccDriverData driverData, Universe universe) {
		CompositeRtAccDriver compositeDriver = new CompositeRtAccDriver();

		compositeDriver.setDestinationNodeId(driverData.getDestinationNodeId());
		compositeDriver.setRouteProvider(RouteProviderFactory.createRouteProvider(getRoute(driverData)));
		compositeDriver.setParameters(driverData.getParameters());

		return compositeDriver;
	}

	private static RoadRoute getRoute(CompositeRtAccDriverData driverData) {
		List<Integer> links = driverData.getRoute();
		if (links!=null){
			RoadRoute route = new RoadRoute();
			route.setLinks(links);
			return route;
		} else 
			return null;
	}
}
