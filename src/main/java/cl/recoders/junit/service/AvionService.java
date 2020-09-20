package cl.recoders.junit.service;

import java.util.Collection;

import cl.recoders.junit.model.Avion;

public interface AvionService {
	
	Avion findById(long id);
	Collection<Avion> findAll();
	Avion save(Avion avion);
	Avion update(Avion avion);
	void deleteById(long id);
	
}
