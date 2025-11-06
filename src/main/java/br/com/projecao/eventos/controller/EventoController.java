package br.com.projecao.eventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.projecao.eventos.dto.EventoDTO;
import br.com.projecao.eventos.service.EventoService;
import br.com.projecao.eventos.service.LocalService;
import jakarta.validation.Valid;

@Controller
public class EventoController {
	private final EventoService eventoService;
	private final LocalService localService;
	
	public EventoController(EventoService eventoService, LocalService localService) {
		this.eventoService = eventoService;
		this.localService = localService;
	}

	@GetMapping("/cadastrar/evento")
	public String formulario(Model model) {
		model.addAttribute("eventoDTO", new EventoDTO());
		model.addAttribute("locais", localService.listarLocais());
		return "evento_form";
	}
	
	@PostMapping("/cadastrar/evento")
	public String cadastrarEvento(@ModelAttribute("eventoDTO") @Valid EventoDTO eventoDTO, BindingResult result) {
		if(eventoDTO.getLocalId() == null) {
			result.rejectValue("localId", null, "O local é obrigatório!");
		}
		
		if(result.hasErrors()) {
			return "evento_form";
		}
		
		eventoService.salvarEvento(eventoDTO);
		return "redirect:/cadastrar/evento";
	}
	
	@GetMapping("/eventos")
	public String listarEventos(Model model) {
		model.addAttribute("eventos", eventoService.listarEventos());
		return "eventos";
	}
	
	@GetMapping("/eventos/editar/{id}")
	public String editarEvento(@PathVariable Long id, Model model) {
		EventoDTO dto = eventoService.buscarPorId(id);
		model.addAttribute("eventoDTO", dto);
		model.addAttribute("locais", localService.listarLocais());
		return "evento_form";
	}
	
	@PutMapping("/eventos/atualizar/{id}")
	public String atualizarEvento(@ModelAttribute EventoDTO eventoDTO, @PathVariable Long id) {
		eventoDTO.setId(id);
		eventoService.salvarEvento(eventoDTO);
		return "redirect:/eventos";
	}
	
	@DeleteMapping("/eventos/excluir/{id}")
	public String excluirEvento(@PathVariable Long id) {
		eventoService.excluirEvento(id);
		return "redirect:/eventos";
	}
}