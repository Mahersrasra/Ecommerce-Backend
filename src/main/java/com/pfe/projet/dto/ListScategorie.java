package com.pfe.projet.dto;

public class ListScategorie {
	 private String code;
	 private String libelle;
	 private String libcateg;
	 private String ccateg;
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
	public String getLibcateg() {
		return libcateg;
	}
	public void setLibcateg(String libcateg) {
		this.libcateg = libcateg;
	}
	public String getCcateg() {
		return ccateg;
	}
	public void setCcateg(String ccateg) {
		this.ccateg = ccateg;
	}
	@Override
	public String toString() {
		return "ListCategorie [code=" + code + ", libelle=" + libelle + ", libcateg=" + libcateg + ", ccateg=" + ccateg
				+ "]";
	}
	public ListScategorie(String code, String libelle, String libcateg, String ccateg) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.libcateg = libcateg;
		this.ccateg = ccateg;
	}
	public ListScategorie() {
		super();
		// TODO Auto-generated constructor stub
	}

}
