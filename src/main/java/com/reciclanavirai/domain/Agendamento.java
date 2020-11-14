package com.reciclanavirai.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.reciclanavirai.domain.enums.DiaSemana;
import com.reciclanavirai.domain.enums.TipoColeta;

import lombok.Data;


@Entity
@Data
public class Agendamento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String horario;
	@Enumerated(value = EnumType.STRING)
	private DiaSemana diaSemana;
	@Enumerated(value = EnumType.STRING)
	private TipoColeta tipoColeta;
	
	@ManyToOne
	@JoinColumn(name = "fk_bairro_id")
	private Bairro bairro;
	
	@ManyToOne
	@JoinColumn(name = "fk_gestor_id")
	private Gestor gestor;
	
}
