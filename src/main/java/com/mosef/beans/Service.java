package com.mosef.beans;

public class Service {
  private int id;
  private String region;
  private String localisation;
  private Double prix;
  private String categorie;
  private int id_f;
  private byte[] image;
  
  
  public Service() {
	  
  }
  
  public Service( String region, String localisation, Double prix, String categorie, int id_f) {
		this.region = region;
		this.localisation = localisation;
		this.prix = prix;
		this.categorie = categorie;
		this.id_f =  id_f;
	} 
  
public Service(int id, String region, String localisation, Double prix, String categorie, byte[] image) {
	this.id = id;
	this.region = region;
	this.localisation = localisation;
	this.prix = prix;
	this.categorie = categorie;
	this.image = image;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRegion() {
	return region;
}
public void setRegion(String region) {
	this.region = region;
}
public String getLocalisation() {
	return localisation;
}
public void setLocalisation(String localisation) {
	this.localisation = localisation;
}
public Double getPrix() {
	return prix;
}
public void setPrix(Double prix) {
	this.prix = prix;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}

public int getId_f() {
	return id_f;
}

public void setId_f(int id_f) {
	this.id_f = id_f;
}

public byte[] getImage() {
	return image;
}

public void setImage(byte[] image) {
	this.image = image;
}


  
}
