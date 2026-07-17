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
 * <p>Classe Java de TCRTCInfoImovel complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCRTCInfoImovel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inscImobFisc" type="{http://www.sped.fazenda.gov.br/nfse}TSInscImobFisc" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="cCIB" type="{http://www.sped.fazenda.gov.br/nfse}TSCodCIB"/>
 *           &lt;element name="end" type="{http://www.sped.fazenda.gov.br/nfse}TCEnderObraEvento"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCRTCInfoImovel", propOrder = {
    "inscImobFisc",
    "ccib",
    "end"
})
public class TCRTCInfoImovel {

    protected String inscImobFisc;
    @XmlElement(name = "cCIB")
    protected String ccib;
    protected TCEnderObraEvento end;

    /**
     * Obtém o valor da propriedade inscImobFisc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInscImobFisc() {
        return inscImobFisc;
    }

    /**
     * Define o valor da propriedade inscImobFisc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInscImobFisc(String value) {
        this.inscImobFisc = value;
    }

    /**
     * Obtém o valor da propriedade ccib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCIB() {
        return ccib;
    }

    /**
     * Define o valor da propriedade ccib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCIB(String value) {
        this.ccib = value;
    }

    /**
     * Obtém o valor da propriedade end.
     * 
     * @return
     *     possible object is
     *     {@link TCEnderObraEvento }
     *     
     */
    public TCEnderObraEvento getEnd() {
        return end;
    }

    /**
     * Define o valor da propriedade end.
     * 
     * @param value
     *     allowed object is
     *     {@link TCEnderObraEvento }
     *     
     */
    public void setEnd(TCEnderObraEvento value) {
        this.end = value;
    }

}
