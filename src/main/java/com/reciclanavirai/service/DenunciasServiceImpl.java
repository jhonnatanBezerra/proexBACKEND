package com.reciclanavirai.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reciclanavirai.domain.Denuncia;
import com.reciclanavirai.domain.dto.DenunciaDTO;
import com.reciclanavirai.repository.DenunciasRepository;

@Service @Transactional(readOnly = false)
public class DenunciasServiceImpl implements DenunciasService{
	
	@Autowired
	private DenunciasRepository repository;

	@Override
	public DenunciaDTO salvar(Denuncia d) {		
		return DenunciaDTO.create(repository.save(d));
	}

	@Override
	public DenunciaDTO atualizar(Denuncia d) {		
		return DenunciaDTO.create(repository.save(d));
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<DenunciaDTO> listarDenuncias() {		
		return repository.findAll().stream().map(DenunciaDTO::create).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DenunciaDTO> listarDenunciaPorId(Long id) {
		
		return repository.findById(id).map(DenunciaDTO::create);
	}
	
	
}
