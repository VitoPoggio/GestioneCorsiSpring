package com.betacom.corsi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.betacom.corsi.businesscomponent.model.Corso;

public interface CorsoService {
	void saveCorso(Corso corso);
	List<Corso> getAll();
	Optional<Corso> findById(long id);
	int getPostiDisponibili(long id);
	Date getUltimoCorso();
	Double getMediaCorsi();
	void deleteCorso(long id);
}
