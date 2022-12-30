package com.betacom.corsi.businesscomponent.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table
@Data
public class Corsista implements Serializable{
	private static final long serialVersionUID = -3029942597036201255L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCorsista;
	@Column(nullable = false)
	private String nomeCorsista;
	@Column(nullable = false)
	private String cognomeCorsista;
	@Column(columnDefinition = "tinyint(1) default 1")
	private String precedentiCorsista;
	
	@OneToMany(mappedBy = "corsista", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CorsistaCorso> cc = new HashSet<CorsistaCorso>();
}
