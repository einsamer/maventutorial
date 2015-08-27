package com.src.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.src.entity.User;
import com.src.model.UserDAOImp;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("userSession")
public class UserController {

	@Autowired
	UserDAOImp userDAOImp;

	@RequestMapping(value = "/login")
	public String login(ModelMap model) {

		if (model.get("userSession") == null) {

			User user = new User();
			model.addAttribute("user", user);
			return "loginpage";
		} else {
			return "redirect:/user/personal";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLogin(@Valid @ModelAttribute User user, BindingResult rs, ModelMap md) {

		String successpage = "successpage";

		User userRs = userDAOImp.checkLogin(user);
		ModelAndView view = new ModelAndView();

		if (userRs.getRole() != 666) {
			view.addObject("userSession", userRs);
			md.addAttribute("userSession", userRs);
			return successpage;
		} else {
			return "loginpage";
		}

	}
	
	@RequestMapping(value = "/personal")
	public String personal(ModelMap model) {

		return "personalpage";
	}


}
