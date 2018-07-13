package com.ticketero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketero.model.Teatro;

public interface ITeatroRepository extends JpaRepository<Teatro, Integer> {
	
	 @Query("SELECT t FROM Teatro t  WHERE t.evento_id=(:pEvento)")	 
	 public Teatro getTeatroByIdDeEvento(@Param("pEvento") Integer pEvento);
	 
}
