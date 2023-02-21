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


@WebServlet("/HomeOffres")
public class HomeOffres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HomeOffres() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetVersion2(request, response);
	}

		

	protected void doGetVersion2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Offre offre = null;

		JSONArray list = null;
		JSONObject obj = null;
		JSONObject json = null;
		PrintWriter out = null;

		HttpSession session = request.getSession();
		ArrayList<Offre> arrayOffre = null;
		
		

		try {
			
			InitialContext initialContext = new InitialContext();
            javax.sql.DataSource dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/MaDSBanqueTest");
            
            Connection connection = dataSource.getConnection();
            Connection connection2 = dataSource.getConnection();
            
           String email = "katia.nseir@gmail.com";
           // String email = "john.doe@gmail.com";
           // String email = (String) session.getAttribute("email");
            System.out.println("EMAIL: " + email);
            String role = "";
            
            java.sql.PreparedStatement stGetUserRole = connection.prepareStatement("SELECT user.idRole, role.role FROM user JOIN role ON user.idRole = role.id WHERE user.email = '" + email + "';");
                  
            
            ResultSet rsSelectRole = stGetUserRole.executeQuery();


			json = new JSONObject();
			list = new JSONArray();
			
			while(rsSelectRole.next()) {
				role = rsSelectRole.getString("role");
            	System.out.println("Role in while: " + role);
            	
            	if(role.equals("client")) {
            		System.out.println("in if");
            		java.sql.PreparedStatement stGetClient = connection2.prepareStatement("SELECT * FROM offres JOIN etat ON "
            				+ "offres.idEtat = etat.id WHERE offres.idEtat = 1 OR offres.idEtat = 2");
            		
            		ResultSet rsSelect = stGetClient.executeQuery();
            		
            		
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
    				
    				json.put("jsonArray", list);
    				
    				out = response.getWriter();
    				out.print(json.toString());
    				
    				out.close();
    				
    				System.out.println(json.toString());

    				session.setAttribute("offre", offre);
            		
            	}
            	
            	else if(role.equals("agent") || role.equals("admin")) {
            		java.sql.PreparedStatement stGetAgentAdmin = connection2.prepareStatement("SELECT * FROM offres JOIN etat ON offres.idEtat = etat.id");
            		
            		ResultSet rsSelect = stGetAgentAdmin.executeQuery();
            		
            		offre = new Offre();
    				obj = new JSONObject();

    				arrayOffre = new ArrayList<Offre>();
    				
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
    				
    				json.put("jsonArray", list);
    				
    				out = response.getWriter();
    				out.print(json.toString());
    				
    				out.close();
    				
    				System.out.println(json.toString());

    				session.setAttribute("offre", offre);
            	}
            	
            	else {
            		java.sql.PreparedStatement stGetVisiteur = connection2.prepareStatement("SELECT * FROM offres JOIN etat ON "
            				+ "offres.idEtat = etat.id WHERE offres.idEtat = 1 OR offres.idEtat = 2");
            		
            		ResultSet rsSelect = stGetVisiteur.executeQuery();
            		
            		offre = new Offre();
    				obj = new JSONObject();

    				arrayOffre = new ArrayList<Offre>();

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
    				
    				json.put("jsonArray", list);
    				
    				out = response.getWriter();
    				out.print(json.toString());
    				
    				out.close();
    				
    				System.out.println(json.toString());

    				session.setAttribute("offre", offre);
            	}
			}
			
			

			connection.close();
			connection2.close();
			 response.getWriter().append("\nConnexion   la DB ok le ").append(new Date().toLocaleString());
        } catch (Exception e2) {
        	response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
            System.out.println(e2.getMessage().toString());
        }
	}


}
