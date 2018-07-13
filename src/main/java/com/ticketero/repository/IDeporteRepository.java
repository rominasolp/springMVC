package com.ticketero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketero.model.Deporte;

public interface IDeporteRepository extends JpaRepository<Deporte, Integer> {
	
	 @Query("SELECT dep FROM Deporte dep  WHERE dep.evento_id=(:pEvento)")	 
	 public Deporte getDeporteByIdDeEvento(@Param("pEvento") Integer pEvento);
	 
}
