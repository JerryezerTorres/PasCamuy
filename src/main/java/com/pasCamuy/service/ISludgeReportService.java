package com.pasCamuy.service;

import java.util.List;

import com.pasCamuy.model.SludgeReport;

public interface ISludgeReportService {
	
	public List <SludgeReport> findAll();
	public void save(SludgeReport sludgeReport);
	public SludgeReport findById (Integer id);
	public void delete (Integer id);

	
}
