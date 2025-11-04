package br.com.projecao.eventos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projecao.eventos.dto.ParticipanteDTO;
import br.com.projecao.eventos.mapper.ParticipanteMapper;
import br.com.projecao.eventos.model.Participante;
import br.com.projecao.eventos.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
	private ParticipanteRepository participanteRepository;
	
	public ParticipanteService(ParticipanteRepository participanteRepository) {
		this.participanteRepository = participanteRepository;
	}
	
	public void salvarParticipante(ParticipanteDTO dto) {
		Participante participante = ParticipanteMapper.toEntity(dto);
		participanteRepository.save(participante);
	}
	
	public List<ParticipanteDTO> listarParticipantes() {
		return participanteRepository.findAll()
									 .stream()
									 .map(ParticipanteMapper::toDTO)
									 .toList();
	}
}