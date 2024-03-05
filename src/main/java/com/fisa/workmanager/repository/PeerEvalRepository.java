package com.fisa.workmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fisa.workmanager.dto.ProjEmpEvalScoreDto;
import com.fisa.workmanager.model.entity.PeerEvaluation;

@Repository
public interface PeerEvalRepository extends JpaRepository<PeerEvaluation, Long>{
//	@Query("SELECT peval.evaluatee.id, peval.evaluatee.ename, ?, peval.ecore, ?, ?"
//			+ "FROM PeerEvaluation peval +"
//			+ "WHERE peval.project.id = :pid")
//	List<ProjEmpEvalScoreDto> findAllScoreById(@Param("pid") Long pid);
	
	@Query("SELECT new com.fisa.workmanager.dto.ProjEmpEvalScoreDto(peval.evaluatee.id, peval.evaluatee.ename, peval.evaluatee.name, null, AVG(peval.score), null) " +
	       "FROM PeerEvaluation peval " +
	       "WHERE peval.project.id = :pid " +
	       "GROUP BY peval.evaluatee.id")
	List<ProjEmpEvalScoreDto> findAllScoresByProjectId(@Param("pid") Long pid);
}
