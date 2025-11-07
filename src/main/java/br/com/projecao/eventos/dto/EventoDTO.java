package br.com.projecao.eventos.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;

public class EventoDTO {
	private Long id;
	
	@NotBlank(message = "O nome do evento é obrigatório!")
	private String nome;

	@NotBlank(message = "A descrição do evento é obrigatório!")
	private String descricao;
	
	private LocalDateTime data;
	
	private Long localId;
	
	private String localNome;
	
	private Integer localCapacidade;

	private List<Long> participantesIds;
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Long getLocalId() {
		return localId;
	}

	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	public String getLocalNome() {
		return localNome;
	}

	public void setLocalNome(String localNome) {
		this.localNome = localNome;
	}

	public List<Long> getParticipantesIds() {
		return participantesIds;
	}

	public void setParticipantesIds(List<Long> participantesIds) {
		this.participantesIds = participantesIds;
	}

	public Integer getLocalCapacidade() {
		return localCapacidade;
	}

	public void setLocalCapacidade(Integer localCapacidade) {
		this.localCapacidade = localCapacidade;
	}
}
