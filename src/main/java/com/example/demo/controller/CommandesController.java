package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dao.CommandesRepository;
import com.example.demo.exception.RessourceNotFoundException;

import com.example.demo.model.Commandes;
import com.example.demo.model.Menus;



@RestController
@RequestMapping("api/commandes")

public class CommandesController {
	
	@Autowired
	private CommandesRepository commandesRepository;
	
	
	 @GetMapping
     public List<Commandes> getAllCategories() {
         return this.commandesRepository.findAll();
     }
	 
     // get by id
     @GetMapping("/{id}")
     public Commandes getCategoriesById(@PathVariable(value = "id") long id) {
         return this.commandesRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Commandes not Found"));
     }

     // showall
     @CrossOrigin(origins ="http://localhost:3000")
     @GetMapping("/qr/{qr}/{idcommande}")
     public List<Commandes> findByQr(@PathVariable(value = "qr") long qr ,@PathVariable(value = "idcommande") long idcommande) {
         return this.commandesRepository.showAll(qr,idcommande);
     }
     // etat
     @CrossOrigin(origins ="http://localhost:3000")
     @GetMapping("/qr/etat/{qr}/{idcommande}")
     public int FindEtat(@PathVariable(value = "qr") long qr ,@PathVariable(value = "idcommande") long idcommande) {
         return this.commandesRepository.findEtat(qr,idcommande);
     }

     // get by qr
     @CrossOrigin(origins ="http://localhost:3000")
     @GetMapping("/qr/{qr}")
     public List<Commandes> findByQr(@PathVariable(value = "qr") long qr) {
         return this.commandesRepository.findByQr(qr);
     }
     

     //create
     @CrossOrigin(origins ="http://localhost:3000")
     @PostMapping
     public Commandes createCommandes(@RequestBody Commandes Commandes) {
         return this.commandesRepository.save(Commandes);
     }
     
     @PutMapping("/update/{idcommande}")
     @CrossOrigin(origins ="http://localhost:3000")
     public  String changerEtat (@PathVariable long idcommande) {
    	 this.commandesRepository.changerEtat(idcommande);
    	 return "updated";
     }
     
    
  

}


