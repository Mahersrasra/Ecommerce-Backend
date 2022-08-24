package com.pfe.projet.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.projet.model.Client;
import com.pfe.projet.service.ClientService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientController {
	 @Autowired  private ClientService clientService;
	 @GetMapping("/clients/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = clientService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return clientService.max();
		 }
	    
	 }
	 
	 
	 @GetMapping("/clients")
	    public List<Client> list() {
		 System.out.println("Get all Clients...");
	             return clientService.getAll();
	   }
	 	 
	 @GetMapping("/clients/{id}")
	 public ResponseEntity<Client> post(@PathVariable int id) {
	        Optional<Client> four = clientService.findByCode(id);
	        return four.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                            .build());
	    }
	    
	 @PostMapping("/clients")
	    public long save(@RequestBody Client Client) {
		
	        return clientService.save(Client);
	    }

	 @PutMapping("/clients/{code}")
	    public void update(@PathVariable int code, @RequestBody Client Client) {
	      
	            clientService.update(code, Client);
	     
	    }

	    @DeleteMapping("/clients/{code}")
	    public void delete(@PathVariable int code) {
	        clientService.delete(code);
	    }
	

}



