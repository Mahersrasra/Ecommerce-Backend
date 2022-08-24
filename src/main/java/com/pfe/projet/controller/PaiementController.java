package com.pfe.projet.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.projet.model.Paiement;
import com.pfe.projet.service.PaiementService;
@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/api")
public class PaiementController {
	@Autowired
    private PaiementService paiementService;
	
 
 @GetMapping("/paiements")
    public List<Paiement> list() {
	 System.out.println("Get all paiements...");
             return paiementService.getAll();
   }
 	 
 @GetMapping("/paiements/{id}")
 public ResponseEntity<Paiement> post(@PathVariable long id) {
        Optional<Paiement> cat = paiementService.findById(id);
        return cat.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound()
                                              .build());
    }
    
 @PostMapping("/paiements")
    public long save(@RequestBody Paiement paiement) {
	 System.out.println("Save paiement...");
        return paiementService.save(paiement);
    }

 

}
