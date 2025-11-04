package br.com.projecao.eventos.mapper;

import br.com.projecao.eventos.dto.LocalDTO;
import br.com.projecao.eventos.model.Local;

public class LocalMapper {
	public static Local toEntity(LocalDTO dto) {
		Local local = new Local();
		local.setId(dto.getId());
		local.setNome(dto.getNome());
		local.setEndereco(dto.getEndereco());
		local.setCapacidade(dto.getCapacidade());
		return local;
	}
	
	public static LocalDTO toDTO(Local local) {
		LocalDTO dto = new LocalDTO();
		dto.setId(local.getId());
		dto.setNome(local.getNome());
		dto.setEndereco(local.getEndereco());
		dto.setCapacidade(local.getCapacidade());
		return dto;
	}
}
