package com.ticketero.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.ui.Model;

import com.ticketero.dto.DeporteDto;
import com.ticketero.dto.EventoDto;
import com.ticketero.dto.MusicaDto;
import com.ticketero.dto.PeliculaDto;
import com.ticketero.dto.TeatroDto;
import com.ticketero.dto.TipoEventoDto;
import com.ticketero.exception.DeporteNotFoundException;
import com.ticketero.exception.EventoNotFoundException;
import com.ticketero.exception.MusicaNotFoundException;
import com.ticketero.exception.PeliculaNotFoundException;
import com.ticketero.exception.TeatroNotFoundException;
import com.ticketero.exception.TipoDeEventoNotFoundException;
import com.ticketero.model.Deporte;
import com.ticketero.model.Evento;
import com.ticketero.model.Musica;
import com.ticketero.model.Pelicula;
import com.ticketero.model.Teatro;
import com.ticketero.model.TipoDeEvento;
import com.ticketero.service.IDeporteService;
import com.ticketero.service.IEventoService;
import com.ticketero.service.IMusicaService;
import com.ticketero.service.IPeliculaService;
import com.ticketero.service.ITeatroService;
import com.ticketero.service.ITipoDeEventoService;


@Controller
@SessionAttributes("loginBean")
@RequestMapping("/admin")
public class EventoController {
	
	@Resource
	private IEventoService EventoService;
	
	@Resource
	private ITipoDeEventoService TipoDeEventoService;
	
	@Resource
	private IDeporteService DeporteService;
	
	@Resource
	private IMusicaService MusicaService;
	
	@Resource
	private IPeliculaService PeliculaService;
	
	@Resource
	private ITeatroService TeatroService;
	
