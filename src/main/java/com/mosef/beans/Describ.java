package com.mosef.beans;

public class Describ {
  private int serviceId;
  private String surface;
  private int chambre;
  private int salon;
  private int douche;
  private int cuisine;
  private int etage;
  private String describ;
  
public Describ() {
	  
}
  
public Describ(int serviceId, String surface, int chambre, int salon, int douche, int cuisine, int etage,
		String describ) {
	super();
	this.serviceId = serviceId;
	this.surface = surface;
	this.chambre = chambre;
	this.salon = salon;
	this.douche = douche;
	this.cuisine = cuisine;
	this.etage = etage;
	this.describ = describ;
}
public int getServiceId() {
	return serviceId;
}
public void setServiceId(int serviceId) {
	this.serviceId = serviceId;
}
public String getSurface() {
	return surface;
}
public void setSurface(String surface) {
	this.surface = surface;
}
public int getChambre() {
	return chambre;
}
public void setChambre(int chambre) {
	this.chambre = chambre;
}
public int getSalon() {
	return salon;
}
public void setSalon(int salon) {
	this.salon = salon;
}
public int getDouche() {
	return douche;
}
public void setDouche(int douche) {
	this.douche = douche;
}
public int getCuisine() {
	return cuisine;
}
public void setCuisine(int cuisine) {
	this.cuisine = cuisine;
}
public int getEtage() {
	return etage;
}
public void setEtage(int etage) {
	this.etage = etage;
}
public String getDescrib() {
	return describ;
}
public void setDescrib(String describ) {
	this.describ = describ;
}
  
  
}
