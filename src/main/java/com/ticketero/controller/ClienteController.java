package com.ticketero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticketero.model.Cliente;
import com.ticketero.service.ClienteService;

@Controller
@RequestMapping("/admin")
public class ClienteController {
	
	private ClienteService ClienteService;
	
	@Autowired(required=true)
	@Qualifier(value="clienteService")
	public void setClienteService(ClienteService ps){
		this.ClienteService = ps;
	}
	
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String listClientes(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listClientes", this.ClienteService.listClientes());
		return "clientes";
	}
	
	//For add and update cliente both
	@RequestMapping(value= "/cliente/add", method = RequestMethod.POST)
	public String addcliente(@ModelAttribute("cliente") Cliente p){
		
		if(p.getId() == 0){
			//new cliente, add it
			this.ClienteService.addCliente(p);
		}else{
			//existing cliente, call update
			this.ClienteService.updateCliente(p);
		}
		
		return "redirect:/admin/clientes";
		
	}
	
	@RequestMapping("/cliente/remove/{id}")
    public String removecliente(@PathVariable("id") int id){
		
        this.ClienteService.removeCliente(id);
        return "redirect:/admin/clientes";
    }
 
    @RequestMapping("/cliente/edit/{id}")
    public String editcliente(@PathVariable("id") int id, Model model){
        model.addAttribute("cliente", this.ClienteService.getClienteById(id));
        model.addAttribute("listClientes", this.ClienteService.listClientes());
        return "clientes";
    }
	
}
