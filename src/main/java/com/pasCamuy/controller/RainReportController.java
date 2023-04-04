package com.pasCamuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/reports")
public class RainReportController {

	
	@GetMapping("/rainReport")
	public String rainRecor() {
		return"/views/reports/rainReport";
	}
	

}
