package com.ticketero.service;

import java.util.List;

import com.ticketero.model.Deporte;

public interface DeporteService {

	public void addDeporte(Deporte p);
	public void updateDeporte(Deporte p);
	public List<Deporte> listDeportes();
	public Deporte getDeporteById(int id);
	public void removeDeporte(int id);
}
