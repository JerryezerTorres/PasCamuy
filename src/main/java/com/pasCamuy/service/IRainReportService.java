package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import com.pasCamuy.model.RainReport;

public interface IRainReportService {
	
	public List<RainReport> findAll();
	public void save(RainReport rainReport);
	public RainReport findById(Integer id);
	public void delete(Integer id);
	public Optional <RainReport> findByIdList(Integer id);
	

}
