package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import beans.Offre;


@WebServlet("/CreationOffre")
public class CreationOffre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreationOffre() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPostVersion2(request, response);
	}
	
protected void doPostVersion2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	JSONArray list = null;
	JSONObject obj = null;
	//JSONObject json = null;
	PrintWriter out = null;

	HttpSession session = request.getSession();
	
	String typeOffre = request.getParameter("offre");
	String typeBien = request.getParameter("bien");
	String parking = request.getParameter("parking");
	Double prix = Double.parseDouble(request.getParameter("prix"));
	String adresse = request.getParameter("adresse");
	Integer etage = Integer.parseInt(request.getParameter("etage"));
	Double surfaceBien = Double.parseDouble(request.getParameter("surfaceBien"));
	Double surfaceTerrain = Double.parseDouble(request.getParameter("surfaceTerrain"));
	Integer nombrePiece = Integer.parseInt(request.getParameter("nombrePiece"));
	String description = request.getParameter("description");
	String photo = request.getParameter("photo");
	
	String email = "katia.nseir@gmail.co";
	Integer idEtat = 1;
	
	 try {
		 
		 
		 InitialContext initialContext = new InitialContext();
            javax.sql.DataSource dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/MaDSBanqueTest");
            
            Connection connection = dataSource.getConnection();
           // Connection connection2 = dataSource.getConnection();
            
            String photoUrl = "../images/" + photo;
            
            java.sql.PreparedStatement stInsertOffre = connection.prepareStatement("INSERT INTO offres (prix, idEtat, mail, "
					+ "typeBien, typeOffre, description, addresse, etage, surfaceMaison, surfaceTerrain, presenceParking, nombrePieces, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            System.out.println("test after query");
			
            stInsertOffre.setDouble(1, prix);
            
            System.out.println(prix);
            
            stInsertOffre.setInt(2, idEtat);
            
            System.out.println(idEtat);
            
            stInsertOffre.setString(3, email);
            stInsertOffre.setString(4, typeBien);
            stInsertOffre.setString(5, typeOffre);
            stInsertOffre.setString(6, description);
            stInsertOffre.setString(7, adresse);
            stInsertOffre.setInt(8, etage);
            stInsertOffre.setDouble(9, surfaceBien);
            stInsertOffre.setDouble(10, surfaceTerrain);
            stInsertOffre.setString(11, parking);
            stInsertOffre.setInt(12, nombrePiece);
            stInsertOffre.setString(13, photoUrl);
            
            System.out.println("what is hapeening??");
            

		//	obj.put("email", email);

			//list.add(obj);
		//	out.println(list.toJSONString());
		//	out.flush();

			session.setAttribute("email", email);
			session.setAttribute("photo", photo);
			
			System.out.println("before execute");
			
			int rsInsert = stInsertOffre.executeUpdate();
			
			System.out.println("Inserted");
			stInsertOffre.close();
			response.sendRedirect("jsp/homeInscrit.jsp");
			
			//rsSelect.close();
		 
		 
	 } catch (Exception e2) {
        	response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
            System.out.println(e2.getMessage().toString());
	 }
	}

}
