package com.project.Shopping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Shopping.Model.Users;
import com.project.Shopping.Service.FrontService;

@Controller
public class FrontController {

	FrontService frontService;

	@Autowired
	public FrontController(FrontService frontService) {
		this.frontService = frontService;
	}

	@GetMapping("/Login")
	public String gotoLoginPage() {
		return "LR";
	}

	@GetMapping("/adminlogin")
	public String adminlogin(@ModelAttribute Users users, Model model) {
		return frontService.adminlogin(users);
	}

	@PostMapping("/CheckLogin")
	public String checkLogin(@ModelAttribute Users users, Model model) {
		String response = frontService.CheckLogin(users);

		if (response.equals("Home")) {
			boolean login = true;
			model.addAttribute("condition", login);
			return "HomePage";
		} else if (response.equals("Admin")) {
			return "AdminPanel";
		} else if (response.equals("Notfound")) {
			model.addAttribute("errorMessage", "Incorrect email or password."); // Set error message
			return "LR";
		}

		return "LR";
	}

	@GetMapping("/Register")
	public String gotoRegisterPage() {
		return "LR";
	}

	@PostMapping("/submitRegister")
	public String saveRegister(@ModelAttribute Users users, Model model) {
		String result = frontService.saveRegister(users);
		System.err.println(result);
		model.addAttribute("message", result);
		return "LR";
	}
}
