package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasCamuy.model.OperatorAssistantName;
import com.pasCamuy.repository.OperatorAssistantNameRepository;

@Service
public class OperatorAssistantNameServiceImpl implements IOperatorAssistantNameService {
	
	@Autowired
	OperatorAssistantNameRepository operatorAssistantNameRepository;
	
	@Override
	public Optional<OperatorAssistantName> findById(Integer id) {
		return operatorAssistantNameRepository.findById(id);
	}

	@Override
	public List<OperatorAssistantName> findAll() {
		return operatorAssistantNameRepository.findAll();
	}
}