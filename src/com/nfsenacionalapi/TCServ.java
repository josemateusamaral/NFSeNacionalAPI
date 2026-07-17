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
 * <p>Classe Java de TCServ complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TCServ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="locPrest" type="{http://www.sped.fazenda.gov.br/nfse}TCLocPrest"/>
 *         &lt;element name="cServ" type="{http://www.sped.fazenda.gov.br/nfse}TCCServ"/>
 *         &lt;element name="comExt" type="{http://www.sped.fazenda.gov.br/nfse}TCComExterior" minOccurs="0"/>
 *         &lt;element name="obra" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoObra" minOccurs="0"/>
 *         &lt;element name="atvEvento" type="{http://www.sped.fazenda.gov.br/nfse}TCAtvEvento" minOccurs="0"/>
 *         &lt;element name="explRod" type="{http://www.sped.fazenda.gov.br/nfse}TCExploracaoRodoviaria" minOccurs="0"/>
 *         &lt;element name="infoCompl" type="{http://www.sped.fazenda.gov.br/nfse}TCInfoCompl" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCServ", propOrder = {
    "locPrest",
    "cServ",
    "comExt",
    "obra",
    "atvEvento",
    "explRod",
    "infoCompl"
})
public class TCServ {

    @XmlElement(required = true)
    protected TCLocPrest locPrest;
    @XmlElement(required = true)
    protected TCCServ cServ;
    protected TCComExterior comExt;
    protected TCInfoObra obra;
    protected TCAtvEvento atvEvento;
    protected TCExploracaoRodoviaria explRod;
    protected TCInfoCompl infoCompl;

    /**
     * Obtém o valor da propriedade locPrest.
     * 
     * @return
     *     possible object is
     *     {@link TCLocPrest }
     *     
     */
    public TCLocPrest getLocPrest() {
        return locPrest;
    }

    /**
     * Define o valor da propriedade locPrest.
     * 
     * @param value
     *     allowed object is
     *     {@link TCLocPrest }
     *     
     */
    public void setLocPrest(TCLocPrest value) {
        this.locPrest = value;
    }

    /**
     * Obtém o valor da propriedade cServ.
     * 
     * @return
     *     possible object is
     *     {@link TCCServ }
     *     
     */
    public TCCServ getCServ() {
        return cServ;
    }

    /**
     * Define o valor da propriedade cServ.
     * 
     * @param value
     *     allowed object is
     *     {@link TCCServ }
     *     
     */
    public void setCServ(TCCServ value) {
        this.cServ = value;
    }

    /**
     * Obtém o valor da propriedade comExt.
     * 
     * @return
     *     possible object is
     *     {@link TCComExterior }
     *     
     */
    public TCComExterior getComExt() {
        return comExt;
    }

    /**
     * Define o valor da propriedade comExt.
     * 
     * @param value
     *     allowed object is
     *     {@link TCComExterior }
     *     
     */
    public void setComExt(TCComExterior value) {
        this.comExt = value;
    }

    /**
     * Obtém o valor da propriedade obra.
     * 
     * @return
     *     possible object is
     *     {@link TCInfoObra }
     *     
     */
    public TCInfoObra getObra() {
        return obra;
    }

    /**
     * Define o valor da propriedade obra.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfoObra }
     *     
     */
    public void setObra(TCInfoObra value) {
        this.obra = value;
    }

    /**
     * Obtém o valor da propriedade atvEvento.
     * 
     * @return
     *     possible object is
     *     {@link TCAtvEvento }
     *     
     */
    public TCAtvEvento getAtvEvento() {
        return atvEvento;
    }

    /**
     * Define o valor da propriedade atvEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link TCAtvEvento }
     *     
     */
    public void setAtvEvento(TCAtvEvento value) {
        this.atvEvento = value;
    }

    /**
     * Obtém o valor da propriedade explRod.
     * 
     * @return
     *     possible object is
     *     {@link TCExploracaoRodoviaria }
     *     
     */
    public TCExploracaoRodoviaria getExplRod() {
        return explRod;
    }

    /**
     * Define o valor da propriedade explRod.
     * 
     * @param value
     *     allowed object is
     *     {@link TCExploracaoRodoviaria }
     *     
     */
    public void setExplRod(TCExploracaoRodoviaria value) {
        this.explRod = value;
    }

    /**
     * Obtém o valor da propriedade infoCompl.
     * 
     * @return
     *     possible object is
     *     {@link TCInfoCompl }
     *     
     */
    public TCInfoCompl getInfoCompl() {
        return infoCompl;
    }

    /**
     * Define o valor da propriedade infoCompl.
     * 
     * @param value
     *     allowed object is
     *     {@link TCInfoCompl }
     *     
     */
    public void setInfoCompl(TCInfoCompl value) {
        this.infoCompl = value;
    }

}
