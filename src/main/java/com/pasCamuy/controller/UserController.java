package com.pasCamuy.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pasCamuy.model.User;
import com.pasCamuy.service.IUserService;
import com.pasCamuy.service.UploadFileService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private UploadFileService upload;

	@GetMapping("/login")
	public String login(Model model, User user) {
		model.addAttribute("titulo", "Iniciar Sesión");
		model.addAttribute("user", new User());

		return "user/login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("titulo", "Crear Cuenta");

		return "user/register";

	}

	@PostMapping("/save")
	public String save(User user, @RequestParam("img") MultipartFile file) throws IOException {
		logger.info("Usuario Registro{}", user);
		user.setType("USER");

		if (user.getId() == 0) {
			String imageName = upload.saveImage(file);
			user.setImage(imageName);
		} else {
		
		}
		userService.save(user);

		return "redirect:/";
	}

	@GetMapping("/showAllUsers")
	public String ShowAllUsers(Model model) {
		model.addAttribute("user", userService.findAll());
		model.addAttribute("titulo", "Listado de todos los usuairos");

		return "user/showAllUsers";

	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable ("id") Integer id, Model model,  RedirectAttributes attribute) {
		
		User user = new User();
		Optional<User> optionalUser=userService.findById(id);
		user =  optionalUser.get();
		logger.info("DESDE EL METODO /edit {}", user);
		model.addAttribute("user", user);
		model.addAttribute("titulo", "Editando los usuairos");
							
		return "user/edit";
		
	}
	
	@PostMapping("/update")
	public String update(User user, @RequestParam ("img") MultipartFile file) throws IOException  {		
		User u = new User();
		u = userService.findById(user.getId()).get();
		
		if(file.isEmpty()) {
			user.setImage(u.getImage());
			logger.info("DESDE EL METODO /update -- 1er if {}", user);

		}else {
			if(!u.getImage().equals("default.jpg")) {
				upload.deleteImage(u.getImage());
				logger.info("DESDE EL METODO /update -- 2er if {}", user);
			}
			String imageName = upload.saveImage(file);
			user.setImage(imageName);
		}
		user.setUser(u.getUser());
		userService.update(user);
		logger.info("DESDE EL METODO /update -- 3er if{}", user);

		return "redirect:/user/showAllUsers";
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		User u =new User();
		u = userService.findById(id).get();
		userService.delete(id);
		
		if(!u.getImage().equals("default.jpg")) {
			upload.deleteImage(u.getImage());
		}
				
		return "redirect:/user/showAllUsers";
	}
	
	@GetMapping("/showProfile/{id}")
	public String showProfile (@PathVariable ("id") Integer id, Model model ) throws IOException  {
		
		Optional <User>user= userService.findById(id);
		model.addAttribute("user", user.get());
		
//		model.addAttribute("user", userService.findById(id));
//		model.addAttribute("titulo", "Perfil de Usuario");
		return "user/showProfile";
		
	}
	
}
