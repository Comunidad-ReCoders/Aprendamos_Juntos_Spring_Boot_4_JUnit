package cl.recoders.junit.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recoders.junit.model.Vuelo;
import cl.recoders.junit.repository.VueloRepository;

@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
	VueloRepository repository;
	
	@Override
	public Vuelo findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Collection<Vuelo> findAll() {
		return repository.findAll();
	}

	@Override
	public Vuelo save(Vuelo vuelo) {
		return repository.save(vuelo);
	}

	@Override
	public Vuelo update(Vuelo vuelo) {
		return repository.save(vuelo);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
