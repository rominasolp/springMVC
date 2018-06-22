package com.ticketero.dao;

import java.util.List;

import com.ticketero.model.TipoDeEvento;

public interface TipoDeEventoDAO {

	public List<TipoDeEvento> listTipoDeEventos();
	public TipoDeEvento getTipoDeEventoById(int id);	
	
}
