package cl.recoders.junit.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recoders.junit.model.Avion;
import cl.recoders.junit.repository.AvionRepository;

@Service
public class AvionServiceImpl implements AvionService {

	@Autowired
	AvionRepository repository;
	
	@Override
	public Avion findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Collection<Avion> findAll() {
		return repository.findAll();
	}

	@Override
	public Avion save(Avion avion) {
		return repository.save(avion);
	}

	@Override
	public Avion update(Avion avion) {
		return repository.save(avion);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
