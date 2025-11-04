package br.com.projecao.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.projecao.eventos.dto.ParticipanteDTO;
import br.com.projecao.eventos.service.ParticipanteService;
import jakarta.validation.Valid;

@Controller
public class ParticipanteController {
	private final ParticipanteService participanteService;
	
	public ParticipanteController(ParticipanteService participanteService) {
		this.participanteService = participanteService;
	}
	
	@GetMapping("/cadastrar/participante")
	public String formulario(Model model) {
		model.addAttribute("participanteDTO", new ParticipanteDTO());
		return "participante_form";
	}
	
	@PostMapping("/cadastrar/participante")
	public String salvarParticipante(@ModelAttribute("participanteDTO") @Valid ParticipanteDTO participanteDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "participante_form";
		}
		participanteService.salvarParticipante(participanteDTO);
		return "redirect:/cadastrar/participante";
	}
}
/*
- GET /participantes → listar todos os participantes
 */