package com.reciclanavirai.domain.dto;

import java.sql.Date;

import org.modelmapper.ModelMapper;

import com.reciclanavirai.domain.Denuncia;

import lombok.Data;

@Data
public class DenunciaDTO {
	private Long id;
	private String denuncia;
	private String foto;
	private Date data;
	
	public static DenunciaDTO create(Denuncia d) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(d, DenunciaDTO.class);
	}
}
