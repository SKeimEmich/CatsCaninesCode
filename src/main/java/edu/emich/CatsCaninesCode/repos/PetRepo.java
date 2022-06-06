package edu.emich.CatsCaninesCode.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.emich.CatsCaninesCode.entities.Pet;

public interface PetRepo extends JpaRepository<Pet, Long>{

}
