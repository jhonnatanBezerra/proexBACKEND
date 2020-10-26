package com.reciclanavirai.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoColeta {
	COLETASELETIVA(1, "Coleta Seletiva"),
	COLETACOMUM(2, "Coleta Comum");
		
	private int id;
	private String coleta;		
}
