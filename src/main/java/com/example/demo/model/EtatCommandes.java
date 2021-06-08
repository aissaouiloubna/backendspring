package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
@Table(name = "etatcommandes")
public class EtatCommandes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "qr")
    private long qr;
    
    @JsonFormat (pattern="yyyy-MM-dd" , shape = Shape.STRING)
    @Column(name = "date")
    private String date;

 

    @Column(name = "total")
    private long total;

    public EtatCommandes( long qr, String date, long total) {
        super();
        this.qr = qr;
        this.date = date;

        this.total = total;
    }

    public EtatCommandes(){

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
