package edu.emich.CatsCaninesCode.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.emich.CatsCaninesCode.entities.Record;

public interface RecordRepo extends JpaRepository<Record, Long> {
//	List<Record> findByAppointmentId(Long id);
	
}
