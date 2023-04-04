package com.pasCamuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/treatmentPlant")
public class TreatmentPlantInformationController {

	
	@GetMapping("/plantInformation")
	public String plantInformation() {
		return "views/treatmentPlant/plantInformation";
		
	}
	
	@GetMapping("/equipmentInformation")
	public String informacionDeEquipos() {
		return "/views/treatmentPlant/equipmentInformation";
		
	}
	
	@GetMapping("/parametersAllowed")
	public String parametrosPermitidos() {
		return "/views/treatmentPlant/parametersAllowed";
		
	}
	
	@GetMapping("/upcomingInspections")
	public String proximasVisitas() {
		return "/views/treatmentPlant/upcomingInspections";
		
	}
	
	@GetMapping ("/epa")
	public String epaVisit() {
		return "/views/treatmentPlant/visit/epa";
		
	}
	
	@GetMapping ("/cumplimiento")
	public String cimplimeintoVisit() {
		return "/views/treatmentPlant/visit/cumplimiento";
		
	}
	
	@GetMapping ("/jca")
	public String jcaVisit() {
		return "/views/treatmentPlant/visit/jca";
		
	}
}
