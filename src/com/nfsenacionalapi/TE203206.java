//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.12.29 às 04:30:44 PM BRST 
//


package com.nfsenacionalapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TE203206 complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TE203206">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xDesc">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="Rejeição do Tomador"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="infRej" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoEventoRejeicao"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TE203206", propOrder = {
    "xDesc",
    "infRej"
})
public class TE203206 {

    @XmlElement(required = true)
    protected String xDesc;
    @XmlElement(required = true)
    protected TCInfoEventoRejeicao infRej;

    /**
     * Obtém o valor da propriedade xDesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXDesc() {
        return xDesc;
    }

    /**
     * Define o valor da propriedade xDesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXDesc(String value) {
        this.xDesc = value;
    }

    /**
     * Obtém o valor da propriedade infRej.
     * 
     * @return
     *     possible object is
     *     {@link TCInfoEventoRejeicao }
     *     
     */
    public TCInfoEventoRejeicao getInfRej() {
        return infRej;
    }

    /**
     * Define o valor da propriedade infRej.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfoEventoRejeicao }
     *     
     */
    public void setInfRej(TCInfoEventoRejeicao value) {
        this.infRej = value;
    }

}
