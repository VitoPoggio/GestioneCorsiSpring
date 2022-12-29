package com.betacom.corsi.businesscomponent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Admin implements Serializable {
	private static final long serialVersionUID = 5168487479976369765L;
	
	
	@Column(nullable = false)
	private String nomeAdmin;
	@Column(nullable = false)
	private String cognomeAdmin;
	@Id
	private String username;
	@Column(nullable = false)
	private String password;
	@Column
	private String role = "ADMIN";
	@Column
	private boolean enabled = true;
}
