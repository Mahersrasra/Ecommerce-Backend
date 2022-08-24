package com.pfe.projet.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "lcommande")
public class Lcommande {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  @Column(name="numero")
	  private int numero ;
	  private String code;
	  private String Libart;
	  private int pu;
	  private double qte;
	  private double qts;
	  private int tva;
	  private double totht;
	  private double tottva;
	  private double totttc;
	  @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	  private Commande commande;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibart() {
		return Libart;
	}
	public void setLibart(String libart) {
		Libart = libart;
	}
	public int getPu() {
		return pu;
	}
	public void setPu(int pu) {
		this.pu = pu;
	}
	public double getQte() {
		return qte;
	}
	public void setQte(double qte) {
		this.qte = qte;
	}
	public double getQts() {
		return qts;
	}
	public void setQts(double qts) {
		this.qts = qts;
	}
	public int getTva() {
		return tva;
	}
	public void setTva(int tva) {
		this.tva = tva;
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
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	@Override
	public String toString() {
		return "Lcommande [id=" + id + ", numero=" + numero + ", code=" + code + ", Libart=" + Libart + ", pu=" + pu
				+ ", qte=" + qte + ", qts=" + qts + ", tva=" + tva + ", totht=" + totht + ", tottva=" + tottva
				+ ", totttc=" + totttc + ", commande=" + commande + "]";
	}
	public Lcommande(long id, int numero, String code, String libart, int pu, double qte, double qts, int tva,
			double totht, double tottva, double totttc, Commande commande) {
		super();
		this.id = id;
		this.numero = numero;
		this.code = code;
		Libart = libart;
		this.pu = pu;
		this.qte = qte;
		this.qts = qts;
		this.tva = tva;
		this.totht = totht;
		this.tottva = tottva;
		this.totttc = totttc;
		this.commande = commande;
	}
	public Lcommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
