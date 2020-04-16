package com.run.authentication.controller;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import com.run.authentication.domain.UserDetails;
import com.run.authentication.repository.UserDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UserController {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @GetMapping(value="/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDetails> getUsers() {
        return userDetailsRepository.findAll();
    }

    @GetMapping(value="/users/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails getUserAccessInfo(Principal principal) {
        UserDetails ud = userDetailsRepository.findUserDetailsByUsername(principal.getName());
        return ud;
    }   
}