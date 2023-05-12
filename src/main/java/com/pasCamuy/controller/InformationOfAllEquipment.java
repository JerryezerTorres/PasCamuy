package com.pasCamuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/reports/equipment")
public class InformationOfAllEquipment {
	
	@GetMapping("/equipmentReport")
	public String equipmentReport(Model model) {
		model.addAttribute("titulo", "Reporte de Equipos");
		
		return "/views/reports/equipment/equipmentReport";
		
	}
	
	

}
