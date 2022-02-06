package br.com.estudoloja.service;

import java.util.function.Supplier;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import br.com.estudoloja.client.FornecedorClient;
import br.com.estudoloja.model.fornecedor.InfoFornecedorDTO;
import br.com.estudoloja.model.loja.CompraDTO;

@Service()
public class CompraService {
	
	private FornecedorClient client;
	private final CircuitBreaker circuitBreaker;
	
	public CompraService(FornecedorClient client,
			CircuitBreakerFactory circuitBreakerFactory) {
		this.client = client;
		this.circuitBreaker = circuitBreakerFactory.create("recommended");
	}
	
	public InfoFornecedorDTO realizaCompra(CompraDTO compra) {
		return this.circuitBreaker.run(getInfoPorEstado(compra), 
				fallback -> new InfoFornecedorDTO("Erro!! Estou no fallback"));
	}

	private Supplier<InfoFornecedorDTO> getInfoPorEstado(CompraDTO compra) {
		return () -> this.client
				.getInfoPorEstado(compra.getEndereco().getSiglaEstado());
	}	
	
}
