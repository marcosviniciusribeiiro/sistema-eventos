package br.com.projecao.eventos.mapper;

import br.com.projecao.eventos.dto.EventoDTO;
import br.com.projecao.eventos.model.Evento;

public class EventoMapper {
	public static Evento toEntity(EventoDTO dto) {
		Evento evento = new Evento();
		evento.setId(dto.getId());
		evento.setNome(dto.getNome());
		evento.setDescricao(dto.getDescricao());
		evento.setData(dto.getData());
		return evento;
	}
	public static EventoDTO toDTO(Evento evento) {
		EventoDTO dto = new EventoDTO();
		dto.setId(evento.getId());
		dto.setNome(evento.getNome());
		dto.setDescricao(evento.getDescricao());
		dto.setData(evento.getData());
		return dto;
	}
}
