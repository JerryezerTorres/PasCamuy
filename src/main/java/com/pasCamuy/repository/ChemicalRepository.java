package com.pasCamuy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.pasCamuy.model.Chemical;

@Repository
public interface ChemicalRepository extends JpaRepository<Chemical, Integer> {
	
	 @Query(value = "SELECT * FROM chemical WHERE id order by id desc", nativeQuery = true)
	 List<Chemical> findByIdOrderByIdDesc();
	
	 
	 @Query(value = "SELECT * FROM chemical WHERE date order by date desc", nativeQuery = true)
	 List<Chemical> findByDateOrderByDateDesc();

}
