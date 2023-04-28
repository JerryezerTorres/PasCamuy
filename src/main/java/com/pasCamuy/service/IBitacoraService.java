package com.pasCamuy.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pasCamuy.model.Bitacora;

public interface IBitacoraService {
	
	public void save(Bitacora bitacora);
	public Bitacora findById(Integer id);
	public void delete(Integer id);
	public List<Bitacora> findAll();
	public Page<Bitacora> findAll(Pageable pageable);
	public List<Bitacora> findByIdOrderByIdDesc();
	public List<Bitacora> findByDateOrderByDateDesc();
	
	

}
