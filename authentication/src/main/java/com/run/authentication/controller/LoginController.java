package com.run.authentication.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
	public String login(Model model, HttpServletRequest request, @Nullable @RequestParam String error, @Nullable @RequestParam String logout) {
		if (error != null)
            model.addAttribute("errorMsg", "Your username or password is invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
	}
}