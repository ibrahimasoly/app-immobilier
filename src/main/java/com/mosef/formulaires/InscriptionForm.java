package com.mosef.formulaires;

import com.mosef.beans.User;
import com.mosef.dao.UserDaoImplementation;

import jakarta.servlet.http.HttpServletRequest;

public class InscriptionForm {
	private String name;
	private String lastname;
	private String tel;
	private String email;
	private String pass;
	
	public void findExtrasData(javax.servlet.http.HttpServletRequest request) {
		this.name = request.getParameter("name");
		this.lastname = request.getParameter("lastname");
		this.tel = request.getParameter("tel");
		this.email = request.getParameter("mail");
		this.pass = request.getParameter("pass");
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
