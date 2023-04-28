package com.pasCamuy.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.pasCamuy.model.Contacts;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Integer> {
	 
	 @Query(value = "SELECT * FROM contacts WHERE id order by id desc", nativeQuery = true)
	 List<Contacts> findByIdOrderByIdDesc();
	
	 @Query(value = "SELECT * FROM contacts WHERE id order by id asc", nativeQuery = true)
	 List<Contacts> findByIdOrderAsc();
	
	 
	
}
