package com.pfe.projet.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name = "compteur",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "annee")
	
	})
public class Compteur {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
		private int annee;
		private int numReglement;
		private int numCommande;
		private int numpanier;
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
		public int getNumReglement() {
			return numReglement;
		}
		public void setNumReglement(int numReglement) {
			this.numReglement = numReglement;
		}
		public int getNumCommande() {
			return numCommande;
		}
		public void setNumCommande(int numCommande) {
			this.numCommande = numCommande;
		}
		public int getNumpanier() {
			return numpanier;
		}
		public void setNumpanier(int numpanier) {
			this.numpanier = numpanier;
		}
		@Override
		public String toString() {
			return "Compteur [id=" + id + ", annee=" + annee + ", numReglement=" + numReglement + ", numCommande="
					+ numCommande + ", numpanier=" + numpanier + "]";
		}
		public Compteur(long id, int annee, int numReglement, int numCommande, int numpanier) {
			super();
			this.id = id;
			this.annee = annee;
			this.numReglement = numReglement;
			this.numCommande = numCommande;
			this.numpanier = numpanier;
		}
		public Compteur() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	
}
