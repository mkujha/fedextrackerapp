//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.24 at 10:26:12 AM EST 
//


package com.demo.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrackDeliveryOptionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TrackDeliveryOptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="APPOINTMENT"/>
 *     &lt;enumeration value="DATE_CERTAIN"/>
 *     &lt;enumeration value="ELECTRONIC_SIGNATURE_RELEASE"/>
 *     &lt;enumeration value="EVENING"/>
 *     &lt;enumeration value="REDIRECT_TO_HOLD_AT_LOCATION"/>
 *     &lt;enumeration value="REROUTE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrackDeliveryOptionType")
@XmlEnum
public enum TrackDeliveryOptionType {

    APPOINTMENT,
    DATE_CERTAIN,
    ELECTRONIC_SIGNATURE_RELEASE,
    EVENING,
    REDIRECT_TO_HOLD_AT_LOCATION,
    REROUTE;

    public String value() {
        return name();
    }

    public static TrackDeliveryOptionType fromValue(String v) {
        return valueOf(v);
    }

}
