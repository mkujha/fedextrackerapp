//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.23 at 12:08:40 PM EST 
//


package com.demo.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OfficeOrderDeliveryMethodType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OfficeOrderDeliveryMethodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COURIER"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="PICKUP"/>
 *     &lt;enumeration value="SHIPMENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OfficeOrderDeliveryMethodType")
@XmlEnum
public enum OfficeOrderDeliveryMethodType {

    COURIER,
    OTHER,
    PICKUP,
    SHIPMENT;

    public String value() {
        return name();
    }

    public static OfficeOrderDeliveryMethodType fromValue(String v) {
        return valueOf(v);
    }

}