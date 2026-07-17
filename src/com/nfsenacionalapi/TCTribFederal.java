//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2025.12.29 às 04:30:44 PM BRST 
//


package com.nfsenacionalapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TCTribFederal complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCTribFederal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="piscofins" type="{http://www.sped.fazenda.gov.br/nfse}TCTribOutrosPisCofins" minOccurs="0"/>
 *         &lt;element name="vRetCP" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="vRetIRRF" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="vRetCSLL" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCTribFederal", propOrder = {
    "piscofins",
    "vRetCP",
    "vRetIRRF",
    "vRetCSLL"
})
public class TCTribFederal {

    protected TCTribOutrosPisCofins piscofins;
    protected String vRetCP;
    protected String vRetIRRF;
    protected String vRetCSLL;

    /**
     * Obtém o valor da propriedade piscofins.
     * 
     * @return
     *     possible object is
     *     {@link TCTribOutrosPisCofins }
     *     
     */
    public TCTribOutrosPisCofins getPiscofins() {
        return piscofins;
    }

    /**
     * Define o valor da propriedade piscofins.
     * 
     * @param value
     *     allowed object is
     *     {@link TCTribOutrosPisCofins }
     *     
     */
    public void setPiscofins(TCTribOutrosPisCofins value) {
        this.piscofins = value;
    }

    /**
     * Obtém o valor da propriedade vRetCP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVRetCP() {
        return vRetCP;
    }

    /**
     * Define o valor da propriedade vRetCP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVRetCP(String value) {
        this.vRetCP = value;
    }

    /**
     * Obtém o valor da propriedade vRetIRRF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVRetIRRF() {
        return vRetIRRF;
    }

    /**
     * Define o valor da propriedade vRetIRRF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVRetIRRF(String value) {
        this.vRetIRRF = value;
    }

    /**
     * Obtém o valor da propriedade vRetCSLL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVRetCSLL() {
        return vRetCSLL;
    }

    /**
     * Define o valor da propriedade vRetCSLL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVRetCSLL(String value) {
        this.vRetCSLL = value;
    }

}
