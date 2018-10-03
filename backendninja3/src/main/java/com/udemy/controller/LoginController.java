package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.constant.ViewConstant;
import com.udemy.model.UserCredencial;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping("/")
	public String redirecLogin() {
		LOG.info("METHOD: redirecLogin() ");
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("METHOD : showLoginForm() -- PARAMS :: error :" + error + " logout: " + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredencial", new UserCredencial());
		LOG.info("Returning login view ");
		return ViewConstant.LOGIN;
	}

	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name = "userCredencial") UserCredencial userCredencial) {
		LOG.info("METHOD : showLoginForm() -- PARAMS :: userCredencial :" + userCredencial.toString());
		if (userCredencial.getUserName().equals("admin") && userCredencial.getPassword().equals("123")) {
			LOG.info("Returning contacs view ");

			return "redirect:/contacts/showcontact";
		}

		LOG.info("Returning login?error view ");
		return "redirect:/login?error";

	}

}
