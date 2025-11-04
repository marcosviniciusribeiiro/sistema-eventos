package br.com.projecao.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.projecao.eventos.dto.EventoDTO;
import br.com.projecao.eventos.service.EventoService;
import jakarta.validation.Valid;

@Controller
public class EventoController {
	private final EventoService eventoService;
	
	public EventoController(EventoService eventoService) {
		this.eventoService = eventoService;
	}

	@GetMapping("cadastrar/evento")
	public String formulario(Model model) {
		model.addAttribute("eventoDTO", new EventoDTO());
		return "evento_form";
	}
	
	@PostMapping("cadastrar/evento")
	public String cadastrarEvento(@ModelAttribute("eventoDTO") @Valid EventoDTO eventoDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "evento_form";
		}
		eventoService.salvarEvento(eventoDTO);
		return "redirect:/cadastrar/evento";
	}
}
/*
- GET /eventos → listar todos os eventos
- GET /eventos/{id} → buscar evento por ID
- PUT /eventos/{id} → atualizar informações do evento
- DELETE /eventos/{id} → excluir evento
 */