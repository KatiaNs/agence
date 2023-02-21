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

@WebServlet("/OffreDetails")
public class OffreDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OffreDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetVersion2(request, response);
		
	}

	
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub doGet(request, response); }
	 */

	
	protected void doGetVersion2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Offre offre = null;

		JSONArray list = null;
		JSONObject obj = null;
		JSONObject json = null;
		PrintWriter out = null;

		HttpSession session = request.getSession();
		
		String idOffre = (String) session.getAttribute("idOffre");
		ArrayList<Offre> arrayOffre = null;
		
		

		try {
			
			InitialContext initialContext = new InitialContext();
            javax.sql.DataSource dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/MaDSBanqueTest");
            
            Connection connection = dataSource.getConnection();
            
            
            java.sql.PreparedStatement stDisplayOffre = connection.prepareStatement("SELECT * FROM offres JOIN etat ON offres.idEtat = etat.id WHERE offres.id = " + idOffre + ";");
            

            ResultSet rsSelect = stDisplayOffre.executeQuery();

            Integer id = 0;
			Double price = 0.0;
			String typeBien = "";
			String typeOffre = "";
			String description = "";
			String adresse = "";
			Integer etage = 0;
			Double surfaceMaison = 0.0;
			Double surfaceTerrain = 0.0;
			String parking = "";
			Integer piece = 0;
			String photo = "";
			String etat = "";

			json = new JSONObject();
			list = new JSONArray();
			
			//display correct offre
			while(rsSelect.next()) {
				offre = new Offre();
				obj = new JSONObject();

				arrayOffre = new ArrayList<Offre>();

				id = rsSelect.getInt("id");
				System.out.println("id: " + id);
				price = rsSelect.getDouble("prix");
				System.out.println("prix: " + price);
				System.out.println("photo" + photo);
				typeBien = rsSelect.getString("typeBien");
				typeOffre = rsSelect.getString("typeOffre");
				description = rsSelect.getString("description");
				adresse = rsSelect.getString("addresse");
				etage = rsSelect.getInt("etage");
				surfaceMaison = rsSelect.getDouble("surfaceMaison");
				surfaceTerrain = rsSelect.getDouble("surfaceTerrain");
				parking = rsSelect.getString("presenceParking");
				piece = rsSelect.getInt("nombrePieces");
				photo = rsSelect.getString("photo");
				etat = rsSelect.getString("etat");
				System.out.println("ETAT:" + etat);
				

				offre.setPrice(price);
				offre.setTypeBien(typeBien);
				offre.setTypeOffre(typeOffre);
				offre.setDescription(description);
				offre.setAddress(adresse);
				offre.setEtage(etage);
				offre.setSurfaceMaison(surfaceMaison);
				offre.setSurfaceTerrain(surfaceTerrain);
				offre.setPresenceParking(parking);
				offre.setNombrePieces(piece);
				offre.setPhoto(photo);
				offre.setEtat(etat);
				
				
				obj.put("idOffre", id);
				obj.put("price", price);
				obj.put("typeBien", typeBien);
				obj.put("typeOffre", typeOffre);
				obj.put("description", description);
				obj.put("adresse", adresse);
				obj.put("etage", etage);
				obj.put("surfaceMaison", surfaceMaison);
				obj.put("surfaceTerrain", surfaceTerrain);
				obj.put("parking", parking);
				obj.put("piece", piece);
				obj.put("photo", photo);
				obj.put("etat", etat);
				
				

				arrayOffre.add(offre);

				list.add(obj);

			}
			
			json.put("jsonArrayDetails", list);
		
			out = response.getWriter();
			out.print(json.toString());
			
			out.close();
			
			System.out.println(json.toString());

			session.setAttribute("offre", offre);

			stDisplayOffre.close();
			rsSelect.close();

			connection.close();
			 response.getWriter().append("\nConnexion   la DB ok le ").append(new Date().toLocaleString());
        } catch (Exception e2) {
        	response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
            System.out.println(e2.getMessage().toString());
        }
	}

}
