package br.com.projecao.eventos.dto;

import jakarta.validation.constraints.NotBlank;

public class LocalDTO {
	private Long id;
	
	@NotBlank(message = "O nome do local é obrigatório!")
	private String nome;
	
	@NotBlank(message = "O endereço do local é obrigatório!")
	private String endereco;
	
	@NotBlank(message = "A capacidade do local tem que ser número positivo!")
	private Integer capacidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
}
