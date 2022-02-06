package br.com.estudoloja.client;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.estudoloja.model.fornecedor.InfoFornecedorDTO;

@FeignClient("fornecedor")
public interface FornecedorClient {
	
	@GetMapping("/info/{estado}")
	@Cacheable("infoFornecedor")
//	@CachePut(value="infoFornecedor", condition="#{{@compraService.getConditionalCache()}}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);
}
