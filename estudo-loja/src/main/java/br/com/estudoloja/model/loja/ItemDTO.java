package br.com.estudoloja.model.loja;

import java.math.BigDecimal;

public class ItemDTO {
	
	private String nome;
	private BigDecimal valor;
	
	public ItemDTO(String nome, BigDecimal valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}	

}
