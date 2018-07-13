package com.ticketero.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ticketero.model.LoginBean;
import com.ticketero.service.IClienteService;
import com.ticketero.service.IEventoService;

@Controller
@SessionAttributes("loginBean")
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	private IClienteService ClienteService;

	@Resource
	private IEventoService EventoService;
		
	@RequestMapping(value="/form",method=RequestMethod.GET)	
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response)  {

		ModelAndView mv = new ModelAndView("login");

		LoginBean loginBean = new LoginBean();

		mv.addObject("loginBean", loginBean);

		return mv;

	}
	
	@RequestMapping(value="/in",method=RequestMethod.POST)
	public ModelAndView executeLogin(
			HttpServletRequest request, 
			HttpServletResponse response, 
			@ModelAttribute("loginBean")LoginBean loginBean) {
		
		ModelAndView mv= null;
		
		try {
			
			boolean isValidUser = this.ClienteService.isValidUser(loginBean.getUsername(), loginBean.getPassword());
			if(isValidUser)	{
				System.out.println("User Login Successful");
				
				//request.setAttribute("loggedInUser", loginBean.getUsername());				
				
				mv = new ModelAndView("home");
				
				mv.addObject("listaDeEventos", this.EventoService.listEventos());
				
			} else {
				mv = new ModelAndView("login");
				mv.addObject("loginBean", loginBean);				
				request.setAttribute("message", "Invalid credentials!!");
			}

		}
		catch(Exception e)	{
			e.printStackTrace();
		}

		return mv;
	}
	
	@RequestMapping(value="/out",method=RequestMethod.GET)	
	public String ExecuteLogout(SessionStatus sessionStatus)  {
		sessionStatus.setComplete();

		return "redirect:/";
	}
	
	@ModelAttribute("visitor")
	public LoginBean getUsuarioSession (HttpServletRequest request) {
		return new LoginBean();
	}
	 

}