//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.06 at 04:46:28 PM MSK 
//


package ru.cos.sim.visualizer.traffic.graphs.classes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * VerificationManual fig.32. Histogram and theoretical values for headway
 * 
 * <p>Java class for HistogramData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HistogramData">
 *   &lt;complexContent>
 *     &lt;extension base="{}GraphData">
 *       &lt;sequence>
 *         &lt;element name="lines" type="{}line" maxOccurs="unbounded"/>
 *         &lt;element name="bars" type="{}bars"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HistogramData", propOrder = {
    "lines",
    "bars"
})
public class HistogramData
    extends GraphData
{

    @XmlElement(required = true)
    protected List<Line> lines;
    @XmlElement(required = true)
    protected Bars bars;

    /**
     * Gets the value of the lines property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lines property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLines().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Line }
     * 
     * 
     */
    public List<Line> getLines() {
        if (lines == null) {
            lines = new ArrayList<Line>();
        }
        return this.lines;
    }

    /**
     * Gets the value of the bars property.
     * 
     * @return
     *     possible object is
     *     {@link Bars }
     *     
     */
    public Bars getBars() {
        return bars;
    }

    /**
     * Sets the value of the bars property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bars }
     *     
     */
    public void setBars(Bars value) {
        this.bars = value;
    }

}
