package br.com.projecao.eventos.mapper;

//import java.util.List;

import br.com.projecao.eventos.dto.EventoDTO;
import br.com.projecao.eventos.model.Evento;
//import br.com.projecao.eventos.model.Participante;

public class EventoMapper {
	public static Evento toEntity(EventoDTO dto/*, List<Participante> participantes*/) {
		Evento evento = new Evento();
		evento.setId(dto.getId());
		evento.setNome(dto.getNome());
		evento.setDescricao(dto.getDescricao());
		evento.setData(dto.getData());
//		evento.setParticipantes(participantes);
		return evento;
	}
	public static EventoDTO toDTO(Evento evento) {
		EventoDTO dto = new EventoDTO();
		dto.setId(evento.getId());
		dto.setNome(evento.getNome());
		dto.setDescricao(evento.getDescricao());
		dto.setData(evento.getData());
	//	dto.setParticipantesIds(evento.getParticipantes().stream().map(Participante::getId).toList());
		if(evento.getLocal() != null) {
			dto.setLocalId(evento.getLocal().getId());
			dto.setLocalNome(evento.getLocal().getNome());
		}
		return dto;
	}
}
