package br.com.estudoloja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.estudoloja.model.fornecedor.InfoFornecedorDTO;
import br.com.estudoloja.model.loja.CompraDTO;

@Service
public class CompraService {

	public void realizaCompra(CompraDTO compra) {
		RestTemplate client = new RestTemplate();
		ResponseEntity<InfoFornecedorDTO> response = client
				.exchange("http://localhost:8092/info/" + compra.getEndereco().getSiglaEstado(),
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		System.out.println(response.getBody().getEndereco());
	}	

}
