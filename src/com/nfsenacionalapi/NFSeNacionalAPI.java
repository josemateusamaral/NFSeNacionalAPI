package com.nfsenacionalapi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.Normalizer;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.zip.GZIPOutputStream;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class NFSeNacionalAPI {

	//endpoints
	public String producao = "https://sefin.nfse.gov.br/sefinnacional";
	public String homologacao = "https://sefin.producaorestrita.nfse.gov.br/sefinnacional";
	public String parametros_municipais_producao = "https://adn.nfse.gov.br/parametrizacao/";
	public String parametros_municipais_homologacao = "https://adn.producaorestrita.nfse.gov.br/parametrizacao/";
	
	//attributes
	public String ambiente = "2";
	public HttpClient client;
	public String certificadoPath;
	public String certificadoSenha;
	
	public NFSeNacionalAPI() {
		
	}
	
	public NFSeNacionalAPI(String certificadoPath, String certificadoSenha, String cTruststorePath) throws IOException, KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
		
		this.certificadoPath = certificadoPath;
	    this.certificadoSenha = certificadoSenha;

	    // =========================
	    // KEYSTORE (certificado cliente)
	    // =========================
	    char[] senha = certificadoSenha.toCharArray();

	    KeyStore keyStore = KeyStore.getInstance("PKCS12");
	    try (FileInputStream fis = new FileInputStream(certificadoPath)) {
	        keyStore.load(fis, senha);
	    }

	    KeyManagerFactory kmf = KeyManagerFactory.getInstance(
	            KeyManagerFactory.getDefaultAlgorithm());
	    kmf.init(keyStore, senha);

	    // =========================
	    // TRUSTSTORE (NFSe)
	    // =========================
	    KeyStore trustStore = KeyStore.getInstance("JKS");
	    try (FileInputStream fis = new FileInputStream(cTruststorePath)) {
	        trustStore.load(fis, "changeit".toCharArray());
	    }

	    TrustManagerFactory tmf = TrustManagerFactory.getInstance(
	            TrustManagerFactory.getDefaultAlgorithm());
	    tmf.init(trustStore);

	    // =========================
	    // SSL CONTEXT ISOLADO (NÃO GLOBAL)
	    // =========================
	    SSLContext sslContext = SSLContext.getInstance("TLS");
	    sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

	    // =========================
	    // HTTP CLIENT (ISOLADO)
	    // =========================
	    this.client = HttpClient.newBuilder()
	            .sslContext(sslContext)
	            .version(HttpClient.Version.HTTP_1_1)
	            .build();
	    
		
	}
	
	public HttpResponse<String> emitir(TCDPS dps) throws JAXBException, UnrecoverableKeyException, FileNotFoundException, KeyStoreException, NoSuchAlgorithmException,
	CertificateException, InvalidAlgorithmParameterException, IOException, SAXException, ParserConfigurationException, MarshalException, XMLSignatureException, TransformerException, InterruptedException{
		
		//definir o ambiente usando o ambiente da api
		dps.infDPS.tpAmb = this.ambiente;
		
		//criar xml apartir da dps
		String xml = this.objectToXml(dps);
		
		System.out.print("\n\n<EMITINDO NFSeNACIONAL>\n" + xml + "\n</EMITINDO NFSeNACIONAL>\n");		
		//assinar xml da dps
		String xmlAssinado = assinarXML(xml,"DPS");
		
		//compactar xml assinado para gzip
		byte[] xmlBytes = xmlAssinado.getBytes(StandardCharsets.UTF_8);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (GZIPOutputStream gzip = new GZIPOutputStream(bos)) {
            gzip.write(xmlBytes);
        }
        byte[] gzip = bos.toByteArray();
        
        //transformar gzip em base64
        String base64 = Base64.getEncoder().encodeToString(gzip);
        
        //endpoint ambiente
        String endpoint_ambiente = ambiente.equals("1") ? producao : homologacao;
        
        //enviar
        HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(endpoint_ambiente + "/nfse"))
	            .header("Content-Type", "application/json")
	            .POST(HttpRequest.BodyPublishers.ofString("{\"dpsXmlGZipB64\":\"" + base64 + "\"}")) 
	            .build();
	    HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());     
	    
		return response;
		
	}
	
	public HttpResponse<String> cancelar(String chave_de_acesso, String cMotivo, String xMotivo) throws JAXBException, UnrecoverableKeyException, FileNotFoundException, KeyStoreException, NoSuchAlgorithmException, 
	CertificateException, InvalidAlgorithmParameterException, IOException, SAXException, ParserConfigurationException, MarshalException, XMLSignatureException, TransformerException, InterruptedException {
	   
	    //pedido de registro do evento
	    TCPedRegEvt pedRegEvento = new TCPedRegEvt();
	    
	    //informacoes do pedido de registro do evento
	    TCInfPedReg infPedReg = new TCInfPedReg();
	    infPedReg.setTpAmb(this.ambiente); //ambiente : 1 - Producao , 2 - Homologacao
	    infPedReg.setVerAplic("1.01"); // versao da aplicacao que gerou o evento
	    infPedReg.setDhEvento(ZonedDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)); // data e hora da geracao do evento
	    infPedReg.setCNPJAutor(chave_de_acesso.trim().substring(9,23)); // cnpj do gerador do evento
	    infPedReg.setChNFSe(chave_de_acesso); // chave de acesso da NFSe que sera cancelada
	    
	    //evento de cancelamento
	    TE101101 e101101 = new TE101101();
	    e101101.setXDesc("Cancelamento de NFS-e"); // descricao do evento
	    e101101.setCMotivo(cMotivo); // codigo do motivo do cancelamento
	    e101101.setXMotivo(xMotivo); // descricao do motivo do cancelamento
	    
	    infPedReg.setE101101(e101101);
	    infPedReg.setId("PRE" + chave_de_acesso + "101101");
	    pedRegEvento.setInfPedReg(infPedReg);
	    pedRegEvento.setVersao("1.01"); // versao - 1.01
	    
	    // gerar xml do evento de cancelamento apartir do objeto
		String xml = this.objectToXml(pedRegEvento);
		
		System.out.print("\n<XML_EVENTO_CANCELAMENTO>\n" + xml + "\n</XML_EVENTO_CANCELAMENTO>\n");
		
		// assinar o xml do evento de cancelamento
		String xmlAssinado = assinarXML(xml,"pedRegEvento");
		byte[] xmlBytes = xmlAssinado.getBytes(StandardCharsets.UTF_8);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (GZIPOutputStream gzip = new GZIPOutputStream(bos)) {
            gzip.write(xmlBytes);
        }
        byte[] gzip = bos.toByteArray();
        
        //converter o xml assinado para uma String base64
        String base64 = Base64.getEncoder().encodeToString(gzip);
        
        //enviar
        HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(homologacao + "/nfse/" + chave_de_acesso + "/eventos"))
	            .header("Content-Type", "application/json")
	            .POST(HttpRequest.BodyPublishers.ofString("{\"pedidoRegistroEventoXmlGZipB64\":\"" + base64 + "\"}")) 
	            .build();
	    HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString()); 
        
		return response;
		
	}
	
	public String assinarXML(String xml, String node) throws FileNotFoundException, IOException, KeyStoreException, NoSuchAlgorithmException, 
	CertificateException, UnrecoverableKeyException, SAXException, ParserConfigurationException, InvalidAlgorithmParameterException, MarshalException, XMLSignatureException, TransformerException {
		
		// 0. remover caracteres especiais
		xml = xml.replace('\u00A0', ' ');
		xml = xml.replace("&#13","");
		xml = Normalizer.normalize(xml, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").replace("ç", "c").replace("Ç", "C");
		String xmlAssinado = xml;
		
		// 1. coletar dados do certificado
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (FileInputStream fis = new FileInputStream(this.certificadoPath)) {
        	keyStore.load(fis, this.certificadoSenha.toCharArray());
        }
        String alias = keyStore.aliases().nextElement();
        Key key = keyStore.getKey(alias, this.certificadoSenha.toCharArray());
        if (!(key instanceof PrivateKey)) {
            throw new RuntimeException("Alias não contém chave privada");
        }
        PrivateKey privateKey = (PrivateKey) key;
        X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);

        // 2. preparar xml
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);  
        Document doc = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        
        // 3. Cria fábrica de assinatura
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
        Reference ref = fac.newReference(
        		"",
        	    fac.newDigestMethod(DigestMethod.SHA1, null),
        	    Arrays.asList(
        	        fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null),
        	        fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (TransformParameterSpec) null)
        	    ),
        	    null,
        	    null
        );
        
        // 4. 
        SignedInfo si = fac.newSignedInfo(
        	    fac.newCanonicalizationMethod(
        	        CanonicalizationMethod.INCLUSIVE,
        	        (C14NMethodParameterSpec) null
        	    ),
        	    fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
        	    Collections.singletonList(ref)
        );

        // 5. KeyInfo (inclui certificado)
        KeyInfoFactory kif = fac.getKeyInfoFactory();
        X509Data x509Data = kif.newX509Data(Collections.singletonList(cert));
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(x509Data));
        
        // 6. Assina e insere no DOM
        Element dpsElement = (Element) doc.getElementsByTagName(node).item(0);
        DOMSignContext dsc = new DOMSignContext(privateKey, dpsElement);
        XMLSignature signature = fac.newXMLSignature(si, ki);
        signature.sign(dsc);
        
        // 7. converter xml assinado para uma string
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer trans = tf.newTransformer();
            trans.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
            trans.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "no");
            trans.transform(new javax.xml.transform.dom.DOMSource(doc),
                            new javax.xml.transform.stream.StreamResult(bos));
            xmlAssinado = bos.toString("UTF-8");
        }
        
        return xmlAssinado;
        
	}
	

	
	public HttpResponse<String> getInformacoesConvenioMunicipio(String municipio) throws Exception {
		
		//endpoint
		String endpoint_parametros_municipais = ambiente.equals("1") ? parametros_municipais_producao : parametros_municipais_homologacao;
		
		HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(endpoint_parametros_municipais + municipio + "/convenio"))
	            .header("Content-Type", "application/json")
	            .GET()  
	            .build();

	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		return response;
		
	}
	
	

	
	
	//-----------------------------------------------------------
	//                       XML TOOLS
	//-----------------------------------------------------------
	/** Transforma um objeto em xml */
	public String objectToXml(Object objeto) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(objeto.getClass());
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
		jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(objeto, sw);
		return sw.toString();
	}

	/** Transforma um xml em objeto */
	public Object xmlToObject(String xml, Object object) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(xml);
		return object.getClass().cast(unmarshaller.unmarshal(reader));
	}
	
}
