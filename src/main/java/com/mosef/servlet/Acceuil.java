package com.mosef.servlet;

import java.io.IOException;
import java.net.URLEncoder;
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
 * Servlet implementation class Acceuil
 */
@WebServlet("/Acceuil")
public class Acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acceuil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDaoImplementation dao = new UserDaoImplementation();
		List<Service> services = new ArrayList<Service>();
		services = dao.findService();
		request.setAttribute("services", services);
		this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String local = request.getParameter("lieu");
		String type = request.getParameter("type");
		HttpSession session = (HttpSession) request.getSession(); 
		
		UserDaoImplementation dao = new UserDaoImplementation();
		List<Service> services = new ArrayList<Service>();
		services = dao.findService();
		
		if(!local.isEmpty() && !type.isEmpty()) {
			session.setAttribute("local", local);
			session.setAttribute("type", type);
			session.setAttribute("val", request.getParameter("budget"));
			response.sendRedirect("/Projet/Search");

		}else {
			request.setAttribute("services", services);
			this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
		}
		
	
		        
 
	
       
		
		/*UserDaoImplementation dao = new UserDaoImplementation();
		List<Service> services = new ArrayList<Service>();
		List<Service> service = new ArrayList<Service>();
		services = dao.findService();
		
		if(local!=null && type != null && prix > 0) {
			for(int i=0; i<services.size(); i++) {
				if(services.get(i).getLocalisation().equalsIgnoreCase(local) && services.get(i).getCategorie().equalsIgnoreCase(type) && 
						services.get(i).getPrix() < prix) {
				 service.add(new Service(services.get(i).getId(),services.get(i).))
				}
			}
		}*/
		
	}

}
