package com.fisa.workmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisa.workmanager.model.entity.PmCustomerEvaluation;

@Repository
public interface PmCustomerEvalRepository extends JpaRepository<PmCustomerEvaluation, Long>{

}
