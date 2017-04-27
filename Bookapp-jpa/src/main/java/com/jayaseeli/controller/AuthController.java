package com.jayaseeli.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jayaseeli.model.User;
import com.jayaseeli.repository.UserRepository;


@Controller
@RequestMapping("auth")
public class AuthController {


	@Autowired
	private UserRepository userrepository;

	@PostMapping("/login")
	public String login(@RequestParam("email") String emailId, @RequestParam("password") String password,
			ModelMap modelMap, HttpSession session) {
	
		User user = userrepository.findByEmailIdAndPassword(emailId, password);
		if (user != null) {
			session.setAttribute("LOGGED_IN_USER", user);
			return "success";
		} else {
			return "fail";
		}
	}

}
