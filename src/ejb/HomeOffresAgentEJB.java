package ejb;

import javax.ejb.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import beans.Offre;

@Stateless
public class HomeOffresAgentEJB {

	@PersistenceUnit(unitName = "webProject")
	private EntityManagerFactory emf;

	@PersistenceContext
	private EntityManager entityManager;

	public ArrayList<Offre> offresAgent() {

		try {

			InitialContext initialContext = new InitialContext();
			javax.sql.DataSource dataSource = (DataSource) initialContext
					.lookup("java:jboss/datasources/MaDSBanqueTest");

			Connection connection = dataSource.getConnection();
			Connection connection2 = dataSource.getConnection();

			String email = "john.doe@gmail.com";
			String role = "";

			java.sql.PreparedStatement stGetUserRole = connection.prepareStatement(
					"SELECT user.idRole, role.role FROM user JOIN role ON user.idRole = role.id WHERE user.email = '"
							+ email + "';");

			ResultSet rsSelectRole = stGetUserRole.executeQuery();

			while (rsSelectRole.next()) {
				role = rsSelectRole.getString("role");
				System.out.println("Role in while: " + role);

				if (role.equals("client")) {
					System.out.println("in if");
					java.sql.PreparedStatement stGetClient = connection2
							.prepareStatement("SELECT * FROM offres WHERE idEtat = 1 OR idEtat = 2");

					ResultSet rsSelect = stGetClient.executeQuery();

					Integer id = 0;
					Double price = 0.0;

					while (rsSelect.next()) {

						id = rsSelect.getInt("id");
						System.out.println("id: " + id);
						price = rsSelect.getDouble("prix");
						System.out.println("prix: " + price);
					}

				}

				else if (role.equals("agent") || role.equals("admin")) {
					java.sql.PreparedStatement stGetAgentAdmin = connection2.prepareStatement("SELECT * FROM offres");

					ResultSet rsSelect = stGetAgentAdmin.executeQuery();

					offre = new Offre();
					obj = new JSONObject();

					arrayOffre = new ArrayList<Offre>();
					Integer id = 0;
					// String title = "";
					Double price = 0.0;

					while (rsSelect.next()) {

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
					java.sql.PreparedStatement stGetVisiteur = connection2
							.prepareStatement("SELECT * FROM offres WHERE idEtat = 1 OR idEtat = 2");

					ResultSet rsSelect = stGetVisiteur.executeQuery();

					offre = new Offre();
					obj = new JSONObject();

					arrayOffre = new ArrayList<Offre>();
					Integer id = 0;
					// String title = "";
					Double price = 0.0;

					while (rsSelect.next()) {

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

			connection.close();
			connection2.close();
			response.getWriter().append("\nConnexion   la DB ok le ").append(new Date().toLocaleString());
		} catch (Exception e2) {
			response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
			System.out.println(e2.getMessage().toString());
		}
	}

}
