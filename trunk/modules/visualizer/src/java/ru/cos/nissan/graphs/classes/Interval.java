//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.06 at 04:46:28 PM MSK 
//


package ru.cos.nissan.graphs.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * range to show on the graph
 * 
 * <p>Java class for interval complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="interval">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="color" type="{}color"/>
 *         &lt;element name="axis" type="{}axis"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "interval", propOrder = {

})
public class Interval {

    protected float start;
    protected float end;
    @XmlElement(required = true)
    protected Color color;
    @XmlElement(required = true)
    protected Axis axis;

    /**
     * Gets the value of the start property.
     * 
     */
    public float getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     */
    public void setStart(float value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     */
    public float getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     */
    public void setEnd(float value) {
        this.end = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setColor(Color value) {
        this.color = value;
    }

    /**
     * Gets the value of the axis property.
     * 
     * @return
     *     possible object is
     *     {@link Axis }
     *     
     */
    public Axis getAxis() {
        return axis;
    }

    /**
     * Sets the value of the axis property.
     * 
     * @param value
     *     allowed object is
     *     {@link Axis }
     *     
     */
    public void setAxis(Axis value) {
        this.axis = value;
    }

}
