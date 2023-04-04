package com.pasCamuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.Bitacora;

@Repository 
public interface BitacoraRepository extends JpaRepository<Bitacora, Integer> {

	
	
}
