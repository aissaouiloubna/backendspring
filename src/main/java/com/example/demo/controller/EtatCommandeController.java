package com.example.demo.controller;

import com.example.demo.dao.EtatCommandeRepository;
import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.model.EtatCommandes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/Ecommande")
public class EtatCommandeController {
    @Autowired
    private EtatCommandeRepository etatCommandeRepository;

    // get all

    @GetMapping
    public List<EtatCommandes> getAllEtatCommandes() {
        return this.etatCommandeRepository.findAll();
    }

    // get by id
    @GetMapping("/{id}")
    public EtatCommandes getEtatCommandesById(@PathVariable(value = "id") long id) {
        return this.etatCommandeRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("etat Commande not Found"));
    }


    // get by qr
    @CrossOrigin(origins ="http://localhost:3000")
    @GetMapping("/qr/{qr}")
    public List<EtatCommandes> findByQr(@PathVariable long qr ) {
        return this.etatCommandeRepository.findByQr(qr);
    }

    //create
    @CrossOrigin(origins ="http://localhost:3000")
    @PostMapping
    public EtatCommandes createMenus(@RequestBody EtatCommandes etatcommandes) {
        return this.etatCommandeRepository.save(etatcommandes);
    }
}
