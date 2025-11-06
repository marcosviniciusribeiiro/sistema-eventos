package br.com.projecao.eventos.mapper;

import br.com.projecao.eventos.dto.ParticipanteDTO;
import br.com.projecao.eventos.model.Participante;

public class ParticipanteMapper {
	public static Participante toEntity(ParticipanteDTO dto) {
		Participante participante = new Participante();
		participante.setId(dto.getId());
		participante.setNome(dto.getNome());
		participante.setEmail(dto.getEmail());
		participante.setEventos(dto.getEventos());
		return participante;
	}
	
	public static ParticipanteDTO toDTO(Participante participante) {
		ParticipanteDTO dto = new ParticipanteDTO();
		dto.setId(participante.getId());
		dto.setNome(participante.getNome());
		dto.setEmail(participante.getEmail());
		dto.setEventos(participante.getEventos());
		return dto;
	}
}
