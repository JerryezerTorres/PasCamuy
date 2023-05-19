package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pasCamuy.model.EquipmentReport;
import com.pasCamuy.repository.EquipmentReportRepository;

@Service
public class EquipmentReportImpl implements IEquipmentReportService  {

	@Autowired
	private EquipmentReportRepository equipmentReportRepository;

	@Override
	public List<EquipmentReport> findAll() {
		return equipmentReportRepository.findAll();
	}

	@Override
	public void save(EquipmentReport equipmentReport) {
		equipmentReportRepository.save(equipmentReport);
		
	}

	@Override
	public EquipmentReport findById(Integer id) {
		return equipmentReportRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		equipmentReportRepository.deleteById(id);
		
	}

	@Override
	public Page<EquipmentReport> findAll(Pageable pageable) {
		return equipmentReportRepository.findAll(pageable);
	}

	@Override
	public Optional<EquipmentReport> findByIdList(Integer id) {
		return equipmentReportRepository.findById(id);
	}
	


}
