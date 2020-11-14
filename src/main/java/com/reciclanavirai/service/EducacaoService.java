package com.reciclanavirai.service;

import java.util.List;
import java.util.Optional;

import com.reciclanavirai.domain.EducacaoAmbiental;
import com.reciclanavirai.domain.dto.EducacaoAmbientalDTO;

public interface EducacaoService {
	
	EducacaoAmbientalDTO salvar (EducacaoAmbiental ed);
	EducacaoAmbientalDTO atualizar (EducacaoAmbiental ed);
	void excluir (Long id);
	List<EducacaoAmbientalDTO> listarEducacao();
	Optional<EducacaoAmbientalDTO> listarEducacaoPorId();
}
