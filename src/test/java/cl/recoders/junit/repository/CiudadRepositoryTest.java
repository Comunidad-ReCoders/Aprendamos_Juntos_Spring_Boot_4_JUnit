package cl.recoders.junit.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cl.recoders.junit.model.Ciudad;

// Test de integración, comprueba repositorio, entidad 
// y comunicación con el JpaRepository
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CiudadRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	CiudadRepository repository;
	
	@Test
	public void findFirstByCodigoTest() {
		// Given
		Ciudad santiago = new Ciudad(1L, "SAN", "Santiago", "Chile", null, null);
		entityManager.persistAndFlush(santiago);
		
		// When
		Optional<Ciudad> encontrado = repository.findFirstByCodigo(santiago.getCodigo());
		
		// Then
		assertThat(encontrado.get())
		 .isEqualTo(santiago);
		
	}
	
	@Test
	public void findByPaisIgnoreCaseTest() {
		// Given
		Ciudad santiago = new Ciudad(1L, "SAN", "Santiago", "Chile", null, null);
	    Ciudad vinia = new Ciudad(2L, "VIN", "Viña del Mar", "Chile", null, null);
	    Ciudad rancagua = new Ciudad(3L, "RAN", "Rancagua", "Chile", null, null);
	    entityManager.persist(santiago);
	    entityManager.persist(vinia);
	    entityManager.persist(rancagua);
	    entityManager.flush();
	    
	    // When
	    Collection<Ciudad> listaEncontrada = repository.findByPaisIgnoreCase("CHILe");
	    
	    // Then
	    assertThat(listaEncontrada.size())
	     .isEqualTo(3);
	    assertThat(listaEncontrada)
	     .contains(santiago, vinia, rancagua);
	}
	
}
