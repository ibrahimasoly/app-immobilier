package com.mosef.formulaires;

public class DescribForm {
	  private String surface;
	  private int chambre;
	  private int salon;
	  private int douche;
	  private int cuisine;
	  private int etage;
	  private String describ;
	  
	  public void DescribData(javax.servlet.http.HttpServletRequest request) {
		  this.surface = request.getParameter("surface");
		  this.chambre = Integer.valueOf(request.getParameter("chambre"));
		  this.salon = Integer.valueOf(request.getParameter("salon"));
		  this.douche = Integer.valueOf(request.getParameter("douche"));
		  this.cuisine = Integer.valueOf(request.getParameter("cuisine"));
		  this.etage = Integer.valueOf(request.getParameter("etage"));
		  this.describ = request.getParameter("describ");
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
