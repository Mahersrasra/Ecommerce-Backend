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

import com.pfe.projet.model.Commande;
import com.pfe.projet.model.Compteur;
import com.pfe.projet.model.Lcommande;
import com.pfe.projet.repository.CommandeRepository;
import com.pfe.projet.repository.CompteurRepository;
import com.pfe.projet.repository.LcommandeRepository;



@Service
@Transactional
public class CommandeService {
	@Autowired
	CommandeRepository repository;
	@Autowired
	LcommandeRepository lprepository;
	@Autowired
	CompteurRepository crepository;
	public List<Commande> getAll() {
		System.out.println("Get all Commandes 11111...");
    	return repository.findAll(Sort.by("numero").ascending());	    	
    }
	
	
    public Optional<Commande> findById(long id) {
        return repository.findById(id);
    }
    
    
    
   
    public long save(Commande Commande) {
    	 System.out.println("Save Lcommandes...");
		List<Lcommande> lpaniers = Commande.getLcommandes();
	    for (Lcommande lp : lpaniers) {
	        lp.setNumero(Commande.getNumero());
	        lprepository.save(lp);
	       }	 
	
     Optional<Compteur> CompteurInfo = crepository.findByAnnee(Commande.getAnnee());
     	if (CompteurInfo.isPresent()) {
	    	Compteur compteur = CompteurInfo.get();
	           compteur.setNumCommande(compteur.getNumCommande()+1);
	         compteur =   crepository.save(compteur);
     	}
     	return repository.save(Commande)
                .getId();
     	
    }
  
  


   
    public void delete(long  id) {
        Optional<Commande> cat = repository.findById(id);
        cat.ifPresent(repository::delete);
    }
}