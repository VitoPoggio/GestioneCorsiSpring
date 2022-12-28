package com.betacom.corsi.businesscomponent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class CorsistaCorso implements Serializable{
	private static final long serialVersionUID = 9129548132361208098L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_corso", nullable = false)
	private Corso corso;
	
	@ManyToOne
	@JoinColumn(name = "id_corsista", nullable = false)
	private Corsista corsista;
}
