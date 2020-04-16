package com.run.authentication.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("authorizationRequest")
public class AccessController {
    @Autowired
	private ClientDetailsService clientDetailsService;

    @RequestMapping("/oauth/confirm_access")
    public ModelAndView confirmAccess(@ModelAttribute AuthorizationRequest request, HttpServletRequest req) throws Exception {
        ClientDetails client = clientDetailsService.loadClientByClientId(request.getClientId());
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("client", client);
		return new ModelAndView("confirmation", model);
    }
}