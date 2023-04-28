package com.pasCamuy.repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	Optional <User> findByEmail(String email);
	
	
}
