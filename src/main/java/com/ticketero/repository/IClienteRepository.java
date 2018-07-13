package com.ticketero.repository;

import com.ticketero.model.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
		
	
	 @Query("SELECT cli FROM Cliente cli  WHERE cli.login=(:pLogin) AND cli.password= (:pClave)")	 
	 List<Cliente> findByLoginYPassword(@Param("pLogin") String pLogin, @Param("pClave") String pClave);
	 

}
