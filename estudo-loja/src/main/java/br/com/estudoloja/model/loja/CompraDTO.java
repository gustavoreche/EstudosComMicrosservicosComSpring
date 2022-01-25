package br.com.estudoloja.model.loja;

import java.util.List;

public class CompraDTO {

	private List<ItemDTO> itens;
	private EnderecoDTO endereco;

	public CompraDTO(List<ItemDTO> itens, EnderecoDTO endereco) {
		this.itens = itens;
		this.endereco = endereco;
	}

	public List<ItemDTO> getItens() {
		return itens;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

}
