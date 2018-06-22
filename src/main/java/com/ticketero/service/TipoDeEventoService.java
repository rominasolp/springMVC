package com.ticketero.service;

import java.util.List;

import com.ticketero.model.TipoDeEvento;

public interface TipoDeEventoService {

	public List<TipoDeEvento> listTipoDeEventos();
	public TipoDeEvento getTipoDeEventoById(int id);
}
