package com.mosef.formulaires;

public class AdminForm {
	private int id;
	private String name;
	private String lastname;
	private String tel;
	private String email;
	private String pass;
	private String radio;
	
	public void AllDatatExtras(javax.servlet.http.HttpServletRequest request) {
		this.id = Integer.valueOf(request.getParameter("id"));
		this.name = request.getParameter("name");
		this.lastname = request.getParameter("lastname");
		this.tel = request.getParameter("tel");
		this.email = request.getParameter("mail");
		this.pass = request.getParameter("pass");
		this.radio = request.getParameter("radio");
		
		if("save".equals(radio)) {
			this.radio = "save";
		}else if("update".equals(radio)) {
			this.radio = "update";
		}else if("delete".equals(radio)) {
			this.radio = "delete";
		}else if("more".equals(radio)) {
			this.radio = "more";
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}
	
	
}
