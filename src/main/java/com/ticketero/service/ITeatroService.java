package com.ticketero.service;

import java.util.List;

import com.ticketero.dto.TeatroDto;
import com.ticketero.exception.TeatroNotFoundException;
import com.ticketero.model.Teatro;

public interface ITeatroService {

	public Teatro addTeatro(TeatroDto p);
	public Teatro updateTeatro(TeatroDto p) throws TeatroNotFoundException;
	public List<Teatro> listTeatros();
	public Teatro getTeatroById(Integer id) throws TeatroNotFoundException;
	public Teatro removeTeatro(Integer id)throws TeatroNotFoundException;
	public Teatro getTeatroByIdDeEvento(Integer id) throws TeatroNotFoundException;
	
}
