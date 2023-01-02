package com.betacom.corsi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.corsi.businesscomponent.model.CorsistaCorso;
import com.betacom.corsi.repository.CorsistaCorsoRepository;
import com.betacom.corsi.repository.CorsoRepository;
import com.betacom.corsi.service.CorsistaCorsoService;

@Service
public class CorsistaCorsoServiceImpl implements CorsistaCorsoService {
	@Autowired
	CorsistaCorsoRepository ccrep;
	@Autowired
	CorsoRepository correp;

	@Override
	public void saveCorsistaCorso(CorsistaCorso corsistaCorso) {
		ccrep.save(corsistaCorso);

	}

	@Override
	public List<CorsistaCorso> getAll() {
		return ccrep.findAll();
	}

	@Override
	public Optional<CorsistaCorso> findById(long id) {
		return ccrep.findById(id);
	}

	@Override
	public int getPostiOccupati(long id) {
		int posti = correp.findById(id).get().getPostiDisponibili() - ccrep.getPostiOccupati(id);
		return posti ;
	}

	@Override
	public int getNumCorsi(long id) {
		return ccrep.getNumCorsi(id);
	}

	@Override
	public List<String> getCorsiFreq() {
		return ccrep.getCorsiFreq();
	}
}
