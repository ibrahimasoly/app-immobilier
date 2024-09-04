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

import com.mosef.dao.UserDaoImplementation;
import com.mosef.beans.Service;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (HttpSession) request.getSession(); 
		String valeur1 = (String) session.getAttribute("local");
        String valeur2 = (String) session.getAttribute("type");
        String valeur3 = (String) session.getAttribute("val");
        //double prix = Double.valueOf(valeur3);
        
        UserDaoImplementation dao = new UserDaoImplementation();
		List<Service> services = new ArrayList<Service>();
		services = dao.findService();
		
		request.setAttribute("local", valeur1);
		request.setAttribute("type", valeur2);
		request.setAttribute("services", services);
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);
	}

}
