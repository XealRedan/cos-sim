/**
 * 
 */
package ru.cos.sim.driver.xml;

import org.jdom.Element;
import ru.cos.sim.driver.composite.CompositeDriverParameters;
import ru.cos.sim.driver.composite.CompositeRtAccDriverParameters;
import ru.cos.sim.driver.data.CompositeDriverData;
import ru.cos.sim.driver.data.CompositeRtAccDriverData;
import ru.cos.sim.mdf.MDFReader;
import ru.cos.sim.road.init.xml.RouteReader;

import java.util.List;


/**
 * 
 * @author alombard
 */
public class CompositeRtAccDriverReader {

	public static final String DESTINATION_NODE_ID = "destinationNodeId";
	public static final String ROUTE = "Route";
	public static final String PARAMETERS = "Parameters";

	public static CompositeRtAccDriverData read(Element driverElement) {
		CompositeRtAccDriverData compositeRtAccDriverData = new CompositeRtAccDriverData();

		Element dstNodeIdElement = driverElement.getChild(DESTINATION_NODE_ID, MDFReader.MDF_NAMESPACE);
		compositeRtAccDriverData.setDestinationNodeId(Integer.parseInt(dstNodeIdElement.getText()));
		
		Element routeElement = driverElement.getChild(ROUTE,MDFReader.MDF_NAMESPACE);
		if (routeElement!=null){
			List<Integer> route = RouteReader.read(routeElement);
			compositeRtAccDriverData.setRoute(route);
		}
		
		Element parametersElement = driverElement.getChild(PARAMETERS,MDFReader.MDF_NAMESPACE);
		CompositeRtAccDriverParameters parameters = CompositeRtAccDriverParametersReader.read(parametersElement);
		compositeRtAccDriverData.setParameters(parameters);
		
		return compositeRtAccDriverData;
	}

}
