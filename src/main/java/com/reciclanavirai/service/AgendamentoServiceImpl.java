package com.reciclanavirai.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reciclanavirai.domain.Agendamento;
import com.reciclanavirai.domain.Bairro;
import com.reciclanavirai.domain.dto.AgendamentoDTO;
import com.reciclanavirai.exception.RegraDeNegocioException;
import com.reciclanavirai.repository.AgendamentoRepository;
import com.reciclanavirai.repository.BairroRepository;

@Service @Transactional(readOnly = false)
public class AgendamentoServiceImpl implements AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private BairroRepository bairroRepository;

	@Override
	public AgendamentoDTO salvar(Agendamento agendamento) {
		Bairro bairro = bairroRepository.findById(agendamento.getBairro().getId()).orElseThrow(() -> new RegraDeNegocioException("Bairro não encontrado"));
		agendamento.setBairro(bairro);
		
		Optional<Agendamento> agendamentoComparado = agendamentoRepository.compararAgendamento(
				agendamento.getBairro(), 
				agendamento.getDiaSemana(), 
				agendamento.getTipoColeta());
		
		if(!agendamentoComparado.isPresent()) {						
			return AgendamentoDTO.create(agendamentoRepository.save(agendamento));
		} else {
			throw new RegraDeNegocioException("Essa coleta já foi agendada para esse dia nesse bairro, tente a opção de atualizar.");
		}
	}
	
	@Override
	public AgendamentoDTO atualizar(Agendamento agendamento) {		
		return AgendamentoDTO.create(agendamentoRepository.save(agendamento));
	}
	
	@Override
	public void excluir(Long id) {
		agendamentoRepository.deleteById(id);		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<AgendamentoDTO> listarAgendamentos() {
		return agendamentoRepository.findAll().stream().map(AgendamentoDTO::create).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<AgendamentoDTO> listarAgendamentosPorBairro(Long idBairro) {
		Bairro bairro = bairroRepository.findById(idBairro).orElseThrow(() -> new RegraDeNegocioException("Bairro não encontrado"));
		return agendamentoRepository.findByBairro(bairro).stream().map(AgendamentoDTO::create).collect(Collectors.toList());		
	}

	@Override
	public Optional<AgendamentoDTO> listarAgendamentoPorId(Long id) {		
		return agendamentoRepository.findById(id).map(AgendamentoDTO::create);
	}
}
