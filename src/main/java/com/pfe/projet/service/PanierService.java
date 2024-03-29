package com.pfe.projet.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pfe.projet.model.Compteur;
import com.pfe.projet.model.Lpanier;
import com.pfe.projet.model.Panier;
import com.pfe.projet.repository.CompteurRepository;
import com.pfe.projet.repository.LpanierRepository;
import com.pfe.projet.repository.PanierRepository;



@Service
@Transactional
public class PanierService {
	@Autowired
	PanierRepository repository;
	@Autowired
	LpanierRepository lprepository;
	@Autowired
	CompteurRepository crepository;
	public List<Panier> getAll() {
		System.out.println("Get all Paniers 11111...");
    	return repository.findAll(Sort.by("numero").ascending());	    	
    }
	
	
    public Optional<Panier> findById(long id) {
        return repository.findById(id);
    }
    
    
    
   
    public long save(Panier Panier) {
    	 System.out.println("Save Lpaniers...");
		List<Lpanier> lpaniers = Panier.getLpaniers();
	    for (Lpanier lp : lpaniers) {
	        lp.setNumero(Panier.getNumero());
	        lprepository.save(lp);
	       }	 
	
     Optional<Compteur> CompteurInfo = crepository.findByAnnee(Panier.getAnnee());
     	if (CompteurInfo.isPresent()) {
	    	Compteur compteur = CompteurInfo.get();
	           compteur.setNumpanier(compteur.getNumpanier()+1);
	         compteur =   crepository.save(compteur);
     	}
     	return repository.save(Panier)
                .getId();
     	
    }
  
  

    public List<Panier> findByNom(String nom) {
        return repository.findAllByNom(nom);
    }

   
    public void delete(long  id) {
        Optional<Panier> cat = repository.findById(id);
        cat.ifPresent(repository::delete);
    }
}