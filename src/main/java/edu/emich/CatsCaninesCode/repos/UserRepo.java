package edu.emich.CatsCaninesCode.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.emich.CatsCaninesCode.entities.User;

public interface UserRepo extends JpaRepository<User, String>{
	List<User> findByEmailIgnoreCase(String email);
	List<User> findByPhone(String phone);
}
