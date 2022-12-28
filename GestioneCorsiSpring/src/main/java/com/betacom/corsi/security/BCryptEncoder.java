package com.betacom.corsi.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoder {
	public static String encode(String password) {
		BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
		return cryptPasswordEncoder.encode(password);
	}
}
