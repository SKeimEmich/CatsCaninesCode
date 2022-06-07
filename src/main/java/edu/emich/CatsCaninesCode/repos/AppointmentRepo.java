package edu.emich.CatsCaninesCode.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.emich.CatsCaninesCode.entities.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long>{
	List<Appointment> findByPetId(Long id);
}
