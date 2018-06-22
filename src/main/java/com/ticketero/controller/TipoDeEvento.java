package com.ticketero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticketero.service.TipoDeEventoService;

@Controller
@RequestMapping("/admin")
public class TipoDeEvento {

	private TipoDeEventoService TipoDeEventoService;
	
	@Autowired(required=true)
	@Qualifier(value="tipoDeEventoService")
	public void setTipoDeEventoService(TipoDeEventoService ps){
		this.TipoDeEventoService = ps;
	}
	
	@RequestMapping(value = "/tiposdeevento", method = RequestMethod.GET)
	public List<com.ticketero.model.TipoDeEvento> listTipoDeEventos() {
		
		return this.TipoDeEventoService.listTipoDeEventos();
	}
	
}
