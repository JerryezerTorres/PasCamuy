package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import com.pasCamuy.model.OperatorName;

public interface IOperatorNameService {

	public Optional<OperatorName>findById(Integer id);
	public List<OperatorName> findAll();
}
