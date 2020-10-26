package com.reciclanavirai.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reciclanavirai.domain.Gestor;
import com.reciclanavirai.domain.dto.GestorDTO;
import com.reciclanavirai.exception.ErroAutenticacaoException;
import com.reciclanavirai.exception.RegraDeNegocioException;
import com.reciclanavirai.repository.GestorRepository;

@Service @Transactional(readOnly = false)
public class GestorServiceImpl implements GestorService{

	GestorRepository repository;
	
	@Override
	public GestorDTO salvar(Gestor g) {
		validarEmail(g.getEmail());
		return GestorDTO.create(repository.save(g));
	}

	@Override
	public GestorDTO atualizar(Gestor g) {
		validarEmail(g.getEmail());
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

	@Override
	public GestorDTO autenticar(String email, String senha) {
		Optional<Gestor> gestor = repository.findByEmail(email);
		if(!gestor.isPresent()) {
			throw new ErroAutenticacaoException("E-mail de gestor não encontrado");
		}
		if(!gestor.get().getSenha().equals(senha)){
			throw new ErroAutenticacaoException("Senha invalida");
		}
		return GestorDTO.create(gestor.get());
	}

	@Override
	public void validarEmail(String email) {
		boolean response = repository.existsByEmail(email);
		if(response) {
			throw new RegraDeNegocioException("Este email já esta vinculado a um gestor cadastrado");
		}
	}

}
