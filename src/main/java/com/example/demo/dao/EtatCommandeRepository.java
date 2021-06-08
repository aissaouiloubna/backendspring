package com.example.demo.dao;


import com.example.demo.model.EtatCommandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.List;
@Repository
public interface EtatCommandeRepository extends JpaRepository<EtatCommandes, Long> {
    @org.springframework.data.jpa.repository.Query("select u from EtatCommandes u where u.qr = ?1 ORDER BY u.date")
    List<EtatCommandes> findByQr(long qr );
}
