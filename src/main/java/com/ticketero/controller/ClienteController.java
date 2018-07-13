package com.ticketero.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ticketero.dto.ClienteDto;
import com.ticketero.exception.ClienteNotFoundException;
import com.ticketero.exception.FormValidationError;
import com.ticketero.model.Cliente;
import com.ticketero.service.IClienteService;

@Controller
@SessionAttributes("loginBean")
@RequestMapping("/admin")
public class ClienteController {
	
	@Resource
	private IClienteService ClienteService;
	
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String listClientes(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listClientes", this.ClienteService.listClientes());
		return "clientes";
	}
	
	//For add and update cliente both
	@RequestMapping(value= "/cliente/add", method = RequestMethod.POST)
	public String addcliente(@ModelAttribute("cliente") Cliente p) throws FormValidationError, ClienteNotFoundException{
		
		ClienteDto cli = createDTO(p);
		
		if(p.getId() == null){
			//new cliente, add it
			this.ClienteService.addCliente(cli);
		}else{
			//existing cliente, call update
			this.ClienteService.updateCliente(cli);
		}
		
		return "redirect:/admin/clientes";
		
	}
	
	@RequestMapping("/cliente/remove/{id}")
    public String removecliente(@PathVariable("id") int id) throws ClienteNotFoundException{
		
        this.ClienteService.removeCliente(id);
        return "redirect:/admin/clientes";
    }
 
    @RequestMapping("/cliente/edit/{id}")
    public String editcliente(@PathVariable("id") int id, Model model) throws ClienteNotFoundException{
        model.addAttribute("cliente", this.ClienteService.getClienteById(id));
        model.addAttribute("listClientes", this.ClienteService.listClientes());
        return "clientes";
    }
    
    private ClienteDto createDTO(Cliente model) {
        ClienteDto dto = new ClienteDto();

       	dto.setId(model.getId());        
        dto.setNombre(model.getNombre());
        dto.setApellido(model.getApellido());
        dto.setEmail(model.getEmail());
        dto.setLogin(model.getLogin());
        dto.setTelefono(model.getTelefono());

        return dto;
    }
	
}
