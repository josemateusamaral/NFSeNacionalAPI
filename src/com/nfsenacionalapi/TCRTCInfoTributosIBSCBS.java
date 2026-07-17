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
 * <p>Classe Java de TCRTCInfoTributosIBSCBS complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCRTCInfoTributosIBSCBS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gIBSCBS" type="{http://www.sped.fazenda.gov.br/nfse}TCRTCInfoTributosSitClas"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCRTCInfoTributosIBSCBS", propOrder = {
    "gibscbs"
})
public class TCRTCInfoTributosIBSCBS {

    @XmlElement(name = "gIBSCBS", required = true)
    protected TCRTCInfoTributosSitClas gibscbs;

    /**
     * Obtém o valor da propriedade gibscbs.
     * 
     * @return
     *     possible object is
     *     {@link TCRTCInfoTributosSitClas }
     *     
     */
    public TCRTCInfoTributosSitClas getGIBSCBS() {
        return gibscbs;
    }

    /**
     * Define o valor da propriedade gibscbs.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRTCInfoTributosSitClas }
     *     
     */
    public void setGIBSCBS(TCRTCInfoTributosSitClas value) {
        this.gibscbs = value;
    }

}
