package br.com.estudoloja.model.loja;

public class EnderecoDTO {
	
	private String logradouro;
	private Integer numero;
	private String siglaEstado;
	
	public EnderecoDTO(String logradouro, Integer numero,
			String siglaEstado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.siglaEstado = siglaEstado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Integer getNumero() {
		return numero;
	}
	
	public String getSiglaEstado() {
		return siglaEstado;
	}
	
}
