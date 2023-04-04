package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasCamuy.model.WorkShift;
import com.pasCamuy.repository.WorkShiftRepository;

@Service
public class WorkShiftImpl implements IWorkShiftService {

	@Autowired
	private WorkShiftRepository workShiftRepository;

	@Override
	public Optional<WorkShift> findById(Integer id) {
		return workShiftRepository.findById(id);
	}

	@Override
	public List<WorkShift> findAll() {
		return workShiftRepository.findAll();
	}








	






}
