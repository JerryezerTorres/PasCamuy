package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pasCamuy.model.EquipmentReport;

public interface IEquipmentReportService {
	
	public List<EquipmentReport> findAll();
	public void save(EquipmentReport equipmentReport);
	public EquipmentReport findById(Integer id);
	public void delete(Integer id);
	public Optional <EquipmentReport> findByIdList(Integer id);
	
	public Page<EquipmentReport> findAll(Pageable pageable);

}
