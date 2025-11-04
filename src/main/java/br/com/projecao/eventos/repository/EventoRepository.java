package br.com.projecao.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projecao.eventos.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> { }
