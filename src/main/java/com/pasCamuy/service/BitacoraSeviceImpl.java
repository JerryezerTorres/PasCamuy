package com.pasCamuy.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pasCamuy.model.Bitacora;
import com.pasCamuy.repository.BitacoraRepository;

@Service
public class BitacoraSeviceImpl implements IBitacoraService {

	@Autowired
	private BitacoraRepository bitacoraRepository;
	
	public void save(Bitacora bitacora) {
		bitacoraRepository.save(bitacora);
		
	}

	public Bitacora findById(Integer id) {
		return bitacoraRepository.findById(id).orElse(null);
	}

	public void delete(Integer id) {
		bitacoraRepository.deleteById(id);
		
	}

	public Page<Bitacora> findAll(Pageable pageable) {
		return bitacoraRepository.findAll(pageable);
	}

	public List<Bitacora> findAll() {
		return (List<Bitacora>) bitacoraRepository.findAll();
	}


	
	


}
