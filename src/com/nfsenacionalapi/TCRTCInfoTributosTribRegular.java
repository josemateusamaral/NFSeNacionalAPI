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
 * <p>Classe Java de TCRTCInfoTributosTribRegular complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCRTCInfoTributosTribRegular">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CSTReg" type="{http://www.sped.fazenda.gov.br/nfse}TSRTCCodSitTrib"/>
 *         &lt;element name="cClassTribReg" type="{http://www.sped.fazenda.gov.br/nfse}TSRTCCodClassTrib"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCRTCInfoTributosTribRegular", propOrder = {
    "cstReg",
    "cClassTribReg"
})
public class TCRTCInfoTributosTribRegular {

    @XmlElement(name = "CSTReg", required = true)
    protected String cstReg;
    @XmlElement(required = true)
    protected String cClassTribReg;

    /**
     * Obtém o valor da propriedade cstReg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSTReg() {
        return cstReg;
    }

    /**
     * Define o valor da propriedade cstReg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSTReg(String value) {
        this.cstReg = value;
    }

    /**
     * Obtém o valor da propriedade cClassTribReg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCClassTribReg() {
        return cClassTribReg;
    }

    /**
     * Define o valor da propriedade cClassTribReg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCClassTribReg(String value) {
        this.cClassTribReg = value;
    }

}
