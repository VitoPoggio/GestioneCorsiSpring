package com.betacom.corsi.businesscomponent.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table
@Data
public class Corso implements Serializable{
	private static final long serialVersionUID = 7791658140307595557L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCorso;
	@Column(nullable = false)
	private String nomeCorso;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dataInizioCorso;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dataFineCorso;
	@Column(nullable = false)
	private double costoCorso;
	@Column
	private String commentiCorso;
	@Column(nullable = false)
	private String aulaCorso;
	@Column(nullable = false )
	private int postiDisponibili = 12;
	
	@ManyToOne
	@JoinColumn(name = "id_docente", nullable = false)
	private Docente docente;
	
	@OneToMany(mappedBy = "corso", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CorsistaCorso> oa = new HashSet<CorsistaCorso>();

}
