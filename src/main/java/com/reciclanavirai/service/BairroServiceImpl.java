package com.reciclanavirai.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reciclanavirai.domain.Bairro;
import com.reciclanavirai.domain.dto.BairroDTO;
import com.reciclanavirai.repository.BairroRepository;

@Service @Transactional(readOnly = false)
public class BairroServiceImpl implements BairroService {
	
	@Autowired
	private BairroRepository repository;

	@Override
	public BairroDTO salvar(Bairro bairro) {		
		return BairroDTO.create(repository.save(bairro));
	}

	@Override
	public BairroDTO atualizar(Bairro bairro) {		
		return BairroDTO.create(repository.save(bairro));
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public List<BairroDTO> listarBairros() {
		return repository.findAll().stream().map(BairroDTO::create).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<BairroDTO> listarBairroPorId(Long id) {		
		return repository.findById(id).map(BairroDTO::create);
	}

}
