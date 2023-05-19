package com.pasCamuy.controller;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.jtorres.model.entity.Contacto;
import com.pasCamuy.model.Contacts;
import com.pasCamuy.service.IContactsService;

@Controller
@RequestMapping("/views/contactList")
public class ContactController {
	
	
	@Autowired
	IContactsService contactsService;
	
//	@GetMapping("allContacts")
	@GetMapping("contacts")
	public String contactList(Model model) {
		
		//List<Contacts> contactList = contactsService.findAll();
		List<Contacts> contactList = contactsService.findByIdOrderAsc();
		//List<Contacts> contactList = contactsService.findByIdOrderByIdDesc();
		model.addAttribute("contacts", contactList);
		
		System.out.println(contactList);
		
		return "/views/contactList/contacts";
		
	}
	
	@GetMapping("/create")
	public String guardarNuevoContacto(Model model) {
		
		Contacts contacts = new Contacts();
		model.addAttribute("contacts",  contacts);
				
		return"/views/contactList/create";
	}

	
	@PostMapping("/save")
	public String save( /*@ModelAttribute*/ Contacts contacts, BindingResult result,
			Model model, RedirectAttributes attribute) {
		
		if(result.hasErrors()) {
			model.addAttribute("contacts", contacts);
			System.out.println("Hubo errores en el formlario");

			return "/views/contactsList/create";
		}
		contactsService.save(contacts);
		System.out.println("Usuario Guardado con Exito");
		attribute.addFlashAttribute("success" , "Contacto guardado con exito");
		
		return"redirect:/views/contactList/contacts";				
		
	}
	
	@GetMapping("/edit/{id}")
	public String editarContacto(@PathVariable ("id") Integer id,
			RedirectAttributes attribute, Model model) {
			
		Contacts contacts = null;
		
		if(id>0) {
			contacts=contactsService.findById(id);
		
			if(contacts==null) {
				attribute.addFlashAttribute("error", "ATENCION: El id del contacto no existe");
				return"redirect:/views/contactList/contacts";
			}
		}else {
			attribute.addFlashAttribute("error", "ATENCION: Hubo  problemas con el id del contacto");
			return"redirect:/views/contactList/contacts";
		}
		
		model.addAttribute("contacts", contacts);
		
		return "/views/contactList/create";
	}
	
	
	@GetMapping("/delete/{id}")
	public String borrarContacto(@PathVariable ("id") Integer id, Model model, RedirectAttributes attribute) {
		
		Contacts contacts = null;
		
		if(id>0) {
			contacts = contactsService.findById(id);
			if(contacts == null) {
				attribute.addFlashAttribute("error", "ATENCION: El id del contacto no existe" );
			return"redirect:/views/contactList/contacts";
			}
		
		}else {
			attribute.addFlashAttribute("error", "ATENCION: Error con el id del contacto" );
			return "redirect:/views/contactList/contacts";
		}
		
		contactsService.delete(id);
		attribute.addFlashAttribute("warning", "Contacto eliminado exitosamente");
		return "redirect:/views/contactList/contacts";
		
	}
}
