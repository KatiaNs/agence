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
            
            
            java.sql.PreparedStatement stDisplayOffre = connection.prepareStatement("SELECT * FROM offres WHERE id = " + idOffre + ";");
            

            ResultSet rsSelect = stDisplayOffre.executeQuery();

			Integer id = 0;
			String title = "";
			Double price = 0.0;
	

			json = new JSONObject();
			list = new JSONArray();
			
			//display correct offre
			while(rsSelect.next()) {
				offre = new Offre();
				obj = new JSONObject();

				arrayOffre = new ArrayList<Offre>();

				id = rsSelect.getInt("id");
				title = rsSelect.getString("titre");
				price = rsSelect.getDouble("prix");
				

				offre.setTitle(title);
				offre.setPrice(price);
				
				
				obj.put("idOffre", id);
				obj.put("title", title);
				obj.put("price", price);
				

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
