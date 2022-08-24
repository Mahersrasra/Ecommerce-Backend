package com.pfe.projet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "carte",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "numCarte"
				) 
	})
public class Carte {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private String numCarte;
	  private String password;
	  private String csv;
	  private  double solde;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumCarte() {
		return numCarte;
	}
	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCsv() {
		return csv;
	}
	public void setCsv(String csv) {
		this.csv = csv;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	@Override
	public String toString() {
		return "Carte [id=" + id + ", numCarte=" + numCarte + ", password=" + password + ", csv=" + csv + ", solde="
				+ solde + "]";
	}
	public Carte(long id, String numCarte, String password, String csv, double solde) {
		super();
		this.id = id;
		this.numCarte = numCarte;
		this.password = password;
		this.csv = csv;
		this.solde = solde;
	}
	public Carte() {
		super();
		// TODO Auto-generated constructor stub
	}

}
