package com.reciclanavirai.service;

import java.util.List;
import java.util.Optional;

import com.reciclanavirai.domain.Agendamento;
import com.reciclanavirai.domain.dto.AgendamentoDTO;

public interface AgendamentoService {

	AgendamentoDTO salvar(Agendamento agendamento);
	AgendamentoDTO atualizar(Agendamento agendamento);
	void excluir(Long id);
	Optional<AgendamentoDTO> listarAgendamentoPorId(Long id);
	List<AgendamentoDTO> listarAgendamentos();
	List<AgendamentoDTO> listarAgendamentosPorBairro(Long idBairro);
	
}
