package com.pasCamuy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pasCamuy.model.Contacts;
import com.pasCamuy.repository.ContactsRepository;

@Service
public class ContactsServiceImp implements IContactsService {

	@Autowired
	//private ContactsRepository contactsService;
	private ContactsRepository contactsRepository;
	
	
	@Override
	public List<Contacts> findAll() {
		//return contactsService.findAll();
		return contactsRepository.findAll();
	}

	@Override
	public void save(Contacts contacts) {
		//contactsService.save(contacts);
		contactsRepository.save(contacts);
		
	}

	@Override
	public Contacts findById(Integer id) {
		//return contactsService.findById(id).orElse(null);
		return contactsRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		//contactsService.deleteById(id);
		contactsRepository.deleteById(id);
		
	}

	@Override
	public List<Contacts> findByName(String name, Pageable Pageable) {
		
		return null;
	}

	@Override
	public List<Contacts> findByIdOrderByIdDesc() {
		
		return contactsRepository.findByIdOrderByIdDesc();
	}

	@Override
	public List<Contacts> findByIdOrderAsc() {
		
		return contactsRepository.findByIdOrderAsc();
	}

	//prueba
//	@Override
//	public List<Contacts> findByName(String name, Pageable Pageable) {
//		int initPage = 0;
//		Pageable page = PageRequest.of(initPage, 10); //size = 10
//		System.out.println("hola");
//		   System.out.println(contactsService.findByName(name, page));
//		   return contactsService.findByName(name, page);
//		
//	}

}
