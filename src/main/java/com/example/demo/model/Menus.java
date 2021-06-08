package com.example.demo.model;


import javax.persistence.*;



@Entity
@Table(name = "menus")
public class Menus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "categorie")
	private String categorie;

	@Column(name = "nomrepas")
	private String nomrepas;

	@Column(name = "description")
	private String description;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "prix")
	private float prix;
	
	@Column(name = "qr")
	private long qr;
	
	
	public Menus() {
		
	}

	public Menus(String categorie, String nomrepas, String description, String image, float prix , long qr) {
		super();
		this.categorie = categorie;
		this.nomrepas = nomrepas;
		this.description = description;
		this.image = image;
		this.prix = prix;
		this.qr = qr;
	}

	public long getIdrepas() {
		return id;
	}

	public void setIdrepas(long idrepas) {
		this.id = idrepas;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getNomrepas() {
		return nomrepas;
	}

	public void setNomrepas(String nomrepas) {
		this.nomrepas = nomrepas;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public long getQr() {
		return qr;
	}

	public void setQr(long qr) {
		this.qr = qr;
	}
	

}
