package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Commandes")

public class Commandes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="idcommande")
	private long idcommande;
	
	@Column(name="plat")
	private String plat;
	
	@Column(name="quantite")
	private int quantite;
	
	@Column(name="categorie")
	private String categorie;
	
	@Column(name="place")
	private String place;
	
	@Column(name="qr")
	private long qr;
	
	@Column(name = "prix")
	private float prix;
	
	@Column(name = "pret")
	private  int pret;

	public Commandes(){
		   super();
		}

	public Commandes(String plat,long idcommande, int quantite, String categorie, float prix,String place,int pret, long qr) {
		super();
		this.idcommande = idcommande;
		this.plat = plat;
		this.quantite = quantite;
		this.categorie = categorie;
		this.place = place;
		this.qr = qr;
		this.pret = pret;
		this.prix = prix;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public long getIdcommande() {
		return idcommande;
	}

	public void setIdcommande(long idcommande) {
		this.idcommande = idcommande;
	}



	public String getPlat() {
		return plat;
	}
	public void setPlat(String plat) {
		this.plat = plat;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public long getQr() {
		return qr;
	}
	public void setQr(long qr) {
		this.qr = qr;
	}
	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
}
