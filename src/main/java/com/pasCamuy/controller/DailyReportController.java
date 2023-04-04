package com.pasCamuy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/reports")
public class DailyReportController {
	
	private final Logger logger = LoggerFactory.getLogger(DailyReportController.class);
	
	@GetMapping("/dailyReport")
	public String dailyReport() {
		return"/views/reports/dailyReport";
	}

}