	@RequestMapping(value = "/eventos", method = RequestMethod.GET)	
	public String listEventos(Model model) {
		model.addAttribute("evento", new Evento());
		
		model.addAttribute("listEventos", this.EventoService.listEventos());
		
		model.addAttribute("listTipoDeEventos", this.TipoDeEventoService.listTipoDeEventos());
		
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
			) throws TipoDeEventoNotFoundException, ParseException, EventoNotFoundException, DeporteNotFoundException, TeatroNotFoundException, PeliculaNotFoundException, MusicaNotFoundException{
		
		TipoDeEvento te = this.TipoDeEventoService.getTipoDeEventoById(p.getIdTipoDeEvento());
		
		EventoDto evnt = createDTO(p, te);
		
		evnt.setFecha_desde(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-01"));
		evnt.setFecha_hasta(new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-01"));
		

		if(p.getId() == null){
			//new evento, add it			
			p = this.EventoService.addEvento(evnt);
			
			switch (p.getIdTipoDeEvento()) {
				case 1:
				TeatroDto teatro = new TeatroDto();
				teatro.setGenero(generoteatro);
				teatro.setEvento_id(p.getId());
				this.TeatroService.addTeatro(teatro);
				
				break;
				
				case 3:
				PeliculaDto peli = new PeliculaDto();
				peli.setGenero(generopelicula);
				peli.setEvento_id(p.getId());
				this.PeliculaService.addPelicula(peli);
				
				break;
				
				case 4:
				MusicaDto music = new MusicaDto();
				music.setEstilo(generomusica);
				music.setEvento_id(p.getId());
				this.MusicaService.addMusica(music);
				break;
				
				case 5:
				DeporteDto dep = new DeporteDto();
				dep.setDeporte(tipodeporte);
				dep.setEvento_id(p.getId());
				
				this.DeporteService.addDeporte(dep);
				break;
				
				default:
				break;
			}
			
		}else{
			//existing evento, call update
			this.EventoService.updateEvento(evnt);
			
			switch (p.getIdTipoDeEvento()) {
			
			case 1:			
				Teatro t = this.TeatroService.getTeatroByIdDeEvento(p.getId());
				t.setGenero(generoteatro);
				TeatroDto tdto = createTeatroDTO(t);
				
				this.TeatroService.updateTeatro(tdto);
				
				break;
			
			case 3:
				
				Pelicula peli = this.PeliculaService.getPeliculaByIdDeEvento(p.getId());
				peli.setGenero(generopelicula);
				PeliculaDto pdto = createPeliculaDTO(peli);
								
				this.PeliculaService.updatePelicula(pdto);
				
				break;
			
			case 4:
				Musica music = this.MusicaService.getMusicaByIdDeEvento(p.getId());
				music.setEstilo(generomusica);
				
				MusicaDto mdto = createMusicaDTO(music);
				
				this.MusicaService.updateMusica(mdto);
				
				break;
			
			case 5:
				Deporte dep = this.DeporteService.getDeporteByIdDeEvento(evnt.getId());
				dep.setDeporte(tipodeporte);
				
				DeporteDto ddto = createDeporteDTO(dep);				
				ddto.setEvento_id(dep.getEvento_id());
								
				this.DeporteService.updateDeporte(ddto);
				
				break;
			
			default:
			break;
			}
		}
		
		return "redirect:/admin/eventos";
		
	}	
	
	@RequestMapping("/evento/edit/{id}")
    public String editEvento(@PathVariable("id") int id, Model model) throws EventoNotFoundException, TeatroNotFoundException, PeliculaNotFoundException, MusicaNotFoundException, DeporteNotFoundException{
		Evento evnt = this.EventoService.getEventoById(id);
		String propiedadAdicional = "";
		
        model.addAttribute("evento", evnt);  
        model.addAttribute("listTipoDeEventos", this.TipoDeEventoService.listTipoDeEventos());
        model.addAttribute("listEventos", this.EventoService.listEventos());
        
        switch (evnt.getIdTipoDeEvento()) {
		
		case 1:			
			propiedadAdicional = this.TeatroService.getTeatroByIdDeEvento(evnt.getId()).getGenero();			
			break;
		
		case 3:
			propiedadAdicional = this.PeliculaService.getPeliculaByIdDeEvento(evnt.getId()).getGenero();
			break;
		
		case 4:
			propiedadAdicional = this.MusicaService.getMusicaByIdDeEvento(evnt.getId()).getEstilo();			
			break;
		
		case 5:
			propiedadAdicional = this.DeporteService.getDeporteByIdDeEvento(evnt.getId()).getDeporte();
			break;
		
		default:
		break;
		}
        
        model.addAttribute("propiedad", propiedadAdicional);
        
        return "eventos";
    }

	@RequestMapping("/evento/remove/{id}")
    public String removeEvento(@PathVariable("id") int id) throws EventoNotFoundException{
		
        //this.EventoService.removeEvento(id);

		//throw new NotImplementedException("Eliminar el tipo de evento antes");
        
        return "redirect:/admin/eventos";
    }
	
	private EventoDto createDTO(Evento model, TipoDeEvento tipo) {
		EventoDto dto = new EventoDto();

		TipoEventoDto te = new TipoEventoDto();
		
		te.setId(tipo.getId());
		te.setNombre(te.getNombre());
		dto.setTipo_de_evento(te);
					
       	dto.setId(model.getId());        
        dto.setNombre_de_evento(model.getNombreEvento());
        dto.setDescripcion(model.getDescripcion());
        dto.setDireccion(model.getDireccion());
        dto.setFecha_desde(model.getFechaDesde());
        dto.setFecha_hasta(model.getFechaHasta());
        dto.setPrecio(model.getPrecio());
        dto.setStock(model.getStock());

        return dto;
    }
		
	private MusicaDto createMusicaDTO(Musica model) {
		MusicaDto dto = new MusicaDto();
					
       	dto.setId(model.getId());        
        dto.setEstilo(model.getEstilo());
        dto.setEvento_id(model.getEvento_id());        

        return dto;
    }
	
	private TeatroDto createTeatroDTO(Teatro model) {
		TeatroDto dto = new TeatroDto();
					
       	dto.setId(model.getId());        
        dto.setGenero(model.getGenero());
        dto.setEvento_id(model.getEvento_id());        

        return dto;
    }
	
	private PeliculaDto createPeliculaDTO(Pelicula model) {
		PeliculaDto dto = new PeliculaDto();
					
       	dto.setId(model.getId());        
        dto.setGenero(model.getGenero());
        dto.setEvento_id(model.getEvento_id());        

        return dto;
    }

	private DeporteDto createDeporteDTO(Deporte model) {
		DeporteDto dto = new DeporteDto();
					
       	dto.setId(model.getId());        
        dto.setDeporte(model.getDeporte());
        dto.setEvento_id(model.getEvento_id());        

        return dto;
    }
	
}
