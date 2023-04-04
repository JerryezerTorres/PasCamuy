package com.pasCamuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/reports")
public class ChemicalReportController {
	
	
	@GetMapping("/chemicalReport")
	public String chemicalRecor() {
		return"/views/reports/chemicalReport";
	}

}
