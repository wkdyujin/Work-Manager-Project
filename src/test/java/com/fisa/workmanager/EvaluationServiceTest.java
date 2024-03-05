package com.fisa.workmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fisa.workmanager.dto.PmCustomerEvalDto;
import com.fisa.workmanager.model.entity.PmCustomerEvaluation.EvaluationType;
import com.fisa.workmanager.service.EvaluationService;

@SpringBootTest
public class EvaluationServiceTest {

	@Autowired
	private EvaluationService evaluationService;
	
	@Test
	void PM평가등록() {
		// given
		Long pid = 1L;
		Long eid = 4L;
		new PmCustomerEvalDto();
		PmCustomerEvalDto dto = PmCustomerEvalDto.builder()
				.score(5)
				.comment("우수")
				.evalType(EvaluationType.PM)
				.build();
		
		// when
		evaluationService.createPmEval(pid, eid, dto);
		
		// then
		
	}
	
	@Test
	void 평가점수조회() {
		evaluationService.getProjUserEvalScore(1L);
	}
}
