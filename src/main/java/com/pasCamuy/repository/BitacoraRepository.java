package com.pasCamuy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.Bitacora;
import com.pasCamuy.model.Contacts;

@Repository 
public interface BitacoraRepository extends JpaRepository<Bitacora, Integer> {
	
	 @Query(value = "SELECT * FROM bitacora WHERE id order by id desc", nativeQuery = true)
	 List<Bitacora> findByIdOrderByIdDesc();
	
	 
	 @Query(value = "SELECT * FROM bitacora WHERE date order by date desc", nativeQuery = true)
	 List<Bitacora> findByDateOrderByDateDesc();
}
