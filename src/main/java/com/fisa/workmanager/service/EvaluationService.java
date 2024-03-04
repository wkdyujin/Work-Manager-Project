package com.fisa.workmanager.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fisa.workmanager.dto.PeerEvalDto;
import com.fisa.workmanager.dto.PmCustomerEvalDto;
import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.model.entity.PmCustomerEvaluation;
import com.fisa.workmanager.model.entity.PmCustomerEvaluation.EvaluationType;
import com.fisa.workmanager.model.entity.Project;
import com.fisa.workmanager.repository.AuthRepository;
import com.fisa.workmanager.repository.PeerEvalRepository;
import com.fisa.workmanager.repository.PmCustomerEvalRepository;
import com.fisa.workmanager.repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
public class EvaluationService {
	private PmCustomerEvalRepository pmCustomerEvalRepo;
	private AuthRepository authRepository;
	private ProjectRepository projectRepository;
	private PeerEvalRepository peerEvalRepository;
	
	EvaluationService(PmCustomerEvalRepository pmCustomerEvalRepo, AuthRepository authRepository, ProjectRepository projectRepository, PeerEvalRepository peerEvalRepository) {
		this.pmCustomerEvalRepo = pmCustomerEvalRepo;
		this.authRepository = authRepository;
		this.projectRepository = projectRepository;
		this.peerEvalRepository = peerEvalRepository;
	}
	
	private Project getProject(Long pid) {
		Optional<Project> project = projectRepository.findById(pid);
		if (! project.isPresent()) {
			throw new RuntimeException("존재하지 않는 프로젝트입니다.");
		}
		return project.get();
	}
	
	private Employee getEmployee(String ename) {
		Optional<Employee> employee = authRepository.findByEname(ename);
		if (! employee.isPresent()) {
			throw new RuntimeException("존재하지 않는 사원입니다.");
		}
		return employee.get();
	}
	
	private Employee getEmployee(Long eid) {
		Optional<Employee> employee = authRepository.findById(eid);
		if (! employee.isPresent()) {
			throw new RuntimeException("존재하지 않는 사원입니다.");
		}
		return employee.get();
	}

	@Transactional
	public void createClientEval(List<String[]> readCSV, Long pid) {
		List<PmCustomerEvaluation> pmCusEvalList = new ArrayList();
		for (String[] arr: readCSV) {
			String ename = arr[0].split("\\(")[1].split("\\)")[0];
			
			Project project = getProject(pid);
			Employee employee = getEmployee(ename);
			
			pmCusEvalList.add(new PmCustomerEvaluation().builder()
					.project(project)
					.evaluatee(employee)
					.score(Integer.parseInt(arr[1]))
					.comment(arr[2])
					.evalType(EvaluationType.CUSTOMER)
					.build());
		}
		pmCustomerEvalRepo.saveAll(pmCusEvalList);
	}
	
	public void createPmEval(Long pid, Long eid, PmCustomerEvalDto dto) {
		Project project = getProject(pid);
		Employee employee = getEmployee(eid);
		
		dto.setProject(project);
		dto.setEmployee(employee);
		
		pmCustomerEvalRepo.save(dto.toEntity());
	}
	
	public void createPeerEval(Long pid, Long eid, Long evaluatorId, PeerEvalDto dto) {
		Project project = getProject(pid);
		Employee evaluatee = getEmployee(eid);
		Employee evaluator = getEmployee(evaluatorId);
		
		dto.setProject(project);
		dto.setEvaluatee(evaluatee);
		dto.setEvaluator(evaluator);
		
		peerEvalRepository.save(dto.toEntity());
	}
}
