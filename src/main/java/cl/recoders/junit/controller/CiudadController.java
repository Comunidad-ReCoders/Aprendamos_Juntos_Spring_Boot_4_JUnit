package cl.recoders.junit.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.recoders.junit.model.Ciudad;
import cl.recoders.junit.service.CiudadService;

@Controller
@RequestMapping("/cities")
public class CiudadController {
	
	@Autowired
	CiudadService service;
	
	@GetMapping("/list")
	public ModelAndView showListCiudades() {
		
		ModelAndView mav = new ModelAndView("cities");
		Collection<Ciudad> cities = service.findAll();
		mav.addObject("ciudades", cities);
		return mav;
		
	}
	
	@GetMapping("/{id}")
	public ModelAndView showDetailsCiudad(@PathVariable(name = "id") long id) {
		
		ModelAndView mav = new ModelAndView("citydetails");
		Ciudad city = service.findById(id);
		mav.addObject("ciudad", city);
		return mav;
		
	}
	
}
