package com.pasCamuy.service;

import java.util.List;

import com.pasCamuy.model.Contacts;

public interface IContactsService {

	public List<Contacts> findAll();
	public void save(Contacts contacts);
	public Contacts findById(Integer id);
	public void delete(Integer id);
	
	
}
