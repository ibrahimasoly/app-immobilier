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
import com.mosef.formulaires.DescribForm;

/**
 * Servlet implementation class Describ
 */
@WebServlet("/describ")
public class Describ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Describ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/describ.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DescribForm form = new DescribForm();
		form.DescribData(request);
        UserDaoImplementation dao = new UserDaoImplementation();
		
        List<Service> services = new ArrayList<Service>();
		services = dao.findService();
		int rst = services.get(0).getId();
		
		com.mosef.beans.Describ desc = new com.mosef.beans.Describ(rst, form.getSurface(), form.getChambre(),
				form.getSalon(), form.getDouche(), form.getCuisine(), form.getEtage(), form.getDescrib());
		
		dao.saveDescrib(rst, desc);
		response.sendRedirect("/Projet/Acceuil");
	}

}
