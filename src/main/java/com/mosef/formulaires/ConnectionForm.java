package com.mosef.formulaires;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.mosef.beans.Login;
import com.mosef.beans.User;
import com.mosef.dao.UserDaoImplementation;

public class ConnectionForm {
 private String login;
 private String pass;
 
 public void checkLogin(javax.servlet.http.HttpServletRequest request) throws ServletException, IOException {
	 this.login = request.getParameter("login");
	 this.pass =request.getParameter("pass");
	 
 }

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}
 
 
 
}
