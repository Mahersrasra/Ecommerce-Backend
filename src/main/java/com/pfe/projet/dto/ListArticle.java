package com.pfe.projet.dto;

public class ListArticle {
	 private long id;
	 private String code;
	 private String libelle;
	 private String categ;
	 private String scateg;
	 private String Boutique;
	 private double pa;
	 private double pv;
	 private int tva;
	 private int stock;
	 private String genre;
	 private String taille;
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
	public String getCateg() {
		return categ;
	}
	public void setCateg(String categ) {
		this.categ = categ;
	}
	public String getScateg() {
		return scateg;
	}
	public void setScateg(String scateg) {
		this.scateg = scateg;
	}
	public String getBoutique() {
		return Boutique;
	}
	public void setBoutique(String boutique) {
		Boutique = boutique;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	@Override
	public String toString() {
		return "ListArticle [id=" + id + ", code=" + code + ", libelle=" + libelle + ", categ=" + categ + ", scateg="
				+ scateg + ", Boutique=" + Boutique + ", pa=" + pa + ", pv=" + pv + ", tva=" + tva + ", stock=" + stock
				+ ", genre=" + genre + ", taille=" + taille + "]";
	}
	public ListArticle(long id, String code, String libelle, String categ, String scateg, String boutique, double pa,
			double pv, int tva, int stock, String genre, String taille) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.categ = categ;
		this.scateg = scateg;
		Boutique = boutique;
		this.pa = pa;
		this.pv = pv;
		this.tva = tva;
		this.stock = stock;
		this.genre = genre;
		this.taille = taille;
	}
	public ListArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

}
