package com.pasCamuy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasCamuy.model.Contacts;
import com.pasCamuy.repository.ContactsRepository;

@Service
public class ContactsServiceImp implements IContactsService {

	@Autowired
	private ContactsRepository contactsService;
	
	
	@Override
	public List<Contacts> findAll() {
		return contactsService.findAll();
	}

	@Override
	public void save(Contacts contacts) {
		contactsService.save(contacts);
		
	}

	@Override
	public Contacts findById(Integer id) {
		return contactsService.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		contactsService.deleteById(id);
		
	}



}
