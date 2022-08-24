package com.pfe.projet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

	@Entity
	@Table(name = "article",
	uniqueConstraints = { 
			@UniqueConstraint(columnNames = "code"
					+ ""),
			@UniqueConstraint(columnNames = "libelle") 
		})
	public class Article {
		@Id
		  @GeneratedValue(strategy = GenerationType.AUTO)
		  private long id;
		  private String code;
	  	  private String libelle;
		  private double pa;
		  private double pv;
		  private int tva;
		  private int stock;
		  private String ccateg;
		  private String cscateg;
		  private String codeBoutique;
		  private String fileName;
		  private String sexe;
		  private String taille;
		  private boolean nCollection;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		public double getPa() {
			return pa;
		}
		public void setPa(double pa) {
			this.pa = pa;
		}
		public double getPv() {
			return pv;
		}
		public void setPv(double pv) {
			this.pv = pv;
		}
		public int getTva() {
			return tva;
		}
		public void setTva(int tva) {
			this.tva = tva;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public String getCcateg() {
			return ccateg;
		}
		public void setCcateg(String ccateg) {
			this.ccateg = ccateg;
		}
		public String getCscateg() {
			return cscateg;
		}
		public void setCscateg(String cscateg) {
			this.cscateg = cscateg;
		}
		public String getCodeBoutique() {
			return codeBoutique;
		}
		public void setCodeBoutique(String codeBoutique) {
			this.codeBoutique = codeBoutique;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getSexe() {
			return sexe;
		}
		public void setSexe(String sexe) {
			this.sexe = sexe;
		}
		public String getTaille() {
			return taille;
		}
		public void setTaille(String taille) {
			this.taille = taille;
		}
		public boolean isnCollection() {
			return nCollection;
		}
		public void setnCollection(boolean nCollection) {
			this.nCollection = nCollection;
		}
		@Override
		public String toString() {
			return "Article [id=" + id + ", code=" + code + ", libelle=" + libelle + ", pa=" + pa + ", pv=" + pv
					+ ", tva=" + tva + ", stock=" + stock + ", ccateg=" + ccateg + ", cscateg=" + cscateg
					+ ", codeBoutique=" + codeBoutique + ", fileName=" + fileName + ", sexe=" + sexe + ", taille="
					+ taille + ", nCollection=" + nCollection + "]";
		}
		public Article(long id, String code, String libelle, double pa, double pv, int tva, int stock, String ccateg,
				String cscateg, String codeBoutique, String fileName, String sexe, String taille, boolean nCollection) {
			super();
			this.id = id;
			this.code = code;
			this.libelle = libelle;
			this.pa = pa;
			this.pv = pv;
			this.tva = tva;
			this.stock = stock;
			this.ccateg = ccateg;
			this.cscateg = cscateg;
			this.codeBoutique = codeBoutique;
			this.fileName = fileName;
			this.sexe = sexe;
			this.taille = taille;
			this.nCollection = nCollection;
		}
		public Article() {
			super();
			// TODO Auto-generated constructor stub
		}	



}
