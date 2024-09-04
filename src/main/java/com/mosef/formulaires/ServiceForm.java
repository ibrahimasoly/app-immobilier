package com.mosef.formulaires;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;


public class ServiceForm {
	  private String region;
	  private String localisation;
	  private Double prix;
	  private String categorie;
	  private String test;
	  
	  public void ServiceData(javax.servlet.http.HttpServletRequest request) throws IOException, ServletException {
		  this.region = request.getParameter("region");
		  this.localisation = request.getParameter("local");
		  this.prix = Double.valueOf(request.getParameter("prix"));
		  this.categorie = request.getParameter("cat");
		  
		  
		  if(!region.isEmpty()&& !localisation.isEmpty() && !categorie.isEmpty()) {
			  this.test = "true";
		  }else {
			  this.test = "false";
		  }
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

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	 
	
	  
}
