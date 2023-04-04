package com.pasCamuy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.WorkShift;

@Repository
public interface WorkShiftRepository extends JpaRepository<WorkShift, Integer> {
	
}
