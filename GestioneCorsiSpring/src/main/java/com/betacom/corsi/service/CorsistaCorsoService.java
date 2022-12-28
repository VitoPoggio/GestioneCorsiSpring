package com.betacom.corsi.service;

import java.util.List;
import java.util.Optional;

import com.betacom.corsi.businesscomponent.model.CorsistaCorso;

public interface CorsistaCorsoService {
	void saveCorsistaCorso(CorsistaCorso corsistaCorso);
	List<CorsistaCorso> getAll();
	Optional<CorsistaCorso> findById(long id);
	int getPostiOccupati();
	int getNumCorsi();
	String getCorsiFreq();
}
