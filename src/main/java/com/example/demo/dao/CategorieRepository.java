package com.example.demo.dao;

import com.example.demo.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    @org.springframework.data.jpa.repository.Query("select u from Categorie u where u.qr = ?1")
    List<Categorie> findByQr(long qr);
}
