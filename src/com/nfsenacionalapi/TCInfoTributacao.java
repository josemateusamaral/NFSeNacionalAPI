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
 * <p>Classe Java de TCInfoTributacao complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCInfoTributacao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tribMun" type="{http://www.sped.fazenda.gov.br/nfse}TCTribMunicipal"/>
 *         &lt;element name="tribFed" type="{http://www.sped.fazenda.gov.br/nfse}TCTribFederal" minOccurs="0"/>
 *         &lt;element name="totTrib" type="{http://www.sped.fazenda.gov.br/nfse}TCTribTotal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCInfoTributacao", propOrder = {
    "tribMun",
    "tribFed",
    "totTrib"
})
public class TCInfoTributacao {

    @XmlElement(required = true)
    protected TCTribMunicipal tribMun;
    protected TCTribFederal tribFed;
    @XmlElement(required = true)
    protected TCTribTotal totTrib;

    /**
     * Obtém o valor da propriedade tribMun.
     * 
     * @return
     *     possible object is
     *     {@link TCTribMunicipal }
     *     
     */
    public TCTribMunicipal getTribMun() {
        return tribMun;
    }

    /**
     * Define o valor da propriedade tribMun.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTribMunicipal }
     *     
     */
    public void setTribMun(TCTribMunicipal value) {
        this.tribMun = value;
    }

    /**
     * Obtém o valor da propriedade tribFed.
     * 
     * @return
     *     possible object is
     *     {@link TCTribFederal }
     *     
     */
    public TCTribFederal getTribFed() {
        return tribFed;
    }

    /**
     * Define o valor da propriedade tribFed.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTribFederal }
     *     
     */
    public void setTribFed(TCTribFederal value) {
        this.tribFed = value;
    }

    /**
     * Obtém o valor da propriedade totTrib.
     * 
     * @return
     *     possible object is
     *     {@link TCTribTotal }
     *     
     */
    public TCTribTotal getTotTrib() {
        return totTrib;
    }

    /**
     * Define o valor da propriedade totTrib.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTribTotal }
     *     
     */
    public void setTotTrib(TCTribTotal value) {
        this.totTrib = value;
    }

}
