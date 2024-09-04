package com.mosef.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mosef.beans.User;
import com.mosef.dao.UserDaoImplementation;
import com.mosef.formulaires.AdminForm;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDaoImplementation dao = new UserDaoImplementation();
		List<User> users = new ArrayList<User>();
		users = dao.findUsers();
		request.setAttribute("users", users);
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = new ArrayList<User>();
		AdminForm form = new AdminForm();
		form.AllDatatExtras(request);
		UserDaoImplementation dao = new UserDaoImplementation();
		User user = new User(form.getName(),form.getLastname(),form.getTel(),form.getEmail(),form.getPass());
		System.out.println(form.getRadio());
		
		
		
		if(form.getRadio().equals("save")) {
			dao.saveUser(user);
			users = dao.findUsers();
			request.setAttribute("users", users);
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
		}else if(form.getRadio().equals("delete")) {
			dao.deleteUser(form.getId());
			dao.deleteService(form.getId());
			users = dao.findUsers();
			request.setAttribute("users", users);
			this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
		}
		
		
		
	}

}
