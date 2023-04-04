package com.pasCamuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.OperatorName;

@Repository
public interface OperatorNameRepository extends JpaRepository<OperatorName, Integer> {

}
