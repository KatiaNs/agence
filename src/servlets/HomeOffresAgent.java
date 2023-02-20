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


@WebServlet("/HomeOffresAgent")
public class HomeOffresAgent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HomeOffresAgent() {
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
            
            //String email = "katia.nseir@gmail.co";
            String email = "john.doe@gmail.com";
            String role = "";
            
            java.sql.PreparedStatement stGetUserRole = connection.prepareStatement("SELECT user.idRole, role.role FROM user JOIN role ON user.idRole = role.id WHERE user.email = '" + email + "';");
            
            
            //java.sql.PreparedStatement stGetOffre = connection.prepareStatement("SELECT * FROM offres");
            
            
            ResultSet rsSelectRole = stGetUserRole.executeQuery();

           // ResultSet rsSelect = stGetOffre.executeQuery();
            
            

		//	Integer id = 0;
			//String title = "";
			//Double price = 0.0;
	

			json = new JSONObject();
			list = new JSONArray();
			
			while(rsSelectRole.next()) {
				role = rsSelectRole.getString("role");
            	System.out.println("Role in while: " + role);
            	
            	if(role.equals("client")) {
            		System.out.println("in if");
            		java.sql.PreparedStatement stGetClient = connection2.prepareStatement("SELECT * FROM offres WHERE idEtat = 1 OR idEtat = 2");
            		
            		ResultSet rsSelect = stGetClient.executeQuery();
            		
            		
    				Integer id = 0;
    				//String title = "";
    				Double price = 0.0;
    				
    				while(rsSelect.next()) {
    					
    				offre = new Offre();
        			obj = new JSONObject();

        			arrayOffre = new ArrayList<Offre>();
    					
    				id = rsSelect.getInt("id");
    				System.out.println("id: " + id);
//    				title = rsSelect.getString("titre");
    				price = rsSelect.getDouble("prix");
    				System.out.println("prix: " + price);
    				

//    				offre.setTitle(title);
    				offre.setPrice(price);
    				
    				
    				obj.put("idOffre", id);
//    				obj.put("title", title);
    				obj.put("price", price);
    				

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
            		java.sql.PreparedStatement stGetAgentAdmin = connection2.prepareStatement("SELECT * FROM offres");
            		
            		ResultSet rsSelect = stGetAgentAdmin.executeQuery();
            		
            		offre = new Offre();
    				obj = new JSONObject();

    				arrayOffre = new ArrayList<Offre>();
    				Integer id = 0;
    				//String title = "";
    				Double price = 0.0;

    				while(rsSelect.next()) {
    				
    				offre = new Offre();
            		obj = new JSONObject();

            		arrayOffre = new ArrayList<Offre>();
            		
    				id = rsSelect.getInt("id");
//    				title = rsSelect.getString("titre");
    				price = rsSelect.getDouble("prix");
    				

//    				offre.setTitle(title);
    				offre.setPrice(price);
    				
    				
    				obj.put("idOffre", id);
//    				obj.put("title", title);
    				obj.put("price", price);
    				

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
            		java.sql.PreparedStatement stGetVisiteur = connection2.prepareStatement("SELECT * FROM offres WHERE idEtat = 1 OR idEtat = 2");
            		
            		ResultSet rsSelect = stGetVisiteur.executeQuery();
            		
            		offre = new Offre();
    				obj = new JSONObject();

    				arrayOffre = new ArrayList<Offre>();
    				Integer id = 0;
    				//String title = "";
    				Double price = 0.0;
    				
    				while(rsSelect.next()) {

    				offre = new Offre();
            		obj = new JSONObject();

            		arrayOffre = new ArrayList<Offre>();
            		
    				id = rsSelect.getInt("id");
//    				title = rsSelect.getString("titre");
    				price = rsSelect.getDouble("prix");
    				

//    				offre.setTitle(title);
    				offre.setPrice(price);
    				
    				
    				obj.put("idOffre", id);
//    				obj.put("title", title);
    				obj.put("price", price);
    				

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
			
			
			
			
			//display all offres
			/*
			 * while(rsSelect.next()) { offre = new Offre(); obj = new JSONObject();
			 * 
			 * arrayOffre = new ArrayList<Offre>();
			 * 
			 * id = rsSelect.getInt("id"); // title = rsSelect.getString("titre"); price =
			 * rsSelect.getDouble("prix");
			 * 
			 * 
			 * // offre.setTitle(title); offre.setPrice(price);
			 * 
			 * 
			 * obj.put("idOffre", id); // obj.put("title", title); obj.put("price", price);
			 * 
			 * 
			 * arrayOffre.add(offre);
			 * 
			 * list.add(obj);
			 * 
			 * }
			 */
			
			///json.put("jsonArray", list);
		
			/*
			 * out = response.getWriter(); out.print(json.toString());
			 * 
			 * out.close();
			 * 
			 * System.out.println(json.toString());
			 * 
			 * session.setAttribute("offre", offre);
			 */

			//stGetOffre.close();
			//rsSelect.close();

			connection.close();
			connection2.close();
			 response.getWriter().append("\nConnexion   la DB ok le ").append(new Date().toLocaleString());
        } catch (Exception e2) {
        	response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
            System.out.println(e2.getMessage().toString());
        }
	}


}
