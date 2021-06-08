package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="Categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "qr")
    private long qr;

    @Column(name="categorie")
    private String categorie;



    public Categorie( String categorie, long qr) {
        this.qr= qr;
        this.categorie = categorie;

    }

    public Categorie(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getQr() {
        return qr;
    }

    public void setQr(long qr) {
        this.qr = qr;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}


