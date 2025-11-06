package br.com.projecao.eventos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projecao.eventos.dto.LocalDTO;
import br.com.projecao.eventos.mapper.LocalMapper;
import br.com.projecao.eventos.model.Local;
import br.com.projecao.eventos.repository.LocalRepository;

@Service
public class LocalService {
	private LocalRepository localRepository;
	
	public LocalService(LocalRepository localRepository) {
		this.localRepository = localRepository;
	}
	
	public void salvarLocal(LocalDTO dto) {
		Local local = LocalMapper.toEntity(dto);
		localRepository.save(local);
	}
	
	public List<LocalDTO> listarLocais() {
		return localRepository.findAll()
							  .stream()
							  .map(LocalMapper::toDTO)
							  .toList();
	}
	
	public Local buscarEntidadePorId(Long id) {
		return localRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Local não encontrado: " + id));
	}
}