package br.com.gescor.gescorkafkaconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gescor.gescorkafkaconsumer.model.Parameter;

@Service
public class GescorService {

	@Autowired
	private Parameter parameter;
	
	@Autowired
	private GescorRequest request;
	
	//private final String json = "[{\"Uf\":\"SP\",\"codigo\":1,\"telefone\":\"1146428051\",\"cidade\":\"ITAQUAQUECETUBA\",\"endereco\":\"RUA ACACIA\",\"numero\":\"23\",\"apolice\":\"\",\"bairro\":\"JARDIM DOS IPES\",\"corretor\":\"M & P CORRETORA DE SEGUROS\",\"cpf\":\"179.188.218-82\",\"celular\":\"(11) 9 9844-8001\",\"segurado\":\"JAQUELINE CRISTINA PAIARO\"},{\"Uf\":\"SP\",\"codigo\":2,\"telefone\":\"(11) 4642-0431\",\"cidade\":\"ITAQUAQUECETUBA\",\"endereco\":\"RUA JOSE ANTONIO DO PRADO\",\"numero\":\"570\",\"apolice\":\"\",\"bairro\":\"JARDIM ZELIA\",\"corretor\":\"ADRIANA CRISTINA MACHADO VITOR\",\"cpf\":\"125.432.618-93\",\"celular\":\"(11) 9 5805-9721\",\"segurado\":\"RENATO PEREIRA DA MATA\"}]";
			
	public void sendJsonKafka(String json) {
		this.sendDataInsered(this.parameter.getUrlAddSeg(), json);
	}

	private void sendDataInsered(String urlAddSeg, String json) {
		this.request.sendJsonArray(urlAddSeg, json);
	}
	
	public static void main(String[] args) {
		
	}
	
}
