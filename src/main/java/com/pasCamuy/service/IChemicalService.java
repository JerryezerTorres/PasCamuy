package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pasCamuy.model.Chemical;

public interface IChemicalService {
	
	public List<Chemical> findAll();
	public void save(Chemical chemical);
	public Chemical findById(Integer id);
	public void delete(Integer id);
	public Optional<Chemical> findByIdList(Integer id);

	public Page <Chemical> findAll(Pageable pageble);
	public List<Chemical> findByOrderByDesc();
	public List<Chemical> findByOrderByDateDesc();
}
