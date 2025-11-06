package br.com.projecao.eventos.dto;

import java.util.List;

import br.com.projecao.eventos.model.Evento;
import jakarta.validation.constraints.NotBlank;

public class LocalDTO {
	private Long id;
	
	@NotBlank(message = "O nome do local é obrigatório!")
	private String nome;

	@NotBlank(message = "O endereço do local é obrigatório!")
	private String endereco;
	
	private Integer capacidade;

	private List<Evento> eventos;
	
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

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
}
