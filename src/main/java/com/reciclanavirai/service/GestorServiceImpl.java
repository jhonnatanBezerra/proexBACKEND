package com.reciclanavirai.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reciclanavirai.domain.Gestor;
import com.reciclanavirai.domain.dto.GestorDTO;
import com.reciclanavirai.repository.GestorRepository;

@Service @Transactional(readOnly = false)
public class GestorServiceImpl implements GestorService{

	GestorRepository repository;
	
	@Override
	public GestorDTO salvar(Gestor g) {
		return GestorDTO.create(repository.save(g));
	}

	@Override
	public GestorDTO atualizar(Gestor g) {
		return GestorDTO.create(repository.save(g));
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public List<GestorDTO> listarGestores() {
		return repository.findAll().stream().map(GestorDTO::create).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<GestorDTO> listarGestoresPorId(Long id) {
		return repository.findById(id).map(GestorDTO::create);
	}

}
