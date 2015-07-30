
package com.micromuse.response.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loginResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loginResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="result" type="{http://response.micromuse.com/types}WSListenerId"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loginResponse", propOrder = {
    "result"
})
public class LoginResponse {

    @XmlElement(required = true, nillable = true)
    protected WSListenerId result;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link WSListenerId }
     *     
     */
    public WSListenerId getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSListenerId }
     *     
     */
    public void setResult(WSListenerId value) {
        this.result = value;
    }

}
