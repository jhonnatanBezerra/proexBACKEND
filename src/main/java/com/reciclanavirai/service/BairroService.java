package com.reciclanavirai.service;

import java.util.List;
import java.util.Optional;

import com.reciclanavirai.domain.Bairro;
import com.reciclanavirai.domain.dto.BairroDTO;

public interface BairroService {

	BairroDTO salvar(Bairro bairro);
	BairroDTO atualizar(Bairro bairro);
	void excluir(Long id);
	List<BairroDTO> listarBairros();
	Optional<BairroDTO> listarBairroPorId(Long id);
	
}
