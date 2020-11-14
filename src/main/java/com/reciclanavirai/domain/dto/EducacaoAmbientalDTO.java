package com.reciclanavirai.domain.dto;

import java.sql.Date;

import org.modelmapper.ModelMapper;

import com.reciclanavirai.domain.EducacaoAmbiental;

import lombok.Data;

@Data
public class EducacaoAmbientalDTO {
	private Long id;
	private String titulo;
	private String foto;
	private String descricao;
	private Date data;
	
	public static EducacaoAmbientalDTO create (EducacaoAmbiental edu) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(edu, EducacaoAmbientalDTO.class);
	}
	
}
