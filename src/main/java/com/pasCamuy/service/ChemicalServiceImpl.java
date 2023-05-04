package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pasCamuy.model.Chemical;
import com.pasCamuy.repository.ChemicalRepository;

@Service
public class ChemicalServiceImpl implements IChemicalService {

	@Autowired
	ChemicalRepository chemicalRepository;
	
	@Override
	public List<Chemical> findAll() {
		return chemicalRepository.findAll();
	}

	@Override
	public void save(Chemical chemical) {
		chemicalRepository.save(chemical);
	}

	@Override
	public Chemical findById(Integer id) {
		return chemicalRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		chemicalRepository.deleteById(id);		
	}

	@Override
	public Optional<Chemical> findByIdList(Integer id) {
		return chemicalRepository.findById(id);
	}

	@Override
	public Page<Chemical> findAll(Pageable pageble) {
		return chemicalRepository.findAll(pageble); 
	}

	@Override
	public List<Chemical> findByOrderByDesc() {
		return chemicalRepository.findByIdOrderByIdDesc();
	}

	@Override
	public List<Chemical> findByOrderByDateDesc() {
		return chemicalRepository.findByDateOrderByDateDesc();
	}



}
