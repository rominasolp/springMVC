package com.ticketero.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketero.dao.TipoDeEventoDAO;
import com.ticketero.model.TipoDeEvento;

@Service
public class TipoDeEventoServiceImpl implements TipoDeEventoService {

	private TipoDeEventoDAO tipoDeEventoDAO;

	public void setTipoDeEventoDAO(TipoDeEventoDAO TipoDeEventoDAO) {
		this.tipoDeEventoDAO = TipoDeEventoDAO;
	}
	
	@Override
	@Transactional
	public List<TipoDeEvento> listTipoDeEventos() {
		
		return this.tipoDeEventoDAO.listTipoDeEventos();
	}

	@Override
	@Transactional
	public TipoDeEvento getTipoDeEventoById(int id) {
		return this.tipoDeEventoDAO.getTipoDeEventoById(id);
	}
	
	
}
