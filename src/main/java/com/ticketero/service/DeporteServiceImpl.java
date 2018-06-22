package com.ticketero.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.ticketero.dao.DeporteDAO;
import com.ticketero.model.Deporte;

@Service
public class DeporteServiceImpl implements DeporteService {

	private DeporteDAO deporteDAO;

	public void setTipoDeEventoDAO(DeporteDAO miDAO) {
		this.deporteDAO = miDAO;
	}
	
	@Override
	@Transactional
	public void addDeporte(Deporte p) {
		this.deporteDAO.addDeporte(p);		
	}

	@Override
	@Transactional
	public void updateDeporte(Deporte p) {
		this.deporteDAO.updateDeporte(p);		
	}

	@Override
	@Transactional
	public List<Deporte> listDeportes() {
		return this.deporteDAO.listDeportes();				
	}

	@Override
	@Transactional
	public Deporte getDeporteById(int id) {
		return this.deporteDAO.getDeporteById(id);
	}

	@Override
	@Transactional
	public void removeDeporte(int id) {
		this.deporteDAO.removeDeporte(id);		
	}

}
