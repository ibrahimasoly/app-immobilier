package com.mosef.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mosef.beans.Describ;
import com.mosef.beans.Image;
import com.mosef.beans.Service;
import com.mosef.dao.UserDaoImplementation;

/**
 * Servlet implementation class Decouvre
 */
@WebServlet("/Decouvre")
public class Decouvre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Decouvre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idParam = Integer.parseInt(request.getParameter("id"));
		UserDaoImplementation dao = new UserDaoImplementation();
		List<Image> images = new ArrayList<Image>();
		images = dao.findImageByIdService(idParam);
		request.setAttribute("images", images);
		
		Describ describ = new Describ();
		describ = dao.findDescribByIdService(idParam);
		request.setAttribute("describ", describ);
		List<Service> services = new ArrayList<Service>();
		Service service = new Service();
		services = dao.findServiceById(idParam);
		request.setAttribute("service", services.get(services.size()-1));
		System.out.println("La région est :" +service.getImage());
		this.getServletContext().getRequestDispatcher("/WEB-INF/decouvre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
