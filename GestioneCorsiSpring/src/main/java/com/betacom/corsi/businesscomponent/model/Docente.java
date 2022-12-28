package com.betacom.corsi.businesscomponent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Docente implements Serializable{
	private static final long serialVersionUID = 1732781834593680454L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDocente;
	@Column(nullable = false)
	private String nomeDocente;
	@Column(nullable = false)
	private String cognomeDocente;
	@Column(nullable = false)
	private String cvDocente;
}
