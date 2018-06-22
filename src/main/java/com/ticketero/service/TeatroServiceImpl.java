package com.ticketero.service;

import java.util.List;

import com.ticketero.dao.TeatroDAO;
import com.ticketero.model.Teatro;

public class TeatroServiceImpl implements TeatroService {

	private TeatroDAO entDAO;

	public void setTeatroDAO(TeatroDAO miDAO) {
		this.entDAO = miDAO;
	}
	
	@Override
	public void addTeatro(Teatro p) {
		this.entDAO.addTeatro(p);
		
	}

	@Override
	public void updateTeatro(Teatro p) {
		this.entDAO.updateTeatro(p);		
	}

	@Override
	public List<Teatro> listTeatros() {
		return this.entDAO.listTeatros();		
	}

	@Override
	public Teatro getTeatroById(int id) {
		return this.entDAO.getTeatroById(id);
	}

	@Override
	public void removeTeatro(int id) {
		this.entDAO.removeTeatro(id);
		
	}

}
