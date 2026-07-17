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
 * <p>Classe Java de TCVDescCondIncond complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCVDescCondIncond">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vDescIncond" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="vDescCond" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCVDescCondIncond", propOrder = {
    "vDescIncond",
    "vDescCond"
})
public class TCVDescCondIncond {

    protected String vDescIncond;
    protected String vDescCond;

    /**
     * Obtém o valor da propriedade vDescIncond.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDescIncond() {
        return vDescIncond;
    }

    /**
     * Define o valor da propriedade vDescIncond.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDescIncond(String value) {
        this.vDescIncond = value;
    }

    /**
     * Obtém o valor da propriedade vDescCond.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDescCond() {
        return vDescCond;
    }

    /**
     * Define o valor da propriedade vDescCond.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDescCond(String value) {
        this.vDescCond = value;
    }

}
