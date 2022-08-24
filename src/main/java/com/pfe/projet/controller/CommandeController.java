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

import com.pfe.projet.model.Commande;
import com.pfe.projet.service.CommandeService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CommandeController {
	@Autowired
    private CommandeService commandeService;
	
 
 @GetMapping("/commandes")
    public List<Commande> list() {
	 System.out.println("Get all commandes...");
             return commandeService.getAll();
   }
 	 
 @GetMapping("/commandes/{id}")
 public ResponseEntity<Commande> post(@PathVariable long id) {
        Optional<Commande> cat = commandeService.findById(id);
        return cat.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                              .build());
    }
    
 @PostMapping("/commandes")
    public long save(@RequestBody Commande Commande) {
	 System.out.println("Save Commande...");
        return commandeService.save(Commande);
    }

 @PutMapping("/commandes/{code}")
    public void update(@PathVariable long id, @RequestBody Commande Commande) {
     
    }

   
     
}


