package com.betacom.corsi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.corsi.businesscomponent.model.Corso;
import com.betacom.corsi.repository.CorsoRepository;
import com.betacom.corsi.service.CorsoService;

@Service
public class CorsoServiceImpl implements CorsoService{
	@Autowired
	CorsoRepository correp;

	@Override
	public void saveCorso(Corso corso) {
		correp.save(corso);
		
	}

	@Override
	public List<Corso> getAll() {
		return correp.findAll();
	}

	@Override
	public Optional<Corso> findById(long id) {
		return correp.findById(id);
	}

	@Override
	public int getPostiDisponibili(long id) {
		return correp.getPostiDisponibili(id);
	}

	@Override
	public Date getUltimoCorso() {
		return correp.getUltimoCorso();
	}

	@Override
	public int getMediaCorsi() {
		return correp.getMediaCorsi();
	}
}
