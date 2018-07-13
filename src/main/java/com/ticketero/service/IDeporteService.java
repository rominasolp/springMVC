package com.ticketero.service;

import java.util.List;

import com.ticketero.dto.DeporteDto;
import com.ticketero.exception.DeporteNotFoundException;
import com.ticketero.model.Deporte;

public interface IDeporteService {

	public Deporte addDeporte(DeporteDto p);
	public Deporte updateDeporte(DeporteDto p) throws DeporteNotFoundException;
	public List<Deporte> listDeportes();
	public Deporte getDeporteById(Integer id) throws DeporteNotFoundException;
	public Deporte removeDeporte(Integer id)throws DeporteNotFoundException;
	public Deporte getDeporteByIdDeEvento(Integer id) throws DeporteNotFoundException;
	
}
