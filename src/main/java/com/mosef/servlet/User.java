package com.mosef.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mosef.beans.Service;
import com.mosef.dao.UserDaoImplementation;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession(); 
		String nom = (String) session.getAttribute("nom");
		UserDaoImplementation dao = new UserDaoImplementation();
		
	
			int id =  (int) session.getAttribute("id");
			List<Service> services = new ArrayList<Service>();
			services = dao.findServiceByIdfournisseur(id);
			request.setAttribute("services", services);
			request.setAttribute("nom", nom);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int productId = Integer.parseInt(request.getParameter("productId"));
		 
		 UserDaoImplementation dao = new UserDaoImplementation();   
		 dao.deleteService(productId);		    
		 response.sendRedirect("/Projet/User"); 
	}

}
