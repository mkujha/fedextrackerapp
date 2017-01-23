//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.23 at 12:08:40 PM EST 
//


package com.demo.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Time Range specified in local time.
 * 
 * <p>Java class for LocalTimeRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocalTimeRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Begins" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ends" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalTimeRange", propOrder = {
    "begins",
    "ends"
})
public class LocalTimeRange {

    @XmlElement(name = "Begins")
    protected String begins;
    @XmlElement(name = "Ends")
    protected String ends;

    /**
     * Gets the value of the begins property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBegins() {
        return begins;
    }

    /**
     * Sets the value of the begins property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBegins(String value) {
        this.begins = value;
    }

    /**
     * Gets the value of the ends property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnds() {
        return ends;
    }

    /**
     * Sets the value of the ends property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnds(String value) {
        this.ends = value;
    }

}
