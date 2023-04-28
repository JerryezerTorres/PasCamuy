package com.pasCamuy.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.Chemical;

@Repository
public interface ChemicalRepository extends JpaRepository<Chemical, Integer> {
	
	/*List<Chemical> findByDate(Date date);*/
	

}
