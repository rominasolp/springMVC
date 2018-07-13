package com.ticketero.service;

import java.util.List;

import com.ticketero.dto.TipoEventoDto;
import com.ticketero.exception.TipoDeEventoNotFoundException;
import com.ticketero.model.TipoDeEvento;

public interface ITipoDeEventoService {

	public TipoDeEvento addTipoDeEvento(TipoEventoDto p);
	public TipoDeEvento updateTipoDeEvento(TipoEventoDto p) throws TipoDeEventoNotFoundException;
	public List<TipoDeEvento> listTipoDeEventos();
	public TipoDeEvento getTipoDeEventoById(int id) throws TipoDeEventoNotFoundException;
	public TipoDeEvento removeTipoDeEvento(int id)throws TipoDeEventoNotFoundException;
	
}
