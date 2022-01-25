package br.com.estudoloja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.estudoloja.model.fornecedor.InfoFornecedorDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {
	
	@GetMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);
}
