package com.fisa.workmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisa.workmanager.model.entity.PeerEvaluation;

@Repository
public interface PeerEvalRepository extends JpaRepository<PeerEvaluation, Long>{

}
