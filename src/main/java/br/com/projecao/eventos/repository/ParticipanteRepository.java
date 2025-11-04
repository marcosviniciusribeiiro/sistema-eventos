package br.com.projecao.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projecao.eventos.model.Participante;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> { }
