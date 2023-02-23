package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import beans.Offre;
import ejb.AllOffresEJB;

/**
 * Servlet implementation class AllOffres
 */
@WebServlet("/AllOffres")
public class AllOffres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AllOffres() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGetVersion2(request, response);
	}

	protected void doGetVersion2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		AllOffresEJB arrayOffre = new AllOffresEJB();

		JSONArray list = null;
		JSONObject obj = null;
		JSONObject json = null;
		PrintWriter out = null;

		HttpSession session = request.getSession();

		try {

			String email = (String) session.getAttribute("email");
			ArrayList<Offre> offres = arrayOffre.allOffres(email);
			System.out.println("EMAIL: " + email);

			json = new JSONObject();
			list = new JSONArray();

			if (!offres.isEmpty()) {
				
				for (int i = 0; i < offres.size(); i++) {

					obj = new JSONObject();

					obj.put("idOffre", offres.get(i).getId());
					obj.put("price", offres.get(i).getPrice());
					obj.put("typeBien", offres.get(i).getTypeBien());
					obj.put("typeOffre", offres.get(i).getTypeOffre());
					obj.put("description", offres.get(i).getDescription());
					obj.put("adresse", offres.get(i).getAddress());
					obj.put("etage", offres.get(i).getEtage());
					obj.put("surfaceMaison", offres.get(i).getSurfaceMaison());
					obj.put("surfaceTerrain", offres.get(i).getSurfaceTerrain());
					obj.put("parking", offres.get(i).getPresenceParking());
					obj.put("piece", offres.get(i).getNombrePieces());
					obj.put("photo", offres.get(i).getPhoto());
					obj.put("etat", offres.get(i).getEtat());

					list.add(obj);	
				}

				json.put("jsonArray", list);

				out = response.getWriter();
				out.print(json.toString());

				out.close();

				System.out.println(json.toString());

				session.setAttribute("offre", offres);

			}

			response.getWriter().append("\nConnexion   la DB ok le ").append(new Date().toLocaleString());
		} catch (

		Exception e2) {
			response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
			System.out.println(e2.getMessage().toString());
		}
	}

}
