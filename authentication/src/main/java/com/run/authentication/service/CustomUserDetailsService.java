package com.run.authentication.service;

import java.util.stream.Collectors;

import com.run.authentication.repository.UserRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username)
				.map(user -> {
					User userInfo = new User(user.getUsername(),
						user.getPassword(), user.getEnabled(), !user.getAccountExpired(), !user.getCredentialsExpired(), !user.getAccountLocked(),
						AuthorityUtils.createAuthorityList(user.getRoles().stream().map((role) -> "ROLE_" + role.getName().toUpperCase()).collect(Collectors.toList()).toArray(new String[] {})));
					return userInfo;
					})
				.orElseThrow(() -> new UsernameNotFoundException(
						"No user with the name " + username + " was found in the database."));
	}
	
	
}
