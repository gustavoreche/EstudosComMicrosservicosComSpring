package br.com.estudoloja.model.fornecedor;

public class InfoFornecedorDTO {
	
	private String endereco;
	
	public InfoFornecedorDTO() {
	}

	public InfoFornecedorDTO(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return endereco;
	}	

}
