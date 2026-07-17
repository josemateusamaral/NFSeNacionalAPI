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
 * <p>Classe Java de TCRTCValoresIBSCBS complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCRTCValoresIBSCBS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vBC" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2"/>
 *         &lt;element name="vCalcReeRepRes" type="{http://www.sped.fazenda.gov.br/nfse}TSDec15V2" minOccurs="0"/>
 *         &lt;element name="uf" type="{http://www.sped.fazenda.gov.br/nfse}TCRTCValoresIBSCBSUF"/>
 *         &lt;element name="mun" type="{http://www.sped.fazenda.gov.br/nfse}TCRTCValoresIBSCBSMun"/>
 *         &lt;element name="fed" type="{http://www.sped.fazenda.gov.br/nfse}TCRTCValoresIBSCBSFed"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCRTCValoresIBSCBS", propOrder = {
    "vbc",
    "vCalcReeRepRes",
    "uf",
    "mun",
    "fed"
})
public class TCRTCValoresIBSCBS {

    @XmlElement(name = "vBC", required = true)
    protected String vbc;
    protected String vCalcReeRepRes;
    @XmlElement(required = true)
    protected TCRTCValoresIBSCBSUF uf;
    @XmlElement(required = true)
    protected TCRTCValoresIBSCBSMun mun;
    @XmlElement(required = true)
    protected TCRTCValoresIBSCBSFed fed;

    /**
     * Obtém o valor da propriedade vbc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVBC() {
        return vbc;
    }

    /**
     * Define o valor da propriedade vbc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVBC(String value) {
        this.vbc = value;
    }

    /**
     * Obtém o valor da propriedade vCalcReeRepRes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVCalcReeRepRes() {
        return vCalcReeRepRes;
    }

    /**
     * Define o valor da propriedade vCalcReeRepRes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVCalcReeRepRes(String value) {
        this.vCalcReeRepRes = value;
    }

    /**
     * Obtém o valor da propriedade uf.
     * 
     * @return
     *     possible object is
     *     {@link TCRTCValoresIBSCBSUF }
     *     
     */
    public TCRTCValoresIBSCBSUF getUf() {
        return uf;
    }

    /**
     * Define o valor da propriedade uf.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRTCValoresIBSCBSUF }
     *     
     */
    public void setUf(TCRTCValoresIBSCBSUF value) {
        this.uf = value;
    }

    /**
     * Obtém o valor da propriedade mun.
     * 
     * @return
     *     possible object is
     *     {@link TCRTCValoresIBSCBSMun }
     *     
     */
    public TCRTCValoresIBSCBSMun getMun() {
        return mun;
    }

    /**
     * Define o valor da propriedade mun.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRTCValoresIBSCBSMun }
     *     
     */
    public void setMun(TCRTCValoresIBSCBSMun value) {
        this.mun = value;
    }

    /**
     * Obtém o valor da propriedade fed.
     * 
     * @return
     *     possible object is
     *     {@link TCRTCValoresIBSCBSFed }
     *     
     */
    public TCRTCValoresIBSCBSFed getFed() {
        return fed;
    }

    /**
     * Define o valor da propriedade fed.
     * 
     * @param value
     *     allowed object is
     *     {@link TCRTCValoresIBSCBSFed }
     *     
     */
    public void setFed(TCRTCValoresIBSCBSFed value) {
        this.fed = value;
    }

}
