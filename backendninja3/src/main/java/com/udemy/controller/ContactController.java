package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private static final Log LOG = LogFactory.getLog(ContactController.class);

	@Autowired
	@Qualifier("contactService")
	private ContactService contactService;

	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showcontact";
	}

	@GetMapping("/contactform")
	public String redirectContactForm(@RequestParam(name = "id", required = false) Integer id, Model model) {
		ContactModel contactModel = contactService.findContactModelById(id);
		if (null != id) {
			model.addAttribute("contactModel", contactModel);
		} else {
			model.addAttribute("contactModel", new ContactModel());
		}

		return ViewConstant.CONTACT_FORM;
	}

	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel, Model model) {
		LOG.info("METHOD addContact() --params : " + contactModel.toString());

		if (null != contactService.save(contactModel)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}

		return "redirect:/contacts/showcontact";
	}

	@GetMapping("/showcontact")
	public ModelAndView showContact() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACTS);
		modelAndView.addObject("contacts", contactService.listtAll());
		return modelAndView;
	}

	@GetMapping("/delete")
	public ModelAndView remove(@RequestParam("id") Integer id) {
		contactService.delete(id);
		return showContact();

	}

}
