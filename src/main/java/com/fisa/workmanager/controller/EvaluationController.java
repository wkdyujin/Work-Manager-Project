package com.fisa.workmanager.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fisa.workmanager.annotation.CheckLogin;
import com.fisa.workmanager.dto.AuthDto;
import com.fisa.workmanager.dto.EvaluationDto;
import com.fisa.workmanager.dto.PeerEvalDto;
import com.fisa.workmanager.dto.PmCustomerEvalDto;
import com.fisa.workmanager.dto.ProjEmpEvalScoreDto;
import com.fisa.workmanager.dto.ProjectDto;
import com.fisa.workmanager.dto.ProjectEmployeeDto;
import com.fisa.workmanager.model.entity.PmCustomerEvaluation.EvaluationType;
import com.fisa.workmanager.service.EvaluationService;
import com.fisa.workmanager.service.ProjectService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	private EvaluationService evaluationService;
	private ProjectService projectService;
	
	private Long getEmpId(HttpSession session) {
		AuthDto dto = (AuthDto) session.getAttribute("session");
		return dto.getId();
	}
	
	public EvaluationController(EvaluationService evaluationService, ProjectService projectService) {
		this.evaluationService = evaluationService;
		this.projectService = projectService;
	}

	@CheckLogin
	@GetMapping("/client/form/{id}")
	public String createForm(@PathVariable Long id, Model model) {
		model.addAttribute("id", id);
		return "evaluation/clientEval";
	}
	
	@CheckLogin
	@PostMapping("/client/csv/{id}")
	public String createClientEval(@PathVariable Long id, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "파일을 선택해주세요.");
            return "redirect:/evaluation/client/form/" + id;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            reader.readLine(); // 필드명 무시
        	String line;
            List<String[]> readCSV = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                readCSV.add(values);
            }
            evaluationService.createClientEval(readCSV, id);
        } catch (Exception e) {
        	System.out.println(e.toString());
            redirectAttributes.addFlashAttribute("message", "파일 처리 중 오류가 발생했습니다.");
            return "redirect:/evaluation/client/form/" + id;
        }

        redirectAttributes.addFlashAttribute("message", "파일이 성공적으로 처리되었습니다.");
        return "redirect:/project/detail/" + id;
    }
	
	@CheckLogin
	@GetMapping("/internal/form/{pid}")
	public String createInternalEvalFrom(@PathVariable Long pid, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
		List<ProjectEmployeeDto> peDtoList = projectService.getProjectEmployee(pid, getEmpId(session));
		
		// 현재 사용자가 peDtoList에 포함되어 있는지 확인
		Long empId = getEmpId(session);
		try {
			projectService.getProjEmp(pid, empId);
			model.addAttribute("peDtoList", peDtoList);
			return "evaluation/internalEval";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMsg", "권한이 없습니다.");
            return "redirect:/project/detail/" + pid;
		}
	}

	@CheckLogin
	@PostMapping("/internal/{pid}/{eid}")
	public String registEvaluation(@PathVariable Long pid, @PathVariable Long eid, @ModelAttribute EvaluationDto dto, HttpSession session) {
		AuthDto authDto = (AuthDto) session.getAttribute("session");
		if (authDto.getRole().equals("MANAGER")) {
			registPmEval(pid, eid, dto);
		} else {
			registPeerEval(pid, eid, authDto.getId(), dto);
		}
		return "redirect:/evaluation/internal/form/" + pid;
	}

	private void registPmEval(Long pid, Long eid, EvaluationDto dto) {
		PmCustomerEvalDto pmCusEvalDto = new PmCustomerEvalDto().builder()
											.score(dto.getScore())
											.comment(dto.getComment())
											.evalType(EvaluationType.PM)
											.build();
		evaluationService.createPmEval(pid, eid, pmCusEvalDto);
	}

	private void registPeerEval(Long pid, Long eid, Long evaluatorId, EvaluationDto dto) {
		PeerEvalDto peerEvalDto = new PeerEvalDto().builder()
    			.score(dto.getScore())
    			.comment(dto.getComment())
    			.build();
		evaluationService.createPeerEval(pid, eid, evaluatorId, peerEvalDto);
		return;
	}
	
	@CheckLogin
	@GetMapping("/project/{pid}")
	public String confirmProjectEval(@PathVariable Long pid, Model model) {
		List<ProjEmpEvalScoreDto> evalDto = evaluationService.getProjUserEvalScore(pid);
		model.addAttribute("empEvalList", evalDto);
		ProjectDto projectDto = projectService.getProject(pid);
		model.addAttribute("project", projectDto);
		return "evaluation/project";
	}
}
