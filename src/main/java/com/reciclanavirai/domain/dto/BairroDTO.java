package com.reciclanavirai.domain.dto;

import org.modelmapper.ModelMapper;

import com.reciclanavirai.domain.Bairro;

import lombok.Data;

@Data
public class BairroDTO {
	private Long id;
	private String nome;
	
	public static BairroDTO create(Bairro b) {	
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(b, BairroDTO.class);
	}	
}
