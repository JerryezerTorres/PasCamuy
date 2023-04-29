package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import com.pasCamuy.model.OperatorAssistantName;

public interface IOperatorAssistantNameService {
	
	public Optional<OperatorAssistantName>findById(Integer id);
	public List<OperatorAssistantName> findAll();

}
