package cl.recoders.junit.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recoders.junit.model.Ciudad;
import cl.recoders.junit.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements CiudadService {

	@Autowired
	CiudadRepository repository;
	
	@Override
	public Ciudad findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Collection<Ciudad> findAll() {
		return repository.findAll();
	}

	@Override
	public Ciudad save(Ciudad ciudad) {
		return repository.save(ciudad);
	}

	@Override
	public Ciudad update(Ciudad ciudad) {
		return repository.save(ciudad);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
