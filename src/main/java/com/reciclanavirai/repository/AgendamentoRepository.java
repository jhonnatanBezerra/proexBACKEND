package com.reciclanavirai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reciclanavirai.domain.Agendamento;
import com.reciclanavirai.domain.Bairro;
import com.reciclanavirai.domain.enums.DiaSemana;
import com.reciclanavirai.domain.enums.TipoColeta;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	@Query( value = "select a.bairro, a.diaSemana, a.tipoColeta from Agendamento a "
			+ "where a.bairro = :bairro and a.diaSemana = :diaSemana and a.tipoColeta = :tipoColeta")
	Optional<Agendamento> compararAgendamento(@Param("bairro") Bairro bairro, @Param("diaSemana") DiaSemana diaSemana, @Param("tipoColeta") TipoColeta tipoColeta);
			
	/**
	 * 
	 * @param bairro
	 * @return -> lista dos agendamentos para aquele bairro
	 */
	List<Agendamento> findByBairro(Bairro bairro);
}
