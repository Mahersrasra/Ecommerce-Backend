package com.pfe.projet.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.projet.model.Carte;
import com.pfe.projet.model.Compteur;
import com.pfe.projet.model.Paiement;
import com.pfe.projet.repository.CarteRepository;
import com.pfe.projet.repository.CompteurRepository;
import com.pfe.projet.repository.PaiementRepository;


@Service
@Transactional
public class PaiementService {
	@Autowired
	PaiementRepository paiementRepository;
	@Autowired
	CompteurRepository crepository;
	@Autowired
	CarteRepository carteRepository;
	public List<Paiement> getAll() {
		System.out.println("Get all Paniers 11111...");
    	return paiementRepository.findAll();	    	
    }
	
	
    public Optional<Paiement> findById(long id) {
        return paiementRepository.findById(id);
    }
    public long save(Paiement Paiement) {
    	Optional<Carte> CarteInfo = carteRepository.findByNumCarte(Paiement.getNumCarte());
    	if (CarteInfo.isPresent()) {
	    	Carte carte = CarteInfo.get();
	           carte.setSolde(carte.getSolde() - Paiement.getMontant());
	         carte =  carteRepository.save(carte);
    	}
    Optional<Compteur> CompteurInfo = crepository.findByAnnee(Paiement.getAnnee());
    	if (CompteurInfo.isPresent()) {
	    	Compteur compteur = CompteurInfo.get();
	           compteur.setNumReglement(compteur.getNumReglement()+1);
	         compteur =   crepository.save(compteur);
    	}
    	return paiementRepository.save(Paiement)
               .getId();
    	
   }
}
