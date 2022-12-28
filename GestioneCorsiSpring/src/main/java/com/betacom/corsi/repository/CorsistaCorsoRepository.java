package com.betacom.corsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.betacom.corsi.businesscomponent.model.CorsistaCorso;

@Repository
public interface CorsistaCorsoRepository extends JpaRepository<CorsistaCorso, Long> {
	@Query(value="select count(id_corso) from corsista_corso where id_corso = ?1", nativeQuery = true)
	int getPostiOccupati(long id);
	
	@Query(value="select count(id_corsista) from corsista_corso where id_corsista = ?1", nativeQuery = true)
	int getNumCorsi(long id);
	
	@Query(value="select nome_corso, count(corsista_corso.id_corso) as count from corsista_corso, corso where corso.id_corso = corsista_corso.id_corso group by nome_corso order by count desc", nativeQuery = true)
	List<String> getCorsiFreq();
}
