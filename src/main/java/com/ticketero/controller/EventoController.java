package com.ticketero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticketero.model.Evento;
import com.ticketero.model.Musica;
import com.ticketero.model.Pelicula;
import com.ticketero.model.Teatro;
import com.ticketero.model.Deporte;
import com.ticketero.service.EventoService;
import com.ticketero.service.TeatroService;
import com.ticketero.service.PeliculaService;
import com.ticketero.service.MusicaService;
import com.ticketero.service.DeporteService;
import com.ticketero.service.TipoDeEventoService;

@Controller
@RequestMapping("/admin")
public class EventoController {

	private EventoService srv;
	private TipoDeEventoService srvTipos;
	private TeatroService srvTeatro;
	private PeliculaService srvPelicula;
	private DeporteService srvDeporte;
	private MusicaService srvMusica;
		
	@Autowired(required=true)
	@Qualifier(value="eventoService")
	public void setEventoService(EventoService ps){
		this.srv = ps;
	}
	
	@Autowired(required=true)
	@Qualifier(value="tipoDeEventoService")
	public void setTipoDeEventoService(TipoDeEventoService ps){
		this.srvTipos = ps;
	}
	
	@Autowired(required=true)
	@Qualifier (value="teatroService")
	public void setTeatroService(TeatroService ps){
		this.srvTeatro = ps;
	}

	@Autowired(required=true)
	@Qualifier (value="peliculaService")
	public void setPeliculaService(PeliculaService ps){
		this.srvPelicula = ps;
	}
	
	@Autowired(required=true)
	@Qualifier (value="deporteService")
	public void setDeporteService(DeporteService ps){
		this.srvDeporte = ps;
	}
	
	@Autowired(required=true)
	@Qualifier (value="musicaService")
	public void setMusicaService(MusicaService ps){
		this.srvMusica = ps;
	}
	
		
	@RequestMapping(value = "/eventos", method = RequestMethod.GET)	
	public String listEventos(Model model) {
		model.addAttribute("evento", new Evento());
		
		model.addAttribute("listEventos", this.srv.listEventos());
		
		model.addAttribute("listTipoDeEventos", this.srvTipos.listTipoDeEventos());
		
		return "eventos";
	}
	
	//For add and update evento both
	@RequestMapping(value= "/evento/add", method = RequestMethod.POST)
	public String addEvento(			
			@ModelAttribute("evento") Evento p,
			@RequestParam("generoteatro") String generoteatro,
			@RequestParam("generocine") String generopelicula,
			@RequestParam("tipodeporte") String tipodeporte,
			@RequestParam("generomusica") String generomusica
			){
		
		if(p.getId() == 0){
			//new evento, add it			
			this.srv.addEvento(p);
			switch (p.getIdTipoDeEvento()) {
				case 1:
				Teatro teatro = new Teatro();
				teatro.setGenero(generoteatro);
				teatro.setEvento_id(p.getId());
				this.srvTeatro.addTeatro(teatro);
				break;
				
				case 3:
				Pelicula peli = new Pelicula();
				peli.setGenero(generopelicula);
				peli.setEvento_id(p.getId());
				this.srvPelicula.addPelicula(peli);
				break;
				
				case 4:
				Musica music = new Musica();
				music.setEstilo(generomusica);
				music.setEvento_id(p.getId());
				this.srvMusica.addMusica(music);
				break;
				
				case 5:
				Deporte dep = new Deporte();
				dep.setDeporte(tipodeporte);
				dep.setEvento_id(p.getId());
				this.srvDeporte.addDeporte(dep);
				break;
				
				default:
				break;
			}
				
			
			
		}else{
			//existing evento, call update
			this.srv.updateEvento(p);
		}
		
		return "redirect:/admin/eventos";
		
	}
	
	@RequestMapping("/evento/remove/{id}")
    public String removeEvento(@PathVariable("id") int id){
		
        this.srv.removeEvento(id);
        return "redirect:/admin/eventos";
    }
	
	@RequestMapping("/evento/edit/{id}")
    public String editEvento(@PathVariable("id") int id, Model model){
        model.addAttribute("evento", this.srv.getEventoById(id));
        model.addAttribute("listTipoDeEventos", this.srvTipos.listTipoDeEventos());
        model.addAttribute("listEventos", this.srv.listEventos());
        return "eventos";
    }

	
}
