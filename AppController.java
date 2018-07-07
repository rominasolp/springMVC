package com.ticketero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

//import com.ticketero.model.Evento;
//import com.ticketero.service.EventoService;
//import com.ticketero.service.TipoDeEventoService;

@Controller
@SessionAttributes("loginBean")
@RequestMapping("/")
public class AppController {

//	private EventoService srv;
	//private TipoDeEventoService srvTipo;
	
/*	@Autowired(required=true)
	@Qualifier(value="eventoService")
	public void setEventoService(EventoService ps){
		this.srv = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="tipoDeEventoService")
	public void setTipoDeEventoService(TipoDeEventoService ps){
		this.srvTipo = ps;
	}
*/
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
	//	model.addAttribute("listaDeEventos", this.srv.listEventos());		
		return "home";
	}
	
/*	@RequestMapping(value = { "/evento/{id}"}, method = RequestMethod.GET)
	public String viewEvento(@PathVariable("id") int id, Model model){
        
        Evento evnt = this.srv.getEventoById(id);
        
        model.addAttribute("evento", evnt);
        
        model.addAttribute("tipoDeEvento", this.srvTipo.getTipoDeEventoById(evnt.getIdTipoDeEvento()));
        
        return "eventoView";
    }
*/
	@RequestMapping(value = { "/admin"}, method = RequestMethod.GET)
	public String AdminPage(ModelMap model) {
		return "redirect:/admin/persons";
	}
	
	@RequestMapping(value = { "/products"}, method = RequestMethod.GET)
	public String productsPage(ModelMap model) {
		return "products";
	}

	@RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "contactus";
	}
}