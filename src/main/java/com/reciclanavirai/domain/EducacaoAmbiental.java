package com.reciclanavirai.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class EducacaoAmbiental {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String foto;
	private String descricao;
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "fk_gestor_id")
	private Gestor gestor;
}
