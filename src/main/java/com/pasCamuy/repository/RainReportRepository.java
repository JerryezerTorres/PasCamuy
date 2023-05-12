package com.pasCamuy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.RainReport;

@Repository
public interface RainReportRepository extends JpaRepository<RainReport, Integer > {
	
	 @Query(value = "SELECT * FROM rain_report WHERE id order by id desc", nativeQuery = true)
	 List<RainReport> findByIdOrderByIdDesc();
	
	 
	 @Query(value = "SELECT * FROM rain_report WHERE date order by date desc", nativeQuery = true)
	 List<RainReport> findByDateOrderByDateDesc();
	
}
