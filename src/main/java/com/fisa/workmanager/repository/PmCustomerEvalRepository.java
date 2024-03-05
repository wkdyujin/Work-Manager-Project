package com.fisa.workmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fisa.workmanager.model.entity.PmCustomerEvaluation;

@Repository
public interface PmCustomerEvalRepository extends JpaRepository<PmCustomerEvaluation, Long>{
	
	 @Query("SELECT pce FROM PmCustomerEvaluation pce WHERE pce.project.id = :pid AND pce.evaluatee.id = :eid")
	 List<PmCustomerEvaluation> findAllByPidAndEid(@Param("pid") Long pid, @Param("eid") Long eid);
}
