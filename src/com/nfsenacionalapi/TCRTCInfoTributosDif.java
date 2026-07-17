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
 * <p>Classe Java de TCRTCInfoTributosDif complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCRTCInfoTributosDif">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pDifUF" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2"/>
 *         &lt;element name="pDifMun" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2"/>
 *         &lt;element name="pDifCBS" type="{http://www.sped.fazenda.gov.br/nfse}TSDec3V2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCRTCInfoTributosDif", propOrder = {
    "pDifUF",
    "pDifMun",
    "pDifCBS"
})
public class TCRTCInfoTributosDif {

    @XmlElement(required = true)
    protected String pDifUF;
    @XmlElement(required = true)
    protected String pDifMun;
    @XmlElement(required = true)
    protected String pDifCBS;

    /**
     * Obtém o valor da propriedade pDifUF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDifUF() {
        return pDifUF;
    }

    /**
     * Define o valor da propriedade pDifUF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDifUF(String value) {
        this.pDifUF = value;
    }

    /**
     * Obtém o valor da propriedade pDifMun.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDifMun() {
        return pDifMun;
    }

    /**
     * Define o valor da propriedade pDifMun.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDifMun(String value) {
        this.pDifMun = value;
    }

    /**
     * Obtém o valor da propriedade pDifCBS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDifCBS() {
        return pDifCBS;
    }

    /**
     * Define o valor da propriedade pDifCBS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDifCBS(String value) {
        this.pDifCBS = value;
    }

}
