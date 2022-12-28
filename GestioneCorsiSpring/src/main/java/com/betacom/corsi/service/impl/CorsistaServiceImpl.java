package com.betacom.corsi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.corsi.businesscomponent.model.Corsista;
import com.betacom.corsi.repository.CorsistaRepository;
import com.betacom.corsi.service.CorsistaService;

@Service
public class CorsistaServiceImpl implements CorsistaService {
	@Autowired
	CorsistaRepository corsisrep;

	@Override
	public void saveCorsista(Corsista corsista) {
		corsisrep.save(corsista);

	}

	@Override
	public List<Corsista> getAll() {
		return corsisrep.findAll();
	}

	@Override
	public Optional<Corsista> findById(long id) {
		return corsisrep.findById(id);
	}
}
