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
public class Denuncia {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String denuncia;
	private String foto;
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "fk_bairro_id")
	private Bairro bairro;
	
}
