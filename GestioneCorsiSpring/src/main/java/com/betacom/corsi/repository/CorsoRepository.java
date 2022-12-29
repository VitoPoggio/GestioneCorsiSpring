package com.betacom.corsi.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.betacom.corsi.businesscomponent.model.Corso;

@Repository
public interface CorsoRepository extends JpaRepository<Corso, Long> {
	@Query(value = "select posti_disponibili from corso where id_corso = ?1", nativeQuery = true)
	int getPostiDisponibili(long id);

	@Query(value = "select max(data_inizio_corso) from corso", nativeQuery = true)
	Date getUltimoCorso();

	@Query(value = "select avg(datediff(data_fine_corso,data_inizio_corso)) from corso", nativeQuery = true)
	double getMediaCorsi(); // vedere bene collection da usare
}
