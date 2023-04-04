package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasCamuy.model.OperatorName;
import com.pasCamuy.repository.OperatorNameRepository;

@Service
public class OperatorNameImpl implements IOperatorNameService {

	@Autowired
	private OperatorNameRepository operatorNameRepository;
	
	@Override
	public Optional<OperatorName> findById(Integer id) {
		return operatorNameRepository.findById(id);
	}

	@Override
	public List<OperatorName> findAll() {
		return operatorNameRepository.findAll();
	}

}
