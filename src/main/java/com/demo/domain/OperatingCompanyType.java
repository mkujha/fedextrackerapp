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
 * <p>Java class for OperatingCompanyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OperatingCompanyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FEDEX_CARGO"/>
 *     &lt;enumeration value="FEDEX_CORPORATE_SERVICES"/>
 *     &lt;enumeration value="FEDEX_CORPORATION"/>
 *     &lt;enumeration value="FEDEX_CUSTOMER_INFORMATION_SYSTEMS"/>
 *     &lt;enumeration value="FEDEX_CUSTOM_CRITICAL"/>
 *     &lt;enumeration value="FEDEX_EXPRESS"/>
 *     &lt;enumeration value="FEDEX_FREIGHT"/>
 *     &lt;enumeration value="FEDEX_GROUND"/>
 *     &lt;enumeration value="FEDEX_KINKOS"/>
 *     &lt;enumeration value="FEDEX_OFFICE"/>
 *     &lt;enumeration value="FEDEX_SERVICES"/>
 *     &lt;enumeration value="FEDEX_TRADE_NETWORKS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OperatingCompanyType")
@XmlEnum
public enum OperatingCompanyType {

    FEDEX_CARGO,
    FEDEX_CORPORATE_SERVICES,
    FEDEX_CORPORATION,
    FEDEX_CUSTOMER_INFORMATION_SYSTEMS,
    FEDEX_CUSTOM_CRITICAL,
    FEDEX_EXPRESS,
    FEDEX_FREIGHT,
    FEDEX_GROUND,
    FEDEX_KINKOS,
    FEDEX_OFFICE,
    FEDEX_SERVICES,
    FEDEX_TRADE_NETWORKS;

    public String value() {
        return name();
    }

    public static OperatingCompanyType fromValue(String v) {
        return valueOf(v);
    }

}
