package com.betacom.corsi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.corsi.businesscomponent.model.Admin;
import com.betacom.corsi.repository.AdminRepository;
import com.betacom.corsi.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminrep;

	@Override
	public void saveAdmin(Admin admin) {
		adminrep.save(admin);

	}

	@Override
	public List<Admin> getAll() {
		return adminrep.findAll();
	}

	@Override
	public Optional<Admin> findById(long id) {
		return adminrep.findById(id);
	}

	@Override
	public void deleteAdmin(Admin admin) {
		adminrep.delete(admin);

	}
}
