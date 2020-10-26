package com.reciclanavirai.domain.dto;

import org.modelmapper.ModelMapper;

import com.reciclanavirai.domain.Departamento;

import lombok.Data;

@Data
public class DepartamentoDTO {
	private Long id;
	private String nome;
	
	public static DepartamentoDTO create(Departamento d) {
		ModelMapper mm = new ModelMapper();
		return mm.map(d, DepartamentoDTO.class);
	}
}
