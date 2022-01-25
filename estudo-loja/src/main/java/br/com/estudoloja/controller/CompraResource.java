package br.com.estudoloja.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudoloja.model.loja.CompraDTO;
import br.com.estudoloja.service.CompraService;

@RestController
@RequestMapping("/loja")
public class CompraResource {
	
	private CompraService compraService;
	
	public CompraResource(CompraService compraService) {
		this.compraService = compraService;
	}
	
	@PostMapping
	public void realizaCompra(@RequestBody CompraDTO compra) {
		this.compraService.realizaCompra(compra);
	}

}
