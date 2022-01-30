package br.com.fornecedor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fornecedor.model.InfoFornecedor;
import br.com.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoResource {
	
	private InfoService infoService; 
	
	public InfoResource(InfoService infoService) {
		this.infoService = infoService;
	}
	
	@GetMapping("/{estado}")
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) throws InterruptedException {
		Thread.sleep(13000);
		return this.infoService.getInfoPorEstado(estado);
	}

}
