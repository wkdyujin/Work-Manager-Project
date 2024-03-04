package com.fisa.workmanager.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fisa.workmanager.service.EvaluationService;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	private EvaluationService evaluationService;
	
	public EvaluationController(EvaluationService evaluationService) {
		this.evaluationService = evaluationService;
	}
	
	@GetMapping("/client/form/{id}")
	public String createForm(@PathVariable Long id, Model model) {
		model.addAttribute("id", id);
		return "evaluation/clientEval";
	}
	
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
	
	@GetMapping("/internal/form/{id}")
	public String createInternalEvalFrom(@PathVariable Long id) {
		return "evaluation/internalEval";
	}
}
