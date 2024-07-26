package com.rs.fer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rs.fer.bean.User;
import com.rs.fer.repository.UserRepository;
import com.rs.fer.utility.JwtUtil;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtil jwtUtil;

	public String login(String username, String password) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

		if (passwordEncoder.matches(password, user.getPassword())) {
			return jwtUtil.generateToken(username);
		} else {
			throw new RuntimeException("Invalid credentials");
		}
	}
	 public JwtUtil getJwtUtil() {
	        return jwtUtil;
	    }

	
}
