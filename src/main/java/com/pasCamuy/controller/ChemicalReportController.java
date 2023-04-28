package com.pasCamuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pasCamuy.model.Chemical;
import com.pasCamuy.service.IChemicalService;

@Controller
@RequestMapping("/views/reports/chemical")
public class ChemicalReportController {
	
	@Autowired
	private IChemicalService chemicalService;
	
	@GetMapping("/chemicalReport")
	public String chemicalRecor(Model model) {
		List<Chemical> chemicalList = chemicalService.findAll();
		model.addAttribute("chemicalList", chemicalList);
		System.out.println(chemicalList);
		
		return"/views/reports/chemical/chemicalReport";
	}
	
	@GetMapping("/createChemicalReport")
	public String createChemicalReport(Model model) {
		
		Chemical chemical = new Chemical();
		
		model.addAttribute("titulo", "Informe de Químicos");
		model.addAttribute("chemical", chemical);
		
		return "/views/reports/chemical/createChemicalReport";
	
	}
	
	@PostMapping("/save")
	public String save(Chemical chemical, Model model, BindingResult result, RedirectAttributes attribute) {
		
		if(result.hasErrors()) {
			model.addAttribute("chemical", chemical);
			return"/views/reports/chemical/chemicalReport";
		}
		chemicalService.save(chemical);
		attribute.addFlashAttribute("success", "Registro guardado con exito");

		
		return "redirect:/views/reports/chemical/chemicalReport";
		
	}
	
	

}
