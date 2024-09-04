package com.mosef.beans;

public class User {
	private int id;
	private String name;
	private String lastname;
	private String tel;
	private String email;
	private String pass;
	public User() {
		
	}
	public User(String name, String lastname, String tel, String email, String pass) {
		this.name = name;
		this.lastname = lastname;
		this.tel = tel;
		this.email = email;
		this.pass = pass;
	}
	
	
	
	public User(int id, String name, String lastname, String tel, String email, String pass) {

		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.tel = tel;
		this.email = email;
		this.pass = pass;
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
	
	
}
