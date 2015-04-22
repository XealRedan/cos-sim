/**
 * 
 */
package ru.cos.sim.driver.factories;

import ru.cos.cs.agents.framework.Universe;
import ru.cos.sim.driver.RoadRoute;
import ru.cos.sim.driver.composite.CompositeRtAccXDriver;
import ru.cos.sim.driver.data.CompositeRtAccXDriverData;
import ru.cos.sim.driver.route.RouteProviderFactory;

import java.util.List;

/**
 * 
 * @author zroslaw
 */
public class CompositeRtAccXDriverFactory {

	public static CompositeRtAccXDriver createDriver(CompositeRtAccXDriverData driverData, Universe universe) {
		CompositeRtAccXDriver compositeDriver = new CompositeRtAccXDriver();

		compositeDriver.setDestinationNodeId(driverData.getDestinationNodeId());
		compositeDriver.setRouteProvider(RouteProviderFactory.createRouteProvider(getRoute(driverData)));
		compositeDriver.setParameters(driverData.getParameters());

		return compositeDriver;
	}

	private static RoadRoute getRoute(CompositeRtAccXDriverData driverData) {
		List<Integer> links = driverData.getRoute();
		if (links!=null){
			RoadRoute route = new RoadRoute();
			route.setLinks(links);
			return route;
		} else 
			return null;
	}
}
