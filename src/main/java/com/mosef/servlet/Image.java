package com.mosef.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mosef.beans.Service;
import com.mosef.dao.UserDaoImplementation;

/**
 * Servlet implementation class Image
 */
@WebServlet("/image")
@MultipartConfig
public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Image() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/image.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part file = (Part) request.getPart("image");
		InputStream input = (InputStream) file.getInputStream();
		UserDaoImplementation dao = new UserDaoImplementation();
		
		List<Service> services = new ArrayList<Service>();
		services = dao.findService();
		int rst = services.get(0).getId();

		dao.saveImage(rst, input);
		this.getServletContext().getRequestDispatcher("/WEB-INF/image.jsp").forward(request, response);
	}

}
