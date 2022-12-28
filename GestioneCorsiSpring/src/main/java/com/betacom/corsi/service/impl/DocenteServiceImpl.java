package com.betacom.corsi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.corsi.businesscomponent.model.Docente;
import com.betacom.corsi.repository.DocenteRepository;
import com.betacom.corsi.service.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService {
	@Autowired
	DocenteRepository docrep;

	@Override
	public void saveDocente(Docente docente) {
		docrep.save(docente);

	}

	@Override
	public List<Docente> getAll() {
		return docrep.findAll();
	}

	@Override
	public Optional<Docente> findById(long id) {
		return docrep.findById(id);
	}
}
