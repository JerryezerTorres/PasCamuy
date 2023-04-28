package com.pasCamuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.RainReport;

@Repository
public interface RainReportRepository extends JpaRepository<RainReport, Integer > {

}
