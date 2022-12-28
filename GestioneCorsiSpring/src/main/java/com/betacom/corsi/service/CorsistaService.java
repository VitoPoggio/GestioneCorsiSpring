package com.betacom.corsi.service;

import java.util.List;
import java.util.Optional;

import com.betacom.corsi.businesscomponent.model.Corsista;

public interface CorsistaService {
	void saveCorsista(Corsista corsista);
	List<Corsista> getAll();
	Optional<Corsista> findById(long id);
}
