package cl.recoders.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.recoders.junit.model.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

}
