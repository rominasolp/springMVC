package com.ticketero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketero.model.Evento;

public interface IEventoRepository extends JpaRepository<Evento, Integer> {

}
