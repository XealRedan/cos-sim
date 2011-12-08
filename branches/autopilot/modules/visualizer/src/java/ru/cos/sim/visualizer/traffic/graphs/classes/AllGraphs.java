//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.06 at 04:46:28 PM MSK 
//


package ru.cos.sim.visualizer.traffic.graphs.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="volumeMeter" type="{}VolumeMeterData"/>
 *         &lt;element name="histogram" type="{}HistogramData"/>
 *         &lt;element name="cumulateVolume" type="{}CumulateVolumeData"/>
 *         &lt;element name="densityFlow" type="{}DensityFlowData"/>
 *         &lt;element name="cumulateVolumeLighted" type="{}CumulateVolumeLightedData"/>
 *         &lt;element name="distanceFromBottleneck" type="{}DistanceFromBottleneckData"/>
 *         &lt;element name="trafficTransitionDiagram" type="{}TrafficTransitionDiagramData"/>
 *         &lt;element name="speed" type="{}SpeedData"/>
 *         &lt;element name="time" type="{}TravelTimeData"/>
 *         &lt;element name="flow" type="{}FlowData"/>
 *         &lt;element name="density" type="{}DensityData"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "volumeMeter",
    "histogram",
    "cumulateVolume",
    "densityFlow",
    "cumulateVolumeLighted",
    "distanceFromBottleneck",
    "trafficTransitionDiagram",
    "speed",
    "time",
    "flow",
    "density"
})
@XmlRootElement(name = "AllGraphs")
public class AllGraphs {

    protected VolumeMeterData volumeMeter;
    protected HistogramData histogram;
    protected CumulateVolumeData cumulateVolume;
    protected DensityFlowData densityFlow;
    protected CumulateVolumeLightedData cumulateVolumeLighted;
    protected DistanceFromBottleneckData distanceFromBottleneck;
    protected TrafficTransitionDiagramData trafficTransitionDiagram;
    protected SpeedData speed;
    protected TravelTimeData time;
    protected FlowData flow;
    protected DensityData density;

    /**
     * Gets the value of the volumeMeter property.
     * 
     * @return
     *     possible object is
     *     {@link VolumeMeterData }
     *     
     */
    public VolumeMeterData getVolumeMeter() {
        return volumeMeter;
    }

    /**
     * Sets the value of the volumeMeter property.
     * 
     * @param value
     *     allowed object is
     *     {@link VolumeMeterData }
     *     
     */
    public void setVolumeMeter(VolumeMeterData value) {
        this.volumeMeter = value;
    }

    /**
     * Gets the value of the histogram property.
     * 
     * @return
     *     possible object is
     *     {@link HistogramData }
     *     
     */
    public HistogramData getHistogram() {
        return histogram;
    }

    /**
     * Sets the value of the histogram property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistogramData }
     *     
     */
    public void setHistogram(HistogramData value) {
        this.histogram = value;
    }

    /**
     * Gets the value of the cumulateVolume property.
     * 
     * @return
     *     possible object is
     *     {@link CumulateVolumeData }
     *     
     */
    public CumulateVolumeData getCumulateVolume() {
        return cumulateVolume;
    }

    /**
     * Sets the value of the cumulateVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link CumulateVolumeData }
     *     
     */
    public void setCumulateVolume(CumulateVolumeData value) {
        this.cumulateVolume = value;
    }

    /**
     * Gets the value of the densityFlow property.
     * 
     * @return
     *     possible object is
     *     {@link DensityFlowData }
     *     
     */
    public DensityFlowData getDensityFlow() {
        return densityFlow;
    }

    /**
     * Sets the value of the densityFlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link DensityFlowData }
     *     
     */
    public void setDensityFlow(DensityFlowData value) {
        this.densityFlow = value;
    }

    /**
     * Gets the value of the cumulateVolumeLighted property.
     * 
     * @return
     *     possible object is
     *     {@link CumulateVolumeLightedData }
     *     
     */
    public CumulateVolumeLightedData getCumulateVolumeLighted() {
        return cumulateVolumeLighted;
    }

    /**
     * Sets the value of the cumulateVolumeLighted property.
     * 
     * @param value
     *     allowed object is
     *     {@link CumulateVolumeLightedData }
     *     
     */
    public void setCumulateVolumeLighted(CumulateVolumeLightedData value) {
        this.cumulateVolumeLighted = value;
    }

    /**
     * Gets the value of the distanceFromBottleneck property.
     * 
     * @return
     *     possible object is
     *     {@link DistanceFromBottleneckData }
     *     
     */
    public DistanceFromBottleneckData getDistanceFromBottleneck() {
        return distanceFromBottleneck;
    }

    /**
     * Sets the value of the distanceFromBottleneck property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistanceFromBottleneckData }
     *     
     */
    public void setDistanceFromBottleneck(DistanceFromBottleneckData value) {
        this.distanceFromBottleneck = value;
    }

    /**
     * Gets the value of the trafficTransitionDiagram property.
     * 
     * @return
     *     possible object is
     *     {@link TrafficTransitionDiagramData }
     *     
     */
    public TrafficTransitionDiagramData getTrafficTransitionDiagram() {
        return trafficTransitionDiagram;
    }

    /**
     * Sets the value of the trafficTransitionDiagram property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficTransitionDiagramData }
     *     
     */
    public void setTrafficTransitionDiagram(TrafficTransitionDiagramData value) {
        this.trafficTransitionDiagram = value;
    }

    /**
     * Gets the value of the speed property.
     * 
     * @return
     *     possible object is
     *     {@link SpeedData }
     *     
     */
    public SpeedData getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedData }
     *     
     */
    public void setSpeed(SpeedData value) {
        this.speed = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link TravelTimeData }
     *     
     */
    public TravelTimeData getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link TravelTimeData }
     *     
     */
    public void setTime(TravelTimeData value) {
        this.time = value;
    }

    /**
     * Gets the value of the flow property.
     * 
     * @return
     *     possible object is
     *     {@link FlowData }
     *     
     */
    public FlowData getFlow() {
        return flow;
    }

    /**
     * Sets the value of the flow property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlowData }
     *     
     */
    public void setFlow(FlowData value) {
        this.flow = value;
    }

    /**
     * Gets the value of the density property.
     * 
     * @return
     *     possible object is
     *     {@link DensityData }
     *     
     */
    public DensityData getDensity() {
        return density;
    }

    /**
     * Sets the value of the density property.
     * 
     * @param value
     *     allowed object is
     *     {@link DensityData }
     *     
     */
    public void setDensity(DensityData value) {
        this.density = value;
    }

}
