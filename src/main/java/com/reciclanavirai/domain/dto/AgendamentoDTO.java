package com.reciclanavirai.domain.dto;

import org.modelmapper.ModelMapper;

import com.reciclanavirai.domain.Agendamento;
import com.reciclanavirai.domain.Bairro;

import lombok.Data;

@Data
public class AgendamentoDTO {
	private Long id;	
	private String horario;	
	private String diaSemana;	
	private String tipoColeta;	
	private Bairro bairro;
	
	public static AgendamentoDTO create(Agendamento a) {	
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(a, AgendamentoDTO.class);
	}	
}
