package com.fisa.workmanager.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fisa.workmanager.model.entity.Employee;
import com.fisa.workmanager.model.entity.PmCustomerEvaluation;
import com.fisa.workmanager.model.entity.PmCustomerEvaluation.EvaluationType;
import com.fisa.workmanager.model.entity.Project;
import com.fisa.workmanager.repository.AuthRepository;
import com.fisa.workmanager.repository.PmCustomerEvalRepository;
import com.fisa.workmanager.repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
public class EvaluationService {
	private PmCustomerEvalRepository pmCustomerEvalRepo;
	private AuthRepository authRepository;
	private ProjectRepository projectRepository;
	
	EvaluationService(PmCustomerEvalRepository pmCustomerEvalRepo, AuthRepository authRepository, ProjectRepository projectRepository) {
		this.pmCustomerEvalRepo = pmCustomerEvalRepo;
		this.authRepository = authRepository;
		this.projectRepository = projectRepository;
	}

	@Transactional
	public void createClientEval(List<String[]> readCSV, Long pid) {
		List<PmCustomerEvaluation> pmCusEvalList = new ArrayList();
		for (String[] arr: readCSV) {
			String ename = arr[0].split("\\(")[1].split("\\)")[0];
			System.out.println(ename);
			
			Optional<Project> resProj = projectRepository.findById(pid);
			if (! resProj.isPresent()) {
				throw new RuntimeException("존재하지 않는 프로젝트입니다.");
			}
			Project project = resProj.get();
			
			Optional<Employee> resEmp = authRepository.findByEname(ename);
			if (! resEmp.isPresent()) {
				throw new RuntimeException("존재하지 않는 사원입니다.");
			}
			Employee employee = resEmp.get();
			
			pmCusEvalList.add(new PmCustomerEvaluation().builder()
					.project(project) // pid로 검색
					.evaluatee(employee) // 사번으로 검색
					.score(Integer.parseInt(arr[1]))
					.comment(arr[2])
					.evalType(EvaluationType.CUSTOMER)
					.build());
		}
		pmCustomerEvalRepo.saveAll(pmCusEvalList);
	}
}
