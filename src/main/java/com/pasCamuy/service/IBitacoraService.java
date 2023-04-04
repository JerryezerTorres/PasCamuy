package com.pasCamuy.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pasCamuy.model.Bitacora;

public interface IBitacoraService {
	public void save(Bitacora bitacora);
	public Bitacora findById(Integer id);
	public void delete(Integer id);
	public List<Bitacora> findAll();
	
	
//	public Date date();
	
	public Page<Bitacora> findAll(Pageable pageable);
	
	

}
