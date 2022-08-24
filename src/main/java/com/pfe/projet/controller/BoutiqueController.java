package com.pfe.projet.controller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.projet.model.Boutique;
import com.pfe.projet.model.User;
import com.pfe.projet.service.BoutiqueService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BoutiqueController {
	 @Autowired
	    private BoutiqueService boutiqueService;
	 @Autowired  ServletContext context;
   	 @GetMapping("/boutiques/7")
	 public  int getCode() {
		 System.out.println("Get Numbers...");
		 int  x = boutiqueService.nbre();
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return boutiqueService.max();
		 }
	    
	 }
	 
	 @GetMapping("/boutiques")
	    public List<Boutique> list() {
		 System.out.println("Get all Boutiques...");
	             return boutiqueService.getAll();
	   }
	 	 
	 @GetMapping("/boutiques/{id}")
	 public ResponseEntity<Boutique> post(@PathVariable long  id) {
	        Optional<Boutique> cat = boutiqueService.findById(id);
	        return cat.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
	    }
	    
	 @PostMapping("/boutiques")
	public long save (@RequestParam("file") MultipartFile file,
			 @RequestParam("boutique") String boutique) throws JsonParseException , JsonMappingException , Exception
	 {
		
		Boutique bouti = new ObjectMapper().readValue(boutique, Boutique.class);
		addBoutiqueImage(file);
	    String filename = file.getOriginalFilename();
	    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	    bouti.setImage(newFileName);
	    return boutiqueService.save(bouti);
	 }
	 
	 @PutMapping("/boutiques/{code}")
	    public void update(@PathVariable String code, @RequestBody Boutique boutique) {
	       
	            boutiqueService.update(code, boutique);
	      
	    }

	    @DeleteMapping("/boutiques/{code}")
	    public void delete(@PathVariable String code) {
	        boutiqueService.delete(code);
	    }
	    
	    
	   
	    private void addBoutiqueImage(MultipartFile file)
	    {
	    	boolean isExit = new File(context.getRealPath("/ImgBoutiques/")).exists();
		    if (!isExit)
		    {
		    	new File (context.getRealPath("/ImgBoutiques/")).mkdir();
		    	System.out.println("mk dir Boutiques...........");
		    }
		    String filename = file.getOriginalFilename();
		    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
		    File serverFile = new File (context.getRealPath("/ImgBoutiques/"+File.separator+newFileName));
		    try
		    {
		    
		    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
		    	 
		    }catch(Exception e) {
		    	 System.out.println("Failed to Add Image Boutique !!");
		    }
	    }
	    
	    @GetMapping(path="/ImgBoutiques/{id}")
		 public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
	    	 System.out.println("Get all Boutiques Images...");
			 Boutique Boutique   =boutiqueService.findById(id).get();
			 return Files.readAllBytes(Paths.get(context.getRealPath("/ImgBoutiques/")+Boutique.getImage()));
		 }
	    
	     
	  
}


