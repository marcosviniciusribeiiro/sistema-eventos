package br.com.projecao.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.projecao.eventos.dto.LocalDTO;
import br.com.projecao.eventos.service.LocalService;
import jakarta.validation.Valid;

@Controller
public class LocalController {
	private final LocalService localService;
	
	public LocalController(LocalService localService) {
		this.localService = localService;
	}
	
	@GetMapping("/cadastrar/local")
	public String formulario(Model model) {
		model.addAttribute("localDTO", new LocalDTO());
		return "local_form";
	}
	
	@PostMapping("/cadastrar/local")
	public String salvarLocal(@ModelAttribute("localDTO") @Valid LocalDTO localDTO, BindingResult result) {
		if(result.hasErrors()){
			return "local_form";
		}
		localService.salvarLocal(localDTO);
		return "redirect:/cadastrar/local";
	}
}
/*
- GET /locais → listar todos os locais
 */
