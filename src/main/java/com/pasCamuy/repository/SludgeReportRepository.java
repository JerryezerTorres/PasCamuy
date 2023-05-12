package com.pasCamuy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.Chemical;
import com.pasCamuy.model.SludgeReport;

@Repository
public interface SludgeReportRepository extends JpaRepository<SludgeReport, Integer> {

	 @Query(value = "SELECT * FROM sludge_report WHERE id order by id desc", nativeQuery = true)
	 List<SludgeReport> findByIdOrderByIdDesc();
	
	 
	 @Query(value = "SELECT * FROM sludge_report WHERE date order by date desc", nativeQuery = true)
	 List<SludgeReport> findByDateOrderByDateDesc();
	
}
