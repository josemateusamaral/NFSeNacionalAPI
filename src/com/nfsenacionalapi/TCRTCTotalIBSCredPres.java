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
 * <p>Classe Java de TCRTCTotalIBSCredPres complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCRTCTotalIBSCredPres">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pCredPresIBS" type="{http://www.sped.fazenda.gov.br/nfse}TSDec2V2"/>
 *         &lt;element name="vCredPresIBS" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCRTCTotalIBSCredPres", propOrder = {
    "pCredPresIBS",
    "vCredPresIBS"
})
public class TCRTCTotalIBSCredPres {

    @XmlElement(required = true)
    protected String pCredPresIBS;
    @XmlElement(required = true)
    protected String vCredPresIBS;

    /**
     * Obtém o valor da propriedade pCredPresIBS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPCredPresIBS() {
        return pCredPresIBS;
    }

    /**
     * Define o valor da propriedade pCredPresIBS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPCredPresIBS(String value) {
        this.pCredPresIBS = value;
    }

    /**
     * Obtém o valor da propriedade vCredPresIBS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCredPresIBS() {
        return vCredPresIBS;
    }

    /**
     * Define o valor da propriedade vCredPresIBS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCredPresIBS(String value) {
        this.vCredPresIBS = value;
    }

}
