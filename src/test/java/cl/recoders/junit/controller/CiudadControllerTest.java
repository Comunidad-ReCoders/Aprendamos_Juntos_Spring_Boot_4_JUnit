package cl.recoders.junit.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import cl.recoders.junit.model.Ciudad;
import cl.recoders.junit.service.CiudadService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CiudadController.class)
public class CiudadControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CiudadService service;
	
	@BeforeEach
	public void setUp() {
		// Given
		Ciudad santiago = new Ciudad(1L, "SAN", "Santiago", "Chile", null, null);
	    Ciudad vinia = new Ciudad(2L, "VIN", "Viña del Mar", "Chile", null, null);
	    Ciudad rancagua = new Ciudad(3L, "RAN", "Rancagua", "Chile", null, null);
	    Ciudad conce = new Ciudad(4L, "CON", "Concepción", "Chile", null, null);
	    Ciudad temuco = new Ciudad(5L, "TEM", "Temuco", "Chile", null, null);
	    Collection<Ciudad> lista = Stream.of(santiago, vinia, rancagua, conce, temuco)
		  .collect(Collectors.toList());
		
	    when(service.findAll())
		 .thenReturn(lista);
	    when(service.findById(santiago.getId()))
	     .thenReturn(santiago);
	}
	
	@Test
	public void showListCiudadesTest() 
	  throws Exception {
		// When
		this.mockMvc.perform(get("/cities/list"))
		
		// Then
		 .andExpect(status().isOk())
		 .andExpect(model().attribute("ciudades", isA(Collection.class)));
		
	}
	
	@Test
	public void showDetailsCiudad() 
	  throws Exception {
		
		// Given
		long id = 1L;
		
		// When
		this.mockMvc.perform(get("/cities/" + id))
		
		// Then
		 .andExpect(status().isOk())
		 .andExpect(model().attribute("ciudad", isA(Ciudad.class)))
		 .andExpect(model().attribute("ciudad", hasProperty("id", is(id))));
		
	}

}
