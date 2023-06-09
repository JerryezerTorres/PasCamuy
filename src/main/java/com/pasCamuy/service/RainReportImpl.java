package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pasCamuy.model.RainReport;
import com.pasCamuy.repository.RainReportRepository;

@Service
public class RainReportImpl implements IRainReportService {

	@Autowired
	private RainReportRepository rainReportRepository;
	
	@Override
	public List<RainReport> findAll() {
		return rainReportRepository.findAll();
	}

	@Override
	public void save(RainReport rainReport) {
		rainReportRepository.save(rainReport);		
	}

	@Override
	public RainReport findById(Integer id) {
		return rainReportRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		rainReportRepository.deleteById(id);		
	}

	@Override
	public Optional<RainReport> findByIdList(Integer id) {
		return rainReportRepository.findById(id);
	}

	@Override
	public Page<RainReport> findAll(Pageable pageble) {
		return rainReportRepository.findAll(pageble);
	}

	@Override
	public List<RainReport> findByOrderByDesc() {
		return rainReportRepository.findByIdOrderByIdDesc();
	}

	@Override
	public List<RainReport> findByOrderByDateDesc() {
		return rainReportRepository.findByDateOrderByDateDesc();
	}

}
