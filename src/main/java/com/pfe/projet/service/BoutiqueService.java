package com.pfe.projet.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.projet.model.Boutique;
import com.pfe.projet.model.User;
import com.pfe.projet.repository.BoutiqueRepository;
import com.pfe.projet.repository.UserRepository;

import javax.transaction.Transactional;
import org.springframework.data.domain.Sort;
@Service
@Transactional
public class BoutiqueService {
	 @Autowired
		BoutiqueRepository repository;
	 @Autowired
		UserRepository userRepository;
	 
		public List<Boutique> getAll() {
			System.out.println("Get all Boutiques 11111...");
	    	return repository.findAll(Sort.by("name").ascending());	    	
	    }
		
		public int max() {
			return repository.max();
		}
		
		public int nbre() {
			return repository.nbre();
		}
		
	    public Optional<Boutique> findById(long id) {
	        return repository.findById(id);
	    }
	    
	    public long save(Boutique Boutique) {
	    	  User user = new User();
		        user.setUsername(Boutique.getName());
		        user.setCode(Boutique.getCode());
		        user.setNom(Boutique.getName());
		        user.setEmail(Boutique.getEmail());
		        user.setPassword(Boutique.getPwd());
		        user.setRole("BOUTIQUE");
		        user.setActive(true);
		        userRepository.save(user);
	        return repository.save(Boutique)
	                             .getId();
	    }
	    public void update(String code, Boutique boutique) {
	        Optional<Boutique> bouti = repository.findByCode(code);
	        if (bouti.isPresent()) {
	            Boutique cat = bouti.get();
	            cat.setName(cat.getName());
	            cat.setAdresse(cat.getAdresse());
	            repository.save(cat);
	        }
	    }
	  
	
	    public List<Boutique> findByName(String libelle) {
	        return repository.findAllByNameContaining(libelle);
	    }

	    public void delete(String code) {
	        Optional<Boutique> cat = repository.findByCode(code);
	        cat.ifPresent(repository::delete);
	    }

		
		
}
