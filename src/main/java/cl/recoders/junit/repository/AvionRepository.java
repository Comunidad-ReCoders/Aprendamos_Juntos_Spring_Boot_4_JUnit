package cl.recoders.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.recoders.junit.model.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long>{

}
