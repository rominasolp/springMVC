package com.ticketero.dao;

import java.util.List;

import com.ticketero.model.Deporte;

public interface DeporteDAO {

	public void addDeporte(Deporte p);
	public void updateDeporte(Deporte p);
	public List<Deporte> listDeportes();
	public Deporte getDeporteById(int id);
	public void removeDeporte(int id);
	
}
