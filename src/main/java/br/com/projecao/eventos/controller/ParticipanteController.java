package br.com.projecao.eventos.controller;

import org.springframework.stereotype.Controller;

import br.com.projecao.eventos.service.ParticipanteService;

@Controller
public class ParticipanteController {
	private final ParticipanteService participanteService;
	
	public ParticipanteController(ParticipanteService participanteService) {
		this.participanteService = participanteService;
	}
}
/*
- POST /participantes → cadastrar participante
- GET /participantes → listar todos os participantes
 */