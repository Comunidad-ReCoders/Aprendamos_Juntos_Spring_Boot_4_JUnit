package cl.recoders.junit.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

import cl.recoders.junit.SpringTestApplication;
import cl.recoders.junit.model.Ciudad;
import cl.recoders.junit.repository.CiudadRepository;

// Agregamos el SpringBootTest para cargar todo el contexto de la app
@SpringBootTest(
  webEnvironment = WebEnvironment.MOCK,
  classes = SpringTestApplication.class)
// Agregamos AutoConfigureMockMvc para habilitar el uso de MockMvc y realizar peticiones http
@AutoConfigureMockMvc
public class CiudadControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	// Ocupamos el repositorio para insertar los datos de ejemplo
	@Autowired
	CiudadRepository repository;
	
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
	    
	    repository.saveAll(lista);
		
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
		 .andExpect(model().attribute("ciudad", hasProperty("id", is(1L))));
		
	}

}
