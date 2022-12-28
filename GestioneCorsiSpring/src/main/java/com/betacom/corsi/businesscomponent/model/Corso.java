package com.betacom.corsi.businesscomponent.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

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
	@Column(nullable = false)
	private int postiDisponibili;
	@OneToOne
	@MapsId
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Docente docente;

}
