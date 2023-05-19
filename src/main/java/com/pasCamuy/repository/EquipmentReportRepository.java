package com.pasCamuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.EquipmentReport;

@Repository
public interface EquipmentReportRepository extends JpaRepository<EquipmentReport, Integer> {

}
