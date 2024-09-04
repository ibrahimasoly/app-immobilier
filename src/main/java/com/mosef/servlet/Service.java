package com.mosef.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mosef.dao.UserDaoImplementation;
import com.mosef.formulaires.ServiceForm;


/**
 * Servlet implementation class Dpa
 */
@WebServlet("/service")
@MultipartConfig
public class Service extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String prediction;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = (HttpSession) request.getSession(); 
		String nom = (String) session.getAttribute("nom");
		
		if(nom != null) {
			int id =  (int) session.getAttribute("id");
			this.getServletContext().getRequestDispatcher("/WEB-INF/service.jsp").forward(request, response);
			System.out.print(id);
		}else {
			response.sendRedirect("/Projet/Signup");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = (Part) request.getPart("image");
		 String apiUrl = "http://127.0.0.1:5000/predict";

	        if (filePart == null) {
	            response.getWriter().println("No file uploaded");
	            prediction = null;
	            return;
	        }

	        // Enregistrer le fichier temporairement sur le serveur
	        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	        File file = new File(System.getProperty("java.io.tmpdir"), fileName);
	        try (InputStream input = filePart.getInputStream();
	             FileOutputStream output = new FileOutputStream(file)) {
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = input.read(buffer)) != -1) {
	                output.write(buffer, 0, bytesRead);
	            }
	        }

	        // Création de la requête HTTP
	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            HttpPost uploadFile = new HttpPost(apiUrl);

	            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	            builder.addPart("file", new FileBody(file, ContentType.APPLICATION_OCTET_STREAM, fileName));
	            
	            HttpEntity multipart = builder.build();
	            uploadFile.setEntity(multipart);

	            // Exécuter la requête et récupérer la réponse
	            try (CloseableHttpResponse httpResponse = httpClient.execute(uploadFile)) {
	                HttpEntity responseEntity = httpResponse.getEntity();
	                if (responseEntity != null) {
	                    String responseString;
						try {
							responseString = EntityUtils.toString(responseEntity);
							System.out.println(responseString);
							 ObjectMapper mapper = new ObjectMapper();
							 JsonParser parser = mapper.getFactory().createParser(responseString);
						     JsonNode jsonNode = mapper.readTree(parser);
					   
						        prediction = jsonNode.get("prediction").asText();
						        System.out.println("Prediction: " + prediction);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                    
	                }
	            }
	        } finally {
	            // Supprimer le fichier temporaire après l'utilisation
	            if (file.exists()) {
	                file.delete();
	            }
	        }
	    
	        InputStream input = (InputStream) filePart.getInputStream();
			ServiceForm form = new ServiceForm();
			form.ServiceData(request);
			
			HttpSession session = (HttpSession) request.getSession(); 
			int id = (int) session.getAttribute("id");
			UserDaoImplementation dao = new UserDaoImplementation();

		if(!prediction.equalsIgnoreCase("autre")) {
			if(form.getTest().equals("true")) {
				com.mosef.beans.Service service = new com.mosef.beans.Service(form.getRegion(),form.getLocalisation(),
						form.getPrix(),form.getCategorie(),id);
				
				 dao.saveService(service,input);
				 response.sendRedirect("/Projet/image");
				 
				}else {
					request.setAttribute("message", "Veuillez remplir tous les champs");
					this.getServletContext().getRequestDispatcher("/WEB-INF/service.jsp").forward(request, response);
				}
		}else {
			request.setAttribute("errorMessage", "Veuillez choisir une image conforme à la plateforme");
            request.setAttribute("successMessage", "error");
            this.getServletContext().getRequestDispatcher("/WEB-INF/service.jsp").forward(request, response);
		}
		
		
		
	}
	
	private byte[] readImageData(String imagePath) throws IOException {
        File file = new File(imagePath);
        byte[] imageData = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(imageData);
        }
        return imageData;
    }

}
