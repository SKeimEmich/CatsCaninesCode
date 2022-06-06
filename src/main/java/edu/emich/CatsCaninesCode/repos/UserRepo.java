package edu.emich.CatsCaninesCode.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.emich.CatsCaninesCode.entities.User;

public interface UserRepo extends JpaRepository<User, String>{
	
}
