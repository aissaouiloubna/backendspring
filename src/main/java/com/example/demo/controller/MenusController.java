package com.example.demo.controller;

import java.util.List;

import com.example.demo.exception.RessourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Menus;
import com.example.demo.dao.MenusRepository;

@CrossOrigin
@RestController
@RequestMapping("api/menus")
public class MenusController {

    @Autowired
    private MenusRepository menusRepository;

    // get all

    @GetMapping
    public List<Menus> getAllMenus() {
        return this.menusRepository.findAll();
    }

    // get by id
    @GetMapping("/{id}")
    public Menus getMenusById(@PathVariable(value = "id") long idrepas) {
        return this.menusRepository.findById(idrepas)
                .orElseThrow(()-> new RessourceNotFoundException("repas not Found"));
    }


    // get by qr
    @CrossOrigin
    //@CrossOrigin(origins ="http://localhost:3000")
    @GetMapping("/qr/{qr}")
    public List<Menus> findByQr(@PathVariable(value = "qr") long qr) {
        return this.menusRepository.findByQr(qr);
    }

    //create
    @CrossOrigin(origins ="http://localhost:3000")
    @PostMapping
    public Menus createMenus(@RequestBody Menus menus) {
        return this.menusRepository.save(menus);
    }

    //update plat
    @CrossOrigin(origins ="http://localhost:3000")
    @PutMapping("/{id}")
    public Menus updatePlat(@RequestBody Menus plat, @PathVariable("id") long platId){
        Menus existingPlat=  this.menusRepository.findById(platId)
                .orElseThrow(()->new RessourceNotFoundException("Plat non trouvÃ© avec id:" + platId));
        existingPlat.setNomrepas(plat.getNomrepas());
        existingPlat.setDescription(plat.getDescription());
        existingPlat.setCategorie(plat.getCategorie());
        existingPlat.setPrix(plat.getPrix());
        existingPlat.setImage(plat.getImage());
        existingPlat.setQr(plat.getQr());
        return this.menusRepository.save(existingPlat);

    }

    //delete plat by id
    @CrossOrigin(origins ="http://localhost:3000")
    @DeleteMapping("/{id}")
    public ResponseEntity<Menus> deletePlat(@PathVariable("id") long platId){
        Menus existingPlat =  this.menusRepository.findById(platId)
                .orElseThrow(()->new RessourceNotFoundException("Plat non trouvÃ© avec id:" + platId));
        this.menusRepository.delete(existingPlat);
        return ResponseEntity.ok().build();

    }

}
