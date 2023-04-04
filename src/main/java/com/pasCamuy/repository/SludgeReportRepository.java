package com.pasCamuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.SludgeReport;

@Repository
public interface SludgeReportRepository extends JpaRepository<SludgeReport, Integer> {

}
