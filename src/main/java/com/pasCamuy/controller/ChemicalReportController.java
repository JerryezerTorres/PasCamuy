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
import com.pasCamuy.service.IChemicalService;

@Controller
@RequestMapping("/views/reports/chemical")
public class ChemicalReportController {
	
	@Autowired
	private IChemicalService chemicalService;
	
	@GetMapping("/chemicalReport")
	public String chemicalReport(@RequestParam Map<String, Object> params,  Model model) {
		
		int page = params.get("page") !=null? (Integer.valueOf(params.get("page").toString()) -1) : 0;
		
		PageRequest pageRequest = PageRequest.of(page, 1, Sort.by("id").descending());
		Page<Chemical> pageChemicalReports = chemicalService.findAll(pageRequest);
		
		int totalPage = pageChemicalReports.getTotalPages();
		if(totalPage >0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		
		model.addAttribute("titulo", "Bitacora / PAS-Camuy");
		model.addAttribute("chemicalList", pageChemicalReports.getContent());
		model.addAttribute("current", page + 1);
		model.addAttribute("next", page + 2);
		model.addAttribute("prev", page);
		model.addAttribute("last", totalPage);
		
		System.out.println(pageChemicalReports.getContent());
		
		return"/views/reports/chemical/chemicalReport";
	}
	
	
	
	
	
	@GetMapping("/createChemicalReport")
	public String createChemicalReport(Model model) {
		
		Chemical chemical = new Chemical();
		
		model.addAttribute("titulo", "Informe de Químicos");
		model.addAttribute("chemicalList", chemical);
		
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
	
	@GetMapping("/edit/{id}")
	public String editChemicalReport(@PathVariable("id") Integer id, Model model, RedirectAttributes attribute) {

		
		Chemical chemical = null;

		if (id > 0) {
			chemical = chemicalService.findById(id);
			System.out.println(" esto es lo que contienen el objeto pruebaService" + chemicalService);

			if (chemical == null) {
				System.out.println("Error: El id de la prueba no exixte.");
				attribute.addFlashAttribute("error", "ATENCION: El id del registro no existe");
				return "redirect:/views/reports/chemical/chemicalReport";
			}
		} else {
			System.out.println("Error: Error con el id prueba");
			attribute.addFlashAttribute("error", "ATENCION: Error con el id del registro... ");
			return "redirect:/views/reports/chemical/chemicalReport";
		}

		model.addAttribute("titulo", "Editar Registro");
		model.addAttribute("chemicalList", chemical);

		return "/views/reports/chemical/createChemicalReport";

	}
	
	@GetMapping("/delete/{id}")
	public String borrarBitacora(@PathVariable("id") Integer id, Model model, RedirectAttributes attribute) {

		Chemical chemical = null;
		if (id > 0) {
			chemical = chemicalService.findById(id);
			if (chemical == null) {
				attribute.addFlashAttribute("error", "ATENCION: El id del registro no existe");
				return "redirect:/views/reports/chemical/chemicalReport";
			} else {

			}
		}
		chemicalService.delete(id);
		attribute.addFlashAttribute("warning", "Registro eliminado exitosamente.");

		return "redirect:/views/reports/chemical/chemicalReport";

	}
	
	
	@GetMapping("/showDetails/{id}")
	public String showDetails (@PathVariable ("id") Integer id, Model model ) throws IOException  {
	
		Optional <Chemical> chemicalReport= chemicalService.findByIdList(id);
		model.addAttribute("chemicalList", chemicalReport.get());
		System.out.println(chemicalReport.get());

		return "/views/reports/chemical/showDetailsOfChemical";
		
	}
}
