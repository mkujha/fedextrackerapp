//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.24 at 12:24:48 PM EST 
//


package com.demo.fedex.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Details about the eligibility for a delivery option.
 * 
 * <p>Java class for DeliveryOptionEligibilityDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliveryOptionEligibilityDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Option" type="{http://fedex.com/ws/track/v12}DeliveryOptionType" minOccurs="0"/>
 *         &lt;element name="Eligibility" type="{http://fedex.com/ws/track/v12}EligibilityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryOptionEligibilityDetail", propOrder = {
    "option",
    "eligibility"
})
public class DeliveryOptionEligibilityDetail {

    @XmlElement(name = "Option")
    protected DeliveryOptionType option;
    @XmlElement(name = "Eligibility")
    protected EligibilityType eligibility;

    /**
     * Gets the value of the option property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryOptionType }
     *     
     */
    public DeliveryOptionType getOption() {
        return option;
    }

    /**
     * Sets the value of the option property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryOptionType }
     *     
     */
    public void setOption(DeliveryOptionType value) {
        this.option = value;
    }

    /**
     * Gets the value of the eligibility property.
     * 
     * @return
     *     possible object is
     *     {@link EligibilityType }
     *     
     */
    public EligibilityType getEligibility() {
        return eligibility;
    }

    /**
     * Sets the value of the eligibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link EligibilityType }
     *     
     */
    public void setEligibility(EligibilityType value) {
        this.eligibility = value;
    }

}
