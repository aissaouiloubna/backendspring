package com.example.demo.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Commandes;


@Repository
public interface CommandesRepository extends JpaRepository<Commandes, Long> {
    @org.springframework.data.jpa.repository.Query("select u from Commandes u where u.qr = ?1 and u.pret= 0")
    List<Commandes> findByQr(long qr);
    
    @org.springframework.data.jpa.repository.Query("select u from Commandes u where u.qr = ?1 and u.idcommande= ?2")
    List<Commandes> showAll(long qr,long idcommande);
    
    @org.springframework.data.jpa.repository.Query("select u.pret from Commandes u where u.qr = ?1 and u.idcommande= ?2 ")
   int findEtat(long qr,long idcommande);
    
    @Transactional
    @Modifying
    @Query("update Commandes u set u.pret = 1 where u.idcommande =:idcommande")
    void changerEtat(long idcommande);
}