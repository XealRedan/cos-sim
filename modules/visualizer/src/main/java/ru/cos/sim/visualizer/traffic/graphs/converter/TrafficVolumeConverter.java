package ru.cos.sim.visualizer.traffic.graphs.converter;

import ru.cos.sim.meters.impl.data.TrafficVolume;
import ru.cos.sim.visualizer.traffic.graphs.classes.Point;
import ru.cos.sim.visualizer.traffic.graphs.classes.PointCollection;
import ru.cos.sim.visualizer.traffic.graphs.classes.Line;
import ru.cos.sim.visualizer.traffic.graphs.classes.VolumeMeterData;

public class TrafficVolumeConverter extends AbstractConverter<Line, VolumeMeterData,
        TrafficVolume> implements DataConverter<VolumeMeterData, TrafficVolume>{
    @Override
    public float[] getValue(TrafficVolume measuredData) {
        float[] data = new float[2];
        data[1] = measuredData.floatValue();
        return data;
    }

    @Override
    protected VolumeMeterData getGraphDataInstance() {
        return new VolumeMeterData();
    }

    @Override
    protected Line getPointCollection() {
        return new Line();
    }

    @Override
    protected Point convertMeasuredData(float time, TrafficVolume trafficVolume) {
        Point p = new Point();
        p.setX(time);
        p.setY(trafficVolume.floatValue());
        return p;
    }

    @Override
    protected void addDatasetToGraphData(VolumeMeterData graphData, PointCollection pointCollection) {
        graphData.getLines().add((Line)pointCollection);
    }
}
