//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.24 at 10:26:12 AM EST 
//


package com.demo.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SpecialInstructionStatusDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpecialInstructionStatusDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://demo.com/ws/track/v12}SpecialInstructionsStatusCode" minOccurs="0"/>
 *         &lt;element name="StatusCreateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecialInstructionStatusDetail", propOrder = {
    "status",
    "statusCreateTime"
})
public class SpecialInstructionStatusDetail {

    @XmlElement(name = "Status")
    protected SpecialInstructionsStatusCode status;
    @XmlElement(name = "StatusCreateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar statusCreateTime;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialInstructionsStatusCode }
     *     
     */
    public SpecialInstructionsStatusCode getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialInstructionsStatusCode }
     *     
     */
    public void setStatus(SpecialInstructionsStatusCode value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusCreateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStatusCreateTime() {
        return statusCreateTime;
    }

    /**
     * Sets the value of the statusCreateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStatusCreateTime(XMLGregorianCalendar value) {
        this.statusCreateTime = value;
    }

}
