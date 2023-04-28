package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasCamuy.model.SludgeReport;
import com.pasCamuy.repository.SludgeReportRepository;

@Service 
public class SludgeReportImpl implements ISludgeReportService {

	
	@Autowired
	private SludgeReportRepository sludgeReportRepository;
	
	@Override
	public List<SludgeReport> findAll() {
		return sludgeReportRepository.findAll();
	}

	@Override
	public void save(SludgeReport sludgeReport) {
		sludgeReportRepository.save(sludgeReport);		
	}

	@Override
	public SludgeReport findById(Integer id) {
		return sludgeReportRepository.findById(id).orElse(null);
	}
	
	@Override
	public void delete(Integer id) {
		sludgeReportRepository.deleteById(id);
	}

	@Override
	public Optional<SludgeReport> findByIdList(Integer id) {
		return sludgeReportRepository.findById(id);
	}

}
