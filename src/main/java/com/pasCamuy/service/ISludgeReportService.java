package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pasCamuy.model.RainReport;
import com.pasCamuy.model.SludgeReport;

public interface ISludgeReportService {
	
	public List <SludgeReport> findAll();
	public void save(SludgeReport sludgeReport);
	public SludgeReport findById (Integer id);
	public void delete (Integer id);
	public Optional<SludgeReport> findByIdList(Integer id);
	
	public Page <SludgeReport> findAll(Pageable pageble);
	public List<SludgeReport> findByOrderByDesc();
	public List<SludgeReport> findByOrderByDateDesc();

	
}
