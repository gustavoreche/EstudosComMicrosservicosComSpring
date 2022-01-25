package br.com.estudoloja.service;

import org.springframework.stereotype.Service;

import br.com.estudoloja.client.FornecedorClient;
import br.com.estudoloja.model.fornecedor.InfoFornecedorDTO;
import br.com.estudoloja.model.loja.CompraDTO;

@Service
public class CompraService {
	
	private FornecedorClient client;
	
	public CompraService(FornecedorClient client) {
		this.client = client;
	}

	public void realizaCompra(CompraDTO compra) {
		InfoFornecedorDTO infoPorEstado = this.client.getInfoPorEstado(compra.getEndereco().getSiglaEstado());
		System.out.println(infoPorEstado.getEndereco());
	}	

}
