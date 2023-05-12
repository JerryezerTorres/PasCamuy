package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.pasCamuy.model.RainReport;

public interface IRainReportService {
	
	public List<RainReport> findAll();
	public void save(RainReport rainReport);
	public RainReport findById(Integer id);
	public void delete(Integer id);
	public Optional <RainReport> findByIdList(Integer id);
	
	
	public Page <RainReport> findAll(Pageable pageble);
	public List<RainReport> findByOrderByDesc();
	public List<RainReport> findByOrderByDateDesc();
	

}
