package com.pasCamuy.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pasCamuy.model.Chemical;
import com.pasCamuy.model.SludgeReport;
import com.pasCamuy.service.ISludgeReportService;

@Controller
@RequestMapping("/views/reports/sludge")
public class SludgeReportController {
	
	@Autowired
	private ISludgeReportService sludgeReportService;
	
	@GetMapping("/sludgeReport")
	public String sludgeReport(@RequestParam Map<String, Object> params, Model model) {
		
		int page = params.get("page") !=null? (Integer.valueOf(params.get("page").toString()) -1) : 0;
		
		PageRequest pageRequest = PageRequest.of(page, 5, Sort.by("id").descending());
		Page<SludgeReport> pageSludgeReports = sludgeReportService.findAll(pageRequest);
		

		int totalPage = pageSludgeReports.getTotalPages();
		if(totalPage >0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		
		model.addAttribute("titulo", "Bitacora / PAS-Camuy");
		model.addAttribute("sludgeListReport", pageSludgeReports.getContent());
		model.addAttribute("current", page + 1);
		model.addAttribute("next", page + 2);
		model.addAttribute("prev", page);
		model.addAttribute("last", totalPage);
		
		System.out.println(pageSludgeReports.getContent());
		
//		List<SludgeReport> sludgeListReport = sludgeReportService.findAll();
//		model.addAttribute("sludgeListReport", sludgeListReport);
		
		return"/views/reports/sludge/sludgeReport";
	}
	
	@GetMapping("/createSludgeReport")
	public String createRecord(Model model) {
		
		SludgeReport sludgeReport = new SludgeReport();

		model.addAttribute("titulo", "Informe de Niveles de Cieno");
		model.addAttribute("sludgeReport", sludgeReport);

		
		return "/views/reports/sludge/createSludgeReport";
		
	}
	
	@PostMapping("/save")
	public String save(SludgeReport sludgeReport, Model model, BindingResult result, RedirectAttributes attribute ) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Bitacora!!!!!!");
			model.addAttribute("sludgeReport", sludgeReport);
			
			
			System.out.println("Hubo errores en el formlario");

			return "/views/reports/sludge/sludgeReport";
		}
		sludgeReportService.save(sludgeReport);
		attribute.addFlashAttribute("success", "Registro guardado con exito");
		
		
		
		return "redirect:/views/reports/sludge/sludgeReport";
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id" )Integer id, Model model, RedirectAttributes attribute) {
		
		SludgeReport sludgeReport = null;
		
		if(id>0) {
			sludgeReport = sludgeReportService.findById(id);
			
			if(sludgeReport==null) {
				attribute.addFlashAttribute("error", "ATENCION: El id de la prueba no existe.");
				System.out.println("1er");
				return"redirect:/views/reports/sludge/sludgeReport";
			}
		}else {
			attribute.addFlashAttribute("error", "ATENCION: Error con el id de la prueba.");
			System.out.println("2do");
			return "redirect:/views/reports/sludge/sludgeReport";
		}
		model.addAttribute("titulo", "Editar Niveles de Cieno");
		model.addAttribute("sludgeReport", sludgeReport);
		System.out.println("3ero");
		return "/views/reports/sludge/createSludgeReport";
			
		
	}
	
	@GetMapping("/delete/{id}")
	public String borrarContacto(@PathVariable ("id") Integer id, Model model, RedirectAttributes attribute) {
		
		SludgeReport sludgeReport = null;
		
		if(id>0) {
			sludgeReport = sludgeReportService.findById(id);
			if(sludgeReport == null) {
				attribute.addFlashAttribute("arror", "ATENCION: El id del contacto no existe" );
				return "redirect:/views/reports/sludge/sludgeReport";
			}
		
		}else {
			attribute.addFlashAttribute("error", "ATENCION: Error con el id del contacto" );
			return "redirect:/views/reports/sludge/sludgeReport";
		}
		
		sludgeReportService.delete(id);
		attribute.addFlashAttribute("warning", "Contacto eliminado exitosamente");
		return "redirect:/views/reports/sludge/sludgeReport";
		
	}
	
	@GetMapping("/showDetails/{id}")
	public String showDetails (@PathVariable ("id") Integer id, Model model ) throws IOException  {
	
		Optional <SludgeReport> sludgeReport= sludgeReportService.findByIdList(id);
		model.addAttribute("sludgeReport", sludgeReport.get());
		System.out.println(sludgeReport.get());

		return "/views/reports/sludge/showDetailsOfSludge";
		
	}

}
