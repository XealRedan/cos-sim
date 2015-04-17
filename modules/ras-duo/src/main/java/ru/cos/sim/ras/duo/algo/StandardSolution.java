package ru.cos.sim.ras.duo.algo;

import ru.cos.sim.ras.duo.DataSources;
import ru.cos.sim.ras.duo.RoadDigraph;
import ru.cos.sim.ras.duo.Parameters;

public abstract class StandardSolution extends Solution {

	public StandardSolution(RoadDigraph graph, Parameters parameters) {
		super(graph, parameters);
	}

	@Override
	protected abstract StandardWeightProvider getWeightProvider();

	@Override
	protected void collectData(DataSources sources) {
		getWeightProvider().collectData(sources);
	}
}
