package br.com.projecao.eventos.controller;

import org.springframework.stereotype.Controller;

import br.com.projecao.eventos.service.LocalService;

@Controller
public class LocalController {
	private final LocalService localService;
	
	public LocalController(LocalService localService) {
		this.localService = localService;
	}

}
/*
- POST /locais → cadastrar um novo local
- GET /locais → listar todos os locais
 */
