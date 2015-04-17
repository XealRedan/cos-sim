package ru.cos.sim.ras.duo;

import ru.cos.sim.ras.duo.utils.Extendable;
import sim.ras.duo.digraph.Edge;

public interface PathExtensions extends Extendable {
	
	public Edge getEdge();
	
	public PathExtensions getPreceeding();
	
}
