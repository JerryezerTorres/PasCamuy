package com.pasCamuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasCamuy.model.OperatorAssistantName;

@Repository
public interface OperatorAssistantNameRepository extends JpaRepository<OperatorAssistantName, Integer> {

}
