package br.com.fornecedor.service;

import org.springframework.stereotype.Service;

import br.com.fornecedor.model.InfoFornecedor;
import br.com.fornecedor.repository.InfoRepository;

@Service
public class InfoService {

	private InfoRepository infoRepository;
	
	public InfoService(InfoRepository infoRepository) {
		this.infoRepository = infoRepository;
	}
	
	public InfoFornecedor getInfoPorEstado(String estado) {
		return this.infoRepository.findByEstado(estado);
	}

}
