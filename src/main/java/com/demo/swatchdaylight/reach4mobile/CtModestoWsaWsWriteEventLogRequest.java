//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.24 at 12:24:50 PM EST 
//


package com.demo.swatchdaylight.reach4mobile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CtModestoWsaWs_WriteEventLogRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CtModestoWsaWs_WriteEventLogRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eventArrivalLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventStatusExceptionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventStatusExceptionDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invoiceNo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="trackingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CtModestoWsaWs_WriteEventLogRequest", namespace = "http://types.wsa.modesto.qualution.com/xsd", propOrder = {
    "eventArrivalLocation",
    "eventCity",
    "eventCountry",
    "eventDate",
    "eventDescription",
    "eventState",
    "eventStatusExceptionCode",
    "eventStatusExceptionDesc",
    "eventType",
    "eventZip",
    "invoiceNo",
    "trackingNumber"
})
public class CtModestoWsaWsWriteEventLogRequest {

    @XmlElement(nillable = true)
    protected String eventArrivalLocation;
    @XmlElement(nillable = true)
    protected String eventCity;
    @XmlElement(nillable = true)
    protected String eventCountry;
    @XmlElement(nillable = true)
    protected String eventDate;
    @XmlElement(nillable = true)
    protected String eventDescription;
    @XmlElement(nillable = true)
    protected String eventState;
    @XmlElement(nillable = true)
    protected String eventStatusExceptionCode;
    @XmlElement(nillable = true)
    protected String eventStatusExceptionDesc;
    @XmlElement(nillable = true)
    protected String eventType;
    @XmlElement(nillable = true)
    protected String eventZip;
    @XmlElement(nillable = true)
    protected Double invoiceNo;
    @XmlElement(nillable = true)
    protected String trackingNumber;

    /**
     * Gets the value of the eventArrivalLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventArrivalLocation() {
        return eventArrivalLocation;
    }

    /**
     * Sets the value of the eventArrivalLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventArrivalLocation(String value) {
        this.eventArrivalLocation = value;
    }

    /**
     * Gets the value of the eventCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventCity() {
        return eventCity;
    }

    /**
     * Sets the value of the eventCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventCity(String value) {
        this.eventCity = value;
    }

    /**
     * Gets the value of the eventCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventCountry() {
        return eventCountry;
    }

    /**
     * Sets the value of the eventCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventCountry(String value) {
        this.eventCountry = value;
    }

    /**
     * Gets the value of the eventDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     * Sets the value of the eventDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventDate(String value) {
        this.eventDate = value;
    }

    /**
     * Gets the value of the eventDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * Sets the value of the eventDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventDescription(String value) {
        this.eventDescription = value;
    }

    /**
     * Gets the value of the eventState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventState() {
        return eventState;
    }

    /**
     * Sets the value of the eventState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventState(String value) {
        this.eventState = value;
    }

    /**
     * Gets the value of the eventStatusExceptionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventStatusExceptionCode() {
        return eventStatusExceptionCode;
    }

    /**
     * Sets the value of the eventStatusExceptionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventStatusExceptionCode(String value) {
        this.eventStatusExceptionCode = value;
    }

    /**
     * Gets the value of the eventStatusExceptionDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventStatusExceptionDesc() {
        return eventStatusExceptionDesc;
    }

    /**
     * Sets the value of the eventStatusExceptionDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventStatusExceptionDesc(String value) {
        this.eventStatusExceptionDesc = value;
    }

    /**
     * Gets the value of the eventType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Sets the value of the eventType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventType(String value) {
        this.eventType = value;
    }

    /**
     * Gets the value of the eventZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventZip() {
        return eventZip;
    }

    /**
     * Sets the value of the eventZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventZip(String value) {
        this.eventZip = value;
    }

    /**
     * Gets the value of the invoiceNo property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * Sets the value of the invoiceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInvoiceNo(Double value) {
        this.invoiceNo = value;
    }

    /**
     * Gets the value of the trackingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Sets the value of the trackingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingNumber(String value) {
        this.trackingNumber = value;
    }

}
