package ru.cos.sim.visualizer.traffic.parser;

import java.io.File;
import java.util.logging.Level;

import ru.cos.sim.visualizer.traffic.core.SimulationSystemManager;
import ru.cos.sim.visualizer.traffic.parser.trace.Lane;
import ru.cos.sim.visualizer.traffic.parser.trace.Link;
import ru.cos.sim.visualizer.traffic.parser.trace.base.Node;
import ru.cos.sim.visualizer.traffic.parser.trace.base.TransitionRule;
import ru.cos.sim.visualizer.trace.TraceHandler;
import ru.cos.sim.visualizer.traffic.parser.trace.base.Staff;


public class VisParser extends Parser {

	private TraceHandler handler;
	
	public VisParser(File file) {
		super(file);
		
		logger.log(Level.FINE, "MDF file parsing sucessful");
		
		handler = SimulationSystemManager.getInstance().getTraceHandler();
		
		createNetwork();
		createStaff();
	}
	
	private void createNetwork()
	{
		// Initing RoadNetwork
		initLinks();
		initSegments();
		initLanes();
		
		initNodes();
		initTransitionRules();
		//
		
		//Finish creating road network
		precompleteLSegments();
		completeSegments();
		completeLanes();
		completeRules();
		//
		postCompleteSegments();
		
	}
	
	private void initLinks()
	{
		logger.log(Level.INFO, "Links - begin initialization");
		
		for (Link link : parserCollector.links)
		{
			handler.initLink(link);
		}
		
		logger.log(Level.FINE, "Links sucessfully inited");
	}
	
	private void createStaff()
	{
		logger.log(Level.INFO, "Staff - begin initialization");
		
		for (Staff s : parserCollector.staff) {
			handler.initStaff(s);
		}
		
		logger.log(Level.FINE, "Staff sucessfully inited");
	}
	
	private void initNodes(){
		
		logger.log(Level.INFO, "Nodes - begin initialization");
		
		for (Node node : parserCollector.nodes)
		{
			handler.initNode(node);
		}
		
		logger.log(Level.FINE, "Nodes sucessfully inited");
	}
	
	private void initTransitionRules()
	{
		logger.log(Level.INFO, "Transition rules - begin initialization");
		
		for (TransitionRule rule : parserCollector.rules)
		{
			handler.initRule(rule);
		}
		
		logger.log(Level.FINE, "Transition rules sucessfully inited");
	}
	
	
	private void completeRules()
	{
		logger.log(Level.INFO, "Transition rules - begin completing relations");
		
		for (TransitionRule rule : parserCollector.rules)
		{
			handler.completeRule(rule);
		}
		
		logger.log(Level.FINE, "Transition rules sucessfully completed");
	}
	
	private void initSegments()
	{
		logger.log(Level.INFO, "Segments - begin initialization");
		
		for (Segment s : parserCollector.segments) {
			handler.initSegment(s);
		}
		
		logger.log(Level.FINE, "Segments sucessfully inited");
	}
	
	private void completeSegments()
	{
		logger.log(Level.INFO, "Segments - begin completing process");
		
		for (Segment s : parserCollector.segments)
		{
			handler.completeSegment(s);
		}
		
		
		logger.log(Level.FINE, "Segments relations sucessfully completed");
	}
	
	private void precompleteLSegments()
	{
		logger.log(Level.INFO, "Segments - begin completing process");
		
		for (Segment s : parserCollector.segments)
		{
			handler.precompleteSegment(s);
		}
		
		
		logger.log(Level.FINE, "Segments relations sucessfully completed");
	}
	
	private void postCompleteSegments()
	{
		logger.log(Level.INFO, "Segments - begin post completing process");
		
		for (Segment s : parserCollector.segments)
		{
			handler.segmentPostComplete(s);
		}
		
		logger.log(Level.FINE, "Segments sucessfully completed");
	}
	
	private void completeLanes()
	{
		logger.log(Level.INFO, "Lanes - begin completing process");
		
		for (Lane lane : parserCollector.lanes)
		{
			handler.completeLane(lane);		
		}
		
		logger.log(Level.FINE, "Lanes relations sucessfully completed");
	}
	
	private void initLanes()
	{
		logger.log(Level.INFO, "Lanes - begin initialization");
		
		for (Lane lane : parserCollector.lanes) {
			handler.initLane(lane);
		}
		
		logger.log(Level.FINE, "Lanes sucessfully inited");
	}
	

	 public static void main(String[] args) {
		 String path = "/home/ivan/Downloads/hell-downtown.mdf";
		 VisParser parser = new VisParser(new File(path));
		 return;
	 }
	 

}
