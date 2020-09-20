package cl.recoders.junit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cl.recoders.junit.model.Ciudad;
import cl.recoders.junit.repository.CiudadRepository;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
public class CiudadServiceTest {
	
	@TestConfiguration
	static class CiudadServiceImplTestContextConfiguration {

		@Bean
		public CiudadService ciudadService() {
			return new CiudadServiceImpl();
		}
		
	}

	@Autowired
	private CiudadService service;

	@MockBean
	private CiudadRepository repository;
	
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
	 
	    when(repository.findById(santiago.getId()))
	      .thenReturn(Optional.of(santiago));
	    when(repository.findAll())
	      .thenReturn((List<Ciudad>) lista);
	}
	
	@Test
	public void findByIdTest() {
	    // Given
		long ciudadid = 1L;
		
		// When
	    Ciudad encontrado = service.findById(ciudadid);
	    
	    // Then
	    assertThat(encontrado.getId())
	     .isEqualTo(ciudadid);
	}
	
	@Test
	public void findAllTest() {
		// When
		Collection<Ciudad> listaEncontrada = service.findAll();
		
		// Then
		assertThat(listaEncontrada.size())
		 .isEqualTo(5);
	}
	
	@Test
	public void saveTest() {
		// Given
		Ciudad conce = new Ciudad(4L, "CON", "Concepción", "Chile", null, null);
		
		// When
		service.save(conce);
		
		// Then
		verify(repository).save(conce);
	}
	
	@Test
	public void updateTest() {
		// Given
		Ciudad rancagua = new Ciudad(3L, "RAN", "Rancagua", "Chile", null, null);
		
		// When
		service.update(rancagua);
		
		// Then
		verify(repository).save(rancagua);
	}
	
	@Test
	public void deleteByIdTest() {
		// Given
		long ciudadid = 2L;
		
		// When
		service.deleteById(ciudadid);
		
		// Then
		verify(repository).deleteById(ciudadid);
	}

}
