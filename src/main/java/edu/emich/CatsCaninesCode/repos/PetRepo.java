package edu.emich.CatsCaninesCode.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.emich.CatsCaninesCode.entities.Pet;

public interface PetRepo extends JpaRepository<Pet, Long>{
	List<Pet> findByUserEmailIgnoreCase(String email);

}
