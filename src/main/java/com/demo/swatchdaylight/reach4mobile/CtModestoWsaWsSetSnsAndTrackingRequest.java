//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.24 at 12:24:50 PM EST 
//


package com.demo.swatchdaylight.reach4mobile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CtModestoWsaWs_SetSnsAndTrackingRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CtModestoWsaWs_SetSnsAndTrackingRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inInvDtl" type="{http://types.wsa.modesto.qualution.com/xsd}CtModestoWsaWs_OModWsaInvDtl" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CtModestoWsaWs_SetSnsAndTrackingRequest", namespace = "http://types.wsa.modesto.qualution.com/xsd", propOrder = {
    "inInvDtls"
})
public class CtModestoWsaWsSetSnsAndTrackingRequest {

    @XmlElement(name = "inInvDtl", nillable = true)
    protected List<CtModestoWsaWsOModWsaInvDtl> inInvDtls;

    /**
     * Gets the value of the inInvDtls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inInvDtls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInInvDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CtModestoWsaWsOModWsaInvDtl }
     * 
     * 
     */
    public List<CtModestoWsaWsOModWsaInvDtl> getInInvDtls() {
        if (inInvDtls == null) {
            inInvDtls = new ArrayList<CtModestoWsaWsOModWsaInvDtl>();
        }
        return this.inInvDtls;
    }

}
