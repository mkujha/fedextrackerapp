//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.24 at 10:26:15 AM EST 
//


package com.demo.swatchdaylight.reach4mobile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence>
 *         &lt;element name="Exception" type="{http://www.qualution.com}AbstractException" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "exception"
})
@XmlRootElement(name = "Exception")
public class Exception {

    @XmlElement(name = "Exception", nillable = true)
    protected AbstractException exception;

    /**
     * Gets the value of the exception property.
     * 
     * @return
     *     possible object is
     *     {@link AbstractException }
     *     
     */
    public AbstractException getException() {
        return exception;
    }

    /**
     * Sets the value of the exception property.
     * 
     * @param value
     *     allowed object is
     *     {@link AbstractException }
     *     
     */
    public void setException(AbstractException value) {
        this.exception = value;
    }

}