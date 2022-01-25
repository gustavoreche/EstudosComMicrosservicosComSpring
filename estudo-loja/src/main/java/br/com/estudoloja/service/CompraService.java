package br.com.estudoloja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.estudoloja.model.fornecedor.InfoFornecedorDTO;
import br.com.estudoloja.model.loja.CompraDTO;

@Service
public class CompraService {
	
	private RestTemplate client;
	
	public CompraService(RestTemplate client) {
		this.client = client;
	}

	public void realizaCompra(CompraDTO compra) {
		ResponseEntity<InfoFornecedorDTO> response = this.client
				.exchange("http://fornecedor/info/" + compra.getEndereco().getSiglaEstado(),
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		System.out.println(response.getBody().getEndereco());
	}	

}
