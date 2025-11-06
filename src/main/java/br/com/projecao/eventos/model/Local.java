package br.com.projecao.eventos.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_locais")
public class Local {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 200, unique = true)
	private String nome;
	
	@Column(nullable = false, length = 500)
	private String endereco;
	
	@Column(nullable = false)
	private Integer capacidade;

	@OneToMany(mappedBy = "local")
	private List<Evento> eventos_local = new ArrayList<Evento>();
	
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

	public List<Evento> getEventos_local() {
		return eventos_local;
	}

	public void setEventos_local(List<Evento> eventos_local) {
		this.eventos_local = eventos_local;
	}
}
