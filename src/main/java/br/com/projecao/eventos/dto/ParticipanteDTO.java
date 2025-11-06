package br.com.projecao.eventos.dto;

import java.util.List;

import br.com.projecao.eventos.model.Evento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ParticipanteDTO {
	private Long id;
	
	@NotBlank(message = "O nome do participante é obrigatório!")	
	private String nome;
	
	@Email
	@NotBlank(message = "O e-mail do participante é obrigatório!")	
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
}
