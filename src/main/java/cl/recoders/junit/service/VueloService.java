package cl.recoders.junit.service;

import java.util.Collection;

import cl.recoders.junit.model.Vuelo;

public interface VueloService {
	
	Vuelo findById(long id);
	Collection<Vuelo> findAll();
	Vuelo save(Vuelo vuelo);
	Vuelo update(Vuelo vuelo);
	void deleteById(long id);
	
}
