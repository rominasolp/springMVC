package com.ticketero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketero.model.TipoDeEvento;

public interface ITipoDeEventoRepository extends JpaRepository<TipoDeEvento, Integer> {

}
