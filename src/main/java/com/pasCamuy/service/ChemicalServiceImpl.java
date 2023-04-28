package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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



}
