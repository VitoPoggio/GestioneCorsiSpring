package com.betacom.corsi.service;

import java.util.List;
import java.util.Optional;

import com.betacom.corsi.businesscomponent.model.Docente;

public interface DocenteService {
	void saveDocente(Docente docente);
	List<Docente> getAll();
	Optional<Docente> findById(long id);
}
