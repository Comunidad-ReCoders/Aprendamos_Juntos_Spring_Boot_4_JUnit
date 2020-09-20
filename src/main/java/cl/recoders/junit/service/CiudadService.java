package cl.recoders.junit.service;

import java.util.Collection;

import cl.recoders.junit.model.Ciudad;

public interface CiudadService {
	
	Ciudad findById(long id);
	Collection<Ciudad> findAll();
	Ciudad save(Ciudad ciudad);
	Ciudad update(Ciudad ciudad);
	void deleteById(long id);
	
}
