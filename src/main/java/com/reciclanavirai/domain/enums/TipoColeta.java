package com.reciclanavirai.domain.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoColeta {
	@JsonProperty("Coleta Seletiva")
	COLETASELETIVA(1, "Coleta Seletiva"),
	@JsonProperty("Coleta Comum")
	COLETACOMUM(2, "Coleta Comum");
		
	private int id;
	private String coleta;		
}