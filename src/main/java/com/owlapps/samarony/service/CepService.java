package com.owlapps.samarony.service;
//package com.ummilhao.service;

//@Service
//public class CepService {
  
//  private final WebServiceTemplate wsTemplate;
//
//
//  public CepService(@Value("${correios.sigepweb.uri}") String sigepWebUri) {
//    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//    marshaller.setContextPath("br.com.correios.sigepweb");
//
//    wsTemplate = new WebServiceTemplate();
//    wsTemplate.setMarshaller(marshaller);
//    wsTemplate.setUnmarshaller(marshaller);
//    wsTemplate.setDefaultUri(sigepWebUri);
//  }
//
//  public Endereco buscaCep(String cep) {
//    ObjectFactory correiosFactory = new ObjectFactory();
//
//    ConsultaCEP request = correiosFactory.createConsultaCEP();
//    request.setCep(cep);
//
//    ConsultaCEPResponse response = (ConsultaCEPResponse) JAXBIntrospector.getValue(
//      wsTemplate.marshalSendAndReceive(correiosFactory.createConsultaCEP(request))
//    );
//
//    return this.toEndereco(response.getReturn());
//  }
//
//  private Endereco toEndereco(EnderecoERP end) {
//    Endereco e = new Endereco();
//    e.setLogradouro(end.getEnd());
//    e.setComplemento(end.getComplemento());
//    e.setComplemento2(end.getComplemento2());
//    e.setBairro(end.getBairro());
//    e.setCidade(end.getCidade());
//    e.setUf(end.getUf());
//    e.setCep(end.getCep());
//    return e;
//  }
  
//}
