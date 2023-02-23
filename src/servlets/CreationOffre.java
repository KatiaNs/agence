package servlets;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.Offre;
import ejb.CreationOffreEJB;

@WebServlet("/CreationOffre")
public class CreationOffre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	CreationOffreEJB creation = new CreationOffreEJB();
	
	public CreationOffre() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPostVersion2(request, response);
	}

	protected void doPostVersion2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Offre offre = new Offre();
		String email = "katia.nseir@gmail.co";

		HttpSession session = request.getSession();

		offre.setTypeOffre(request.getParameter("offre"));
		offre.setTypeBien(request.getParameter("bien"));
		offre.setPresenceParking(request.getParameter("parking"));
		offre.setPrice(Double.parseDouble(request.getParameter("prix")));
		offre.setAddress(request.getParameter("adresse"));
		offre.setEtage(Integer.parseInt(request.getParameter("etage")));
		offre.setSurfaceTerrain(Double.parseDouble(request.getParameter("surfaceTerrain")));
		offre.setSurfaceMaison(Double.parseDouble(request.getParameter("surfaceBien")));
		offre.setNombrePieces(Integer.parseInt(request.getParameter("nombrePiece")));
		offre.setDescription(request.getParameter("description"));
		offre.setPhoto(request.getParameter("photo"));

		try {
			
			String photo = creation.createOffre(offre);
			session.setAttribute("email", email);
			session.setAttribute("photo", photo);
			response.sendRedirect("jsp/homeInscrit.jsp");
			
		} catch (Exception e) {
        	response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
		}

	}

}
