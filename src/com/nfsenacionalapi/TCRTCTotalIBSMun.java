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
 * <p>Classe Java de TCRTCTotalIBSMun complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCRTCTotalIBSMun">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vDifMun" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="vIBSMun" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCRTCTotalIBSMun", propOrder = {
    "vDifMun",
    "vibsMun"
})
public class TCRTCTotalIBSMun {

    protected String vDifMun;
    @XmlElement(name = "vIBSMun", required = true)
    protected String vibsMun;

    /**
     * Obtém o valor da propriedade vDifMun.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDifMun() {
        return vDifMun;
    }

    /**
     * Define o valor da propriedade vDifMun.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDifMun(String value) {
        this.vDifMun = value;
    }

    /**
     * Obtém o valor da propriedade vibsMun.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVIBSMun() {
        return vibsMun;
    }

    /**
     * Define o valor da propriedade vibsMun.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVIBSMun(String value) {
        this.vibsMun = value;
    }

}
