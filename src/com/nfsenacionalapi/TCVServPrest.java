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
 * <p>Classe Java de TCVServPrest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCVServPrest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vReceb" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="vServ" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCVServPrest", propOrder = {
    "vReceb",
    "vServ"
})
public class TCVServPrest {

    protected String vReceb;
    @XmlElement(required = true)
    protected String vServ;

    /**
     * Obtém o valor da propriedade vReceb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVReceb() {
        return vReceb;
    }

    /**
     * Define o valor da propriedade vReceb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVReceb(String value) {
        this.vReceb = value;
    }

    /**
     * Obtém o valor da propriedade vServ.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVServ() {
        return vServ;
    }

    /**
     * Define o valor da propriedade vServ.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVServ(String value) {
        this.vServ = value;
    }

}
