package com.pfe.projet.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "commande")
public class Commande {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int annee;
	  private int numero;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date dateCommande;
	  private int code;
	  private String libelle;
	  private String libClient;
	  private double avance;
	  private double totht;
	  private double tottva;
	  private double totttc;
	  @JsonManagedReference
	  @JsonIgnore
	  @OneToMany(mappedBy = "commande", fetch=FetchType.EAGER)
      @Valid
	  private List<Lcommande> lcommandes = new ArrayList<>();
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
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLibClient() {
		return libClient;
	}
	public void setLibClient(String libClient) {
		this.libClient = libClient;
	}
	public double getAvance() {
		return avance;
	}
	public void setAvance(double avance) {
		this.avance = avance;
	}
	public double getTotht() {
		return totht;
	}
	public void setTotht(double totht) {
		this.totht = totht;
	}
	public double getTottva() {
		return tottva;
	}
	public void setTottva(double tottva) {
		this.tottva = tottva;
	}
	public double getTotttc() {
		return totttc;
	}
	public void setTotttc(double totttc) {
		this.totttc = totttc;
	}
	public List<Lcommande> getLcommandes() {
		return lcommandes;
	}
	public void setLcommandes(List<Lcommande> lcommandes) {
		this.lcommandes = lcommandes;
	}
	@Override
	public String toString() {
		return "Commande [id=" + id + ", annee=" + annee + ", numero=" + numero + ", dateCommande=" + dateCommande
				+ ", code=" + code + ", libelle=" + libelle + ", libClient=" + libClient + ", avance=" + avance
				+ ", totht=" + totht + ", tottva=" + tottva + ", totttc=" + totttc + ", lcommandes=" + lcommandes + "]";
	}
	public Commande(long id, int annee, int numero, Date dateCommande, int code, String libelle, String libClient,
			double avance, double totht, double tottva, double totttc, @Valid List<Lcommande> lcommandes) {
		super();
		this.id = id;
		this.annee = annee;
		this.numero = numero;
		this.dateCommande = dateCommande;
		this.code = code;
		this.libelle = libelle;
		this.libClient = libClient;
		this.avance = avance;
		this.totht = totht;
		this.tottva = tottva;
		this.totttc = totttc;
		this.lcommandes = lcommandes;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

}

