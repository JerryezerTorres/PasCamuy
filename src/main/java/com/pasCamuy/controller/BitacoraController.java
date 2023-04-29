package com.pasCamuy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.pasCamuy.model.Bitacora;
import com.pasCamuy.model.OperatorAssistantName;
import com.pasCamuy.model.OperatorName;
import com.pasCamuy.model.WorkShift;
import com.pasCamuy.service.IBitacoraService;
import com.pasCamuy.service.IOperatorAssistantNameService;
import com.pasCamuy.service.IOperatorNameService;
import com.pasCamuy.service.IUserService;
import com.pasCamuy.service.IWorkShiftService;

@Controller
@RequestMapping("/views/reports")
public class BitacoraController {

	private final Logger logger = LoggerFactory.getLogger(BitacoraController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private IBitacoraService bitacoraService;

	@Autowired
	private IWorkShiftService workShiftService;
	
	@Autowired
	private IOperatorNameService operatorNameService;
	
	@Autowired
	private IOperatorAssistantNameService operatorAssistantNameService;
	

	@GetMapping("/bitacora")
	public String reportList(@RequestParam Map<String, Object> params, Model model) {

		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;

		PageRequest pageRequest = PageRequest.of(page, 5 ,Sort.by("id").descending()) ; // esto es anadido ,Sort.by("id").descending()
		Page<Bitacora> pageBitacora = bitacoraService.findAll(pageRequest);
		
		int totalPage = pageBitacora.getTotalPages();
		if (totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());

			model.addAttribute("pages", pages);
		}
		
		model.addAttribute("titulo", "Bitacora / PAS-Camuy");
		model.addAttribute("bitacora", pageBitacora.getContent());
		model.addAttribute("current", page + 1);
		model.addAttribute("next", page + 2);
		model.addAttribute("prev", page);
		model.addAttribute("last", totalPage);
		
		return "/views/reports/bitacora";

	}

	@GetMapping("/create")
	public String createRecord(Model model) {
		
		Bitacora bitacora = new Bitacora();
		List<WorkShift> workShift = workShiftService.findAll();
		List<OperatorName> operatorName = operatorNameService.findAll();
		List<OperatorAssistantName> operatorAssistantName = operatorAssistantNameService.findAll();

		model.addAttribute("titulo", "Bitacora de Pas-Cammuy");
		model.addAttribute("bitacora", bitacora);
		model.addAttribute("workShift", workShift);
		model.addAttribute("operatorName", operatorName);
		model.addAttribute("operatorAssistantName", operatorAssistantName);	

		return "/views/reports/createReport";

	}

	@PostMapping("save")
	public String save(Bitacora bitacora, Model model, BindingResult result, RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Bitacora");
			model.addAttribute("bitacora", bitacora);
			System.out.println("Hubo errores en el formlario");

			return "/views/reports/createRecord";
		}
		bitacoraService.save(bitacora);
		attribute.addFlashAttribute("success", "Registro guardado con exito");
		return "redirect:/views/reports/bitacora";

	}

	@GetMapping("/edit/{id}")
	public String editarBitacora(@PathVariable("id") Integer id, Model model, RedirectAttributes attribute) {

		List<WorkShift> workShift = workShiftService.findAll();
		List<OperatorName> operatorName = operatorNameService.findAll();
		List<OperatorAssistantName> operatorAssistantName = operatorAssistantNameService.findAll();
		
		Bitacora bitacora = null;

		if (id > 0) {
			bitacora = bitacoraService.findById(id);
			System.out.println(" esto es lo que contienen el objeto pruebaService" + bitacoraService);

			if (bitacora == null) {
				System.out.println("Error: El id de la prueba no exixte.");
				attribute.addFlashAttribute("error", "ATENCION: El id del registro no existe");
				return "redirect:/views/reports/bitacora";
			}
		} else {
			System.out.println("Error: Error con el id prueba");
			attribute.addFlashAttribute("error", "ATENCION: Error con el id del registro... ");
			return "redirect:/views/reports/bitacora";
		}

		model.addAttribute("titulo", "Editar Registro");
		model.addAttribute("bitacora", bitacora);
		model.addAttribute("workShift", workShift);
		model.addAttribute("operatorName", operatorName);
		model.addAttribute("operatorAssistantName", operatorAssistantName);

		return "views/reports/createReport";

	}

	@GetMapping("/delete/{id}")
	public String borrarBitacora(@PathVariable("id") Integer id, Model model, RedirectAttributes attribute) {

		Bitacora bitacora = null;

		if (id > 0) {
			bitacora = bitacoraService.findById(id);

			if (bitacora == null) {
				attribute.addFlashAttribute("error", "ATENCION: El id del registro no existe");
				return "redirect:/views/reports/bitacora";
			} else {

			}
		}

		bitacoraService.delete(id);
		attribute.addFlashAttribute("warning", "Registro eliminado exitosamente.");

		return "redirect:/views/reports/bitacora";

	}

}
