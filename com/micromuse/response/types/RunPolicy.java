
package com.micromuse.response.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for runPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="runPolicy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSListenerId_1" type="{http://response.micromuse.com/types}WSListenerId"/>
 *         &lt;element name="String_2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="arrayOfWSPolicyUserParameter_3" type="{http://response.micromuse.com/types}WSPolicyUserParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="boolean_4" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "runPolicy", propOrder = {
    "wsListenerId1",
    "string2",
    "arrayOfWSPolicyUserParameter3",
    "boolean4"
})
public class RunPolicy {

    @XmlElement(name = "WSListenerId_1", required = true, nillable = true)
    protected WSListenerId wsListenerId1;
    @XmlElement(name = "String_2", required = true, nillable = true)
    protected String string2;
    @XmlElement(name = "arrayOfWSPolicyUserParameter_3", nillable = true)
    protected List<WSPolicyUserParameter> arrayOfWSPolicyUserParameter3;
    @XmlElement(name = "boolean_4")
    protected boolean boolean4;

    /**
     * Gets the value of the wsListenerId1 property.
     * 
     * @return
     *     possible object is
     *     {@link WSListenerId }
     *     
     */
    public WSListenerId getWSListenerId1() {
        return wsListenerId1;
    }

    /**
     * Sets the value of the wsListenerId1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSListenerId }
     *     
     */
    public void setWSListenerId1(WSListenerId value) {
        this.wsListenerId1 = value;
    }

    /**
     * Gets the value of the string2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getString2() {
        return string2;
    }

    /**
     * Sets the value of the string2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setString2(String value) {
        this.string2 = value;
    }

    /**
     * Gets the value of the arrayOfWSPolicyUserParameter3 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrayOfWSPolicyUserParameter3 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrayOfWSPolicyUserParameter3().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WSPolicyUserParameter }
     * 
     * 
     */
    public List<WSPolicyUserParameter> getArrayOfWSPolicyUserParameter3() {
        if (arrayOfWSPolicyUserParameter3 == null) {
            arrayOfWSPolicyUserParameter3 = new ArrayList<WSPolicyUserParameter>();
        }
        return this.arrayOfWSPolicyUserParameter3;
    }

    /**
     * Gets the value of the boolean4 property.
     * 
     */
    public boolean isBoolean4() {
        return boolean4;
    }

    /**
     * Sets the value of the boolean4 property.
     * 
     */
    public void setBoolean4(boolean value) {
        this.boolean4 = value;
    }

}
