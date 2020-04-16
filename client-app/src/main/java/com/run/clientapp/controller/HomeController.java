package com.run.clientapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.run.clientapp.domain.UserInfo;
import com.run.clientapp.util.ApplicationConstant;

@Controller
public class HomeController {
	@GetMapping({"/", "/home"})
	public ModelAndView index(HttpSession session) {
		ModelAndView model = new ModelAndView("home");
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if(userInfo == null) {
			model.addObject("error", isTokenEmpty(session));
		} else {
			model.addObject("name", userInfo.getFirstname() + " " + userInfo.getLastname());
			model.addObject("error", isTokenEmpty(session));
		}
		return model;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET, params = "code")
	public ModelAndView home(@RequestParam String code, HttpSession session) {
		try {
			String token = (String) session.getAttribute(ApplicationConstant.TOKEN_VALUE.name());
			System.out.println("Token: " + token);
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://authentication:9000/auth/users/details";
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<UserInfo> user = restTemplate.exchange(url, HttpMethod.GET, entity, UserInfo.class);
			UserInfo userInfo = user.getBody();
			session.setAttribute("userInfo", userInfo);
			ModelAndView model = new ModelAndView("home");
			if(userInfo != null) {
				model.addObject("name", userInfo.getFirstname() + " " + userInfo.getLastname());
				model.addObject("error", isTokenEmpty(session));
			} else {
				model.addObject("error", false);
			}
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
	
	private boolean isTokenEmpty(HttpSession session) {
		return session.getAttribute(ApplicationConstant.TOKEN_VALUE.name()) == null;
	}
}
