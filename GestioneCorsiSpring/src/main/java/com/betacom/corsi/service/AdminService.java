package com.betacom.corsi.service;

import java.util.List;
import java.util.Optional;

import com.betacom.corsi.businesscomponent.model.Admin;

public interface AdminService {
	void saveAdmin(Admin admin);
	List<Admin> getAll();
	Optional<Admin> findById(long id);
	void deleteAdmin(Admin admin);
}
