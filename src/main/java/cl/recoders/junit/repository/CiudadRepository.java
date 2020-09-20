package cl.recoders.junit.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.recoders.junit.model.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long>{
	
	Optional<Ciudad> findFirstByCodigo(String codigo);
	Collection<Ciudad> findByPaisIgnoreCase(String pais);

}
