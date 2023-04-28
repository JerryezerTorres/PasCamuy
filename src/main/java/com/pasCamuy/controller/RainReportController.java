package com.pasCamuy.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pasCamuy.model.RainReport;
import com.pasCamuy.model.SludgeReport;
import com.pasCamuy.service.IRainReportService;

@Controller
@RequestMapping("/views/reports/rain")
public class RainReportController {

	@Autowired
	private IRainReportService rainReportService;

	@GetMapping("/rainReport")
	public String rainReport(Model model) {

		List<RainReport> rainReportList = rainReportService.findAll();
		model.addAttribute("rainReportList", rainReportList);
		System.out.println("RainReportList " + rainReportList);

		return "/views/reports/rain/rainReport";
	}

	@GetMapping("createRainReport")
	public String rainReportCreate(Model model) {

		RainReport rainReport = new RainReport();
		model.addAttribute("titulo", "Registro de Pulgadas de Lluvia");
		model.addAttribute("rainReport", rainReport);

		return "/views/reports/rain/createRainReport";

	}

	@PostMapping("save")
	public String save(RainReport rainReport, Model model, BindingResult result, RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Error!!!!!!");
			model.addAttribute("rainReport", rainReport);
			System.out.println("error");
			return "/views/reports/rain/rainReport";
		}

		rainReportService.save(rainReport);

		return "redirect:/views/reports/rain/rainReport";

	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable ("id") Integer id, Model model, RedirectAttributes attribute) {
		RainReport rainReport = null;
		
		if(id>0) {
			rainReport = rainReportService.findById(id);
			
			if(rainReport == null) {
				attribute.addFlashAttribute("error", "ATENCION: El id de la prueba no existe.");
			return"redirect:/views/reports/rain/rainReport";
			}
		}else {
			attribute.addFlashAttribute("error", "ATENCION: Error con el id de la prueba.");
			System.out.println("2do");
			return "redirect:/views/reports/rain/rainReport";
		}
		
		model.addAttribute("titulo", "Editar Niveles de Cieno");
		model.addAttribute("rainReport", rainReport);
		System.out.println("3ero");
		return "/views/reports/rain/createRainReport";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable ("id") Integer id, Model model, RedirectAttributes attribute) {
		
		RainReport rainReport = null;
		
		if(id>0) {
			rainReport = rainReportService.findById(id);
			
			if(rainReport == null) {
				attribute.addFlashAttribute("error", "ATENCION: El id de la prueba no existe.");
			return"redirect:/views/reports/rain/rainReport";
			}
		}else {
			attribute.addFlashAttribute("error", "ATENCION: Error con el id de la prueba.");
			System.out.println("2do");
			return "redirect:/views/reports/rain/rainReport";
		}
		
		rainReportService.delete(id);
		System.out.println("3ero");
		return "redirect:/views/reports/rain/rainReport";
	}
	
	@GetMapping("/showDetails/{id}")
	public String showDetails (@PathVariable ("id") Integer id, Model model ) throws IOException  {
	
		Optional <RainReport> rainReport= rainReportService.findByIdList(id);
		model.addAttribute("rainReport", rainReport.get());
		System.out.println(rainReport.get());

		return "/views/reports/rain/showDetailsOfRain";
		
	}
	
}
