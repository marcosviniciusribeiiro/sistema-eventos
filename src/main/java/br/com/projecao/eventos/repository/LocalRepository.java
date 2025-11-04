package br.com.projecao.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projecao.eventos.model.Local;

public interface LocalRepository extends JpaRepository<Local, Long> { }
