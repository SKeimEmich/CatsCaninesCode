package edu.emich.CatsCaninesCode.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.emich.CatsCaninesCode.entities.Record;

public interface RecordRepo extends JpaRepository<Record, Long> {

}
