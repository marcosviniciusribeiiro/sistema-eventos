package br.com.projecao.eventos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projecao.eventos.dto.EventoDTO;
import br.com.projecao.eventos.mapper.EventoMapper;
import br.com.projecao.eventos.model.Evento;
import br.com.projecao.eventos.model.Local;
import br.com.projecao.eventos.model.Participante;
import br.com.projecao.eventos.repository.EventoRepository;
import br.com.projecao.eventos.repository.ParticipanteRepository;

@Service
public class EventoService {
	private final EventoRepository eventoRepository;
	private final LocalService localService;
	private final ParticipanteRepository participanteRepository;
	
	public EventoService(EventoRepository eventoRepository, LocalService localService, ParticipanteRepository participanteRepository) {
		this.eventoRepository = eventoRepository;
		this.localService = localService;
		this.participanteRepository = participanteRepository;
	}
	
	public void salvarEvento(EventoDTO dto) {
		List<Participante> participantes = participanteRepository.findAllById(dto.getParticipantesIds());
		Evento evento = EventoMapper.toEntity(dto, participantes);
		eventoRepository.save(evento);
		Local local = localService.buscarEntidadePorId(dto.getLocalId());
		
		evento.setLocal(local);
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