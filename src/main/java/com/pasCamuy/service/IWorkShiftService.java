package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import com.pasCamuy.model.WorkShift;

public interface IWorkShiftService {
	
	public Optional<WorkShift>findById(Integer id);
	public List<WorkShift> findAll();


}
