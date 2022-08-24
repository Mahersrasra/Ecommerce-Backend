package com.pfe.projet.service;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pfe.projet.model.Client;
import com.pfe.projet.model.User;
import com.pfe.projet.repository.ClientRepository;
import com.pfe.projet.repository.UserRepository;



@Service
@Transactional
public class ClientService {
	@Autowired 	ClientRepository repository;
	
	@Autowired 	UserRepository userRepository;
	
	public int max() {
		return repository.max();
	}
	
	public int nbre() {
		return repository.nbre();
	}
	
	public List<Client> getAll() {
		System.out.println("Get all Clients 11111...");
    	return repository.findAll(Sort.by("libelle").ascending());	    	
    }
	
	
    public Optional<Client> findByCode(int id) {
        return repository.findByCode(id);
    }
    
    public long save(Client Client) {
    	   User user = new User();
	        user.setUsername(Client.getEmail());
	        user.setEmail(Client.getEmail());
	        user.setPassword(Client.getPwd());
	        user.setRole("CLIENT");
	        user.setActive(true);
	        userRepository.save(user);
        return repository.save(Client)
                             .getId();
    }
    public void update(int code, Client Client) {
        Optional<Client> cli = repository.findByCode(code);
        if (cli.isPresent()) {
            Client cl = cli.get();
            cl.setLibelle(Client.getLibelle());
            cl.setAdresse(Client.getAdresse());
            repository.save(cl);
        }
    }
    
    
  

    public List<Client> findByLibelle(String libelle) {
        return repository.findAllByLibelleContaining(libelle);
    }
    
    public List<Client> findByEmail(String email) {
        return repository.findAllByEmail(email);
    }
    
    public void delete(int code) {
        Optional<Client> cat = repository.findByCode(code);
        cat.ifPresent(repository::delete);
    }
	


}
