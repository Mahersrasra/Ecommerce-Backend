package com.pfe.projet.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name = "boutique",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "code"
				+ ""),
		@UniqueConstraint(columnNames = "name") 
	})
public class Boutique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	private String description;
	private String adresse;
	private String ville;
	private String codep;
	private String  telephone;
	private String image;
	private String responsable;
	private String email;
	private String pwd;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodep() {
		return codep;
	}
	public void setCodep(String codep) {
		this.codep = codep;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Boutique [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description
				+ ", adresse=" + adresse + ", ville=" + ville + ", codep=" + codep + ", telephone=" + telephone
				+ ", image=" + image + ", responsable=" + responsable + ", email=" + email + ", pwd=" + pwd + "]";
	}
	public Boutique(Long id, String code, String name, String description, String adresse, String ville, String codep,
			String telephone, String image, String responsable, String email, String pwd) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.adresse = adresse;
		this.ville = ville;
		this.codep = codep;
		this.telephone = telephone;
		this.image = image;
		this.responsable = responsable;
		this.email = email;
		this.pwd = pwd;
	}
	public Boutique() {
		super();
		// TODO Auto-generated constructor stub
	}

}

