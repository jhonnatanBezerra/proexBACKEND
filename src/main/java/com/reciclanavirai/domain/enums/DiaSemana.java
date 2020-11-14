package com.reciclanavirai.domain.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonDeserialize
public enum DiaSemana {
	@JsonProperty("Domingo")
	DOMINGO(1, "Domingo"),
	@JsonProperty("Segunda-feira")
	SEGUNDA(2, "Segunda-feira"),
	@JsonProperty("Terça-feira")
	TERCA(3, "Terça-feira"),
	@JsonProperty("Quarta-feira")
	QUARTA(4, "Quarta-feira"),
	@JsonProperty("Quinta-feira")
	QUINTA(5, "Quinta-feira"),
	@JsonProperty("Sexta-feira")
	SEXTA(6, "Sexta-feira"),
	@JsonProperty("Sábado")
	SABADO(7, "Sábado");
	
	private int id;
	private String dia;
		
}
