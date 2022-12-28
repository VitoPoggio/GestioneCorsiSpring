package com.betacom.corsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.corsi.businesscomponent.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long>{

}
