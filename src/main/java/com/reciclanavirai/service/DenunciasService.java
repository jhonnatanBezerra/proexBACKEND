package com.reciclanavirai.service;

import java.util.List;
import java.util.Optional;

import com.reciclanavirai.domain.Denuncia;
import com.reciclanavirai.domain.dto.DenunciaDTO;

public interface DenunciasService {

	DenunciaDTO salvar (Denuncia d);
	DenunciaDTO atualizar (Denuncia d);
	void excluir (Long id);
	List<DenunciaDTO> listarDenuncias();
	Optional<DenunciaDTO> listarDenunciaPorId(Long id);
	
}
