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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pasCamuy.model.Chemical;
import com.pasCamuy.model.Contacts;
import com.pasCamuy.model.EquipmentReport;
import com.pasCamuy.model.User;
import com.pasCamuy.service.IEquipmentReportService;
import com.pasCamuy.service.UploadFileService;

@Controller
@RequestMapping("/views/reports/equipment")
public class InformationOfAllEquipmentController {
	
	@Autowired
	private IEquipmentReportService equipmetReportService;
	
	@Autowired
	private UploadFileService upload;
	
	
	@GetMapping("/equipmentReport")
	public String equipmentReport(Model model) {
		
		List<EquipmentReport> equipmentReportList = equipmetReportService.findAll();
		model.addAttribute("titulo", "Reporte de Equipos");
		model.addAttribute("equipmentReport", equipmentReportList);
		
		return "/views/reports/equipment/equipmentReport";
		
	}
	
	@GetMapping("/create")
	public String createEquipmentReport(Model model) {
		
		EquipmentReport equipmentReport = new EquipmentReport();
		model.addAttribute("titulo", "Registrar Nuevo Equipo");
		model.addAttribute("equipmentReport", equipmentReport);
		
		return "/views/reports/equipment/createEquipmentReport" ;
		
		
		
	}
	
	@PostMapping("/save")
	public String save(EquipmentReport equipmentReport,
			BindingResult result, Model model, RedirectAttributes attribute) throws IOException {
		
		if(result.hasErrors()) {
			model.addAttribute("equipmentReport", equipmentReport);
			return"/views/reports/equipment/createEquipmentReport";
		}
			
		equipmetReportService.save(equipmentReport);
		attribute.addFlashAttribute("success" , "Equipo guardado con exito");

		return "redirect:/views/reports/equipment/equipmentReport";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editarContacto(@PathVariable ("id") Integer id,
			RedirectAttributes attribute, Model model) {
			
		EquipmentReport equipmentReport = null;
		
		if(id>0) {
			equipmentReport=equipmetReportService.findById(id);
		
			if(equipmentReport==null) {
				attribute.addFlashAttribute("error", "ATENCION: El id del equipo no existe");
				return"redirect:/views/reports/equipment/equipmentReport";
			}
		}else {
			attribute.addFlashAttribute("error", "ATENCION: Hubo  problemas con el id del equipo");
			return"redirect:/views/reports/equipment/equipmentReport";
		}
		
		model.addAttribute("equipmentReport", equipmentReport);
		
		return "/views/reports/equipment/createEquipmentReport";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes attribute, Model model) {
		
		EquipmentReport equipmentReport = null;
		
		if(id>0) {
			equipmentReport = equipmetReportService.findById(id);
			if(equipmentReport == null) {
				attribute.addFlashAttribute("error", "ATENCION: El id de la prueba no existe.");
				return"redirect:/views/reports/equipment/equipmentReport";
		}
	}else {
			attribute.addFlashAttribute("error", "ATENCION: El id de la prueba no existe.");
			return"redirect:/views/reports/equipment/equipmentReport";
		}
		equipmetReportService.delete(id);
		return "redirect:/views/reports/equipment/equipmentReport" ;
	}
	
	@GetMapping("/showDetails/{id}")
	public String showDetails (@PathVariable ("id") Integer id, Model model ) throws IOException  {
	
		Optional <EquipmentReport> equipmentReport = equipmetReportService.findByIdList(id);
		model.addAttribute("equipmentReport", equipmentReport.get());
		System.out.println(equipmentReport);

		return "/views/reports/equipment/showDetailsOfEquipment";
		
	}
	
	
	

}







