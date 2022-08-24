package com.pfe.projet.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "paiement",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "numero"
				) 
	})
public class Paiement {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int annee;
	  private int numero;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date date_mvt;
	  private String numCarte;
	  private String password;
	  private double montant;
	@Override
	public String toString() {
		return "Paiement [id=" + id + ", annee=" + annee + ", numero=" + numero + ", date_mvt=" + date_mvt
				+ ", numCarte=" + numCarte + ", password=" + password + ", montant=" + montant + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getDate_mvt() {
		return date_mvt;
	}
	public void setDate_mvt(Date date_mvt) {
		this.date_mvt = date_mvt;
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
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Paiement(long id, int annee, int numero, Date date_mvt, String numCarte, String password, double montant) {
		super();
		this.id = id;
		this.annee = annee;
		this.numero = numero;
		this.date_mvt = date_mvt;
		this.numCarte = numCarte;
		this.password = password;
		this.montant = montant;
	}
	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
}
