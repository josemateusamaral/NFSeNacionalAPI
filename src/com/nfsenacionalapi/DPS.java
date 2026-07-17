package com.nfsenacionalapi;

import java.io.StringWriter;
import java.math.RoundingMode;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.esquematika.strato.dfe.NFe;
import com.esquematika.strato.dfe.Obra;
import com.esquematika.util.lib.Lib;

public class DPS {

	public String xml;
	public TCDPS dps;
	public NFe nota;
	
	public DPS(NFe nota) throws JAXBException{
		this.nota = nota;		
		this.dps = preencher_DPS();
		this.xml = genXML();
	}
	
	public String genXML() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(this.dps.getClass());
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
		jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(this.dps, sw);
		return sw.toString();
	}
	
	public TCDPS preencher_DPS() {
		
		TCDPS DPS = new TCDPS();
		
		//versao 
		DPS.setVersao("1.01");
		
		//informacoes da DPS
		DPS.setInfDPS(preencher_infDPS());
		
		return DPS;
		
	}
	
	public TCInfDPS preencher_infDPS() {
		
		TCInfDPS infDPS = new TCInfDPS();
		
		//ambiente = 1 - producao, 2 - hologacao
	    infDPS.setTpAmb("2");
		
	    //data e hora emissao
	    infDPS.setDhEmi(ZonedDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
	    
	    //versao da aplicacao
	    infDPS.setVerAplic("SefinNac_Pre_1.4.0");
	    
	    //serie da nota
	    infDPS.setSerie("00001");
	    
	    //numero da nota
	    infDPS.setNDPS("202500000000001");
	    
	    //data da competencia
	    infDPS.setDCompet(Lib.SetaDataEmString(Lib.Today()).replace("'",""));
	    
	    //emissor = 1 - Prestador; 2 - Tomador; 3 - Intermediário
	    infDPS.setTpEmit("1");
	    
	    //local da emissao
	    infDPS.setCLocEmi(this.nota.getEmitente().getCida2_cod_ibge().toString());
	    
	    //informacoes do prestador
	    infDPS.setPrest(preencher_prest());
	    
	    //informacoes do servico
	    infDPS.setServ(preencher_serv());
	    
	    //valores
	    infDPS.setValores(preencher_valores());
	    
	    //id (45 caracteres) = DPS" + Cód.Mun (7) + Tipo de Inscrição Federal (1) + Inscrição Federal (14 - CPF completar com 000 à esquerda) + Série DPS (5)+ Núm. DPS (15)
		infDPS.setId("DPS" + this.nota.getEmitente().getCida2_cod_ibge() + "2" + this.nota.getEmitente().getCemp1_cnpj().replaceAll("\\D", "") + infDPS.getSerie() + infDPS.getNDPS());
	    
		return infDPS;
		
	}
	
	public TCInfoPrestador preencher_prest() {
		
		TCInfoPrestador prest = new TCInfoPrestador();
		
		//cnpj
		prest.setCNPJ(this.nota.getEmitente().getCemp1_cnpj().replaceAll("\\D", ""));
		
	    //informacoes do retime tributario
	    TCRegTrib regTrib = new TCRegTrib();
	    
	    //Situação perante o Simples Nacional: 1 - Não Optante; 2 - Optante - Microempreendedor Individual (MEI); 3 - Optante - Microempresa ou Empresa de Pequeno Porte (ME/EPP);
	    regTrib.setOpSimpNac("8,9".contains(this.nota.getEmitente().getCemp1_reg_tri()) ? "3" : "1"); 
	    
	    //regime de apuracao do simples nacional
	    if("8,9".contains(this.nota.getEmitente().getCemp1_reg_tri())) {
	    	regTrib.setRegApTribSN("1");
	    }
	    
	    //Tipos de Regimes Especiais de Tributação: 0 - Nenhum; 1 - Ato Cooperado (Cooperativa); 2 - Estimativa; 3 - Microempresa Municipal; 4 - Notário ou Registrador; 5 - Profissional Autônomo; 6 - Sociedade de Profissionais;
	    regTrib.setRegEspTrib("80411192000168".contains(this.nota.getEmitente().getCemp1_cnpj().replaceAll("\\D", "")) ? "6" : "0");
		
	    prest.setRegTrib(regTrib);
		
	    
		return prest;
		
	}
	
	public TCServ preencher_serv() {
		
		TCServ serv = new TCServ();
		
		//local de prestacao
		TCLocPrest locPrest = new TCLocPrest();
		if(!Lib.Empty(this.nota.getObra().getObra2_cod())) {
			locPrest.setCLocPrestacao(this.nota.getObra().getCida2_cod_ibge().toString());		
		} else {
			locPrest.setCLocPrestacao(this.nota.getDestinatario().getCida2_cod_ibge().toString());	
		}
		serv.setLocPrest(locPrest);
		
		//servico
	    TCCServ cServ = new TCCServ();
	    
	    //Código de tributação nacional do ISSQN: Regra de formação - 6 dígitos numéricos sendo: 2 para Item (LC 116/2003), 2 para Subitem (LC 116/2003) e 2 para Desdobro Nacional
	    cServ.setCTribNac("070201");
	
	    //descricao do Código de tributação nacional do ISSQN
	    cServ.setXDescServ(this.nota.getDeducoes().getServ1_nom());
	    
	    boolean informarObra = true;
	    
	    //informacoes da obra
	    if(!Lib.Empty(this.nota.getObra().getObra2_cod())) {//  && informarObra) {
	    	
	    	Obra obra = this.nota.getObra();
	    	
	    	TCInfoObra infoObra = new TCInfoObra();
	        
	    	//endereco da obra
	        TCEnderObraEvento end = new TCEnderObraEvento();
	        end.setCEP(obra.getObra2_cep().replace("-",""));
	        end.setXLgr(obra.getObra2_end());
	        end.setNro(obra.getObra2_end_num());
	        end.setXBairro(obra.getObra2_bai());
	        infoObra.setEnd(end);
	        
	        serv.setObra(infoObra);
	        
	    }
	    
	    
	    serv.setCServ(cServ);
	    
		
		return serv;
		
	}
	
	public TCInfoValores preencher_valores() { 
		
		TCInfoValores valores = new TCInfoValores();
		
		//valores do servico prestado
		TCVServPrest vServPrest = new TCVServPrest();
		vServPrest.setVServ(this.nota.getNoem1_val_ser_item().setScale(2,RoundingMode.HALF_EVEN).toString());
		valores.setVServPrest(vServPrest);
	
		
		//tributacao
		TCInfoTributacao trib = new TCInfoTributacao();
		trib.setTribMun(preencher_tribMun()); // tributacao municipal
		trib.setTotTrib(preencher_tribTotal()); // totais da tributacao
		valores.setTrib(trib);
		
		
		return valores;
		
	}
	
	public TCTribMunicipal preencher_tribMun() {
		
		TCTribMunicipal tribMun = new TCTribMunicipal();
		
		//Tributação do ISSQN sobre o serviço prestado: 1 - Operação tributável; 2 - Imunidade; 3 - Exportação de serviço; 4 - Não Incidência;		
		switch(this.nota.getDeducoes().getTipoTributacao().toString()) {
			case "0": tribMun.setTribISSQN("4"); break;
			case "1": tribMun.setTribISSQN("4"); break;
			case "2": tribMun.setTribISSQN("2"); break;
			case "3": tribMun.setTribISSQN("4"); break;
			case "4": tribMun.setTribISSQN("4"); break;
			case "5": tribMun.setTribISSQN("1"); break;
			case "6": tribMun.setTribISSQN("1"); break;
			case "7": tribMun.setTribISSQN("1"); break;
			case "8": tribMun.setTribISSQN("1"); break;
			default:  tribMun.setTribISSQN("4"); break;
		}
	
	    //Tipo de retencao do ISSQN: 1 - Não Retido; 2 - Retido pelo Tomador; 3 - Retido pelo Intermediario;
		tribMun.setTpRetISSQN(this.nota.getDeducoes().isRetencaoFonte() ? (this.nota.getDeducoes().isResponsavelRetencao() ? "2" : "3") : "1");
		
		return tribMun;
		
	}
	
	public TCTribTotal preencher_tribTotal() {
		
		TCTribTotal tribTotal = new TCTribTotal();
	
		
		//valor monetario das tributacoes
		/*
		
		TCTribTotalMonet tribTotalMonet = new TCTribTotalMonet();
		
		//vTotTribFed = INSS + IR + CSLL + PIS + COFINS
		BigDecimal vTotTribFed = new BigDecimal("0");
		vTotTribFed = vTotTribFed.add(this.nota.getDeducoes().getValorInss()); //INSS
		vTotTribFed = vTotTribFed.add(this.nota.getDeducoes().getValorIr()); //IR
		vTotTribFed = vTotTribFed.add(this.nota.getDeducoes().getValorCsll()); //CSLL
		vTotTribFed = vTotTribFed.add(this.nota.getDeducoes().getValorPis()); //PIS
		vTotTribFed = vTotTribFed.setScale(2,RoundingMode.HALF_EVEN);
		tribTotalMonet.setVTotTribFed(vTotTribFed.toString());
		
		//vTotTribEst
		tribTotalMonet.setVTotTribEst("0.00");;
		
		//vTotTribMun
		tribTotalMonet.setVTotTribMun(this.nota.getDeducoes().getValorIss().toString());;
		
		tribTotal.setVTotTrib(tribTotalMonet);
		*/
		
		
		
		/*
		
		DE ACORDO COM OS TESTES, TEMOS QUE ESCOLHER ENTRE INFORMAR OS VALORES OU OS PERCENTUAIS
		NÂO PODE INFORMAR OS DOIS
		 
		//percentual das tributacoes
		TCTribTotalPercent tribTotalPercent = new TCTribTotalPercent();
		
		//pTotTribFed = INSS + IR + CSLL + PIS + COFINS
		BigDecimal pTotTribFed = new BigDecimal("0");
		pTotTribFed = pTotTribFed.add(this.nota.getDeducoes().getPercentualInss()); //INSS
		pTotTribFed = pTotTribFed.add(this.nota.getDeducoes().getPercentualIr()); //IR
		pTotTribFed = pTotTribFed.add(this.nota.getDeducoes().getPercentualCsll()); //CSLL
		pTotTribFed = pTotTribFed.add(this.nota.getDeducoes().getPercentualPis()); //PIS
		pTotTribFed = pTotTribFed.add(this.nota.getDeducoes().getPercentualCofins()); //COFINS		
		pTotTribFed = pTotTribFed.setScale(2,RoundingMode.HALF_EVEN);
		tribTotalPercent.setPTotTribFed(pTotTribFed.toString());
		
		//pTotTribEst
		tribTotalPercent.setPTotTribEst("0.00");
		
		//pTotTribMun
		tribTotalPercent.setPTotTribMun(this.nota.getDeducoes().getPercentualIss().toString());
		
		tribTotal.setPTotTrib(tribTotalPercent);
		
		*/
		
		
		//Indicador de informação de valor total de tributos. Possui valor fixo igual a zero (indTotTrib=0). Não informar nenhum valor estimado para os Tributos (Decreto 8.264/2014). 0 - Não;
		//tribTotal.setIndTotTrib("0");
		
		//percentual do simples nacional
		tribTotal.setPTotTribSN("0");
		
		return tribTotal;
		
	}
	
}
