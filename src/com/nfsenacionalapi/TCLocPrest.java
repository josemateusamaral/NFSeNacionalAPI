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
 * <p>Classe Java de TCLocPrest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCLocPrest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="cLocPrestacao" type="{http://www.sped.fazenda.gov.br/nfse}TSCodMunIBGE"/>
 *         &lt;element name="cPaisPrestacao" type="{http://www.sped.fazenda.gov.br/nfse}TSCodPaisISO"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCLocPrest", propOrder = {
    "cLocPrestacao",
    "cPaisPrestacao"
})
public class TCLocPrest {

    protected String cLocPrestacao;
    protected String cPaisPrestacao;

    /**
     * Obtém o valor da propriedade cLocPrestacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLocPrestacao() {
        return cLocPrestacao;
    }

    /**
     * Define o valor da propriedade cLocPrestacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLocPrestacao(String value) {
        this.cLocPrestacao = value;
    }

    /**
     * Obtém o valor da propriedade cPaisPrestacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPaisPrestacao() {
        return cPaisPrestacao;
    }

    /**
     * Define o valor da propriedade cPaisPrestacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPaisPrestacao(String value) {
        this.cPaisPrestacao = value;
    }

}
