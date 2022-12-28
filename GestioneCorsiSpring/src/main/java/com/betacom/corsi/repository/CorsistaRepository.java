package com.betacom.corsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.corsi.businesscomponent.model.Corsista;

@Repository
public interface CorsistaRepository extends JpaRepository<Corsista, Long> {

}
