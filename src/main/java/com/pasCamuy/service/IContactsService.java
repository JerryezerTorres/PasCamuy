package com.pasCamuy.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pasCamuy.model.Contacts;

public interface IContactsService {

	public List<Contacts> findAll();
	public void save(Contacts contacts);
	public Contacts findById(Integer id);
	public void delete(Integer id);
	
	
	
	public List<Contacts> findByName(String name, Pageable Pageable) ;
	
	public List<Contacts> findByIdOrderByIdDesc();
		 
	public List<Contacts> findByIdOrderAsc();
	
}
