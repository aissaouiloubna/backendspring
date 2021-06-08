package com.example.demo.controller;

import java.util.List;

import com.example.demo.dao.CategorieRepository;
import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/categorie")
public class CategorieController {


        @Autowired
        private CategorieRepository categorieRepository;

        // get all

        @GetMapping
        public List<Categorie> getAllCategories() {
            return this.categorieRepository.findAll();
        }

        // get by id
        @GetMapping("/{id}")
        public Categorie getCategoriesById(@PathVariable(value = "id") long id) {
            return this.categorieRepository.findById(id)
                   .orElseThrow(() -> new RessourceNotFoundException("Categorie not Found"));
        }


        // get by qr
        @CrossOrigin(origins ="http://localhost:3000")
        @GetMapping("/qr/{qr}")
        public List<Categorie> findByQr(@PathVariable(value = "qr") long qr) {
            return this.categorieRepository.findByQr(qr);
        }

        //create
        @CrossOrigin(origins ="http://localhost:3000")
        @PostMapping
        public Categorie createMenus(@RequestBody Categorie categorie) {
            return this.categorieRepository.save(categorie);
        }

    }

