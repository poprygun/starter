
package com.holidaywebservice.holidayservice_v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HolidayDateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HolidayDateType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Observed"/&gt;
 *     &lt;enumeration value="Actual"/&gt;
 *     &lt;enumeration value="ObservedActual"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HolidayDateType")
@XmlEnum
public enum HolidayDateType {

    @XmlEnumValue("Observed")
    OBSERVED("Observed"),
    @XmlEnumValue("Actual")
    ACTUAL("Actual"),
    @XmlEnumValue("ObservedActual")
    OBSERVED_ACTUAL("ObservedActual");
    private final String value;

    HolidayDateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HolidayDateType fromValue(String v) {
        for (HolidayDateType c: HolidayDateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
