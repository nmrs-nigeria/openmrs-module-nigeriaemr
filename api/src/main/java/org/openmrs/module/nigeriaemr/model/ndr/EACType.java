
package org.openmrs.module.nigeriaemr.model.ndr;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for EACType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EACType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisitID" type="{}StringType"/>
 *         &lt;element name="VisitDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="AssessmentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EACSessionType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="FS"/>
 *               &lt;enumeration value="SS"/>
 *               &lt;enumeration value="TS"/>
 *               &lt;enumeration value="OS"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ARVPlan" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="AV1"/>
 *               &lt;enumeration value="AV2"/>
 *               &lt;enumeration value="AV3"/>
 *               &lt;enumeration value="AV4"/>
 *               &lt;enumeration value="AV5"/>
 *               &lt;enumeration value="AV6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EACType", propOrder = {
    "visitID",
    "visitDate",
    "assessmentDate",
    "eacSessionType",
    "arvPlan"
})
public class EACType {

    @XmlElement(name = "VisitID", required = true)
    protected String visitID;
    @XmlElement(name = "VisitDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar visitDate;
    @XmlElement(name = "AssessmentDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar assessmentDate;
    @XmlElement(name = "EACSessionType")
    protected String eacSessionType;
    @XmlElement(name = "ARVPlan")
    protected String arvPlan;

    /**
     * Gets the value of the visitID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisitID() {
        return visitID;
    }

    /**
     * Sets the value of the visitID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisitID(String value) {
        this.visitID = value;
    }

    /**
     * Gets the value of the visitDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVisitDate() {
        return visitDate;
    }

    /**
     * Sets the value of the visitDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVisitDate(XMLGregorianCalendar value) {
        this.visitDate = value;
    }

    /**
     * Gets the value of the assessmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAssessmentDate() {
        return assessmentDate;
    }

    /**
     * Sets the value of the assessmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAssessmentDate(XMLGregorianCalendar value) {
        this.assessmentDate = value;
    }

    /**
     * Gets the value of the eacSessionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEACSessionType() {
        return eacSessionType;
    }

    /**
     * Sets the value of the eacSessionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEACSessionType(String value) {
        this.eacSessionType = value;
    }

    /**
     * Gets the value of the arvPlan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getARVPlan() {
        return arvPlan;
    }

    /**
     * Sets the value of the arvPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setARVPlan(String value) {
        this.arvPlan = value;
    }

}
