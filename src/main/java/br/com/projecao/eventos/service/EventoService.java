package br.com.projecao.eventos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projecao.eventos.dto.EventoDTO;
import br.com.projecao.eventos.mapper.EventoMapper;
import br.com.projecao.eventos.model.Evento;
import br.com.projecao.eventos.repository.EventoRepository;

@Service
public class EventoService {
	private final EventoRepository eventoRepository;
	
	public EventoService(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}
	
	public void salvarEvento(EventoDTO dto) {
		Evento evento = EventoMapper.toEntity(dto);
		eventoRepository.save(evento);
	}
	
	public List<EventoDTO> listarEventos() {
		return eventoRepository.findAll()
							   .stream()
							   .map(EventoMapper::toDTO)
							   .toList();
	}
	
	public EventoDTO buscarPorId(Long id) {
		Evento evento = eventoRepository.findById(id)
										.orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
		return EventoMapper.toDTO(evento);
	}
	
	public void excluirEvento(Long id) {
		eventoRepository.deleteById(id);
	}
}