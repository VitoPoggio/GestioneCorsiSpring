package com.betacom.corsi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.betacom.corsi.businesscomponent.model.Admin;
import com.betacom.corsi.repository.AdminRepository;

@Configuration
public class AdminDetailsService implements UserDetailsService {
	private AdminRepository adminRepository;
	
	public AdminDetailsService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Admin admin = adminRepository.findById(username).get();
			if(admin != null) {
				return User.withUsername(
						admin.getUsername())
						.accountLocked(!admin.isEnabled())
						.password(admin.getPassword())
						.roles(admin.getRole())
						.build();
			}
		} catch(Exception exc) {
			exc.printStackTrace();
		}
		throw new UsernameNotFoundException(username);
	}

}
