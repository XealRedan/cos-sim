package ru.cos.sim.ras.duo;

import sim.ras.duo.digraph.Edge;

public interface WeightProvider {

	public float getWeight(Edge edge, PathExtensions extensions);
	
}
