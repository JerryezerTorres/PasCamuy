package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import com.pasCamuy.model.Chemical;

public interface IChemicalService {
	
	public List<Chemical> findAll();
	public void save(Chemical chemical);
	public Chemical findById(Integer id);
	public void delete(Integer id);
	public Optional<Chemical> findByIdList(Integer id);

}
