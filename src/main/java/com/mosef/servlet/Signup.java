package com.mosef.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mosef.beans.Login;
import com.mosef.beans.User;
import com.mosef.dao.UserDaoImplementation;
import com.mosef.formulaires.ConnectionForm;


/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession();
		String name= (String) session.getAttribute("nom");
		if(name !=null) {
			response.sendRedirect("/Projet/User"); 
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionForm form = new ConnectionForm();
		form.checkLogin(request);
		
		 Login login = new Login();
		 login.setLogin(form.getLogin());
		 login.setPass(form.getPass());
		 
		 UserDaoImplementation dao = new UserDaoImplementation();
		 User user = dao.findLogin(login);
		 
		 if(user != null) {
			 if(user.getName().equalsIgnoreCase("admin") && user.getPass().equalsIgnoreCase("admin987")) {
				 response.sendRedirect("/Projet/admin");
			 }
			 else {
				 HttpSession session = (HttpSession) request.getSession();
				 session.setAttribute("id", user.getId());
				 session.setAttribute("nom", user.getName());
				 response.sendRedirect("/Projet/User"); 
			 }
			 
		 }else {
			 request.setAttribute("reponse", "Bad login class");
			 this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
		 }
	}

}
