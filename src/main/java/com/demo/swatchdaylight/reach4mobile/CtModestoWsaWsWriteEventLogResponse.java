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
 * <p>Java class for CtModestoWsaWs_WriteEventLogResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CtModestoWsaWs_WriteEventLogResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="problemDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recordNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CtModestoWsaWs_WriteEventLogResponse", namespace = "http://types.wsa.modesto.qualution.com/xsd", propOrder = {
    "problemDesc",
    "recordNo",
    "resultCode"
})
public class CtModestoWsaWsWriteEventLogResponse {

    @XmlElement(nillable = true)
    protected String problemDesc;
    @XmlElement(nillable = true)
    protected Integer recordNo;
    @XmlElement(nillable = true)
    protected Integer resultCode;

    /**
     * Gets the value of the problemDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProblemDesc() {
        return problemDesc;
    }

    /**
     * Sets the value of the problemDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProblemDesc(String value) {
        this.problemDesc = value;
    }

    /**
     * Gets the value of the recordNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRecordNo() {
        return recordNo;
    }

    /**
     * Sets the value of the recordNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRecordNo(Integer value) {
        this.recordNo = value;
    }

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResultCode(Integer value) {
        this.resultCode = value;
    }

}
