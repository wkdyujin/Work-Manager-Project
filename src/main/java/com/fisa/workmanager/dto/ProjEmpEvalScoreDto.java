package com.fisa.workmanager.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 프로젝트 별 사원의 평가 점수 - PM, 발주처, 동료(평균)
// ProjectEmployee x Employee x Evaluation(PmCustomer/Peer)

@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString
@Getter @Setter
public class ProjEmpEvalScoreDto {
	private Long eid;
	private String ename;
	private String name;
	private Double pmScore;
	private Double peerScore;
	private Double clientScore;
}
